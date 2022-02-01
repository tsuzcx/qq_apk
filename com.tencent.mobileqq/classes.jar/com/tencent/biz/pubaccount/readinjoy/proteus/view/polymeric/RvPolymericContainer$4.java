package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RvPolymericContainer$4
  implements Application.ActivityLifecycleCallbacks
{
  RvPolymericContainer$4(RvPolymericContainer paramRvPolymericContainer, Activity paramActivity) {}
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != this.jdField_a_of_type_AndroidAppActivity) {}
    do
    {
      return;
      QLog.d("RvPolymericContainer", 1, "visibility changed, visible :  " + paramBoolean);
      if (paramBoolean)
      {
        RvPolymericContainer.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericRvPolymericContainer);
        return;
      }
    } while (RvPolymericContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericRvPolymericContainer) == null);
    RvPolymericContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericRvPolymericContainer).b();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((paramActivity == this.jdField_a_of_type_AndroidAppActivity) && (BaseApplication.getContext() != null)) {
      BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.4
 * JD-Core Version:    0.7.0.1
 */