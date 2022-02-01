package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQARSession$18
  implements Runnable
{
  QQARSession$18(QQARSession paramQQARSession, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    if (((!this.a) || (!this.b.b())) && (QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null))
    {
      localObject = QQARSession.h(this.this$0);
      int i;
      if (this.a) {
        i = 4;
      } else {
        i = 5;
      }
      ((AREngineCallback)localObject).a(1, i);
    }
    if (QQARSession.i(this.this$0) != null)
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
      QQARSession.b(QQARSession.i(this.this$0));
      QQARSession.a(this.this$0, null);
    }
    if (!this.a)
    {
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end.");
      this.this$0.D();
      ThreadManager.getUIHandler().post(new QQARSession.18.1(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARSceneRecogDownloadComplete end. isNeedInternalRender = ");
    ((StringBuilder)localObject).append(this.b.f());
    ((StringBuilder)localObject).append(", isNeedExternalRender = ");
    ((StringBuilder)localObject).append(this.b.g());
    ((StringBuilder)localObject).append(", isNeedWaitUserOperation = ");
    ((StringBuilder)localObject).append(this.b.h());
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if (this.b.b())
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2)) {
        this.this$0.i = this.b;
      }
    }
    else
    {
      if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null)) {
        QQARSession.h(this.this$0).a(2048L, new ARTarget(this.b));
      }
      if (this.b.d())
      {
        this.this$0.D();
        return;
      }
      if (this.b.f())
      {
        ARVideoRecordUIControllerImpl.a().a(2);
        if (this.b.j()) {
          QQARSession.e(this.this$0, false);
        }
        QQARSession.a(this.this$0, 2048L, this.b, -1, 0.0F, 0.0F, 0.0F);
        return;
      }
      if ((!this.b.h()) && (!this.b.g()))
      {
        this.this$0.D();
        return;
      }
      if ((this.b.g()) && (this.b.j())) {
        QQARSession.e(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.18
 * JD-Core Version:    0.7.0.1
 */