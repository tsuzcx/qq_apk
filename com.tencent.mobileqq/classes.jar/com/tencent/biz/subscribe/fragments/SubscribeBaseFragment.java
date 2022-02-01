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
  private static long i;
  protected CertifiedAccountMeta.StFeed a;
  protected ExtraTypeInfo b;
  protected SubscribeShareHelper c;
  protected IColorNoteController d;
  protected boolean e;
  protected boolean f;
  protected TransitionAnimHelper g;
  private Handler h;
  private MiniMsgUser j;
  private boolean k;
  
  private void a(int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    Object localObject = this.a;
    if ((localObject != null) && (!StringUtil.isEmpty(((CertifiedAccountMeta.StFeed)localObject).poster.id.get())))
    {
      localObject = this.a.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exp_");
      localStringBuilder.append(SubscribeShareHelper.a(paramExtraTypeInfo));
      VSReporter.a((String)localObject, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[0]);
    }
  }
  
  private void i()
  {
    if (this.d != null) {
      return;
    }
    this.d = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.d.init(getBaseActivity(), false, true);
    this.d.attachToActivity(getBaseActivity());
    this.d.setServiceInfo(new SubscribeBaseFragment.2(this));
    this.d.setOnColorNoteAnimFinishListener(new SubscribeBaseFragment.3(this));
    this.d.setOnColorNoteCurdListener(new SubscribeBaseFragment.4(this));
  }
  
  private void j()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      long l = getBaseActivity().getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if (l != 0L)
      {
        Object localObject = this.b;
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
  
  private void k()
  {
    View localView = new View(getBaseActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getBaseActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void l()
  {
    File localFile = new File(SubscribeUtils.b());
    if ((!localFile.exists()) && (SdCardUtil.getSdCardDirectory() != null))
    {
      SubscribeUtils.a(localFile, (String)VSConfigManager.a().a("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
      return;
    }
    QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
  }
  
  private void m()
  {
    QLog.i("SubscribeBaseFragment", 1, "downloadAnimationPic");
    Object localObject1 = SubscribeConstants.h;
    int n = localObject1.length;
    int m = 0;
    while (m < n)
    {
      Object localObject2 = localObject1[m];
      String str = (String)SubscribeConstants.f.get(localObject2);
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
      str = (String)SubscribeConstants.g.get(localObject2);
      localObject2 = (String)SubscribeConstants.e.get(localObject2);
      SubscribeUtils.a(localFile, (String)VSConfigManager.a().a(str, localObject2), SubscribeConstants.c);
      m += 1;
    }
  }
  
  protected View a()
  {
    return null;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed) {}
  
  protected abstract void a(View paramView);
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    if (paramShareInfoBean != null)
    {
      Object localObject;
      if (paramShareInfoBean.b == null)
      {
        localObject = this.a;
        if (localObject != null) {
          paramShareInfoBean.b = ((CertifiedAccountMeta.StFeed)localObject);
        }
      }
      if (paramShareInfoBean.e == null)
      {
        localObject = this.b;
        if (localObject != null) {
          paramShareInfoBean.e = ((ExtraTypeInfo)localObject);
        }
      }
      if (this.c != null)
      {
        a(paramShareInfoBean.a, this.b);
        this.c.a(paramShareInfoBean, this.d);
      }
      if ((c()) && (b() != null) && (paramShareInfoBean.a == 1) && (b().getVisibility() == 0) && (e() != null)) {
        e().onClick(a());
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    return new int[2];
  }
  
  protected TextView b()
  {
    return null;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.a = paramStFeed;
    }
  }
  
  protected boolean c()
  {
    return (a() != null) && (b() != null);
  }
  
  protected MiniMsgUserParam d()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 25;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.unreadView = b();
    return localMiniMsgUserParam;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    l();
    m();
    if (getBaseActivity().getIntent() != null)
    {
      this.a = new CertifiedAccountMeta.StFeed();
      try
      {
        this.a = ((CertifiedAccountMeta.StFeed)this.a.mergeFrom(getBaseActivity().getIntent().getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
        this.b = ((ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
        if (this.b == null) {
          this.b = new ExtraTypeInfo();
        }
      }
      catch (Exception paramLayoutInflater)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
    this.c = new SubscribeShareHelper(getBaseActivity(), new SubscribeBaseFragment.1(this));
    if (getBaseActivity().getIntent().hasExtra("bundle_key_parms_extra"))
    {
      paramLayoutInflater = getBaseActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
      if (TransitionAnimHelper.a(paramLayoutInflater))
      {
        this.g = new TransitionAnimHelper(paramLayoutInflater, this);
        if (this.g.c() != null)
        {
          paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
          paramLayoutInflater.addRule(3, 2131444897);
          this.titleRoot.addView(this.g.c(), paramLayoutInflater);
        }
      }
    }
    if (c())
    {
      paramLayoutInflater = d();
      this.j = new MiniMsgUser(getBaseActivity(), paramLayoutInflater);
    }
    f();
    j();
  }
  
  public MiniMsgUser e()
  {
    return this.j;
  }
  
  protected void f()
  {
    if (SubscribeUtils.a()) {
      k();
    }
    a(this.mContentView);
  }
  
  public Handler g()
  {
    if (this.h == null) {
      this.h = new Handler(Looper.getMainLooper());
    }
    return this.h;
  }
  
  public int h()
  {
    return 0;
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
          this.a = ((CertifiedAccountMeta.StFeed)localObject2);
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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(this.b));
      VSReporter.a((String)localObject, localStringBuilder.toString(), "clk_return", 0, 0, new String[] { "", "" });
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject = this.b;
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
    if (c())
    {
      localObject = this.j;
      if (localObject != null)
      {
        ((MiniMsgUser)localObject).destroy();
        this.j = null;
      }
      localObject = this.d;
      if (localObject != null) {
        ((IColorNoteController)localObject).onDestroy();
      }
    }
    this.f = true;
    g().removeCallbacksAndMessages(null);
    Object localObject = this.c;
    if (localObject != null) {
      ((SubscribeShareHelper)localObject).a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (c())
    {
      Object localObject = this.j;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onBackground();
      }
      localObject = this.d;
      if (localObject != null) {
        ((IColorNoteController)localObject).onPause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (c())
    {
      Object localObject = this.j;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onForeground();
      }
      i();
      localObject = this.d;
      if (localObject != null) {
        ((IColorNoteController)localObject).onResume();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.k))
    {
      if (c())
      {
        MiniMsgUser localMiniMsgUser = this.j;
        if (localMiniMsgUser != null) {
          localMiniMsgUser.showOnFirst();
        }
      }
      this.k = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
 * JD-Core Version:    0.7.0.1
 */