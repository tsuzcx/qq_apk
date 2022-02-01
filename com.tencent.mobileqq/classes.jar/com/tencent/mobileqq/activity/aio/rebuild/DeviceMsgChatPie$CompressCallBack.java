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
  static final String b = DeviceMsgChatPie.class.getSimpleName();
  WeakReference<DeviceMsgChatPie> a;
  
  public DeviceMsgChatPie$CompressCallBack(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    this.a = new WeakReference(paramDeviceMsgChatPie);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceMsgChatPie, compress success, localUUID:");
      localStringBuilder.append(paramCompressInfo.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceMsgChatPie, compress fail, localUUID:");
      localStringBuilder.append(paramCompressInfo.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DeviceMsgChatPie, compress complete, localUUID:");
      ((StringBuilder)localObject2).append(paramCompressInfo.a);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (DeviceMsgChatPie)this.a.get();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(b, 2, "onCompressComplete, error: activity is null");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCompressComplete, new path:");
        localStringBuilder.append(paramCompressInfo.l);
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
      }
      if (Looper.getMainLooper().getThread() != Thread.currentThread())
      {
        if (((DeviceMsgChatPie)localObject1).aX() != null) {
          ((DeviceMsgChatPie)localObject1).aX().runOnUiThread(new DeviceMsgChatPie.CompressCallBack.1(this, (DeviceMsgChatPie)localObject1, paramCompressInfo));
        }
      }
      else
      {
        ((DeviceMsgChatPie)localObject1).e(paramCompressInfo.l);
        DeviceMsgChatPie.d((DeviceMsgChatPie)localObject1).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.CompressCallBack
 * JD-Core Version:    0.7.0.1
 */