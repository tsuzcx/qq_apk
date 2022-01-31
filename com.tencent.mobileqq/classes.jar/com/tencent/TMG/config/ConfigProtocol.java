package com.tencent.TMG.config;

import com.tencent.TMG.utils.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

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
  
  public TLVBase CreateS2CTLV(short paramShort1, short paramShort2)
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
    return new WriteLocalLogTLV();
    return new LocalLogUploadTLV(paramShort2);
    return new RelaySvrUDPCheckTLV(paramShort2);
    return new StunServerAddrTLV(paramShort2);
    return new ConnForbidTypeTLV();
    return new VideoEngineNeedInfoTLV(paramShort2);
    return new AudioEngineNeedInfoTLV(paramShort2);
    return new CameraAngleInfoTLV(paramShort2);
    return new ConnPriorityInfoTLV(paramShort2);
    return new SharpInfoTLV(paramShort2);
    return new AVSwitchTypeTLV();
    return new SharpConfigPayloadTLV(paramShort2);
  }
  
  public class AVSwitchTypeTLV
    extends ConfigProtocol.TLVBase
  {
    private byte m_bIsAuidoEnable = 1;
    private byte m_bIsOpenMaxEnable = 0;
    
    public AVSwitchTypeTLV()
    {
      super((short)11, (short)1);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramByteBuffer != null)
      {
        bool1 = bool2;
        if (paramByteBuffer.length() > 0)
        {
          int i = paramByteBuffer.ReadUInt8();
          bool1 = bool2;
          if (i >= 0)
          {
            this.m_bIsAuidoEnable = ((byte)(i & 0x1));
            this.m_bIsOpenMaxEnable = ((byte)(i >> 1 & 0x1));
            if (QLog.isColorLevel()) {
              QLog.d("simonchwang", 0, "m_bIsAuidoEnable:" + this.m_bIsAuidoEnable + "m_bIsOpenMaxEnable:" + this.m_bIsOpenMaxEnable);
            }
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public byte getM_bIsAuidoEnable()
    {
      return this.m_bIsAuidoEnable;
    }
    
    public byte getM_bIsOpenMaxEnable()
    {
      return this.m_bIsOpenMaxEnable;
    }
  }
  
  public class AudioEngineNeedInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private byte m_OutputVolumeGain;
    private byte m_WorkModel;
    private int m_length;
    private byte m_param1;
    private byte m_preProcessModel;
    
    public AudioEngineNeedInfoTLV(short paramShort)
    {
      super((short)7, (short)4);
      this.m_length = paramShort;
      this.m_WorkModel = 0;
      this.m_preProcessModel = 0;
      this.m_OutputVolumeGain = 0;
      this.m_param1 = 0;
    }
    
    public byte GetOutputVolumeGain()
    {
      return this.m_OutputVolumeGain;
    }
    
    public byte GetParam1()
    {
      return this.m_param1;
    }
    
    public byte GetPreProcessModel()
    {
      return this.m_preProcessModel;
    }
    
    public byte GetWorkModel()
    {
      return this.m_WorkModel;
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
        return false;
      }
      this.m_WorkModel = paramByteBuffer.ReadUInt8();
      this.m_preProcessModel = paramByteBuffer.ReadUInt8();
      this.m_OutputVolumeGain = paramByteBuffer.ReadUInt8();
      this.m_param1 = paramByteBuffer.ReadUInt8();
      return true;
    }
  }
  
  public class C2SReqConfigProtocol
  {
    private ArrayList<ConfigProtocol.TLVBase> attrs = new ArrayList();
    private short lengthOfTLV = 0;
    private short numOfTLV = 0;
    private short tag = 1;
    
    public C2SReqConfigProtocol() {}
    
    public void AddTLV(ConfigProtocol.TLVBase paramTLVBase)
    {
      if (this.attrs == null) {
        return;
      }
      this.attrs.add(paramTLVBase);
      this.lengthOfTLV = ((short)(this.lengthOfTLV + 4));
      this.lengthOfTLV = ((short)(this.lengthOfTLV + paramTLVBase.getLength()));
      this.numOfTLV = ((short)(this.numOfTLV + 1));
    }
    
    public ConfigProtocol.TLVBase GetTLVByIndex(int paramInt)
    {
      if (paramInt >= this.attrs.size()) {
        return null;
      }
      return (ConfigProtocol.TLVBase)this.attrs.get(paramInt);
    }
    
    public ByteBuffer Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt16(this.tag);
      localByteBuffer.WriteUInt16(this.numOfTLV);
      localByteBuffer.WriteUInt16(this.lengthOfTLV);
      int i = 0;
      while (i < this.attrs.size())
      {
        localByteBuffer.WriteUInt16(((ConfigProtocol.TLVBase)this.attrs.get(i)).getType());
        localByteBuffer.WriteUInt16(((ConfigProtocol.TLVBase)this.attrs.get(i)).getLength());
        localByteBuffer.WriteByteBuffer(((ConfigProtocol.TLVBase)this.attrs.get(i)).Pack());
        i += 1;
      }
      return localByteBuffer;
    }
    
    public boolean UnPack(ByteBuffer paramByteBuffer)
    {
      this.tag = paramByteBuffer.ReadUInt16();
      this.numOfTLV = paramByteBuffer.ReadUInt16();
      this.lengthOfTLV = paramByteBuffer.ReadUInt16();
      return this.lengthOfTLV == paramByteBuffer.length();
    }
    
    public short getLengthOfTLV()
    {
      return this.lengthOfTLV;
    }
    
    public short getNumOfTLV()
    {
      return this.numOfTLV;
    }
    
    public short getTag()
    {
      return this.tag;
    }
    
    public void setLengthOfTLV(short paramShort)
    {
      this.lengthOfTLV = paramShort;
    }
    
    public void setNumOfTLV(short paramShort)
    {
      this.numOfTLV = paramShort;
    }
    
    public void setTag(short paramShort)
    {
      this.tag = paramShort;
    }
  }
  
  class CameraAngleInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private byte m_BackCameraAngleForLocalPreview;
    private byte m_BackCameraAngleForRemote_0;
    private byte m_BackCameraAngleForRemote_180;
    private byte m_BackCameraAngleForRemote_270;
    private byte m_BackCameraAngleForRemote_90;
    private byte m_BackCameraFormat;
    private byte m_FrontCameraAngleForLocalPreview;
    private byte m_FrontCameraAngleForRemote_0;
    private byte m_FrontCameraAngleForRemote_180;
    private byte m_FrontCameraAngleForRemote_270;
    private byte m_FrontCameraAngleForRemote_90;
    private byte m_FrontCameraFormat;
    private short m_length;
    private byte m_param3;
    private byte m_param4;
    private byte m_param5;
    private byte m_param6;
    
    public CameraAngleInfoTLV(short paramShort)
    {
      super((short)8, (short)16);
      this.m_length = paramShort;
      this.m_FrontCameraAngleForLocalPreview = 0;
      this.m_BackCameraAngleForLocalPreview = 0;
      this.m_FrontCameraAngleForRemote_0 = 0;
      this.m_BackCameraAngleForRemote_0 = 0;
      this.m_FrontCameraAngleForRemote_90 = 0;
      this.m_BackCameraAngleForRemote_90 = 0;
      this.m_FrontCameraAngleForRemote_180 = 0;
      this.m_BackCameraAngleForRemote_180 = 0;
      this.m_FrontCameraAngleForRemote_270 = 0;
      this.m_BackCameraAngleForRemote_270 = 0;
      this.m_FrontCameraFormat = 0;
      this.m_BackCameraFormat = 0;
      this.m_param3 = 0;
      this.m_param4 = 0;
      this.m_param5 = 0;
      this.m_param6 = 0;
    }
    
    public byte GetBackCameraAngleForLocalPreview()
    {
      return this.m_BackCameraAngleForLocalPreview;
    }
    
    public byte GetBackCameraAngleForRemote_0()
    {
      return this.m_BackCameraAngleForRemote_0;
    }
    
    public byte GetBackCameraAngleForRemote_180()
    {
      return this.m_BackCameraAngleForRemote_180;
    }
    
    public byte GetBackCameraAngleForRemote_270()
    {
      return this.m_BackCameraAngleForRemote_270;
    }
    
    public byte GetBackCameraAngleForRemote_90()
    {
      return this.m_BackCameraAngleForRemote_90;
    }
    
    public byte GetBackCameraFormat()
    {
      return this.m_BackCameraFormat;
    }
    
    public byte GetFrontCameraAngleForLocalPreview()
    {
      return this.m_FrontCameraAngleForLocalPreview;
    }
    
    public byte GetFrontCameraAngleForRemote_0()
    {
      return this.m_FrontCameraAngleForRemote_0;
    }
    
    public byte GetFrontCameraAngleForRemote_180()
    {
      return this.m_FrontCameraAngleForRemote_180;
    }
    
    public byte GetFrontCameraAngleForRemote_270()
    {
      return this.m_FrontCameraAngleForRemote_270;
    }
    
    public byte GetFrontCameraAngleForRemote_90()
    {
      return this.m_FrontCameraAngleForRemote_90;
    }
    
    public byte GetFrontCameraFormat()
    {
      return this.m_FrontCameraFormat;
    }
    
    public byte GetParam3()
    {
      return this.m_param3;
    }
    
    public byte GetParam4()
    {
      return this.m_param4;
    }
    
    public byte GetParam5()
    {
      return this.m_param5;
    }
    
    public byte GetParam6()
    {
      return this.m_param6;
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
        return false;
      }
      this.m_FrontCameraAngleForLocalPreview = paramByteBuffer.ReadUInt8();
      this.m_BackCameraAngleForLocalPreview = paramByteBuffer.ReadUInt8();
      this.m_FrontCameraAngleForRemote_0 = paramByteBuffer.ReadUInt8();
      this.m_BackCameraAngleForRemote_0 = paramByteBuffer.ReadUInt8();
      this.m_FrontCameraAngleForRemote_90 = paramByteBuffer.ReadUInt8();
      this.m_BackCameraAngleForRemote_90 = paramByteBuffer.ReadUInt8();
      this.m_FrontCameraAngleForRemote_180 = paramByteBuffer.ReadUInt8();
      this.m_BackCameraAngleForRemote_180 = paramByteBuffer.ReadUInt8();
      this.m_FrontCameraAngleForRemote_270 = paramByteBuffer.ReadUInt8();
      this.m_BackCameraAngleForRemote_270 = paramByteBuffer.ReadUInt8();
      this.m_FrontCameraFormat = paramByteBuffer.ReadUInt8();
      this.m_BackCameraFormat = paramByteBuffer.ReadUInt8();
      this.m_param3 = paramByteBuffer.ReadUInt8();
      this.m_param4 = paramByteBuffer.ReadUInt8();
      this.m_param5 = paramByteBuffer.ReadUInt8();
      this.m_param6 = paramByteBuffer.ReadUInt8();
      return true;
    }
  }
  
  public class ClientAVEngineInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private short m_DispHeight;
    private short m_DispWidth;
    private byte m_maxDecFPS;
    private byte m_maxEncFPS;
    
    public ClientAVEngineInfoTLV()
    {
      super((short)7, (short)6);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt8(this.m_maxEncFPS);
      localByteBuffer.WriteUInt8(this.m_maxDecFPS);
      localByteBuffer.WriteUInt16(this.m_DispWidth);
      localByteBuffer.WriteUInt16(this.m_DispHeight);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    void setAVEngineInfo(byte paramByte1, byte paramByte2, short paramShort1, short paramShort2)
    {
      this.m_maxEncFPS = paramByte1;
      this.m_maxDecFPS = paramByte2;
      this.m_DispWidth = paramShort1;
      this.m_DispHeight = paramShort2;
      setLength((short)6);
    }
  }
  
  public class ClientAppIDTLV
    extends ConfigProtocol.TLVBase
  {
    private String appID;
    
    public ClientAppIDTLV(short paramShort)
    {
      super((short)3, paramShort);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteString(this.appID);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setAppID(String paramString)
    {
      this.appID = paramString;
      short s = (short)paramString.length();
      try
      {
        int i = paramString.getBytes("GBK").length;
        s = (short)i;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      setLength(s);
    }
  }
  
  public class ClientDevNameTLV
    extends ConfigProtocol.TLVBase
  {
    private String devNameInfo;
    
    public ClientDevNameTLV()
    {
      super((short)5, (short)0);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteString(this.devNameInfo);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setDevNameInfo(String paramString)
    {
      this.devNameInfo = paramString;
      short s = (short)paramString.length();
      try
      {
        int i = this.devNameInfo.getBytes("GBK").length;
        s = (short)i;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      setLength(s);
    }
  }
  
  public class ClientDeviceTypeTLV
    extends ConfigProtocol.TLVBase
  {
    private short clientType = 0;
    
    public ClientDeviceTypeTLV()
    {
      super((short)1, (short)2);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt16(this.clientType);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setClientType(short paramShort)
    {
      this.clientType = paramShort;
    }
  }
  
  public class ClientHardWareInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private short angleForCamera;
    private short cpuChipArch;
    private int cpuFreq;
    private short numOfCore;
    
    public ClientHardWareInfoTLV()
    {
      super((short)6, (short)10);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt16(this.cpuChipArch);
      localByteBuffer.WriteUInt16(this.numOfCore);
      localByteBuffer.WriteUInt32(this.cpuFreq);
      localByteBuffer.WriteUInt16(this.angleForCamera);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setHardWareInfo(short paramShort1, short paramShort2, int paramInt, short paramShort3)
    {
      this.cpuChipArch = paramShort1;
      this.numOfCore = paramShort2;
      this.cpuFreq = paramInt;
      this.angleForCamera = paramShort3;
      setLength((short)10);
    }
  }
  
  public class ClientOSTypeTLV
    extends ConfigProtocol.TLVBase
  {
    private short clientOSType;
    
    public ClientOSTypeTLV()
    {
      super((short)2, (short)2);
      setClientOSType((short)0);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt16(this.clientOSType);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setClientOSType(short paramShort)
    {
      this.clientOSType = paramShort;
    }
  }
  
  public class ClientRomInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private String m_RomInfo;
    
    public ClientRomInfoTLV()
    {
      super((short)8, (short)0);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteString(this.m_RomInfo);
      return localByteBuffer.Data();
    }
    
    public void SetRomInfo(String paramString)
    {
      this.m_RomInfo = paramString;
      short s = (short)paramString.length();
      try
      {
        int i = this.m_RomInfo.getBytes("GBK").length;
        s = (short)i;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      setLength(s);
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
  }
  
  public class ClientSharpInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private int m_opensl = 0;
    
    public ClientSharpInfoTLV()
    {
      super((short)9, (short)4);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt32(this.m_opensl);
      return localByteBuffer.Data();
    }
    
    void SetOpenslInfo(int paramInt)
    {
      this.m_opensl = paramInt;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return false;
    }
  }
  
  public class ConnForbidTypeTLV
    extends ConfigProtocol.TLVBase
  {
    private short m_ConnType = 0;
    
    public ConnForbidTypeTLV()
    {
      super((short)5, (short)2);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((paramByteBuffer == null) || (paramByteBuffer.length() < 2)) {
        return false;
      }
      this.m_ConnType = paramByteBuffer.ReadUInt16();
      return true;
    }
    
    public short getConnForbidType()
    {
      return this.m_ConnType;
    }
  }
  
  public class ConnPriorityInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private byte m_LocalDirectConnPri;
    private byte m_RelayConnPri;
    private byte m_StunDirectConnPri;
    private short m_length;
    private byte m_param1;
    
    public ConnPriorityInfoTLV(short paramShort)
    {
      super((short)9, (short)4);
      this.m_length = paramShort;
      this.m_LocalDirectConnPri = 0;
      this.m_RelayConnPri = 0;
      this.m_StunDirectConnPri = 0;
      this.m_param1 = 0;
    }
    
    public byte GetLocalDirectConnPri()
    {
      return this.m_LocalDirectConnPri;
    }
    
    public byte GetParam1()
    {
      return this.m_param1;
    }
    
    public byte GetRelayConnPri()
    {
      return this.m_RelayConnPri;
    }
    
    public byte GetStunDirectConnPri()
    {
      return this.m_StunDirectConnPri;
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
        return false;
      }
      this.m_LocalDirectConnPri = paramByteBuffer.ReadUInt8();
      this.m_RelayConnPri = paramByteBuffer.ReadUInt8();
      this.m_StunDirectConnPri = paramByteBuffer.ReadUInt8();
      this.m_param1 = paramByteBuffer.ReadUInt8();
      return true;
    }
  }
  
  public class EngineVersionTLV
    extends ConfigProtocol.TLVBase
  {
    private String engienVersion;
    
    public EngineVersionTLV(short paramShort)
    {
      super((short)4, paramShort);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteString(this.engienVersion);
      return localByteBuffer.Data();
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public void setEngienVersion(String paramString)
    {
      this.engienVersion = paramString;
      short s = (short)paramString.length();
      try
      {
        int i = this.engienVersion.getBytes("GBK").length;
        s = (short)i;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      setLength(s);
    }
  }
  
  public class LocalLogUploadTLV
    extends ConfigProtocol.TLVBase
  {
    private String m_allStr;
    private String m_endTimeStr;
    private String m_startTimeStr;
    
    public LocalLogUploadTLV(short paramShort)
    {
      super((short)2, paramShort);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((paramByteBuffer == null) || (paramByteBuffer.length() < getLength())) {
        return false;
      }
      this.m_allStr = paramByteBuffer.ReadString(getLength());
      return true;
    }
    
    public boolean getLogUploadTimeScope()
    {
      if (this.m_allStr.length() < "2012/03/05/08,2012/03/05/20".length()) {
        return false;
      }
      this.m_startTimeStr = this.m_allStr.substring(0, 13);
      this.m_endTimeStr = this.m_allStr.substring(14, 13);
      return true;
    }
    
    public String getM_endTimeStr()
    {
      return this.m_endTimeStr;
    }
    
    public String getM_startTimeStr()
    {
      return this.m_startTimeStr;
    }
  }
  
  public class RelaySvrUDPCheckTLV
    extends ConfigProtocol.TLVBase
  {
    private ArrayList<ConfigProtocol.stNetAddress> addrList = new ArrayList();
    
    public RelaySvrUDPCheckTLV(short paramShort)
    {
      super((short)3, paramShort);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      int i = 0;
      if (paramByteBuffer == null) {}
      int k;
      int j;
      do
      {
        do
        {
          return false;
          k = getLength();
        } while (k < 2);
        j = paramByteBuffer.ReadUInt16();
      } while (j != (k - 2) / 6);
      while (i < j)
      {
        k = paramByteBuffer.ReadUInt32();
        short s = paramByteBuffer.ReadUInt16();
        ConfigProtocol.stNetAddress localstNetAddress = new ConfigProtocol.stNetAddress(ConfigProtocol.this);
        localstNetAddress.m_ip = k;
        localstNetAddress.m_port = s;
        this.addrList.add(localstNetAddress);
        i += 1;
      }
      return true;
    }
    
    public ConfigProtocol.stNetAddress getRelaySvrAddrByIndex(int paramInt)
    {
      if ((paramInt >= this.addrList.size()) || (paramInt < 0)) {
        return null;
      }
      return (ConfigProtocol.stNetAddress)this.addrList.get(paramInt);
    }
    
    public int getRelaySvrAddrCount()
    {
      return this.addrList.size();
    }
  }
  
  public class S2CConfigInfoProtocol
  {
    private ArrayList<ConfigProtocol.TLVBase> attrs = new ArrayList();
    private short lengthOfTLV = 0;
    private String md5;
    private short numOfTLV = 0;
    private short tag = 0;
    
    public S2CConfigInfoProtocol() {}
    
    public void AddTLV(ConfigProtocol.TLVBase paramTLVBase) {}
    
    public ConfigProtocol.TLVBase GetTLVByIndex(int paramInt)
    {
      if (paramInt >= this.attrs.size()) {
        return null;
      }
      return (ConfigProtocol.TLVBase)this.attrs.get(paramInt);
    }
    
    public boolean Pack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
    
    public boolean UnPack(ByteBuffer paramByteBuffer)
    {
      if ((paramByteBuffer == null) || (paramByteBuffer.length() < 39)) {
        return false;
      }
      this.md5 = paramByteBuffer.ReadString(33);
      this.tag = paramByteBuffer.ReadUInt16();
      this.numOfTLV = paramByteBuffer.ReadUInt16();
      this.lengthOfTLV = paramByteBuffer.ReadUInt16Length();
      this.attrs.clear();
      int i = 0;
      for (;;)
      {
        if (paramByteBuffer.length() <= 0) {
          break label196;
        }
        short s1 = paramByteBuffer.ReadUInt16();
        short s2 = paramByteBuffer.ReadUInt16Length();
        ConfigProtocol.TLVBase localTLVBase = ConfigProtocol.this.CreateS2CTLV(s1, s2);
        if (localTLVBase == null)
        {
          if (paramByteBuffer.Consume(s2)) {
            break label187;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("simonchwang", 0, "[S2CConfigInfoProtocol::UnPack] Consume failed" + i);
          return false;
        }
        if (!localTLVBase.Unpack(paramByteBuffer))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("simonchwang", 0, "[S2CConfigInfoProtocol::UnPack] Unpack failed" + i);
          return false;
        }
        this.attrs.add(localTLVBase);
        label187:
        i += 1;
      }
      label196:
      if (this.attrs != null) {
        this.numOfTLV = ((short)this.attrs.size());
      }
      return true;
    }
    
    public short getLengthOfTLV()
    {
      return this.lengthOfTLV;
    }
    
    public String getMd5()
    {
      return this.md5;
    }
    
    public short getNumOfTLV()
    {
      return this.numOfTLV;
    }
    
    public short getTag()
    {
      return this.tag;
    }
    
    public void setLengthOfTLV(short paramShort)
    {
      this.lengthOfTLV = paramShort;
    }
    
    public void setNumOfTLV(short paramShort)
    {
      this.numOfTLV = paramShort;
    }
    
    public void setTag(short paramShort)
    {
      this.tag = paramShort;
    }
  }
  
  public class SharpConfigPayloadTLV
    extends ConfigProtocol.TLVBase
  {
    private String m_sharpConfigPayload;
    
    public SharpConfigPayloadTLV(short paramShort)
    {
      super((short)14, paramShort);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((paramByteBuffer == null) || (paramByteBuffer.length() < getLength())) {
        return false;
      }
      this.m_sharpConfigPayload = paramByteBuffer.ReadString(getLength());
      return true;
    }
    
    public String getSharpConfigPayload()
    {
      return this.m_sharpConfigPayload;
    }
  }
  
  public class SharpConfigVersionTLV
    extends ConfigProtocol.TLVBase
  {
    private int m_sharpConfigVersion;
    
    public SharpConfigVersionTLV()
    {
      super((short)10, (short)4);
    }
    
    public byte[] Pack()
    {
      ByteBuffer localByteBuffer = new ByteBuffer();
      localByteBuffer.WriteUInt32(this.m_sharpConfigVersion);
      return localByteBuffer.Data();
    }
    
    public void SetSharpConfigVersion(int paramInt)
    {
      this.m_sharpConfigVersion = paramInt;
      setLength((short)4);
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      return true;
    }
  }
  
  public class SharpInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private byte m_ARM_Version;
    private short m_CPU_Frequence;
    private byte m_TRAE_Interface;
    private byte m_TRAE_Mode;
    private byte m_TRAE_Source;
    private byte m_TRAE_Stream_Type;
    private byte m_TRAE_Volume;
    private short m_length;
    
    public SharpInfoTLV(short paramShort)
    {
      super((short)10, (short)16);
      this.m_length = paramShort;
      this.m_TRAE_Source = 0;
      this.m_TRAE_Interface = 0;
      this.m_TRAE_Stream_Type = 0;
      this.m_TRAE_Volume = 0;
      this.m_TRAE_Mode = 0;
      this.m_ARM_Version = 0;
      this.m_CPU_Frequence = 0;
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
        return false;
      }
      this.m_TRAE_Source = paramByteBuffer.ReadUInt8();
      this.m_TRAE_Interface = paramByteBuffer.ReadUInt8();
      this.m_TRAE_Stream_Type = paramByteBuffer.ReadUInt8();
      this.m_TRAE_Volume = paramByteBuffer.ReadUInt8();
      this.m_TRAE_Mode = paramByteBuffer.ReadUInt8();
      this.m_ARM_Version = paramByteBuffer.ReadUInt8();
      this.m_CPU_Frequence = paramByteBuffer.ReadUInt16();
      paramByteBuffer.ReadUInt32();
      paramByteBuffer.ReadUInt32();
      if (QLog.isColorLevel()) {
        QLog.d("sevenzhu", 0, "SharpInfo " + this.m_TRAE_Source + " " + this.m_TRAE_Interface + " " + this.m_TRAE_Stream_Type + " " + this.m_TRAE_Volume + " " + this.m_TRAE_Mode + " " + this.m_ARM_Version + " " + this.m_CPU_Frequence);
      }
      return true;
    }
  }
  
  public class StunServerAddrTLV
    extends ConfigProtocol.TLVBase
  {
    private ArrayList<ConfigProtocol.stNetAddress> addrList = new ArrayList();
    
    public StunServerAddrTLV(short paramShort)
    {
      super((short)4, paramShort);
    }
    
    public ConfigProtocol.stNetAddress GetStunSvrAddrByIndex(int paramInt)
    {
      if ((paramInt >= this.addrList.size()) || (paramInt < 0)) {
        return null;
      }
      return (ConfigProtocol.stNetAddress)this.addrList.get(paramInt);
    }
    
    public int GetStunSvrAddrCount()
    {
      return this.addrList.size();
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      int i = 0;
      if (paramByteBuffer == null) {}
      int j;
      do
      {
        do
        {
          return false;
        } while (getLength() < 2);
        j = paramByteBuffer.ReadUInt16();
      } while (j != (getLength() - 2) / 6);
      while (i < j)
      {
        int k = paramByteBuffer.ReadUInt32();
        short s = paramByteBuffer.ReadUInt16();
        ConfigProtocol.stNetAddress localstNetAddress = new ConfigProtocol.stNetAddress(ConfigProtocol.this);
        localstNetAddress.m_ip = k;
        localstNetAddress.m_port = s;
        this.addrList.add(localstNetAddress);
        i += 1;
      }
      return true;
    }
  }
  
  public abstract class TLVBase
  {
    private short length;
    private short type;
    
    public TLVBase(short paramShort1, short paramShort2)
    {
      this.type = paramShort1;
      this.length = paramShort2;
    }
    
    public abstract byte[] Pack();
    
    public abstract boolean Unpack(ByteBuffer paramByteBuffer);
    
    public short getLength()
    {
      return this.length;
    }
    
    public short getType()
    {
      return this.type;
    }
    
    public void setLength(short paramShort)
    {
      this.length = paramShort;
    }
    
    public void setType(short paramShort)
    {
      this.type = paramShort;
    }
  }
  
  public class VideoEngineNeedInfoTLV
    extends ConfigProtocol.TLVBase
  {
    private short m_BackAngleForCamera;
    private short m_CPUArch;
    private short m_FrontAngleForCamera;
    private short m_dispHeight;
    private short m_dispWidth;
    private short m_length;
    private byte m_maxDecFPS;
    private byte m_maxEncFPS;
    private short m_param2;
    
    public VideoEngineNeedInfoTLV(short paramShort)
    {
      super((short)6, (short)14);
      this.m_length = paramShort;
      this.m_CPUArch = 0;
      this.m_maxEncFPS = 0;
      this.m_maxDecFPS = 0;
      this.m_FrontAngleForCamera = 0;
      this.m_dispHeight = 0;
      this.m_dispWidth = 0;
      this.m_BackAngleForCamera = 0;
    }
    
    public short GetBackAngleForCamera()
    {
      return this.m_BackAngleForCamera;
    }
    
    public short GetCPUArch()
    {
      return this.m_CPUArch;
    }
    
    public short GetDispHeight()
    {
      return this.m_dispHeight;
    }
    
    public short GetDispWidth()
    {
      return this.m_dispWidth;
    }
    
    public short GetFrontAngleForCamera()
    {
      return this.m_FrontAngleForCamera;
    }
    
    public byte GetMaxDecFPS()
    {
      return this.m_maxDecFPS;
    }
    
    public byte GetMaxEncFPS()
    {
      return this.m_maxEncFPS;
    }
    
    public short GetParam2()
    {
      return this.m_param2;
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((this.m_length != getLength()) || (paramByteBuffer.length() < this.m_length)) {
        return false;
      }
      this.m_CPUArch = paramByteBuffer.ReadUInt16();
      this.m_FrontAngleForCamera = paramByteBuffer.ReadUInt16();
      this.m_maxEncFPS = paramByteBuffer.ReadUInt8();
      this.m_maxDecFPS = paramByteBuffer.ReadUInt8();
      this.m_dispWidth = paramByteBuffer.ReadUInt16();
      this.m_dispHeight = paramByteBuffer.ReadUInt16();
      this.m_BackAngleForCamera = paramByteBuffer.ReadUInt16();
      this.m_param2 = paramByteBuffer.ReadUInt16();
      return true;
    }
  }
  
  public class WriteLocalLogTLV
    extends ConfigProtocol.TLVBase
  {
    private short m_bIsWrite = 0;
    
    public WriteLocalLogTLV()
    {
      super((short)1, (short)2);
    }
    
    public byte[] Pack()
    {
      return null;
    }
    
    public boolean Unpack(ByteBuffer paramByteBuffer)
    {
      if ((paramByteBuffer == null) || (paramByteBuffer.length() < 2)) {
        return false;
      }
      this.m_bIsWrite = paramByteBuffer.ReadUInt16();
      return true;
    }
    
    public short getIsWriteLog()
    {
      return this.m_bIsWrite;
    }
  }
  
  public class stNetAddress
  {
    int m_ip = 0;
    short m_port = 0;
    
    public stNetAddress() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigProtocol
 * JD-Core Version:    0.7.0.1
 */