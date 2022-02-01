package com.tencent.mobileqq.activity.qcircle;

import akpw;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import anun;
import bdfk;
import com.tencent.biz.qcircleshadow.lib.HostUIHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostGlobalInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import cooperation.qqcircle.beans.QCircleRedInfoBean;
import cooperation.qqcircle.chat.QCircleObserver;
import cooperation.qqcircle.events.QCircleFrameEvent;
import cooperation.qqcircle.events.QCircleRedInfoEvent;
import java.util.ArrayList;

public class QCircleFrame
  extends anun
  implements SimpleEventReceiver, QzoneConfig.QzoneConfigChangeListener
{
  private static final QCircleRedInfoBean jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean = new QCircleRedInfoBean();
  private int jdField_a_of_type_Int = ImmersiveUtils.a(54.0F);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private MainFragment jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private QCircleObserver jdField_a_of_type_CooperationQqcircleChatQCircleObserver = new akpw(this);
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleRedInfoEvent)) && (((QCircleRedInfoEvent)paramSimpleBaseEvent).mIsRefreshRedPoint) && (jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean != null)) {
      jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean.refreshRedDotInfo();
    }
  }
  
  private void b(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFrameEvent)) && (a() != null) && (paramSimpleBaseEvent.mHashCode != a().hashCode()) && (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(Color.parseColor(((QCircleFrameEvent)paramSimpleBaseEvent).mBackgroundColor));
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.inflate(2131560761, null));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    super.a();
    if (jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean != null) {
      jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean.reset();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.a("onAccountChanged");
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
  
  public void a(BaseActivity paramBaseActivity)
  {
    super.a(paramBaseActivity);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void e()
  {
    QLog.d("QCircleFrame", 1, "onCreate: ");
    super.e();
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379099));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369409));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(Color.parseColor("#FAFAFB"));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    if (a() != null)
    {
      bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      ImmersiveUtils.a(true, a().getWindow());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("QCircleFrame", 1, "onResume: ");
    super.e(paramBoolean);
    if (a() != null) {
      ImmersiveUtils.a(true, a().getWindow());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.a("QCircleFrame onResume");
    }
    Bitmap localBitmap = QCircleHostGlobalInfo.getFrameSnapShot();
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (localBitmap != null) && (localBitmap.getWidth() > 0)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void f()
  {
    QLog.d("QCircleFrame", 1, "onStart: ");
    super.f();
  }
  
  public void g()
  {
    QLog.d("QCircleFrame", 1, "onPause: ");
    super.g();
    if (jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean != null) {
      jdField_a_of_type_CooperationQqcircleBeansQCircleRedInfoBean.reportRedDotWhenValueChange();
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
  
  public void i()
  {
    QLog.d("QCircleFrame", 1, "onDestroy: ");
    super.i();
    FrameHelperActivity.c(true);
    QCircleHostGlobalInfo.setCurrentIsActive(false);
    HostUIHelper.closeTopShadowActivity();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
    }
    a().removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment = null;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
    }
  }
  
  public void onConfigChange()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.a("Wns onConfigChange");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    b(paramSimpleBaseEvent);
    a(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame
 * JD-Core Version:    0.7.0.1
 */