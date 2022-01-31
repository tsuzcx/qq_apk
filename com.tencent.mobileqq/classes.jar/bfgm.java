import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadProxy.2;
import com.tencent.open.appstore.dl.DownloadProxy.3;
import com.tencent.open.appstore.dl.DownloadProxy.6;
import com.tencent.open.appstore.dl.DownloadProxy.7;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bfgm
{
  private static volatile bfgm jdField_a_of_type_Bfgm;
  private ITMAssistantExchangeURLListenner jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bfgn(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bfip.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bfjy.I));
    }
    bfhg.b("DownloadResolver", "[doDownloadActionBySDK] pParmas =" + paramBundle);
    String str1 = paramBundle.getString(bfjy.j);
    if (TextUtils.isEmpty(str1))
    {
      bfhg.e("DownloadResolver", "[doDownloadActionBySDK] url is empty");
      return -1;
    }
    String str13 = paramBundle.getString(bfjy.f);
    int i = paramBundle.getInt(bfjy.k);
    String str14 = paramBundle.getString(bfjy.i);
    String str15 = paramBundle.getString(bfjy.l);
    String str12 = paramBundle.getString(bfjy.D);
    int j = paramBundle.getInt(bfjy.H);
    String str11 = paramBundle.getString(bfjy.I);
    boolean bool1 = paramBundle.getBoolean(bfjy.o);
    boolean bool2 = paramBundle.getBoolean(bfjy.y, true);
    boolean bool3 = paramBundle.getBoolean("is_qq_self_update_task", false);
    boolean bool4 = paramBundle.getBoolean(bfjy.jdField_h_of_type_JavaLangString, true);
    boolean bool5 = paramBundle.getBoolean(bfjy.x);
    int k = paramBundle.getInt(bfjy.C, 0);
    boolean bool6 = paramBundle.getBoolean(bfjy.J, false);
    String str16 = paramBundle.getString("appId");
    String str2 = paramBundle.getString("apkId", "");
    String str3 = paramBundle.getString("recommendId", "");
    String str4 = paramBundle.getString(bfjy.K, "");
    String str5 = paramBundle.getString("sourceFromServer", "");
    String str6 = paramBundle.getString("pageId", "");
    String str7 = paramBundle.getString("moduleId", "");
    String str8 = paramBundle.getString("positionId", "");
    String str9 = paramBundle.getString("sendTime", "");
    String str10 = paramBundle.getString("big_brother_ref_source_key", "");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      bfgh.a(11, str1, i, localObject1);
      return 0;
      localObject1 = new DownloadInfo(str16, str1.trim(), str13, str15, str14, null, paramString, bool2);
      ((DownloadInfo)localObject1).jdField_g_of_type_Int = i;
      if (bool2)
      {
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = bool4;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = bool5;
        label441:
        ((DownloadInfo)localObject1).jdField_h_of_type_Int = k;
        ((DownloadInfo)localObject1).n = str12;
        ((DownloadInfo)localObject1).i = j;
        ((DownloadInfo)localObject1).o = str11;
        ((DownloadInfo)localObject1).jdField_d_of_type_Boolean = bool6;
        ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
      }
      try
      {
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bfjy.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject1).jdField_d_of_type_Long = paramBundle.getLong(bfjy.G);
        label506:
        ((DownloadInfo)localObject1).k = str2;
        ((DownloadInfo)localObject1).q = str3;
        ((DownloadInfo)localObject1).r = str5;
        ((DownloadInfo)localObject1).s = str4;
        ((DownloadInfo)localObject1).t = str6;
        ((DownloadInfo)localObject1).u = str7;
        ((DownloadInfo)localObject1).v = str8;
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
        }
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).a();
        bfhg.b("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
        bfgi.a().b((DownloadInfo)localObject1);
        continue;
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = true;
        ((DownloadInfo)localObject1).jdField_a_of_type_Int = 2;
        break label441;
        localObject1 = new DownloadInfo(str16, str1.trim(), str13, str15, str14, null, paramString, bool2);
        ((DownloadInfo)localObject1).jdField_g_of_type_Int = i;
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = bool4;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = bool5;
        ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bfjy.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject1).o = str11;
        if ((paramApkUpdateDetail != null) && (((DownloadInfo)localObject1).jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
        }
        ((DownloadInfo)localObject1).k = str2;
        ((DownloadInfo)localObject1).q = str3;
        ((DownloadInfo)localObject1).r = str5;
        ((DownloadInfo)localObject1).s = str4;
        ((DownloadInfo)localObject1).t = str6;
        ((DownloadInfo)localObject1).u = str7;
        ((DownloadInfo)localObject1).v = str8;
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).a();
        bfgi.a().b((DownloadInfo)localObject1);
        bfhg.c("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE " + bool1);
        continue;
        return bfgi.a().a(str1);
        localObject1 = localObject2;
        if (!bool2) {
          continue;
        }
        bfip.a("305", str14, str16, str11);
        paramString = bfgi.a().b(str1);
        localObject1 = paramString;
        if (paramString == null)
        {
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).jdField_c_of_type_JavaLangString = str16;
          ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString = str1.trim();
          ((DownloadInfo)localObject1).jdField_e_of_type_JavaLangString = str13;
          ((DownloadInfo)localObject1).f = str15;
          ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString = str14;
          ((DownloadInfo)localObject1).j = paramBundle.getString(bfjy.jdField_c_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bfjy.jdField_e_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_c_of_type_Boolean = paramBundle.getBoolean(bfjy.y, true);
          ((DownloadInfo)localObject1).jdField_h_of_type_Int = k;
          ((DownloadInfo)localObject1).n = str12;
          ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
          ((DownloadInfo)localObject1).o = str11;
          if (!TextUtils.isEmpty(str9)) {
            ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
          }
          ((DownloadInfo)localObject1).k = str2;
          ((DownloadInfo)localObject1).q = str3;
          ((DownloadInfo)localObject1).r = str5;
          ((DownloadInfo)localObject1).s = str4;
          ((DownloadInfo)localObject1).t = str6;
          ((DownloadInfo)localObject1).u = str7;
          ((DownloadInfo)localObject1).v = str8;
          ((DownloadInfo)localObject1).a();
        }
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        bfgi.a().a((DownloadInfo)localObject1);
        continue;
        bfgi.a().a(str1, true);
        localObject1 = localObject2;
      }
      catch (NumberFormatException paramBundle)
      {
        break label506;
      }
    }
  }
  
  public static bfgm a()
  {
    if (jdField_a_of_type_Bfgm == null) {}
    try
    {
      if (jdField_a_of_type_Bfgm == null) {
        jdField_a_of_type_Bfgm = new bfgm();
      }
      return jdField_a_of_type_Bfgm;
    }
    finally {}
  }
  
  private String a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mSavePath=" + paramTMAssistantDownloadTaskInfo.mSavePath);
    localStringBuilder.append("\n");
    localStringBuilder.append("mState=" + paramTMAssistantDownloadTaskInfo.mState);
    localStringBuilder.append("\n");
    localStringBuilder.append("mReceiveDataLen=" + paramTMAssistantDownloadTaskInfo.mReceiveDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTotalDataLen=" + paramTMAssistantDownloadTaskInfo.mTotalDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mContentType=" + paramTMAssistantDownloadTaskInfo.mContentType);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskPackageName=" + paramTMAssistantDownloadTaskInfo.mTaskPackageName);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskVersionCode=" + paramTMAssistantDownloadTaskInfo.mTaskVersionCode);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    bfju.a(paramActivity, paramBundle);
  }
  
  public static void a(Bundle paramBundle)
  {
    bfju.a(paramBundle);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bfjy.k) == 5)
    {
      String str2 = paramBundle.getString(bfjy.j);
      if (TextUtils.isEmpty(str2))
      {
        bfhg.e("DownloadResolver", "[installApp] url is empty");
        return false;
      }
      String str3 = paramBundle.getString(bfjy.f);
      String str4 = paramBundle.getString(bfjy.i);
      String str5 = paramBundle.getString(bfjy.l);
      Object localObject = paramBundle.getString(bfjy.I);
      String str6 = paramBundle.getString("appId");
      String str7 = paramBundle.getString("apkId", "");
      String str8 = paramBundle.getString("recommendId", "");
      String str9 = paramBundle.getString(bfjy.K, "");
      String str10 = paramBundle.getString("sourceFromServer", "");
      String str11 = paramBundle.getString("pageId", "");
      String str12 = paramBundle.getString("moduleId", "");
      String str13 = paramBundle.getString("positionId", "");
      String str14 = paramBundle.getString("big_brother_ref_source_key", "");
      String str1 = paramBundle.getString("big_brother_source_key");
      bfip.a("305", str4, str6, (String)localObject);
      localObject = bfgi.a().b(str2);
      if (localObject == null)
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString = str6;
        ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString = str2.trim();
        ((DownloadInfo)localObject).jdField_e_of_type_JavaLangString = str3;
        ((DownloadInfo)localObject).f = str5;
        ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = str4;
        ((DownloadInfo)localObject).j = paramBundle.getString(bfjy.jdField_c_of_type_JavaLangString);
        ((DownloadInfo)localObject).k = paramBundle.getString(bfjy.jdField_d_of_type_JavaLangString);
        ((DownloadInfo)localObject).jdField_b_of_type_Int = paramBundle.getInt(bfjy.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject).o = paramBundle.getString(bfjy.I);
        ((DownloadInfo)localObject).k = str7;
        ((DownloadInfo)localObject).q = str8;
        ((DownloadInfo)localObject).r = str10;
        ((DownloadInfo)localObject).s = str9;
        ((DownloadInfo)localObject).t = str11;
        ((DownloadInfo)localObject).u = str12;
        ((DownloadInfo)localObject).v = str13;
        ((DownloadInfo)localObject).m = str1;
        ((DownloadInfo)localObject).a("big_brother_ref_source_key", str14);
        ((DownloadInfo)localObject).a();
        paramBundle = (Bundle)localObject;
      }
      for (;;)
      {
        return bfgi.a().a(paramBundle);
        if (!TextUtils.isEmpty(str4)) {
          ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = str4;
        }
        if (!TextUtils.isEmpty(str14)) {
          ((DownloadInfo)localObject).a("big_brother_ref_source_key", str14);
        }
        paramBundle = (Bundle)localObject;
        if (!TextUtils.isEmpty(str1))
        {
          ((DownloadInfo)localObject).m = str1;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    return false;
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    bfhg.b("DownloadResolver", "[doDownloadActionByMyApp] pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bfip.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bfjy.I));
    }
    Object localObject1;
    if (paramBundle.getInt(bfjy.jdField_e_of_type_JavaLangString, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(this.jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bexd.a().a());
      localObject1 = paramBundle.getString(bfjy.f);
      Object localObject3 = paramBundle.getString(bfjy.B);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label292:
    do
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(5000L);
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label292;
          }
          localObject1 = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            bfgi.a().b(bexd.a().a().getString(2131695034));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(bfjy.jdField_e_of_type_JavaLangString, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bfjy.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bfjy.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        paramBundle.putInt("dialogType", 1);
        bfko.a().a(paramActivity, paramBundle, new bfgo(this, paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bfko.a().b(paramActivity, paramBundle, new bfgp(this, paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    bfju.b(paramBundle);
  }
  
  public List<DownloadInfo> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = bfgi.a().a();
    Object localObject3 = new StringBuilder().append("DownloadManagerV2 tasks:");
    if (localObject2 == null) {}
    for (Object localObject1 = "0";; localObject1 = Integer.valueOf(((Map)localObject2).size()))
    {
      bfhg.b("DownloadResolver", localObject1);
      if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
        break;
      }
      bfhg.e("DownloadResolver", "infos is null!!");
      return localArrayList;
    }
    localObject2 = new HashMap((Map)localObject2);
    localObject1 = new ArrayList();
    if (((Map)localObject2).size() > 0)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        long l2 = System.currentTimeMillis();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (DownloadInfo)((Map.Entry)localObject3).getValue();
        if ((((DownloadInfo)localObject3).jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(((DownloadInfo)localObject3).jdField_e_of_type_JavaLangString)) && (((DownloadInfo)localObject3).jdField_c_of_type_Boolean))
        {
          localArrayList.add(localObject3);
          localObject4 = bfgi.a().a(((DownloadInfo)localObject3).jdField_d_of_type_JavaLangString);
          bfhg.b("DownloadResolver", "\ninfo=" + ((DownloadInfo)localObject3).toString() + "\ntaskInfo:" + a((TMAssistantDownloadTaskInfo)localObject4));
        }
        for (;;)
        {
          ((List)localObject1).add(Long.valueOf(System.currentTimeMillis() - l2));
          break;
          bfhg.e("DownloadResolver", "Info is not SDK && APK task!! \ninfo=" + ((DownloadInfo)localObject3).toString());
        }
      }
    }
    else
    {
      bfhg.e("DownloadResolver", "infos is empty!!");
    }
    localObject2 = new Long[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    bfhg.e("DownloadResolver", "Total time Cost:" + (System.currentTimeMillis() - l1) + ";Every loop time cost:" + Arrays.toString((Object[])localObject2));
    return localArrayList;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bexd.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bfip.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bfjy.I));
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.3(this, paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.6(this, paramString, paramBoolean), 32, null, true);
  }
  
  public void a(List<DownloadInfo> paramList, bfki parambfki)
  {
    if (paramList == null)
    {
      bfhg.b("DownloadResolver", "[queryByDownloadManagerV2] infos == null");
      return;
    }
    if (parambfki == null) {
      bfhg.b("DownloadResolver", "[queryByDownloadManagerV2] listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.2(this, paramList, parambfki));
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.7(this, paramString, paramBoolean), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgm
 * JD-Core Version:    0.7.0.1
 */