package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import alrv;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baht;
import baip;
import bfhl;
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
import vvz;
import vxn;
import wcn;
import wco;
import wcp;
import wcq;
import wfz;
import wwt;
import wye;

public abstract class SubscribeBaseFragment
  extends IphoneTitleBarFragment
{
  public CertifiedAccountMeta.StFeed a;
  protected alrv a;
  private Handler a;
  public ExtraTypeInfo a;
  public wfz a;
  public boolean a;
  protected boolean b;
  
  private void a(int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!baip.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      wye.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + wfz.a(paramExtraTypeInfo), paramInt, 0, new String[0]);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Alrv != null) {
      return;
    }
    this.jdField_a_of_type_Alrv = new alrv(getActivity(), false, true);
    this.jdField_a_of_type_Alrv.a(getActivity());
    this.jdField_a_of_type_Alrv.a(new wco(this));
    this.jdField_a_of_type_Alrv.a(new wcp(this));
    this.jdField_a_of_type_Alrv.a(new wcq(this));
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
      wye.a(str, wye.a(0L, System.currentTimeMillis() - l));
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
    File localFile = new File(vvz.a());
    if ((localFile.exists()) || (baht.a() == null))
    {
      QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    vvz.a(localFile, (String)wwt.a().a("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "http://down.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
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
  
  protected String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {}
    switch (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    case 7001: 
    default: 
      return "certified_account_preload_pic";
    case 7000: 
      return "certified_account_preload_video";
    }
    return "certified_account_personal_preload_loading";
  }
  
  protected void a()
  {
    if (vvz.a()) {
      d();
    }
    a(this.mContentView);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed) {}
  
  protected abstract void a(View paramView);
  
  public void a(vxn paramvxn)
  {
    if (paramvxn != null)
    {
      if ((paramvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
        paramvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      }
      if ((paramvxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
        paramvxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      }
      if (this.jdField_a_of_type_Wfz != null)
      {
        a(paramvxn.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        this.jdField_a_of_type_Wfz.a(paramvxn, this.jdField_a_of_type_Alrv);
      }
      if ((isNeedMiniMsg()) && (a() != null) && (paramvxn.jdField_a_of_type_Int == 1) && (a().getVisibility() == 0) && (getMiniMsgUser() != null)) {
        getMiniMsgUser().onClick(a());
      }
    }
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
      this.jdField_a_of_type_Wfz = new wfz(getActivity(), new wcn(this));
      a();
      c();
      b();
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
      bfhl.a(super.getActivity(), paramIntent);
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
      wye.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + wfz.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo), "clk_return", 0, 0, new String[] { "", "" });
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
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.c();
    }
    this.b = true;
    a().removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Wfz != null) {
      this.jdField_a_of_type_Wfz.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Alrv != null) {
      this.jdField_a_of_type_Alrv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
 * JD-Core Version:    0.7.0.1
 */