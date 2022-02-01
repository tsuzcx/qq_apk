package com.tencent.mobileqq.apollo.script.drawerInfo;

import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;

class SpriteDrawerInfoBridge$2
  implements Runnable
{
  SpriteDrawerInfoBridge$2(SpriteDrawerInfoBridge paramSpriteDrawerInfoBridge, SpriteContext paramSpriteContext) {}
  
  public void run()
  {
    ISpriteDrawerInfoCallback localISpriteDrawerInfoCallback = this.a.a();
    if (localISpriteDrawerInfoCallback != null) {
      localISpriteDrawerInfoCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2
 * JD-Core Version:    0.7.0.1
 */