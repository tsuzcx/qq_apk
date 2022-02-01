package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;

class a$5
  implements Runnable
{
  a$5(a parama, TXSVideoEncoderParam paramTXSVideoEncoderParam) {}
  
  public void run()
  {
    int i = this.a.encoderMode;
    Object localObject = "unknown";
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          str1 = "unknown";
        } else {
          str1 = "CQ";
        }
      }
      else {
        str1 = "VBR";
      }
    }
    else {
      str1 = "CBR";
    }
    i = this.a.encoderProfile;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          localObject = "High";
        }
      }
      else {
        localObject = "Main";
      }
    }
    else {
      localObject = "Baseline";
    }
    i = this.b.hashCode();
    int j = this.a.width;
    int k = this.a.height;
    int m = this.a.fps;
    int n = this.a.bitrate;
    int i1 = this.a.gop;
    boolean bool = this.a.bMultiRef;
    String str3 = "true";
    String str2;
    if (bool) {
      str2 = "true";
    } else {
      str2 = "false";
    }
    int i2 = this.a.streamType;
    if (!this.a.isH265EncoderEnabled) {
      str3 = "false";
    }
    String str1 = String.format("VideoEncoder[%d]: Start [type:hardware][resolution:%d*%d][fps:%d][bitrate:%dkbps][gop:%d][rateControl:%s][profile:%s][rps:%s][streamType:%d][enable hevc:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, localObject, str2, Integer.valueOf(i2), str3 });
    Monitor.a(2, str1, "", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start:");
    ((StringBuilder)localObject).append(str1);
    TXCLog.i("TXCHWVideoEncoder", ((StringBuilder)localObject).toString());
    if (this.b.mInit) {
      a.a(this.b);
    }
    if (a.a(this.b, this.a))
    {
      Monitor.a(2, String.format("VideoEncoder[%d]: Start successfully, streamType:%d", new Object[] { Integer.valueOf(this.b.hashCode()), Integer.valueOf(this.a.streamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
      return;
    }
    this.b.callDelegate(10000004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.5
 * JD-Core Version:    0.7.0.1
 */