package com.tencent.faceBeauty;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class FaceDetect
{
  public static final int FACE_FEATURE_NUM = 83;
  public static final String TAG = "FaceDetect";
  protected int faceCount = 0;
  protected boolean mDetectedFace;
  public List<FaceParam> mFaceParams = new ArrayList();
  protected List<Boolean> mFemale = new ArrayList();
  protected boolean mGetFaceFeatures = false;
  protected boolean mGetFaceGender = false;
  
  public static Rect boundingRect(int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayOfInt[paramInt1][0];
    int k = i1;
    int i = paramArrayOfInt[paramInt1][1];
    int j = i;
    int m = paramInt1 + 1;
    paramInt1 = j;
    j = m;
    if (j <= paramInt2)
    {
      int n;
      label61:
      int i2;
      if (paramArrayOfInt[j][0] < k)
      {
        n = paramArrayOfInt[j][0];
        m = i1;
        if (paramArrayOfInt[j][1] >= paramInt1) {
          break label139;
        }
        i2 = paramArrayOfInt[j][1];
        k = i;
      }
      for (;;)
      {
        j += 1;
        i1 = m;
        i = k;
        k = n;
        paramInt1 = i2;
        break;
        m = i1;
        n = k;
        if (paramArrayOfInt[j][0] <= i1) {
          break label61;
        }
        m = paramArrayOfInt[j][0];
        n = k;
        break label61;
        label139:
        k = i;
        i2 = paramInt1;
        if (paramArrayOfInt[j][1] > i)
        {
          k = paramArrayOfInt[j][1];
          i2 = paramInt1;
        }
      }
    }
    return new Rect(k, paramInt1, i1, i);
  }
  
  public final void detectFace(Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    doDetectFace(paramBitmap);
    LogUtil.d("FaceDetect", "detectFace() :" + (System.currentTimeMillis() - l));
  }
  
  public final boolean detectedFace()
  {
    return this.mDetectedFace;
  }
  
  protected abstract void doDetectFace(Bitmap paramBitmap);
  
  protected abstract void doInitial();
  
  protected abstract void doRelease();
  
  public Rect getEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mEye;
  }
  
  public int getFaceCount()
  {
    return this.faceCount;
  }
  
  public int[][] getFaceFeatures(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return (int[][])null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mFaceOutline;
  }
  
  public boolean getFaceFemale(int paramInt)
  {
    if (paramInt > this.mFemale.size() - 1) {
      return false;
    }
    return ((Boolean)this.mFemale.get(paramInt)).booleanValue();
  }
  
  public FaceParam getFaceParams(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return (FaceParam)this.mFaceParams.get(paramInt);
  }
  
  public Rect getFaces(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mFace;
  }
  
  public Point getLeftEyeCenters(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mLeftEyeCenter;
  }
  
  public Rect getLeftEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mLeftEye;
  }
  
  public Rect getMouths(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mMouth;
  }
  
  public Point getRightEyeCenters(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mRightEyeCenter;
  }
  
  public Rect getRightEyes(int paramInt)
  {
    if (paramInt > this.mFaceParams.size() - 1) {
      return null;
    }
    return ((FaceParam)this.mFaceParams.get(paramInt)).mRightEye;
  }
  
  public void needDetectFaceFeatures(boolean paramBoolean)
  {
    this.mGetFaceFeatures = paramBoolean;
  }
  
  public void needDetectFaceGender(boolean paramBoolean)
  {
    this.mGetFaceGender = paramBoolean;
  }
  
  public final void release()
  {
    doRelease();
  }
  
  public void resizeData(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.faceCount)
    {
      ((FaceParam)this.mFaceParams.get(i)).resetSize(paramInt1, paramInt2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.faceBeauty.FaceDetect
 * JD-Core Version:    0.7.0.1
 */