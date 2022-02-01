package com.tencent.mobileqq.activity.qcircle;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.main.ASFrameFactory;
import com.tencent.mobileqq.auto.engine.main.IASBaseFrame;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleThemeChangeEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleFrame
  extends Frame
  implements SimpleEventReceiver, QzoneConfig.QzoneConfigChangeListener
{
  public static boolean a = false;
  private static final QCircleRedInfoBean e = new QCircleRedInfoBean(1);
  private static final long k = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  private static boolean l = false;
  private FrameLayout b;
  private Handler c;
  private MainFragment d;
  private boolean f = false;
  private int g;
  private int h;
  private int i;
  private ImmersiveTitleBar2 j;
  private long m = 9223372036854775807L;
  private long n = 9223372036854775807L;
  private boolean o;
  private IASBaseFrame p;
  private Fragment q;
  private boolean r;
  private QCircleObserver s = new QCircleFrame.1(this);
  
  private void A()
  {
    this.m = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.n > k)
    {
      l = true;
      this.o = true;
    }
  }
  
  private void B()
  {
    FrameLayout localFrameLayout = this.b;
    if (localFrameLayout == null) {
      return;
    }
    Resources localResources = Q();
    int i1;
    if (QQTheme.isNowThemeIsNight()) {
      i1 = 2131167018;
    } else {
      i1 = 2131167017;
    }
    localFrameLayout.setBackgroundColor(localResources.getColor(i1));
  }
  
  private Handler C()
  {
    if (this.c == null) {
      this.c = new Handler(Looper.getMainLooper());
    }
    return this.c;
  }
  
  private int D()
  {
    int i1;
    if (n().getAllRedNum() > 0) {
      i1 = 1;
    } else if (n().isShowRedDot()) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedDotDowpVia:");
    localStringBuilder.append(i1);
    QLog.d("QCircleFrame", 2, localStringBuilder.toString());
    return i1;
  }
  
  private void E()
  {
    ReportController.b(this.aF, "CliOper", "", "", "little_world", "bottom_tab_clk", D(), 1, "", "", "", "");
  }
  
  private void F()
  {
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleReportHelper.getQQCirclePageStackNum());
    localStringBuilder.append("");
    localMap.put("xsj_page_stack_num", localStringBuilder.toString());
    localMap.put("xsj_main_entrance", "qq_main_tab");
    localMap.put("xsj_sub_entrance", "default");
    VideoReport.reportEvent("xsj_login", localMap);
  }
  
  private void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRedInfoEvent))
    {
      MainFragment localMainFragment = this.d;
      paramSimpleBaseEvent = (QCircleRedInfoEvent)paramSimpleBaseEvent;
      QCircleInjectImpl.a(localMainFragment, paramSimpleBaseEvent.mInvokeMethodName, paramSimpleBaseEvent.mIsClearRedPoint);
    }
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFrameEvent)) && (P() != null) && (paramSimpleBaseEvent.mHashCode != P().hashCode()) && (((QCircleFrameEvent)paramSimpleBaseEvent).mIsNeedExposeTab)) {
      o();
    }
  }
  
  public static BusinessInfoCheckUpdate.RedTypeInfo c(boolean paramBoolean)
  {
    try
    {
      e.refreshRedDotInfo();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(-1);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("cn", "#FF0000");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localRedTypeInfo.red_desc.set(localJSONObject.toString());
      if (e.getAllRedNum() > 0)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_content.set(String.valueOf(e.getAllRedNum()));
      }
      else if ((e.isShowRedDot()) && (!paramBoolean))
      {
        localRedTypeInfo.red_type.set(0);
        l = true;
      }
      return localRedTypeInfo;
    }
    finally {}
  }
  
  public static QCircleRedInfoBean n()
  {
    return e;
  }
  
  private void p()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("KEY_AS_ENTER_BEAN", u());
    this.q.setArguments(localBundle);
  }
  
  private void q()
  {
    try
    {
      if (this.b == null) {
        return;
      }
      if (this.p != null)
      {
        this.p.f();
        P().getSupportFragmentManager().beginTransaction().remove(this.q).commitAllowingStateLoss();
        this.q = null;
        QLog.d("QCircleFrame", 1, "releaseFolderFragment");
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAccountChanged exception:");
      localStringBuilder.append(localException.getMessage());
      QLog.d("QCircleFrame", 1, localStringBuilder.toString());
    }
  }
  
  private void r()
  {
    if ((P() != null) && (ImmersiveUtils.isSupporImmersive() != 0)) {
      ImmersiveUtils.setStatusTextColor(s(), P().getWindow());
    }
  }
  
  private boolean s()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      bool1 = bool2;
      if (!QCircleConfigHelper.bg()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void t()
  {
    FrameLayout localFrameLayout = this.b;
    if (localFrameLayout == null) {
      return;
    }
    if (this.q == null)
    {
      this.q = this.p.a(localFrameLayout);
      p();
      P().getSupportFragmentManager().beginTransaction().replace(2131441682, this.q).commitAllowingStateLoss();
      QLog.d("QCircleFrame", 1, "wrapFolderFragmentIfNeed");
    }
  }
  
  private ASEnterBean u()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("key_jump_from", String.valueOf(11));
    Object localObject = "1";
    localHashMap1.put("key_enable_splash", "1");
    if (!e.isShowRedDot()) {
      localObject = "0";
    }
    localHashMap1.put("key_show_active_red_dot", localObject);
    localHashMap1.put("key_unread_red_num", String.valueOf(e.getAllRedNum()));
    localHashMap1.put("xsj_main_entrance", "qq_main_tab");
    if (e.getRedDotTransInfo() != null) {
      localHashMap2.put("key_red_dot_trans_info", e.getRedDotTransInfo());
    }
    if (e.getEntranceTabType() > 0) {
      localHashMap1.put("key_assign_show_tab_type", String.valueOf(e.getEntranceTabType()));
    }
    if (((this.aF instanceof QQAppInterface)) && (P() != null) && (!TextUtils.isEmpty(e.getRedDotJumpUrl())))
    {
      localObject = JumpParser.a((QQAppInterface)this.aF, P(), e.getRedDotJumpUrl());
      if ((localObject != null) && (!TextUtils.isEmpty(((JumpAction)localObject).e)))
      {
        localHashMap1.putAll(((JumpAction)localObject).f);
        localObject = ((JumpAction)localObject).e;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("has JumpUrl:");
        ((StringBuilder)localObject).append(e.getRedDotJumpUrl());
        ((StringBuilder)localObject).append(", but parse jump action failed");
        QLog.e("QCircleFrame", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = "openfolder";
    }
    return new ASEnterBean("qcircle-app").setByteAttrs(localHashMap2).setSchemeAction((String)localObject).setAttrs(localHashMap1);
  }
  
  private void w()
  {
    if (l)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(P().hashCode(), x()));
      this.o = false;
      l = false;
    }
  }
  
  private int x()
  {
    if (this.o) {
      return 4;
    }
    if (e.isShowRecommendRedDot()) {
      return 1;
    }
    if (e.isShowActiveRedDot()) {
      return 2;
    }
    return -1;
  }
  
  private void y()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setStatusTextColor(this.r, P().getWindow());
    }
  }
  
  private void z()
  {
    this.n = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.m > k)
    {
      l = true;
      this.o = true;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    FrameLayout localFrameLayout = this.b;
    if (localFrameLayout != null) {
      return localFrameLayout;
    }
    this.p = ASFrameFactory.a("qcircle-app");
    this.b = ((FrameLayout)paramLayoutInflater.inflate(2131626857, null));
    B();
    this.q = this.p.a(this.b);
    if (this.q == null)
    {
      QLog.d("QCircleFrame", 1, "onCreateView fragment is empty");
      return this.b;
    }
    p();
    P().getSupportFragmentManager().beginTransaction().replace(2131441682, this.q).commitAllowingStateLoss();
    VideoReport.addToDetectionWhitelist(P());
    QLog.d("QCircleFrame", 1, "onCreateView new fragment");
    return this.b;
  }
  
  public void a()
  {
    QLog.d("QCircleFrame", 1, "onCreate: ");
    super.a();
    this.g = Q().getColor(2131167017);
    this.h = Q().getColor(2131167018);
    this.j = ((ImmersiveTitleBar2)d(2131447582));
    IphoneTitleBarActivity.setLayerType(this.j);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(int paramInt)
  {
    ASDynamicEngineFactory.a("qcircle-app").a(false);
    z();
    y();
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    this.f = false;
    QCircleReportHelper.getInstance().setQCircleIsActivate(false);
    IASBaseFrame localIASBaseFrame = this.p;
    if (localIASBaseFrame != null) {
      localIASBaseFrame.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setBackgroundColor(Color.parseColor("#FAFAFB"));
        return;
      }
      paramView.setBackgroundColor(Q().getColor(2131168092));
    }
  }
  
  public void a(MainFragment paramMainFragment)
  {
    this.d = paramMainFragment;
  }
  
  public void a(Frame paramFrame)
  {
    this.r = ImmersiveUtils.isStatusTextUseDarkColor(P().getWindow());
    ASDynamicEngineFactory.a("qcircle-app").a(true);
    QCircleHostGlobalInfo.setCurrentTabActive(true);
    t();
    A();
    this.f = true;
    FrameHelperActivity.c(false);
    r();
    paramFrame = this.p;
    if (paramFrame != null) {
      paramFrame.a();
    }
    w();
    E();
    F();
    QCircleReportHelper.getInstance().setQCircleIsActivate(true);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QCircleFrame", 1, "onResume: ");
    super.a(paramBoolean);
    ApngImage.playByTag(8);
    MainFragment localMainFragment = this.d;
    if (localMainFragment != null) {
      QCircleInjectImpl.c(localMainFragment, "QCircleFrame onResume");
    }
    if (this.f) {
      FrameHelperActivity.c(false);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    FrameLayout localFrameLayout = this.b;
    if (localFrameLayout != null) {
      localFrameLayout.setPadding(0, 0, 0, this.i);
    }
    HostUIHelper.getInstance().setHostTABHeight(this.i);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.aF != null) {
      ((QQAppInterface)this.aF).addObserver(this.s);
    }
    Object localObject = e;
    if (localObject != null) {
      ((QCircleRedInfoBean)localObject).reset();
    }
    if (paramBoolean) {
      q();
    }
    localObject = this.d;
    if (localObject != null) {
      QCircleInjectImpl.c((FrameFragment)localObject, "onAccountChanged");
    }
    localObject = this.p;
    if (localObject != null) {
      ((IASBaseFrame)localObject).a(paramBoolean);
    }
  }
  
  public void bQ_()
  {
    QLog.d("QCircleFrame", 1, "onPause: ");
    super.bQ_();
    ApngImage.pauseByTag(8);
    FrameHelperActivity.c(true);
  }
  
  public boolean cz_()
  {
    return true;
  }
  
  public void d()
  {
    QLog.d("QCircleFrame", 1, "onDestroy: ");
    super.d();
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if ((this.aF != null) && (this.s != null)) {
      ((QQAppInterface)this.aF).removeObserver(this.s);
    }
    C().removeCallbacksAndMessages(null);
    IASBaseFrame localIASBaseFrame = this.p;
    if (localIASBaseFrame != null) {
      localIASBaseFrame.c();
    }
    this.d = null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFrameEvent.class);
    localArrayList.add(QCircleRedInfoEvent.class);
    return localArrayList;
  }
  
  public boolean h()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      boolean bool = ((IASBaseFrame)localObject).d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBackPressed qcircleFrame:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ASDynamicEngine_back", 1, ((StringBuilder)localObject).toString());
      return bool;
    }
    return super.h();
  }
  
  public void k()
  {
    if (this.aF != null) {
      ((QQAppInterface)this.aF).removeObserver(this.s);
    }
  }
  
  public void l()
  {
    MainFragment localMainFragment = this.d;
    if (localMainFragment != null) {
      QCircleInjectImpl.c(localMainFragment, "onPostThemeChanged");
    }
    r();
    B();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleThemeChangeEvent(P().hashCode()));
  }
  
  public void m()
  {
    if (P() != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(P().hashCode(), 0));
    }
    IASBaseFrame localIASBaseFrame = this.p;
    if (localIASBaseFrame != null) {
      localIASBaseFrame.e();
    }
    E();
  }
  
  public void o()
  {
    ReportController.b(this.aF, "CliOper", "", "", "little_world", "bottom_tab_exp", D(), 1, "", "", "", "");
  }
  
  public void onConfigChange()
  {
    MainFragment localMainFragment = this.d;
    if (localMainFragment != null) {
      QCircleInjectImpl.c(localMainFragment, "Wns onConfigChange");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    b(paramSimpleBaseEvent);
    a(paramSimpleBaseEvent);
  }
  
  public void v()
  {
    super.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame
 * JD-Core Version:    0.7.0.1
 */