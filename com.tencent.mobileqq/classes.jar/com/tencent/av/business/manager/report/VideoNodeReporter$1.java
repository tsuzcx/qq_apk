package com.tencent.av.business.manager.report;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.qphone.base.util.QLog;

class VideoNodeReporter$1
  implements Handler.Callback
{
  VideoNodeReporter$1(VideoNodeReporter paramVideoNodeReporter) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage msg =  ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("VideoNodeReporter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramMessage.what != 1) {
      return false;
    }
    Object localObject = this.a;
    long l2 = 1L;
    ((VideoNodeReporter)localObject).a(36, 1L);
    boolean bool2 = SmallScreenUtils.f(BaseApplicationImpl.getContext());
    localObject = this.a;
    long l1;
    if (bool2) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    ((VideoNodeReporter)localObject).a(23, l1);
    localObject = null;
    boolean bool1;
    try
    {
      String str = ConfigHandler.a(BaseApplicationImpl.getContext());
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        bool1 = str.equals("com.tencent.av.ui.AVActivity");
        if (bool1)
        {
          localObject = str;
          break label205;
        }
      }
      bool1 = true;
      localObject = str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage Exception ,msg =  ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("VideoNodeReporter", 1, localStringBuilder.toString(), localException);
      label205:
      bool1 = false;
    }
    paramMessage = this.a;
    if (bool1) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    paramMessage.a(28, l1);
    int i = this.a.f;
    this.a.a(37, i);
    if (VideoNodeReporter.a(this.a).b() != null) {
      VideoNodeReporter.b(this.a).b().b("batteryValue", String.valueOf(i));
    }
    boolean bool3 = VideoController.b(BaseApplicationImpl.getContext());
    paramMessage = this.a;
    if (bool3) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    paramMessage.a(39, l1);
    bool3 = SmallScreenUtils.b(BaseApplicationImpl.getContext());
    paramMessage = this.a;
    if (bool3) {
      l1 = l2;
    } else {
      l1 = 0L;
    }
    paramMessage.a(40, l1);
    this.a.b();
    i = QavRecordDpc.a().j;
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage, activityName =  ");
    paramMessage.append((String)localObject);
    paramMessage.append(",isAppForground = ");
    paramMessage.append(bool2);
    paramMessage.append(",isBackground = ");
    paramMessage.append(bool1);
    paramMessage.append(",checkDuration = ");
    paramMessage.append(i);
    QLog.d("VideoNodeReporter", 1, paramMessage.toString());
    this.a.g.sendEmptyMessageDelayed(1, i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.1
 * JD-Core Version:    0.7.0.1
 */