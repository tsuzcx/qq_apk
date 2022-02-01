package com.tencent.livesdk.livesdkplayer;

public class AVCatonReportManager
{
  private static AVCatonReportManager a;
  private AVCatonReport4Player b = new AVCatonReport4Player();
  
  public static AVCatonReportManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVCatonReportManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(AVCatonReport4Player paramAVCatonReport4Player)
  {
    if (paramAVCatonReport4Player != null) {
      this.b = paramAVCatonReport4Player;
    }
  }
  
  public AVCatonReport4Player b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.AVCatonReportManager
 * JD-Core Version:    0.7.0.1
 */