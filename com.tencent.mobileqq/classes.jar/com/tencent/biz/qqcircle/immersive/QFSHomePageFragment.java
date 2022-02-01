package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.part.QFSPublishFeedPart;
import com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QFSHomePageFragment
  extends QFSBaseFragment
{
  private List<Part> c;
  private QFSHomePageFragmentPart d;
  private QFSPublishFeedPart e;
  
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
      QLog.d("QFSHomePageFragment", 1, "receive onTab selected event");
      onResume();
      return;
    }
    onStop();
  }
  
  private void u()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleFolderBean == null) {
        return;
      }
      boolean bool = localQCircleFolderBean.isPublish();
      QFSPublishFeedPart localQFSPublishFeedPart = this.e;
      if ((localQFSPublishFeedPart != null) && (bool))
      {
        localQFSPublishFeedPart.d();
        localQCircleFolderBean.setPublish(false);
      }
    }
  }
  
  private boolean w()
  {
    boolean bool = ASInject.g().getAsEngineDelegate().isOnThirdTab("flash-show-app");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleFolder back isPluginTab:");
    localStringBuilder.append(false);
    localStringBuilder.append("_");
    localStringBuilder.append(bool);
    localStringBuilder.append("_");
    QLog.d("ASDynamicEngine_back_qcircle", 1, localStringBuilder.toString());
    return false;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return "QFSHomePageFragment";
  }
  
  protected int c()
  {
    return 2131627131;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.d = new QFSHomePageFragmentPart(p());
      this.c.add(this.d);
      this.e = new QFSPublishFeedPart(QCirclePluginGlobalInfo.c());
      this.e.a(17);
      this.e.a(this);
      this.c.add(this.e);
    }
    return this.c;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(ASEngineTabBackEvent.class);
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
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
  
  public void onPause()
  {
    QLog.d("QFSHomePageFragment", 1, "fs_lifecycle onPause");
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
    QLog.d("QFSHomePageFragment", 1, "fs_lifecycle onResume");
    super.onResume();
    u();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSHomePageFragment
 * JD-Core Version:    0.7.0.1
 */