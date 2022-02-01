package com.tencent.av.config;

public class ConfigPBProtocol
{
  public static String a = "";
  private ConfigPBProtocol.C2SConfigInfoPBProtocol b = new ConfigPBProtocol.C2SConfigInfoPBProtocol(this);
  private ConfigPBProtocol.S2CConfigInfoPBProtocol c = new ConfigPBProtocol.S2CConfigInfoPBProtocol(this);
  
  public int a(byte[] paramArrayOfByte)
  {
    ConfigPBProtocol.S2CConfigInfoPBProtocol localS2CConfigInfoPBProtocol = this.c;
    if (localS2CConfigInfoPBProtocol != null) {
      return localS2CConfigInfoPBProtocol.a(paramArrayOfByte);
    }
    return -1;
  }
  
  public void a(long paramLong, ConfigPBProtocol.TerminalInfo paramTerminalInfo)
  {
    this.b.a(paramLong, paramTerminalInfo);
  }
  
  public byte[] a()
  {
    ConfigPBProtocol.C2SConfigInfoPBProtocol localC2SConfigInfoPBProtocol = this.b;
    if (localC2SConfigInfoPBProtocol != null) {
      return localC2SConfigInfoPBProtocol.a();
    }
    return null;
  }
  
  public ConfigPBProtocol.ConfigSysInfoNew b()
  {
    ConfigPBProtocol.S2CConfigInfoPBProtocol localS2CConfigInfoPBProtocol = this.c;
    if (localS2CConfigInfoPBProtocol != null) {
      return localS2CConfigInfoPBProtocol.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol
 * JD-Core Version:    0.7.0.1
 */