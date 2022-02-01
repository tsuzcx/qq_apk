package com.android.dx.cf.attrib;

import com.android.dx.cf.iface.Attribute;

public abstract class BaseAttribute
  implements Attribute
{
  private final String name;
  
  public BaseAttribute(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.BaseAttribute
 * JD-Core Version:    0.7.0.1
 */