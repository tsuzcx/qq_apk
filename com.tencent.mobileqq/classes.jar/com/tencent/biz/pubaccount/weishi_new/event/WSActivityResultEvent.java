package com.tencent.biz.pubaccount.weishi_new.event;

import android.content.Intent;

public class WSActivityResultEvent
  extends WSSimpleBaseEvent
{
  private final Intent data;
  private final int requestCode;
  private final int resultCode;
  
  public WSActivityResultEvent(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.requestCode = paramInt1;
    this.resultCode = paramInt2;
    this.data = paramIntent;
  }
  
  public Intent getData()
  {
    return this.data;
  }
  
  public int getRequestCode()
  {
    return this.requestCode;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSActivityResultEvent
 * JD-Core Version:    0.7.0.1
 */