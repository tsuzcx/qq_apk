package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.qphone.base.util.QLog;

class TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1
  implements Runnable
{
  TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, AIOAnimationControlManager.DownloadGftData paramDownloadGftData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.a.b)
    {
      this.this$0.A.isLoading = false;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GONE uniseq = ");
        localStringBuilder.append(this.this$0.A.uniseq);
        QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
      }
      ((AIOAnimationControlManager)TroopGiftMsgItemBuilder.TroopGiftMsgHolder.a(this.this$0).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).b(this.this$0);
      this.this$0.s.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("VISIBLE uniseq = ");
      localStringBuilder.append(this.this$0.A.uniseq);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
    this.this$0.A.isLoading = true;
    this.this$0.s.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1
 * JD-Core Version:    0.7.0.1
 */