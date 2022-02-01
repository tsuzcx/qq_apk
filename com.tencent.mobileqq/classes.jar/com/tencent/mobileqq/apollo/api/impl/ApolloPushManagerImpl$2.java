package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPushManagerImpl$2
  implements Runnable
{
  ApolloPushManagerImpl$2(ApolloPushManagerImpl paramApolloPushManagerImpl, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionPush != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam != null)) {
      ApolloActionHelperImpl.doActionReport(ApolloPushManagerImpl.access$100(this.this$0), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionPush.mContent) ^ true, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.b);
    }
    if ((ApolloPushManagerImpl.access$100(this.this$0) != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionPush != null)) {
      ((ApolloDaoManagerServiceImpl)ApolloPushManagerImpl.access$100(this.this$0).getRuntimeService(IApolloDaoManagerService.class, "all")).removeActionPushDataById(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionPush.mId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */