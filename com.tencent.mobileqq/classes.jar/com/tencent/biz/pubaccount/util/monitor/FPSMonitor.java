package com.tencent.biz.pubaccount.util.monitor;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import com.tencent.mobileqq.kandian.base.bandwidth.api.IBandwidthPredictor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class FPSMonitor
  implements DropFrameCollector.DropFrameCallback
{
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private DropFrameCollector jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector;
  private FPSSuspendedBall jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall;
  private SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  private Context a()
  {
    SoftReference localSoftReference = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localSoftReference != null) {
      return (Context)localSoftReference.get();
    }
    return null;
  }
  
  public static final FPSMonitor a()
  {
    return FPSMonitor.FPSMonitorHolder.a();
  }
  
  private void b(Context paramContext)
  {
    if (a() != paramContext) {
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall;
    if ((paramContext != null) && (paramContext.getParent() != null)) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector = null;
    this.jdField_a_of_type_AndroidViewWindowManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall = null;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    FPSSuspendedBall localFPSSuspendedBall = this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall;
    if (localFPSSuspendedBall != null) {
      localFPSSuspendedBall.a(paramFloat1, paramFloat2, paramFloat3, ((IBandwidthPredictor)QRoute.api(IBandwidthPredictor.class)).getLastBandwidth(), ((IBandwidthPredictor)QRoute.api(IBandwidthPredictor.class)).getCurrentPrediction());
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FPSMonitor", 2, "start fail, switch was closed");
      }
      return;
    }
    Context localContext = a();
    if ((paramActivity == localContext) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall != null)) {
      return;
    }
    b(localContext);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramActivity.getSystemService("window"));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall = new FPSSuspendedBall(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector = new DropFrameCollector(this, this.jdField_a_of_type_AndroidViewWindowManager);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall.a(paramActivity, this.jdField_a_of_type_AndroidViewWindowManager);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector.a();
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    b(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSMonitor
 * JD-Core Version:    0.7.0.1
 */