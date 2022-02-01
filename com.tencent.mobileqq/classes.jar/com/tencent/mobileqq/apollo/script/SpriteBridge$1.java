package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;

class SpriteBridge$1
  implements Runnable
{
  SpriteBridge$1(SpriteBridge paramSpriteBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteBridge.a(this.this$0) != null)
    {
      if (SpriteBridge.a(this.this$0).a()) {
        this.a.j = 1;
      }
      this.a.a = this.this$0;
      SpriteBridge.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.1
 * JD-Core Version:    0.7.0.1
 */