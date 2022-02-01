package com.tencent.biz.qqstory.takevideo.rmw;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import dov.com.qq.im.ae.download.AEResUtil;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    RMWLog.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.loadAVCodecSo();
    RMWLog.b("RMWService", "preload AVCodec - end -");
    RMWLog.b("RMWService", "preload PtvFilterSoLoad - start -");
    AEResUtil.e();
    RMWLog.b("RMWService", "preload PtvFilterSoLoad - end -");
    RMWLog.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((DoodleEmojiManager)SuperManager.a(8)).a(this.this$0);
    RMWLog.b("RMWService", "preInit DoodleEmojiManager - end -");
    RMWLog.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    HwEnvData.a();
    RMWLog.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    RMWLog.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    VcSystemInfo.getCpuInfo();
    RMWLog.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */