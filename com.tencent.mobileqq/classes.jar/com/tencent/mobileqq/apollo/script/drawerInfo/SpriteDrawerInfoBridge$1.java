package com.tencent.mobileqq.apollo.script.drawerInfo;

import akwy;
import akxb;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

public class SpriteDrawerInfoBridge$1
  implements Runnable
{
  public SpriteDrawerInfoBridge$1(akxb paramakxb, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (akxb.a(this.this$0) != null)
    {
      if (akxb.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      akxb.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1
 * JD-Core Version:    0.7.0.1
 */