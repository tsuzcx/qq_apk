package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class AVNotifyCenter$GAudioHandler
  extends MqqHandler
{
  WeakReference<AVNotifyCenter> a;
  
  public AVNotifyCenter$GAudioHandler(Looper paramLooper, AVNotifyCenter paramAVNotifyCenter)
  {
    super(paramLooper);
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {
      return;
    }
    if (!localAVNotifyCenter.y()) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage, msg[");
      ((StringBuilder)localObject).append(paramMessage.what);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVNotifyCenter", 1, ((StringBuilder)localObject).toString());
    }
    if ((paramMessage.what >= 10003) && (paramMessage.what <= 10009))
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      ((Intent)localObject).putExtra("type", 35);
      ((Intent)localObject).setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast((Intent)localObject);
    }
    switch (paramMessage.what)
    {
    default: 
    case 10011: 
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      ((Intent)localObject).putExtra("type", 34);
      ((Intent)localObject).putExtra("relationId", ((Long)paramMessage.obj).longValue());
      ((Intent)localObject).setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast((Intent)localObject);
      return;
    case 10010: 
      localAVNotifyCenter.c(((Boolean)paramMessage.obj).booleanValue());
      return;
    case 10005: 
      paramMessage = (Object[])paramMessage.obj;
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      ((Intent)localObject).putExtra("type", 31);
      ((Intent)localObject).putExtra("discussId", ((Long)paramMessage[0]).longValue());
      ((Intent)localObject).putExtra("cmdUin", (String)paramMessage[1]);
      ((Intent)localObject).putExtra("uins", (String[])paramMessage[2]);
      ((Intent)localObject).setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast((Intent)localObject);
      return;
    case 10004: 
      paramMessage = (Object[])paramMessage.obj;
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      ((Intent)localObject).putExtra("type", 24);
      ((Intent)localObject).putExtra("discussId", ((Long)paramMessage[0]).longValue());
      ((Intent)localObject).putExtra("cmdUin", (String)paramMessage[1]);
      ((Intent)localObject).putExtra("uins", (String[])paramMessage[2]);
      ((Intent)localObject).setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast((Intent)localObject);
      return;
    case 10003: 
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      ((Intent)localObject).putExtra("type", 26);
      ((Intent)localObject).putExtra("discussId", ((Long)paramMessage.obj).longValue());
      ((Intent)localObject).putExtra("memberUin", localAVNotifyCenter.a.getCurrentAccountUin());
      ((Intent)localObject).setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast((Intent)localObject);
      return;
    case 10002: 
      localAVNotifyCenter.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.GAudioHandler
 * JD-Core Version:    0.7.0.1
 */