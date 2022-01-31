package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import java.util.Arrays;

public class UniformParam$FloatsParam
  extends UniformParam
{
  float[] value;
  
  public UniformParam$FloatsParam(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    this.value = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.value[i] = paramArrayOfFloat[i];
      i += 1;
    }
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    switch (this.value.length)
    {
    default: 
      GLES20.glUniform1fv(this.handle, this.value.length, this.value, 0);
    }
    for (;;)
    {
      GlUtil.checkGlError("FloatsParam setParams");
      return;
      GLES20.glUniform1f(this.handle, this.value[0]);
      continue;
      GLES20.glUniform2fv(this.handle, 1, this.value, 0);
      continue;
      GLES20.glUniform3fv(this.handle, 1, this.value, 0);
      continue;
      GLES20.glUniform4fv(this.handle, 1, this.value, 0);
      continue;
      GLES20.glUniformMatrix3fv(this.handle, 1, false, this.value, 0);
      continue;
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.value, 0);
    }
  }
  
  public String toString()
  {
    return this.name + " = " + Arrays.toString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.FloatsParam
 * JD-Core Version:    0.7.0.1
 */