package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;

class OnLinePushMessageProcessor$HandleShMsgType0x08
{
  private MsgInfo b;
  private String c;
  private int d;
  private int e;
  private long f;
  
  public OnLinePushMessageProcessor$HandleShMsgType0x08(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, String paramString)
  {
    this.b = paramMsgInfo;
    this.c = paramString;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.f;
  }
  
  public HandleShMsgType0x08 e()
  {
    byte[] arrayOfByte = new byte[4];
    if (this.b.vMsg.length > 4) {
      PkgTools.copyData(arrayOfByte, 0, this.b.vMsg, 0, 4);
    }
    this.f = PkgTools.getLongData(arrayOfByte, 0);
    if (this.b.vMsg.length >= 9)
    {
      arrayOfByte = new byte[this.b.vMsg.length - 9];
      PkgTools.copyData(arrayOfByte, 0, this.b.vMsg, 8, arrayOfByte.length);
      this.c = new String(EmotionCodecUtils.a(arrayOfByte), "utf-8");
    }
    this.d = 1000;
    this.e = -1000;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgType0x08
 * JD-Core Version:    0.7.0.1
 */