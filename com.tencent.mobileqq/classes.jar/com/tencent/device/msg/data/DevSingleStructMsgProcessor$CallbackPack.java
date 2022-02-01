package com.tencent.device.msg.data;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import java.lang.ref.WeakReference;

class DevSingleStructMsgProcessor$CallbackPack
{
  WeakReference<View> a;
  WeakReference<MessageForDeviceSingleStruct.DeviceSingleStructItemCallback> b;
  
  public DevSingleStructMsgProcessor$CallbackPack(DevSingleStructMsgProcessor paramDevSingleStructMsgProcessor, View paramView, MessageForDeviceSingleStruct.DeviceSingleStructItemCallback paramDeviceSingleStructItemCallback)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceSingleStructItemCallback);
  }
  
  public View a()
  {
    return (View)this.a.get();
  }
  
  public MessageForDeviceSingleStruct.DeviceSingleStructItemCallback b()
  {
    return (MessageForDeviceSingleStruct.DeviceSingleStructItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DevSingleStructMsgProcessor.CallbackPack
 * JD-Core Version:    0.7.0.1
 */