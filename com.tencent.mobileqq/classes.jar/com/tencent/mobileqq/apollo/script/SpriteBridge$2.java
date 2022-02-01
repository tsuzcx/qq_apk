package com.tencent.mobileqq.apollo.script;

class SpriteBridge$2
  implements Runnable
{
  SpriteBridge$2(SpriteBridge paramSpriteBridge, SpriteActionScript paramSpriteActionScript, ISpriteContext paramISpriteContext) {}
  
  public void run()
  {
    SpriteActionScript localSpriteActionScript = this.a;
    if (localSpriteActionScript != null)
    {
      ISpriteContext localISpriteContext = this.b;
      if (localISpriteContext != null)
      {
        localSpriteActionScript.a(localISpriteContext.g(), false);
        this.a.a(this.b.h(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.2
 * JD-Core Version:    0.7.0.1
 */