package com.tencent.mobileqq.apollo.script;

class SpriteBridge$2
  implements Runnable
{
  SpriteBridge$2(SpriteBridge paramSpriteBridge, SpriteActionScript paramSpriteActionScript, ISpriteContext paramISpriteContext) {}
  
  public void run()
  {
    SpriteActionScript localSpriteActionScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript;
    if (localSpriteActionScript != null)
    {
      ISpriteContext localISpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteContext;
      if (localISpriteContext != null)
      {
        localSpriteActionScript.a(localISpriteContext.a(), false);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionScript.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteContext.b(), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.2
 * JD-Core Version:    0.7.0.1
 */