package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProChannelCreateInfo
{
  final long mAppid;
  final int mMsgNotifyType;
  final String mName;
  final int mTalkPermission;
  final int mType;
  final ArrayList<Long> mVisibleMemberList;
  final int mVisibleType;
  
  public GProChannelCreateInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, ArrayList<Long> paramArrayList)
  {
    this.mName = paramString;
    this.mType = paramInt1;
    this.mTalkPermission = paramInt2;
    this.mMsgNotifyType = paramInt3;
    this.mAppid = paramLong;
    this.mVisibleType = paramInt4;
    this.mVisibleMemberList = paramArrayList;
  }
  
  public long getAppid()
  {
    return this.mAppid;
  }
  
  public int getMsgNotifyType()
  {
    return this.mMsgNotifyType;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTalkPermission()
  {
    return this.mTalkPermission;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public ArrayList<Long> getVisibleMemberList()
  {
    return this.mVisibleMemberList;
  }
  
  public int getVisibleType()
  {
    return this.mVisibleType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannelCreateInfo{mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mTalkPermission=");
    localStringBuilder.append(this.mTalkPermission);
    localStringBuilder.append(",mMsgNotifyType=");
    localStringBuilder.append(this.mMsgNotifyType);
    localStringBuilder.append(",mAppid=");
    localStringBuilder.append(this.mAppid);
    localStringBuilder.append(",mVisibleType=");
    localStringBuilder.append(this.mVisibleType);
    localStringBuilder.append(",mVisibleMemberList=");
    localStringBuilder.append(this.mVisibleMemberList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProChannelCreateInfo
 * JD-Core Version:    0.7.0.1
 */