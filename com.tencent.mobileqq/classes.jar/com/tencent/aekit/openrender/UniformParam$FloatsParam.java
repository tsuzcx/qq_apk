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
    paramInt = this.value.length;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 9)
            {
              if (paramInt != 16)
              {
                paramInt = this.handle;
                float[] arrayOfFloat = this.value;
                GLES20.glUniform1fv(paramInt, arrayOfFloat.length, arrayOfFloat, 0);
              }
              else
              {
                GLES20.glUniformMatrix4fv(this.handle, 1, false, this.value, 0);
              }
            }
            else {
              GLES20.glUniformMatrix3fv(this.handle, 1, false, this.value, 0);
            }
          }
          else {
            GLES20.glUniform4fv(this.handle, 1, this.value, 0);
          }
        }
        else {
          GLES20.glUniform3fv(this.handle, 1, this.value, 0);
        }
      }
      else {
        GLES20.glUniform2fv(this.handle, 1, this.value, 0);
      }
    }
    else {
      GLES20.glUniform1f(this.handle, this.value[0]);
    }
    GlUtil.checkGlError("FloatsParam setParams");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" = ");
    localStringBuilder.append(Arrays.toString(this.value));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.FloatsParam
 * JD-Core Version:    0.7.0.1
 */