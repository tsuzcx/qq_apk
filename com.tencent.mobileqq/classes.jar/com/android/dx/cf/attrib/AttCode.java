package com.android.dx.cf.attrib;

import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.util.MutabilityException;

public final class AttCode
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "Code";
  private final AttributeList attributes;
  private final ByteCatchList catches;
  private final BytecodeArray code;
  private final int maxLocals;
  private final int maxStack;
  
  public AttCode(int paramInt1, int paramInt2, BytecodeArray paramBytecodeArray, ByteCatchList paramByteCatchList, AttributeList paramAttributeList)
  {
    super("Code");
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("maxStack < 0");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("maxLocals < 0");
    }
    if (paramBytecodeArray == null) {
      throw new NullPointerException("code == null");
    }
    try
    {
      if (paramByteCatchList.isMutable()) {
        throw new MutabilityException("catches.isMutable()");
      }
    }
    catch (NullPointerException paramBytecodeArray)
    {
      throw new NullPointerException("catches == null");
    }
    try
    {
      if (paramAttributeList.isMutable()) {
        throw new MutabilityException("attributes.isMutable()");
      }
    }
    catch (NullPointerException paramBytecodeArray)
    {
      throw new NullPointerException("attributes == null");
    }
    this.maxStack = paramInt1;
    this.maxLocals = paramInt2;
    this.code = paramBytecodeArray;
    this.catches = paramByteCatchList;
    this.attributes = paramAttributeList;
  }
  
  public int byteLength()
  {
    return this.code.byteLength() + 10 + this.catches.byteLength() + this.attributes.byteLength();
  }
  
  public AttributeList getAttributes()
  {
    return this.attributes;
  }
  
  public ByteCatchList getCatches()
  {
    return this.catches;
  }
  
  public BytecodeArray getCode()
  {
    return this.code;
  }
  
  public int getMaxLocals()
  {
    return this.maxLocals;
  }
  
  public int getMaxStack()
  {
    return this.maxStack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttCode
 * JD-Core Version:    0.7.0.1
 */