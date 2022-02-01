package com.tencent.mobileqq.activity.qwallet.emoj;

import android.graphics.PointF;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FaceDetector
{
  public static final int EXPRESSION_ITEM_COUNT = 7;
  public static final double[] WEIGHT = { 0.2D, 0.2D, 0.3D, 0.06D, 0.06D, 0.06D, 0.12D };
  private static volatile FaceDetector sInstance;
  private List<FaceInfo> faceInfos = new ArrayList();
  
  public static float[] convertJsonAngle2NormalAngle(float[] paramArrayOfFloat)
  {
    return new float[] { paramArrayOfFloat[0], paramArrayOfFloat[2], paramArrayOfFloat[1] };
  }
  
  public static FaceDetector getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new FaceDetector();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public List<PointF> getAllPoints(int paramInt)
  {
    if (indexOutOfBounds(this.faceInfos, paramInt)) {
      return new ArrayList();
    }
    return ((FaceInfo)this.faceInfos.get(paramInt)).points;
  }
  
  public float[] getFaceAngles(int paramInt)
  {
    if (indexOutOfBounds(this.faceInfos, paramInt)) {
      return new float[0];
    }
    return ((FaceInfo)this.faceInfos.get(paramInt)).angles;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.FaceDetector
 * JD-Core Version:    0.7.0.1
 */