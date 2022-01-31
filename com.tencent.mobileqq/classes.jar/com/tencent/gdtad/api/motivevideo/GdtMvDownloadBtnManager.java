package com.tencent.gdtad.api.motivevideo;

import aapw;
import aapx;
import aase;
import aasg;
import aatc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bfkr;
import bfkv;
import bfoh;
import bfoj;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import noy;

public class GdtMvDownloadBtnManager
{
  private int jdField_a_of_type_Int;
  private aapx jdField_a_of_type_Aapx;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfoj jdField_a_of_type_Bfoj = new aapw(this);
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtMvAppBtnData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtMvDownloadBtnManager.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMvDownloadBtnManager(Context paramContext, GdtAd paramGdtAd, String paramString, GdtMvAppBtnView paramGdtMvAppBtnView1, GdtMvAppBtnView paramGdtMvAppBtnView2)
  {
    aase.a("GdtMvDownloadBtnManager", "GdtMvDownloadBtnManager: ");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_Aapx = new aapx(paramString, paramGdtMvAppBtnView1, paramGdtMvAppBtnView2, this);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 10: 
    case 30: 
    default: 
      return 0;
    case 4: 
      return 5;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 2;
  }
  
  private static void a(Activity paramActivity, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((paramActivity == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    String str1 = paramGdtMvAppBtnData.packageName;
    String str2 = paramGdtMvAppBtnData.mGdtAd_appId;
    String str3 = paramGdtMvAppBtnData.apkUrlhttp;
    String str4 = paramGdtMvAppBtnData.name;
    String str5 = paramGdtMvAppBtnData.via;
    Object localObject = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramGdtMvAppBtnData = (GdtMvAppBtnData)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramGdtMvAppBtnData = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      aase.d("GdtMvDownloadBtnPresenter", "startRealDownload param null");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString(bfoh.f, str1);
    ((Bundle)localObject).putString(bfoh.b, str2);
    ((Bundle)localObject).putString(bfoh.j, str3);
    ((Bundle)localObject).putString(bfoh.l, str4);
    ((Bundle)localObject).putInt(bfoh.k, 2);
    ((Bundle)localObject).putInt(bfoh.E, 0);
    ((Bundle)localObject).putBoolean(bfoh.x, false);
    ((Bundle)localObject).putInt(bfoh.H, 0);
    ((Bundle)localObject).putBoolean(bfoh.y, true);
    ((Bundle)localObject).putBoolean(bfoh.h, true);
    ((Bundle)localObject).putBoolean(bfoh.r, false);
    ((Bundle)localObject).putBoolean(bfoh.J, false);
    ((Bundle)localObject).putString(bfoh.i, str5);
    ((Bundle)localObject).putString("big_brother_ref_source_key", paramGdtMvAppBtnData);
    aase.a("GdtMvDownloadBtnManager", "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    bfkv.a().a(paramActivity, (Bundle)localObject, "biz_src_ads", null, 0);
  }
  
  private void a(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    aase.a("GdtMvDownloadBtnManager", "setCGdtMvAppBtnData() called with: gdtMvAppBtnData = [" + paramGdtMvAppBtnData + "]");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData = paramGdtMvAppBtnData;
      this.jdField_a_of_type_Aapx.d(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return (TextUtils.equals(paramString1, paramString3)) && (TextUtils.equals(paramString2, paramString4));
  }
  
  private static void b(String paramString)
  {
    aase.a("GdtMvDownloadBtnManager", "triggerRegisterDownloadCallback: ");
    ThreadManagerV2.executeOnSubThread(new GdtMvDownloadBtnManager.2(paramString));
  }
  
  private static void c(GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    paramGdtMvAppBtnData.mGdtAd_appId = paramGdtMvDownloadBtnManager.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getAppId();
    paramGdtMvAppBtnData.packageName = paramGdtMvDownloadBtnManager.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getAppPackageName();
    paramGdtMvAppBtnData.name = paramGdtMvDownloadBtnManager.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getAdvertiser_corporate_image_name();
    paramGdtMvAppBtnData.via = paramGdtMvDownloadBtnManager.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getVia();
    if (noy.a(paramGdtMvDownloadBtnManager.jdField_a_of_type_AndroidContentContext, paramGdtMvAppBtnData.packageName))
    {
      paramGdtMvAppBtnData.cState = 1;
      paramGdtMvAppBtnData.cProgerss = 100;
      return;
    }
    paramGdtMvDownloadBtnManager = bfkr.a().b(paramGdtMvAppBtnData.apkUrlhttp);
    if (paramGdtMvDownloadBtnManager != null)
    {
      paramGdtMvAppBtnData.cState = a(paramGdtMvDownloadBtnManager.a());
      paramGdtMvAppBtnData.cProgerss = paramGdtMvDownloadBtnManager.f;
      return;
    }
    aase.a("GdtMvDownloadBtnManager", "updateMvAppBtnData: getDownloadInfoByUrl return null");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_Aapx.a(null, 0);
      return;
    }
    this.jdField_a_of_type_Aapx.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.cState);
  }
  
  public void a(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    aase.c("GdtMvDownloadBtnManager", "startDownload " + paramGdtMvAppBtnData.packageName + " progress " + paramInt);
    paramGdtMvAppBtnData.cState = 3;
    this.jdField_a_of_type_Aapx.b(paramGdtMvAppBtnData, paramInt);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Aapx.jdField_a_of_type_Boolean = true;
    a(localActivity, paramGdtMvAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDownloadPause " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aapx.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDownloadError " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aapx.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(String paramString1, String paramString2)
  {
    aase.b("GdtMvDownloadBtnPresenter", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aapx.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    aase.a("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo.e, localDownloadInfo.c, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.mGdtAd_appId)) {
          this.jdField_a_of_type_Aapx.e(localDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
        }
      }
    }
  }
  
  public void b()
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDestroy");
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
    bfkr.a().b(this.jdField_a_of_type_Bfoj);
    this.jdField_a_of_type_Aapx = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDownloadWait " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aapx.b(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void b(String paramString1, String paramString2)
  {
    aase.b("GdtMvDownloadBtnPresenter", "uninstallSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aapx.b(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void c()
  {
    aase.a("GdtMvDownloadBtnManager", "onActivityResume: ");
    GdtMvAppBtnData localGdtMvAppBtnData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
    if (localGdtMvAppBtnData != null)
    {
      if (noy.a(this.jdField_a_of_type_AndroidContentContext, localGdtMvAppBtnData.packageName))
      {
        aase.c("GdtMvDownloadBtnPresenter", "onActivityResume already installed." + localGdtMvAppBtnData.packageName);
        this.jdField_a_of_type_Aapx.b(localGdtMvAppBtnData);
      }
      do
      {
        return;
        if (aatc.b(this.jdField_a_of_type_AndroidContentContext, localGdtMvAppBtnData.apkUrlhttp))
        {
          aase.c("GdtMvDownloadBtnPresenter", "onActivityResume already finishDownload." + localGdtMvAppBtnData.packageName);
          this.jdField_a_of_type_Aapx.a(localGdtMvAppBtnData);
          return;
        }
      } while ((localGdtMvAppBtnData.cState != 1) && (localGdtMvAppBtnData.cState != 0) && (localGdtMvAppBtnData.cState != 5));
      aase.c("GdtMvDownloadBtnManager", "onActivityResume already installed or finishDownload but not exist." + localGdtMvAppBtnData.packageName);
      this.jdField_a_of_type_Aapx.c(localGdtMvAppBtnData);
      return;
    }
    aase.a("GdtMvDownloadBtnManager", "onActivityResume: app btn data is null");
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aapx.d(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void c(String paramString1, String paramString2)
  {
    aase.b("GdtMvDownloadBtnPresenter", "packageReplaced " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aapx.c(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void d()
  {
    aase.a("GdtMvDownloadBtnManager", "going fetch AppData");
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) && (aasg.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    aase.b("GdtMvDownloadBtnPresenter", "onDownloadCancel " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aapx.c(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Aapx == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) || (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.isValid())) {
      return;
    }
    if (noy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName))
    {
      this.jdField_a_of_type_Aapx.b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      return;
    }
    if (aatc.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp))
    {
      this.jdField_a_of_type_Aapx.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      DownloadInfo localDownloadInfo = bfkr.a().b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bfkr.a().a(localDownloadInfo);
      return;
    }
    int j = aatc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, i);
  }
  
  public void f()
  {
    aase.a("GdtMvDownloadBtnManager", "onCreate() called");
    bfkr.a().a(this.jdField_a_of_type_Bfoj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager
 * JD-Core Version:    0.7.0.1
 */