package com.tencent.mobileqq.activity.aio.core;

import bhdj;
import mqq.app.QQPermissionCallback;

class BaseChatPie$82
  implements QQPermissionCallback
{
  BaseChatPie$82(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.this$0.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.grantForCamera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.82
 * JD-Core Version:    0.7.0.1
 */