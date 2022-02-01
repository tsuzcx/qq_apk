package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

class ChatHistory$ChatHistoryAdapter$9
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$9(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, ImageViewParameter paramImageViewParameter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.istroop == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.istroop == 10002)))
    {
      localObject = PkgTools.decodeCgi(this.jdField_a_of_type_JavaLangString);
      localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, (String)localObject);
      if (localObject != null) {
        ((JumpAction)localObject).a();
      }
    }
    else
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != -3000) && (i != -3004) && (i != -30002) && (i != -30003))
      {
        if (i == -3005)
        {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
        }
        else if (i == -3001)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("schemaurl", this.jdField_a_of_type_JavaLangString);
          String str = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getCurrentAccountUin();
          ((Bundle)localObject).putString("uin", str);
          ((Bundle)localObject).putString("vkey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getManager(2)).getSkey(str));
          OpenAppClient.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, (Bundle)localObject);
        }
        else if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a))
        {
          AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, AnimationUtils.a(paramView));
        }
        else
        {
          i = this.jdField_a_of_type_Int;
          if ((i == -30002) || (i == -30003)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.isInMixedMsg = true;
          }
          PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, false, true, true, null);
        }
      }
      else {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.9
 * JD-Core Version:    0.7.0.1
 */