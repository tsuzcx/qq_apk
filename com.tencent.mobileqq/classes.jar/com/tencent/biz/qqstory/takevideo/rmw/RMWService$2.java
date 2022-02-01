package com.tencent.biz.qqstory.takevideo.rmw;

import bbtm;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.AEResUtil;
import lld;
import vux;
import ydh;
import ykb;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    ykb.b("RMWService", "preload AVCodec - start -");
    VideoEnvironment.loadAVCodecSoNotify("AVCodec", null, true);
    ykb.b("RMWService", "preload AVCodec - end -");
    ykb.b("RMWService", "preload PtvFilterSoLoad - start -");
    AEResUtil.loadAEBaseSo();
    ykb.b("RMWService", "preload PtvFilterSoLoad - end -");
    ykb.b("RMWService", "preInit DoodleEmojiManager - start -");
    ((ydh)vux.a(8)).a(this.this$0);
    ykb.b("RMWService", "preInit DoodleEmojiManager - end -");
    ykb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    bbtm.a();
    ykb.b("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    ykb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    lld.a();
    ykb.b("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */