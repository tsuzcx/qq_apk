package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProNotice
{
  final ArrayList<GProNoticeAction> mActionList;
  final ArrayList<GProNoticeText> mComment;
  final GProNoticeCover mCover;
  final int mCreateTs;
  final int mExpireTs;
  final long mGuildId;
  final int mHandleTs;
  final String mJoinSign;
  final String mNoticeId;
  final ArrayList<GProNoticeText> mSubTitle;
  final int mTemplateId;
  final ArrayList<GProNoticeText> mTitle;
  
  public GProNotice(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList<GProNoticeText> paramArrayList1, ArrayList<GProNoticeText> paramArrayList2, ArrayList<GProNoticeText> paramArrayList3, GProNoticeCover paramGProNoticeCover, ArrayList<GProNoticeAction> paramArrayList, String paramString2)
  {
    this.mNoticeId = paramString1;
    this.mTemplateId = paramInt1;
    this.mCreateTs = paramInt2;
    this.mExpireTs = paramInt3;
    this.mHandleTs = paramInt4;
    this.mGuildId = paramLong;
    this.mTitle = paramArrayList1;
    this.mSubTitle = paramArrayList2;
    this.mComment = paramArrayList3;
    this.mCover = paramGProNoticeCover;
    this.mActionList = paramArrayList;
    this.mJoinSign = paramString2;
  }
  
  public ArrayList<GProNoticeAction> getActionList()
  {
    return this.mActionList;
  }
  
  public ArrayList<GProNoticeText> getComment()
  {
    return this.mComment;
  }
  
  public GProNoticeCover getCover()
  {
    return this.mCover;
  }
  
  public int getCreateTs()
  {
    return this.mCreateTs;
  }
  
  public int getExpireTs()
  {
    return this.mExpireTs;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public int getHandleTs()
  {
    return this.mHandleTs;
  }
  
  public String getJoinSign()
  {
    return this.mJoinSign;
  }
  
  public String getNoticeId()
  {
    return this.mNoticeId;
  }
  
  public ArrayList<GProNoticeText> getSubTitle()
  {
    return this.mSubTitle;
  }
  
  public int getTemplateId()
  {
    return this.mTemplateId;
  }
  
  public ArrayList<GProNoticeText> getTitle()
  {
    return this.mTitle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProNotice{mNoticeId=");
    localStringBuilder.append(this.mNoticeId);
    localStringBuilder.append(",mTemplateId=");
    localStringBuilder.append(this.mTemplateId);
    localStringBuilder.append(",mCreateTs=");
    localStringBuilder.append(this.mCreateTs);
    localStringBuilder.append(",mExpireTs=");
    localStringBuilder.append(this.mExpireTs);
    localStringBuilder.append(",mHandleTs=");
    localStringBuilder.append(this.mHandleTs);
    localStringBuilder.append(",mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mTitle=");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append(",mSubTitle=");
    localStringBuilder.append(this.mSubTitle);
    localStringBuilder.append(",mComment=");
    localStringBuilder.append(this.mComment);
    localStringBuilder.append(",mCover=");
    localStringBuilder.append(this.mCover);
    localStringBuilder.append(",mActionList=");
    localStringBuilder.append(this.mActionList);
    localStringBuilder.append(",mJoinSign=");
    localStringBuilder.append(this.mJoinSign);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProNotice
 * JD-Core Version:    0.7.0.1
 */