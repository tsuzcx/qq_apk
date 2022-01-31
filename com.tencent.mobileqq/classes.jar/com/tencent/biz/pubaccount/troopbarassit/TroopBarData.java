package com.tencent.biz.pubaccount.troopbarassit;

import aukm;
import aulx;
import auma;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopBarData
  extends aukm
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @aulx
  public MessageRecord mLatestMessage;
  @auma
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