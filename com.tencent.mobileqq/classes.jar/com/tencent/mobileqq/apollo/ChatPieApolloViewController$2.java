package com.tencent.mobileqq.apollo;

import alps;
import amkk;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$2
  implements Runnable
{
  public ChatPieApolloViewController$2(alps paramalps, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    QLog.i("sava_ChatPieApolloViewController", 1, "sava_native_log checkNeedPreLoadEngine start");
    ApolloCmdChannel.getChannel(this.a.app).setActivityContext(this.a.mActivity);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null)
    {
      float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = new ApolloRender(f, this.a.mApolloViewObserver, 0);
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.setUseGlobalTimer(true);
    }
    amkk.b(this.this$0.jdField_a_of_type_Amkm);
    if (!ApolloEngine.a())
    {
      amkk.a(this.this$0.jdField_a_of_type_Amkm);
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
      if (alps.a(this.this$0))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "checkNeedPreLoadEngine but AIO destroy!");
        return;
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
    alps.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */