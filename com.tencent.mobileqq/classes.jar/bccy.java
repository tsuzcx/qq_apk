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

public class bccy
{
  private static volatile bccy jdField_a_of_type_Bccy;
  private ITMAssistantExchangeURLListenner jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bccz(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bcfb.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    bcds.b("DownloadResolver", "[doDownloadActionBySDK] pParmas =" + paramBundle);
    String str1 = paramBundle.getString(bcgl.j);
    if (TextUtils.isEmpty(str1))
    {
      bcds.e("DownloadResolver", "[doDownloadActionBySDK] url is empty");
      return -1;
    }
    String str13 = paramBundle.getString(bcgl.f);
    int i = paramBundle.getInt(bcgl.k);
    String str14 = paramBundle.getString(bcgl.i);
    String str15 = paramBundle.getString(bcgl.l);
    String str12 = paramBundle.getString(bcgl.D);
    int j = paramBundle.getInt(bcgl.H);
    String str11 = paramBundle.getString(bcgl.I);
    boolean bool1 = paramBundle.getBoolean(bcgl.o);
    boolean bool2 = paramBundle.getBoolean(bcgl.y, true);
    boolean bool3 = paramBundle.getBoolean("is_qq_self_update_task", false);
    boolean bool4 = paramBundle.getBoolean(bcgl.jdField_h_of_type_JavaLangString, true);
    boolean bool5 = paramBundle.getBoolean(bcgl.x);
    int k = paramBundle.getInt(bcgl.C, 0);
    boolean bool6 = paramBundle.getBoolean(bcgl.J, false);
    String str16 = paramBundle.getString("appId");
    String str2 = paramBundle.getString("apkId", "");
    String str3 = paramBundle.getString("recommendId", "");
    String str4 = paramBundle.getString(bcgl.K, "");
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
      bcct.a(11, str1, i, localObject1);
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
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bcgl.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject1).jdField_d_of_type_Long = paramBundle.getLong(bcgl.G);
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
        bcds.b("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
        bccu.a().b((DownloadInfo)localObject1);
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
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bcgl.jdField_e_of_type_JavaLangString);
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
        bccu.a().b((DownloadInfo)localObject1);
        bcds.c("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE " + bool1);
        continue;
        return bccu.a().a(str1);
        localObject1 = localObject2;
        if (!bool2) {
          continue;
        }
        bcfb.a("305", str14, str16, str11);
        paramString = bccu.a().b(str1);
        localObject1 = paramString;
        if (paramString == null)
        {
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).jdField_c_of_type_JavaLangString = str16;
          ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString = str1.trim();
          ((DownloadInfo)localObject1).jdField_e_of_type_JavaLangString = str13;
          ((DownloadInfo)localObject1).f = str15;
          ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString = str14;
          ((DownloadInfo)localObject1).j = paramBundle.getString(bcgl.jdField_c_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(bcgl.jdField_e_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_c_of_type_Boolean = paramBundle.getBoolean(bcgl.y, true);
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
        bccu.a().c((DownloadInfo)localObject1);
        continue;
        bccu.a().a(str1, true);
        localObject1 = localObject2;
      }
      catch (NumberFormatException paramBundle)
      {
        break label506;
      }
    }
  }
  
  public static bccy a()
  {
    if (jdField_a_of_type_Bccy == null) {}
    try
    {
      if (jdField_a_of_type_Bccy == null) {
        jdField_a_of_type_Bccy = new bccy();
      }
      return jdField_a_of_type_Bccy;
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
    bcgh.a(paramActivity, paramBundle);
  }
  
  public static void a(Bundle paramBundle)
  {
    bcgh.a(paramBundle);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bcgl.k) == 5)
    {
      String str2 = paramBundle.getString(bcgl.j);
      if (TextUtils.isEmpty(str2))
      {
        bcds.e("DownloadResolver", "[installApp] url is empty");
        return false;
      }
      String str3 = paramBundle.getString(bcgl.f);
      String str4 = paramBundle.getString(bcgl.i);
      String str5 = paramBundle.getString(bcgl.l);
      Object localObject = paramBundle.getString(bcgl.I);
      String str6 = paramBundle.getString("appId");
      String str7 = paramBundle.getString("apkId", "");
      String str8 = paramBundle.getString("recommendId", "");
      String str9 = paramBundle.getString(bcgl.K, "");
      String str10 = paramBundle.getString("sourceFromServer", "");
      String str11 = paramBundle.getString("pageId", "");
      String str12 = paramBundle.getString("moduleId", "");
      String str13 = paramBundle.getString("positionId", "");
      String str14 = paramBundle.getString("big_brother_ref_source_key", "");
      String str1 = paramBundle.getString("big_brother_source_key");
      bcfb.a("305", str4, str6, (String)localObject);
      localObject = bccu.a().b(str2);
      if (localObject == null)
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString = str6;
        ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString = str2.trim();
        ((DownloadInfo)localObject).jdField_e_of_type_JavaLangString = str3;
        ((DownloadInfo)localObject).f = str5;
        ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = str4;
        ((DownloadInfo)localObject).j = paramBundle.getString(bcgl.jdField_c_of_type_JavaLangString);
        ((DownloadInfo)localObject).k = paramBundle.getString(bcgl.jdField_d_of_type_JavaLangString);
        ((DownloadInfo)localObject).jdField_b_of_type_Int = paramBundle.getInt(bcgl.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject).o = paramBundle.getString(bcgl.I);
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
        bccu.a().c(paramBundle);
        return true;
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
    bcds.b("DownloadResolver", "[doDownloadActionByMyApp] pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bcfb.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    Object localObject1;
    if (paramBundle.getInt(bcgl.jdField_e_of_type_JavaLangString, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(this.jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bbtm.a().a());
      localObject1 = paramBundle.getString(bcgl.f);
      Object localObject3 = paramBundle.getString(bcgl.B);
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
            bccu.a().b(bbtm.a().a().getString(2131629199));
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
      paramBundle.putInt(bcgl.jdField_e_of_type_JavaLangString, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bcgl.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bcgl.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        paramBundle.putInt("dialogType", 1);
        bchb.a().a(paramActivity, paramBundle, new bcda(this, paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bchb.a().b(paramActivity, paramBundle, new bcdb(this, paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    bcgh.b(paramBundle);
  }
  
  public List<DownloadInfo> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = bccu.a().a();
    Object localObject3 = new StringBuilder().append("DownloadManagerV2 tasks:");
    if (localObject2 == null) {}
    for (Object localObject1 = "0";; localObject1 = Integer.valueOf(((Map)localObject2).size()))
    {
      bcds.b("DownloadResolver", localObject1);
      if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
        break;
      }
      bcds.e("DownloadResolver", "infos is null!!");
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
          localObject4 = bccu.a().a(((DownloadInfo)localObject3).jdField_d_of_type_JavaLangString);
          bcds.b("DownloadResolver", "\ninfo=" + ((DownloadInfo)localObject3).toString() + "\ntaskInfo:" + a((TMAssistantDownloadTaskInfo)localObject4));
        }
        for (;;)
        {
          ((List)localObject1).add(Long.valueOf(System.currentTimeMillis() - l2));
          break;
          bcds.e("DownloadResolver", "Info is not SDK && APK task!! \ninfo=" + ((DownloadInfo)localObject3).toString());
        }
      }
    }
    else
    {
      bcds.e("DownloadResolver", "infos is empty!!");
    }
    localObject2 = new Long[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    bcds.e("DownloadResolver", "Total time Cost:" + (System.currentTimeMillis() - l1) + ";Every loop time cost:" + Arrays.toString((Object[])localObject2));
    return localArrayList;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bbtm.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bcfb.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.3(this, paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.6(this, paramString, paramBoolean), 32, null, true);
  }
  
  public void a(List<DownloadInfo> paramList, bcgv parambcgv)
  {
    if (paramList == null)
    {
      bcds.b("DownloadResolver", "[queryByDownloadManagerV2] infos == null");
      return;
    }
    if (parambcgv == null) {
      bcds.b("DownloadResolver", "[queryByDownloadManagerV2] listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.2(this, paramList, parambcgv));
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.7(this, paramString, paramBoolean), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bccy
 * JD-Core Version:    0.7.0.1
 */