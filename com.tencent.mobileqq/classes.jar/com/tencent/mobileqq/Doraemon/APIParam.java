package com.tencent.mobileqq.Doraemon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class APIParam
  extends HashMap
{
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_CODE = "code";
  
  public String toJSONString()
  {
    Object localObject = keySet();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          Serializable localSerializable = (Serializable)get(str);
          if (localSerializable != null) {
            localJSONObject.put(str, localSerializable.toString());
          }
        }
        else
        {
          return localJSONObject.toString();
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localJSONObject.put(str, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.APIParam
 * JD-Core Version:    0.7.0.1
 */