package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonUtils
{
  public static int getDynamicRateSize(double[] paramArrayOfDouble, Object paramObject)
  {
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() >= 2) {
        try
        {
          double d = Double.parseDouble(paramObject.get(0).toString());
          paramObject = paramObject.get(1).toString();
          if ((!TextUtils.isEmpty(paramObject)) && (d > 0.0D))
          {
            if ("YES".equalsIgnoreCase(paramObject))
            {
              paramArrayOfDouble[0] = d;
              return 1;
            }
            if ("NO".equalsIgnoreCase(paramObject))
            {
              paramArrayOfDouble[0] = d;
              return 2;
            }
          }
          else
          {
            return 0;
          }
        }
        catch (Exception paramArrayOfDouble) {}
      }
    }
    return 0;
  }
  
  public static String getStringValue(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() > paramInt) {}
    }
    while (!(paramObject instanceof String)) {
      for (;;)
      {
        return null;
        try
        {
          paramObject = paramObject.get(paramInt);
          if ((paramObject instanceof String)) {
            return (String)paramObject;
          }
        }
        catch (JSONException paramObject)
        {
          for (;;)
          {
            paramObject.printStackTrace();
            paramObject = null;
          }
        }
      }
    }
    return (String)paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */