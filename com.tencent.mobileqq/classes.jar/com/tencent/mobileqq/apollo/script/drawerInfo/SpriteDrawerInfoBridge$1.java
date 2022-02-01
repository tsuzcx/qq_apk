package com.tencent.mobileqq.apollo.script.drawerInfo;

import ancp;
import ancs;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public class SpriteDrawerInfoBridge$1
  implements Runnable
{
  public SpriteDrawerInfoBridge$1(ancs paramancs, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (ancs.a(this.this$0) != null)
    {
      if (ancs.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      ancs.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */