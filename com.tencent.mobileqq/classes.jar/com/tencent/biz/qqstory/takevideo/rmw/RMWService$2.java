package com.tencent.biz.qqstory.takevideo.rmw;

import bchp;
import bnpy;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import lkw;
import wpm;
import yye;
import zfg;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    zfg.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    zfg.b("RMWService", "preload AVCodec - end -");
    zfg.b("RMWService", "preload PtvFilterSoLoad - start -");
    bnpy.c();
    zfg.b("RMWService", "preload PtvFilterSoLoad - end -");
    zfg.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((yye)wpm.a(8)).a(this.this$0);
    zfg.b("RMWService", "preInit DoodleEmojiManager - end -");
    zfg.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    bchp.a();
    zfg.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    zfg.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lkw.a();
    zfg.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */