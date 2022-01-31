package com.tencent.biz.qqstory.takevideo.rmw;

import axgy;
import axlc;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import lmb;
import tdc;
import vlv;
import vsx;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    vsx.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    vsx.b("RMWService", "preload AVCodec - end -");
    vsx.b("RMWService", "preload PtvFilterSoLoad - start -");
    axlc.a();
    vsx.b("RMWService", "preload PtvFilterSoLoad - end -");
    vsx.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((vlv)tdc.a(8)).a(this.this$0);
    vsx.b("RMWService", "preInit DoodleEmojiManager - end -");
    vsx.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    axgy.a();
    vsx.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    vsx.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lmb.a();
    vsx.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */