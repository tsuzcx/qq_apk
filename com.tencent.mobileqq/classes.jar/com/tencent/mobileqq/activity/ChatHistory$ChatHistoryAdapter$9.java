package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
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
      localObject = PkgTools.Decodecgi(this.jdField_a_of_type_JavaLangString);
      localObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, (String)localObject);
      if (localObject != null) {
        ((JumpAction)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3005)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
      }
      else if (this.jdField_a_of_type_Int == -3001)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", this.jdField_a_of_type_JavaLangString);
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getCurrentAccountUin();
        ((Bundle)localObject).putString("uin", str);
        ((Bundle)localObject).putString("vkey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getManager(2)).getSkey(str));
        OpenAppClient.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, (Bundle)localObject);
      }
      else if (PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a))
      {
        AIOEmotionFragment.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, AnimationUtils.a(paramView));
      }
      else
      {
        if ((this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.isInMixedMsg = true;
        }
        PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, paramView.getContext(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, false, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.9
 * JD-Core Version:    0.7.0.1
 */