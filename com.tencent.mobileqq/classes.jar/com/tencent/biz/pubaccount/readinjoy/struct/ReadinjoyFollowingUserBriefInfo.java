package com.tencent.biz.pubaccount.readinjoy.struct;

import atmo;
import atoc;

public class ReadinjoyFollowingUserBriefInfo
  extends atmo
{
  public int followed = 0;
  @atoc
  public long uin;
  
  public ReadinjoyFollowingUserBriefInfo()
  {
    this.uin = 0L;
  }
  
  public ReadinjoyFollowingUserBriefInfo(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.followed = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyFollowingUserBriefInfo
 * JD-Core Version:    0.7.0.1
 */