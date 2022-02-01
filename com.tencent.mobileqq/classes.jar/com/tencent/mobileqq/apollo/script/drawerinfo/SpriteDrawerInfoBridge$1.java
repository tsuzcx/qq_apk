package com.tencent.mobileqq.apollo.script.drawerinfo;

import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

class SpriteDrawerInfoBridge$1
  implements Runnable
{
  SpriteDrawerInfoBridge$1(SpriteDrawerInfoBridge paramSpriteDrawerInfoBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteDrawerInfoBridge.a(this.this$0) != null)
    {
      if (SpriteDrawerInfoBridge.a(this.this$0).c()) {
        this.a.p = 1;
      }
      SpriteTaskParam localSpriteTaskParam = this.a;
      SpriteDrawerInfoBridge localSpriteDrawerInfoBridge = this.this$0;
      localSpriteTaskParam.u = localSpriteDrawerInfoBridge;
      SpriteDrawerInfoBridge.a(localSpriteDrawerInfoBridge).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */