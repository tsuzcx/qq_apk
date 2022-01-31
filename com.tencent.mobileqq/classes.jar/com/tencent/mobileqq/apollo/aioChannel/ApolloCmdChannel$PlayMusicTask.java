package com.tencent.mobileqq.apollo.aioChannel;

import aivy;
import ajay;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class ApolloCmdChannel$PlayMusicTask
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference<aivy> jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private WeakReference<ajay> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int;
  private WeakReference<ApolloCmdChannel> jdField_c_of_type_JavaLangRefWeakReference;
  private int d;
  
  ApolloCmdChannel$PlayMusicTask(int paramInt1, ApolloCmdChannel paramApolloCmdChannel, aivy paramaivy, ajay paramajay, long paramLong, int paramInt2, int paramInt3, String paramString, float paramFloat, int paramInt4)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannel);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaivy);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramajay);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramInt1;
    this.jdField_c_of_type_Int = paramInt4;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void run()
  {
    ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    aivy localaivy = (aivy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ajay localajay = (ajay)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localApolloCmdChannel == null) || (localajay == null) || (localaivy == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localajay.a(localaivy, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.PlayMusicTask
 * JD-Core Version:    0.7.0.1
 */