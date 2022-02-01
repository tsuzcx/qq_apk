package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.qphone.base.util.QLog;

public class ARPhonePoseDetectManager
  implements SensorTrackManager.ARSensorTrackCallback
{
  public static int a = 8;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private ARPhonePoseDetectManager.PhonePoseDetectListener jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener;
  private SensorTrackManager jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  public ARPhonePoseDetectManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = new SensorTrackManager();
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 1000L) {
        return;
      }
      this.jdField_a_of_type_Long = l;
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    int i;
    if (paramFloat2 > jdField_a_of_type_Int) {
      i = 1;
    } else {
      i = 2;
    }
    Object localObject;
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ARPhonePoseDetectManager current value:=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(";nextPhonepose:=");
      ((StringBuilder)localObject).append(i);
      QLog.d("ARPhonePoseDetectManager", 1, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Int != i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("detectPhonePose. data = ");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramFloat3);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", mPhonePose = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(", phonePose = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("ARPhonePoseDetectManager", 1, ((StringBuilder)localObject).toString());
      if ((i == 2) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_b_of_type_Int = i;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener;
      if (localObject != null)
      {
        i = this.jdField_b_of_type_Int;
        if (i == 1)
        {
          ((ARPhonePoseDetectManager.PhonePoseDetectListener)localObject).a(true);
          return;
        }
        if (i == 2) {
          ((ARPhonePoseDetectManager.PhonePoseDetectListener)localObject).a(false);
        }
      }
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.a(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.b();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    b(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(ARPhonePoseDetectManager.PhonePoseDetectListener paramPhonePoseDetectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener = paramPhonePoseDetectListener;
  }
  
  public void a(float[] paramArrayOfFloat) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.c();
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPhonePoseDetectManager
 * JD-Core Version:    0.7.0.1
 */