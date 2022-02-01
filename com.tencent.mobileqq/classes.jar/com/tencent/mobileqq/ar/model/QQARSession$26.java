package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

class QQARSession$26
  implements Runnable
{
  QQARSession$26(QQARSession paramQQARSession, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    ArCloudConfigInfo localArCloudConfigInfo = this.a;
    if ((localArCloudConfigInfo != null) && (localArCloudConfigInfo.a()))
    {
      int i = this.b;
      if ((i != 100) && (i != 101)) {
        QQARSession.h(this.this$0).a(null, this.a, this.b, this.c, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.26
 * JD-Core Version:    0.7.0.1
 */