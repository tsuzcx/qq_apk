package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class UpSendMsgReq
  implements IMessageEntity
{
  @Packed
  public String collapseKey;
  @Packed
  public String data;
  @Packed
  public String msgId;
  @Packed
  public String msgType;
  @Packed
  public String packageName;
  @Packed
  public int receiptMode;
  @Packed
  public int sendMode;
  @Packed
  public String to;
  @Packed
  public String token;
  @Packed
  public int ttl;
  
  public String getCollapseKey()
  {
    return this.collapseKey;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getMessageId()
  {
    return this.msgId;
  }
  
  public String getMessageType()
  {
    return this.msgType;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public int getReceiptMode()
  {
    return this.receiptMode;
  }
  
  public int getSendMode()
  {
    return this.sendMode;
  }
  
  public String getTo()
  {
    return this.to;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public int getTtl()
  {
    return this.ttl;
  }
  
  public void setCollapseKey(String paramString)
  {
    this.collapseKey = paramString;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setMessageId(String paramString)
  {
    this.msgId = paramString;
  }
  
  public void setMessageType(String paramString)
  {
    this.msgType = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setReceiptMode(int paramInt)
  {
    this.receiptMode = paramInt;
  }
  
  public void setSendMode(int paramInt)
  {
    this.sendMode = paramInt;
  }
  
  public void setTo(String paramString)
  {
    this.to = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setTtl(int paramInt)
  {
    this.ttl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.push.UpSendMsgReq
 * JD-Core Version:    0.7.0.1
 */