package com.tencent.aelight.camera.ae.biz.circle.part.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class AECircleBasePart
  implements Application.ActivityLifecycleCallbacks, SimpleEventReceiver
{
  private AECirclePartManager a;
  private View b;
  protected AECirclePhotoListLogic c;
  protected PhotoListBaseData d;
  protected final Handler e = new Handler(Looper.getMainLooper());
  private Activity f;
  private AECircleBasePartFragment g;
  
  public AECircleBasePart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.c = paramAECirclePhotoListLogic;
    this.d = this.c.d;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    paramView = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onInitView");
    QLog.d(paramView, 1, localStringBuilder.toString());
  }
  
  public void a(AECircleBasePartFragment paramAECircleBasePartFragment, View paramView, AECirclePartManager paramAECirclePartManager)
  {
    this.f = paramAECircleBasePartFragment.getActivity();
    this.g = paramAECircleBasePartFragment;
    this.a = paramAECirclePartManager;
    this.b = paramView;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean am_()
  {
    return false;
  }
  
  public abstract String b();
  
  public AECircleBasePartFragment f()
  {
    return this.g;
  }
  
  public Activity g()
  {
    return this.f;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public Context h()
  {
    Activity localActivity = this.f;
    if (localActivity != null) {
      return localActivity;
    }
    return null;
  }
  
  public Handler i()
  {
    return this.e;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.e;
    if (paramActivity != null) {
      paramActivity.removeCallbacksAndMessages(null);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart
 * JD-Core Version:    0.7.0.1
 */