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
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceFileItemCallback);
  }
  
  public View a()
  {
    return (View)this.a.get();
  }
  
  public MessageForDeviceFile.DeviceFileItemCallback b()
  {
    return (MessageForDeviceFile.DeviceFileItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileObserver.CallbackPack
 * JD-Core Version:    0.7.0.1
 */