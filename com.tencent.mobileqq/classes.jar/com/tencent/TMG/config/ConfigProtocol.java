package com.tencent.TMG.config;

import com.tencent.TMG.utils.QLog;

public class ConfigProtocol
{
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_ANDROID_ROM_INFO = 8;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_AVENGINE_INFO = 7;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_AVENGINE_VERSION = 4;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_CLIENT_APPID = 3;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_CLIENT_DEVNAME = 5;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_CLIENT_OS = 2;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_CLIENT_TYPE = 1;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_HARDWARE_INFO = 6;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_SHARP_CONFIG_VERSION = 10;
  public static final short AV_ENGINE_C2S_CONFIG_TLV_TYPE_SHARP_REPORT_INFO = 9;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_AUDIOENGINE_NEED_INFO = 7;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_AUDIO_SWITCH = 11;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_CAMERAANGLE_INFO = 8;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_CONN_PRIORITY_INFO = 9;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_CONN_TYPE = 5;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_LOG_UPLOAD = 2;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_LOG_WRITE = 1;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_SHARP_CONFIG_PAYLOAD = 14;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_SHARP_INFO = 10;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_STUN_SERVER_ADDR = 4;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_UDP_CHECK = 3;
  public static final short AV_ENGINE_S2C_CONFIG_TLV_TYPE_VIDEOENGINE_NEED_INFO = 6;
  public static final byte C2S_CONFIG_REQ_TAG = 1;
  public static final short S2C_CONFIG_INFO_MD5_SIZE = 33;
  public static final short TLV_IP_ADDRESS_LENGTH = 6;
  
  public ConfigProtocol.TLVBase CreateS2CTLV(short paramShort1, short paramShort2)
  {
    if (paramShort2 <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("simonchwang", 0, "[TLVBase::CreateS2CTLV] length <= 0, type=" + paramShort1 + " length=" + paramShort2);
      }
    }
    do
    {
      return null;
      switch (paramShort1)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("simonchwang", 0, "[TLVBase::CreateS2CTLV] Error ,Unknow type:" + paramShort1);
    return null;
    return new ConfigProtocol.WriteLocalLogTLV(this);
    return new ConfigProtocol.LocalLogUploadTLV(this, paramShort2);
    return new ConfigProtocol.RelaySvrUDPCheckTLV(this, paramShort2);
    return new ConfigProtocol.StunServerAddrTLV(this, paramShort2);
    return new ConfigProtocol.ConnForbidTypeTLV(this);
    return new ConfigProtocol.VideoEngineNeedInfoTLV(this, paramShort2);
    return new ConfigProtocol.AudioEngineNeedInfoTLV(this, paramShort2);
    return new ConfigProtocol.CameraAngleInfoTLV(this, paramShort2);
    return new ConfigProtocol.ConnPriorityInfoTLV(this, paramShort2);
    return new ConfigProtocol.SharpInfoTLV(this, paramShort2);
    return new ConfigProtocol.AVSwitchTypeTLV(this);
    return new ConfigProtocol.SharpConfigPayloadTLV(this, paramShort2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol
 * JD-Core Version:    0.7.0.1
 */