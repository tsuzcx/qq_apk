package com.tencent.biz.videostory.db;

import awge;
import awhs;

public class WSPersonalEntity
  extends awge
{
  @awhs
  public String uin;
  public byte[] weiShiPersonalRsp;
  
  public void updateWeiShiFeedListEntity(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    this.uin = paramString;
    this.weiShiPersonalRsp = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.db.WSPersonalEntity
 * JD-Core Version:    0.7.0.1
 */