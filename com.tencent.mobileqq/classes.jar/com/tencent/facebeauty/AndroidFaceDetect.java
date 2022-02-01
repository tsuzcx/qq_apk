package com.tencent.facebeauty;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import java.util.List;

public class AndroidFaceDetect
  extends FaceDetect
{
  void caculateFaceAndEyes(PointF paramPointF, float paramFloat, int paramInt1, int paramInt2)
  {
    FaceParam localFaceParam = new FaceParam();
    Rect localRect1 = new Rect();
    localFaceParam.mFace = localRect1;
    double d3 = paramPointF.x;
    double d1 = paramFloat;
    Double.isNaN(d1);
    double d2 = 1.2D * d1;
    Double.isNaN(d3);
    localRect1.left = ((int)(d3 - d2));
    d3 = paramPointF.y;
    Double.isNaN(d1);
    Double.isNaN(d3);
    localRect1.top = ((int)(d3 - 0.9D * d1));
    d3 = paramPointF.x;
    Double.isNaN(d3);
    localRect1.right = ((int)(d3 + d2));
    d2 = paramPointF.y;
    Double.isNaN(d1);
    Double.isNaN(d2);
    localRect1.bottom = ((int)(d2 + 1.4D * d1));
    if (localRect1.left < 0) {
      localRect1.left = 0;
    }
    if (localRect1.top < 0) {
      localRect1.top = 0;
    }
    if (localRect1.right > paramInt1) {
      localRect1.right = paramInt1;
    }
    if (localRect1.bottom > paramInt2) {
      localRect1.bottom = paramInt2;
    }
    Rect localRect2 = new Rect();
    localFaceParam.mEye = localRect2;
    d3 = paramPointF.x;
    Double.isNaN(d1);
    d2 = 0.8D * d1;
    Double.isNaN(d3);
    localRect2.left = ((int)(d3 - d2));
    d3 = paramPointF.y;
    Double.isNaN(d1);
    Double.isNaN(d3);
    localRect2.top = ((int)(d3 - 0.2D * d1));
    d3 = paramPointF.x;
    Double.isNaN(d3);
    localRect2.right = ((int)(d3 + d2));
    d2 = paramPointF.y;
    Double.isNaN(d1);
    Double.isNaN(d2);
    localRect2.bottom = ((int)(d2 + d1 * 0.28D));
    if (localRect2.left < 0) {
      localRect2.left = 0;
    }
    if (localRect2.top < 0) {
      localRect2.top = 0;
    }
    if (localRect2.right > paramInt1) {
      localRect2.right = paramInt1;
    }
    if (localRect2.bottom > paramInt2) {
      localRect2.bottom = paramInt2;
    }
    paramPointF = new Rect();
    localFaceParam.mLeftEye = paramPointF;
    paramPointF.left = localRect2.left;
    paramPointF.right = (localRect2.width() * 3 / 7 + paramPointF.left);
    localRect2.top -= localRect2.height() / 6;
    paramPointF.bottom = (localRect2.height() * 4 / 3 + paramPointF.top);
    localFaceParam.mLeftEyeCenter = new Point(paramPointF.centerX(), paramPointF.centerY());
    paramPointF = new Rect(paramPointF);
    localFaceParam.mRightEye = paramPointF;
    paramPointF.left += localRect2.width() * 2 / 3;
    paramPointF.right += localRect2.width() * 2 / 3;
    localFaceParam.mRightEyeCenter = new Point(paramPointF.centerX(), paramPointF.centerY());
    paramPointF = new Rect();
    localFaceParam.mMouth = paramPointF;
    d1 = localRect1.left;
    d2 = localRect1.width();
    Double.isNaN(d2);
    d2 = d2 * 0.6D / 2.0D;
    Double.isNaN(d1);
    paramPointF.left = ((int)(d1 + d2));
    d1 = localRect1.top;
    d2 = localRect1.height();
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramPointF.top = ((int)(d1 + d2 * 0.72D));
    d1 = localRect1.width();
    Double.isNaN(d1);
    paramPointF.right = ((int)(d1 * 0.4D) + paramPointF.left);
    d1 = localRect1.height();
    Double.isNaN(d1);
    paramPointF.bottom = ((int)(d1 * 0.16D) + paramPointF.top);
    localFaceParam.width = paramInt1;
    localFaceParam.height = paramInt2;
    this.mFaceParams.add(localFaceParam);
  }
  
  protected void doDetectFace(Bitmap paramBitmap)
  {
    Object localObject1 = paramBitmap;
    int i3 = 0;
    this.mDetectedFace = false;
    this.mFaceParams.clear();
    this.faceCount = 0;
    if (localObject1 == null) {
      return;
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    PointF localPointF = new PointF();
    int k;
    int i;
    int j;
    if (paramBitmap.getConfig() == Bitmap.Config.RGB_565)
    {
      k = 1;
    }
    else
    {
      if (i1 > i2) {
        i = i1;
      } else {
        i = i2;
      }
      j = i / 512;
      i = j;
      if (j < 1) {
        i = 1;
      }
    }
    try
    {
      Object localObject2 = Bitmap.createBitmap(i1 / i, i2 / i, Bitmap.Config.RGB_565);
      new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject1, new Rect(0, 0, i1, i2), new Rect(0, 0, i1 / i, i2 / i), null);
      localObject1 = localObject2;
      k = i;
      localObject2 = new FaceDetector(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), 10);
      paramBitmap = new FaceDetector.Face[10];
      int i4 = ((FaceDetector)localObject2).findFaces((Bitmap)localObject1, paramBitmap);
      ((Bitmap)localObject1).recycle();
      this.faceCount = i4;
      float f1;
      int m;
      float f3;
      float f2;
      for (i = 0;; i = m)
      {
        j = i3;
        if (i >= this.faceCount) {
          break;
        }
        localObject1 = paramBitmap[i];
        f1 = ((FaceDetector.Face)localObject1).eyesDistance();
        m = i + 1;
        int n = i;
        j = m;
        while (j < this.faceCount)
        {
          f3 = paramBitmap[j].eyesDistance();
          f2 = f1;
          if (f3 > f1)
          {
            n = j;
            f2 = f3;
          }
          j += 1;
          f1 = f2;
        }
        if (n != i)
        {
          localObject2 = paramBitmap[n];
          paramBitmap[n] = localObject1;
          paramBitmap[i] = localObject2;
        }
      }
      while (j < i4)
      {
        this.mDetectedFace = true;
        paramBitmap[j].getMidPoint(localPointF);
        f1 = paramBitmap[j].eyesDistance();
        f2 = localPointF.x;
        f3 = k;
        localPointF.x = (f2 * f3);
        localPointF.y *= f3;
        caculateFaceAndEyes(localPointF, f1 * f3, i1, i2);
        j += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label433:
      break label433;
    }
    localPointF.x = (paramBitmap.getWidth() / 2);
    localPointF.y = (paramBitmap.getHeight() / 2);
    caculateFaceAndEyes(localPointF, paramBitmap.getWidth() / 4, i1, i2);
  }
  
  protected void doInitial() {}
  
  protected void doRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.facebeauty.AndroidFaceDetect
 * JD-Core Version:    0.7.0.1
 */