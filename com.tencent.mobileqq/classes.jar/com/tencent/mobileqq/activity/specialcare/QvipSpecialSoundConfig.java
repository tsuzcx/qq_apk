package com.tencent.mobileqq.activity.specialcare;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundConfig
{
  public List<QvipSpecialSoundConfig.SpecialSound> a = new ArrayList();
  
  public static QvipSpecialSoundConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new QvipSpecialSoundConfig();
    }
    localQvipSpecialSoundConfig = new QvipSpecialSoundConfig();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.getString("items"));
      if (paramJSONObject.length() >= 0)
      {
        int j = paramJSONObject.length();
        int i = 0;
        while (i < j)
        {
          QvipSpecialSoundConfig.SpecialSound localSpecialSound = QvipSpecialSoundConfig.SpecialSound.a(paramJSONObject.getJSONObject(i));
          localQvipSpecialSoundConfig.a.add(localSpecialSound);
          i += 1;
        }
      }
      return localQvipSpecialSoundConfig;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localQvipSpecialSoundConfig;
    }
    catch (OutOfMemoryError paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localQvipSpecialSoundConfig;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundConfig
 * JD-Core Version:    0.7.0.1
 */