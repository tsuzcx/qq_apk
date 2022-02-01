package com.tencent.mobileqq.activity.aio.item;

import ahle;
import android.view.View;
import bggl;
import bggx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1
  implements Runnable
{
  public TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1(ahle paramahle, bggx parambggx) {}
  
  public void run()
  {
    if (this.a.a)
    {
      this.this$0.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.this$0.a.uniseq);
      }
      ((bggl)ahle.a(this.this$0).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).b(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1
 * JD-Core Version:    0.7.0.1
 */