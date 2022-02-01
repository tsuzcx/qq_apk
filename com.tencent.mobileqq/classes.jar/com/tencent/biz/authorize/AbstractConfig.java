package com.tencent.biz.authorize;

import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AbstractConfig
{
  public SharedPreferences a;
  public AbstractConfig b;
  
  public AbstractConfig(SharedPreferences paramSharedPreferences, AbstractConfig paramAbstractConfig)
  {
    this.a = paramSharedPreferences;
    this.b = paramAbstractConfig;
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
  
  public abstract JSONArray a(String paramString);
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract String c();
  
  public abstract String d();
  
  public abstract JSONObject e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.AbstractConfig
 * JD-Core Version:    0.7.0.1
 */