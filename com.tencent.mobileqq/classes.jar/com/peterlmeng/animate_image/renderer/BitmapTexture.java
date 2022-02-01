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
  private final int vertexCount = vertexData.length / 3;
  private final int vertexStride = 12;
  
  public BitmapTexture(Context paramContext)
  {
    this.context = paramContext;
    this.vertexBuffer = ByteBuffer.allocateDirect(vertexData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertexData);
    this.vertexBuffer.position(0);
    this.textureBuffer = ByteBuffer.allocateDirect(textureData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(textureData);
    this.textureBuffer.position(0);
  }
  
  public BitmapTexture(Context paramContext, Bitmap paramBitmap)
  {
    this.context = paramContext;
    this.vertexBuffer = ByteBuffer.allocateDirect(vertexData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertexData);
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
    int[] arrayOfInt;
    if (this.program > 0)
    {
      this.avPosition = GLES20.glGetAttribLocation(this.program, "av_Position");
      this.afPosition = GLES20.glGetAttribLocation(this.program, "af_Position");
      arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      if (arrayOfInt[0] != 0) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      this.textureId = arrayOfInt[0];
      GLES20.glBindTexture(3553, this.textureId);
      GLES20.glTexParameteri(3553, 10242, 10497);
      GLES20.glTexParameteri(3553, 10243, 10497);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
    } while (this.bitmap == null);
    GLUtils.texImage2D(3553, 0, this.bitmap, 0);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
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