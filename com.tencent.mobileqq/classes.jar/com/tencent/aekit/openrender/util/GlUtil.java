package com.tencent.aekit.openrender.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.ETC1Util;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class GlUtil
{
  public static final float[] EMPTY_POSITIONS;
  public static final float[] EMPTY_POSITIONS_TRIANGLES;
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final float[] IDENTITY_MATRIX;
  public static final int NO_TEXTURE = -1;
  public static final float[] ORIGIN_POSITION_COORDS;
  public static final float[] ORIGIN_TEX_COORDS;
  public static final float[] ORIGIN_TEX_COORDS_REVERSE;
  public static final float[] ORIGIN_TEX_COORDS_TRIANGLES;
  private static final int SIZEOF_FLOAT = 4;
  public static final String TAG = GlUtil.class.getSimpleName();
  private static AtomicInteger blendModeRef = new AtomicInteger(0);
  public static boolean curBlendModeEnabled;
  private static boolean enableLog;
  
  static
  {
    EMPTY_POSITIONS = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    EMPTY_POSITIONS_TRIANGLES = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    ORIGIN_POSITION_COORDS = new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
    ORIGIN_TEX_COORDS = new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    ORIGIN_TEX_COORDS_REVERSE = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    ORIGIN_TEX_COORDS_TRIANGLES = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    IDENTITY_MATRIX = new float[16];
    Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    enableLog = true;
  }
  
  @TargetApi(18)
  public static void checkEglError(String paramString)
  {
    if (!enableLog) {
      return;
    }
    for (;;)
    {
      int i = EGL14.eglGetError();
      if (i == 12288) {
        break;
      }
      Log.e(TAG, paramString + ": eglGetError: 0x" + Integer.toHexString(i));
    }
  }
  
  public static void checkGlError(String paramString)
  {
    if (!enableLog) {}
    for (;;)
    {
      return;
      int i = GLES20.glGetError();
      if (i != 0)
      {
        Log.e(TAG, paramString + ": glError " + i);
        paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
        int j = paramString.length;
        i = 0;
        while (i < j)
        {
          Object localObject = paramString[i];
          Log.e(TAG, localObject.toString());
          i += 1;
        }
      }
    }
  }
  
  public static void createEtcTexture(int[] paramArrayOfInt)
  {
    int i = 0;
    GLES20.glGenTextures(paramArrayOfInt.length, paramArrayOfInt, 0);
    while (i < paramArrayOfInt.length)
    {
      GLES20.glBindTexture(3553, paramArrayOfInt[i]);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      i += 1;
    }
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createImageTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    checkGlError("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
    return i;
  }
  
  public static FloatBuffer createSquareVtx()
  {
    float[] arrayOfFloat = new float[20];
    arrayOfFloat[0] = -1.0F;
    arrayOfFloat[1] = 1.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = -1.0F;
    arrayOfFloat[6] = -1.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 1.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 1.0F;
    arrayOfFloat[14] = 1.0F;
    arrayOfFloat[15] = 1.0F;
    arrayOfFloat[16] = -1.0F;
    arrayOfFloat[17] = 0.0F;
    arrayOfFloat[18] = 1.0F;
    arrayOfFloat[19] = 0.0F;
    arrayOfFloat;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createTexture(int paramInt)
  {
    return createTexture(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    checkGlError("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    checkGlError("glBindTexture " + arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    checkGlError("glTexParameter");
    return arrayOfInt[0];
  }
  
  @TargetApi(18)
  public static int createTextureAllocate(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = createTexture(3553);
    if (paramBoolean) {
      GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      return i;
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
  }
  
  public static void deleteTexture(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static void glBindTexture(int paramInt1, int paramInt2)
  {
    GLES20.glBindTexture(paramInt1, paramInt2);
    if (paramInt1 == 3553) {}
  }
  
  public static void glDeleteTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public static void glGenTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    GLES20.glGenTextures(paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public static void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    GLES20.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
  }
  
  public static boolean isEnableLog()
  {
    return enableLog;
  }
  
  public static void loadTexture(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      GLES20.glBindTexture(3553, paramInt);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
    }
  }
  
  public static void loadTexture(int paramInt, ETC1Util.ETC1Texture paramETC1Texture)
  {
    if (paramETC1Texture != null)
    {
      GLES20.glBindTexture(3553, paramInt);
      ETC1Util.loadTexture(3553, 0, 0, 6407, 33635, paramETC1Texture);
    }
  }
  
  public static void loadTexture(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt4, paramInt2, paramInt3, 0, paramInt4, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
  }
  
  public static void logVersionInfo()
  {
    Log.i(TAG, "vendor  : " + GLES20.glGetString(7936));
    Log.i(TAG, "renderer: " + GLES20.glGetString(7937));
    Log.i(TAG, "version : " + GLES20.glGetString(7938));
  }
  
  public static void resetFilterCoords(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {
      return;
    }
    paramVideoFilterBase.setTexCords(AEOpenRenderConfig.ORIGIN_POSITION_COORDS);
    paramVideoFilterBase.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
  }
  
  public static Bitmap saveTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    checkGlError("glReadPixels");
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[paramInt2 * paramInt3 * 4]);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    checkGlError("glBindFramebuffer");
    return localBitmap;
  }
  
  public static Bitmap saveTexture(Frame paramFrame)
  {
    return saveTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt6);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(paramInt2, paramInt3, paramInt4, paramInt5, 6408, 5121, paramArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt4);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, paramArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
  }
  
  public static void setBlendMode(boolean paramBoolean)
  {
    curBlendModeEnabled = paramBoolean;
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  public static void setBlendModeSrcAlpha(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  public static void setEnableLog(boolean paramBoolean)
  {
    enableLog = paramBoolean;
  }
  
  public static void texImage2D(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4)
  {
    GLUtils.texImage2D(paramInt1, paramInt2, paramInt3, paramBitmap, paramInt4);
  }
  
  public static void texImage2D(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, int paramInt5)
  {
    GLUtils.texImage2D(paramInt1, paramInt2, paramInt3, paramBitmap, paramInt4, paramInt5);
  }
  
  public static void texImage2D(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    GLUtils.texImage2D(paramInt1, paramInt2, paramBitmap, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.GlUtil
 * JD-Core Version:    0.7.0.1
 */