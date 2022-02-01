package com.tencent.mobileqq.activity.contacts.device;

import com.tencent.widget.XListView;

class DeviceFragment$2
  implements Runnable
{
  DeviceFragment$2(DeviceFragment paramDeviceFragment) {}
  
  public void run()
  {
    if ((this.this$0.b != null) && (this.this$0.b.getCount() > 0))
    {
      int i = this.this$0.b.f();
      if ((i >= 0) && (i < this.this$0.b.getCount())) {
        this.this$0.a.setSelection(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.device.DeviceFragment.2
 * JD-Core Version:    0.7.0.1
 */