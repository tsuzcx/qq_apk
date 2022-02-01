package com.tencent.mobileqq.apollo.script.drawerinfo;

import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;

class SpriteDrawerInfoBridge$3
  implements Runnable
{
  SpriteDrawerInfoBridge$3(SpriteDrawerInfoBridge paramSpriteDrawerInfoBridge, SpriteActionScript paramSpriteActionScript, SpriteContext paramSpriteContext) {}
  
  public void run()
  {
    SpriteActionScript localSpriteActionScript = this.a;
    if (localSpriteActionScript != null)
    {
      localSpriteActionScript.a(this.b.g(), false);
      this.a.a(this.b.h(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoBridge.3
 * JD-Core Version:    0.7.0.1
 */