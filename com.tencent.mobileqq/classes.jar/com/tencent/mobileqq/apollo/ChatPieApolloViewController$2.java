package com.tencent.mobileqq.apollo;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$2
  implements Runnable
{
  ChatPieApolloViewController$2(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine start");
    ApolloUtilImpl.getCmdChannel().setActivityContext(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null)
    {
      float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = new ApolloRender(f, this.a.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener, 0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.setUseGlobalTimer(true);
    }
    ApolloSoLoaderImpl.removeLoadCallback(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback);
    if (!ApolloEngine.a())
    {
      ApolloSoLoaderImpl.addLoadCallback(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloSoLoader$OnCmSoLoadCompleteCallback);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine !isEngineReady");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine isEngineReady");
      }
      if (ChatPieApolloViewController.a(this.this$0))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine but AIO destroy!");
        return;
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
    ChatPieApolloViewController.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */