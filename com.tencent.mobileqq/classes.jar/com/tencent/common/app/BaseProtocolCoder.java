package com.tencent.common.app;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public abstract class BaseProtocolCoder
{
  public HashMap<String, Integer> requestHandles = new HashMap();
  
  public static long createUserId(long paramLong)
  {
    Object localObject = new ByteArrayOutputStream(8);
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    try
    {
      localDataOutputStream.writeLong(paramLong);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      localObject[0] = 0;
      localObject[1] = 0;
      paramLong = new DataInputStream(new ByteArrayInputStream((byte[])localObject)).readLong();
      return paramLong;
    }
    catch (IOException localIOException) {}
    return 0L;
  }
  
  public abstract String[] cmdHeaderPrefix();
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return null;
  }
  
  public final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void destroy() {}
  
  public boolean enableBinaryProtocol()
  {
    return false;
  }
  
  public abstract boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
  
  public byte[] encodeReqMsg(ToServiceMsg paramToServiceMsg)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseProtocolCoder
 * JD-Core Version:    0.7.0.1
 */