package com.tencent.mobileqq.apollo.script.drawerInfo;

import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;

class SpriteDrawerInfoBridge$1
  implements Runnable
{
  SpriteDrawerInfoBridge$1(SpriteDrawerInfoBridge paramSpriteDrawerInfoBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteDrawerInfoBridge.a(this.this$0) != null)
    {
      if (SpriteDrawerInfoBridge.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      SpriteDrawerInfoBridge.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */