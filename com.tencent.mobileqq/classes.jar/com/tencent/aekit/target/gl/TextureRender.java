package com.tencent.aekit.target.gl;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureRender
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private static final String VERTEX_SHADER = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
  private final String TAG;
  private float[] mMVPMatrix;
  private int mProgram;
  private FloatBuffer mTriangleVertices;
  private float[] mTriangleVerticesData;
  private int maPositionHandle;
  private int maTextureHandle;
  
  public TextureRender()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureRender-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.mTriangleVerticesData = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.mMVPMatrix = new float[16];
    this.mProgram = 0;
    this.maPositionHandle = 0;
    this.maTextureHandle = 0;
    this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    int k = loadShader(35632, paramString2);
    int j = GLES20.glCreateProgram();
    GLES20.glAttachShader(j, i);
    GLES20.glAttachShader(j, k);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    i = j;
    if (paramString1[0] != 1)
    {
      LogUtils.e(this.TAG, "Could not link program:");
      LogUtils.e(this.TAG, GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      i = 0;
    }
    return i;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      paramString = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not compile shader(TYPE=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("):");
      LogUtils.e(paramString, localStringBuilder.toString());
      LogUtils.e(this.TAG, GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public void drawFrame(int paramInt)
  {
    System.currentTimeMillis();
    GLES20.glUseProgram(this.mProgram);
    GlUtil.checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    this.mTriangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
    GlUtil.checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
    this.mTriangleVertices.position(3);
    GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, this.mTriangleVertices);
    GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
    GLES20.glDrawArrays(5, 0, 4);
    GlUtil.checkGlError("glDrawArrays");
  }
  
  public void prepare()
  {
    this.mProgram = createProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int i = this.mProgram;
    if (i != 0)
    {
      this.maPositionHandle = GLES20.glGetAttribLocation(i, "aPosition");
      GlUtil.checkGlError("glGetAttribLocation aPosition");
      if (this.maPositionHandle != -1)
      {
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        GlUtil.checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle != -1) {
          return;
        }
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    throw new RuntimeException("failed creating program");
  }
  
  public void release()
  {
    int i = this.mProgram;
    if (i != 0)
    {
      GLES20.glDeleteProgram(i);
      this.mProgram = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.target.gl.TextureRender
 * JD-Core Version:    0.7.0.1
 */