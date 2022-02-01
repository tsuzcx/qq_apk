package com.tencent.aelight.camera.ae.camera.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import java.nio.FloatBuffer;

public class ScaleFilter
  extends VideoFilterBase
{
  public ScaleFilter(String paramString)
  {
    super(paramString);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9728.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glUniformMatrix4fv(this.mFilterProjHandle, 1, false, FloatBuffer.wrap(this.mFilterProjMat));
    GLES20.glUniformMatrix4fv(this.mFilterViewHandle, 1, false, FloatBuffer.wrap(this.mFilterViewMat));
    GLES20.glUniformMatrix4fv(this.mTMatHandle, 1, false, FloatBuffer.wrap(this.mTMat));
    GLES20.glDrawArrays(6, 0, 4);
    GLES20.glFlush();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.ScaleFilter
 * JD-Core Version:    0.7.0.1
 */