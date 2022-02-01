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
    localRect1.left = ((int)(paramPointF.x - paramFloat * 1.2D));
    localRect1.top = ((int)(paramPointF.y - paramFloat * 0.9D));
    localRect1.right = ((int)(paramPointF.x + paramFloat * 1.2D));
    localRect1.bottom = ((int)(paramPointF.y + paramFloat * 1.4D));
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
    localRect2.left = ((int)(paramPointF.x - 0.8D * paramFloat));
    localRect2.top = ((int)(paramPointF.y - paramFloat * 0.2D));
    localRect2.right = ((int)(paramPointF.x + 0.8D * paramFloat));
    localRect2.bottom = ((int)(paramPointF.y + paramFloat * 0.28D));
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
    int i = paramPointF.right;
    paramPointF.right = (localRect2.width() * 2 / 3 + i);
    localFaceParam.mRightEyeCenter = new Point(paramPointF.centerX(), paramPointF.centerY());
    paramPointF = new Rect();
    localFaceParam.mMouth = paramPointF;
    paramPointF.left = ((int)(localRect1.left + localRect1.width() * (1.0D - 0.4D) / 2.0D));
    paramPointF.top = ((int)(localRect1.top + localRect1.height() * 0.72D));
    paramPointF.right = ((int)(0.4D * localRect1.width()) + paramPointF.left);
    paramPointF.bottom = ((int)(localRect1.height() * (0.88D - 0.72D)) + paramPointF.top);
    localFaceParam.width = paramInt1;
    localFaceParam.height = paramInt2;
    this.mFaceParams.add(localFaceParam);
  }
  
  protected void doDetectFace(Bitmap paramBitmap)
  {
    this.mDetectedFace = false;
    this.mFaceParams.clear();
    this.faceCount = 0;
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      int k = 1;
      int n = paramBitmap.getWidth();
      int i1 = paramBitmap.getHeight();
      PointF localPointF = new PointF();
      FaceDetector localFaceDetector;
      Object localObject;
      int i2;
      if (paramBitmap.getConfig() == Bitmap.Config.RGB_565)
      {
        localFaceDetector = new FaceDetector(paramBitmap.getWidth(), paramBitmap.getHeight(), 10);
        localObject = new FaceDetector.Face[10];
        i2 = localFaceDetector.findFaces(paramBitmap, (FaceDetector.Face[])localObject);
        paramBitmap.recycle();
        this.faceCount = i2;
        i = 0;
      }
      float f1;
      for (;;)
      {
        if (i >= this.faceCount) {
          break label376;
        }
        paramBitmap = localObject[i];
        f1 = paramBitmap.eyesDistance();
        int j = i + 1;
        int m = i;
        while (j < this.faceCount)
        {
          float f3 = localObject[j].eyesDistance();
          float f2 = f1;
          if (f3 > f1)
          {
            f2 = f3;
            m = j;
          }
          j += 1;
          f1 = f2;
          continue;
          if (n > i1) {}
          for (i = n;; i = i1) {
            for (;;)
            {
              j = i / 512;
              i = j;
              if (j < 1) {
                i = 1;
              }
              try
              {
                localObject = Bitmap.createBitmap(n / i, i1 / i, Bitmap.Config.RGB_565);
                new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, new Rect(0, 0, n, i1), new Rect(0, 0, n / i, i1 / i), null);
                paramBitmap = (Bitmap)localObject;
                k = i;
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                localPointF.x = (paramBitmap.getWidth() / 2);
                localPointF.y = (paramBitmap.getHeight() / 2);
                caculateFaceAndEyes(localPointF, paramBitmap.getWidth() / 4, n, i1);
                return;
              }
            }
          }
        }
        if (m != i)
        {
          localFaceDetector = localOutOfMemoryError[m];
          localOutOfMemoryError[m] = paramBitmap;
          localOutOfMemoryError[i] = localFaceDetector;
        }
        i += 1;
      }
      label376:
      int i = 0;
      while (i < i2)
      {
        this.mDetectedFace = true;
        localOutOfMemoryError[i].getMidPoint(localPointF);
        f1 = localOutOfMemoryError[i].eyesDistance();
        localPointF.x *= k;
        localPointF.y *= k;
        caculateFaceAndEyes(localPointF, f1 * k, n, i1);
        i += 1;
      }
    }
  }
  
  protected void doInitial() {}
  
  protected void doRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.facebeauty.AndroidFaceDetect
 * JD-Core Version:    0.7.0.1
 */