package com.tencent.biz.pubaccount.ecshopassit.utils;

import com.google.gson.Gson;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class RedPointUtil
{
  public static ArrayList<RedPointInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      localArrayList = (ArrayList)new Gson().fromJson(SharedPreferencesUtil.a(localAppRuntime, "redpoint_info_" + EcshopUtils.a(localAppRuntime)), new RedPointUtil.1().getType());
    }
    return localArrayList;
  }
  
  public static void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "redpoint_info_" + EcshopUtils.a(localAppRuntime), "");
    }
  }
  
  public static void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + EcshopUtils.a(localAppRuntime), true);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QLog.i("Ecshop_RedPointUtil", 2, "[saveRedpoingClickTag]  taksId: " + paramInt2);
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "redpoint_click_" + paramInt1 + "_" + EcshopUtils.a(localAppRuntime), paramInt2);
    }
  }
  
  public static void a(ArrayList<RedPointInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    SharedPreferencesUtil.a(localAppRuntime, "redpoint_info_" + EcshopUtils.a(localAppRuntime), new Gson().toJson(paramArrayList));
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null) {
        bool = SharedPreferencesUtil.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + EcshopUtils.a(localAppRuntime));
      }
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_RedPointUtil", 1, "[getRedpointClickTag] fail.", localException);
    }
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null)
      {
        paramInt1 = SharedPreferencesUtil.a(localAppRuntime, "redpoint_click_" + paramInt1 + "_" + EcshopUtils.a(localAppRuntime));
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_RedPointUtil", 2, "[getRedpointClickTag] cachedTaskId: " + paramInt1 + " taskId: " + paramInt2);
        }
        return paramInt1 == paramInt2;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_RedPointUtil", 1, "[getRedpointClickTag] fail.", localException);
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + EcshopUtils.a(localAppRuntime), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil
 * JD-Core Version:    0.7.0.1
 */