package com.peterlmeng.animate_image.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.peterlmeng.animate_image.R.raw;
import com.peterlmeng.animate_image.bitmaptexture.ShaderUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class BitmapTexture
{
  static final int COORDS_PER_VERTEX = 3;
  private static final String TAG = "BitmapTexture";
  static float[] textureData = { 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  static float[] vertexData = { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private int afPosition;
  private int avPosition;
  Bitmap bitmap;
  private Context context;
  private int program;
  private FloatBuffer textureBuffer;
  private int textureId;
  private FloatBuffer vertexBuffer;
  private final int vertexCount;
  private final int vertexStride;
  
  public BitmapTexture(Context paramContext)
  {
    float[] arrayOfFloat = vertexData;
    this.vertexCount = (arrayOfFloat.length / 3);
    this.vertexStride = 12;
    this.context = paramContext;
    this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertexData);
    this.vertexBuffer.position(0);
    this.textureBuffer = ByteBuffer.allocateDirect(textureData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(textureData);
    this.textureBuffer.position(0);
  }
  
  public BitmapTexture(Context paramContext, Bitmap paramBitmap)
  {
    float[] arrayOfFloat = vertexData;
    this.vertexCount = (arrayOfFloat.length / 3);
    this.vertexStride = 12;
    this.context = paramContext;
    this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertexData);
    this.vertexBuffer.position(0);
    this.textureBuffer = ByteBuffer.allocateDirect(textureData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(textureData);
    this.textureBuffer.position(0);
    this.bitmap = paramBitmap;
  }
  
  public void dispose()
  {
    GLES20.glClear(16384);
    GLES20.glDeleteTextures(1, new int[] { this.textureId }, 0);
    GLES20.glDeleteProgram(this.program);
    GLES20.glFlush();
  }
  
  public void draw()
  {
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.program);
    GLES20.glEnableVertexAttribArray(this.avPosition);
    GLES20.glEnableVertexAttribArray(this.afPosition);
    GLES20.glVertexAttribPointer(this.avPosition, 3, 5126, false, 12, this.vertexBuffer);
    GLES20.glVertexAttribPointer(this.afPosition, 3, 5126, false, 12, this.textureBuffer);
    GLES20.glDrawArrays(5, 0, this.vertexCount);
    GLES20.glDisableVertexAttribArray(this.avPosition);
    GLES20.glDisableVertexAttribArray(this.afPosition);
    GLES20.glBindTexture(3553, 0);
    this.bitmap = null;
  }
  
  public void onSurfaceCreated()
  {
    this.program = ShaderUtil.createProgram(ShaderUtil.readRawTxt(this.context, R.raw.vertex_shader), ShaderUtil.readRawTxt(this.context, R.raw.fragment_shader));
    int i = this.program;
    if (i > 0)
    {
      this.avPosition = GLES20.glGetAttribLocation(i, "av_Position");
      this.afPosition = GLES20.glGetAttribLocation(this.program, "af_Position");
      Object localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      if (localObject[0] == 0) {
        return;
      }
      this.textureId = localObject[0];
      GLES20.glBindTexture(3553, this.textureId);
      GLES20.glTexParameteri(3553, 10242, 10497);
      GLES20.glTexParameteri(3553, 10243, 10497);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
      localObject = this.bitmap;
      if (localObject == null) {
        return;
      }
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
    }
  }
  
  public void updateBitmap(Bitmap paramBitmap)
  {
    GLES20.glBindTexture(3553, this.textureId);
    GLUtils.texSubImage2D(3553, 0, 0, 0, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */