package com.tencent.av;

import com.tencent.av.business.config.MediaCodecChipConfigManager;

class VideoServlet$1
  implements Runnable
{
  VideoServlet$1(VideoServlet paramVideoServlet, HardWareCodecSSO.ConfigRsp paramConfigRsp) {}
  
  public void run()
  {
    MediaCodecChipConfigManager.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoServlet.1
 * JD-Core Version:    0.7.0.1
 */