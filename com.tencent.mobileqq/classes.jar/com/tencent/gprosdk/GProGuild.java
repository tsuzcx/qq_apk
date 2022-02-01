package com.tencent.gprosdk;

import java.io.Serializable;
import java.util.ArrayList;

public final class GProGuild
  implements Serializable
{
  ArrayList<Long> mAdminList;
  int mAdminMaxNum;
  long mAvatarSeq;
  boolean mChannelListChange;
  int mClientId;
  long mCoverSeq;
  long mCreateTime;
  long mCreatorTinyId;
  String mErrMsg;
  long mGuildId;
  int mGuildType;
  boolean mIsBanned;
  boolean mIsFrozen;
  int mIsMember;
  boolean mIsTop;
  boolean mIsValid;
  long mJoinTime;
  int mMedalLevel;
  String mName;
  String mProfile;
  int mResult;
  ArrayList<Long> mRobotList;
  int mRobotMaxNum;
  String mSearchJoinSig;
  long mShowNumber;
  long mU64channelSeq;
  long mU64guildSeq;
  int mUserMaxNum;
  int mUserNum;
  int mUserType;
  int mVisibleChannelMaxNum;
  long serialVersionUID = 1L;
  
  public GProGuild(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, boolean paramBoolean1, int paramInt3, long paramLong7, long paramLong8, ArrayList<Long> paramArrayList1, int paramInt4, ArrayList<Long> paramArrayList2, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, long paramLong9, int paramInt7, int paramInt8, String paramString4, int paramInt9, int paramInt10, int paramInt11)
  {
    this.mGuildId = paramLong1;
    this.mShowNumber = paramLong2;
    this.mGuildType = paramInt1;
    this.mName = paramString1;
    this.mProfile = paramString2;
    this.mAvatarSeq = paramLong3;
    this.mCreatorTinyId = paramLong4;
    this.mCreateTime = paramLong5;
    this.mJoinTime = paramLong6;
    this.mUserType = paramInt2;
    this.mIsTop = paramBoolean1;
    this.mUserNum = paramInt3;
    this.mU64guildSeq = paramLong7;
    this.mU64channelSeq = paramLong8;
    this.mAdminList = paramArrayList1;
    this.mAdminMaxNum = paramInt4;
    this.mRobotList = paramArrayList2;
    this.mRobotMaxNum = paramInt5;
    this.mUserMaxNum = paramInt6;
    this.mIsBanned = paramBoolean2;
    this.mIsFrozen = paramBoolean3;
    this.mIsValid = paramBoolean4;
    this.mSearchJoinSig = paramString3;
    this.mChannelListChange = paramBoolean5;
    this.mCoverSeq = paramLong9;
    this.mIsMember = paramInt7;
    this.mResult = paramInt8;
    this.mErrMsg = paramString4;
    this.mClientId = paramInt9;
    this.mVisibleChannelMaxNum = paramInt10;
    this.mMedalLevel = paramInt11;
  }
  
  public ArrayList<Long> getAdminList()
  {
    return this.mAdminList;
  }
  
  public int getAdminMaxNum()
  {
    return this.mAdminMaxNum;
  }
  
  public long getAvatarSeq()
  {
    return this.mAvatarSeq;
  }
  
  public boolean getChannelListChange()
  {
    return this.mChannelListChange;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public long getCoverSeq()
  {
    return this.mCoverSeq;
  }
  
  public long getCreateTime()
  {
    return this.mCreateTime;
  }
  
  public long getCreatorTinyId()
  {
    return this.mCreatorTinyId;
  }
  
  public String getErrMsg()
  {
    return this.mErrMsg;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public int getGuildType()
  {
    return this.mGuildType;
  }
  
  public boolean getIsBanned()
  {
    return this.mIsBanned;
  }
  
  public boolean getIsFrozen()
  {
    return this.mIsFrozen;
  }
  
  public int getIsMember()
  {
    return this.mIsMember;
  }
  
  public boolean getIsTop()
  {
    return this.mIsTop;
  }
  
  public boolean getIsValid()
  {
    return this.mIsValid;
  }
  
  public long getJoinTime()
  {
    return this.mJoinTime;
  }
  
  public int getMedalLevel()
  {
    return this.mMedalLevel;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getProfile()
  {
    return this.mProfile;
  }
  
  public int getResult()
  {
    return this.mResult;
  }
  
  public ArrayList<Long> getRobotList()
  {
    return this.mRobotList;
  }
  
  public int getRobotMaxNum()
  {
    return this.mRobotMaxNum;
  }
  
  public String getSearchJoinSig()
  {
    return this.mSearchJoinSig;
  }
  
  public long getShowNumber()
  {
    return this.mShowNumber;
  }
  
  public long getU64channelSeq()
  {
    return this.mU64channelSeq;
  }
  
  public long getU64guildSeq()
  {
    return this.mU64guildSeq;
  }
  
  public int getUserMaxNum()
  {
    return this.mUserMaxNum;
  }
  
  public int getUserNum()
  {
    return this.mUserNum;
  }
  
  public int getUserType()
  {
    return this.mUserType;
  }
  
  public int getVisibleChannelMaxNum()
  {
    return this.mVisibleChannelMaxNum;
  }
  
  public void setAdminList(ArrayList<Long> paramArrayList)
  {
    this.mAdminList = paramArrayList;
  }
  
  public void setAdminMaxNum(int paramInt)
  {
    this.mAdminMaxNum = paramInt;
  }
  
  public void setAvatarSeq(long paramLong)
  {
    this.mAvatarSeq = paramLong;
  }
  
  public void setChannelListChange(boolean paramBoolean)
  {
    this.mChannelListChange = paramBoolean;
  }
  
  public void setClientId(int paramInt)
  {
    this.mClientId = paramInt;
  }
  
  public void setCoverSeq(long paramLong)
  {
    this.mCoverSeq = paramLong;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.mCreateTime = paramLong;
  }
  
  public void setCreatorTinyId(long paramLong)
  {
    this.mCreatorTinyId = paramLong;
  }
  
  public void setErrMsg(String paramString)
  {
    this.mErrMsg = paramString;
  }
  
  public void setGuildId(long paramLong)
  {
    this.mGuildId = paramLong;
  }
  
  public void setGuildType(int paramInt)
  {
    this.mGuildType = paramInt;
  }
  
  public void setIsBanned(boolean paramBoolean)
  {
    this.mIsBanned = paramBoolean;
  }
  
  public void setIsFrozen(boolean paramBoolean)
  {
    this.mIsFrozen = paramBoolean;
  }
  
  public void setIsMember(int paramInt)
  {
    this.mIsMember = paramInt;
  }
  
  public void setIsTop(boolean paramBoolean)
  {
    this.mIsTop = paramBoolean;
  }
  
  public void setIsValid(boolean paramBoolean)
  {
    this.mIsValid = paramBoolean;
  }
  
  public void setJoinTime(long paramLong)
  {
    this.mJoinTime = paramLong;
  }
  
  public void setMedalLevel(int paramInt)
  {
    this.mMedalLevel = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setProfile(String paramString)
  {
    this.mProfile = paramString;
  }
  
  public void setResult(int paramInt)
  {
    this.mResult = paramInt;
  }
  
  public void setRobotList(ArrayList<Long> paramArrayList)
  {
    this.mRobotList = paramArrayList;
  }
  
  public void setRobotMaxNum(int paramInt)
  {
    this.mRobotMaxNum = paramInt;
  }
  
  public void setSearchJoinSig(String paramString)
  {
    this.mSearchJoinSig = paramString;
  }
  
  public void setShowNumber(long paramLong)
  {
    this.mShowNumber = paramLong;
  }
  
  public void setU64channelSeq(long paramLong)
  {
    this.mU64channelSeq = paramLong;
  }
  
  public void setU64guildSeq(long paramLong)
  {
    this.mU64guildSeq = paramLong;
  }
  
  public void setUserMaxNum(int paramInt)
  {
    this.mUserMaxNum = paramInt;
  }
  
  public void setUserNum(int paramInt)
  {
    this.mUserNum = paramInt;
  }
  
  public void setUserType(int paramInt)
  {
    this.mUserType = paramInt;
  }
  
  public void setVisibleChannelMaxNum(int paramInt)
  {
    this.mVisibleChannelMaxNum = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuild{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mShowNumber=");
    localStringBuilder.append(this.mShowNumber);
    localStringBuilder.append(",mGuildType=");
    localStringBuilder.append(this.mGuildType);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mProfile=");
    localStringBuilder.append(this.mProfile);
    localStringBuilder.append(",mAvatarSeq=");
    localStringBuilder.append(this.mAvatarSeq);
    localStringBuilder.append(",mCreatorTinyId=");
    localStringBuilder.append(this.mCreatorTinyId);
    localStringBuilder.append(",mCreateTime=");
    localStringBuilder.append(this.mCreateTime);
    localStringBuilder.append(",mJoinTime=");
    localStringBuilder.append(this.mJoinTime);
    localStringBuilder.append(",mUserType=");
    localStringBuilder.append(this.mUserType);
    localStringBuilder.append(",mIsTop=");
    localStringBuilder.append(this.mIsTop);
    localStringBuilder.append(",mUserNum=");
    localStringBuilder.append(this.mUserNum);
    localStringBuilder.append(",mU64guildSeq=");
    localStringBuilder.append(this.mU64guildSeq);
    localStringBuilder.append(",mU64channelSeq=");
    localStringBuilder.append(this.mU64channelSeq);
    localStringBuilder.append(",mAdminList=");
    localStringBuilder.append(this.mAdminList);
    localStringBuilder.append(",mAdminMaxNum=");
    localStringBuilder.append(this.mAdminMaxNum);
    localStringBuilder.append(",mRobotList=");
    localStringBuilder.append(this.mRobotList);
    localStringBuilder.append(",mRobotMaxNum=");
    localStringBuilder.append(this.mRobotMaxNum);
    localStringBuilder.append(",mUserMaxNum=");
    localStringBuilder.append(this.mUserMaxNum);
    localStringBuilder.append(",mIsBanned=");
    localStringBuilder.append(this.mIsBanned);
    localStringBuilder.append(",mIsFrozen=");
    localStringBuilder.append(this.mIsFrozen);
    localStringBuilder.append(",mIsValid=");
    localStringBuilder.append(this.mIsValid);
    localStringBuilder.append(",mSearchJoinSig=");
    localStringBuilder.append(this.mSearchJoinSig);
    localStringBuilder.append(",mChannelListChange=");
    localStringBuilder.append(this.mChannelListChange);
    localStringBuilder.append(",mCoverSeq=");
    localStringBuilder.append(this.mCoverSeq);
    localStringBuilder.append(",mIsMember=");
    localStringBuilder.append(this.mIsMember);
    localStringBuilder.append(",mResult=");
    localStringBuilder.append(this.mResult);
    localStringBuilder.append(",mErrMsg=");
    localStringBuilder.append(this.mErrMsg);
    localStringBuilder.append(",mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mVisibleChannelMaxNum=");
    localStringBuilder.append(this.mVisibleChannelMaxNum);
    localStringBuilder.append(",mMedalLevel=");
    localStringBuilder.append(this.mMedalLevel);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuild
 * JD-Core Version:    0.7.0.1
 */