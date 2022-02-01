package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;

class CmShowSpriteDrawerInfoBridge$3
  implements Runnable
{
  CmShowSpriteDrawerInfoBridge$3(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, CmShowSpriteContext paramCmShowSpriteContext) {}
  
  public void run()
  {
    ISpriteDrawerInfoCallback localISpriteDrawerInfoCallback = this.a.a();
    if (localISpriteDrawerInfoCallback != null) {
      localISpriteDrawerInfoCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.3
 * JD-Core Version:    0.7.0.1
 */