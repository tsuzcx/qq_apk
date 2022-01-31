package com.tencent.biz.pubaccount.troopbarassit;

import awbv;
import awdg;
import awdj;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopBarData
  extends awbv
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @awdg
  public MessageRecord mLatestMessage;
  @awdj
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