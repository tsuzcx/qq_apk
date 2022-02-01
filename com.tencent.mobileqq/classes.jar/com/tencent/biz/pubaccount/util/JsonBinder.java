package com.tencent.biz.pubaccount.util;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonBinder
{
  private static final String TAG = JsonBinder.class.getName();
  private static JsonBinder jsonBinder;
  private Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
  
  public static JsonBinder getInstance()
  {
    if (jsonBinder == null) {
      jsonBinder = new JsonBinder();
    }
    return jsonBinder;
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {}
    try
    {
      return paramClass.newInstance();
    }
    catch (JsonSyntaxException paramString)
    {
      Log.e(TAG, "form json error.");
      return null;
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz new instance instantiation error.");
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz IllegalAccessException error.");
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramClass.getName() + "clazz NumberFormatException error.");
      }
    }
    paramString = this.gson.fromJson(paramString, paramClass);
    return paramString;
  }
  
  public <T> List<T> fromJson(String paramString, Type paramType)
  {
    if (paramString == null) {
      return new ArrayList();
    }
    try
    {
      paramString = (List)this.gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      Log.e(TAG, "form json error.");
    }
    return new ArrayList();
  }
  
  public <T> T generticfromJson(String paramString, Type paramType)
  {
    try
    {
      paramString = this.gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      Log.e(TAG, "form json error.");
    }
    return null;
  }
  
  public String toJson(Object paramObject)
  {
    return this.gson.toJson(paramObject);
  }
  
  public <T> String toJson(List<T> paramList)
  {
    return this.gson.toJson(paramList, new JsonBinder.1(this).getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.JsonBinder
 * JD-Core Version:    0.7.0.1
 */