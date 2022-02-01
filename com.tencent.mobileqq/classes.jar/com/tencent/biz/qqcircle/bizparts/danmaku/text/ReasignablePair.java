package com.tencent.biz.qqcircle.bizparts.danmaku.text;

public class ReasignablePair<F, S>
{
  public F a;
  public S b;
  
  public ReasignablePair(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
  }
  
  public ReasignablePair<F, S> a(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ReasignablePair)) {
      return false;
    }
    try
    {
      paramObject = (ReasignablePair)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.a.hashCode()) * 31 + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ReasignablePair
 * JD-Core Version:    0.7.0.1
 */