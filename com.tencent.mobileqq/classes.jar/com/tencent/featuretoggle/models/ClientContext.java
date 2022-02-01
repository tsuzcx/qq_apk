package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public class ClientContext
  extends JceStruct
{
  static Map<String, String> cache_properties = new HashMap();
  public String deviceId = "";
  public String hostname = "";
  public Map<String, String> properties = null;
  public String qimei = "";
  public String remoteAddress = "";
  public String sessionId = "";
  public String userId = "";
  
  static
  {
    cache_properties.put("", "");
  }
  
  public ClientContext() {}
  
  public ClientContext(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap, String paramString6)
  {
    this.userId = paramString1;
    this.sessionId = paramString2;
    this.remoteAddress = paramString3;
    this.deviceId = paramString4;
    this.hostname = paramString5;
    this.properties = paramMap;
    this.qimei = paramString6;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof ClientContext)) {
      return false;
    }
    paramObject = (ClientContext)paramObject;
    return (JceUtil.equals(this.userId, paramObject.userId)) && (JceUtil.equals(this.sessionId, paramObject.sessionId)) && (JceUtil.equals(this.remoteAddress, paramObject.remoteAddress)) && (JceUtil.equals(this.deviceId, paramObject.deviceId)) && (JceUtil.equals(this.hostname, paramObject.hostname)) && (JceUtil.equals(this.properties, paramObject.properties)) && (JceUtil.equals(this.qimei, paramObject.qimei));
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getHostname()
  {
    return this.hostname;
  }
  
  public Map<String, String> getProperties()
  {
    return this.properties;
  }
  
  public String getQimei()
  {
    return this.qimei;
  }
  
  public String getRemoteAddress()
  {
    return this.remoteAddress;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userId = paramJceInputStream.readString(0, false);
    this.sessionId = paramJceInputStream.readString(1, false);
    this.remoteAddress = paramJceInputStream.readString(2, false);
    this.deviceId = paramJceInputStream.readString(3, false);
    this.hostname = paramJceInputStream.readString(4, false);
    this.properties = ((Map)paramJceInputStream.read(cache_properties, 5, false));
    this.qimei = paramJceInputStream.readString(6, false);
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setHostname(String paramString)
  {
    this.hostname = paramString;
  }
  
  public void setProperties(Map<String, String> paramMap)
  {
    this.properties = paramMap;
  }
  
  public void setQimei(String paramString)
  {
    this.qimei = paramString;
  }
  
  public void setRemoteAddress(String paramString)
  {
    this.remoteAddress = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.userId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sessionId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.remoteAddress;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.deviceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.hostname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.properties;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    localObject = this.qimei;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.ClientContext
 * JD-Core Version:    0.7.0.1
 */