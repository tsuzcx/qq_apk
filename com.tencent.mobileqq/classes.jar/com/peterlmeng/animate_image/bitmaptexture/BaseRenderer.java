package com.peterlmeng.animate_image.bitmaptexture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import javax.microedition.khronos.opengles.GL10;

public class BaseRenderer
{
  public boolean isReadCurrentFrame = false;
  protected int outputHeight = 0;
  protected int outputWidth = 0;
  protected int program = 0;
  public boolean rendererCallback = false;
  
  protected int getAttrib(String paramString)
  {
    return GLES20.glGetAttribLocation(this.program, paramString);
  }
  
  protected int getUniform(String paramString)
  {
    return GLES20.glGetUniformLocation(this.program, paramString);
  }
  
  protected void makeProgram(String paramString1, String paramString2)
  {
    this.program = ShaderHelper.linkProgram(ShaderHelper.compileVertexShader(paramString1), ShaderHelper.compileFragmentShader(paramString2));
    ShaderHelper.validateProgram(this.program);
    GLES20.glUseProgram(this.program);
  }
  
  public void onClick() {}
  
  protected void onReadPixel(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isReadCurrentFrame) {
      return;
    }
    this.isReadCurrentFrame = false;
    GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, ByteBuffer.allocate(paramInt3 * paramInt4 * 4));
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  protected Bitmap readPixel(int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 4);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.bitmaptexture.BaseRenderer
 * JD-Core Version:    0.7.0.1
 */