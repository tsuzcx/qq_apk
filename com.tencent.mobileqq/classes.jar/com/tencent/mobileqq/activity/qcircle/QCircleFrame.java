package com.tencent.mobileqq.activity.qcircle;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleThemeChangeEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
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
  private static final long jdField_a_of_type_Long = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  private static final QCircleRedInfoBean jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean = new QCircleRedInfoBean(1);
  public static boolean a = false;
  private static boolean d = false;
  private int jdField_a_of_type_Int;
  private LocalActivityManager jdField_a_of_type_AndroidAppLocalActivityManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private MainFragment jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
  private QCircleObserver jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver = new QCircleFrame.2(this);
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  private boolean jdField_c_of_type_Boolean;
  private boolean e;
  
  private int a()
  {
    if (this.e) {
      return 4;
    }
    if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowRecommendRedDot()) {
      return 1;
    }
    if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowActiveRedDot()) {
      return 2;
    }
    return -1;
  }
  
  private LocalActivityManager a()
  {
    if (this.jdField_a_of_type_AndroidAppLocalActivityManager == null)
    {
      this.jdField_a_of_type_AndroidAppLocalActivityManager = new LocalActivityManager(a(), true);
      this.jdField_a_of_type_AndroidAppLocalActivityManager.dispatchCreate(null);
    }
    return this.jdField_a_of_type_AndroidAppLocalActivityManager;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static QCircleRedInfoBean a()
  {
    return jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean;
  }
  
  public static BusinessInfoCheckUpdate.RedTypeInfo a(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.refreshRedDotInfo();
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
      if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum() > 0)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_content.set(String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum()));
      }
      else if ((jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowRedDot()) && (!paramBoolean))
      {
        localRedTypeInfo.red_type.set(0);
        d = true;
      }
      return localRedTypeInfo;
    }
    finally {}
  }
  
  private void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRedInfoEvent))
    {
      MainFragment localMainFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
      paramSimpleBaseEvent = (QCircleRedInfoEvent)paramSimpleBaseEvent;
      QCircleInjectImpl.a(localMainFragment, paramSimpleBaseEvent.mInvokeMethodName, paramSimpleBaseEvent.mIsClearRedPoint);
    }
  }
  
  private int b()
  {
    int i;
    if (a().getAllRedNum() > 0) {
      i = 1;
    } else if (a().isShowRedDot()) {
      i = 2;
    } else {
      i = 3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedDotDowpVia:");
    localStringBuilder.append(i);
    QLog.d("QCircleFrame", 2, localStringBuilder.toString());
    return i;
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFrameEvent)) && (a() != null) && (paramSimpleBaseEvent.mHashCode != a().hashCode()) && (((QCircleFrameEvent)paramSimpleBaseEvent).mIsNeedExposeTab)) {
      k();
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            return;
          }
        }
      }
    }
    try
    {
      a().dispatchDestroy(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    a().dispatchStop();
    return;
    a().dispatchPause(false);
    return;
    a().dispatchResume();
    return;
  }
  
  private void l()
  {
    if (a() != null)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      int i;
      if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
        i = this.jdField_b_of_type_Int;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      Object localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
      if (localObject != null) {
        ((ImmersiveTitleBar2)localObject).setBackgroundColor(i);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = a().getWindow();
        ((Window)localObject).clearFlags(67108864);
        ((Window)localObject).getDecorView().setSystemUiVisibility(1280);
        ((Window)localObject).addFlags(-2147483648);
        return;
      }
      if (Build.VERSION.SDK_INT >= 19) {
        a().getWindow().addFlags(67108864);
      }
    }
  }
  
  private void m()
  {
    QCircleHostGlobalInfo.setCurrentTabActive(true);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      n();
      c(1);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) && (!((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).checkIsQCirclePluginLoadingActivity(QBaseActivity.sTopActivity)))
    {
      this.jdField_c_of_type_Boolean = true;
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      localHashMap1.put("key_jump_from", String.valueOf(11));
      Object localObject = "1";
      localHashMap1.put("key_enable_splash", "1");
      if (!jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowRedDot()) {
        localObject = "0";
      }
      localHashMap1.put("key_show_active_red_dot", localObject);
      localHashMap1.put("key_unread_red_num", String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum()));
      localHashMap1.put("xsj_main_entrance", "qq_main_tab");
      localObject = jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean;
      if ((localObject != null) && (((QCircleRedInfoBean)localObject).getRedDotTransInfo() != null)) {
        localHashMap2.put("key_red_dot_trans_info", jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotTransInfo());
      }
      localObject = jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean;
      if ((localObject != null) && (((QCircleRedInfoBean)localObject).getEntranceTabType() > 0)) {
        localHashMap1.put("key_assign_show_tab_type", String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getEntranceTabType()));
      }
      if (((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) && (a() != null) && (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl())))
      {
        localObject = JumpParser.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a(), jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl());
        if ((localObject != null) && (!StringUtil.a(((JumpAction)localObject).c)))
        {
          localHashMap1.putAll(((JumpAction)localObject).a);
          localObject = ((JumpAction)localObject).c;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("has JumpUrl:");
          ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl());
          ((StringBuilder)localObject).append(", but parse jump action failed");
          QLog.e("QCircleFrame", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = "openfolder";
      }
      HostUIHelper.getInstance().setPluginIntentHook(new QCircleFrame.1(this));
      QCircleUtils.a().enterBySchemeAction(a(), (String)localObject, localHashMap1, localHashMap2);
      return;
    }
    QLog.e("QCircleFrame", 1, "plugin is loading now and return");
  }
  
  private void n()
  {
    if (d)
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(a().hashCode(), a()));
      this.e = false;
      d = false;
    }
  }
  
  private void o()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long > jdField_a_of_type_Long)
    {
      d = true;
      this.e = true;
    }
  }
  
  private void p()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > jdField_a_of_type_Long)
    {
      d = true;
      this.e = true;
    }
  }
  
  private void r()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      return;
    }
    Resources localResources = a();
    int i;
    if (QQTheme.a()) {
      i = 2131166281;
    } else {
      i = 2131166280;
    }
    localFrameLayout.setBackgroundColor(localResources.getColor(i));
  }
  
  private void s()
  {
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "little_world", "bottom_tab_clk", b(), 1, "", "", "", "");
  }
  
  private void t()
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
  
  public void V_()
  {
    QLog.d("QCircleFrame", 1, "onStart: ");
    super.V_();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.inflate(2131560726, null));
    r();
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    QLog.d("QCircleFrame", 1, "onCreate: ");
    super.a();
    this.jdField_a_of_type_Int = a().getColor(2131166280);
    this.jdField_b_of_type_Int = a().getColor(2131166281);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378881));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    SimpleEventBus.getInstance().registerReceiver(this);
    if (a() != null) {
      l();
    }
  }
  
  public void a(int paramInt)
  {
    o();
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    c(2);
    c(3);
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
      paramView.setBackgroundColor(a().getColor(2131167114));
    }
  }
  
  public void a(MainFragment paramMainFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment = paramMainFragment;
  }
  
  public void a(Frame paramFrame)
  {
    p();
    this.jdField_b_of_type_Boolean = true;
    FrameHelperActivity.b(false);
    l();
    m();
    s();
    t();
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QCircleFrame", 1, "onResume: ");
    super.a(paramBoolean);
    MainFragment localMainFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
    if (localMainFragment != null) {
      QCircleInjectImpl.c(localMainFragment, "QCircleFrame onResume");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      c(1);
      FrameHelperActivity.b(false);
    }
  }
  
  public void ab_()
  {
    QLog.d("QCircleFrame", 1, "onPause: ");
    super.ab_();
    c(2);
    FrameHelperActivity.b(true);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_c_of_type_Int) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.setPadding(0, 0, 0, this.jdField_c_of_type_Int);
    }
    HostUIHelper.getInstance().setHostTABHeight(this.jdField_c_of_type_Int);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    QLog.d("QCircleFrame", 1, "onStop: ");
    super.c();
    c(3);
  }
  
  public void d()
  {
    QLog.d("QCircleFrame", 1, "onDestroy: ");
    super.d();
    c(4);
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver != null)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
    }
    a().removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment = null;
  }
  
  protected void f()
  {
    super.f();
    Object localObject = jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean;
    if (localObject != null) {
      ((QCircleRedInfoBean)localObject).reset();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
    if (localObject != null) {
      QCircleInjectImpl.c((FrameFragment)localObject, "onAccountChanged");
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFrameEvent.class);
    localArrayList.add(QCircleRedInfoEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
    if (localObject != null) {
      QCircleInjectImpl.c((FrameFragment)localObject, "onPostThemeChanged");
    }
    l();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleThemeChangeEvent(a().hashCode()));
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPostThemeChanged: removeView isNowThemeIsNight()");
        ((StringBuilder)localObject).append(QQTheme.a());
        QLog.d("QCircleFrame", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
        r();
      }
      c(4);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_b_of_type_Boolean) {
      m();
    }
  }
  
  public void j()
  {
    if (a() != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(a().hashCode(), 0));
    }
    s();
  }
  
  public void k()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "little_world", "bottom_tab_exp", b(), 1, "", "", "", "");
  }
  
  public void onConfigChange()
  {
    MainFragment localMainFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
    if (localMainFragment != null) {
      QCircleInjectImpl.c(localMainFragment, "Wns onConfigChange");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    b(paramSimpleBaseEvent);
    a(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame
 * JD-Core Version:    0.7.0.1
 */