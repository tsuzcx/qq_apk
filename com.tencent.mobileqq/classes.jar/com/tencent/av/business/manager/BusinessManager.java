package com.tencent.av.business.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;

public abstract class BusinessManager
{
  protected static final String[] a;
  protected VideoAppInterface a;
  public final String a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MANAGER_ZIMU", "MANAGER_FILTER", "MANAGER_PENDANT", "MANAGER_FACE", "MANAGER_NODE_REPORTER", "MANAGER_SUPPORT", "MANAGER_REDPACKET", "MANAGER_REDPACKET_Entry", "MANAGER_EFFECT_OPERATE", "MANAGER_ZIMU_LIVE", "MANAGER_Voice_Recog", "MANAGER_Tips", "MANAGER_mutex", "MANAGER_MAKEUP", "MANAGER_VIRTUAL_BG", "MANAGER_EFFECT_MATERIAL" };
  }
  
  protected BusinessManager(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append(getClass().getSimpleName());
    paramVideoAppInterface.append("_");
    paramVideoAppInterface.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramVideoAppInterface.toString();
  }
  
  public static void a(String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < 18) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Business_");
      ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      localObject = ((StringBuilder)localObject).toString();
      paramContext = SharedPreUtils.b(paramContext).edit();
      paramContext.putBoolean((String)localObject, paramBoolean);
      paramContext.commit();
      paramContext = new StringBuilder();
      paramContext.append("setPreload zzzzz  bid=");
      paramContext.append(paramInt);
      AVLog.printErrorLog(paramString, paramContext.toString());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("setPreload ERROR : bid=");
    paramContext.append(paramInt);
    AVLog.printErrorLog(paramString, paramContext.toString());
  }
  
  static boolean a(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 18) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Business_");
      ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      localObject = ((StringBuilder)localObject).toString();
      boolean bool = SharedPreUtils.b(paramVideoAppInterface.getApplication()).getBoolean((String)localObject, false);
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("isPreloaded:");
      paramVideoAppInterface.append((String)localObject);
      paramVideoAppInterface.append("|");
      paramVideoAppInterface.append(bool);
      AVLog.printColorLog(paramString, paramVideoAppInterface.toString());
      return bool;
    }
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append("isPreloaded ERROR : bid=");
    paramVideoAppInterface.append(paramInt);
    AVLog.printErrorLog(paramString, paramVideoAppInterface.toString());
    return false;
  }
  
  protected abstract void a();
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessManager
 * JD-Core Version:    0.7.0.1
 */