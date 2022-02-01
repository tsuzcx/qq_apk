package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class ArkFlashChatItemBubbleBuilder$1
  implements ArkAppView.Callback
{
  ArkFlashChatItemBubbleBuilder$1(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void a()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThreadDelay(this.a.ark_app_message.appName, new ArkFlashChatItemBubbleBuilder.1.1(this), 450);
  }
  
  public void b()
  {
    AutoStartProgressBar localAutoStartProgressBar = (AutoStartProgressBar)this.a.mSendingProgress.get();
    if ((localAutoStartProgressBar != null) && (localAutoStartProgressBar.getTag() == this.a))
    {
      localAutoStartProgressBar.b();
      localAutoStartProgressBar.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */