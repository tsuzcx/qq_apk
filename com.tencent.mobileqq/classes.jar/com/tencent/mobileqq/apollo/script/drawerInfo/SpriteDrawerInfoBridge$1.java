package com.tencent.mobileqq.apollo.script.drawerInfo;

import albn;
import albq;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public class SpriteDrawerInfoBridge$1
  implements Runnable
{
  public SpriteDrawerInfoBridge$1(albq paramalbq, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (albq.a(this.this$0) != null)
    {
      if (albq.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      albq.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */