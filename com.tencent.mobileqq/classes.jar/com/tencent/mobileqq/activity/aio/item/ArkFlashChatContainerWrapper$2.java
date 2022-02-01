package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.mobileqq.flashchat.FlashChatObserver;

class ArkFlashChatContainerWrapper$2
  extends FlashChatObserver
{
  ArkFlashChatContainerWrapper$2(ArkFlashChatContainerWrapper paramArkFlashChatContainerWrapper) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    ArkDispatchTask.getInstance().postDelayed(ArkFlashChatContainerWrapper.a(this.a).name, new ArkFlashChatContainerWrapper.2.1(this, paramBoolean, paramBundle), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2
 * JD-Core Version:    0.7.0.1
 */