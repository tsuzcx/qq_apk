package com.tencent.intervideo.nowproxy;

import android.content.Context;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import java.util.ArrayList;

public class Global
{
  public static boolean isQueenFreeFlow;
  public static String sAppid;
  protected static Global sGlobal = new Global();
  public static InitData sInitData;
  public static LoginData sLoginData;
  public static NowLoginInfo sNowLoginInfo;
  public static IShadow sShadowImpl;
  protected Context mApplicationContext;
  ArrayList<NowPluginObserver> mObservers = new ArrayList();
  
  public static void addNowPluginObserver(NowPluginObserver paramNowPluginObserver)
  {
    try
    {
      sGlobal.mObservers.add(paramNowPluginObserver);
      return;
    }
    finally
    {
      paramNowPluginObserver = finally;
      throw paramNowPluginObserver;
    }
  }
  
  public static Context getApplicationContext()
  {
    return sGlobal.mApplicationContext;
  }
  
  public static ArrayList<NowPluginObserver> getPluginObservers()
  {
    try
    {
      ArrayList localArrayList = sGlobal.mObservers;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void removeNowPluginObserver(NowPluginObserver paramNowPluginObserver)
  {
    try
    {
      sGlobal.mObservers.remove(paramNowPluginObserver);
      return;
    }
    finally
    {
      paramNowPluginObserver = finally;
      throw paramNowPluginObserver;
    }
  }
  
  public static void setApplicationContext(Context paramContext)
  {
    sGlobal.mApplicationContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.Global
 * JD-Core Version:    0.7.0.1
 */