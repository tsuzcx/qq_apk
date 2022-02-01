package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;

class CmShowSpriteDrawerInfoBridge$2
  implements Runnable
{
  CmShowSpriteDrawerInfoBridge$2(CmShowSpriteDrawerInfoBridge paramCmShowSpriteDrawerInfoBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (CmShowSpriteDrawerInfoBridge.a(this.this$0) != null)
    {
      if (CmShowSpriteDrawerInfoBridge.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      CmShowSpriteDrawerInfoBridge.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.2
 * JD-Core Version:    0.7.0.1
 */