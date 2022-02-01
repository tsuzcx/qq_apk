package com.tencent.device.msg.data;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import java.lang.ref.WeakReference;

class DevSingleStructMsgProcessor$CallbackPack
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<MessageForDeviceSingleStruct.DeviceSingleStructItemCallback> b;
  
  public DevSingleStructMsgProcessor$CallbackPack(DevSingleStructMsgProcessor paramDevSingleStructMsgProcessor, View paramView, MessageForDeviceSingleStruct.DeviceSingleStructItemCallback paramDeviceSingleStructItemCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceSingleStructItemCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public MessageForDeviceSingleStruct.DeviceSingleStructItemCallback a()
  {
    return (MessageForDeviceSingleStruct.DeviceSingleStructItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.data.DevSingleStructMsgProcessor.CallbackPack
 * JD-Core Version:    0.7.0.1
 */