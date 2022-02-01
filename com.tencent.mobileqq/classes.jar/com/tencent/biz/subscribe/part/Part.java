package com.tencent.biz.subscribe.part;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class Part
  implements Application.ActivityLifecycleCallbacks
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private BasePartFragment jdField_a_of_type_ComTencentBizSubscribePartBasePartFragment;
  private PartManager jdField_a_of_type_ComTencentBizSubscribePartPartManager;
  public QQAppInterface a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public BasePartFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBasePartFragment;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    QLog.d(a(), 1, a() + "->onInitView");
  }
  
  public void a(BasePartFragment paramBasePartFragment, View paramView, PartManager paramPartManager)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramBasePartFragment.getActivity();
    this.jdField_a_of_type_ComTencentBizSubscribePartBasePartFragment = paramBasePartFragment;
    this.jdField_a_of_type_ComTencentBizSubscribePartPartManager = paramPartManager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBasePartFragment.getActivity().app;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.Part
 * JD-Core Version:    0.7.0.1
 */