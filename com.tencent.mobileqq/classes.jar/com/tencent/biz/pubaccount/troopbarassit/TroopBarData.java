package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class TroopBarData
  extends Entity
{
  public boolean mIsSticky = false;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @notColumn
  public MessageRecord mLatestMessage;
  @unique
  public String mUin;
  
  public String getTableName()
  {
    return super.getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarData
 * JD-Core Version:    0.7.0.1
 */