package com.tencent.biz.qqcircle.fragments.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBackFlowSplashPart;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.main.part.QCircleFolderFragmentsTabPart;
import com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
  implements SimpleEventReceiver
{
  private List<Part> c;
  private QCirclePublishFeedPart d;
  private QCircleFolderSplashPart e;
  private QCircleBackFlowSplashPart f;
  private QCircleFolderFragmentsPart g;
  private QCircleFolderBean h;
  private boolean i = false;
  
  public QCircleFolderActivityFragment()
  {
    QCircleHostGlobalInfo.setFolderUIType(1);
  }
  
  private void A()
  {
    if (this.i) {
      x();
    }
  }
  
  private boolean B()
  {
    boolean bool = ASInject.g().getAsEngineDelegate().isOnThirdTab("qcircle-app");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleFolder back isPluginTab:");
    localStringBuilder.append(bool);
    localStringBuilder.append("_");
    QLog.d("ASDynamicEngine_back_qcircle", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void a(ASEngineTabBackEvent paramASEngineTabBackEvent)
  {
    if (!paramASEngineTabBackEvent.getBusinessKey().equals("qcircle-app")) {
      return;
    }
    boolean bool = onBackEvent();
    ASInject.g().getOnBackEventListener().onBackEvent(bool, "flash-show-app");
  }
  
  private void a(ASEngineTabStatusEvent paramASEngineTabStatusEvent)
  {
    if (!paramASEngineTabStatusEvent.getBusinessKey().equals("qcircle-app")) {
      return;
    }
    if (paramASEngineTabStatusEvent.isSelected())
    {
      QLog.d("QCircleFolderActivityFragment", 1, "receive onTab selected event");
      onResume();
      w();
      return;
    }
    onPause();
    x();
  }
  
  private void w()
  {
    if ((ImmersiveUtils.d() == 1) && (this.D != null)) {
      this.D.setFitsSystemWindows(true);
    }
  }
  
  private void x()
  {
    if ((ImmersiveUtils.d() == 1) && (this.D != null)) {
      this.D.setFitsSystemWindows(false);
    }
  }
  
  private QCircleFolderBean y()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && ((getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean)))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      this.h = localQCircleFolderBean;
      return localQCircleFolderBean;
    }
    return null;
  }
  
  private void z()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleFolderBean.getAssignShowTabType() != -1)
      {
        QCircleFolderFragmentsPart localQCircleFolderFragmentsPart = this.g;
        if (localQCircleFolderFragmentsPart != null) {
          localQCircleFolderFragmentsPart.a(localQCircleFolderBean.getAssignShowTabType());
        }
      }
    }
  }
  
  public int a()
  {
    QCircleFolderFragmentsPart localQCircleFolderFragmentsPart = this.g;
    if (localQCircleFolderFragmentsPart != null) {
      return localQCircleFolderFragmentsPart.i();
    }
    return -1;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->doOnCreateView");
    SimpleEventBus.getInstance().registerReceiver(this);
    Object localObject = this.e;
    if (localObject != null) {
      ((QCircleFolderSplashPart)localObject).b(this.D);
    }
    localObject = this.f;
    if (localObject != null) {
      ((QCircleBackFlowSplashPart)localObject).b(this.D);
    }
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return "QCircleFolderActivityFragment";
  }
  
  protected int c()
  {
    return 2131626826;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      Object localObject = new QCircleFolderActivityChipPart();
      ((QCircleFolderActivityChipPart)localObject).a(this);
      this.c.add(localObject);
      this.c.add(new QCirclePublishStatusBoxPart(QCirclePluginGlobalInfo.c()));
      this.d = new QCirclePublishFeedPart(QCirclePluginGlobalInfo.c());
      this.d.a(this);
      this.c.add(this.d);
      localObject = new QCircleLightInteractListPart();
      ((QCircleLightInteractListPart)localObject).a(this);
      this.c.add(localObject);
      localObject = new QCircleCommentPanelPart();
      ((QCircleCommentPanelPart)localObject).a(this);
      this.c.add(localObject);
      if ((y() != null) && (QCircleHostGlobalInfo.isCurrentTabActive())) {
        this.g = new QCircleFolderFragmentsTabPart();
      } else {
        this.g = new QCircleFolderFragmentsPart();
      }
      this.c.add(this.g);
      localObject = this.c;
      QCircleFolderSplashPart localQCircleFolderSplashPart = new QCircleFolderSplashPart();
      this.e = localQCircleFolderSplashPart;
      ((List)localObject).add(localQCircleFolderSplashPart);
      this.f = new QCircleBackFlowSplashPart();
      this.c.add(this.f);
      localObject = new QCircleTaskCenterPart();
      ((QCircleTaskCenterPart)localObject).a(this);
      this.c.add(localObject);
      this.c.add(new QCirclePushToastPart());
      this.c.add(new QCircleSharePartV2());
      this.c.add(new QCircleMainTabTipPart());
    }
    z();
    return this.c;
  }
  
  protected String f()
  {
    if (a() == 1) {
      return "pg_xsj_following_page";
    }
    if (a() == 3) {
      return "pg_xsj_explore_page";
    }
    if (a() == 91) {
      return "pg_xsj_nearby_page";
    }
    return null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(super.getEventClass());
    localArrayList.add(ASEngineTabBackEvent.class);
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  protected void l() {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    if (B())
    {
      boolean bool = super.onBackEvent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FsFolder back onBackEvent:");
      localStringBuilder.append(bool);
      QLog.d("ASDynamicEngine_back_qcircle", 1, localStringBuilder.toString());
      ASInject.g().getOnBackEventListener().onBackEvent(bool, "qcircle-app");
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = QCircleHostGlobalInfo.isCurrentTabActive();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.g != null)
    {
      paramIntent = (QCircleFolderBean)paramIntent.getSerializableExtra("key_bundle_common_init_bean");
      if (paramIntent != null) {
        this.g.a(paramIntent.getAssignShowTabType(), false, false);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    A();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof ASEngineTabBackEvent))
    {
      a((ASEngineTabBackEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof ASEngineTabStatusEvent)) {
      a((ASEngineTabStatusEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if (QCirclePluginUtil.e()) {
      w();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    A();
  }
  
  public void u()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onWriteClick?");
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QCircleFolderActivityFragment", 4, ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null) {
      ((QCirclePublishFeedPart)localObject).i();
    }
  }
  
  protected boolean v()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderActivityFragment
 * JD-Core Version:    0.7.0.1
 */