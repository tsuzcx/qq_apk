package com.android.dx.cf.direct;

import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

final class AttributeListParser
{
  private final AttributeFactory attributeFactory;
  private final DirectClassFile cf;
  private final int context;
  private int endOffset;
  private final StdAttributeList list;
  private ParseObserver observer;
  private final int offset;
  
  public AttributeListParser(DirectClassFile paramDirectClassFile, int paramInt1, int paramInt2, AttributeFactory paramAttributeFactory)
  {
    if (paramDirectClassFile == null) {
      throw new NullPointerException("cf == null");
    }
    if (paramAttributeFactory == null) {
      throw new NullPointerException("attributeFactory == null");
    }
    int i = paramDirectClassFile.getBytes().getUnsignedShort(paramInt2);
    this.cf = paramDirectClassFile;
    this.context = paramInt1;
    this.offset = paramInt2;
    this.attributeFactory = paramAttributeFactory;
    this.list = new StdAttributeList(i);
    this.endOffset = -1;
  }
  
  private void parse()
  {
    int k = this.list.size();
    int i = this.offset;
    ByteArray localByteArray = this.cf.getBytes();
    if (this.observer != null) {
      this.observer.parsed(localByteArray, this.offset, 2, "attributes_count: " + Hex.u2(k));
    }
    int j = i + 2;
    i = 0;
    while (i < k) {
      try
      {
        if (this.observer != null)
        {
          this.observer.parsed(localByteArray, j, 0, "\nattributes[" + i + "]:\n");
          this.observer.changeIndent(1);
        }
        Attribute localAttribute = this.attributeFactory.parse(this.cf, this.context, j, this.observer);
        j = localAttribute.byteLength() + j;
        this.list.set(i, localAttribute);
        if (this.observer != null)
        {
          this.observer.changeIndent(-1);
          this.observer.parsed(localByteArray, j, 0, "end attributes[" + i + "]\n");
        }
        i += 1;
      }
      catch (ParseException localParseException1)
      {
        localParseException1.addContext("...while parsing attributes[" + i + "]");
        throw localParseException1;
      }
      catch (RuntimeException localRuntimeException)
      {
        ParseException localParseException2 = new ParseException(localRuntimeException);
        localParseException2.addContext("...while parsing attributes[" + i + "]");
        throw localParseException2;
      }
    }
    this.endOffset = j;
  }
  
  private void parseIfNecessary()
  {
    if (this.endOffset < 0) {
      parse();
    }
  }
  
  public int getEndOffset()
  {
    parseIfNecessary();
    return this.endOffset;
  }
  
  public StdAttributeList getList()
  {
    parseIfNecessary();
    return this.list;
  }
  
  public void setObserver(ParseObserver paramParseObserver)
  {
    this.observer = paramParseObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.AttributeListParser
 * JD-Core Version:    0.7.0.1
 */