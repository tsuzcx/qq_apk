package com.tencent.biz.qcircleshadow.local.fragment.qcircle;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public class QCirclePluginLoadingFragment
  extends QPublicBaseFragment
  implements SimpleEventReceiver
{
  private QCirclePluginLoadingDialog a;
  
  private void a()
  {
    this.a = new QCirclePluginLoadingDialog(getActivity());
    this.a.setOnKeyListener(new QCirclePluginLoadingFragment.1(this));
    this.a.a();
  }
  
  private void b()
  {
    ASEngineEnterEvent localASEngineEnterEvent = new ASEngineEnterEvent("flash-show-app");
    localASEngineEnterEvent.setCancel(true);
    SimpleEventBus.getInstance().dispatchEvent(localASEngineEnterEvent);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ASEngineEnterEvent.class);
    return localArrayList;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      paramBundle = ((QPublicFragmentActivity)getActivity()).mSystemBarComp;
      if (paramBundle != null)
      {
        paramBundle.init();
        paramBundle.setStatusBarColor(getResources().getColor(2131168376));
      }
    }
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (!(paramSimpleBaseEvent instanceof ASEngineEnterEvent)) {
      return;
    }
    if (!((ASEngineEnterEvent)paramSimpleBaseEvent).getBusinessKey().equals("qcircle-app")) {
      return;
    }
    ASDynamicEngineFactory.a("qcircle-app").c(true);
    paramSimpleBaseEvent = this.a;
    if (paramSimpleBaseEvent != null) {
      paramSimpleBaseEvent.dismiss();
    }
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.qcircle.QCirclePluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */