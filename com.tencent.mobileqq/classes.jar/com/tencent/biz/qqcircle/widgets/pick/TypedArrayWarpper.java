package com.tencent.biz.qqcircle.widgets.pick;

import android.content.res.TypedArray;

public class TypedArrayWarpper
{
  private TypedArray a;
  
  public TypedArrayWarpper(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray;
  }
  
  public void a()
  {
    this.a.recycle();
  }
  
  public CharSequence[] a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getTextArray(paramInt);
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.TypedArrayWarpper
 * JD-Core Version:    0.7.0.1
 */