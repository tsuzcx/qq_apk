package com.tencent.mobileqq.apollo.sdk;

import ancp;
import andj;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public class CmShowSpriteDrawerInfoBridge$2
  implements Runnable
{
  public CmShowSpriteDrawerInfoBridge$2(andj paramandj, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (andj.a(this.this$0) != null)
    {
      if (andj.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      andj.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteDrawerInfoBridge.2
 * JD-Core Version:    0.7.0.1
 */