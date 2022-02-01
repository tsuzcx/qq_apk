package com.tencent.gprosdk;

import java.io.Serializable;
import java.util.ArrayList;

public final class GProChannel
  implements Serializable
{
  long mAnchorTinyId;
  int mBannedSpeak;
  long mChannelId;
  int mChannelMaxMember;
  long mCreateTime;
  long mCreatorTinyId;
  int mFinalNotifyType;
  long mGuildId;
  long mLastCntMsgSeq;
  long mLastCntMsgTime;
  long mLastMsgSeq;
  long mLastMsgTime;
  byte[] mMsgMeta;
  int mMsgNotifyType;
  int mMyMsgNotifyType;
  String mName;
  long mReadCntMsgSeq;
  long mReadCntMsgTime;
  byte[] mReadMsgMeta;
  long mReadMsgSeq;
  long mReadMsgTime;
  int mResult;
  long mRoomId;
  String mRoomName;
  ArrayList<Integer> mSpecialTypes;
  int mTalkPermission;
  int mType;
  int mVisibleType;
  long serialVersionUID = 1L;
  
  public GProChannel(long paramLong1, long paramLong2, String paramString1, int paramInt1, long paramLong3, long paramLong4, int paramInt2, int paramInt3, int paramInt4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, long paramLong13, long paramLong14, String paramString2, int paramInt7, int paramInt8, ArrayList<Integer> paramArrayList, int paramInt9)
  {
    this.mChannelId = paramLong1;
    this.mGuildId = paramLong2;
    this.mName = paramString1;
    this.mType = paramInt1;
    this.mCreatorTinyId = paramLong3;
    this.mCreateTime = paramLong4;
    this.mTalkPermission = paramInt2;
    this.mMsgNotifyType = paramInt3;
    this.mMyMsgNotifyType = paramInt4;
    this.mLastMsgSeq = paramLong5;
    this.mLastCntMsgSeq = paramLong6;
    this.mReadMsgSeq = paramLong7;
    this.mReadCntMsgSeq = paramLong8;
    this.mLastMsgTime = paramLong9;
    this.mLastCntMsgTime = paramLong10;
    this.mReadMsgTime = paramLong11;
    this.mReadCntMsgTime = paramLong12;
    this.mMsgMeta = paramArrayOfByte1;
    this.mReadMsgMeta = paramArrayOfByte2;
    this.mResult = paramInt5;
    this.mChannelMaxMember = paramInt6;
    this.mRoomId = paramLong13;
    this.mAnchorTinyId = paramLong14;
    this.mRoomName = paramString2;
    this.mBannedSpeak = paramInt7;
    this.mVisibleType = paramInt8;
    this.mSpecialTypes = paramArrayList;
    this.mFinalNotifyType = paramInt9;
  }
  
  public long getAnchorTinyId()
  {
    return this.mAnchorTinyId;
  }
  
  public int getBannedSpeak()
  {
    return this.mBannedSpeak;
  }
  
  public long getChannelId()
  {
    return this.mChannelId;
  }
  
  public int getChannelMaxMember()
  {
    return this.mChannelMaxMember;
  }
  
  public long getCreateTime()
  {
    return this.mCreateTime;
  }
  
  public long getCreatorTinyId()
  {
    return this.mCreatorTinyId;
  }
  
  public int getFinalNotifyType()
  {
    return this.mFinalNotifyType;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public long getLastCntMsgSeq()
  {
    return this.mLastCntMsgSeq;
  }
  
  public long getLastCntMsgTime()
  {
    return this.mLastCntMsgTime;
  }
  
  public long getLastMsgSeq()
  {
    return this.mLastMsgSeq;
  }
  
  public long getLastMsgTime()
  {
    return this.mLastMsgTime;
  }
  
  public byte[] getMsgMeta()
  {
    return this.mMsgMeta;
  }
  
  public int getMsgNotifyType()
  {
    return this.mMsgNotifyType;
  }
  
  public int getMyMsgNotifyType()
  {
    return this.mMyMsgNotifyType;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getReadCntMsgSeq()
  {
    return this.mReadCntMsgSeq;
  }
  
  public long getReadCntMsgTime()
  {
    return this.mReadCntMsgTime;
  }
  
  public byte[] getReadMsgMeta()
  {
    return this.mReadMsgMeta;
  }
  
  public long getReadMsgSeq()
  {
    return this.mReadMsgSeq;
  }
  
  public long getReadMsgTime()
  {
    return this.mReadMsgTime;
  }
  
  public int getResult()
  {
    return this.mResult;
  }
  
  public long getRoomId()
  {
    return this.mRoomId;
  }
  
  public String getRoomName()
  {
    return this.mRoomName;
  }
  
  public ArrayList<Integer> getSpecialTypes()
  {
    return this.mSpecialTypes;
  }
  
  public int getTalkPermission()
  {
    return this.mTalkPermission;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public int getVisibleType()
  {
    return this.mVisibleType;
  }
  
  public void setAnchorTinyId(long paramLong)
  {
    this.mAnchorTinyId = paramLong;
  }
  
  public void setBannedSpeak(int paramInt)
  {
    this.mBannedSpeak = paramInt;
  }
  
  public void setChannelId(long paramLong)
  {
    this.mChannelId = paramLong;
  }
  
  public void setChannelMaxMember(int paramInt)
  {
    this.mChannelMaxMember = paramInt;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.mCreateTime = paramLong;
  }
  
  public void setCreatorTinyId(long paramLong)
  {
    this.mCreatorTinyId = paramLong;
  }
  
  public void setFinalNotifyType(int paramInt)
  {
    this.mFinalNotifyType = paramInt;
  }
  
  public void setGuildId(long paramLong)
  {
    this.mGuildId = paramLong;
  }
  
  public void setLastCntMsgSeq(long paramLong)
  {
    this.mLastCntMsgSeq = paramLong;
  }
  
  public void setLastCntMsgTime(long paramLong)
  {
    this.mLastCntMsgTime = paramLong;
  }
  
  public void setLastMsgSeq(long paramLong)
  {
    this.mLastMsgSeq = paramLong;
  }
  
  public void setLastMsgTime(long paramLong)
  {
    this.mLastMsgTime = paramLong;
  }
  
  public void setMsgMeta(byte[] paramArrayOfByte)
  {
    this.mMsgMeta = paramArrayOfByte;
  }
  
  public void setMsgNotifyType(int paramInt)
  {
    this.mMsgNotifyType = paramInt;
  }
  
  public void setMyMsgNotifyType(int paramInt)
  {
    this.mMyMsgNotifyType = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setReadCntMsgSeq(long paramLong)
  {
    this.mReadCntMsgSeq = paramLong;
  }
  
  public void setReadCntMsgTime(long paramLong)
  {
    this.mReadCntMsgTime = paramLong;
  }
  
  public void setReadMsgMeta(byte[] paramArrayOfByte)
  {
    this.mReadMsgMeta = paramArrayOfByte;
  }
  
  public void setReadMsgSeq(long paramLong)
  {
    this.mReadMsgSeq = paramLong;
  }
  
  public void setReadMsgTime(long paramLong)
  {
    this.mReadMsgTime = paramLong;
  }
  
  public void setResult(int paramInt)
  {
    this.mResult = paramInt;
  }
  
  public void setRoomId(long paramLong)
  {
    this.mRoomId = paramLong;
  }
  
  public void setRoomName(String paramString)
  {
    this.mRoomName = paramString;
  }
  
  public void setSpecialTypes(ArrayList<Integer> paramArrayList)
  {
    this.mSpecialTypes = paramArrayList;
  }
  
  public void setTalkPermission(int paramInt)
  {
    this.mTalkPermission = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setVisibleType(int paramInt)
  {
    this.mVisibleType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannel{mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(",mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mCreatorTinyId=");
    localStringBuilder.append(this.mCreatorTinyId);
    localStringBuilder.append(",mCreateTime=");
    localStringBuilder.append(this.mCreateTime);
    localStringBuilder.append(",mTalkPermission=");
    localStringBuilder.append(this.mTalkPermission);
    localStringBuilder.append(",mMsgNotifyType=");
    localStringBuilder.append(this.mMsgNotifyType);
    localStringBuilder.append(",mMyMsgNotifyType=");
    localStringBuilder.append(this.mMyMsgNotifyType);
    localStringBuilder.append(",mLastMsgSeq=");
    localStringBuilder.append(this.mLastMsgSeq);
    localStringBuilder.append(",mLastCntMsgSeq=");
    localStringBuilder.append(this.mLastCntMsgSeq);
    localStringBuilder.append(",mReadMsgSeq=");
    localStringBuilder.append(this.mReadMsgSeq);
    localStringBuilder.append(",mReadCntMsgSeq=");
    localStringBuilder.append(this.mReadCntMsgSeq);
    localStringBuilder.append(",mLastMsgTime=");
    localStringBuilder.append(this.mLastMsgTime);
    localStringBuilder.append(",mLastCntMsgTime=");
    localStringBuilder.append(this.mLastCntMsgTime);
    localStringBuilder.append(",mReadMsgTime=");
    localStringBuilder.append(this.mReadMsgTime);
    localStringBuilder.append(",mReadCntMsgTime=");
    localStringBuilder.append(this.mReadCntMsgTime);
    localStringBuilder.append(",mMsgMeta=");
    localStringBuilder.append(this.mMsgMeta);
    localStringBuilder.append(",mReadMsgMeta=");
    localStringBuilder.append(this.mReadMsgMeta);
    localStringBuilder.append(",mResult=");
    localStringBuilder.append(this.mResult);
    localStringBuilder.append(",mChannelMaxMember=");
    localStringBuilder.append(this.mChannelMaxMember);
    localStringBuilder.append(",mRoomId=");
    localStringBuilder.append(this.mRoomId);
    localStringBuilder.append(",mAnchorTinyId=");
    localStringBuilder.append(this.mAnchorTinyId);
    localStringBuilder.append(",mRoomName=");
    localStringBuilder.append(this.mRoomName);
    localStringBuilder.append(",mBannedSpeak=");
    localStringBuilder.append(this.mBannedSpeak);
    localStringBuilder.append(",mVisibleType=");
    localStringBuilder.append(this.mVisibleType);
    localStringBuilder.append(",mSpecialTypes=");
    localStringBuilder.append(this.mSpecialTypes);
    localStringBuilder.append(",mFinalNotifyType=");
    localStringBuilder.append(this.mFinalNotifyType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProChannel
 * JD-Core Version:    0.7.0.1
 */