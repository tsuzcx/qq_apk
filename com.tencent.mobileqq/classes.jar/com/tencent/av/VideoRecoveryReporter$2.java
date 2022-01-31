package com.tencent.av;

import axrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$2
  implements Runnable
{
  public VideoRecoveryReporter$2(boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    axrn.a(BaseApplication.getContext()).a("", "av_recovery_result2", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.2
 * JD-Core Version:    0.7.0.1
 */