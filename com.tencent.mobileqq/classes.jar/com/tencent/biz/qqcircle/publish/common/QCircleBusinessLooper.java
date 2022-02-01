package com.tencent.biz.qqcircle.publish.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qqcircle.publish.request.QCircleRequest;
import com.tencent.biz.qqcircle.publish.task.QCircleTask;
import com.tencent.qphone.base.util.QLog;

public class QCircleBusinessLooper
  implements Handler.Callback
{
  private static final Singleton<QCircleBusinessLooper, Void> b = new QCircleBusinessLooper.1();
  public Handler a;
  
  public static QCircleBusinessLooper a()
  {
    return (QCircleBusinessLooper)b.b(null);
  }
  
  public void a(QCircleTask paramQCircleTask)
  {
    if (this.a == null) {
      this.a = new Handler(QCircleHostQzoneThreadHelper.getBusinessThreadLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramQCircleTask;
    this.a.sendMessage(localMessage);
  }
  
  public void b(QCircleTask paramQCircleTask)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramQCircleTask;
    this.a.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    String str = "mRequest is null";
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if (i == 1)
      {
        paramMessage = (QCircleTask)paramMessage.obj;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("completeTask resultCode:");
        localStringBuilder.append(paramMessage.ap);
        localStringBuilder.append(", cmd=");
        if (paramMessage.as != null) {
          str = paramMessage.as.d();
        }
        localStringBuilder.append(str);
        QLog.i("[QcirclePublish]QcircleBusinessLooper", 1, localStringBuilder.toString());
        if (paramMessage.an != null) {
          try
          {
            paramMessage.an.a(paramMessage);
          }
          catch (Exception paramMessage)
          {
            QLog.w("[QcirclePublish]QcircleBusinessLooper", 1, paramMessage.getMessage());
          }
        }
      }
    }
    else
    {
      paramMessage = (QCircleTask)paramMessage.obj;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runTask cmd=");
      if (paramMessage.as != null) {
        str = paramMessage.as.d();
      }
      localStringBuilder.append(str);
      QLog.i("[QcirclePublish]QcircleBusinessLooper", 1, localStringBuilder.toString());
      paramMessage.E();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.common.QCircleBusinessLooper
 * JD-Core Version:    0.7.0.1
 */