package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class RIJNetworkUtils$1
  implements INetEventHandler
{
  RIJNetworkUtils$1(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RIJNetworkUtils.a(this.a);
      return;
    }
    RIJNetworkUtils.a("");
    RIJNetworkUtils.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJNetworkUtils.1
 * JD-Core Version:    0.7.0.1
 */