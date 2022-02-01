package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public class QueryProductSetReq
  extends JceStruct
{
  public String productId = "";
  
  public QueryProductSetReq() {}
  
  public QueryProductSetReq(String paramString)
  {
    this.productId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof QueryProductSetReq)) {
      return false;
    }
    paramObject = (QueryProductSetReq)paramObject;
    return JceUtil.equals(this.productId, paramObject.productId);
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.productId = paramJceInputStream.readString(0, true);
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.productId, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.QueryProductSetReq
 * JD-Core Version:    0.7.0.1
 */