package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.aelight.camera.struct.camera.TTAutoAISceneType;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TTAutoAIScene
  implements IAIScene
{
  private static final Double a = Double.valueOf(0.005D);
  private static final Double b = Double.valueOf(0.01D);
  private static final Double c = Double.valueOf(0.35D);
  private JSONObject d = null;
  
  private TTAutoAIScene.FaceResult a(Bitmap paramBitmap, ArrayList<IAIScene.FaceRect> paramArrayList)
  {
    TTAutoAIScene.FaceResult localFaceResult = new TTAutoAIScene.FaceResult(this);
    if (paramBitmap != null)
    {
      if (paramArrayList == null) {
        return localFaceResult;
      }
      double d1 = paramBitmap.getWidth() * paramBitmap.getHeight();
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramBitmap = (IAIScene.FaceRect)paramArrayList.get(i);
        double d2 = paramBitmap.b * paramBitmap.a;
        double d3 = localFaceResult.c;
        Double.isNaN(d2);
        Double.isNaN(d1);
        localFaceResult.c = (d3 + d2 / d1);
        if (localFaceResult.c > a.doubleValue()) {
          localFaceResult.a = true;
        }
        i += 1;
      }
      if ((paramArrayList.size() > 1) && (localFaceResult.c > b.doubleValue())) {
        localFaceResult.b = true;
      }
    }
    return localFaceResult;
  }
  
  private TTAutoAISceneType a(JSONArray paramJSONArray)
  {
    Object localObject1 = new TTAutoAISceneType();
    Object localObject2 = localObject1;
    if (paramJSONArray.length() > 0)
    {
      int i = 0;
      double d2 = -1.0D;
      double d5;
      for (double d3 = -1.0D;; d3 = d5)
      {
        localObject2 = localObject1;
        if (i >= paramJSONArray.length()) {
          break;
        }
        localObject2 = paramJSONArray.optJSONObject(i);
        Object localObject3 = ((JSONObject)localObject2).optString("label");
        double d4 = ((JSONObject)localObject2).optDouble("confidence");
        localObject3 = e((String)localObject3);
        if (localObject3 == null)
        {
          d5 = d3;
        }
        else if (((TTAutoAISceneType)localObject3).b == -1)
        {
          d5 = d3;
        }
        else
        {
          localObject2 = localObject1;
          double d1 = d2;
          if (((TTAutoAISceneType)localObject3).a == 3)
          {
            localObject2 = localObject1;
            d1 = d2;
            if (d4 > c.doubleValue())
            {
              localObject2 = localObject1;
              d1 = d2;
              if (d4 > d2)
              {
                localObject2 = localObject3;
                d1 = d4;
              }
            }
          }
          localObject1 = localObject2;
          d2 = d1;
          d5 = d3;
          if (d4 > d3)
          {
            localObject1 = localObject2;
            d2 = d1;
            d5 = d3;
            if (d1 <= 0.0D)
            {
              localObject1 = localObject3;
              d5 = d4;
              d2 = d1;
            }
          }
        }
        i += 1;
      }
    }
    return localObject2;
  }
  
  private String a(Bitmap paramBitmap, int paramInt)
  {
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (i > paramInt)
    {
      paramBitmap = OlympicUtil.a(paramBitmap, Math.min(i, 720) / paramInt);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      return Base64Util.a(localByteArrayOutputStream.toByteArray());
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return Base64Util.a(localByteArrayOutputStream.toByteArray());
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(FileUtils.readStringFromAsset("video_story_aiSceneParams.json"));
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private String b(String paramString)
  {
    int i = paramString.length();
    int j = i / 2;
    double d1 = i;
    Double.isNaN(d1);
    paramString = paramString.substring(j, (int)(d1 * 0.1D) + j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("9996ef4aa4fb4378826bc1f1a8409dd7");
    return a(localStringBuilder.toString());
  }
  
  private JSONObject c(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("raw_base64", paramString);
      localJSONObject2.put("only_gender", 0);
      localJSONObject2.put("token", b(paramString));
      paramString = HttpUtil.a("https://tu.qq.com/cgi-bin/qq/get_face_detail.fcg", localJSONObject2.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private JSONObject d(String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(l).hashCode());
    ((StringBuilder)localObject).append("");
    String str = ((StringBuilder)localObject).toString();
    localObject = new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("request_id", str);
      localJSONObject.put("appid", "10301");
      localJSONObject.put("raw_base64", paramString);
      localJSONObject.put("user", "PTU");
      localJSONObject.put("token", b(paramString));
      paramString = HttpUtil.a("https://tu.qq.com/cgi-bin/qq/do_image_classify.fcg", localJSONObject.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localObject;
  }
  
  private TTAutoAISceneType e(String paramString)
  {
    TTAutoAISceneType localTTAutoAISceneType = new TTAutoAISceneType();
    if (paramString == null) {
      return null;
    }
    if (this.d == null)
    {
      this.d = a();
      if (this.d == null) {
        return null;
      }
    }
    JSONArray localJSONArray1 = this.d.optJSONArray("sceneList");
    int i = 0;
    while (i < localJSONArray1.length())
    {
      JSONObject localJSONObject1 = localJSONArray1.optJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject1.optJSONArray("sceneLvTwoList");
      int j = 0;
      while (j < localJSONArray2.length())
      {
        JSONObject localJSONObject2 = localJSONArray2.optJSONObject(j);
        if (localJSONObject2.optString("sceneName").equals(paramString))
        {
          localTTAutoAISceneType.a = localJSONObject1.optInt("sceneLvOne");
          localTTAutoAISceneType.b = localJSONObject2.optInt("sceneLvTwo");
          localTTAutoAISceneType.c = localJSONObject2.optString("sceneName");
          localTTAutoAISceneType.d = localJSONObject2.optString("sceneFilterID");
          localTTAutoAISceneType.e = localJSONObject2.optDouble("sceneFilterPercent");
          localTTAutoAISceneType.f = localJSONObject2.optString("sceneFilterIDForV7");
          localTTAutoAISceneType.g = localJSONObject2.optDouble("sceneFilterPercentV7");
          break;
        }
        JSONArray localJSONArray3 = localJSONObject2.optJSONArray("sceneLabels");
        String[] arrayOfString = new String[localJSONArray3.length()];
        int k = 0;
        while (k < localJSONArray3.length())
        {
          arrayOfString[k] = localJSONArray3.optString(k);
          k += 1;
        }
        int m = arrayOfString.length;
        k = 0;
        while (k < m)
        {
          if (arrayOfString[k].equals(paramString))
          {
            localTTAutoAISceneType.a = localJSONObject1.optInt("sceneLvOne");
            localTTAutoAISceneType.b = localJSONObject2.optInt("sceneLvTwo");
            localTTAutoAISceneType.c = localJSONObject2.optString("sceneName");
            localTTAutoAISceneType.d = localJSONObject2.optString("sceneFilterID");
            localTTAutoAISceneType.e = localJSONObject2.optDouble("sceneFilterPercent");
            localTTAutoAISceneType.f = localJSONObject2.optString("sceneFilterIDForV7");
            localTTAutoAISceneType.g = localJSONObject2.optDouble("sceneFilterPercentV7");
            break;
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    return localTTAutoAISceneType;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = String.format("%032x", new Object[] { new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes())) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a(Bitmap paramBitmap, ArrayList<IAIScene.FaceRect> paramArrayList, IAIScene.GetImageSceneCB paramGetImageSceneCB)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l = System.currentTimeMillis();
      TTAutoAISceneType localTTAutoAISceneType = new TTAutoAISceneType();
      paramArrayList = a(paramBitmap, paramArrayList);
      paramBitmap = a(paramBitmap, 256);
      if (paramArrayList.a)
      {
        if (paramArrayList.b)
        {
          paramBitmap = e(HardCodeUtil.a(2131913082));
        }
        else
        {
          paramBitmap = c(paramBitmap);
          if ((paramBitmap != null) && (!paramBitmap.isNull("retcode")))
          {
            if ((paramBitmap != null) && (paramBitmap.has("retcode")) && (paramBitmap.optInt("retcode") == 0))
            {
              paramBitmap = paramBitmap.optJSONObject("retdata");
              int i = paramBitmap.optInt("age");
              int j = paramBitmap.optInt("gender");
              if (i <= 5) {
                paramBitmap = e(HardCodeUtil.a(2131913085));
              } else if (j < 50) {
                paramBitmap = e(HardCodeUtil.a(2131913083));
              } else {
                paramBitmap = e(HardCodeUtil.a(2131913080));
              }
            }
            else
            {
              paramBitmap = e(HardCodeUtil.a(2131913084));
            }
          }
          else
          {
            paramGetImageSceneCB.a("network error");
            HttpUtil.a(System.currentTimeMillis() - l, 1);
          }
        }
      }
      else
      {
        paramArrayList = d(paramBitmap);
        if ((paramArrayList == null) || (paramArrayList.isNull("retcode"))) {
          break label409;
        }
        paramBitmap = localTTAutoAISceneType;
        if (paramArrayList != null)
        {
          paramBitmap = localTTAutoAISceneType;
          if (paramArrayList.has("retcode"))
          {
            paramBitmap = localTTAutoAISceneType;
            if (paramArrayList.optInt("retcode") == 0)
            {
              paramArrayList = paramArrayList.optJSONObject("retdata");
              paramBitmap = localTTAutoAISceneType;
              if (paramArrayList.has("message"))
              {
                paramBitmap = localTTAutoAISceneType;
                if (paramArrayList.optString("message").equals("ok")) {
                  paramBitmap = a(paramArrayList.optJSONObject("data").optJSONArray("tags"));
                }
              }
            }
          }
        }
      }
      if (paramBitmap == null)
      {
        paramGetImageSceneCB.a("unknown error");
        HttpUtil.a(System.currentTimeMillis() - l, 1);
        return;
      }
      paramGetImageSceneCB.a(paramBitmap);
      l = System.currentTimeMillis() - l;
      HttpUtil.a(l, 0);
      VSReporter.a("record_smart_filter", VSReporter.a(0L, l));
      return;
      label409:
      paramGetImageSceneCB.a("network error");
      l = System.currentTimeMillis() - l;
      HttpUtil.a(l, 1);
      VSReporter.a("record_smart_filter", VSReporter.a(1L, l));
      return;
    }
    paramGetImageSceneCB.a("image is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAIScene
 * JD-Core Version:    0.7.0.1
 */