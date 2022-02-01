package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$1
  implements IApolloSoLoader.OnCmSoLoadCompleteCallback
{
  ChatPieApolloViewController$1(ChatPieApolloViewController paramChatPieApolloViewController) {}
  
  public void a(int paramInt)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, "sava_native_log preLoadApolloEngine onSoLoadComplete ret:" + paramInt);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine onSoLoadComplete");
      }
      if (ChatPieApolloViewController.a(this.a))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "onSoLoadComplete but AIO destroy!");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
        ChatPieApolloViewController.a(this.a);
      }
    }
    ApolloSoLoaderImpl.removeLoadCallback(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.1
 * JD-Core Version:    0.7.0.1
 */