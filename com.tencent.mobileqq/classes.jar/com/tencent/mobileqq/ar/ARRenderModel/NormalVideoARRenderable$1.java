package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.keying.KeyingBase.UserInterface;

class NormalVideoARRenderable$1
  implements KeyingBase.UserInterface
{
  NormalVideoARRenderable$1(NormalVideoARRenderable paramNormalVideoARRenderable) {}
  
  public void a()
  {
    GLES20.glUniform1i(NormalVideoARRenderable.a(this.a), NormalVideoARRenderable.b(this.a));
  }
  
  public void a(int paramInt)
  {
    NormalVideoARRenderable.a(this.a, GLES20.glGetUniformLocation(paramInt, "uDisplayType"));
    ARVideoUtil.a("glGetUniformLocation uDisplayType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARRenderable.1
 * JD-Core Version:    0.7.0.1
 */