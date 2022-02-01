package com.tencent.mobileqq.apollo;

import amje;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import andw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$2
  implements Runnable
{
  public ChatPieApolloViewController$2(amje paramamje, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine start");
    ApolloCmdChannel.getChannel(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).setActivityContext(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null)
    {
      float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = new ApolloRender(f, this.a.jdField_a_of_type_Anha, 0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.setUseGlobalTimer(true);
    }
    andw.b(this.this$0.jdField_a_of_type_Andx);
    if (!ApolloEngine.a())
    {
      andw.a(this.this$0.jdField_a_of_type_Andx);
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
      if (amje.a(this.this$0))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine but AIO destroy!");
        return;
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
    amje.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */