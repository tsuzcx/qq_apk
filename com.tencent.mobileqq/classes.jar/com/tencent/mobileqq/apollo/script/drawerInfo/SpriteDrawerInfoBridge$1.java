package com.tencent.mobileqq.apollo.script.drawerInfo;

import ambh;
import ambk;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public class SpriteDrawerInfoBridge$1
  implements Runnable
{
  public SpriteDrawerInfoBridge$1(ambk paramambk, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (ambk.a(this.this$0) != null)
    {
      if (ambk.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      ambk.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */