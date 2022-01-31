package com.tencent.mobileqq.activity.specialcare;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yls;

public class QvipSpecialSoundConfig
{
  public List a = new ArrayList();
  
  public static QvipSpecialSoundConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new QvipSpecialSoundConfig();
    }
    for (;;)
    {
      return paramJSONObject;
      localQvipSpecialSoundConfig = new QvipSpecialSoundConfig();
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.getString("items"));
        paramJSONObject = localQvipSpecialSoundConfig;
        if (localJSONArray == null) {
          continue;
        }
        paramJSONObject = localQvipSpecialSoundConfig;
        if (localJSONArray.length() < 0) {
          continue;
        }
        int j = localJSONArray.length();
        int i = 0;
        for (;;)
        {
          paramJSONObject = localQvipSpecialSoundConfig;
          if (i >= j) {
            break;
          }
          paramJSONObject = yls.a(localJSONArray.getJSONObject(i));
          localQvipSpecialSoundConfig.a.add(paramJSONObject);
          i += 1;
        }
        return localQvipSpecialSoundConfig;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localQvipSpecialSoundConfig;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localQvipSpecialSoundConfig;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundConfig
 * JD-Core Version:    0.7.0.1
 */