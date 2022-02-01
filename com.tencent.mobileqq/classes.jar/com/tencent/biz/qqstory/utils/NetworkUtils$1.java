package com.tencent.biz.qqstory.utils;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class NetworkUtils$1
  implements INetEventHandler
{
  NetworkUtils$1(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NetworkUtils.f(this.a);
      return;
    }
    NetworkUtils.a("");
    NetworkUtils.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.NetworkUtils.1
 * JD-Core Version:    0.7.0.1
 */