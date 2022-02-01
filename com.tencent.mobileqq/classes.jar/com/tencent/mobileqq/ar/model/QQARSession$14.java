package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQARSession$14
  implements Runnable
{
  QQARSession$14(QQARSession paramQQARSession, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    Object localObject1;
    if (((!this.a) || (!this.b.a())) && ((!this.a) || (!this.b.b())) && (QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null))
    {
      localObject1 = QQARSession.h(this.this$0);
      int i;
      if (this.a) {
        i = 4;
      } else {
        i = 5;
      }
      ((AREngineCallback)localObject1).a(1, i);
    }
    if (QQARSession.i(this.this$0) != null)
    {
      QQARSession.b(QQARSession.i(this.this$0));
      QQARSession.a(this.this$0, null);
    }
    if (!this.a)
    {
      QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end.");
      QQARSession.d(this.this$0, false);
      QQARSession.j(this.this$0);
      ThreadManager.getUIHandler().post(new QQARSession.14.1(this));
      return;
    }
    Object localObject2;
    if (this.b.a())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null))
      {
        localObject1 = QQARSession.h(this.this$0);
        localObject2 = this.b;
        ((AREngineCallback)localObject1).a((ArCloudConfigInfo)localObject2, (ArCloudConfigInfo)localObject2, 10, 0, null);
      }
    }
    else if (this.b.b())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2)) {
        this.this$0.i = this.b;
      }
    }
    else
    {
      localObject1 = this.b.j.a;
      localObject2 = this.b.j.d;
      if ((!this.b.d()) && (QQARSession.k(this.this$0)))
      {
        if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null)) {
          QQARSession.h(this.this$0).a(1L, new ARTarget(this.b));
        }
        if (this.b.f())
        {
          if (this.b.f()) {
            ARVideoRecordUIControllerImpl.a().a(1);
          }
          this.this$0.a(1L);
          QQARSession.a(this.this$0, 1L, this.b, 0, 0.0F, 0.0F, 0.0F);
          if (this.b.j()) {
            QQARSession.e(this.this$0, false);
          }
        }
        else if ((!this.b.h()) && (!this.b.g()))
        {
          QQARSession.j(this.this$0);
        }
        else if (this.b.g())
        {
          this.this$0.a(1L);
          if (this.b.j()) {
            QQARSession.e(this.this$0, true);
          }
        }
      }
      if (this.this$0.h != null)
      {
        this.this$0.h.a((String)localObject1, (String)localObject2, this.b);
        QQARSession.a(this.this$0, 0L);
        QQARSession.b(this.this$0, 0L);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processCloudMarkerRecogResult end. isNeedInternalRender = ");
      ((StringBuilder)localObject1).append(this.b.f());
      ((StringBuilder)localObject1).append(", isNeedExternalRender = ");
      ((StringBuilder)localObject1).append(this.b.g());
      ((StringBuilder)localObject1).append(", isNeedWaitUserOperation = ");
      ((StringBuilder)localObject1).append(this.b.h());
      QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
    }
    QQARSession.d(this.this$0, false);
    this.this$0.o = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.14
 * JD-Core Version:    0.7.0.1
 */