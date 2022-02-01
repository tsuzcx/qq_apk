package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.lang.ref.WeakReference;

class OrientationDetector$1
  extends OrientationEventListener
{
  OrientationDetector$1(OrientationDetector paramOrientationDetector, Context paramContext, WeakReference paramWeakReference)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, paramInt)) {
      break label11;
    }
    label11:
    label159:
    for (;;)
    {
      return;
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a() instanceof SplashActivity))
      {
        int i = OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector);
        if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330)) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt == OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector)) {
            break label159;
          }
          OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, paramInt);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break;
          }
          ((OrientationDetector.OnOrientationChangedListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt);
          return;
          if ((paramInt > 70) && (paramInt <= 110)) {
            paramInt = 8;
          } else if ((paramInt > 150) && (paramInt <= 210)) {
            paramInt = 9;
          } else if ((paramInt > 250) && (paramInt <= 290)) {
            paramInt = 0;
          } else {
            paramInt = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.1
 * JD-Core Version:    0.7.0.1
 */