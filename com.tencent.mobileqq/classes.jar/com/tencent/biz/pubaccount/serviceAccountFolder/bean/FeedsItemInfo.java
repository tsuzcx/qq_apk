package com.tencent.biz.pubaccount.serviceAccountFolder.bean;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem;

public class FeedsItemInfo
{
  public String a;
  public CertifiedAccountRead.GetPortalRsp.RoomItem b;
  public boolean c;
  
  public FeedsItemInfo(String paramString, CertifiedAccountRead.GetPortalRsp.RoomItem paramRoomItem)
  {
    this.a = paramString;
    this.b = paramRoomItem;
    this.c = false;
  }
  
  public FeedsItemInfo(String paramString, CertifiedAccountRead.GetPortalRsp.RoomItem paramRoomItem, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramRoomItem;
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.bean.FeedsItemInfo
 * JD-Core Version:    0.7.0.1
 */