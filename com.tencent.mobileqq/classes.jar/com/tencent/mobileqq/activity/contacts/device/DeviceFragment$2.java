package com.tencent.mobileqq.activity.contacts.device;

import ajiq;
import com.tencent.widget.XListView;

class DeviceFragment$2
  implements Runnable
{
  DeviceFragment$2(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Ajiq != null) && (this.this$0.jdField_a_of_type_Ajiq.getCount() > 0))
    {
      int i = this.this$0.jdField_a_of_type_Ajiq.a();
      if ((i >= 0) && (i < this.this$0.jdField_a_of_type_Ajiq.getCount())) {
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.2
 * JD-Core Version:    0.7.0.1
 */