package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;

class HiBoomItemBuilder$1
  implements HiBoomTextView.OnDoubleClick
{
  HiBoomItemBuilder$1(HiBoomItemBuilder paramHiBoomItemBuilder) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.ItemBuilder", 2, "onDoubleClick");
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    if (this.a.c()) {
      return;
    }
    ChatActivityUtils.a(this.a.d, paramView, (BaseActivity)this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */