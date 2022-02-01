package com.tencent.ilivesdk.thumbplayerservice;

import com.tencent.av.report.impl.AVCatonReport;
import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;

public class AVCatonReport4PlayerTransfer
  extends AVCatonReport4Player
{
  private AVCatonReport a;
  
  public AVCatonReport4PlayerTransfer(AVCatonReport paramAVCatonReport)
  {
    if (paramAVCatonReport != null) {
      this.a = paramAVCatonReport;
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.send();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.a != null) {
      this.a.addTimeValue(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.a != null) {
      this.a.addGapValue(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.a != null) {
      this.a.addPlayerParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.thumbplayerservice.AVCatonReport4PlayerTransfer
 * JD-Core Version:    0.7.0.1
 */