package com.tencent.mobileqq.activity.aio.item;

import aedq;
import android.view.View;
import bahf;
import bahr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1
  implements Runnable
{
  public TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1(aedq paramaedq, bahr parambahr) {}
  
  public void run()
  {
    if (this.a.a)
    {
      this.this$0.a.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.this$0.a.uniseq);
      }
      ((bahf)aedq.a(this.this$0).getManager(223)).b(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1
 * JD-Core Version:    0.7.0.1
 */