package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.aekit.openrender.util.ProgramTools.ProgramInfo;

public class Shader
{
  private int fragmentShaderId;
  private final String fragmentShaderSource;
  private int shaderProgram = 0;
  private int vertexShaderId;
  private final String vertexShaderSource;
  
  public Shader(String paramString1, String paramString2)
  {
    this.fragmentShaderSource = paramString2;
    this.vertexShaderSource = paramString1;
  }
  
  public void bind()
  {
    GLES20.glUseProgram(this.shaderProgram);
    GlUtil.checkGlError("glUseProgram:" + this.shaderProgram);
  }
  
  public void clear()
  {
    GLES20.glDeleteShader(this.vertexShaderId);
    GLES20.glDeleteShader(this.fragmentShaderId);
    GLES20.glDeleteProgram(this.shaderProgram);
    this.shaderProgram = 0;
  }
  
  public void compile()
  {
    if (this.shaderProgram == 0)
    {
      ProgramTools.ProgramInfo localProgramInfo = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource);
      if (localProgramInfo != null)
      {
        this.shaderProgram = localProgramInfo.programId;
        this.vertexShaderId = localProgramInfo.vertextShaderId;
        this.fragmentShaderId = localProgramInfo.fragShaderId;
      }
    }
  }
  
  String getFragmentShaderSource()
  {
    return this.fragmentShaderSource;
  }
  
  public int getShaderProgram()
  {
    return this.shaderProgram;
  }
  
  String getVertexShaderSource()
  {
    return this.vertexShaderSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.Shader
 * JD-Core Version:    0.7.0.1
 */