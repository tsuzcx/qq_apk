package com.tencent.av;

import axrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoSocketReconnectReporter$2
  implements Runnable
{
  public VideoSocketReconnectReporter$2(int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("policy_type", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("net_type", String.valueOf(this.b));
    localHashMap.put("time_cost", String.valueOf(this.jdField_a_of_type_Long));
    axrn.a(BaseApplication.getContext()).a("", "av_socket_recon_result2", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter.2
 * JD-Core Version:    0.7.0.1
 */