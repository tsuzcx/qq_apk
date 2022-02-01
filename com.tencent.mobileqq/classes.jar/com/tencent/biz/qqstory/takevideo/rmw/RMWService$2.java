package com.tencent.biz.qqstory.takevideo.rmw;

import bdah;
import bork;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import llk;
import wth;
import zbz;
import zjb;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    zjb.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    zjb.b("RMWService", "preload AVCodec - end -");
    zjb.b("RMWService", "preload PtvFilterSoLoad - start -");
    bork.c();
    zjb.b("RMWService", "preload PtvFilterSoLoad - end -");
    zjb.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((zbz)wth.a(8)).a(this.this$0);
    zjb.b("RMWService", "preInit DoodleEmojiManager - end -");
    zjb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    bdah.a();
    zjb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    zjb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    llk.a();
    zjb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */