package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public class AccessSet
  extends JceStruct
{
  public String l5CmdId = "";
  public String l5ModId = "";
  public String setName = "";
  
  public AccessSet() {}
  
  public AccessSet(String paramString1, String paramString2, String paramString3)
  {
    this.setName = paramString1;
    this.l5ModId = paramString2;
    this.l5CmdId = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof AccessSet)) {
      return false;
    }
    paramObject = (AccessSet)paramObject;
    return (JceUtil.equals(this.setName, paramObject.setName)) && (JceUtil.equals(this.l5ModId, paramObject.l5ModId)) && (JceUtil.equals(this.l5CmdId, paramObject.l5CmdId));
  }
  
  public String getL5CmdId()
  {
    return this.l5CmdId;
  }
  
  public String getL5ModId()
  {
    return this.l5ModId;
  }
  
  public String getSetName()
  {
    return this.setName;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.setName = paramJceInputStream.readString(0, false);
    this.l5ModId = paramJceInputStream.readString(1, false);
    this.l5CmdId = paramJceInputStream.readString(2, false);
  }
  
  public void setL5CmdId(String paramString)
  {
    this.l5CmdId = paramString;
  }
  
  public void setL5ModId(String paramString)
  {
    this.l5ModId = paramString;
  }
  
  public void setSetName(String paramString)
  {
    this.setName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.setName;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.l5ModId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.l5CmdId;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.AccessSet
 * JD-Core Version:    0.7.0.1
 */