package com.tencent.mobileqq.activity.contacts.fragment;

import afpj;
import com.tencent.widget.XListView;

class DeviceFragment$1
  implements Runnable
{
  DeviceFragment$1(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Afpj != null) && (this.this$0.jdField_a_of_type_Afpj.getCount() > 0))
    {
      int i = this.this$0.jdField_a_of_type_Afpj.a();
      if ((i >= 0) && (i < this.this$0.jdField_a_of_type_Afpj.getCount())) {
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment.1
 * JD-Core Version:    0.7.0.1
 */