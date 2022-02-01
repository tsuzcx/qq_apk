package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.transition.inter.ITransAnimInitImpl;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.util.HashMap;

public abstract class SubscribeBaseFragment
  extends IphoneTitleBarFragment
  implements ITransAnimInitImpl
{
  private static long jdField_a_of_type_Long;
  protected CertifiedAccountMeta.StFeed a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected ExtraTypeInfo a;
  protected TransitionAnimHelper a;
  protected SubscribeShareHelper a;
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  protected IColorNoteController a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  
  private void a(int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if ((localObject != null) && (!StringUtil.a(((CertifiedAccountMeta.StFeed)localObject).poster.id.get())))
    {
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exp_");
      localStringBuilder.append(SubscribeShareHelper.a(paramExtraTypeInfo));
      VSReporter.a((String)localObject, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[0]);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(getBaseActivity(), false, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(new SubscribeBaseFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new SubscribeBaseFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new SubscribeBaseFragment.4(this));
  }
  
  private void c()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      long l = getBaseActivity().getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        if (localObject != null)
        {
          switch (((ExtraTypeInfo)localObject).pageType)
          {
          default: 
            localObject = "SubscribeBaseFragment";
            break;
          case 7002: 
            localObject = "subscribe_open_personal_detail_page_time";
            break;
          case 7001: 
            localObject = "subscribe_open_muti_pic_page_time";
            break;
          case 7000: 
            localObject = "subscribe_open_video_detail_page_time";
          }
          VSReporter.a((String)localObject, VSReporter.a(0L, System.currentTimeMillis() - l));
        }
      }
    }
  }
  
  private void d()
  {
    View localView = new View(getBaseActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getBaseActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void e()
  {
    File localFile = new File(SubscribeUtils.a());
    if ((!localFile.exists()) && (SdCardUtil.getSdCardDirectory() != null))
    {
      SubscribeUtils.a(localFile, (String)VSConfigManager.a().a("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
      return;
    }
    QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
  }
  
  private void f()
  {
    QLog.i("SubscribeBaseFragment", 1, "downloadAnimationPic");
    Object localObject1 = SubscribeConstants.jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      String str = (String)SubscribeConstants.b.get(localObject2);
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DownLoadZipFile ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" Save file is exist");
        QLog.i("DownLoadZipFile", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      str = (String)SubscribeConstants.jdField_c_of_type_JavaUtilHashMap.get(localObject2);
      localObject2 = (String)SubscribeConstants.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      SubscribeUtils.a(localFile, (String)VSConfigManager.a().a(str, localObject2), SubscribeConstants.jdField_c_of_type_JavaLangString);
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
  
  protected View a()
  {
    return null;
  }
  
  protected TextView a()
  {
    return null;
  }
  
  public MiniMsgUser a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 25;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.unreadView = a();
    return localMiniMsgUserParam;
  }
  
  protected void a()
  {
    if (SubscribeUtils.a()) {
      d();
    }
    a(this.mContentView);
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed) {}
  
  protected abstract void a(View paramView);
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    if (paramShareInfoBean != null)
    {
      Object localObject;
      if (paramShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)
      {
        localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        if (localObject != null) {
          paramShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)localObject);
        }
      }
      if (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        if (localObject != null) {
          paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper != null)
      {
        a(paramShareInfoBean.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.a(paramShareInfoBean, this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController);
      }
      if ((a()) && (a() != null) && (paramShareInfoBean.jdField_a_of_type_Int == 1) && (a().getVisibility() == 0) && (a() != null)) {
        a().onClick(a());
      }
    }
  }
  
  protected boolean a()
  {
    return (a() != null) && (a() != null);
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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    e();
    f();
    if (getBaseActivity().getIntent() != null)
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
      try
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(getBaseActivity().getIntent().getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
        this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
        if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
          this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
        }
      }
      catch (Exception paramLayoutInflater)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper = new SubscribeShareHelper(getBaseActivity(), new SubscribeBaseFragment.1(this));
    if (getBaseActivity().getIntent().hasExtra("bundle_key_parms_extra"))
    {
      paramLayoutInflater = getBaseActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
      if (TransitionAnimHelper.a(paramLayoutInflater))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper = new TransitionAnimHelper(paramLayoutInflater, this);
        if (this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper.a() != null)
        {
          paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
          paramLayoutInflater.addRule(3, 2131376636);
          this.titleRoot.addView(this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper.a(), paramLayoutInflater);
        }
      }
    }
    if (a())
    {
      paramLayoutInflater = a();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getBaseActivity(), paramLayoutInflater);
    }
    a();
    c();
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SubscribeVideoDetailFragment onActivityResult,requestCode=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",resultCode=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("SubscribeBaseFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt2 == -1) && (paramInt1 == 2))
    {
      QfavBuilder.a(super.getBaseActivity(), paramIntent);
      return;
    }
    if ((paramInt1 == 3) && (paramInt2 == -1))
    {
      localObject1 = paramIntent.getByteArrayExtra("feed");
      if (localObject1 != null)
      {
        Object localObject2 = new CertifiedAccountMeta.StFeed();
        try
        {
          ((CertifiedAccountMeta.StFeed)localObject2).mergeFrom((byte[])localObject1);
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)localObject2);
          a((CertifiedAccountMeta.StFeed)localObject2);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onActivityResult: prase stFeed error:");
          ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException.toString());
          QLog.e("SubscribeBaseFragment", 4, ((StringBuilder)localObject2).toString());
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localObject != null)
    {
      localObject = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo));
      VSReporter.a((String)localObject, localStringBuilder.toString(), "clk_return", 0, 0, new String[] { "", "" });
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localObject != null) && (((ExtraTypeInfo)localObject).sourceType == 9001))
      {
        localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getBaseActivity(), (String)localObject, 2016, null, null);
      }
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localObject != null)
      {
        ((MiniMsgUser)localObject).destroy();
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject != null) {
        ((IColorNoteController)localObject).onDestroy();
      }
    }
    this.b = true;
    a().removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper;
    if (localObject != null) {
      ((SubscribeShareHelper)localObject).a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onBackground();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject != null) {
        ((IColorNoteController)localObject).onPause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onForeground();
      }
      b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject != null) {
        ((IColorNoteController)localObject).onResume();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.c))
    {
      if (a())
      {
        MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
        if (localMiniMsgUser != null) {
          localMiniMsgUser.showOnFirst();
        }
      }
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
 * JD-Core Version:    0.7.0.1
 */