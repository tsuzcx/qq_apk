package com.tencent.biz.authorize;

import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AbstractConfig
{
  public SharedPreferences a;
  public AbstractConfig a;
  
  public AbstractConfig(SharedPreferences paramSharedPreferences, AbstractConfig paramAbstractConfig)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig = paramAbstractConfig;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public abstract int a(String paramString1, String paramString2);
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (paramBoolean2) {
      bool = true;
    } else {
      bool = false;
    }
    return paramBoolean1 | bool;
  }
  
  public abstract String a();
  
  public abstract JSONArray a(String paramString);
  
  public abstract JSONObject a();
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.AbstractConfig
 * JD-Core Version:    0.7.0.1
 */