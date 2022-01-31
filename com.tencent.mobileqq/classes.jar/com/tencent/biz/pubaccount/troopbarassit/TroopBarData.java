package com.tencent.biz.pubaccount.troopbarassit;

import auko;
import aulz;
import aumc;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopBarData
  extends auko
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @aulz
  public MessageRecord mLatestMessage;
  @aumc
  public String mUin;
  
  public String getTableName()
  {
    return super.getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarData
 * JD-Core Version:    0.7.0.1
 */