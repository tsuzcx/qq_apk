package com.tencent.av;

import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$1
  implements Runnable
{
  public VideoRecoveryReporter$1(int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", String.valueOf(this.jdField_a_of_type_Int));
    azmz.a(BaseApplication.getContext()).a("", "av_recovery_request2", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.1
 * JD-Core Version:    0.7.0.1
 */