package com.tencent.av;

import awrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoSocketReconnectReporter$1
  implements Runnable
{
  public VideoSocketReconnectReporter$1(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("policy_type", String.valueOf(this.a));
    localHashMap.put("net_type", String.valueOf(this.b));
    awrn.a(BaseApplication.getContext()).a("", "av_socket_recon_request2", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter.1
 * JD-Core Version:    0.7.0.1
 */