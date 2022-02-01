package com.android.dx.util;

import com.android.dex.Leb128;
import com.android.dex.util.ByteOutput;
import com.android.dex.util.ExceptionWithContext;
import java.io.Writer;
import java.util.ArrayList;

public final class ByteArrayAnnotatedOutput
  implements ByteOutput, AnnotatedOutput
{
  private static final int DEFAULT_SIZE = 1000;
  private int annotationWidth;
  private ArrayList<ByteArrayAnnotatedOutput.Annotation> annotations;
  private int cursor;
  private byte[] data;
  private int hexCols;
  private final boolean stretchy;
  private boolean verbose;
  
  public ByteArrayAnnotatedOutput()
  {
    this(1000);
  }
  
  public ByteArrayAnnotatedOutput(int paramInt)
  {
    this(new byte[paramInt], true);
  }
  
  public ByteArrayAnnotatedOutput(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, false);
  }
  
  private ByteArrayAnnotatedOutput(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("data == null");
    }
    this.stretchy = paramBoolean;
    this.data = paramArrayOfByte;
    this.cursor = 0;
    this.verbose = false;
    this.annotations = null;
    this.annotationWidth = 0;
    this.hexCols = 0;
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (this.data.length < paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt * 2 + 1000];
      System.arraycopy(this.data, 0, arrayOfByte, 0, this.cursor);
      this.data = arrayOfByte;
    }
  }
  
  private static void throwBounds()
  {
    throw new IndexOutOfBoundsException("attempt to write past the end");
  }
  
  public void alignTo(int paramInt)
  {
    int i = paramInt - 1;
    if ((paramInt < 0) || ((i & paramInt) != 0)) {
      throw new IllegalArgumentException("bogus alignment");
    }
    paramInt = (i ^ 0xFFFFFFFF) & this.cursor + i;
    if (this.stretchy) {
      ensureCapacity(paramInt);
    }
    while (paramInt <= this.data.length)
    {
      this.cursor = paramInt;
      return;
    }
    throwBounds();
  }
  
  public void annotate(int paramInt, String paramString)
  {
    if (this.annotations == null) {
      return;
    }
    endAnnotation();
    int i = this.annotations.size();
    if (i == 0) {}
    for (i = 0;; i = ((ByteArrayAnnotatedOutput.Annotation)this.annotations.get(i - 1)).getEnd())
    {
      int j = i;
      if (i <= this.cursor) {
        j = this.cursor;
      }
      this.annotations.add(new ByteArrayAnnotatedOutput.Annotation(j, j + paramInt, paramString));
      return;
    }
  }
  
  public void annotate(String paramString)
  {
    if (this.annotations == null) {
      return;
    }
    endAnnotation();
    this.annotations.add(new ByteArrayAnnotatedOutput.Annotation(this.cursor, paramString));
  }
  
  public boolean annotates()
  {
    return this.annotations != null;
  }
  
  public void assertCursor(int paramInt)
  {
    if (this.cursor != paramInt) {
      throw new ExceptionWithContext("expected cursor " + paramInt + "; actual value: " + this.cursor);
    }
  }
  
  public void enableAnnotations(int paramInt, boolean paramBoolean)
  {
    int i = 6;
    if ((this.annotations != null) || (this.cursor != 0)) {
      throw new RuntimeException("cannot enable annotations");
    }
    if (paramInt < 40) {
      throw new IllegalArgumentException("annotationWidth < 40");
    }
    int j = (paramInt - 7) / 15 + 1 & 0xFFFFFFFE;
    if (j < 6) {}
    for (;;)
    {
      this.annotations = new ArrayList(1000);
      this.annotationWidth = paramInt;
      this.hexCols = i;
      this.verbose = paramBoolean;
      return;
      if (j > 10) {
        i = 10;
      } else {
        i = j;
      }
    }
  }
  
  public void endAnnotation()
  {
    if (this.annotations == null) {}
    int i;
    do
    {
      return;
      i = this.annotations.size();
    } while (i == 0);
    ((ByteArrayAnnotatedOutput.Annotation)this.annotations.get(i - 1)).setEndIfUnset(this.cursor);
  }
  
  public void finishAnnotating()
  {
    endAnnotation();
    if (this.annotations != null)
    {
      int i = this.annotations.size();
      while (i > 0)
      {
        ByteArrayAnnotatedOutput.Annotation localAnnotation = (ByteArrayAnnotatedOutput.Annotation)this.annotations.get(i - 1);
        if (localAnnotation.getStart() > this.cursor)
        {
          this.annotations.remove(i - 1);
          i -= 1;
        }
        else if (localAnnotation.getEnd() > this.cursor)
        {
          localAnnotation.setEnd(this.cursor);
        }
      }
    }
  }
  
  public int getAnnotationWidth()
  {
    int i = this.hexCols;
    int j = this.hexCols / 2;
    return this.annotationWidth - (i * 2 + 8 + j);
  }
  
  public byte[] getArray()
  {
    return this.data;
  }
  
  public int getCursor()
  {
    return this.cursor;
  }
  
  public boolean isVerbose()
  {
    return this.verbose;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.cursor];
    System.arraycopy(this.data, 0, arrayOfByte, 0, this.cursor);
    return arrayOfByte;
  }
  
  public void write(ByteArray paramByteArray)
  {
    int j = paramByteArray.size();
    int i = this.cursor;
    j += i;
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      paramByteArray.getBytes(this.data, i);
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.cursor;
    int j = i + paramInt2;
    if (((paramInt1 | paramInt2 | j) < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("bytes.length " + paramArrayOfByte.length + "; " + paramInt1 + "..!" + j);
    }
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.data, i, paramInt2);
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public void writeAnnotationsTo(Writer paramWriter)
  {
    int i = getAnnotationWidth();
    TwoColumnOutput localTwoColumnOutput = new TwoColumnOutput(paramWriter, this.annotationWidth - i - 1, i, "|");
    Writer localWriter1 = localTwoColumnOutput.getLeft();
    Writer localWriter2 = localTwoColumnOutput.getRight();
    int n = this.annotations.size();
    i = 0;
    int j = 0;
    if ((j < this.cursor) && (i < n))
    {
      paramWriter = (ByteArrayAnnotatedOutput.Annotation)this.annotations.get(i);
      k = paramWriter.getStart();
      if (j < k) {
        paramWriter = "";
      }
      for (;;)
      {
        localWriter1.write(Hex.dump(this.data, j, k - j, j, this.hexCols, 6));
        localWriter2.write(paramWriter);
        localTwoColumnOutput.flush();
        j = k;
        break;
        int m = paramWriter.getEnd();
        paramWriter = paramWriter.getText();
        i += 1;
        j = k;
        k = m;
      }
    }
    int k = i;
    if (j < this.cursor)
    {
      localWriter1.write(Hex.dump(this.data, j, this.cursor - j, j, this.hexCols, 6));
      k = i;
    }
    while (k < n)
    {
      localWriter2.write(((ByteArrayAnnotatedOutput.Annotation)this.annotations.get(k)).getText());
      k += 1;
    }
    localTwoColumnOutput.flush();
  }
  
  public void writeByte(int paramInt)
  {
    int i = this.cursor;
    int j = i + 1;
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      this.data[i] = ((byte)paramInt);
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public void writeInt(int paramInt)
  {
    int i = this.cursor;
    int j = i + 4;
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      this.data[i] = ((byte)paramInt);
      this.data[(i + 1)] = ((byte)(paramInt >> 8));
      this.data[(i + 2)] = ((byte)(paramInt >> 16));
      this.data[(i + 3)] = ((byte)(paramInt >> 24));
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public void writeLong(long paramLong)
  {
    int i = this.cursor;
    int j = i + 8;
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      int k = (int)paramLong;
      this.data[i] = ((byte)k);
      this.data[(i + 1)] = ((byte)(k >> 8));
      this.data[(i + 2)] = ((byte)(k >> 16));
      this.data[(i + 3)] = ((byte)(k >> 24));
      k = (int)(paramLong >> 32);
      this.data[(i + 4)] = ((byte)k);
      this.data[(i + 5)] = ((byte)(k >> 8));
      this.data[(i + 6)] = ((byte)(k >> 16));
      this.data[(i + 7)] = ((byte)(k >> 24));
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public void writeShort(int paramInt)
  {
    int i = this.cursor;
    int j = i + 2;
    if (this.stretchy) {
      ensureCapacity(j);
    }
    while (j <= this.data.length)
    {
      this.data[i] = ((byte)paramInt);
      this.data[(i + 1)] = ((byte)(paramInt >> 8));
      this.cursor = j;
      return;
    }
    throwBounds();
  }
  
  public int writeSleb128(int paramInt)
  {
    if (this.stretchy) {
      ensureCapacity(this.cursor + 5);
    }
    int i = this.cursor;
    Leb128.writeSignedLeb128(this, paramInt);
    return this.cursor - i;
  }
  
  public int writeUleb128(int paramInt)
  {
    if (this.stretchy) {
      ensureCapacity(this.cursor + 5);
    }
    int i = this.cursor;
    Leb128.writeUnsignedLeb128(this, paramInt);
    return this.cursor - i;
  }
  
  public void writeZeroes(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("count < 0");
    }
    paramInt = this.cursor + paramInt;
    if (this.stretchy) {
      ensureCapacity(paramInt);
    }
    while (paramInt <= this.data.length)
    {
      this.cursor = paramInt;
      return;
    }
    throwBounds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.ByteArrayAnnotatedOutput
 * JD-Core Version:    0.7.0.1
 */