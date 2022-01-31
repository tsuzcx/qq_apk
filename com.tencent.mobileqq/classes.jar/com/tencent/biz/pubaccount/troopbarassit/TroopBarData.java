package com.tencent.biz.pubaccount.troopbarassit;

import atmo;
import atnz;
import atoc;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopBarData
  extends atmo
{
  public boolean mIsSticky;
  public long mLastDraftTime;
  public long mLastMsgTime;
  public long mLastStickyTime;
  @atnz
  public MessageRecord mLatestMessage;
  @atoc
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