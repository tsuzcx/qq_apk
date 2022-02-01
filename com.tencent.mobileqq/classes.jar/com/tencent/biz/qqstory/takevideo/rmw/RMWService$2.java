package com.tencent.biz.qqstory.takevideo.rmw;

import bdah;
import bnky;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import llq;
import wjs;
import ysa;
import yyu;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    yyu.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.loadAVCodecSoNotify("AVCodec", null, true);
    yyu.b("RMWService", "preload AVCodec - end -");
    yyu.b("RMWService", "preload PtvFilterSoLoad - start -");
    bnky.c();
    yyu.b("RMWService", "preload PtvFilterSoLoad - end -");
    yyu.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((ysa)wjs.a(8)).a(this.this$0);
    yyu.b("RMWService", "preInit DoodleEmojiManager - end -");
    yyu.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    bdah.a();
    yyu.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    yyu.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    llq.a();
    yyu.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */