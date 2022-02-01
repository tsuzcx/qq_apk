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
    Object localObject = null;
    if (paramShort2 <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[TLVBase::CreateS2CTLV] length <= 0, type=");
        ((StringBuilder)localObject).append(paramShort1);
        ((StringBuilder)localObject).append(" length=");
        ((StringBuilder)localObject).append(paramShort2);
        QLog.d("simonchwang", 0, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (paramShort1 != 14) {
      switch (paramShort1)
      {
      default: 
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[TLVBase::CreateS2CTLV] Error ,Unknow type:");
        ((StringBuilder)localObject).append(paramShort1);
        QLog.d("simonchwang", 0, ((StringBuilder)localObject).toString());
        return null;
      case 11: 
        return new ConfigProtocol.AVSwitchTypeTLV(this);
      case 10: 
        return new ConfigProtocol.SharpInfoTLV(this, paramShort2);
      case 9: 
        return new ConfigProtocol.ConnPriorityInfoTLV(this, paramShort2);
      case 8: 
        return new ConfigProtocol.CameraAngleInfoTLV(this, paramShort2);
      case 7: 
        return new ConfigProtocol.AudioEngineNeedInfoTLV(this, paramShort2);
      case 6: 
        return new ConfigProtocol.VideoEngineNeedInfoTLV(this, paramShort2);
      case 5: 
        return new ConfigProtocol.ConnForbidTypeTLV(this);
      case 4: 
        return new ConfigProtocol.StunServerAddrTLV(this, paramShort2);
      case 3: 
        return new ConfigProtocol.RelaySvrUDPCheckTLV(this, paramShort2);
      case 2: 
        return new ConfigProtocol.LocalLogUploadTLV(this, paramShort2);
      case 1: 
        return new ConfigProtocol.WriteLocalLogTLV(this);
      }
    } else {
      localObject = new ConfigProtocol.SharpConfigPayloadTLV(this, paramShort2);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol
 * JD-Core Version:    0.7.0.1
 */