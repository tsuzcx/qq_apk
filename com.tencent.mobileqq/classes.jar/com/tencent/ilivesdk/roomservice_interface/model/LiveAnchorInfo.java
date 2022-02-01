package com.tencent.ilivesdk.roomservice_interface.model;

import android.text.TextUtils;

public class LiveAnchorInfo
{
  public String businessUid;
  public long explicitId;
  public String headUrl;
  public long imsdkTinyId;
  public int initialClientType;
  public String nickName;
  public long uid;
  
  public String getHeadUrl()
  {
    if (TextUtils.isEmpty(this.headUrl)) {
      return "";
    }
    return this.headUrl;
  }
  
  public String getNickName()
  {
    if (TextUtils.isEmpty(this.nickName)) {
      return "";
    }
    return this.nickName.trim();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveAnchorInfo is [uid= ");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(";explicitId=");
    localStringBuilder.append(this.explicitId);
    localStringBuilder.append(";nickName=");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append(";headUrl=");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append(";businessUid=");
    localStringBuilder.append(this.businessUid);
    localStringBuilder.append(";initialClientType=");
    localStringBuilder.append(this.initialClientType);
    localStringBuilder.append(";imsdkTinyId=");
    localStringBuilder.append(this.imsdkTinyId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo
 * JD-Core Version:    0.7.0.1
 */