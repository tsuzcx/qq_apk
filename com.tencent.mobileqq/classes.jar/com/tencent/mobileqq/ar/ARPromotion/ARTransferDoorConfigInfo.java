package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ARTransferDoorConfigInfo
{
  public boolean a = false;
  public int b = 0;
  public int c = 1;
  public int d = 1;
  public int e = 0;
  public String f;
  public long g;
  public String h;
  public String i;
  public ArrayList<ARTransferDoorConfigInfo.FragmentInfo> j = new ArrayList();
  public String k = "https://www.qq.com";
  
  public static ARTransferDoorConfigInfo a(JSONObject paramJSONObject)
  {
    localARTransferDoorConfigInfo = new ARTransferDoorConfigInfo();
    try
    {
      if (paramJSONObject.has("preDownload")) {
        localARTransferDoorConfigInfo.b = paramJSONObject.optInt("preDownload");
      }
      if (paramJSONObject.has("Video360Restart")) {
        localARTransferDoorConfigInfo.c = paramJSONObject.optInt("Video360Restart");
      }
      int m;
      if (paramJSONObject.has("Video360Repeat"))
      {
        localARTransferDoorConfigInfo.d = paramJSONObject.optInt("Video360Repeat");
        if (localARTransferDoorConfigInfo.d <= 0) {
          m = 2147483647;
        } else {
          m = localARTransferDoorConfigInfo.d;
        }
        localARTransferDoorConfigInfo.d = m;
      }
      if (paramJSONObject.has("Video360ConnectType")) {
        localARTransferDoorConfigInfo.e = paramJSONObject.optInt("Video360ConnectType");
      }
      Object localObject1;
      if (paramJSONObject.has("TraversingResource"))
      {
        localObject1 = paramJSONObject.optJSONObject("TraversingResource");
        if (((JSONObject)localObject1).has("TraversingResourceSize")) {
          localARTransferDoorConfigInfo.g = ((JSONObject)localObject1).optLong("TraversingResourceSize");
        }
        if (((JSONObject)localObject1).has("TraversingResourceUrl")) {
          localARTransferDoorConfigInfo.f = ((JSONObject)localObject1).optString("TraversingResourceUrl");
        }
        if (((JSONObject)localObject1).has("TraversingResourceMD5")) {
          localARTransferDoorConfigInfo.h = ((JSONObject)localObject1).optString("TraversingResourceMD5");
        }
      }
      if (paramJSONObject.has("FragmentInfos"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("FragmentInfos");
        int i1 = paramJSONObject.length();
        m = 0;
        while (m < i1)
        {
          Object localObject2 = paramJSONObject.getJSONObject(m);
          localObject1 = new ARTransferDoorConfigInfo.FragmentInfo();
          if (((JSONObject)localObject2).has("name")) {
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).a = ((JSONObject)localObject2).getString("name");
          }
          if (((JSONObject)localObject2).has("md5")) {
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).b = ((JSONObject)localObject2).getString("md5");
          }
          if (((JSONObject)localObject2).has("url")) {
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).c = ((JSONObject)localObject2).getString("url");
          }
          int n;
          if (((JSONObject)localObject2).has("repeat"))
          {
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).d = ((JSONObject)localObject2).optInt("repeat");
            if (((ARTransferDoorConfigInfo.FragmentInfo)localObject1).d <= 0) {
              n = 2147483647;
            } else {
              n = ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).d;
            }
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).d = n;
          }
          if (((JSONObject)localObject2).has("triggerType")) {
            ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).e = ((JSONObject)localObject2).optInt("triggerType");
          }
          if (((JSONObject)localObject2).has("trigger"))
          {
            localObject2 = ((JSONObject)localObject2).getString("trigger").split("\\|");
            if (localObject2 != null)
            {
              n = localObject2.length;
              if (n == 2) {
                try
                {
                  ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).f = Integer.parseInt(localObject2[0]);
                  ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).g = Integer.parseInt(localObject2[1]);
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).f = 0;
                  ((ARTransferDoorConfigInfo.FragmentInfo)localObject1).g = 0;
                  QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, numberException\n%s", new Object[] { localNumberFormatException }));
                }
              }
            }
          }
          localARTransferDoorConfigInfo.j.add(localObject1);
          m += 1;
        }
      }
      return localARTransferDoorConfigInfo;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ARTransferDoorConfigInfo", 1, String.format("ARTransferDoorConfigInfo parseJson, Exception\n%s", new Object[] { paramJSONObject }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo
 * JD-Core Version:    0.7.0.1
 */