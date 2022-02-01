package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevicePttItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  DevicePttItemBuilder$2(DevicePttItemBuilder paramDevicePttItemBuilder, PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.d.a(this.a, this.b);
    this.d.d();
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */