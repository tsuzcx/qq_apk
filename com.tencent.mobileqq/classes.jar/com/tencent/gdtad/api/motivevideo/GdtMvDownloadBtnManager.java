package com.tencent.gdtad.api.motivevideo;

import aalh;
import aali;
import aanp;
import aanr;
import aaon;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bfgi;
import bfgm;
import bfjy;
import bfka;
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
  private aali jdField_a_of_type_Aali;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfka jdField_a_of_type_Bfka = new aalh(this);
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtMvAppBtnData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GdtMvDownloadBtnManager.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMvDownloadBtnManager(Context paramContext, GdtAd paramGdtAd, String paramString, GdtMvAppBtnView paramGdtMvAppBtnView1, GdtMvAppBtnView paramGdtMvAppBtnView2)
  {
    aanp.a("GdtMvDownloadBtnManager", "GdtMvDownloadBtnManager: ");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_Aali = new aali(paramString, paramGdtMvAppBtnView1, paramGdtMvAppBtnView2, this);
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
      aanp.d("GdtMvDownloadBtnPresenter", "startRealDownload param null");
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString(bfjy.f, str1);
    ((Bundle)localObject).putString(bfjy.b, str2);
    ((Bundle)localObject).putString(bfjy.j, str3);
    ((Bundle)localObject).putString(bfjy.l, str4);
    ((Bundle)localObject).putInt(bfjy.k, 2);
    ((Bundle)localObject).putInt(bfjy.E, 0);
    ((Bundle)localObject).putBoolean(bfjy.x, false);
    ((Bundle)localObject).putInt(bfjy.H, 0);
    ((Bundle)localObject).putBoolean(bfjy.y, true);
    ((Bundle)localObject).putBoolean(bfjy.h, true);
    ((Bundle)localObject).putBoolean(bfjy.r, false);
    ((Bundle)localObject).putBoolean(bfjy.J, false);
    ((Bundle)localObject).putString(bfjy.i, str5);
    ((Bundle)localObject).putString("big_brother_ref_source_key", paramGdtMvAppBtnData);
    aanp.a("GdtMvDownloadBtnManager", "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    bfgm.a().a(paramActivity, (Bundle)localObject, "biz_src_ads", null, 0);
  }
  
  private void a(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    aanp.a("GdtMvDownloadBtnManager", "setCGdtMvAppBtnData() called with: gdtMvAppBtnData = [" + paramGdtMvAppBtnData + "]");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData = paramGdtMvAppBtnData;
      this.jdField_a_of_type_Aali.d(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return (TextUtils.equals(paramString1, paramString3)) && (TextUtils.equals(paramString2, paramString4));
  }
  
  private static void b(String paramString)
  {
    aanp.a("GdtMvDownloadBtnManager", "triggerRegisterDownloadCallback: ");
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
    paramGdtMvDownloadBtnManager = bfgi.a().b(paramGdtMvAppBtnData.apkUrlhttp);
    if (paramGdtMvDownloadBtnManager != null)
    {
      paramGdtMvAppBtnData.cState = a(paramGdtMvDownloadBtnManager.a());
      paramGdtMvAppBtnData.cProgerss = paramGdtMvDownloadBtnManager.f;
      return;
    }
    aanp.a("GdtMvDownloadBtnManager", "updateMvAppBtnData: getDownloadInfoByUrl return null");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null)
    {
      this.jdField_a_of_type_Aali.a(null, 0);
      return;
    }
    this.jdField_a_of_type_Aali.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.cState);
  }
  
  public void a(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    aanp.c("GdtMvDownloadBtnManager", "startDownload " + paramGdtMvAppBtnData.packageName + " progress " + paramInt);
    paramGdtMvAppBtnData.cState = 3;
    this.jdField_a_of_type_Aali.b(paramGdtMvAppBtnData, paramInt);
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Aali.jdField_a_of_type_Boolean = true;
    a(localActivity, paramGdtMvAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDownloadPause " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aali.a(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDownloadError " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aali.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(String paramString1, String paramString2)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "installSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aali.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    aanp.a("GdtMvDownloadBtnManager", "onDownloadUpdate: ");
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo.e, localDownloadInfo.c, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.mGdtAd_appId)) {
          this.jdField_a_of_type_Aali.e(localDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
        }
      }
    }
  }
  
  public void b()
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDestroy");
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
    bfgi.a().b(this.jdField_a_of_type_Bfka);
    this.jdField_a_of_type_Aali = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDownloadWait " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aali.b(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void b(String paramString1, String paramString2)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "uninstallSucceed " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aali.b(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void c()
  {
    aanp.a("GdtMvDownloadBtnManager", "onActivityResume: ");
    GdtMvAppBtnData localGdtMvAppBtnData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData;
    if (localGdtMvAppBtnData != null)
    {
      if (noy.a(this.jdField_a_of_type_AndroidContentContext, localGdtMvAppBtnData.packageName))
      {
        aanp.c("GdtMvDownloadBtnPresenter", "onActivityResume already installed." + localGdtMvAppBtnData.packageName);
        this.jdField_a_of_type_Aali.b(localGdtMvAppBtnData);
      }
      do
      {
        return;
        if (aaon.b(this.jdField_a_of_type_AndroidContentContext, localGdtMvAppBtnData.apkUrlhttp))
        {
          aanp.c("GdtMvDownloadBtnPresenter", "onActivityResume already finishDownload." + localGdtMvAppBtnData.packageName);
          this.jdField_a_of_type_Aali.a(localGdtMvAppBtnData);
          return;
        }
      } while ((localGdtMvAppBtnData.cState != 1) && (localGdtMvAppBtnData.cState != 0) && (localGdtMvAppBtnData.cState != 5));
      aanp.c("GdtMvDownloadBtnManager", "onActivityResume already installed or finishDownload but not exist." + localGdtMvAppBtnData.packageName);
      this.jdField_a_of_type_Aali.c(localGdtMvAppBtnData);
      return;
    }
    aanp.a("GdtMvDownloadBtnManager", "onActivityResume: app btn data is null");
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDownloadFinish " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aali.d(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void c(String paramString1, String paramString2)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "packageReplaced " + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    this.jdField_a_of_type_Aali.c(paramString1, paramString2, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  public void d()
  {
    aanp.a("GdtMvDownloadBtnManager", "going fetch AppData");
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) && (aanr.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    aanp.b("GdtMvDownloadBtnPresenter", "onDownloadCancel " + paramDownloadInfo.e);
    this.jdField_a_of_type_Aali.c(paramDownloadInfo, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Aali == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData == null) || (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.isValid())) {
      return;
    }
    if (noy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.packageName))
    {
      this.jdField_a_of_type_Aali.b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      return;
    }
    if (aaon.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp))
    {
      this.jdField_a_of_type_Aali.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
      DownloadInfo localDownloadInfo = bfgi.a().b(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData.apkUrlhttp);
      if (localDownloadInfo != null) {
        localDownloadInfo.m = "biz_src_ads";
      }
      bfgi.a().a(localDownloadInfo);
      return;
    }
    int j = aaon.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnData, i);
  }
  
  public void f()
  {
    aanp.a("GdtMvDownloadBtnManager", "onCreate() called");
    bfgi.a().a(this.jdField_a_of_type_Bfka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager
 * JD-Core Version:    0.7.0.1
 */