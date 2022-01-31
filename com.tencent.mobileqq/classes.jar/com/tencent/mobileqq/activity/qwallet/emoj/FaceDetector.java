package com.tencent.mobileqq.activity.qwallet.emoj;

import ahiw;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ltq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
  
  public List<QWalletFaceTracker.ExpressionInfo> parseExpressionConfigFromJson(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = ahiw.b(paramString1);
      if (!TextUtils.isEmpty(paramContext))
      {
        paramContext = (JSONObject)new JSONTokener(paramContext).nextValue();
        if (paramContext == null) {
          break label470;
        }
      }
    }
    catch (JSONException paramString1)
    {
      try
      {
        paramString2 = paramContext.optJSONArray("expressionList");
        if (paramString2 == null) {
          break label470;
        }
        paramContext = new ArrayList();
        i = 0;
        paramString1 = paramContext;
      }
      catch (JSONException paramContext)
      {
        try
        {
          int i;
          ltq localltq;
          int j;
          for (;;)
          {
            if (i >= paramString2.length()) {
              break label464;
            }
            paramString1 = new QWalletFaceTracker.ExpressionInfo();
            localltq = new ltq();
            paramString1.expressionItem = localltq;
            localObject = paramString2.getJSONObject(i);
            paramString1.coolValue = ((JSONObject)localObject).optDouble("coolValue");
            paramString1.perfectValue = ((JSONObject)localObject).optInt("perfectValue");
            localltq.expressionID = ((JSONObject)localObject).optString("expressionID");
            localJSONArray = ((JSONObject)localObject).optJSONArray("expressionFeat");
            if (localJSONArray == null) {
              break;
            }
            localltq.expressionFeat = new ArrayList();
            j = 0;
            while (j < localJSONArray.length() / 2)
            {
              localltq.expressionFeat.add(new PointF(localJSONArray.optInt(j * 2), localJSONArray.optInt(j * 2 + 1)));
              j += 1;
            }
            paramContext = paramContext;
            paramContext.printStackTrace();
            paramContext = null;
          }
          JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("expressionAngle");
          if ((localJSONArray != null) && (localJSONArray.length() == 3)) {
            localltq.expressionAngle = convertJsonAngle2NormalAngle(new float[] { (float)localJSONArray.optDouble(0), (float)localJSONArray.optDouble(1), (float)localJSONArray.optDouble(2) });
          }
          localJSONArray = ((JSONObject)localObject).optJSONArray("expressionWeight");
          if ((localJSONArray != null) && (localJSONArray.length() == 7))
          {
            localltq.expressionWeight = new double[7];
            j = 0;
          }
          while (j < 7)
          {
            localltq.expressionWeight[j] = localJSONArray.optDouble(j);
            j += 1;
            continue;
            localltq.expressionWeight = WEIGHT;
          }
          Object localObject = ((JSONObject)localObject).optJSONArray("expressionMaxNeedRefine");
          if ((localObject != null) && (((JSONArray)localObject).length() == 3))
          {
            localltq.a = new int[3];
            localltq.a[0] = ((JSONArray)localObject).optInt(0);
            localltq.a[1] = ((JSONArray)localObject).optInt(1);
            localltq.a[2] = ((JSONArray)localObject).optInt(2);
          }
          paramContext.add(paramString1);
          i += 1;
        }
        catch (JSONException paramString1)
        {
          break label458;
        }
        paramString1 = paramString1;
        paramContext = null;
      }
      label458:
      paramString1.printStackTrace();
      paramString1 = paramContext;
    }
    label464:
    return paramString1;
    label470:
    return null;
  }
  
  public void updatePointsAndAngles(QWalletFaceTracker.FaceStatus[] paramArrayOfFaceStatus)
  {
    this.faceInfos.clear();
    if (paramArrayOfFaceStatus != null)
    {
      int i = 0;
      while (i < paramArrayOfFaceStatus.length)
      {
        QWalletFaceTracker.FaceStatus localFaceStatus = paramArrayOfFaceStatus[i];
        FaceInfo localFaceInfo = new FaceInfo();
        localFaceInfo.points = YoutuPointsUtil.transformYTPointsToPtuPoints(localFaceStatus.xys);
        localFaceInfo.angles[0] = ((float)(localFaceStatus.pitch * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.angles[1] = ((float)(localFaceStatus.yaw * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.angles[2] = ((float)(localFaceStatus.roll * 3.141592653589793D / 180.0D) * -1.0F);
        localFaceInfo.pitch = localFaceStatus.pitch;
        localFaceInfo.yaw = (-localFaceStatus.yaw);
        localFaceInfo.roll = (-localFaceStatus.roll);
        this.faceInfos.add(localFaceInfo);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.FaceDetector
 * JD-Core Version:    0.7.0.1
 */