package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public class QueryFeatureReq
  extends JceStruct
{
  static ClientContext cache_clientCtx = new ClientContext();
  static ExtendInfo cache_extendInfo = new ExtendInfo();
  static ArrayList<Integer> cache_localIdList = new ArrayList();
  public ClientContext clientCtx = null;
  public ExtendInfo extendInfo = null;
  public ArrayList<Integer> localIdList = null;
  public String moduleId = "";
  public String moduleVersion = "";
  public String productId = "";
  public long timestamp = 0L;
  
  static
  {
    cache_localIdList.add(Integer.valueOf(0));
  }
  
  public QueryFeatureReq() {}
  
  public QueryFeatureReq(String paramString1, String paramString2, String paramString3, ClientContext paramClientContext, ExtendInfo paramExtendInfo, long paramLong, ArrayList<Integer> paramArrayList)
  {
    this.productId = paramString1;
    this.moduleId = paramString2;
    this.moduleVersion = paramString3;
    this.clientCtx = paramClientContext;
    this.extendInfo = paramExtendInfo;
    this.timestamp = paramLong;
    this.localIdList = paramArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof QueryFeatureReq)) {
      return false;
    }
    paramObject = (QueryFeatureReq)paramObject;
    return (JceUtil.equals(this.productId, paramObject.productId)) && (JceUtil.equals(this.moduleId, paramObject.moduleId)) && (JceUtil.equals(this.moduleVersion, paramObject.moduleVersion)) && (JceUtil.equals(this.clientCtx, paramObject.clientCtx)) && (JceUtil.equals(this.extendInfo, paramObject.extendInfo)) && (JceUtil.equals(this.timestamp, paramObject.timestamp)) && (JceUtil.equals(this.localIdList, paramObject.localIdList));
  }
  
  public ClientContext getClientCtx()
  {
    return this.clientCtx;
  }
  
  public ExtendInfo getExtendInfo()
  {
    return this.extendInfo;
  }
  
  public ArrayList<Integer> getLocalIdList()
  {
    return this.localIdList;
  }
  
  public String getModuleId()
  {
    return this.moduleId;
  }
  
  public String getModuleVersion()
  {
    return this.moduleVersion;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.productId = paramJceInputStream.readString(0, true);
    this.moduleId = paramJceInputStream.readString(1, true);
    this.moduleVersion = paramJceInputStream.readString(2, true);
    this.clientCtx = ((ClientContext)paramJceInputStream.read(cache_clientCtx, 3, false));
    this.extendInfo = ((ExtendInfo)paramJceInputStream.read(cache_extendInfo, 4, false));
    this.timestamp = paramJceInputStream.read(this.timestamp, 5, false);
    cache_localIdList = (ArrayList)paramJceInputStream.read(cache_localIdList, 6, false);
  }
  
  public void setClientCtx(ClientContext paramClientContext)
  {
    this.clientCtx = paramClientContext;
  }
  
  public void setExtendInfo(ExtendInfo paramExtendInfo)
  {
    this.extendInfo = paramExtendInfo;
  }
  
  public void setLocalIdList(ArrayList<Integer> paramArrayList)
  {
    this.localIdList = paramArrayList;
  }
  
  public void setModuleId(String paramString)
  {
    this.moduleId = paramString;
  }
  
  public void setModuleVersion(String paramString)
  {
    this.moduleVersion = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.productId, 0);
    paramJceOutputStream.write(this.moduleId, 1);
    paramJceOutputStream.write(this.moduleVersion, 2);
    Object localObject = this.clientCtx;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.extendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.timestamp, 5);
    localObject = this.localIdList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.models.QueryFeatureReq
 * JD-Core Version:    0.7.0.1
 */