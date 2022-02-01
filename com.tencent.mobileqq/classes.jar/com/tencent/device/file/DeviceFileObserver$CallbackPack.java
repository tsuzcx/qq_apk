package com.tencent.device.file;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import java.lang.ref.WeakReference;

public class DeviceFileObserver$CallbackPack
{
  public WeakReference<View> a;
  public WeakReference<MessageForDeviceFile.DeviceFileItemCallback> b;
  
  public DeviceFileObserver$CallbackPack(DeviceFileObserver paramDeviceFileObserver, View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceFileItemCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public MessageForDeviceFile.DeviceFileItemCallback a()
  {
    return (MessageForDeviceFile.DeviceFileItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileObserver.CallbackPack
 * JD-Core Version:    0.7.0.1
 */