package com.android.dx.cf.attrib;

import com.android.dx.rop.type.TypeList;
import com.android.dx.util.MutabilityException;

public final class AttExceptions
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "Exceptions";
  private final TypeList exceptions;
  
  public AttExceptions(TypeList paramTypeList)
  {
    super("Exceptions");
    try
    {
      if (paramTypeList.isMutable()) {
        throw new MutabilityException("exceptions.isMutable()");
      }
    }
    catch (NullPointerException paramTypeList)
    {
      throw new NullPointerException("exceptions == null");
    }
    this.exceptions = paramTypeList;
  }
  
  public int byteLength()
  {
    return this.exceptions.size() * 2 + 8;
  }
  
  public TypeList getExceptions()
  {
    return this.exceptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttExceptions
 * JD-Core Version:    0.7.0.1
 */