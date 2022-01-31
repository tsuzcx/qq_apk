package com.tencent.biz.qqstory.takevideo.rmw;

import azcg;
import azgk;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import lnz;
import urr;
import xak;
import xhm;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    xhm.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    xhm.b("RMWService", "preload AVCodec - end -");
    xhm.b("RMWService", "preload PtvFilterSoLoad - start -");
    azgk.a();
    xhm.b("RMWService", "preload PtvFilterSoLoad - end -");
    xhm.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((xak)urr.a(8)).a(this.this$0);
    xhm.b("RMWService", "preInit DoodleEmojiManager - end -");
    xhm.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    azcg.a();
    xhm.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    xhm.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lnz.a();
    xhm.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */