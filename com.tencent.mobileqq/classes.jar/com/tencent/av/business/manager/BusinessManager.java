package com.tencent.av.business.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public abstract class BusinessManager
{
  protected static final String[] a;
  public VideoAppInterface a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MANAGER_ZIMU", "MANAGER_FILTER", "MANAGER_PENDANT", "MANAGER_FACE", "MANAGER_NODE_REPORTER", "MANAGER_SUPPORT", "MANAGER_REDPACKET", "MANAGER_REDPACKET_Entry", "MANAGER_EFFECT_OPERATE", "MANAGER_ZIMU_LIVE" };
  }
  
  public BusinessManager(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 10) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      String str = "Business_" + jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean(str, paramBoolean);
      paramContext.commit();
      AVLog.e("BusinessManager", "setPreload zzzzz  bid=" + paramInt);
      return;
    }
    AVLog.e("BusinessManager", "setPreload ERROR : bid=" + paramInt);
  }
  
  static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      String str = "Business_" + jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      boolean bool = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApplication()).getBoolean(str, false);
      AVLog.c("BusinessManager", "isPreloaded:" + str + "|" + bool);
      return bool;
    }
    AVLog.e("BusinessManager", "isPreloaded ERROR : bid=" + paramInt);
    return false;
  }
  
  public abstract void a();
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessManager
 * JD-Core Version:    0.7.0.1
 */