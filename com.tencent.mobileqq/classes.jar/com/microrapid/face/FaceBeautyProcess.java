package com.microrapid.face;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.faceBeauty.FaceDetect;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.filter.MRect;
import com.tencent.util.LogUtil;

public class FaceBeautyProcess
{
  public static final int AUTO_FACE_ANIT_SPOT = 4;
  public static final int AUTO_FACE_EYE_BAG = 10;
  public static final int AUTO_FACE_EYE_ENLARGE = 8;
  public static final int AUTO_FACE_EYE_LIGHTEN = 9;
  public static final int AUTO_FACE_FACERUDDY = 31;
  public static final int AUTO_FACE_GLOBAL_WHITEN = 0;
  public static final int AUTO_FACE_GLOSSY = 12;
  public static final int AUTO_FACE_LIPS_ST = 32;
  public static final int AUTO_FACE_SKIN_BRIGHTEN = 1;
  public static final int AUTO_FACE_SKIN_COLOR = 7;
  public static final int AUTO_FACE_SKIN_SMOOTH = 3;
  public static final int AUTO_FACE_SKIN_WHITEN = 2;
  public static final int AUTO_FACE_SLIM_FACE = 5;
  public static final int AUTO_FACE_SLIM_FACE_TYPE = 6;
  public static final int AUTO_FACE_SLIM_NOSE = 28;
  public static final int AUTO_FACE_SLIM_NOSE_TYPE = 29;
  public static final int AUTO_FACE_SMILE = 11;
  public static final int AUTO_FACE_WHITENTOOTH = 13;
  public static final int AUTO_FACE_WHITESKIN = 30;
  private boolean available = false;
  FaceParam mFaceFeature = null;
  private long nativeObj = Algorithm.nativeAutoFaceHandle();
  public boolean useNewSmoothen = true;
  
  private int checkavailable()
  {
    if (this.nativeObj == -2L)
    {
      Log.e("FaceBeautyProcess", "auth failed");
      return -2;
    }
    if ((!this.available) || (this.nativeObj == 0L)) {
      throw new RuntimeException("use bad addr");
    }
    return 0;
  }
  
  public static void clearMask() {}
  
  private void createFaceMolesMask(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[124];
    Algorithm.nativeGetFaceMaskPoints(this.nativeObj, arrayOfInt);
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localCanvas.drawColor(Color.argb(255, 0, 0, 0));
    localPaint.setColor(Color.argb(255, 255, 255, 255));
    Path localPath = new Path();
    localPath.moveTo(arrayOfInt[0], arrayOfInt[1]);
    int j = 0 + 2;
    int i = 1;
    while (i < 10)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPaint.setColor(Color.argb(255, 0, 0, 0));
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 9)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 9)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 9)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 7)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 9)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
    j += 2;
    i = 1;
    while (i < 9)
    {
      localPath.lineTo(arrayOfInt[j], arrayOfInt[(j + 1)]);
      j += 2;
      i += 1;
    }
    localPath.close();
    localCanvas.drawPath(localPath, localPaint);
    Algorithm.nativeSetFaceMak(this.nativeObj, paramBitmap);
  }
  
  private void drawLightEyeMask(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[40];
    Algorithm.nativeGetEyeMaskPoints(this.nativeObj, arrayOfInt);
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localCanvas.drawColor(Color.argb(255, 0, 0, 0));
    localPaint.setColor(Color.argb(255, 255, 255, 255));
    int i = 0;
    int j = 0;
    while (j < 2)
    {
      Path localPath = new Path();
      localPath.moveTo(arrayOfInt[i], arrayOfInt[(i + 1)]);
      i += 2;
      int k = 1;
      while (k < 9)
      {
        localPath.lineTo(arrayOfInt[i], arrayOfInt[(i + 1)]);
        i += 2;
        k += 1;
      }
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      j += 1;
    }
    Algorithm.nativeSetEyeMak(this.nativeObj, paramBitmap);
  }
  
  private void drawLightPouchMask(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[28];
    Algorithm.nativeGetPouchMaskPoints(this.nativeObj, arrayOfInt);
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localCanvas.drawColor(Color.argb(255, 0, 0, 0));
    localPaint.setColor(Color.argb(255, 255, 255, 255));
    int i = 0;
    int j = 0;
    while (j < 2)
    {
      Path localPath = new Path();
      localPath.moveTo(arrayOfInt[i], arrayOfInt[(i + 1)]);
      i += 2;
      int k = 1;
      while (k < 7)
      {
        localPath.lineTo(arrayOfInt[i], arrayOfInt[(i + 1)]);
        i += 2;
        k += 1;
      }
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      j += 1;
    }
    Algorithm.nativeSetPouchMak(this.nativeObj, paramBitmap);
  }
  
  private void drawWhitenToothMask()
  {
    if (this.mFaceFeature.mFaceOutline == null) {
      return;
    }
    Rect localRect = FaceDetect.boundingRect(this.mFaceFeature.mFaceOutline, 65, 79);
    Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localCanvas.drawColor(Color.argb(255, 255, 0, 0));
    Path localPath = new Path();
    int j = localRect.left;
    int k = localRect.top;
    localPath.moveTo(this.mFaceFeature.mFaceOutline[65][0] - j, this.mFaceFeature.mFaceOutline[65][1] - k);
    int i = 67;
    while (i <= 71)
    {
      localPath.lineTo(this.mFaceFeature.mFaceOutline[i][0] - j, this.mFaceFeature.mFaceOutline[i][1] - k);
      i += 1;
    }
    localPath.lineTo(this.mFaceFeature.mFaceOutline[66][0] - j, this.mFaceFeature.mFaceOutline[66][1] - k);
    i = 79;
    while (i >= 75)
    {
      localPath.lineTo(this.mFaceFeature.mFaceOutline[i][0] - j, this.mFaceFeature.mFaceOutline[i][1] - k);
      i -= 1;
    }
    localPath.close();
    localPaint.setColor(Color.argb(255, 0, 255, 0));
    localCanvas.drawPath(localPath, localPaint);
    localPath = new Path();
    localPath.moveTo(this.mFaceFeature.mFaceOutline[65][0] - j, this.mFaceFeature.mFaceOutline[65][1] - k);
    i = 74;
    while (i >= 72)
    {
      localPath.lineTo(this.mFaceFeature.mFaceOutline[i][0] - j, this.mFaceFeature.mFaceOutline[i][1] - k);
      i -= 1;
    }
    localPath.lineTo(this.mFaceFeature.mFaceOutline[66][0] - j, this.mFaceFeature.mFaceOutline[66][1] - k);
    i = 80;
    while (i <= 82)
    {
      localPath.lineTo(this.mFaceFeature.mFaceOutline[i][0] - j, this.mFaceFeature.mFaceOutline[i][1] - k);
      i += 1;
    }
    localPath.close();
    localPaint.setColor(Color.argb(255, 0, 0, 255));
    localCanvas.drawPath(localPath, localPaint);
    Algorithm.nativeSetLipsMak(this.nativeObj, localBitmap, MRect.toMRect(localRect));
    localBitmap.recycle();
  }
  
  private void initMask(Bitmap paramBitmap)
  {
    if ((!Algorithm.nativeIsInitMak(this.nativeObj)) && (this.mFaceFeature != null))
    {
      LogUtil.printTime("[filter process initMask face]", "BEGIN face process initMask");
      createFaceMolesMask(paramBitmap);
      drawLightPouchMask(paramBitmap);
      drawLightEyeMask(paramBitmap);
      drawWhitenToothMask();
      LogUtil.printTime("[filter process initMask face]", "END face process initMask");
    }
  }
  
  public static void initial() {}
  
  private void validateFeature()
  {
    if (checkavailable() < 0) {}
    while (this.mFaceFeature == null) {
      return;
    }
    MRect localMRect1 = MRect.toMRect(this.mFaceFeature.mFace);
    MRect localMRect2 = MRect.toMRect(this.mFaceFeature.mLeftEye);
    MRect localMRect3 = MRect.toMRect(this.mFaceFeature.mRightEye);
    MRect localMRect4 = MRect.toMRect(this.mFaceFeature.mMouth);
    if (this.mFaceFeature.mFaceOutline != null) {
      Algorithm.nativeSetFaceFeatures(this.nativeObj, this.mFaceFeature.mFaceOutline);
    }
    Algorithm.nativeSetFaceInfo(this.nativeObj, localMRect1, localMRect2, localMRect3, localMRect4);
  }
  
  public void cleanup()
  {
    if (checkavailable() < 0) {
      return;
    }
    Algorithm.nativeCleanUp(this.nativeObj);
  }
  
  public void dispose()
  {
    if (checkavailable() < 0) {}
    do
    {
      return;
      cleanup();
    } while (!this.available);
    Algorithm.nativeDispose(this.nativeObj);
    this.nativeObj = 0L;
    this.available = false;
  }
  
  public double getAutoParam(int paramInt)
  {
    if (checkavailable() < 0) {
      return 0.0D;
    }
    return Algorithm.nativeGetAutoParam(this.nativeObj, paramInt);
  }
  
  public void processImage(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    while (checkavailable() < 0) {
      return;
    }
    LogUtil.printTime("[filter process total face process]", "BEGIN 开始美容处理函数");
    LogUtil.printTime("[filter process init face]", "BEGIN face process 开始美容初始化");
    initial();
    initMask(paramBitmap);
    LogUtil.printTime("[filter process init face]", "END face process 美容初始化结束 花费时间为：");
    Algorithm.nativePreProcessImage(this.nativeObj);
    LogUtil.printTime("[filter process native process]", "BEGIN face process 开始美容native处理");
    Algorithm.nativeProcessBitmap(this.nativeObj, paramBitmap);
    LogUtil.printTime("[filter process native process]", "END face process 美容native处理完成 花费时间为：");
    LogUtil.printTime("[filter process total face process]", "END 美容处理函数完成 花费时间为：");
  }
  
  public void setAutoParam(int paramInt, double paramDouble)
  {
    if (checkavailable() < 0) {
      return;
    }
    Algorithm.nativeSetAutoParam(this.nativeObj, paramInt, paramDouble);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (checkavailable() < 0) {
      return;
    }
    Algorithm.nativeSetBitmap(this.nativeObj, paramBitmap);
    validateFeature();
  }
  
  public void setContrastON(boolean paramBoolean)
  {
    if (checkavailable() < 0) {
      return;
    }
    Algorithm.nativeSetContrastON(this.nativeObj, paramBoolean);
  }
  
  public void setFaceParam(FaceParam paramFaceParam)
  {
    this.mFaceFeature = paramFaceParam;
    validateFeature();
  }
  
  public void setUseSmoothenWithGpu(boolean paramBoolean)
  {
    if (checkavailable() < 0) {
      return;
    }
    long l = this.nativeObj;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Algorithm.nativeSetCpuSmoothenOn(l, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.face.FaceBeautyProcess
 * JD-Core Version:    0.7.0.1
 */