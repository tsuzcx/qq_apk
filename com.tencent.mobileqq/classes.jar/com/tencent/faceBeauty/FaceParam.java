package com.tencent.faceBeauty;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.reflect.Array;

public class FaceParam
  implements Parcelable
{
  public static final Parcelable.Creator<FaceParam> CREATOR = new FaceParam.1();
  private static final String TAG = FaceParam.class.getSimpleName();
  public int height = 0;
  public Rect mEye = null;
  public Rect mFace = null;
  public int[][] mFaceOutline = (int[][])null;
  public Rect mLeftEye = null;
  public Point mLeftEyeCenter = null;
  public Rect mMouth = null;
  public Rect mRightEye = null;
  public Point mRightEyeCenter = null;
  public int width = 0;
  
  public FaceParam() {}
  
  private FaceParam(Parcel paramParcel)
  {
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.mLeftEyeCenter = new Point(paramParcel.readInt(), paramParcel.readInt());
    this.mRightEyeCenter = new Point(paramParcel.readInt(), paramParcel.readInt());
    ClassLoader localClassLoader = Rect.class.getClassLoader();
    this.mFace = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.mLeftEye = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.mRightEye = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.mEye = ((Rect)paramParcel.readParcelable(localClassLoader));
    this.mMouth = ((Rect)paramParcel.readParcelable(localClassLoader));
    if (paramParcel.readInt() == 1)
    {
      paramParcel = paramParcel.createIntArray();
      if ((paramParcel != null) && (paramParcel.length >= 2))
      {
        int i = paramParcel.length / 2;
        this.mFaceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 }));
        i = 0;
        while (i < paramParcel.length / 2)
        {
          this.mFaceOutline[i][0] = paramParcel[(i * 2)];
          this.mFaceOutline[i][1] = paramParcel[(i * 2 + 1)];
          i += 1;
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public NormalizedFaceParam normalizeFace()
  {
    NormalizedFaceParam localNormalizedFaceParam = new NormalizedFaceParam();
    localNormalizedFaceParam.setX(this.mFace.left * 1.0D / this.width);
    localNormalizedFaceParam.setY(this.mFace.top * 1.0D / this.height);
    localNormalizedFaceParam.setW(this.mFace.right * 1.0D / this.width - localNormalizedFaceParam.getX());
    localNormalizedFaceParam.setH(this.mFace.bottom * 1.0D / this.height - localNormalizedFaceParam.getY());
    Log.d("NewEnhance_Batch", "Face normalized(" + localNormalizedFaceParam.getX() + ", " + localNormalizedFaceParam.getY() + ", " + localNormalizedFaceParam.getW() + ", " + localNormalizedFaceParam.getH() + ")");
    return localNormalizedFaceParam;
  }
  
  public void printFaceDes()
  {
    Object localObject1 = "\n****************FaceFeature******************:\n" + String.format("ImageSize:(%d, %d)\n", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    Object localObject2 = (String)localObject1 + String.format("FaceRect:(%d, %d, %d, %d)\n", new Object[] { Integer.valueOf(this.mFace.left), Integer.valueOf(this.mFace.top), Integer.valueOf(this.mFace.width()), Integer.valueOf(this.mFace.height()) });
    localObject1 = localObject2;
    if (this.mFaceOutline != null)
    {
      localObject1 = (String)localObject2 + "LandMark:";
      localObject2 = this.mFaceOutline;
      int i = 0;
      while (i < localObject2.length)
      {
        localObject1 = (String)localObject1 + String.format("(%d, %d)", new Object[] { Integer.valueOf(localObject2[i][0]), Integer.valueOf(localObject2[i][1]) });
        i += 1;
      }
      localObject1 = (String)localObject1 + "\n";
    }
    localObject1 = (String)localObject1 + "*********************************************\n";
    LogUtils.e(TAG, (String)localObject1);
  }
  
  public void resetSize(int paramInt1, int paramInt2)
  {
    if ((this.height != paramInt2) || (this.width != paramInt1))
    {
      resizeData(paramInt1 / this.width, paramInt2 / this.height);
      this.height = paramInt2;
      this.width = paramInt1;
    }
  }
  
  public void resizeData(float paramFloat1, float paramFloat2)
  {
    this.height = ((int)(this.height * paramFloat2));
    this.width = ((int)(this.width * paramFloat1));
    Object localObject = this.mFace;
    ((Rect)localObject).left = ((int)(((Rect)localObject).left * paramFloat1));
    ((Rect)localObject).top = ((int)(((Rect)localObject).top * paramFloat2));
    ((Rect)localObject).right = ((int)(((Rect)localObject).right * paramFloat1));
    ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * paramFloat2));
    localObject = this.mLeftEye;
    ((Rect)localObject).left = ((int)(((Rect)localObject).left * paramFloat1));
    ((Rect)localObject).top = ((int)(((Rect)localObject).top * paramFloat2));
    ((Rect)localObject).right = ((int)(((Rect)localObject).right * paramFloat1));
    ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * paramFloat2));
    localObject = this.mLeftEyeCenter;
    ((Point)localObject).x = ((int)(((Point)localObject).x * paramFloat1));
    ((Point)localObject).y = ((int)(((Point)localObject).y * paramFloat2));
    localObject = this.mRightEye;
    ((Rect)localObject).left = ((int)(((Rect)localObject).left * paramFloat1));
    ((Rect)localObject).top = ((int)(((Rect)localObject).top * paramFloat2));
    ((Rect)localObject).right = ((int)(((Rect)localObject).right * paramFloat1));
    ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * paramFloat2));
    localObject = this.mRightEyeCenter;
    ((Point)localObject).x = ((int)(((Point)localObject).x * paramFloat1));
    ((Point)localObject).y = ((int)(((Point)localObject).y * paramFloat2));
    localObject = this.mEye;
    ((Rect)localObject).left = ((int)(((Rect)localObject).left * paramFloat1));
    ((Rect)localObject).top = ((int)(((Rect)localObject).top * paramFloat2));
    ((Rect)localObject).right = ((int)(((Rect)localObject).right * paramFloat1));
    ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * paramFloat2));
    localObject = this.mMouth;
    ((Rect)localObject).left = ((int)(((Rect)localObject).left * paramFloat1));
    ((Rect)localObject).top = ((int)(((Rect)localObject).top * paramFloat2));
    ((Rect)localObject).right = ((int)(((Rect)localObject).right * paramFloat1));
    ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom * paramFloat2));
    if (this.mFaceOutline != null)
    {
      localObject = this.mFaceOutline;
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i][0] = ((int)(localObject[i][0] * paramFloat1));
        localObject[i][1] = ((int)(localObject[i][1] * paramFloat2));
        i += 1;
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.mLeftEyeCenter.x);
    paramParcel.writeInt(this.mLeftEyeCenter.y);
    paramParcel.writeInt(this.mRightEyeCenter.x);
    paramParcel.writeInt(this.mRightEyeCenter.y);
    paramParcel.writeParcelable(this.mFace, 1);
    paramParcel.writeParcelable(this.mLeftEye, 1);
    paramParcel.writeParcelable(this.mRightEye, 1);
    paramParcel.writeParcelable(this.mEye, 1);
    paramParcel.writeParcelable(this.mMouth, 1);
    if (this.mFaceOutline != null)
    {
      paramParcel.writeInt(1);
      int[] arrayOfInt = new int[this.mFaceOutline.length * 2];
      paramInt = 0;
      while (paramInt < this.mFaceOutline.length)
      {
        arrayOfInt[(paramInt * 2)] = this.mFaceOutline[paramInt][0];
        arrayOfInt[(paramInt * 2 + 1)] = this.mFaceOutline[paramInt][1];
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.faceBeauty.FaceParam
 * JD-Core Version:    0.7.0.1
 */