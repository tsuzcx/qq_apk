package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class OnlineVideoARRenderable$1
  implements KeyingBase.UserInterface
{
  OnlineVideoARRenderable$1(OnlineVideoARRenderable paramOnlineVideoARRenderable) {}
  
  public void a()
  {
    GLES20.glUniform1i(OnlineVideoARRenderable.a(this.a), OnlineVideoARRenderable.b(this.a));
  }
  
  public void a(int paramInt)
  {
    OnlineVideoARRenderable.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.1
 * JD-Core Version:    0.7.0.1
 */