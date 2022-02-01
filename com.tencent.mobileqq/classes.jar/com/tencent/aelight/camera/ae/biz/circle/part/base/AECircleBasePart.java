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
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  protected AECirclePhotoListLogic a;
  private AECircleBasePartFragment jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECircleBasePartFragment;
  private AECirclePartManager jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
  protected PhotoListBaseData a;
  
  public AECircleBasePart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null) {
      return localActivity;
    }
    return null;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public AECircleBasePartFragment a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECircleBasePartFragment;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    paramView = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("->onInitView");
    QLog.d(paramView, 1, localStringBuilder.toString());
  }
  
  public void a(AECircleBasePartFragment paramAECircleBasePartFragment, View paramView, AECirclePartManager paramAECirclePartManager)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramAECircleBasePartFragment.getActivity();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECircleBasePartFragment = paramAECircleBasePartFragment;
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager = paramAECirclePartManager;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.jdField_a_of_type_AndroidOsHandler;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart
 * JD-Core Version:    0.7.0.1
 */