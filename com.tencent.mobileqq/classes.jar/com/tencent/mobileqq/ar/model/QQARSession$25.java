package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

class QQARSession$25
  implements Runnable
{
  QQARSession$25(QQARSession paramQQARSession, ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback) {}
  
  public void run()
  {
    if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null)) {
      QQARSession.h(this.this$0).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.25
 * JD-Core Version:    0.7.0.1
 */