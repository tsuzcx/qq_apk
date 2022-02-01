package com.tencent.mobileqq.activity.aio.core;

import bfur;
import mqq.app.QQPermissionCallback;

class BaseChatPie$84
  implements QQPermissionCallback
{
  BaseChatPie$84(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.this$0.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.doShowPtv(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.84
 * JD-Core Version:    0.7.0.1
 */