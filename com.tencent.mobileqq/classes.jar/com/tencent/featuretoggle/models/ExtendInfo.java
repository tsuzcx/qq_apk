package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public class ExtendInfo
  extends JceStruct
{
  static Map<String, String> cache_properties = new HashMap();
  public String bundleId = "";
  public String channel = "";
  public String os = "";
  public String osVersion = "";
  public Map<String, String> properties = null;
  public String qua = "";
  public String sdkVersion = "";
  
  static
  {
    cache_properties.put("", "");
  }
  
  public ExtendInfo() {}
  
  public ExtendInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, String> paramMap)
  {
    this.bundleId = paramString1;
    this.qua = paramString2;
    this.channel = paramString3;
    this.os = paramString4;
    this.osVersion = paramString5;
    this.sdkVersion = paramString6;
    this.properties = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof ExtendInfo)) {
      return false;
    }
    paramObject = (ExtendInfo)paramObject;
    return (JceUtil.equals(this.bundleId, paramObject.bundleId)) && (JceUtil.equals(this.qua, paramObject.qua)) && (JceUtil.equals(this.channel, paramObject.channel)) && (JceUtil.equals(this.os, paramObject.os)) && (JceUtil.equals(this.osVersion, paramObject.osVersion)) && (JceUtil.equals(this.sdkVersion, paramObject.sdkVersion)) && (JceUtil.equals(this.properties, paramObject.properties));
  }
  
  public String getBundleId()
  {
    return this.bundleId;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public String getOs()
  {
    return this.os;
  }
  
  public String getOsVersion()
  {
    return this.osVersion;
  }
  
  public Map<String, String> getProperties()
  {
    return this.properties;
  }
  
  public String getQua()
  {
    return this.qua;
  }
  
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bundleId = paramJceInputStream.readString(0, false);
    this.qua = paramJceInputStream.readString(1, false);
    this.channel = paramJceInputStream.readString(2, false);
    this.os = paramJceInputStream.readString(3, false);
    this.osVersion = paramJceInputStream.readString(4, false);
    this.sdkVersion = paramJceInputStream.readString(5, false);
    this.properties = ((Map)paramJceInputStream.read(cache_properties, 6, false));
  }
  
  public void setBundleId(String paramString)
  {
    this.bundleId = paramString;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setOs(String paramString)
  {
    this.os = paramString;
  }
  
  public void setOsVersion(String paramString)
  {
    this.osVersion = paramString;
  }
  
  public void setProperties(Map<String, String> paramMap)
  {
    this.properties = paramMap;
  }
  
  public void setQua(String paramString)
  {
    this.qua = paramString;
  }
  
  public void setSdkVersion(String paramString)
  {
    this.sdkVersion = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.bundleId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.qua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.channel;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.os;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.osVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.sdkVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.properties;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.ExtendInfo
 * JD-Core Version:    0.7.0.1
 */