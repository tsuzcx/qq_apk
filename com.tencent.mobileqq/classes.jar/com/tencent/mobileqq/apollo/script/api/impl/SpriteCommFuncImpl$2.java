package com.tencent.mobileqq.apollo.script.api.impl;

import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;

class SpriteCommFuncImpl$2
  implements Runnable
{
  SpriteCommFuncImpl$2(SpriteCommFuncImpl paramSpriteCommFuncImpl, ISpriteTaskHandler paramISpriteTaskHandler, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    ISpriteTaskHandler localISpriteTaskHandler = this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler;
    if (localISpriteTaskHandler != null) {
      localISpriteTaskHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.api.impl.SpriteCommFuncImpl.2
 * JD-Core Version:    0.7.0.1
 */