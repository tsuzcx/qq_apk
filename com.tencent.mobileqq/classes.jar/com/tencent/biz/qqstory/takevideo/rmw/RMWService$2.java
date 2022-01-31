package com.tencent.biz.qqstory.takevideo.rmw;

import awhs;
import awlw;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import lbk;
import sqg;
import uyz;
import vgb;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    vgb.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    vgb.b("RMWService", "preload AVCodec - end -");
    vgb.b("RMWService", "preload PtvFilterSoLoad - start -");
    awlw.a();
    vgb.b("RMWService", "preload PtvFilterSoLoad - end -");
    vgb.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((uyz)sqg.a(8)).a(this.this$0);
    vgb.b("RMWService", "preInit DoodleEmojiManager - end -");
    vgb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    awhs.a();
    vgb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    vgb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lbk.a();
    vgb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */