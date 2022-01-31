package com.tencent.mobileqq.apollo.aioChannel;

import aijf;
import aioa;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class ApolloCmdChannel$PlayMusicTask
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference<aijf> jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private WeakReference<aioa> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int;
  private WeakReference<ApolloCmdChannel> jdField_c_of_type_JavaLangRefWeakReference;
  private int d;
  
  ApolloCmdChannel$PlayMusicTask(int paramInt1, ApolloCmdChannel paramApolloCmdChannel, aijf paramaijf, aioa paramaioa, long paramLong, int paramInt2, int paramInt3, String paramString, float paramFloat, int paramInt4)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannel);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaijf);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramaioa);
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
    aijf localaijf = (aijf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    aioa localaioa = (aioa)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localApolloCmdChannel == null) || (localaioa == null) || (localaijf == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localaioa.a(localaijf, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.PlayMusicTask
 * JD-Core Version:    0.7.0.1
 */