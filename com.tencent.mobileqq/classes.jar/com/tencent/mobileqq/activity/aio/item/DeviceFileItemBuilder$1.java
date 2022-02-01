package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DeviceFileItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  DeviceFileItemBuilder$1(DeviceFileItemBuilder paramDeviceFileItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.c.a(this.a);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */