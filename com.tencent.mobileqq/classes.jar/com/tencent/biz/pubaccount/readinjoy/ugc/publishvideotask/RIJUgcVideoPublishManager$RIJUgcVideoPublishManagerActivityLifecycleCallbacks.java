package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class RIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  RIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (this.b == 1)
    {
      this.b -= 1;
      return;
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.b += 1;
    if (this.jdField_a_of_type_Boolean) {
      RIJUgcVideoPublishManager.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.jdField_a_of_type_Int -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */