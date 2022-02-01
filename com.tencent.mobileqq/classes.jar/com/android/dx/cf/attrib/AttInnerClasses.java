package com.android.dx.cf.attrib;

import com.android.dx.util.MutabilityException;

public final class AttInnerClasses
  extends BaseAttribute
{
  public static final String ATTRIBUTE_NAME = "InnerClasses";
  private final InnerClassList innerClasses;
  
  public AttInnerClasses(InnerClassList paramInnerClassList)
  {
    super("InnerClasses");
    try
    {
      if (paramInnerClassList.isMutable()) {
        throw new MutabilityException("innerClasses.isMutable()");
      }
    }
    catch (NullPointerException paramInnerClassList)
    {
      throw new NullPointerException("innerClasses == null");
    }
    this.innerClasses = paramInnerClassList;
  }
  
  public int byteLength()
  {
    return this.innerClasses.size() * 8 + 8;
  }
  
  public InnerClassList getInnerClasses()
  {
    return this.innerClasses;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.AttInnerClasses
 * JD-Core Version:    0.7.0.1
 */