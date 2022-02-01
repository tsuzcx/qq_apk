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
  static byte angle_local_background = 0;
  static byte angle_local_front = 0;
  static byte angle_remote_background_0 = 0;
  static byte angle_remote_background_180 = 0;
  static byte angle_remote_background_270 = 0;
  static byte angle_remote_background_90 = 0;
  static byte angle_remote_front_0 = 0;
  static byte angle_remote_front_180 = 0;
  static byte angle_remote_front_270 = 0;
  static byte angle_remote_front_90 = 0;
  static byte bace_camera_format = 0;
  static ConfigProtocol.S2CConfigInfoProtocol configProtocol;
  static byte dAudio_enable = 1;
  static byte front_camera_format = 0;
  static boolean isReadDone = false;
  byte[] configMsg = null;
  String m_Appid = null;
  Context m_Context = null;
  ConfigProtocol protocol = null;
  
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
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return angle_local_front;
      }
      return angle_local_background;
    }
    if (paramBoolean1)
    {
      if (paramByte == 0) {
        return angle_remote_front_0;
      }
      if (paramByte == 1) {
        return angle_remote_front_90;
      }
      if (paramByte == 2) {
        return angle_remote_front_180;
      }
      if (paramByte == 3) {
        return angle_remote_front_270;
      }
    }
    else
    {
      if (paramByte == 0) {
        return angle_remote_background_0;
      }
      if (paramByte == 1) {
        return angle_remote_background_90;
      }
      if (paramByte == 2) {
        return angle_remote_background_180;
      }
      if (paramByte == 3) {
        b = angle_remote_background_270;
      }
    }
    return b;
  }
  
  static void GetAngleInfo(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null) {
      return;
    }
    Object localObject = new ConfigProtocol();
    localObject.getClass();
    localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
    if (!((ConfigProtocol.S2CConfigInfoProtocol)localObject).UnPack(new ByteBuffer(paramContext))) {
      return;
    }
    int j = ((ConfigProtocol.S2CConfigInfoProtocol)localObject).getNumOfTLV();
    int i = 0;
    while (i < j)
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
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("angle_local_front: ");
      paramContext.append(angle_local_front);
      paramContext.append(", angle_local_background: ");
      paramContext.append(angle_local_background);
      paramContext.append(", angle_remote_front_0: ");
      paramContext.append(angle_remote_front_0);
      paramContext.append(", angle_remote_front_90: ");
      paramContext.append(angle_remote_front_90);
      paramContext.append(", angle_remote_front_180: ");
      paramContext.append(angle_remote_front_180);
      paramContext.append(", angle_remote_front_270: ");
      paramContext.append(angle_remote_front_270);
      paramContext.append(", angle_remote_background_0: ");
      paramContext.append(angle_remote_background_0);
      paramContext.append(", angle_remote_background_90: ");
      paramContext.append(angle_remote_background_90);
      paramContext.append(", angle_remote_background_180: ");
      paramContext.append(angle_remote_background_180);
      paramContext.append(", angle_remote_background_270: ");
      paramContext.append(angle_remote_background_270);
      QLog.d("ConfigSystem", 0, paramContext.toString());
    }
  }
  
  public static byte[] getConfigRequestPackage(String paramString, Context paramContext)
  {
    return new ConfigSystemImpl(paramString, paramContext).getConfigRequestPackage();
  }
  
  static void getDAudioConfig(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "not have config file");
      }
      return;
    }
    Object localObject = new ConfigProtocol();
    localObject.getClass();
    localObject = new ConfigProtocol.S2CConfigInfoProtocol((ConfigProtocol)localObject);
    if (!((ConfigProtocol.S2CConfigInfoProtocol)localObject).UnPack(new ByteBuffer(paramContext)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "unPack TLV video config err");
      }
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 0, "file has no DAudio Config item");
    }
  }
  
  public static boolean isDAudioEnable(Context paramContext)
  {
    getDAudioConfig(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isDAudioEnable:");
      paramContext.append(dAudio_enable);
      QLog.d("ConfigSystem", 0, paramContext.toString());
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
    Object localObject = this.configMsg;
    if ((localObject != null) && (localObject.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "WriteConfigInfoToFile commit!");
      }
      Common.writeFile(this.m_Context, "VideoConfigInfo", this.configMsg);
      dAudio_enable = 1;
      localObject = getSharpConfigPayload(this.m_Context);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        String str = ((String)localObject).substring(0, 1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("WriteConfigInfoToFile SharpConfigPayload: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" sharpConfigType: ");
          localStringBuilder.append(str);
          QLog.d("ConfigSystem", 0, localStringBuilder.toString());
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
    paramContext = Common.readFile(paramContext, "SharpConfigPayload");
    if (paramContext != null)
    {
      String str = new String(paramContext);
      int i = str.indexOf('|');
      paramContext = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetSharpConfigPayloadFromFile get version: ");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(". payload: ");
        localStringBuilder.append(str);
        QLog.d("", 0, localStringBuilder.toString());
      }
      return Integer.parseInt(paramContext);
    }
    return 0;
  }
  
  public boolean isNeedStartVideoProcess()
  {
    Object localObject = this.configMsg;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "null == this.configMsg");
      }
      return false;
    }
    localObject = new ByteBuffer((byte[])localObject);
    if (!configProtocol.UnPack((ByteBuffer)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "UnpackConfigInfo Error");
      }
      return false;
    }
    int j = configProtocol.getNumOfTLV();
    if (j <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 0, "TLV number less then 1");
      }
      return false;
    }
    int i = 0;
    while (i < j)
    {
      localObject = configProtocol.GetTLVByIndex(i);
      if ((localObject != null) && ((((ConfigProtocol.TLVBase)localObject).getType() == 2) || (((ConfigProtocol.TLVBase)localObject).getType() == 3))) {
        return true;
      }
      i += 1;
    }
    return false;
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