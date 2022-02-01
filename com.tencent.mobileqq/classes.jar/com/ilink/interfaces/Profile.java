package com.ilink.interfaces;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Profile
  implements Serializable
{
  private static final long serialVersionUID = -5209587597047763261L;
  public String bigheadurl;
  public String city;
  public String exportid;
  public String ilinkid;
  public String nickname;
  public String province;
  public String qrcodepath;
  public String requestTip;
  public String sex;
  public String smallheadurl;
  public int uin;
  
  public Profile() {}
  
  public Profile(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      paramArrayOfByte = (Profile)new ObjectInputStream(paramArrayOfByte).readObject();
      this.ilinkid = paramArrayOfByte.ilinkid;
      this.uin = paramArrayOfByte.uin;
      this.nickname = paramArrayOfByte.nickname;
      this.sex = paramArrayOfByte.sex;
      this.province = paramArrayOfByte.province;
      this.city = paramArrayOfByte.city;
      this.smallheadurl = paramArrayOfByte.smallheadurl;
      this.bigheadurl = paramArrayOfByte.bigheadurl;
      this.qrcodepath = paramArrayOfByte.qrcodepath;
      return;
    }
    catch (ClassNotFoundException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] serialize()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(this);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public void setIlinkid(String paramString)
  {
    this.ilinkid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ilink.interfaces.Profile
 * JD-Core Version:    0.7.0.1
 */