package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import java.lang.ref.WeakReference;

class ArkFlashChatItemBubbleBuilder$2
  implements ArkAppView.Callback
{
  ArkFlashChatItemBubbleBuilder$2(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void a()
  {
    AutoStartProgressBar localAutoStartProgressBar = (AutoStartProgressBar)this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.mSendingProgress.get();
    if ((localAutoStartProgressBar != null) && (localAutoStartProgressBar.getTag() == this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat))
    {
      localAutoStartProgressBar.b();
      localAutoStartProgressBar.setVisibility(8);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder.2
 * JD-Core Version:    0.7.0.1
 */