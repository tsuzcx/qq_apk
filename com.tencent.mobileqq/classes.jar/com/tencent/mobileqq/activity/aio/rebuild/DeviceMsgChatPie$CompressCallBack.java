package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Looper;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

class DeviceMsgChatPie$CompressCallBack
  extends ICompressionCallBack.Stub
{
  static final String jdField_a_of_type_JavaLangString = DeviceMsgChatPie.class.getSimpleName();
  WeakReference<DeviceMsgChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  
  public DeviceMsgChatPie$CompressCallBack(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeviceMsgChatPie);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceMsgChatPie, compress success, localUUID:");
      localStringBuilder.append(paramCompressInfo.jdField_a_of_type_JavaLangString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceMsgChatPie, compress fail, localUUID:");
      localStringBuilder.append(paramCompressInfo.jdField_a_of_type_JavaLangString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DeviceMsgChatPie, compress complete, localUUID:");
      ((StringBuilder)localObject2).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (DeviceMsgChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCompressComplete, new path:");
        localStringBuilder.append(paramCompressInfo.e);
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
      }
      if (Looper.getMainLooper().getThread() != Thread.currentThread())
      {
        if (((DeviceMsgChatPie)localObject1).a() != null) {
          ((DeviceMsgChatPie)localObject1).a().runOnUiThread(new DeviceMsgChatPie.CompressCallBack.1(this, (DeviceMsgChatPie)localObject1, paramCompressInfo));
        }
      }
      else
      {
        ((DeviceMsgChatPie)localObject1).d(paramCompressInfo.e);
        DeviceMsgChatPie.b((DeviceMsgChatPie)localObject1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.CompressCallBack
 * JD-Core Version:    0.7.0.1
 */