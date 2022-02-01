package com.tencent.mobileqq.activity.qcircle;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleFrame
  extends Frame
  implements SimpleEventReceiver, QzoneConfig.QzoneConfigChangeListener
{
  private static final QCircleRedInfoBean jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean = new QCircleRedInfoBean(1);
  public static boolean a;
  private int jdField_a_of_type_Int = ImmersiveUtils.dpToPx(54.0F);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private MainFragment jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
  private QCircleObserver jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver = new QCircleFrame.1(this);
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private int a()
  {
    int i;
    if (a().getAllRedNum() > 0) {
      i = 1;
    }
    for (;;)
    {
      QLog.d("QCircleFrame", 2, "RedDotDowpVia:" + i);
      return i;
      if (a().isShowActiveRedDot()) {
        i = 2;
      } else {
        i = 3;
      }
    }
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
    for (;;)
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
          localRedTypeInfo.red_desc.set(localJSONObject.toString());
          if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum() > 0)
          {
            localRedTypeInfo.red_type.set(5);
            localRedTypeInfo.red_content.set(String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum()));
            return localRedTypeInfo;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        if (!jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowActiveRedDot()) {
          continue;
        }
      }
      finally {}
      if (!paramBoolean) {
        localObject.red_type.set(0);
      }
    }
  }
  
  private void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRedInfoEvent)) {
      QCircleInjectImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, ((QCircleRedInfoEvent)paramSimpleBaseEvent).mInvokeMethodName, ((QCircleRedInfoEvent)paramSimpleBaseEvent).mIsClearRedPoint);
    }
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFrameEvent)) && (a() != null) && (paramSimpleBaseEvent.mHashCode != a().hashCode()))
    {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(Color.parseColor(((QCircleFrameEvent)paramSimpleBaseEvent).mBackgroundColor));
      }
      if (((QCircleFrameEvent)paramSimpleBaseEvent).mIsNeedExposeTab) {
        c();
      }
    }
  }
  
  private void g()
  {
    int i;
    if (a() != null)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      if (!ThemeUtil.a(null, false, null)) {
        break label104;
      }
      i = this.c;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(i);
      }
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(i);
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label112;
      }
      localWindow = a().getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
    }
    label104:
    label112:
    while (Build.VERSION.SDK_INT < 19)
    {
      Window localWindow;
      return;
      i = this.jdField_b_of_type_Int;
      break;
    }
    a().getWindow().addFlags(67108864);
  }
  
  private void i()
  {
    QCircleHostGlobalInfo.setCurrentTabActive(true);
    QCircleHostGlobalInfo.setHasRestoreState(false);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("key_jump_from", String.valueOf(11));
    localHashMap1.put("key_activity_bottom_margin", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap1.put("key_enable_splash", "1");
    if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.isShowActiveRedDot())
    {
      localObject = "1";
      localHashMap1.put("key_show_active_red_dot", localObject);
      localHashMap1.put("key_unread_red_num", String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getAllRedNum()));
      if ((jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean != null) && (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotTransInfo() != null)) {
        localHashMap2.put("key_red_dot_trans_info", jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotTransInfo());
      }
      if ((jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean != null) && (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getEntranceTabType() > 0)) {
        localHashMap1.put("key_assign_show_tab_type", String.valueOf(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getEntranceTabType()));
      }
      HostUIHelper.setTransEventViewGroup(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.a());
      if ((!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) || (a() == null) || (TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl()))) {
        break label310;
      }
      localObject = JumpParser.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, a(), jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl());
      if ((localObject == null) || (StringUtil.a(((JumpAction)localObject).c))) {
        break label273;
      }
      localHashMap1.putAll(((JumpAction)localObject).a);
    }
    label273:
    label310:
    for (Object localObject = ((JumpAction)localObject).c;; localObject = "openfolder")
    {
      QCircleUtils.a().enterBySchemeAction(a(), (String)localObject, localHashMap1, localHashMap2);
      return;
      localObject = "0";
      break;
      QLog.e("QCircleFrame", 2, "has JumpUrl:" + jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.getRedDotJumpUrl() + ", but parse jump action failed");
    }
  }
  
  private void j()
  {
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "little_world", "bottom_tab_clk", a(), 1, "", "", "", "");
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.inflate(2131560851, null));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a(int paramInt)
  {
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    HostUIHelper.closeTopShadowActivity();
    if ((QBaseActivity.sTopActivity instanceof QPublicTransFragmentActivity)) {
      QBaseActivity.sTopActivity.finish();
    }
    if (a() != null) {
      ImmersiveUtils.setStatusTextColor(false, a().getWindow());
    }
    FrameHelperActivity.c(true);
    this.jdField_b_of_type_Boolean = true;
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
      if (paramBoolean) {
        paramView.setBackgroundColor(Color.parseColor("#FAFAFB"));
      }
    }
    else {
      return;
    }
    paramView.setBackgroundColor(a().getColor(2131167091));
  }
  
  public void a(MainFragment paramMainFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment = paramMainFragment;
  }
  
  public void a(Frame paramFrame)
  {
    g();
    FrameHelperActivity.c(false);
    FrameHelperActivity.w();
    i();
    j();
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a(paramQBaseActivity);
  }
  
  public void b()
  {
    if (a() != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFrameEvent(a().hashCode(), true));
    }
    j();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("QCircleFrame", 1, "onResume: ");
    super.b(paramBoolean);
    if (a() != null) {
      ImmersiveUtils.setStatusTextColor(true, a().getWindow());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      QCircleInjectImpl.c(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, "QCircleFrame onResume");
    }
    Bitmap localBitmap = QCircleHostGlobalInfo.getFrameSnapShot();
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (localBitmap != null) && (localBitmap.getWidth() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "little_world", "bottom_tab_exp", a(), 1, "", "", "", "");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
    }
  }
  
  public void e()
  {
    QLog.d("QCircleFrame", 1, "onStart: ");
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
    }
  }
  
  public boolean e_()
  {
    return true;
  }
  
  public void f()
  {
    QLog.d("QCircleFrame", 1, "onCreate: ");
    super.f();
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379533));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369667));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    this.jdField_b_of_type_Int = a().getColor(2131166269);
    this.c = a().getColor(2131166270);
    SimpleEventBus.getInstance().registerReceiver(this);
    if (a() != null)
    {
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      g();
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
    QLog.d("QCircleFrame", 1, "onStop: ");
    super.h();
  }
  
  public void k()
  {
    QLog.d("QCircleFrame", 1, "onDestroy: ");
    super.k();
    FrameHelperActivity.c(true);
    QCircleHostGlobalInfo.setCurrentTabActive(false);
    HostUIHelper.closeTopShadowActivity();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver != null)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
    }
    a().removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment = null;
  }
  
  public void l()
  {
    super.l();
    if (jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean != null) {
      jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleRedInfoBean.reset();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      QCircleInjectImpl.c(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, "onAccountChanged");
    }
  }
  
  public void n()
  {
    QLog.d("QCircleFrame", 1, "onPause: ");
    super.n();
  }
  
  public void onConfigChange()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      QCircleInjectImpl.c(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, "Wns onConfigChange");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    b(paramSimpleBaseEvent);
    a(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame
 * JD-Core Version:    0.7.0.1
 */