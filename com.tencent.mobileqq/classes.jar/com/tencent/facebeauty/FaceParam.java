package com.tencent.facebeauty;

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
  private static final String TAG = "FaceParam";
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
    Object localObject1 = Rect.class.getClassLoader();
    this.mFace = ((Rect)paramParcel.readParcelable((ClassLoader)localObject1));
    this.mLeftEye = ((Rect)paramParcel.readParcelable((ClassLoader)localObject1));
    this.mRightEye = ((Rect)paramParcel.readParcelable((ClassLoader)localObject1));
    this.mEye = ((Rect)paramParcel.readParcelable((ClassLoader)localObject1));
    this.mMouth = ((Rect)paramParcel.readParcelable((ClassLoader)localObject1));
    if (paramParcel.readInt() == 1)
    {
      paramParcel = paramParcel.createIntArray();
      if ((paramParcel != null) && (paramParcel.length >= 2))
      {
        this.mFaceOutline = ((int[][])Array.newInstance(Integer.TYPE, new int[] { paramParcel.length / 2, 2 }));
        int i = 0;
        while (i < paramParcel.length / 2)
        {
          localObject1 = this.mFaceOutline;
          Object localObject2 = localObject1[i];
          int j = i * 2;
          localObject2[0] = paramParcel[j];
          localObject1[i][1] = paramParcel[(j + 1)];
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
    double d1 = this.mFace.left;
    Double.isNaN(d1);
    double d2 = this.width;
    Double.isNaN(d2);
    localNormalizedFaceParam.setX(d1 * 1.0D / d2);
    d1 = this.mFace.top;
    Double.isNaN(d1);
    d2 = this.height;
    Double.isNaN(d2);
    localNormalizedFaceParam.setY(d1 * 1.0D / d2);
    d1 = this.mFace.right;
    Double.isNaN(d1);
    d2 = this.width;
    Double.isNaN(d2);
    localNormalizedFaceParam.setW(d1 * 1.0D / d2 - localNormalizedFaceParam.getX());
    d1 = this.mFace.bottom;
    Double.isNaN(d1);
    d2 = this.height;
    Double.isNaN(d2);
    localNormalizedFaceParam.setH(d1 * 1.0D / d2 - localNormalizedFaceParam.getY());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Face normalized(");
    localStringBuilder.append(localNormalizedFaceParam.getX());
    localStringBuilder.append(", ");
    localStringBuilder.append(localNormalizedFaceParam.getY());
    localStringBuilder.append(", ");
    localStringBuilder.append(localNormalizedFaceParam.getW());
    localStringBuilder.append(", ");
    localStringBuilder.append(localNormalizedFaceParam.getH());
    localStringBuilder.append(")");
    Log.d("NewEnhance_Batch", localStringBuilder.toString());
    return localNormalizedFaceParam;
  }
  
  public void printFaceDes()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("\n****************FaceFeature******************:\n");
    ((StringBuilder)localObject1).append(String.format("ImageSize:(%d, %d)\n", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) }));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format("FaceRect:(%d, %d, %d, %d)\n", new Object[] { Integer.valueOf(this.mFace.left), Integer.valueOf(this.mFace.top), Integer.valueOf(this.mFace.width()), Integer.valueOf(this.mFace.height()) }));
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (this.mFaceOutline != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("LandMark:");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = this.mFaceOutline;
      int i = 0;
      while (i < localObject2.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(String.format("(%d, %d)", new Object[] { Integer.valueOf(localObject2[i][0]), Integer.valueOf(localObject2[i][1]) }));
        localObject1 = localStringBuilder.toString();
        i += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("*********************************************\n");
    localObject1 = ((StringBuilder)localObject2).toString();
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
    localObject = this.mFaceOutline;
    if (localObject != null)
    {
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
      for (;;)
      {
        int[][] arrayOfInt1 = this.mFaceOutline;
        if (paramInt >= arrayOfInt1.length) {
          break;
        }
        int i = paramInt * 2;
        arrayOfInt[i] = arrayOfInt1[paramInt][0];
        arrayOfInt[(i + 1)] = arrayOfInt1[paramInt][1];
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.facebeauty.FaceParam
 * JD-Core Version:    0.7.0.1
 */