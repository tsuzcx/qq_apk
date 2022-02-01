package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public class QueryProductSetResp
  extends JceStruct
{
  static AccessSet cache_data = new AccessSet();
  public int code = 0;
  public AccessSet data = null;
  public String msg = "";
  
  public QueryProductSetResp() {}
  
  public QueryProductSetResp(int paramInt, String paramString, AccessSet paramAccessSet)
  {
    this.code = paramInt;
    this.msg = paramString;
    this.data = paramAccessSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof QueryProductSetResp)) {
      return false;
    }
    paramObject = (QueryProductSetResp)paramObject;
    return (JceUtil.equals(this.code, paramObject.code)) && (JceUtil.equals(this.msg, paramObject.msg)) && (JceUtil.equals(this.data, paramObject.data));
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public AccessSet getData()
  {
    return this.data;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.data = ((AccessSet)paramJceInputStream.read(cache_data, 2, false));
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setData(AccessSet paramAccessSet)
  {
    this.data = paramAccessSet;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    paramJceOutputStream.write(this.msg, 1);
    AccessSet localAccessSet = this.data;
    if (localAccessSet != null) {
      paramJceOutputStream.write(localAccessSet, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.QueryProductSetResp
 * JD-Core Version:    0.7.0.1
 */