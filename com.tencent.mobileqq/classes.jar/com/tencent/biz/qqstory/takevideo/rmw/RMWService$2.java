package com.tencent.biz.qqstory.takevideo.rmw;

import axha;
import axle;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import llw;
import tcz;
import vls;
import vsu;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    vsu.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    vsu.b("RMWService", "preload AVCodec - end -");
    vsu.b("RMWService", "preload PtvFilterSoLoad - start -");
    axle.a();
    vsu.b("RMWService", "preload PtvFilterSoLoad - end -");
    vsu.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((vls)tcz.a(8)).a(this.this$0);
    vsu.b("RMWService", "preInit DoodleEmojiManager - end -");
    vsu.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    axha.a();
    vsu.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    vsu.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    llw.a();
    vsu.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */