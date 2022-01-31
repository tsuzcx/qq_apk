package com.tencent.biz.qqstory.takevideo.rmw;

import azgp;
import azkt;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import lnz;
import uwa;
import xet;
import xlv;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    xlv.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    xlv.b("RMWService", "preload AVCodec - end -");
    xlv.b("RMWService", "preload PtvFilterSoLoad - start -");
    azkt.a();
    xlv.b("RMWService", "preload PtvFilterSoLoad - end -");
    xlv.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((xet)uwa.a(8)).a(this.this$0);
    xlv.b("RMWService", "preInit DoodleEmojiManager - end -");
    xlv.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    azgp.a();
    xlv.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    xlv.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lnz.a();
    xlv.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */