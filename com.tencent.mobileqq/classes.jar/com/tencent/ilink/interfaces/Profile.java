package com.tencent.ilink.interfaces;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.luggage.wxa.ar.a.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Profile
  implements Serializable
{
  public String bigheadurl;
  public String city;
  public String ilinkid;
  public String nickname;
  public String province;
  public String qrcodepath;
  public String requestTip;
  public String sex;
  public String smallheadurl;
  public long uin;
  
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
  
  protected static Profile pb2Profile(byte[] paramArrayOfByte)
  {
    Profile localProfile = new Profile();
    try
    {
      paramArrayOfByte = a.b.a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      if (paramArrayOfByte.b()) {
        localProfile.ilinkid = paramArrayOfByte.c();
      }
      if (paramArrayOfByte.d()) {
        localProfile.uin = paramArrayOfByte.e();
      }
      if (paramArrayOfByte.f()) {
        localProfile.nickname = paramArrayOfByte.g();
      }
      if (paramArrayOfByte.h()) {
        localProfile.sex = paramArrayOfByte.i();
      }
      if (paramArrayOfByte.j()) {
        localProfile.province = paramArrayOfByte.k();
      }
      if (paramArrayOfByte.l()) {
        localProfile.city = paramArrayOfByte.m();
      }
      if (paramArrayOfByte.n()) {
        localProfile.smallheadurl = paramArrayOfByte.o();
      }
      if (paramArrayOfByte.p()) {
        localProfile.bigheadurl = paramArrayOfByte.q();
      }
      if (paramArrayOfByte.r()) {
        localProfile.qrcodepath = paramArrayOfByte.s();
      }
      return localProfile;
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilinkid:");
    localStringBuilder.append(this.ilinkid);
    localStringBuilder.append(" ,uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" ,nickname:");
    localStringBuilder.append(this.nickname);
    localStringBuilder.append(" ,sex:");
    localStringBuilder.append(this.sex);
    localStringBuilder.append(" ,province:");
    localStringBuilder.append(this.province);
    localStringBuilder.append(" ,city:");
    localStringBuilder.append(this.city);
    localStringBuilder.append(",smallheadurl:");
    localStringBuilder.append(this.smallheadurl);
    localStringBuilder.append(" ,bigheadurl:");
    localStringBuilder.append(this.bigheadurl);
    localStringBuilder.append(" ,qrcodepath:");
    localStringBuilder.append(this.qrcodepath);
    localStringBuilder.append(",requestTip:");
    localStringBuilder.append(this.requestTip);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.interfaces.Profile
 * JD-Core Version:    0.7.0.1
 */