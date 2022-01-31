package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import amgn;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbjn;
import bbkk;
import bgpu;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashMap;
import wim;
import wit;
import wkm;
import wpx;
import wpy;
import wpz;
import wqa;
import wrq;
import wry;
import wux;
import xfo;
import xhb;

public abstract class SubscribeBaseFragment
  extends IphoneTitleBarFragment
  implements wry
{
  public CertifiedAccountMeta.StFeed a;
  protected amgn a;
  private Handler a;
  public ExtraTypeInfo a;
  protected wrq a;
  public wux a;
  public boolean a;
  protected boolean b;
  
  private void a(int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!bbkk.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + wux.a(paramExtraTypeInfo), paramInt, 0, new String[0]);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Amgn != null) {
      return;
    }
    this.jdField_a_of_type_Amgn = new amgn(getActivity(), false, true);
    this.jdField_a_of_type_Amgn.a(getActivity());
    this.jdField_a_of_type_Amgn.a(new wpy(this));
    this.jdField_a_of_type_Amgn.a(new wpz(this));
    this.jdField_a_of_type_Amgn.a(new wqa(this));
  }
  
  private void c()
  {
    long l;
    String str;
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      l = getActivity().getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if ((l != 0L) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
        switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
        {
        default: 
          str = "SubscribeBaseFragment";
        }
      }
    }
    for (;;)
    {
      xhb.a(str, xhb.a(0L, System.currentTimeMillis() - l));
      return;
      str = "subscribe_open_video_detail_page_time";
      continue;
      str = "subscribe_open_muti_pic_page_time";
      continue;
      str = "subscribe_open_personal_detail_page_time";
    }
  }
  
  private void d()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void e()
  {
    File localFile = new File(wit.a());
    if ((localFile.exists()) || (bbjn.a() == null))
    {
      QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    wit.a(localFile, (String)xfo.a().a("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
  }
  
  private void f()
  {
    QLog.i("SubscribeBaseFragment", 1, "downloadAnimationPic");
    String[] arrayOfString = wim.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j)
      {
        str1 = arrayOfString[i];
        str2 = (String)wim.b.get(str1);
        localFile = new File(str2);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          QLog.i("DownLoadZipFile", 1, "DownLoadZipFile " + str2 + " Save file is exist");
        }
      }
      else
      {
        return;
      }
      String str2 = (String)wim.jdField_c_of_type_JavaUtilHashMap.get(str1);
      String str1 = (String)wim.jdField_a_of_type_JavaUtilHashMap.get(str1);
      wit.a(localFile, (String)xfo.a().a(str2, str1), wim.jdField_c_of_type_JavaLangString);
      i += 1;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  protected abstract View a();
  
  protected abstract TextView a();
  
  protected void a()
  {
    if (wit.a()) {
      d();
    }
    a(this.mContentView);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed) {}
  
  protected abstract void a(View paramView);
  
  public void a(wkm paramwkm)
  {
    if (paramwkm != null)
    {
      if ((paramwkm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
        paramwkm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      }
      if ((paramwkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
        paramwkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      }
      if (this.jdField_a_of_type_Wux != null)
      {
        a(paramwkm.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        this.jdField_a_of_type_Wux.a(paramwkm, this.jdField_a_of_type_Amgn);
      }
      if ((isNeedMiniMsg()) && (a() != null) && (paramwkm.jdField_a_of_type_Int == 1) && (a().getVisibility() == 0) && (getMiniMsgUser() != null)) {
        getMiniMsgUser().onClick(a());
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    return new int[2];
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    e();
    f();
    if (getActivity().getIntent() != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(getActivity().getIntent().getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
        this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_Wux = new wux(getActivity(), new wpx(this));
      if (getActivity().getIntent().hasExtra("bundle_key_parms_extra"))
      {
        paramLayoutInflater = getActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
        if (wrq.a(paramLayoutInflater))
        {
          this.jdField_a_of_type_Wrq = new wrq(paramLayoutInflater, this);
          if (this.jdField_a_of_type_Wrq.a() != null)
          {
            paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
            paramLayoutInflater.addRule(3, 2131375329);
            this.titleRoot.addView(this.jdField_a_of_type_Wrq.a(), paramLayoutInflater);
          }
        }
      }
      a();
      c();
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 25;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.unreadView = a();
    return localMiniMsgUserParam;
  }
  
  public boolean isNeedMiniMsg()
  {
    return (a() != null) && (a() != null);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscribeBaseFragment", 2, "SubscribeVideoDetailFragment onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    byte[] arrayOfByte;
    CertifiedAccountMeta.StFeed localStFeed;
    switch (paramInt1)
    {
    default: 
      if ((paramInt1 == 3) && (paramInt2 == -1))
      {
        arrayOfByte = paramIntent.getByteArrayExtra("feed");
        if (arrayOfByte != null) {
          localStFeed = new CertifiedAccountMeta.StFeed();
        }
      }
      break;
    }
    try
    {
      localStFeed.mergeFrom(arrayOfByte);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
      a(localStFeed);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      bgpu.a(super.getActivity(), paramIntent);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        QLog.e("SubscribeBaseFragment", 4, "onActivityResult: prase stFeed error:" + localInvalidProtocolBufferMicroException.toString());
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      xhb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + wux.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo), "clk_return", 0, 0, new String[] { "", "" });
    }
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType == 9001))
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      MiniAppLauncher.startMiniApp(getActivity(), str, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.c();
    }
    this.b = true;
    a().removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Wux != null) {
      this.jdField_a_of_type_Wux.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    if (this.jdField_a_of_type_Amgn != null) {
      this.jdField_a_of_type_Amgn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
 * JD-Core Version:    0.7.0.1
 */