package com.tencent.TMG.config;

import android.content.Context;
import com.tencent.TMG.utils.QLog;

public class ConfigInfo
{
  private static ConfigInfo instance;
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetSharpConfigPayloadFromFile payloadBufTmp: ");
        ((StringBuilder)localObject).append(str);
        QLog.d("", 0, ((StringBuilder)localObject).toString());
      }
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetSharpConfigPayloadFromFile version: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(". payload: ");
        localStringBuilder.append(str);
        QLog.d("", 0, localStringBuilder.toString());
      }
      return str;
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    Object localObject = Common.readFile(this.m_context, "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetSharpConfigPayloadFromFile payloadBufTmp: ");
        ((StringBuilder)localObject).append(str);
        QLog.d("", 0, ((StringBuilder)localObject).toString());
      }
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetSharpConfigPayloadFromFile version: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(". payload: ");
        localStringBuilder.append(str);
        QLog.d("", 0, localStringBuilder.toString());
      }
      return Integer.parseInt((String)localObject);
    }
    return 0;
  }
  
  public void WriteConfigInfoToFile(byte[] paramArrayOfByte) {}
  
  public void init(Context paramContext)
  {
    this.m_context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */