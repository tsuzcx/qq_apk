package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

public class ServiceAccountFolderActivityNew
  extends BaseActivity
  implements SimpleEventReceiver
{
  public static boolean a;
  View.OnClickListener b = new ServiceAccountFolderActivityNew.1(this);
  private View c;
  private View d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private SquareImageView h;
  private RadioGroup i;
  private RadioButton j;
  private RadioButton k;
  private QQViewPager l;
  private ServiceAccountFolderActivityNew.FolderTabFragmentAdapter m;
  private ArrayList<FolderBaseTabFragment> n = new ArrayList();
  private String o;
  private String p;
  private ImageView q;
  private TopGestureLayout r;
  private boolean s;
  private long t;
  private int u;
  private boolean v;
  private ExtraTypeInfo w;
  private CertifiedAccountRead.StGetMainPageRsp x;
  private FolderFollowTabFragment y;
  private boolean z = true;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqsubscribe", "DefaultSelectExplorePage", 0) > 0) {
      bool = true;
    }
    a = bool;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramStGetMainPageRsp.messStatus.get() != null)
    {
      ServiceAccountFolderActivityNew.FolderTabFragmentAdapter localFolderTabFragmentAdapter = this.m;
      if ((localFolderTabFragmentAdapter != null) && (localFolderTabFragmentAdapter.a(0) != null) && ((this.m.a(0) instanceof FolderFollowTabFragment))) {
        ((FolderFollowTabFragment)this.m.a(0)).a(paramStGetMainPageRsp.messStatus.noticeCount.get());
      }
    }
  }
  
  private void b(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramStGetMainPageRsp.user != null) && (paramStGetMainPageRsp.user.certifiedType.get() == 1))
    {
      paramStGetMainPageRsp = a(a(QzoneConfig.getInstance().getConfig("H5Url", "SubPersonalHomePageUrl", "https://h5.qzone.qq.com/v2/vip/live/profile?openid={openid}&puin={puin}&_wv=16777217"), "{puin}", paramStGetMainPageRsp.user.id.get()), "{openid}", "");
      try
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("url", paramStGetMainPageRsp);
        ((Intent)localObject).setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
        startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramStGetMainPageRsp)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start Intent error ");
        ((StringBuilder)localObject).append(paramStGetMainPageRsp);
        QLog.e("ServiceAccountFolderActivityNew", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if ((paramStGetMainPageRsp.user != null) && (paramStGetMainPageRsp.user.type.get() == 1))
    {
      SubscribeLaucher.a(this, paramStGetMainPageRsp.user);
      VSReporter.b("auth_follow", "clk_head", 0, 0, new String[0]);
      return;
    }
    SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
  }
  
  private void d()
  {
    this.w = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    this.y = new FolderFollowTabFragment();
    this.n.add(this.y);
    this.z = QVipServiceAccountFolderProcessor.a().showRecommendPage;
    if ((!a()) && (this.z))
    {
      FolderRecommendTabFragment localFolderRecommendTabFragment = new FolderRecommendTabFragment();
      this.n.add(localFolderRecommendTabFragment);
    }
    this.o = this.app.getAccount();
  }
  
  private void e()
  {
    this.c = findViewById(2131445655);
    this.d = findViewById(2131445042);
    this.i = ((RadioGroup)findViewById(2131444765));
    this.j = ((RadioButton)findViewById(2131444183));
    this.k = ((RadioButton)findViewById(2131444192));
    this.l = ((QQViewPager)findViewById(2131450003));
    this.y.a(this.l);
    this.m = new ServiceAccountFolderActivityNew.FolderTabFragmentAdapter(this, getSupportFragmentManager());
    this.l.setAdapter(this.m);
    this.l.setOffscreenPageLimit(1);
    this.g = ((ImageView)findViewById(2131436507));
    if (this.s)
    {
      this.d.setBackgroundColor(-16777216);
      this.j.setTextColor(getResources().getColor(2131165678));
      this.j.setBackgroundDrawable(getResources().getDrawable(2130839185));
      this.k.setTextColor(getResources().getColor(2131165678));
      this.k.setBackgroundDrawable(getResources().getDrawable(2130839185));
      this.g.setImageDrawable(getResources().getDrawable(2130839159));
      this.g.setColorFilter(1308622848);
    }
    g();
    j();
  }
  
  private void f()
  {
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = this.x;
    if ((localStGetMainPageRsp != null) && (localStGetMainPageRsp.user != null) && (SubscribeUtils.c(this.x.user.attr.get())) && (!a()))
    {
      this.g.setVisibility(8);
      VSReporter.a(((CertifiedAccountMeta.StUser)this.x.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      this.g.setOnClickListener(this.b);
      return;
    }
    this.g.setVisibility(8);
  }
  
  private void g()
  {
    this.q = ((ImageView)findViewById(2131447741));
    this.e = ((ImageView)findViewById(2131436436));
    this.e.setOnClickListener(new ServiceAccountFolderActivityNew.2(this));
    this.f = ((ImageView)findViewById(2131437785));
    this.h = ((SquareImageView)findViewById(2131437786));
    if (this.s)
    {
      this.e.setImageDrawable(getResources().getDrawable(2130842586));
      this.f.setImageDrawable(getResources().getDrawable(2130839101));
      this.h.setFilterColor(1711276032);
    }
    this.f.setVisibility(8);
    this.h.setVisibility(0);
    h();
  }
  
  private void h()
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.o, i());
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, new ServiceAccountFolderActivityNew.3(this));
  }
  
  private COMM.StCommonExt i()
  {
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("user_info");
    localEntry.value.set("1");
    localStCommonExt.mapInfo.get().add(localEntry);
    return localStCommonExt;
  }
  
  private void j()
  {
    this.i.setOnCheckedChangeListener(new ServiceAccountFolderActivityNew.4(this));
    this.l.setOnPageChangeListener(new ServiceAccountFolderActivityNew.5(this));
    if ((a()) || (!this.z)) {
      this.k.setVisibility(8);
    }
    ExtraTypeInfo localExtraTypeInfo = this.w;
    if ((localExtraTypeInfo != null) && (localExtraTypeInfo.pageType == 7004) && (!a()) && (this.z))
    {
      this.l.setCurrentItem(0);
      MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
    }
    else
    {
      this.l.setCurrentItem(0);
      MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
    }
    this.u = this.l.getCurrentItem();
    this.t = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    if (((paramInt == 0) && (this.l.getCurrentItem() != 0)) || (paramInt == 8)) {
      this.q.setVisibility(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = c();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableFlingRight->enable:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivityNew", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    return StudyModeManager.h();
  }
  
  public boolean b()
  {
    return this.q.getVisibility() == 0;
  }
  
  protected TopGestureLayout c()
  {
    if (this.r == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.r = ((TopGestureLayout)localObject);
      }
    }
    return this.r;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131625664);
    this.s = SubscribeUtils.a();
    d();
    e();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.c.setFitsSystemWindows(true);
      this.c.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    try
    {
      SubImageLoader.a();
    }
    catch (Exception localException)
    {
      QLog.e("ServiceAccountFolderActivityNew", 1, localException, new Object[0]);
    }
    if (this.t > 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.t;
      String str;
      if (this.u == FolderBaseTabFragment.d) {
        str = "auth_follow";
      } else {
        str = "auth_discover";
      }
      VSReporter.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      this.t = 0L;
    }
    this.n.clear();
    VSNetworkHelper.getInstance().cancelRequest(BaseApplicationImpl.getContext());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(UserStateUpdateEvent.class);
    return localArrayList;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof UserStateUpdateEvent)) {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew
 * JD-Core Version:    0.7.0.1
 */