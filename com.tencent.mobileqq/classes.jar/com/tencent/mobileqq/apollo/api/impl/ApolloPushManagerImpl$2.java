package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPushManagerImpl$2
  implements Runnable
{
  ApolloPushManagerImpl$2(ApolloPushManagerImpl paramApolloPushManagerImpl, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    SpriteTaskParam localSpriteTaskParam;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionPush != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam != null))
    {
      localQQAppInterface = ApolloPushManagerImpl.access$100(this.this$0);
      localSpriteTaskParam = this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionPush.mContent)) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      ApolloActionHelperImpl.doActionReport(localQQAppInterface, localSpriteTaskParam, bool, this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptSpriteTaskParam.b);
      if ((ApolloPushManagerImpl.access$100(this.this$0) != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionPush != null)) {
        ((ApolloDaoManagerServiceImpl)ApolloPushManagerImpl.access$100(this.this$0).getRuntimeService(IApolloDaoManagerService.class, "all")).removeActionPushDataById(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionPush.mId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */