package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Stack;

final class DefaultEbmlReader
  implements EbmlReader
{
  private static final int ELEMENT_STATE_READ_CONTENT = 2;
  private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
  private static final int ELEMENT_STATE_READ_ID = 0;
  private static final int MAX_ID_BYTES = 4;
  private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
  private static final int MAX_LENGTH_BYTES = 8;
  private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
  private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
  private long elementContentSize;
  private int elementId;
  private int elementState;
  private final Stack<DefaultEbmlReader.MasterElement> masterElementsStack = new Stack();
  private EbmlReaderOutput output;
  private final byte[] scratch = new byte[8];
  private final VarintReader varintReader = new VarintReader();
  
  private long maybeResyncToNextLevel1Element(ExtractorInput paramExtractorInput)
  {
    paramExtractorInput.resetPeekPosition();
    for (;;)
    {
      paramExtractorInput.peekFully(this.scratch, 0, 4);
      int i = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
      if ((i != -1) && (i <= 4))
      {
        int j = (int)VarintReader.assembleVarint(this.scratch, i, false);
        if (this.output.isLevel1Element(j))
        {
          paramExtractorInput.skipFully(i);
          return j;
        }
      }
      paramExtractorInput.skipFully(1);
    }
  }
  
  private double readFloat(ExtractorInput paramExtractorInput, int paramInt)
  {
    long l = readInteger(paramExtractorInput, paramInt);
    if (paramInt == 4) {
      return Float.intBitsToFloat((int)l);
    }
    return Double.longBitsToDouble(l);
  }
  
  private long readInteger(ExtractorInput paramExtractorInput, int paramInt)
  {
    byte[] arrayOfByte = this.scratch;
    int i = 0;
    paramExtractorInput.readFully(arrayOfByte, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.scratch[i] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  private String readString(ExtractorInput paramExtractorInput, int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramExtractorInput.readFully(arrayOfByte, 0, paramInt);
    return new String(arrayOfByte);
  }
  
  public void init(EbmlReaderOutput paramEbmlReaderOutput)
  {
    this.output = paramEbmlReaderOutput;
  }
  
  public boolean read(ExtractorInput paramExtractorInput)
  {
    boolean bool;
    if (this.output != null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    for (;;)
    {
      if ((!this.masterElementsStack.isEmpty()) && (paramExtractorInput.getPosition() >= DefaultEbmlReader.MasterElement.access$000((DefaultEbmlReader.MasterElement)this.masterElementsStack.peek())))
      {
        this.output.endMasterElement(DefaultEbmlReader.MasterElement.access$100((DefaultEbmlReader.MasterElement)this.masterElementsStack.pop()));
        return true;
      }
      long l2;
      long l1;
      if (this.elementState == 0)
      {
        l2 = this.varintReader.readUnsignedVarint(paramExtractorInput, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          l1 = maybeResyncToNextLevel1Element(paramExtractorInput);
        }
        if (l1 == -1L) {
          return false;
        }
        this.elementId = ((int)l1);
        this.elementState = 1;
      }
      if (this.elementState == 1)
      {
        this.elementContentSize = this.varintReader.readUnsignedVarint(paramExtractorInput, false, true, 8);
        this.elementState = 2;
      }
      int i = this.output.getElementType(this.elementId);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5)
                {
                  l1 = this.elementContentSize;
                  if ((l1 != 4L) && (l1 != 8L))
                  {
                    paramExtractorInput = new StringBuilder();
                    paramExtractorInput.append("Invalid float size: ");
                    paramExtractorInput.append(this.elementContentSize);
                    throw new ParserException(paramExtractorInput.toString());
                  }
                  this.output.floatElement(this.elementId, readFloat(paramExtractorInput, (int)this.elementContentSize));
                  this.elementState = 0;
                  return true;
                }
                paramExtractorInput = new StringBuilder();
                paramExtractorInput.append("Invalid element type ");
                paramExtractorInput.append(i);
                throw new ParserException(paramExtractorInput.toString());
              }
              this.output.binaryElement(this.elementId, (int)this.elementContentSize, paramExtractorInput);
              this.elementState = 0;
              return true;
            }
            l1 = this.elementContentSize;
            if (l1 <= 2147483647L)
            {
              this.output.stringElement(this.elementId, readString(paramExtractorInput, (int)l1));
              this.elementState = 0;
              return true;
            }
            paramExtractorInput = new StringBuilder();
            paramExtractorInput.append("String element size: ");
            paramExtractorInput.append(this.elementContentSize);
            throw new ParserException(paramExtractorInput.toString());
          }
          l1 = this.elementContentSize;
          if (l1 <= 8L)
          {
            this.output.integerElement(this.elementId, readInteger(paramExtractorInput, (int)l1));
            this.elementState = 0;
            return true;
          }
          paramExtractorInput = new StringBuilder();
          paramExtractorInput.append("Invalid integer size: ");
          paramExtractorInput.append(this.elementContentSize);
          throw new ParserException(paramExtractorInput.toString());
        }
        l1 = paramExtractorInput.getPosition();
        l2 = this.elementContentSize;
        this.masterElementsStack.add(new DefaultEbmlReader.MasterElement(this.elementId, l2 + l1, null));
        this.output.startMasterElement(this.elementId, l1, this.elementContentSize);
        this.elementState = 0;
        return true;
      }
      paramExtractorInput.skipFully((int)this.elementContentSize);
      this.elementState = 0;
    }
  }
  
  public void reset()
  {
    this.elementState = 0;
    this.masterElementsStack.clear();
    this.varintReader.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader
 * JD-Core Version:    0.7.0.1
 */