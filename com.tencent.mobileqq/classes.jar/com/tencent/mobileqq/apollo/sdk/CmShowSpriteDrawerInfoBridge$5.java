package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;

class CmShowSpriteDrawerInfoBridge$5
  implements Runnable
{
  CmShowSpriteDrawerInfoBridge$5(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, CmShowSpriteContext paramCmShowSpriteContext) {}
  
  public void run()
  {
    ISpriteDrawerInfoCallback localISpriteDrawerInfoCallback = this.a.a();
    if (localISpriteDrawerInfoCallback != null) {
      localISpriteDrawerInfoCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.5
 * JD-Core Version:    0.7.0.1
 */