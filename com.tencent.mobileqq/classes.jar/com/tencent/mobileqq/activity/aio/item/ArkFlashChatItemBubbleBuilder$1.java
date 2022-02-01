package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.lang.ref.WeakReference;

class ArkFlashChatItemBubbleBuilder$1
  implements ArkAppView.Callback
{
  ArkFlashChatItemBubbleBuilder$1(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void a()
  {
    AutoStartProgressBar localAutoStartProgressBar = (AutoStartProgressBar)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.mSendingProgress.get();
    if ((localAutoStartProgressBar != null) && (localAutoStartProgressBar.getTag() == this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat))
    {
      localAutoStartProgressBar.b();
      localAutoStartProgressBar.setVisibility(8);
    }
  }
  
  public void b()
  {
    ArkAppCenter.a().postDelayed(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.ark_app_message.appName, new ArkFlashChatItemBubbleBuilder.1.1(this), 450L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */