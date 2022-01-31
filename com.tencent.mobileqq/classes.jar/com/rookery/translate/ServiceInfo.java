package com.rookery.translate;

import com.tencent.qphone.base.util.Cryptor;

public class ServiceInfo
{
  private final String a = "ZaDA32%dkn_vs4dAjg";
  
  public String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new String(new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2));
  }
  
  public byte[] a()
  {
    return "ZaDA32%dkn_vs4dAjg".getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.rookery.translate.ServiceInfo
 * JD-Core Version:    0.7.0.1
 */