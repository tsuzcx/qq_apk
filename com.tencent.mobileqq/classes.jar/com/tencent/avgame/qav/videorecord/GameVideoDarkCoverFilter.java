package com.tencent.avgame.qav.videorecord;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class GameVideoDarkCoverFilter
  extends GPUImageFilter
{
  private int k;
  
  public GameVideoDarkCoverFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision mediump float;\nuniform vec4 coverColor;\nvoid main()\n{\n\tgl_FragColor = coverColor;\n}");
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(new GameVideoDarkCoverFilter.1(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (!f()) {
      a();
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(this.e);
    j();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.f);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.f);
    k();
  }
  
  public void b()
  {
    super.b();
    this.k = GLES20.glGetUniformLocation(this.e, "coverColor");
  }
  
  public void l()
  {
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    a(-1, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameVideoDarkCoverFilter
 * JD-Core Version:    0.7.0.1
 */