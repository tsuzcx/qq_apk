package com.tencent.biz.pubaccount.weishi_new.net;

import android.os.Bundle;

@Deprecated
public class WeishiResult
  implements IResult, Cloneable
{
  @NeedParcel
  public int a;
  @NeedParcel
  private int b;
  @NeedParcel
  private int c;
  @NeedParcel
  private String d;
  @NeedParcel
  private Object e;
  @NeedParcel
  private final Bundle f = new Bundle();
  
  public WeishiResult() {}
  
  public WeishiResult(WeishiResult paramWeishiResult)
  {
    this.a = paramWeishiResult.a;
    this.b = paramWeishiResult.b;
    this.c = paramWeishiResult.c;
    this.d = paramWeishiResult.d;
    this.e = paramWeishiResult.e;
  }
  
  public WeishiResult a()
  {
    return new WeishiResult(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiResult
 * JD-Core Version:    0.7.0.1
 */