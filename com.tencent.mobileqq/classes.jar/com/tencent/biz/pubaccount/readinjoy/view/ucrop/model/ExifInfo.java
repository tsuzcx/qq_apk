package com.tencent.biz.pubaccount.readinjoy.view.ucrop.model;

public class ExifInfo
{
  private int a;
  private int b;
  private int c;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        paramObject = (ExifInfo)paramObject;
        bool1 = bool3;
      } while (this.a != paramObject.a);
      bool1 = bool3;
    } while (this.b != paramObject.b);
    if (this.c == paramObject.c) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public int hashCode()
  {
    return (this.a * 31 + this.b) * 31 + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.model.ExifInfo
 * JD-Core Version:    0.7.0.1
 */