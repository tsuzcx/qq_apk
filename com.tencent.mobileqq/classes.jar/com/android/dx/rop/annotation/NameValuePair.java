package com.android.dx.rop.annotation;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;

public final class NameValuePair
  implements Comparable<NameValuePair>
{
  private final CstString name;
  private final Constant value;
  
  public NameValuePair(CstString paramCstString, Constant paramConstant)
  {
    if (paramCstString == null) {
      throw new NullPointerException("name == null");
    }
    if (paramConstant == null) {
      throw new NullPointerException("value == null");
    }
    this.name = paramCstString;
    this.value = paramConstant;
  }
  
  public int compareTo(NameValuePair paramNameValuePair)
  {
    int i = this.name.compareTo(paramNameValuePair.name);
    if (i != 0) {
      return i;
    }
    return this.value.compareTo(paramNameValuePair.value);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NameValuePair)) {}
    do
    {
      return false;
      paramObject = (NameValuePair)paramObject;
    } while ((!this.name.equals(paramObject.name)) || (!this.value.equals(paramObject.value)));
    return true;
  }
  
  public CstString getName()
  {
    return this.name;
  }
  
  public Constant getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.name.hashCode() * 31 + this.value.hashCode();
  }
  
  public String toString()
  {
    return this.name.toHuman() + ":" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.annotation.NameValuePair
 * JD-Core Version:    0.7.0.1
 */