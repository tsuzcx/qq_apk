package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.qphone.base.util.QLog;

public class ARPhonePoseDetectManager
  implements SensorTrackManager.ARSensorTrackCallback
{
  public static int a;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private ARPhonePoseDetectManager.PhonePoseDetectListener jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener;
  private SensorTrackManager jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = 8;
  }
  
  public ARPhonePoseDetectManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = new SensorTrackManager();
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    long l;
    if (this.jdField_a_of_type_Long != 0L)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L) {}
    }
    label35:
    label241:
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      if (paramFloat2 > jdField_a_of_type_Int) {}
      for (int i = 1;; i = 2)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("ARPhonePoseDetectManager", 1, "ARPhonePoseDetectManager current value:=" + this.jdField_b_of_type_Int + ";nextPhonepose:=" + i);
        }
        if (this.jdField_b_of_type_Int == i) {
          break;
        }
        QLog.i("ARPhonePoseDetectManager", 1, "detectPhonePose. data = " + paramFloat1 + "," + paramFloat2 + "," + paramFloat3 + "," + paramLong + ", mPhonePose = " + this.jdField_b_of_type_Int + ", phonePose = " + i);
        if ((i == 2) && (this.jdField_b_of_type_Boolean)) {
          this.jdField_b_of_type_Boolean = false;
        }
        this.jdField_b_of_type_Int = i;
        if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener == null) {
          break;
        }
        if (this.jdField_b_of_type_Int != 1) {
          break label241;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener.a(true);
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        break label35;
      }
    } while (this.jdField_b_of_type_Int != 2);
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager$PhonePoseDetectListener.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPhonePoseDetectManager
 * JD-Core Version:    0.7.0.1
 */