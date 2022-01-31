package com.tencent.biz.pubaccount.troopbarassit;

import awge;
import awhp;
import awhs;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopBarData
  extends awge
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @awhp
  public MessageRecord mLatestMessage;
  @awhs
  public String mUin;
  
  public String getTableName()
  {
    return super.getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarData
 * JD-Core Version:    0.7.0.1
 */