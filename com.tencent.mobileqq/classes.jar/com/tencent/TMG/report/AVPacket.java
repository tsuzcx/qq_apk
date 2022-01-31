package com.tencent.TMG.report;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;

public class AVPacket
{
  private String SSOCommand;
  private String account = "0";
  private HashMap<String, Object> attributes = new HashMap();
  public boolean autoResend;
  private UniPacket client = new UniPacket(true);
  private boolean noResponse;
  private byte[] sendData;
  private long timeout = 30000L;
  
  public AVPacket(String paramString)
  {
    this.client.setEncodeName("UTF-8");
    if (paramString != null) {
      this.account = paramString;
    }
  }
  
  public static <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.decode(paramArrayOfByte);
    return localUniPacket.getByClass(paramString, paramT);
  }
  
  public Object addAttribute(String paramString, Object paramObject)
  {
    return this.attributes.put(paramString, paramObject);
  }
  
  public void addRequestPacket(String paramString, JceStruct paramJceStruct)
  {
    this.client.put(paramString, paramJceStruct);
  }
  
  public HashMap<String, Object> getAttributes()
  {
    return this.attributes;
  }
  
  public String getFuncName()
  {
    return this.client.getServantName();
  }
  
  public String getServantName()
  {
    return this.client.getServantName();
  }
  
  public void putSendData(byte[] paramArrayOfByte)
  {
    this.sendData = paramArrayOfByte;
  }
  
  public void setAccount(String paramString)
  {
    this.account = paramString;
  }
  
  public void setAttributes(HashMap<String, Object> paramHashMap)
  {
    this.attributes = paramHashMap;
  }
  
  public void setFuncName(String paramString)
  {
    this.client.setFuncName(paramString);
  }
  
  public void setNoResponse()
  {
    this.noResponse = true;
  }
  
  public void setSSOCommand(String paramString)
  {
    this.SSOCommand = paramString;
  }
  
  public void setServantName(String paramString)
  {
    this.client.setServantName(paramString);
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public byte[] toWupData()
  {
    if ((this.SSOCommand != null) && (this.sendData == null)) {
      this.sendData = this.client.encode();
    }
    return this.sendData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.report.AVPacket
 * JD-Core Version:    0.7.0.1
 */