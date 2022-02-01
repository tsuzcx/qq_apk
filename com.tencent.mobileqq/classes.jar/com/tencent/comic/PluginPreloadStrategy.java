package com.tencent.comic;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy.PluginPreloadInfo;
import com.tencent.comic.api.plugin.PreloadPublicParam;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class PluginPreloadStrategy
{
  public IQQComicPluginPreloadStrategy.PluginPreloadInfo a;
  private final IQQComicPluginPreloadStrategy a;
  
  public PluginPreloadStrategy(IQQComicPluginPreloadStrategy paramIQQComicPluginPreloadStrategy)
  {
    this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy = paramIQQComicPluginPreloadStrategy;
    if (paramIQQComicPluginPreloadStrategy != null) {
      this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo = IQQComicPluginPreloadStrategy.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo;
    }
    if (this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo == null) {
      this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy$PluginPreloadInfo = new IQQComicPluginPreloadStrategy.PluginPreloadInfo();
    }
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (paramString == null) {
        return 3;
      }
      Object localObject = (IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "");
      int i1 = 0;
      int k;
      int n;
      if (localObject != null)
      {
        k = ((IRedTouchManager)localObject).getNumRedShowNumByAppSet(0);
        List localList = ((IRedTouchManager)localObject).requestAppInfoListByAppSet(0);
        localObject = ((IRedTouchManager)localObject).requestSettingInfoList();
        i = k;
        if (localList != null)
        {
          i = k;
          if (!localList.isEmpty())
          {
            n = 0;
            boolean bool1 = false;
            for (i = 0;; i = j)
            {
              m = k;
              bool2 = bool1;
              j = i;
              if (n >= localList.size()) {
                break;
              }
              BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList.get(n);
              bool2 = bool1;
              j = i;
              if (localAppInfo.mission_level.get() == 0)
              {
                bool2 = bool1;
                j = i;
                if (!localAppInfo.path.get().contains(".")) {
                  if (localAppInfo.iNewFlag.get() != 1)
                  {
                    bool2 = bool1;
                    j = i;
                  }
                  else
                  {
                    j = 0;
                    while ((j < ((List)localObject).size()) && (localAppInfo.uiAppId.get() != ((BusinessInfoCheckUpdate.AppSetting)((List)localObject).get(j)).appid.get())) {
                      j += 1;
                    }
                    if ((j < ((List)localObject).size()) && (!((BusinessInfoCheckUpdate.AppSetting)((List)localObject).get(j)).setting.get()))
                    {
                      bool2 = bool1;
                      j = i;
                    }
                    else
                    {
                      i += 1;
                      bool2 = bool1;
                      j = i;
                      if (paramString.equals(localAppInfo.path.get()))
                      {
                        bool2 = true;
                        j = i;
                      }
                    }
                  }
                }
              }
              n += 1;
              bool1 = bool2;
            }
          }
        }
      }
      else
      {
        i = 0;
      }
      boolean bool2 = false;
      int j = 0;
      int m = i;
      paramAppRuntime = (IReadInJoyManager)paramAppRuntime.getRuntimeService(IReadInJoyManager.class, "");
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.obtainLatestNotifyRedTouchInfo();
        if (paramAppRuntime != null) {
          i = paramAppRuntime.a();
        } else {
          i = 0;
        }
        k = i1;
        n = i;
        if (paramAppRuntime != null)
        {
          k = i1;
          n = i;
          if (paramAppRuntime.a())
          {
            k = 1;
            n = i;
          }
        }
      }
      else
      {
        n = 0;
        k = i1;
      }
      int i = n + m;
      k += j;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("; Message num: ");
        paramAppRuntime.append(m);
        paramAppRuntime.append("; Leba redTouch: ");
        paramAppRuntime.append(j);
        paramAppRuntime.append("; Business has redTouch: ");
        paramAppRuntime.append(bool2);
        paramAppRuntime.append("; Total redTouch: ");
        paramAppRuntime.append(k);
        paramAppRuntime.append("; Total num: ");
        paramAppRuntime.append(i);
        QLog.d("PluginPreloadStrategy", 2, paramAppRuntime.toString());
      }
      if (bool2)
      {
        if ((i == 0) && (k == 1)) {
          return 4;
        }
        return 1;
      }
      if (i <= 0)
      {
        if (k > 0) {
          return 2;
        }
        return 3;
      }
      return 2;
    }
    return 3;
  }
  
  private static void a(IQQComicPluginUtil.ExtraResult paramExtraResult, String paramString)
  {
    if (paramExtraResult != null)
    {
      paramExtraResult.jdField_a_of_type_Int = 2;
      paramExtraResult.jdField_a_of_type_JavaLangString = paramString;
    }
    if (QLog.isColorLevel())
    {
      paramExtraResult = new StringBuilder();
      paramExtraResult.append("pluginType: ");
      paramExtraResult.append(paramString);
      QLog.d("PluginPreloadStrategy", 2, paramExtraResult.toString());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 1 << Calendar.getInstance().get(7) - 1) == 0) {
      return false;
    }
    return (1 << Calendar.getInstance().get(11) & paramInt2) != 0;
  }
  
  public static boolean a(PreloadPublicParam paramPreloadPublicParam, String paramString1, AppRuntime paramAppRuntime, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    if (paramPreloadPublicParam == null) {
      return false;
    }
    if ((paramPreloadPublicParam.jdField_h_of_type_Boolean) && (!a(paramString2, paramAppRuntime)))
    {
      a(paramExtraResult, "preload:fail:notinleba");
      return false;
    }
    if (paramPreloadPublicParam.jdField_b_of_type_Boolean)
    {
      int i = a(paramAppRuntime, paramString1);
      if ((paramPreloadPublicParam.jdField_c_of_type_Boolean) && (i == 4))
      {
        a(paramExtraResult, "preload:ok:reddotonly");
        return true;
      }
      if ((paramPreloadPublicParam.jdField_d_of_type_Boolean) && ((i == 1) || (i == 4)))
      {
        a(paramExtraResult, "preload:ok:reddot");
        return true;
      }
      if ((paramPreloadPublicParam.jdField_e_of_type_Boolean) && (i == 2))
      {
        a(paramExtraResult, "preload:fail:lebareddot");
        return false;
      }
    }
    if ((paramPreloadPublicParam.a) && (!a(paramPreloadPublicParam.jdField_b_of_type_Int, paramPreloadPublicParam.jdField_c_of_type_Int)))
    {
      a(paramExtraResult, "preload:fail:timecontrol");
      return false;
    }
    if ((paramPreloadPublicParam.j) && (paramInt < paramPreloadPublicParam.jdField_f_of_type_Int))
    {
      a(paramExtraResult, "preload:fail:usedtimeslimit");
      return false;
    }
    if (paramPreloadPublicParam.jdField_i_of_type_Boolean)
    {
      long l = paramPreloadPublicParam.jdField_e_of_type_Int * 60 * 60 * 1000;
      if (System.currentTimeMillis() - paramLong > l)
      {
        a(paramExtraResult, "preload:fail:notactive");
        return false;
      }
    }
    if (paramPreloadPublicParam.jdField_f_of_type_Boolean)
    {
      if ((System.currentTimeMillis() - paramLong) / 1000L <= paramPreloadPublicParam.jdField_d_of_type_Int) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        if (paramPreloadPublicParam.jdField_g_of_type_Boolean)
        {
          a(paramExtraResult, "preload:ok:cdperiod");
          return true;
        }
        a(paramExtraResult, "preload:fail:cdperiod");
        return false;
      }
    }
    if ((paramPreloadPublicParam.k) && (paramPreloadPublicParam.jdField_g_of_type_Int > 0) && (!a(paramString1, paramAppRuntime.getCurrentAccountUin(), paramPreloadPublicParam.jdField_g_of_type_Int, paramArrayOfInt, paramPreloadPublicParam.jdField_h_of_type_Int, paramPreloadPublicParam.jdField_i_of_type_Int)))
    {
      a(paramExtraResult, "preload:fail:notinuserlearn");
      return false;
    }
    a(paramExtraResult, "preload:ok:normal");
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramInt1 > 0))
    {
      if (paramArrayOfInt == null) {
        return false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("_userlearn_lasttime:");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_userlearn_timearea:");
      ((StringBuilder)localObject2).append(paramString2);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append("_userlearn_timearea_inhour:");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(":");
      localObject3 = ((StringBuilder)localObject3).toString();
      SharedPreferences localSharedPreferences = AppHelper.a().getSharedPreferences("ppp_profile", SecMsgUtil.a());
      long l = localSharedPreferences.getLong((String)localObject1, 0L);
      int i = localSharedPreferences.getInt((String)localObject2, 3);
      if ((System.currentTimeMillis() - l <= 86400000L) && (paramInt1 == i))
      {
        paramString2 = new int[i];
        paramInt1 = 0;
        for (;;)
        {
          paramString1 = paramString2;
          if (paramInt1 >= i) {
            break;
          }
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject3);
          paramString1.append(paramInt1);
          paramString2[paramInt1] = localSharedPreferences.getInt(paramString1.toString(), paramInt1 + 20);
          paramInt1 += 1;
        }
      }
      paramString1 = a(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      if (paramString1 != null)
      {
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          paramString2 = localSharedPreferences.edit();
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append((String)localObject3);
          paramArrayOfInt.append(paramInt2);
          paramString2.putInt(paramArrayOfInt.toString(), paramString1[paramInt2]).commit();
          paramInt2 += 1;
        }
        localSharedPreferences.edit().putInt((String)localObject2, paramInt1).commit();
        localSharedPreferences.edit().putLong((String)localObject1, System.currentTimeMillis()).commit();
      }
      if (paramString1 != null)
      {
        paramInt2 = Calendar.getInstance().get(11);
        paramInt3 = paramString1.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt3)
        {
          if (paramInt2 == paramString1[paramInt1]) {
            return true;
          }
          paramInt1 += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "");
    if (paramAppRuntime == null)
    {
      QLog.d("PluginPreloadStrategy", 1, "checkInLebaList lebaHelperService == null");
      return false;
    }
    paramAppRuntime = paramAppRuntime.getLebaShowList();
    if (paramAppRuntime != null)
    {
      if (paramAppRuntime.size() == 0) {
        return false;
      }
      paramAppRuntime = paramAppRuntime.iterator();
      while (paramAppRuntime.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)paramAppRuntime.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName != null) && (localLebaViewItem.a.strPkgName.contains(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = null;
    Object localObject = arrayOfInt;
    if (paramArrayOfInt != null)
    {
      localObject = arrayOfInt;
      if (paramInt1 > 0)
      {
        if (paramInt1 > paramArrayOfInt.length) {
          return null;
        }
        localObject = new PluginPreloadStrategy.KMeans(paramInt3);
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2) {
            return null;
          }
          return ((PluginPreloadStrategy.KMeans)localObject).a(paramArrayOfInt, paramInt1);
        }
        paramInt2 = ((PluginPreloadStrategy.KMeans)localObject).a(paramArrayOfInt, paramInt1);
        if (paramInt2 == -1) {
          return null;
        }
        paramInt3 = paramInt2 - paramInt1 / 2;
        paramInt2 = paramInt3;
        if (paramInt3 < 0) {
          paramInt2 = paramInt3 + paramArrayOfInt.length;
        }
        arrayOfInt = new int[paramInt1];
        paramInt3 = paramInt2;
        paramInt2 = 0;
        for (;;)
        {
          localObject = arrayOfInt;
          if (paramInt2 >= paramInt1) {
            break;
          }
          arrayOfInt[paramInt2] = paramInt3;
          int i = paramInt3 + 1;
          if (i >= paramArrayOfInt.length) {
            paramInt3 = -paramArrayOfInt.length;
          } else {
            paramInt3 = 0;
          }
          paramInt3 = i + paramInt3;
          paramInt2 += 1;
        }
      }
    }
    return localObject;
  }
  
  protected void a()
  {
    IQQComicPluginPreloadStrategy localIQQComicPluginPreloadStrategy = this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy;
    if (localIQQComicPluginPreloadStrategy != null) {
      localIQQComicPluginPreloadStrategy.a();
    }
  }
  
  public void a(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    IQQComicPluginPreloadStrategy localIQQComicPluginPreloadStrategy = this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy;
    if (localIQQComicPluginPreloadStrategy != null) {
      localIQQComicPluginPreloadStrategy.a(paramExtraResult);
    }
  }
  
  protected boolean a(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    IQQComicPluginPreloadStrategy localIQQComicPluginPreloadStrategy = this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy;
    if (localIQQComicPluginPreloadStrategy != null) {
      return localIQQComicPluginPreloadStrategy.a(paramExtraResult);
    }
    return false;
  }
  
  protected boolean b(IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    IQQComicPluginPreloadStrategy localIQQComicPluginPreloadStrategy = this.jdField_a_of_type_ComTencentComicApiPluginIQQComicPluginPreloadStrategy;
    if (localIQQComicPluginPreloadStrategy != null) {
      localIQQComicPluginPreloadStrategy.b(paramExtraResult);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.PluginPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */