package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InformationFacePackage
  extends FacePackage
{
  public static boolean b = false;
  public List<InformationFacePackage.Item> a = new ArrayList();
  public Map<String, Map<String, InformationFacePackage.CityRes>> a;
  public int c;
  public String f;
  public String g = "default";
  public String h;
  public String i;
  
  public InformationFacePackage(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List<InformationFacePackage.Item> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramJSONArray.length())
    {
      localArrayList.add(new InformationFacePackage.Item(paramJSONArray.getJSONObject(j)));
      j += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Map<String, InformationFacePackage.CityRes>> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          HashMap localHashMap1 = new HashMap(paramJSONArray.length());
          int j = 0;
          while (j < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject).getString("id");
            localObject = ((JSONObject)localObject).getJSONArray("res");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              HashMap localHashMap2 = new HashMap(((JSONArray)localObject).length());
              int k = 0;
              while (k < ((JSONArray)localObject).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(k);
                InformationFacePackage.CityRes localCityRes = new InformationFacePackage.CityRes();
                localCityRes.a = localJSONObject.getString("resname");
                localCityRes.b = localJSONObject.getString("resurl");
                localCityRes.d = localJSONObject.getString("cityname");
                localCityRes.c = localJSONObject.getString("md5");
                localHashMap2.put(localCityRes.d, localCityRes);
                k += 1;
              }
              localHashMap1.put(str, localHashMap2);
            }
            j += 1;
          }
          return localHashMap1;
        }
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("FacePackage", 1, paramJSONArray, new Object[0]);
      }
    }
    return null;
  }
  
  public InformationFacePackage.Item a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          InformationFacePackage.Item localItem = (InformationFacePackage.Item)((Iterator)localObject).next();
          if (paramString.equals(localItem.a)) {
            return localItem;
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "InformationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InformationFacePackage.Item)this.a.get(paramInt)).c;
    }
    return null;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InformationFacePackage.Item)this.a.get(paramInt)).d;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage
 * JD-Core Version:    0.7.0.1
 */