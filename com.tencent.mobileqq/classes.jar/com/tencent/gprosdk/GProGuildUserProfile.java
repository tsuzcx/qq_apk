package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProGuildUserProfile
{
  final byte mAge;
  final int mAvatarSizeFlag;
  final long mAvatarTimeStamp;
  final String mAvatarUrl;
  final short mBirthDay;
  final short mBirthMouth;
  final short mBirthYear;
  final String mCity;
  final int mCityId;
  final int mCityZoneId;
  final ArrayList<GProClientAccount> mClientAccount;
  final ArrayList<GProClientArchive> mClientArchives;
  final int mClientId;
  final GProClientPresence mClientPresence;
  final String mCountry;
  final int mCountryId;
  final String mDesc;
  final int mGender;
  final boolean mIsNlAge;
  final boolean mIsNlBirthday;
  final long mJoinTime;
  final String mMemberName;
  final String mNick;
  final String mProvince;
  final int mProvinceId;
  final int mRobotType;
  final long mTinyId;
  final int mUserType;
  final int mVerifyFriType;
  
  public GProGuildUserProfile(long paramLong1, String paramString1, int paramInt1, long paramLong2, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, byte paramByte, boolean paramBoolean2, short paramShort1, short paramShort2, short paramShort3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong3, int paramInt9, String paramString6, int paramInt10, String paramString7, GProClientPresence paramGProClientPresence, ArrayList<GProClientArchive> paramArrayList, ArrayList<GProClientAccount> paramArrayList1)
  {
    this.mTinyId = paramLong1;
    this.mAvatarUrl = paramString1;
    this.mAvatarSizeFlag = paramInt1;
    this.mAvatarTimeStamp = paramLong2;
    this.mNick = paramString2;
    this.mVerifyFriType = paramInt2;
    this.mGender = paramInt3;
    this.mIsNlAge = paramBoolean1;
    this.mAge = paramByte;
    this.mIsNlBirthday = paramBoolean2;
    this.mBirthYear = paramShort1;
    this.mBirthMouth = paramShort2;
    this.mBirthDay = paramShort3;
    this.mCountry = paramString3;
    this.mProvince = paramString4;
    this.mCity = paramString5;
    this.mCountryId = paramInt4;
    this.mProvinceId = paramInt5;
    this.mCityId = paramInt6;
    this.mCityZoneId = paramInt7;
    this.mUserType = paramInt8;
    this.mJoinTime = paramLong3;
    this.mRobotType = paramInt9;
    this.mMemberName = paramString6;
    this.mClientId = paramInt10;
    this.mDesc = paramString7;
    this.mClientPresence = paramGProClientPresence;
    this.mClientArchives = paramArrayList;
    this.mClientAccount = paramArrayList1;
  }
  
  public byte getAge()
  {
    return this.mAge;
  }
  
  public int getAvatarSizeFlag()
  {
    return this.mAvatarSizeFlag;
  }
  
  public long getAvatarTimeStamp()
  {
    return this.mAvatarTimeStamp;
  }
  
  public String getAvatarUrl()
  {
    return this.mAvatarUrl;
  }
  
  public short getBirthDay()
  {
    return this.mBirthDay;
  }
  
  public short getBirthMouth()
  {
    return this.mBirthMouth;
  }
  
  public short getBirthYear()
  {
    return this.mBirthYear;
  }
  
  public String getCity()
  {
    return this.mCity;
  }
  
  public int getCityId()
  {
    return this.mCityId;
  }
  
  public int getCityZoneId()
  {
    return this.mCityZoneId;
  }
  
  public ArrayList<GProClientAccount> getClientAccount()
  {
    return this.mClientAccount;
  }
  
  public ArrayList<GProClientArchive> getClientArchives()
  {
    return this.mClientArchives;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public GProClientPresence getClientPresence()
  {
    return this.mClientPresence;
  }
  
  public String getCountry()
  {
    return this.mCountry;
  }
  
  public int getCountryId()
  {
    return this.mCountryId;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public int getGender()
  {
    return this.mGender;
  }
  
  public boolean getIsNlAge()
  {
    return this.mIsNlAge;
  }
  
  public boolean getIsNlBirthday()
  {
    return this.mIsNlBirthday;
  }
  
  public long getJoinTime()
  {
    return this.mJoinTime;
  }
  
  public String getMemberName()
  {
    return this.mMemberName;
  }
  
  public String getNick()
  {
    return this.mNick;
  }
  
  public String getProvince()
  {
    return this.mProvince;
  }
  
  public int getProvinceId()
  {
    return this.mProvinceId;
  }
  
  public int getRobotType()
  {
    return this.mRobotType;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public int getUserType()
  {
    return this.mUserType;
  }
  
  public int getVerifyFriType()
  {
    return this.mVerifyFriType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildUserProfile{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mAvatarUrl=");
    localStringBuilder.append(this.mAvatarUrl);
    localStringBuilder.append(",mAvatarSizeFlag=");
    localStringBuilder.append(this.mAvatarSizeFlag);
    localStringBuilder.append(",mAvatarTimeStamp=");
    localStringBuilder.append(this.mAvatarTimeStamp);
    localStringBuilder.append(",mNick=");
    localStringBuilder.append(this.mNick);
    localStringBuilder.append(",mVerifyFriType=");
    localStringBuilder.append(this.mVerifyFriType);
    localStringBuilder.append(",mGender=");
    localStringBuilder.append(this.mGender);
    localStringBuilder.append(",mIsNlAge=");
    localStringBuilder.append(this.mIsNlAge);
    localStringBuilder.append(",mAge=");
    localStringBuilder.append(this.mAge);
    localStringBuilder.append(",mIsNlBirthday=");
    localStringBuilder.append(this.mIsNlBirthday);
    localStringBuilder.append(",mBirthYear=");
    localStringBuilder.append(this.mBirthYear);
    localStringBuilder.append(",mBirthMouth=");
    localStringBuilder.append(this.mBirthMouth);
    localStringBuilder.append(",mBirthDay=");
    localStringBuilder.append(this.mBirthDay);
    localStringBuilder.append(",mCountry=");
    localStringBuilder.append(this.mCountry);
    localStringBuilder.append(",mProvince=");
    localStringBuilder.append(this.mProvince);
    localStringBuilder.append(",mCity=");
    localStringBuilder.append(this.mCity);
    localStringBuilder.append(",mCountryId=");
    localStringBuilder.append(this.mCountryId);
    localStringBuilder.append(",mProvinceId=");
    localStringBuilder.append(this.mProvinceId);
    localStringBuilder.append(",mCityId=");
    localStringBuilder.append(this.mCityId);
    localStringBuilder.append(",mCityZoneId=");
    localStringBuilder.append(this.mCityZoneId);
    localStringBuilder.append(",mUserType=");
    localStringBuilder.append(this.mUserType);
    localStringBuilder.append(",mJoinTime=");
    localStringBuilder.append(this.mJoinTime);
    localStringBuilder.append(",mRobotType=");
    localStringBuilder.append(this.mRobotType);
    localStringBuilder.append(",mMemberName=");
    localStringBuilder.append(this.mMemberName);
    localStringBuilder.append(",mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mDesc=");
    localStringBuilder.append(this.mDesc);
    localStringBuilder.append(",mClientPresence=");
    localStringBuilder.append(this.mClientPresence);
    localStringBuilder.append(",mClientArchives=");
    localStringBuilder.append(this.mClientArchives);
    localStringBuilder.append(",mClientAccount=");
    localStringBuilder.append(this.mClientAccount);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildUserProfile
 * JD-Core Version:    0.7.0.1
 */