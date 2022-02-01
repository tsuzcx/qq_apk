package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart;
import com.tencent.biz.qqcircle.immersive.part.folder.QFSFolderFragmentPart;
import com.tencent.biz.qqcircle.immersive.part.qqtab.QFSTabFolderFragmentPart;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QFSFolderFragment
  extends QFSBaseFragment
{
  private List<Part> c;
  private QCircleFolderSplashPart d;
  
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
      QLog.d("QFSFolderFragment", 1, "receive onTab selected event");
      onResume();
      x();
      y();
      return;
    }
    onStop();
  }
  
  private boolean u()
  {
    Object localObject = getActivity();
    int j = 0;
    if ((localObject != null) && (getActivity().getIntent() != null))
    {
      if (!(getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean)) {
        return false;
      }
      localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localObject != null) {
        localObject = ((QCircleFolderBean)localObject).getSchemeAttrs();
      } else {
        localObject = null;
      }
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (String.valueOf(11).equals(((HashMap)localObject).get("key_jump_from"))) {
          i = 1;
        }
      }
      return i ^ 0x1;
    }
    return false;
  }
  
  private boolean w()
  {
    if (u()) {
      return false;
    }
    boolean bool = ASInject.g().getAsEngineDelegate().isOnThirdTab("qcircle-app");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleFolder back isPluginTab:");
    localStringBuilder.append(bool);
    localStringBuilder.append("_");
    QLog.d("ASDynamicEngine_back_qcircle", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void x()
  {
    RFThreadManager.execute(new QFSFolderFragment.1(this));
  }
  
  private void y()
  {
    RFThreadManager.execute(new QFSFolderFragment.2(this));
  }
  
  public int a()
  {
    return -1;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return "QFSFolderFragment";
  }
  
  protected int c()
  {
    return 2131627125;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      if ((!u()) && (QCircleHostGlobalInfo.isCurrentTabActive())) {
        this.c.add(new QFSTabFolderFragmentPart(p()));
      } else {
        this.c.add(new QFSFolderFragmentPart(p()));
      }
      this.d = new QCircleFolderSplashPart();
      this.c.add(this.d);
      this.c.add(new QFSMainTabTipPart());
    }
    return this.c;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList2 = super.getEventClass();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(ASEngineTabBackEvent.class);
    localArrayList1.add(ASEngineTabStatusEvent.class);
    return localArrayList1;
  }
  
  protected void l() {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    y();
    x();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).lock();
  }
  
  public boolean onBackEvent()
  {
    if (w())
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
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).unlock();
  }
  
  public void onPause()
  {
    QLog.d("QFSFolderFragment", 1, "fs_lifecycle onPause");
    super.onPause();
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
    QLog.d("QFSFolderFragment", 1, "fs_lifecycle onResume");
    super.onResume();
    if (getActivity() != null) {
      QCirclePluginInitHelper.PreloadWink(getActivity());
    }
  }
  
  public void onStop()
  {
    QLog.d("QFSFolderFragment", 1, "fs_lifecycle onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFolderFragment
 * JD-Core Version:    0.7.0.1
 */