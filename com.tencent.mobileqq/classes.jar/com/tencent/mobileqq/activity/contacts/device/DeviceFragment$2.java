package com.tencent.mobileqq.activity.contacts.device;

import ajtz;
import com.tencent.widget.XListView;

class DeviceFragment$2
  implements Runnable
{
  DeviceFragment$2(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Ajtz != null) && (this.this$0.jdField_a_of_type_Ajtz.getCount() > 0))
    {
      int i = this.this$0.jdField_a_of_type_Ajtz.a();
      if ((i >= 0) && (i < this.this$0.jdField_a_of_type_Ajtz.getCount())) {
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.2
 * JD-Core Version:    0.7.0.1
 */