package com.tencent.biz.videostory.db;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class WSPersonalEntity
  extends Entity
{
  @unique
  public String uin;
  public byte[] weiShiPersonalRsp = null;
  
  public void updateWeiShiFeedListEntity(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      this.uin = paramString;
      this.weiShiPersonalRsp = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.db.WSPersonalEntity
 * JD-Core Version:    0.7.0.1
 */