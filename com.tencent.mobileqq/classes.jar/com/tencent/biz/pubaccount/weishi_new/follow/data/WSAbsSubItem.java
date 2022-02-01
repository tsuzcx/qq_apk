package com.tencent.biz.pubaccount.weishi_new.follow.data;

public abstract class WSAbsSubItem<T>
{
  protected T a;
  protected StringBuilder b;
  
  public String a()
  {
    StringBuilder localStringBuilder = this.b;
    if (localStringBuilder == null) {
      return "";
    }
    return localStringBuilder.toString();
  }
  
  public T b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.data.WSAbsSubItem
 * JD-Core Version:    0.7.0.1
 */