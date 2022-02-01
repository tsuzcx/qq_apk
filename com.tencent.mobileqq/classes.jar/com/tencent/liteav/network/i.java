package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  protected static i a = new i();
  private Context b = null;
  private long c = 3L;
  
  private i.a a(String paramString, boolean paramBoolean)
  {
    if (b(paramString)) {
      return null;
    }
    try
    {
      localObject5 = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
      if (b((String)localObject5)) {
        return null;
      }
      localObject5 = new JSONObject((String)localObject5).optJSONObject(paramString);
      if (localObject5 != null) {
        break label374;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Object localObject5;
      long l;
      TXCLog.e("UploadQualityData", "get quality data failed.", paramString);
      return null;
    }
    localObject5 = ((JSONObject)localObject5).optJSONArray(paramString);
    if (localObject5 == null) {
      return null;
    }
    l = ((JSONArray)localObject5).length();
    if (l == 0L) {
      return null;
    }
    for (;;)
    {
      int i;
      float f5;
      float f1;
      float f2;
      float f3;
      float f4;
      if (i < l)
      {
        JSONObject localJSONObject = ((JSONArray)localObject5).getJSONObject(i);
        f5 = (float)localJSONObject.optLong("networkRTT");
        Object localObject1;
        double d1 = localObject1;
        double d2 = localJSONObject.optDouble("avgBlockCnt");
        Double.isNaN(d1);
        f1 = (float)(d1 + d2);
        Object localObject2;
        d1 = localObject2;
        d2 = localJSONObject.optDouble("avgVideoQue");
        Double.isNaN(d1);
        f2 = (float)(d1 + d2);
        Object localObject3;
        d1 = localObject3;
        d2 = localJSONObject.optDouble("avgAudioQue");
        Double.isNaN(d1);
        f3 = (float)(d1 + d2);
        paramString = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(localJSONObject.optLong("networkRTT")), Double.valueOf(localJSONObject.optDouble("avgBlockCnt")), Double.valueOf(localJSONObject.optDouble("avgVideoQue")), Double.valueOf(localJSONObject.optDouble("avgAudioQue")) });
        i += 1;
        Object localObject4;
        localObject4 += f5;
      }
      else
      {
        f5 = (float)l;
        f4 /= f5;
        f1 /= f5;
        f2 /= f5;
        f3 /= f5;
        paramString = new i.a(this);
        paramString.a = f4;
        paramString.b = f1;
        paramString.c = f2;
        paramString.d = f3;
        paramString.e = l;
        return paramString;
        label374:
        if (paramBoolean)
        {
          paramString = "DomainArrayData";
          break;
        }
        paramString = "OriginArrayData";
        break;
        paramString = "";
        f4 = 0.0F;
        i = 0;
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
      }
    }
  }
  
  public static i a()
  {
    return a;
  }
  
  private boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private JSONObject c(String paramString)
  {
    if (!b(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        TXCLog.e("UploadQualityData", "failed to parse json string", paramString);
      }
    }
    return new JSONObject();
  }
  
  private void d()
  {
    this.c = c.a().a("Network", "QualityDataCacheCount");
    long l = this.c;
    if ((l == -1L) || (l < 3L)) {
      this.c = 3L;
    }
  }
  
  public long a(String paramString)
  {
    Context localContext = this.b;
    if (localContext != null) {
      return localContext.getSharedPreferences("com.tencent.liteav.network", 0).getLong(paramString, 0L);
    }
    return 0L;
  }
  
  public void a(Context paramContext)
  {
    if (this.b == null) {
      this.b = paramContext.getApplicationContext();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Context localContext = this.b;
    if (localContext != null) {
      localContext.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(paramString, paramLong).commit();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i;
    if (c.a().a("Network", "QualityDataCacheCount") > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    if (b(paramString)) {
      return;
    }
    String str;
    try
    {
      localSharedPreferences = this.b.getSharedPreferences("com.tencent.liteav.network", 0);
      localJSONObject = c(localSharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
      localObject1 = localJSONObject.optJSONObject(paramString);
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label389;
      }
      localObject2 = new JSONObject();
    }
    catch (Exception paramString)
    {
      SharedPreferences localSharedPreferences;
      JSONObject localJSONObject;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      TXCLog.e("UploadQualityData", "build json object failed.", paramString);
      return;
    }
    localObject3 = ((JSONObject)localObject2).optJSONArray(str);
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = new JSONArray();
    }
    localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("totalTime", paramLong2);
    ((JSONObject)localObject3).put("networkRTT", paramLong3);
    ((JSONObject)localObject3).put("avgBlockCnt", paramFloat1);
    ((JSONObject)localObject3).put("avgVideoQue", paramFloat2);
    ((JSONObject)localObject3).put("avgAudioQue", paramFloat3);
    ((JSONArray)localObject1).put(localObject3);
    j = ((JSONArray)localObject1).length();
    paramLong1 = j;
    localObject3 = localObject1;
    if (paramLong1 > this.c)
    {
      localObject3 = new JSONArray();
      i = (int)(paramLong1 - this.c);
      while (i < j)
      {
        ((JSONArray)localObject3).put(((JSONArray)localObject1).get(i));
        i += 1;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject2).put(str, localObject3);
      localJSONObject.put(paramString, localObject2);
      paramString = localJSONObject.toString();
      localSharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", paramString).commit();
      return;
      label389:
      if (paramLong1 == 3L)
      {
        str = "DomainArrayData";
        break;
      }
      str = "OriginArrayData";
      break;
    }
  }
  
  public String b()
  {
    int i;
    label59:
    label62:
    do
    {
      try
      {
        if (this.b == null) {
          break label59;
        }
        i = f.e(this.b);
        if (i != 0) {
          break label62;
        }
        return "";
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get network type failed.");
        localStringBuilder.append(localException.getMessage());
        TXCLog.e("UploadQualityData", localStringBuilder.toString());
      }
      return "xg:";
      return "";
      if (i == 1) {
        return "wifi:";
      }
      if (i == 2) {
        return "4g:";
      }
      if (i == 3) {
        return "3g:";
      }
      if (i == 4) {
        return "2g:";
      }
    } while (i != 5);
    return "ethernet:";
  }
  
  public boolean c()
  {
    d();
    Object localObject1 = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isDomainAddressBetter: accessID = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" minQualityDataCount = ");
    ((StringBuilder)localObject2).append(this.c);
    localObject2 = ((StringBuilder)localObject2).toString();
    i.a locala1 = a((String)localObject1, true);
    i.a locala2 = a((String)localObject1, false);
    localObject1 = localObject2;
    if (locala1 != null) {
      localObject1 = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject2, Long.valueOf(locala1.e), Float.valueOf(locala1.a), Float.valueOf(locala1.b), Float.valueOf(locala1.c), Float.valueOf(locala1.d) });
    }
    localObject2 = localObject1;
    if (locala2 != null) {
      localObject2 = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject1, Long.valueOf(locala2.e), Float.valueOf(locala2.a), Float.valueOf(locala2.b), Float.valueOf(locala2.c), Float.valueOf(locala2.d) });
    }
    TXCLog.e("UploadQualityData", (String)localObject2);
    if ((locala1 != null) && (locala1.e >= this.c) && (locala2 != null))
    {
      if (locala2.e < this.c) {
        return false;
      }
      if ((locala1.b < locala2.b) && (locala1.c < locala2.c) && (locala1.d < locala2.d)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.i
 * JD-Core Version:    0.7.0.1
 */