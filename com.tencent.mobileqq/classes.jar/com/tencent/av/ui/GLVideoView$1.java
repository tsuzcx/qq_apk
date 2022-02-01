package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.qphone.base.util.QLog;

class GLVideoView$1
  implements GLRenderListener
{
  GLVideoView$1(GLVideoView paramGLVideoView, VideoAppInterface paramVideoAppInterface) {}
  
  public void onFaceFeatureUpdate(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      String str = this.b.R();
      this.a.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void onRenderFlush()
  {
    GLVideoView.c(this.b);
  }
  
  public void onRenderFrame()
  {
    GLVideoView.a(this.b);
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = GLVideoView.k(paramInt4);
    if (QLog.isColorLevel())
    {
      localObject = GLVideoView.d(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRenderInfoNotify, width[");
      localStringBuilder.append(this.b.aC);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], height[");
      localStringBuilder.append(this.b.aD);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], angle[");
      localStringBuilder.append(this.b.aB);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], rotation[");
      localStringBuilder.append(GLVideoView.e(this.b));
      localStringBuilder.append("->");
      localStringBuilder.append(i);
      localStringBuilder.append("], srcR[");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], isLocalView[");
      localStringBuilder.append(this.b.s());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!this.b.s())
    {
      localObject = this.a;
      if (localObject != null) {
        ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    Object localObject = this.b;
    ((GLVideoView)localObject).aC = paramInt1;
    ((GLVideoView)localObject).aD = paramInt2;
    ((GLVideoView)localObject).aB = paramInt3;
    ((GLVideoView)localObject).P = i;
    if (paramInt4 != -1) {
      GLVideoView.a((GLVideoView)localObject, i);
    }
    GLVideoView.f(this.b);
  }
  
  public void onRenderReset()
  {
    GLVideoView.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.1
 * JD-Core Version:    0.7.0.1
 */