package com.tencent.device.file;

import android.view.View;
import java.lang.ref.WeakReference;

class DeviceAVFileMsgObserver$CallbackPack
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<DeviceAVFileMsgObserver.DevMsgViewCallback> b;
  
  public DeviceAVFileMsgObserver$CallbackPack(DeviceAVFileMsgObserver paramDeviceAVFileMsgObserver, View paramView, DeviceAVFileMsgObserver.DevMsgViewCallback paramDevMsgViewCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDevMsgViewCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public DeviceAVFileMsgObserver.DevMsgViewCallback a()
  {
    return (DeviceAVFileMsgObserver.DevMsgViewCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DeviceAVFileMsgObserver.CallbackPack
 * JD-Core Version:    0.7.0.1
 */