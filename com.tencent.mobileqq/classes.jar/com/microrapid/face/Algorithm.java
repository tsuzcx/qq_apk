package com.microrapid.face;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;
import com.tencent.util.FileEncryptUtils;
import com.tencent.util.IOUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Algorithm
{
  public static final int AUTO_ENLARGE_EYE_MASK = 4;
  public static final int AUTO_EYE_MASK = 1;
  public static final int AUTO_FACE_MASK = 0;
  public static final int AUTO_FLASH_FACE_NORMAL = 9;
  public static final int AUTO_FLASH_FACE_STRONG = 10;
  public static final int AUTO_MOUTH_MASK = 2;
  public static final int AUTO_PERFECT_SKIN = 11;
  public static final int AUTO_RESOURCE_ALL = 12;
  public static final int AUTO_SLIM_FACE_MASK = 3;
  public static final int AUTO_SLIM_FACE_MASK2 = 5;
  public static final int AUTO_SLIM_FACE_MASK_MODEL1H = 6;
  public static final int AUTO_SLIM_FACE_MASK_MODEL1V = 7;
  public static final int AUTO_SLIM_FACE_MASK_MODEL3 = 8;
  static boolean prepared = false;
  
  public static native void BlendBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static void clearMask()
  {
    nativeClear();
    prepared = false;
  }
  
  public static void initial()
  {
    if (prepared) {
      return;
    }
    prepared = true;
    loadMaskFile("face/face_mask.jpg", 0);
    loadMaskFile("face/single_eye_mask_2.jpg", 1);
    loadMaskFile("face/mouse_mask.jpg", 2);
    loadRawFile("face/distort_curve_n.raw", 3, 127, 199);
    loadRawBitmapFile("face/enlarge_eye_tmpl_n.bmp", 4);
    loadPerfectSkinFile("face/perfectskin.png", 11);
    loadRawFile("face/distort_curvex_1h.raw", 6, 127, 199);
    loadRawFile("face/distort_curvex_1v.raw", 7, 199, 127);
    loadRawFile("face/distort_curvex_3.raw", 8, 127, 199);
    loadFaceFlashFile();
  }
  
  private static void loadFaceFlashFile()
  {
    Bitmap localBitmap = FilterDefault.decodeBitmap("face/face_flash_normal.jpg");
    byte[] arrayOfByte = new byte[768];
    int i = 0;
    int j;
    while (i < 256)
    {
      j = localBitmap.getPixel(i, 32);
      arrayOfByte[(i * 3 + 0)] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[(i * 3 + 1)] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[(i * 3 + 2)] = ((byte)(j & 0xFF));
      i += 1;
    }
    nativeSetMask(arrayOfByte, 256, 1, 3, 9);
    localBitmap.recycle();
    localBitmap = FilterDefault.decodeBitmap("face/face_flash_strong.jpg");
    i = 0;
    while (i < 256)
    {
      j = localBitmap.getPixel(i, 32);
      arrayOfByte[(i * 3 + 0)] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[(i * 3 + 1)] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[(i * 3 + 2)] = ((byte)(j & 0xFF));
      i += 1;
    }
    nativeSetMask(arrayOfByte, 256, 1, 3, 10);
    localBitmap.recycle();
  }
  
  private static void loadMaskFile(String paramString, int paramInt)
  {
    byte[] arrayOfByte = null;
    try
    {
      paramString = FilterDefault.decodeBitmap(paramString);
      if (paramString == null) {
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
      arrayOfByte = new byte[paramString.getWidth() * paramString.getHeight()];
      int i = 0;
      while (i < paramString.getHeight())
      {
        int j = 0;
        while (j < paramString.getWidth())
        {
          arrayOfByte[(paramString.getWidth() * i + j)] = ((byte)paramString.getPixel(j, i));
          j += 1;
        }
        i += 1;
      }
      nativeSetMask(arrayOfByte, paramString.getWidth(), paramString.getHeight(), 1, paramInt);
      paramString.recycle();
    }
  }
  
  private static void loadPerfectSkinFile(String paramString, int paramInt)
  {
    paramString = FilterDefault.decodeBitmap(paramString, Bitmap.Config.ARGB_8888);
    LogUtil.i("bitmap.getConfig() = ", "" + paramString.getConfig());
    if (paramString.getConfig() == Bitmap.Config.ARGB_8888) {
      nativeSetSkinMask(paramString, paramInt);
    }
    paramString.recycle();
  }
  
  private static void loadRawBitmapFile(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[26];
    int j = -1;
    int i = -1;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      InputStream localInputStream = FilterDefault.getInputStreamByName(paramString);
      localObject1 = localObject3;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      try
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localObject1 = new ByteArrayInputStream(paramString);
      paramString = localObject2;
      if (((InputStream)localObject1).read(arrayOfByte) != 26) {
        break label141;
      }
      int k = trans2Int(arrayOfByte, 10);
      j = trans2Int(arrayOfByte, 18);
      i = trans2Int(arrayOfByte, 22);
      paramString = new byte[j * i];
      ((InputStream)localObject1).skip(k - 26);
      ((InputStream)localObject1).read(paramString);
      label141:
      IOUtils.closeQuietly((InputStream)localObject1);
      nativeSetMask(paramString, j, i, 1, paramInt);
    }
    if (paramString == null) {
      return;
    }
  }
  
  private static void loadRawFile(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramString = FilterDefault.getInputStreamByName(paramString);
      byte[] arrayOfByte = new byte[paramInt2 * paramInt3];
      paramString.read(arrayOfByte);
      IOUtils.closeQuietly(paramString);
      nativeSetMask(arrayOfByte, paramInt2, paramInt3, 1, paramInt1);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static native long nativeAutoFaceHandle();
  
  public static native void nativeCleanUp(long paramLong);
  
  public static native void nativeClear();
  
  public static native void nativeClearAutoPramChanged(long paramLong, int paramInt);
  
  public static native void nativeDispose(long paramLong);
  
  public static native double nativeGetAutoParam(long paramLong, int paramInt);
  
  public static native QImage nativeGetBeginImage(long paramLong);
  
  public static native void nativeGetEyeMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native void nativeGetFaceMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native void nativeGetPouchMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native boolean nativeIsAutoPramChanged(long paramLong, int paramInt);
  
  public static native boolean nativeIsInitMak(long paramLong);
  
  public static native void nativePreProcessImage(long paramLong);
  
  public static native void nativeProcessBitmap(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetAutoParam(long paramLong, int paramInt, double paramDouble);
  
  public static native void nativeSetBitmap(long paramLong, Bitmap paramBitmap);
  
  public static native boolean nativeSetContrastON(long paramLong, boolean paramBoolean);
  
  public static native boolean nativeSetCpuSmoothenOn(long paramLong, boolean paramBoolean);
  
  public static native void nativeSetEyeMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetFaceFeatures(long paramLong, int[][] paramArrayOfInt);
  
  public static native void nativeSetFaceInfo(long paramLong, MRect paramMRect1, MRect paramMRect2, MRect paramMRect3, MRect paramMRect4);
  
  public static native void nativeSetFaceMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetLipsMak(long paramLong, Bitmap paramBitmap, MRect paramMRect);
  
  public static native void nativeSetMask(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void nativeSetPouchMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetSkinMask(Bitmap paramBitmap, int paramInt);
  
  public static native void nativeSmoothFace14(QImage paramQImage, float paramFloat);
  
  public static native void nativeSmoothImage(long paramLong, QImage paramQImage);
  
  public static native void nativeSurfaceBlurAndSmoothmage(QImage paramQImage, int paramInt);
  
  public static native void nativesetGlossyImage(long paramLong, QImage paramQImage);
  
  private static int trans2Int(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInt[i] = (paramArrayOfByte[(paramInt + i)] & 0xFF);
      i += 1;
    }
    return arrayOfInt[0] | arrayOfInt[1] << 8 | arrayOfInt[2] << 16 | arrayOfInt[3] << 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.face.Algorithm
 * JD-Core Version:    0.7.0.1
 */