package com.tencent.mobileqq.auto.engine.main.impl.fs;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.main.IASBaseFrame;
import com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragmentManger;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.events.FSFrameEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class FSAutoPluginMainFrame
  extends IASBaseFrame
{
  public Fragment a(View paramView)
  {
    return ASPluginFragmentManger.a("flash-show-app").g();
  }
  
  public void a()
  {
    QLog.i("FSAutoPluginMainFrame", 1, "fs_lifecycle onBottomPageSelected-> to onResume");
    ASPluginFragmentManger.a("flash-show-app").a();
    ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).onBottomRedPointClick();
    SimpleEventBus.getInstance().dispatchEvent(new FSFrameEvent(ASPluginFragmentManger.a("flash-show-app").g().hashCode(), 4));
  }
  
  public void a(boolean paramBoolean)
  {
    ASPluginFragmentManger.a("flash-show-app").a(paramBoolean);
  }
  
  public void b()
  {
    QLog.i("FSAutoPluginMainFrame", 1, "fs_lifecycle onBottomPageUnSelected-> to pause");
    ASPluginFragmentManger.a("flash-show-app").b();
  }
  
  public void c()
  {
    QLog.i("FSAutoPluginMainFrame", 1, "fs_lifecycle onBottomPageUnSelected-> to destroy");
    ASPluginFragmentManger.a("flash-show-app").c();
  }
  
  public boolean d()
  {
    boolean bool = ASPluginFragmentManger.a("flash-show-app").d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed pluginMainFrame:");
    localStringBuilder.append(bool);
    QLog.d("ASDynamicEngine_back", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void e()
  {
    SimpleEventBus.getInstance().dispatchEvent(new FSFrameEvent(ASPluginFragmentManger.a("flash-show-app").g().hashCode(), 0));
  }
  
  public void f()
  {
    ASPluginFragmentManger.a("flash-show-app").f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.impl.fs.FSAutoPluginMainFrame
 * JD-Core Version:    0.7.0.1
 */