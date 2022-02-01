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
    return "LiveAnchorInfo is [uid= " + this.uid + ";explicitId=" + this.explicitId + ";nickName=" + this.nickName + ";headUrl=" + this.headUrl + ";businessUid=" + this.businessUid + ";initialClientType=" + this.initialClientType + ";imsdkTinyId=" + this.imsdkTinyId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo
 * JD-Core Version:    0.7.0.1
 */