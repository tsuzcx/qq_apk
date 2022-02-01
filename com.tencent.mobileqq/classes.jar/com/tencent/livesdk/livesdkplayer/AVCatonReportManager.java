package com.tencent.livesdk.livesdkplayer;

public class AVCatonReportManager
{
  private static AVCatonReportManager jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReportManager = null;
  private AVCatonReport4Player jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReport4Player = new AVCatonReport4Player();
  
  public static AVCatonReportManager a()
  {
    if (jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReportManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReportManager == null) {
        jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReportManager = new AVCatonReportManager();
      }
      return jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReportManager;
    }
    finally {}
  }
  
  public AVCatonReport4Player a()
  {
    return this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReport4Player;
  }
  
  public void a(AVCatonReport4Player paramAVCatonReport4Player)
  {
    if (paramAVCatonReport4Player != null) {
      this.jdField_a_of_type_ComTencentLivesdkLivesdkplayerAVCatonReport4Player = paramAVCatonReport4Player;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.AVCatonReportManager
 * JD-Core Version:    0.7.0.1
 */