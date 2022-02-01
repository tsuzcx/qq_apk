package com.tencent.biz.pubaccount.util;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;

public class JsonBinder
{
  private static JsonBinder jdField_a_of_type_ComTencentBizPubaccountUtilJsonBinder;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.pubaccount.util.JsonBinder";
  private Gson jdField_a_of_type_ComGoogleGsonGson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
  
  public static JsonBinder a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountUtilJsonBinder == null) {
      jdField_a_of_type_ComTencentBizPubaccountUtilJsonBinder = new JsonBinder();
    }
    return jdField_a_of_type_ComTencentBizPubaccountUtilJsonBinder;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {}
    try
    {
      return paramClass.newInstance();
    }
    catch (JsonSyntaxException paramString)
    {
      StringBuilder localStringBuilder;
      break label141;
    }
    catch (InstantiationException paramString)
    {
      break label101;
    }
    catch (IllegalAccessException paramString)
    {
      break label61;
    }
    catch (NumberFormatException paramString)
    {
      break label21;
    }
    paramString = this.jdField_a_of_type_ComGoogleGsonGson.fromJson(paramString, paramClass);
    return paramString;
    label21:
    paramString = jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz NumberFormatException error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label61:
    paramString = jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz IllegalAccessException error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label101:
    paramString = jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("clazz new instance instantiation error.");
    Log.e(paramString, localStringBuilder.toString());
    break label150;
    label141:
    Log.e(jdField_a_of_type_JavaLangString, "form json error.");
    label150:
    return null;
  }
  
  public String a(Object paramObject)
  {
    return this.jdField_a_of_type_ComGoogleGsonGson.toJson(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.JsonBinder
 * JD-Core Version:    0.7.0.1
 */