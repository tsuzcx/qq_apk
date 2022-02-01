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
  public static boolean k = false;
  public List<InformationFacePackage.Item> l = new ArrayList();
  public String m;
  public String n = "default";
  public String o;
  public String p;
  public int q;
  public Map<String, Map<String, InformationFacePackage.CityRes>> r;
  
  public InformationFacePackage(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List<InformationFacePackage.Item> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new InformationFacePackage.Item(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Map<String, InformationFacePackage.CityRes>> b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          HashMap localHashMap1 = new HashMap(paramJSONArray.length());
          int i = 0;
          while (i < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(i);
            String str = ((JSONObject)localObject).getString("id");
            localObject = ((JSONObject)localObject).getJSONArray("res");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              HashMap localHashMap2 = new HashMap(((JSONArray)localObject).length());
              int j = 0;
              while (j < ((JSONArray)localObject).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                InformationFacePackage.CityRes localCityRes = new InformationFacePackage.CityRes();
                localCityRes.a = localJSONObject.getString("resname");
                localCityRes.b = localJSONObject.getString("resurl");
                localCityRes.d = localJSONObject.getString("cityname");
                localCityRes.c = localJSONObject.getString("md5");
                localHashMap2.put(localCityRes.d, localCityRes);
                j += 1;
              }
              localHashMap1.put(str, localHashMap2);
            }
            i += 1;
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
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.l.size())) {
      return ((InformationFacePackage.Item)this.l.get(paramInt)).d;
    }
    return null;
  }
  
  public InformationFacePackage.Item b(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.l;
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
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.l.size())) {
      return ((InformationFacePackage.Item)this.l.get(paramInt)).e;
    }
    return null;
  }
  
  public String c()
  {
    return "InformationFacePackage";
  }
  
  public int d()
  {
    return this.l.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage
 * JD-Core Version:    0.7.0.1
 */