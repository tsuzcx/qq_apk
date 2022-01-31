package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.util.BitmapUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;

public class CosmeticsHandle
{
  public static final int COS_AGING_OLDER = 30;
  public static final int COS_ALL = 99;
  public static final int COS_BACKIMAGE = 40;
  public static final int COS_BALD_HEAD = 29;
  public static final int COS_BASIC = 0;
  public static final int COS_BLUSH = 11;
  public static final int COS_BROWSHAPING = 14;
  public static final int COS_CG = 39;
  public static final int COS_CONTOUR = 27;
  public static final int COS_CONTOUR_LIGHT = 36;
  public static final int COS_CONTOUR_SHADOW = 37;
  public static final int COS_DOUBLEEYELID = 15;
  public static final int COS_EYEBROW = 13;
  public static final int COS_EYELASH = 6;
  public static final int COS_EYELINE = 4;
  private static final int COS_EYELINE_DOWN = 5;
  public static final int COS_FOREHEAD = 16;
  public static final int COS_GLASSES = 26;
  public static final int COS_HAIR = 12;
  public static final int COS_HAIR2 = 31;
  public static final int COS_HAIRLINES = 34;
  public static final int COS_HEAD = 25;
  public static final int COS_HIGHLIGHT = 21;
  public static final int COS_IRIS = 9;
  private static final int COS_LASH_DOWN = 7;
  public static final int COS_LEFTEYE = 17;
  public static final int COS_LIPS = 1;
  public static final int COS_LIP_DEPTH = 8;
  public static final int COS_LIP_HIGH = 38;
  public static final int COS_MOUSE = 19;
  public static final int COS_NONE = 41;
  public static final int COS_NOSE = 2;
  public static final int COS_PASTE_EYE_LEFT = 32;
  public static final int COS_PASTE_EYE_RIGHT = 33;
  public static final int COS_REMOVE_MOLES = 10;
  public static final int COS_RIGHTEYE = 18;
  public static final int COS_SHADOW = 3;
  public static final int COS_SMILE = 23;
  public static final int COS_SMOOTH = 20;
  public static final int COS_WHITENTOOTH = 22;
  public static final int COS_WHOLEFACE = 24;
  public static final int COS_WHOLE_EYE = 28;
  public static final int COS_WOCAN_EYE = 35;
  private static final int RSS_TYPE_BitLipsModel = 128;
  private static final int RSS_TYPE_CGHairLines = 256;
  private static final int RSS_TYPE_FaceModel = 1;
  private static final int RSS_TYPE_HairModel = 16;
  private static final int RSS_TYPE_LipsHLModel = 512;
  private static final int RSS_TYPE_LipsWaterModel = 8;
  private static final int RSS_TYPE_NONE = 0;
  private static final int RSS_TYPE_NoseModel = 4;
  private static final int RSS_TYPE_STRIPEHAIRModel = 64;
  private static final int RSS_TYPE_SkinYCBRModel = 2;
  private static final int RSS_TYPE_WOCANModel = 32;
  private boolean available = false;
  private QImage mSrcImage = null;
  private final long nativeObj = nativeCosmeticsProcess();
  
  private void checkCosModel()
  {
    int i = nativeIsNeedRestModel(this.nativeObj);
    if ((i & 0x1) == 1) {
      setModelFromList(new String[] { "face_highlight.png", "face_shadow.png" }, 1);
    }
    if ((i & 0x2) == 2) {
      setModelFromList(new String[] { "skin.png" }, 2);
    }
    if ((i & 0x4) == 4) {
      setModelFromList(new String[] { "bridge_highlight.png", "bridge_shadow.png" }, 4);
    }
    if ((i & 0x20) == 32) {
      setModelFromList(new String[] { "wocan.png" }, 32);
    }
    if ((i & 0x8) == 8) {
      setModelFromList(new String[] { "lipsWater.png" }, 8);
    }
    if ((i & 0x200) == 512) {
      setModelFromList(new String[] { "lipsHL.png" }, 512);
    }
    if ((i & 0x10) == 16) {
      setModelFromList(new String[] { "hair_tmpl0.jpg", "hair_tmpl1.jpg", "hair_tmpl2.jpg" }, 16);
    }
    if ((i & 0x40) == 64) {
      setModelFromList(new String[] { "hairstripe_1.png" }, 64);
    }
    if ((i & 0x80) == 128) {
      setModelFromList(new String[] { "bitlip.png" }, 128);
    }
  }
  
  private void checkavailable()
  {
    if ((!this.available) || (this.nativeObj == 0L)) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private int distance(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (int)Math.sqrt(Math.abs(paramInt1 - paramInt3) * Math.abs(paramInt1 - paramInt3) + Math.abs(paramInt2 - paramInt4) * Math.abs(paramInt2 - paramInt4));
  }
  
  public static void locateIrisFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2, int[] paramArrayOfInt1)
  {
    nativeLocateIrisFast(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramArrayOfInt1);
  }
  
  private static native boolean nativeCanManualRedo(long paramLong, int paramInt);
  
  private static native boolean nativeCanManualUndo(long paramLong, int paramInt);
  
  private static native boolean nativeCheckIsAllDisable(long paramLong);
  
  private static native void nativeClearComseticCache(long paramLong, int paramInt);
  
  private static native void nativeClearCosmeticMask(long paramLong, int paramInt);
  
  private static native void nativeCosmetic(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private static native long nativeCosmeticsProcess();
  
  private static native void nativeDisableAllCosmetic(long paramLong);
  
  private static native void nativeDisableCosmetic(long paramLong, int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeFineTuneFeatures(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native double nativeGetCosAlpha(long paramLong, int paramInt);
  
  private static native int nativeGetCosParamWithIndex(long paramLong, int paramInt1, int paramInt2);
  
  private static native int[][] nativeGetFaceFeatures(long paramLong);
  
  private static native int nativeGetHairType(long paramLong);
  
  private static native double nativeGetLastSmoothMag(long paramLong);
  
  private static native void nativeGetSkinMaskBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeInitCosModel(long paramLong, int paramInt, Bitmap[] paramArrayOfBitmap);
  
  private static native int nativeIsNeedRestModel(long paramLong);
  
  private static native void nativeLanderBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeLocateIrisFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2, int[] paramArrayOfInt1);
  
  private static native void nativeManualAcceptAdjust(long paramLong, int paramInt);
  
  private static native void nativeManualCancelAdjust(long paramLong, int paramInt);
  
  private static native void nativeManualRedo(long paramLong, int paramInt);
  
  private static native void nativeManualUndo(long paramLong, int paramInt);
  
  private static native boolean nativePreProcessImage(long paramLong, int paramInt);
  
  private static native void nativeRSSColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeResetALLCosAlpha(long paramLong);
  
  private static native void nativeSegmentLipsFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2);
  
  private static native void nativeSetAutoBodyMask(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeSetAutoHairMask(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeSetBitmap(long paramLong, QImage paramQImage);
  
  private static native void nativeSetCosAlpha(long paramLong, double paramDouble, int paramInt);
  
  private static native int nativeSetCosParamWithIndex(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeSetFaceCount(long paramLong, int paramInt);
  
  private static native void nativeSetFaceFeatures(long paramLong, int[][] paramArrayOfInt);
  
  private static native void nativeSetHairMask(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private static native void nativeSetHairRecolorType(long paramLong, int paramInt);
  
  private static native void nativeSetLastSmoothMag(long paramLong, double paramDouble);
  
  private static native void nativeSetMaxBasicMag(long paramLong, double paramDouble);
  
  private static native void nativeSetMaxSmoothMag(long paramLong, double paramDouble);
  
  private static native void nativeSetRss(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  private static native void nativeSetUseGpuSmooth(long paramLong, boolean paramBoolean);
  
  public static void segmentLipsFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    nativeSegmentLipsFast(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2);
  }
  
  private void setModelFromList(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return;
      int k = paramArrayOfString.length;
      Bitmap[] arrayOfBitmap = new Bitmap[k];
      int j = 1;
      int i = 0;
      while (i < k)
      {
        arrayOfBitmap[i] = FilterDefault.decodeBitmap("cos/" + paramArrayOfString[i]);
        if (arrayOfBitmap[i] == null) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        nativeInitCosModel(this.nativeObj, paramInt, arrayOfBitmap);
      }
      paramInt = 0;
      while (paramInt < k)
      {
        BitmapUtils.recycle(arrayOfBitmap[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  public boolean canManualRedo(int paramInt)
  {
    checkavailable();
    return nativeCanManualRedo(this.nativeObj, paramInt);
  }
  
  public boolean canManualUndo(int paramInt)
  {
    checkavailable();
    return nativeCanManualUndo(this.nativeObj, paramInt);
  }
  
  public boolean checkIsAllDisable()
  {
    checkavailable();
    return nativeCheckIsAllDisable(this.nativeObj);
  }
  
  public void clearComseticCache(int paramInt)
  {
    checkavailable();
    nativeClearComseticCache(this.nativeObj, paramInt);
  }
  
  public void clearCosmeticMask(int paramInt)
  {
    checkavailable();
    nativeClearCosmeticMask(this.nativeObj, paramInt);
  }
  
  public void cosmeticProcess(Bitmap paramBitmap)
  {
    checkavailable();
    checkCosModel();
    nativePreProcessImage(this.nativeObj, 99);
    nativeCosmetic(this.nativeObj, paramBitmap, 99);
  }
  
  public void cosmeticProcessByAdjust(Bitmap paramBitmap, int paramInt)
  {
    checkavailable();
    nativeCosmetic(this.nativeObj, paramBitmap, paramInt);
  }
  
  public void disableAllCosmetic()
  {
    checkavailable();
    nativeDisableAllCosmetic(this.nativeObj);
  }
  
  public void disableCosmetic(int paramInt)
  {
    checkavailable();
    nativeDisableCosmetic(this.nativeObj, paramInt);
  }
  
  public void dispose()
  {
    if (this.available)
    {
      LogUtil.v("filter", "cosmeticProcess dispose");
      nativeDispose(this.nativeObj);
      this.available = false;
      if (this.mSrcImage != null) {
        this.mSrcImage.Dispose();
      }
      this.mSrcImage = null;
    }
  }
  
  public void fineTuneFeatures(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    checkavailable();
    nativeFineTuneFeatures(this.nativeObj, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public double getCosAlpha(int paramInt)
  {
    checkavailable();
    return nativeGetCosAlpha(this.nativeObj, paramInt);
  }
  
  public int getCosParamWithIndex(int paramInt1, int paramInt2)
  {
    checkavailable();
    return nativeGetCosParamWithIndex(this.nativeObj, paramInt1, paramInt2);
  }
  
  public int[][] getFaceFeatures()
  {
    checkavailable();
    return nativeGetFaceFeatures(this.nativeObj);
  }
  
  public int getHairType()
  {
    checkavailable();
    return nativeGetHairType(this.nativeObj);
  }
  
  public double getLastSmoothMag()
  {
    checkavailable();
    return nativeGetLastSmoothMag(this.nativeObj);
  }
  
  public void initHairMask()
  {
    setModelFromList(new String[] { "hair_tmpl0.jpg", "hair_tmpl1.jpg", "hair_tmpl2.jpg" }, 16);
  }
  
  public void landerBitmap(Bitmap paramBitmap)
  {
    checkavailable();
    nativeLanderBitmap(this.nativeObj, paramBitmap);
  }
  
  public void manualAcceptAdjust(int paramInt)
  {
    checkavailable();
    nativeManualAcceptAdjust(this.nativeObj, paramInt);
  }
  
  public void manualCancelAdjust(int paramInt)
  {
    checkavailable();
    nativeManualCancelAdjust(this.nativeObj, paramInt);
  }
  
  public void manualRedo(int paramInt)
  {
    checkavailable();
    nativeManualRedo(this.nativeObj, paramInt);
  }
  
  public void manualUndo(int paramInt)
  {
    checkavailable();
    nativeManualUndo(this.nativeObj, paramInt);
  }
  
  public void resetALLCosAlpha()
  {
    checkavailable();
    nativeResetALLCosAlpha(this.nativeObj);
  }
  
  public void setAutoBodyMask(Bitmap paramBitmap)
  {
    checkavailable();
    nativeSetAutoBodyMask(this.nativeObj, paramBitmap);
  }
  
  public void setAutoHairMask(Bitmap paramBitmap)
  {
    checkavailable();
    nativeSetAutoHairMask(this.nativeObj, paramBitmap);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    checkavailable();
    if (this.mSrcImage != null) {
      this.mSrcImage.Dispose();
    }
    this.mSrcImage = QImage.Bitmap2QImage(paramBitmap);
    nativeSetBitmap(this.nativeObj, this.mSrcImage);
  }
  
  public void setCanUseGpuStatus(boolean paramBoolean)
  {
    checkavailable();
    nativeSetUseGpuSmooth(this.nativeObj, paramBoolean);
  }
  
  public void setCosAlpha(double paramDouble, int paramInt)
  {
    checkavailable();
    nativeSetCosAlpha(this.nativeObj, paramDouble, paramInt);
  }
  
  public int setCosParamWithIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    checkavailable();
    return nativeSetCosParamWithIndex(this.nativeObj, paramInt1, paramInt2, paramInt3);
  }
  
  public void setFaceCount(int paramInt)
  {
    checkavailable();
    nativeSetFaceCount(this.nativeObj, paramInt);
  }
  
  public void setFaceFeatures(int[][] paramArrayOfInt)
  {
    checkavailable();
    nativeSetFaceFeatures(this.nativeObj, paramArrayOfInt);
  }
  
  public void setHairMask(Bitmap paramBitmap, int paramInt)
  {
    checkavailable();
    nativeSetHairMask(this.nativeObj, paramBitmap, paramInt);
  }
  
  public void setHairRecolorType(int paramInt)
  {
    checkavailable();
    nativeSetHairRecolorType(this.nativeObj, paramInt);
  }
  
  public void setLastSmoothMag(double paramDouble)
  {
    checkavailable();
    nativeSetLastSmoothMag(this.nativeObj, paramDouble);
  }
  
  public void setMaxBasicMag(double paramDouble)
  {
    checkavailable();
    nativeSetMaxBasicMag(this.nativeObj, paramDouble);
  }
  
  public void setMaxSmoothMag(double paramDouble)
  {
    checkavailable();
    nativeSetMaxSmoothMag(this.nativeObj, paramDouble);
  }
  
  public void setRSSColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    checkavailable();
    nativeRSSColor(this.nativeObj, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setRss(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    checkavailable();
    nativeSetRss(this.nativeObj, paramBitmap, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.CosmeticsHandle
 * JD-Core Version:    0.7.0.1
 */