package com.tencent.mobileqq.activity.contacts.fragment;

import ahna;
import com.tencent.widget.XListView;

class DeviceFragment$1
  implements Runnable
{
  DeviceFragment$1(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Ahna != null) && (this.this$0.jdField_a_of_type_Ahna.getCount() > 0))
    {
      int i = this.this$0.jdField_a_of_type_Ahna.a();
      if ((i >= 0) && (i < this.this$0.jdField_a_of_type_Ahna.getCount())) {
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment.1
 * JD-Core Version:    0.7.0.1
 */