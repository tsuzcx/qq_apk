package com.tencent.mobileqq.apollo.script;

class SpriteBridge$1
  implements Runnable
{
  SpriteBridge$1(SpriteBridge paramSpriteBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteBridge.a(this.this$0) != null)
    {
      if (SpriteBridge.a(this.this$0).c()) {
        this.a.p = 1;
      }
      SpriteTaskParam localSpriteTaskParam = this.a;
      SpriteBridge localSpriteBridge = this.this$0;
      localSpriteTaskParam.u = localSpriteBridge;
      SpriteBridge.a(localSpriteBridge).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.1
 * JD-Core Version:    0.7.0.1
 */