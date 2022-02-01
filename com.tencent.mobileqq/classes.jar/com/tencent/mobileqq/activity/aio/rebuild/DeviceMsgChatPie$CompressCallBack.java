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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
    DeviceMsgChatPie localDeviceMsgChatPie = (DeviceMsgChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localDeviceMsgChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
      }
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        break;
      }
    } while (localDeviceMsgChatPie.a() == null);
    localDeviceMsgChatPie.a().runOnUiThread(new DeviceMsgChatPie.CompressCallBack.1(this, localDeviceMsgChatPie, paramCompressInfo));
    return;
    localDeviceMsgChatPie.i(paramCompressInfo.e);
    DeviceMsgChatPie.b(localDeviceMsgChatPie).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.CompressCallBack
 * JD-Core Version:    0.7.0.1
 */