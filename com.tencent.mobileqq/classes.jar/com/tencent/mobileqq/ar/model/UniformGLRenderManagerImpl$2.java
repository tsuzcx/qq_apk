package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager;
import com.tencent.qphone.base.util.QLog;

class UniformGLRenderManagerImpl$2
  implements Runnable
{
  UniformGLRenderManagerImpl$2(UniformGLRenderManagerImpl paramUniformGLRenderManagerImpl, ARBaseRender paramARBaseRender, ARRenderResourceInfo paramARRenderResourceInfo) {}
  
  public void run()
  {
    ARBaseRender localARBaseRender = this.a;
    UniformGLRenderManagerImpl localUniformGLRenderManagerImpl = this.this$0;
    int i = UniformGLRenderManagerImpl.b;
    localUniformGLRenderManagerImpl = this.this$0;
    localARBaseRender.a(i, UniformGLRenderManagerImpl.c);
    localARBaseRender = this.this$0.e;
    this.this$0.e = this.a;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localARBaseRender != null) && (localARBaseRender != this.this$0.e)) {
      localARBaseRender.l();
    }
    if (this.this$0.e == null) {
      return;
    }
    boolean bool;
    if ((this.b.b == 5) && ((this.b.c == 2L) || (this.b.c == 2048L))) {
      bool = true;
    } else {
      bool = false;
    }
    this.this$0.h.a();
    this.this$0.h.a(bool, this.b);
    this.this$0.e.i();
    this.this$0.e.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */