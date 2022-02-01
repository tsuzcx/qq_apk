package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevicePicItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  DevicePicItemBuilder$1(DevicePicItemBuilder paramDevicePicItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DevicePicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */