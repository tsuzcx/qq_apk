package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkAppNotifyCenter$GdtNotify$3$1
  implements GdtAdLoader.Listener
{
  ArkAppNotifyCenter$GdtNotify$3$1(ArkAppNotifyCenter.GdtNotify.3 param3) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    ArkAppCenter.a().postToArkThread(new ArkAppNotifyCenter.GdtNotify.3.1.1(this, paramGdtAdLoader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3.1
 * JD-Core Version:    0.7.0.1
 */