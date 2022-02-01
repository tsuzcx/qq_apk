package com.tencent.TMG.config;

import android.content.Context;
import com.tencent.TMG.utils.QLog;

public class ConfigInfo
{
  private static ConfigInfo instance = null;
  private Context m_context = null;
  
  public ConfigInfo()
  {
    try
    {
      init();
      cacheMethodIds();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ConfigInfo instance()
  {
    if (instance == null) {
      instance = new ConfigInfo();
    }
    return instance;
  }
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.readFile(this.m_context, "VideoConfigInfo");
  }
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject = Common.readFile(this.m_context, "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("", 0, "GetSharpConfigPayloadFromFile payloadBufTmp: " + str);
      }
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 0, "GetSharpConfigPayloadFromFile version: " + (String)localObject + ". payload: " + str);
      }
      return str;
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    int i = 0;
    Object localObject = Common.readFile(this.m_context, "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("", 0, "GetSharpConfigPayloadFromFile payloadBufTmp: " + str);
      }
      i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 0, "GetSharpConfigPayloadFromFile version: " + (String)localObject + ". payload: " + str);
      }
      i = Integer.parseInt((String)localObject);
    }
    return i;
  }
  
  public void WriteConfigInfoToFile(byte[] paramArrayOfByte) {}
  
  public void init(Context paramContext)
  {
    this.m_context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */