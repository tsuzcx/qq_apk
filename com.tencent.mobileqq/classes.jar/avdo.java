import BOSSStrategyCenter.tAdvDesc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class avdo
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static avdt a(tAdvDesc paramtAdvDesc, SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramtAdvDesc == null)
    {
      paramtAdvDesc = null;
      return paramtAdvDesc;
    }
    Object localObject3 = null;
    String str1 = paramtAdvDesc.task_id + "";
    String str2 = paramtAdvDesc.res_traceinfo;
    paramtAdvDesc = paramtAdvDesc.res_data;
    if (TextUtils.isEmpty(paramtAdvDesc)) {
      return null;
    }
    paramSharedPreferences = localObject3;
    for (;;)
    {
      try
      {
        Object localObject4 = new JSONObject(paramtAdvDesc);
        paramSharedPreferences = localObject3;
        String str3 = ((JSONObject)localObject4).getString("showStartTime");
        paramSharedPreferences = localObject3;
        String str4 = ((JSONObject)localObject4).getString("showEndTime");
        paramSharedPreferences = localObject3;
        int j = ((JSONObject)localObject4).getInt("resourceType");
        int k;
        int m;
        Object localObject2;
        Object localObject1;
        int i2;
        int i3;
        boolean bool;
        switch (j)
        {
        case 0: 
          paramSharedPreferences = localObject3;
          k = avds.a(((JSONObject)localObject4).getString("showPriority"));
          paramSharedPreferences = localObject3;
          m = ((JSONObject)localObject4).getInt("linkType");
          paramSharedPreferences = localObject3;
          localObject2 = ((JSONObject)localObject4).getString("linkURL");
          if (m == 1)
          {
            localObject1 = localObject2;
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              paramSharedPreferences = localObject3;
              if (!((String)localObject2).startsWith("http"))
              {
                paramSharedPreferences = localObject3;
                localObject1 = "https://" + (String)localObject2;
              }
            }
            paramSharedPreferences = localObject3;
            localObject2 = new StringBuilder().append((String)localObject1);
            paramSharedPreferences = localObject3;
            if (!((String)localObject1).contains("?")) {
              break label671;
            }
            localObject1 = "&";
            paramSharedPreferences = localObject3;
            localObject1 = bhdv.a(paramString, str2, (String)localObject1);
            paramSharedPreferences = localObject3;
            int n = avds.a(((JSONObject)localObject4).getString("androidMinimumMemorySize"));
            paramSharedPreferences = localObject3;
            int i1 = avds.a(((JSONObject)localObject4).getString("androidMinimumOSVersion"));
            paramSharedPreferences = localObject3;
            i2 = avds.a(((JSONObject)localObject4).getString("thirdPartyReportPlatform"));
            paramSharedPreferences = localObject3;
            localObject2 = ((JSONObject)localObject4).getString("thirdPartyReportURLForExposure");
            paramSharedPreferences = localObject3;
            i3 = avds.a(((JSONObject)localObject4).getString("shouldShowAdMark"));
            if ((i1 != 0) || (n != 0)) {
              break label678;
            }
            i = 0;
            paramSharedPreferences = localObject3;
            bool = a(i, n, i1);
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty(str1))
            {
              paramSharedPreferences = localObject3;
              if (!TextUtils.isEmpty(str3))
              {
                paramSharedPreferences = localObject3;
                if (!TextUtils.isEmpty(str4))
                {
                  paramSharedPreferences = localObject3;
                  if (!TextUtils.isEmpty(paramtAdvDesc)) {
                    continue;
                  }
                }
              }
            }
            paramSharedPreferences = localObject3;
            QLog.i("QSplash@QbossSplashCacheManager", 1, "downloadUrl = " + paramtAdvDesc + ", mAdID = " + str1 + ", mBeginTime = " + str3 + ", mEndTime = " + str4);
            return null;
            paramSharedPreferences = localObject3;
            paramtAdvDesc = ((JSONObject)localObject4).getString("imageURL");
          }
          break;
        case 1: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("gifURL");
          break;
        case 2: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("videoURL");
          continue;
          paramSharedPreferences = localObject3;
          localObject4 = new avdu();
          paramSharedPreferences = localObject3;
          ((avdu)localObject4).g(paramString).a(str1).b(str3).c(str4).c(j).d(paramtAdvDesc).d(m).e((String)localObject1).b(bool).f((String)localObject2).b(k).e(i2).h(str2).i("").a(i3);
          paramSharedPreferences = localObject3;
          paramString = ((avdu)localObject4).a();
          paramtAdvDesc = paramString;
          paramSharedPreferences = paramString;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramSharedPreferences = paramString;
          QLog.i("QSplash@QbossSplashCacheManager", 2, paramString.toString());
          return paramString;
          localObject1 = localObject2;
          break;
        default: 
          paramtAdvDesc = "";
          continue;
          localObject1 = "?";
        }
      }
      catch (Exception paramtAdvDesc)
      {
        return paramSharedPreferences;
      }
      label671:
      continue;
      label678:
      int i = 1;
    }
  }
  
  public static ArrayList<avdt> a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject1;
      int i;
      Object localObject2;
      try
      {
        axnq.a(paramQQAppInterface.getApp(), avds.a(paramString));
        localObject1 = a(BaseApplicationImpl.getContext(), paramString);
        localArrayList.clear();
        i = 0;
        try
        {
          if (i < paramArrayList.size())
          {
            localObject2 = (tAdvDesc)paramArrayList.get(i);
            if ((localObject2 == null) || (((tAdvDesc)localObject2).pattern_id != 1014)) {
              break label424;
            }
            localObject2 = a((tAdvDesc)localObject2, (SharedPreferences)localObject1, paramString);
            if (localObject2 == null) {
              break label424;
            }
            localArrayList.add(localObject2);
            if ((((avdt)localObject2).jdField_b_of_type_Int == 3) || (((avdt)localObject2).jdField_b_of_type_Int == 2)) {
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(((avdt)localObject2).f, null);
            }
            avds.a.put(((avdt)localObject2).jdField_b_of_type_JavaLangString, localObject2);
          }
        }
        finally {}
      }
      catch (Exception paramArrayList)
      {
        return localArrayList;
      }
      if (localArrayList.size() > 0)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = avds.a(BaseApplicationImpl.getContext(), paramString);
        HashSet localHashSet = new HashSet();
        paramArrayList = new StringBuffer();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          avdt localavdt = (avdt)localIterator.next();
          String str = localavdt.jdField_b_of_type_JavaLangString;
          localHashSet.add(str);
          paramArrayList.append(str).append(",").append(localavdt.jdField_c_of_type_JavaLangString).append(",").append(localavdt.jdField_d_of_type_JavaLangString).append(",");
          if (((Set)localObject2).contains(str))
          {
            ((Set)localObject2).remove(str);
            a((SharedPreferences.Editor)localObject1, localavdt, false);
          }
          else
          {
            a((SharedPreferences.Editor)localObject1, localavdt, true);
          }
        }
        ((SharedPreferences.Editor)localObject1).putString("splash_ad_ids", avds.a(localHashSet));
        ((SharedPreferences.Editor)localObject1).apply();
        localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
        ((SharedPreferences.Editor)localObject1).putString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramString, paramArrayList.substring(0, paramArrayList.length() - 1));
        ((SharedPreferences.Editor)localObject1).apply();
        avdp.a(paramQQAppInterface, localArrayList);
        return localArrayList;
        label424:
        i += 1;
      }
    }
  }
  
  public static void a(SharedPreferences.Editor paramEditor, avdt paramavdt, boolean paramBoolean)
  {
    paramEditor.putString("qboss_splash_ad_begin_time_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_c_of_type_JavaLangString);
    paramEditor.putString("qboss_splash_ad_end_time_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_d_of_type_JavaLangString);
    paramEditor.putInt("qbosss_plash_ad_content_type_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_a_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_download_url_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_e_of_type_JavaLangString);
    paramEditor.putInt("qbosss_splash_ad_jumptype_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_b_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_jump_h5_url_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.f);
    paramEditor.putInt("qboss_splash_ad_showpriority_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_d_of_type_Int);
    paramEditor.putBoolean("qboss_exposure_is_low_device_limit_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_a_of_type_Boolean);
    paramEditor.putInt("qboss_splash_ad_exposure_platform_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_c_of_type_Int);
    paramEditor.putString("qboss_splash_info_report_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.j);
    paramEditor.putString("qboss_splash_resource_md5_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.k);
    paramEditor.putInt("qboss_splash_should_show_ad_mark_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_e_of_type_Int);
    String str2 = paramavdt.g;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.startsWith("https")) {
        str1 = paramavdt.g.replaceFirst("http", "https");
      }
    }
    paramEditor.putString("qboss_exposure_url_" + paramavdt.jdField_b_of_type_JavaLangString, str1);
    paramBoolean = avdt.a(paramavdt.h, true);
    if ((!paramavdt.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramavdt.jdField_b_of_type_Boolean = paramBoolean;
      paramEditor.putBoolean("qboss_splash_ad_is_limited_" + paramavdt.jdField_b_of_type_JavaLangString, paramavdt.jdField_b_of_type_Boolean);
      return;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (1 == paramInt1)
    {
      l = bbct.d();
      if (paramInt3 != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT <= paramInt3) {}
      }
      else
      {
        if ((l == 0L) || (paramInt2 == 0) || (l > paramInt2 * 1024 * 1024)) {
          break label142;
        }
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("openDisabledLowerDevice ");
        localStringBuilder.append(" sdk_int:" + paramInt3);
        localStringBuilder.append(" mem:" + paramInt2);
        QLog.d("QSplash@QbossSplashCacheManager", 2, localStringBuilder.toString());
      }
    }
    label142:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        StringBuilder localStringBuilder;
        return bool1;
        bool1 = false;
      }
    }
    QLog.d("QSplash@QbossSplashCacheManager", 2, "isDisabledLowerDevice false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdo
 * JD-Core Version:    0.7.0.1
 */