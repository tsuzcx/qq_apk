package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1
  implements Runnable
{
  TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, AIOAnimationControlManager.DownloadGftData paramDownloadGftData) {}
  
  public void run()
  {
    if (this.a.a)
    {
      this.this$0.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.this$0.a.uniseq);
      }
      ((AIOAnimationControlManager)TroopGiftMsgItemBuilder.TroopGiftMsgHolder.a(this.this$0).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).b(this.this$0);
      this.this$0.d.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + this.this$0.a.uniseq);
    }
    this.this$0.a.isLoading = true;
    this.this$0.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1
 * JD-Core Version:    0.7.0.1
 */