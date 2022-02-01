package com.tencent.TMG.config;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.TMG.utils.QLog;

public class ConfigSystemImpl
{
  public static final byte DEFLECT_ANGLE_0 = 0;
  public static final byte DEFLECT_ANGLE_180 = 2;
  public static final byte DEFLECT_ANGLE_270 = 3;
  public static final byte DEFLECT_ANGLE_90 = 1;
  static final String TAG = "ConfigSystem";
  static byte angle_local_background;
  static byte angle_local_front;
  static byte angle_remote_background_0;
  static byte angle_remote_background_180;
  static byte angle_remote_background_270;
  static byte angle_remote_background_90;
  static byte angle_remote_front_0;
  static byte angle_remote_front_180;
  static byte angle_remote_front_270;
  static byte angle_remote_front_90;
  static byte bace_camera_format;
  static ConfigProtocol.S2CConfigInfoProtocol configProtocol = null;
  static byte dAudio_enable = 1;
  static byte front_camera_format;
  static boolean isReadDone;
  byte[] configMsg = null;
  String m_Appid = null;
  Context m_Context = null;
  ConfigProtocol protocol = null;
  
  static
  {
    angle_local_front = 0;
    angle_local_background = 0;
    angle_remote_front_0 = 0;
    angle_remote_front_90 = 0;
    angle_remote_front_180 = 0;
    angle_remote_front_270 = 0;
    angle_remote_background_0 = 0;
    angle_remote_background_90 = 0;
    angle_remote_background_180 = 0;
    angle_remote_background_270 = 0;
    front_camera_format = 0;
    bace_camera_format = 0;
    isReadDone = false;
  }
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.m_Appid = paramString;
    this.m_Context = paramContext;
    this.protocol = new ConfigProtocol();
    paramString = this.protocol;
    paramString.getClass();
    configProtocol = new ConfigProtocol.S2CConfigInfoProtocol(paramString);
  }
  
  public static byte GetAngleForCamera(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte)
  {
    if (!isReadDone)
    {
      GetAngleInfo(paramContext);
      isReadDone = true;
    }
    byte b = 0;
    if (paramBoolean2) {
      if (paramBoolean1) {
        b = angle_local_front;
      }
    }
    do
    {
      do
      {
        return b;
        return angle_local_background;
        if (!paramBoolean1) {
          break;
        }
        if (paramByte == 0) {
          return angle_remote_front_0;
        }
        if (paramByte == 1) {
          return angle_remote_front_90;
        }
        if (paramByte == 2) {
          return angle_remote_front_180;
        }
      } while (paramByte != 3);
      return angle_remote_front_270;
      if (paramByte == 0) {
        return angle_remote_background_0;
      }
      if (paramByte == 1) {
        return angle_remote_background_90;
      }
      if (paramByte == 2) {
        return angle_remote_background_180;
      }
    } while (paramByte != 3);
    return angle_remote_background_270;
  }
  
  static void GetAngleInfo(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null) {}
    Object localObject;
    do
    {
      return;
      localObject = new ConfigProtocol();
      localObject.getClass();
      localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
    } while (!((ConfigProtocol.S2CConfigInfoProtocol)localObject).UnPack(new ByteBuffer(paramContext)));
    int j = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).getNumOfTLV();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        paramContext = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).GetTLVByIndex(i);
        if ((paramContext != null) && (paramContext.getType() == 8))
        {
          paramContext = (ConfigProtocol.CameraAngleInfoTLV)paramContext;
          angle_local_front = paramContext.GetFrontCameraAngleForLocalPreview();
          angle_local_background = paramContext.GetBackCameraAngleForLocalPreview();
          angle_remote_front_0 = paramContext.GetFrontCameraAngleForRemote_0();
          angle_remote_front_90 = paramContext.GetFrontCameraAngleForRemote_90();
          angle_remote_front_180 = paramContext.GetFrontCameraAngleForRemote_180();
          angle_remote_front_270 = paramContext.GetFrontCameraAngleForRemote_270();
          angle_remote_background_0 = paramContext.GetBackCameraAngleForRemote_0();
          angle_remote_background_90 = paramContext.GetBackCameraAngleForRemote_90();
          angle_remote_background_180 = paramContext.GetBackCameraAngleForRemote_180();
          angle_remote_background_270 = paramContext.GetBackCameraAngleForRemote_270();
          front_camera_format = paramContext.GetFrontCameraFormat();
          bace_camera_format = paramContext.GetBackCameraFormat();
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ConfigSystem", 0, "angle_local_front: " + angle_local_front + ", angle_local_background: " + angle_local_background + ", angle_remote_front_0: " + angle_remote_front_0 + ", angle_remote_front_90: " + angle_remote_front_90 + ", angle_remote_front_180: " + angle_remote_front_180 + ", angle_remote_front_270: " + angle_remote_front_270 + ", angle_remote_background_0: " + angle_remote_background_0 + ", angle_remote_background_90: " + angle_remote_background_90 + ", angle_remote_background_180: " + angle_remote_background_180 + ", angle_remote_background_270: " + angle_remote_background_270);
        return;
      }
      i += 1;
    }
  }
  
  public static byte[] getConfigRequestPackage(String paramString, Context paramContext)
  {
    return new ConfigSystemImpl(paramString, paramContext).getConfigRequestPackage();
  }
  
  static void getDAudioConfig(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "not have config file");
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = new ConfigProtocol();
        localObject.getClass();
        localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
        if (((ConfigProtocol.S2CConfigInfoProtocol)localObject).UnPack(new ByteBuffer(paramContext))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystem", 0, "unPack TLV video config err");
      return;
      int j = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).getNumOfTLV();
      int i = 0;
      while (i < j)
      {
        paramContext = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).GetTLVByIndex(i);
        if ((paramContext != null) && (paramContext.getType() == 11))
        {
          dAudio_enable = ((ConfigProtocol.AVSwitchTypeTLV)paramContext).getM_bIsAuidoEnable();
          return;
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystem", 0, "file has no DAudio Config item");
  }
  
  public static boolean isDAudioEnable(Context paramContext)
  {
    getDAudioConfig(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 0, "isDAudioEnable:" + dAudio_enable);
    }
    return dAudio_enable == 1;
  }
  
  public static boolean isNeedStartVideoProcess(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramString = new ConfigSystemImpl(paramString, paramContext);
      paramString.setConfigMsg(paramArrayOfByte);
      paramString.WriteConfigInfoToFile();
      return paramString.isNeedStartVideoProcess();
    }
    return false;
  }
  
  public void WriteConfigInfoToFile()
  {
    if ((this.configMsg != null) && (this.configMsg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "WriteConfigInfoToFile commit!");
      }
      Common.writeFile(this.m_Context, "VideoConfigInfo", this.configMsg);
      dAudio_enable = 1;
      String str1 = getSharpConfigPayload(this.m_Context);
      if ((str1 != null) && (str1.length() > 0))
      {
        String str2 = str1.substring(0, 1);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 0, "WriteConfigInfoToFile SharpConfigPayload: " + str1 + " sharpConfigType: " + str2);
        }
      }
    }
  }
  
  public byte[] getConfigRequestPackage()
  {
    Object localObject1 = this.protocol;
    localObject1.getClass();
    localObject1 = new ConfigProtocol.C2SReqConfigProtocol((ConfigProtocol)localObject1);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).setTag((short)1);
    Object localObject2 = this.protocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientDeviceTypeTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientDeviceTypeTLV)localObject2).setClientType((short)101);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).AddTLV((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.protocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientAppIDTLV((ConfigProtocol)localObject2, (short)0);
    ((ConfigProtocol.ClientAppIDTLV)localObject2).setAppID(this.m_Appid);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).AddTLV((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.protocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.EngineVersionTLV((ConfigProtocol)localObject2, (short)0);
    ((ConfigProtocol.EngineVersionTLV)localObject2).setEngienVersion(Common.getVersion(this.m_Context));
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).AddTLV((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.protocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientRomInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientRomInfoTLV)localObject2).SetRomInfo(Build.VERSION.INCREMENTAL);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).AddTLV((ConfigProtocol.TLVBase)localObject2);
    localObject2 = this.protocol;
    localObject2.getClass();
    localObject2 = new ConfigProtocol.ClientSharpInfoTLV((ConfigProtocol)localObject2);
    ((ConfigProtocol.ClientSharpInfoTLV)localObject2).SetOpenslInfo(22);
    ((ConfigProtocol.C2SReqConfigProtocol)localObject1).AddTLV((ConfigProtocol.TLVBase)localObject2);
    return ((ConfigProtocol.C2SReqConfigProtocol)localObject1).Pack().Data();
  }
  
  public String getSharpConfigPayload(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "not have config file");
      }
      return "";
    }
    ConfigProtocol localConfigProtocol = new ConfigProtocol();
    localConfigProtocol.getClass();
    if (!new ConfigProtocol.S2CConfigInfoProtocol(localConfigProtocol).UnPack(new ByteBuffer(paramContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "unPack TLV video config err");
      }
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 0, "file has no SharpConfigPayload config item");
    }
    return "";
  }
  
  public int getSharpConfigVersion(Context paramContext)
  {
    int i = 0;
    paramContext = Common.readFile(paramContext, "SharpConfigPayload");
    if (paramContext != null)
    {
      String str = new String(paramContext);
      i = str.indexOf('|');
      paramContext = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 0, "GetSharpConfigPayloadFromFile get version: " + paramContext + ". payload: " + str);
      }
      i = Integer.parseInt(paramContext);
    }
    return i;
  }
  
  public boolean isNeedStartVideoProcess()
  {
    if (this.configMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "null == this.configMsg");
      }
    }
    for (;;)
    {
      return false;
      Object localObject = new ByteBuffer(this.configMsg);
      if (!configProtocol.UnPack((ByteBuffer)localObject))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ConfigSystem", 0, "UnpackConfigInfo Error");
          return false;
        }
      }
      else
      {
        int j = configProtocol.getNumOfTLV();
        if (j <= 0)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ConfigSystem", 0, "TLV number less then 1");
            return false;
          }
        }
        else
        {
          int i = 0;
          while (i < j)
          {
            localObject = configProtocol.GetTLVByIndex(i);
            if ((localObject != null) && ((((ConfigProtocol.TLVBase)localObject).getType() == 2) || (((ConfigProtocol.TLVBase)localObject).getType() == 3))) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  void setConfigMsg(byte[] paramArrayOfByte)
  {
    this.configMsg = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */