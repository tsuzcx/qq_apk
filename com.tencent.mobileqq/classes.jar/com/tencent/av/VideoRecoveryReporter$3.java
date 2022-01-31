package com.tencent.av;

import awrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$3
  implements Runnable
{
  public VideoRecoveryReporter$3(int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("close_reason", String.valueOf(this.jdField_a_of_type_Int));
    awrn.a(BaseApplication.getContext()).a("", "av_recovery_close2", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.3
 * JD-Core Version:    0.7.0.1
 */