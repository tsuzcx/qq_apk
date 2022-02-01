package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;

class QQGamePubAIOHelper$12
  implements Runnable
{
  QQGamePubAIOHelper$12(QQGamePubAIOHelper paramQQGamePubAIOHelper, QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (QQGamePubAIOHelper.a(this.this$0).c != null)
    {
      ViewGroup localViewGroup = (ViewGroup)QQGamePubAIOHelper.a(this.this$0).c.findViewById(2131362288);
      String str = QQGamePubAIOHelper.a(this.this$0).a().getIntent().getStringExtra("qqgame_msg_page_appid_key");
      ((IQQGameSubscribeService)QQGamePubAIOHelper.a(this.this$0).getRuntimeService(IQQGameSubscribeService.class)).handleGameInfoUiOnRsp(localViewGroup, str, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataQQGamePubSubscribe$AppSubscribeInfo, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.12
 * JD-Core Version:    0.7.0.1
 */