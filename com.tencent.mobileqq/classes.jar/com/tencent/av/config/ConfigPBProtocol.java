package com.tencent.av.config;

public class ConfigPBProtocol
{
  public static String a;
  private ConfigPBProtocol.C2SConfigInfoPBProtocol jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$C2SConfigInfoPBProtocol = new ConfigPBProtocol.C2SConfigInfoPBProtocol(this);
  private ConfigPBProtocol.S2CConfigInfoPBProtocol jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$S2CConfigInfoPBProtocol = new ConfigPBProtocol.S2CConfigInfoPBProtocol(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$S2CConfigInfoPBProtocol != null) {
      return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$S2CConfigInfoPBProtocol.a(paramArrayOfByte);
    }
    return -1;
  }
  
  public ConfigPBProtocol.ConfigSysInfoNew a()
  {
    ConfigPBProtocol.ConfigSysInfoNew localConfigSysInfoNew = null;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$S2CConfigInfoPBProtocol != null) {
      localConfigSysInfoNew = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$S2CConfigInfoPBProtocol.a();
    }
    return localConfigSysInfoNew;
  }
  
  public void a(long paramLong, ConfigPBProtocol.TerminalInfo paramTerminalInfo)
  {
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$C2SConfigInfoPBProtocol.a(paramLong, paramTerminalInfo);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = null;
    if (this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$C2SConfigInfoPBProtocol != null) {
      arrayOfByte = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$C2SConfigInfoPBProtocol.a();
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol
 * JD-Core Version:    0.7.0.1
 */