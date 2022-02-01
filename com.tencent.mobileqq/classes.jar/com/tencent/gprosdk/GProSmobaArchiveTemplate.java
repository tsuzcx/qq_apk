package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProSmobaArchiveTemplate
{
  final String mGoodBranch;
  final ArrayList<String> mGoodHeroIconList;
  final int mGradeLevel;
  final String mMvpNum;
  final int mStarCnt;
  final String mWinNum;
  final String mWinRate;
  
  public GProSmobaArchiveTemplate(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList)
  {
    this.mGradeLevel = paramInt1;
    this.mStarCnt = paramInt2;
    this.mWinNum = paramString1;
    this.mMvpNum = paramString2;
    this.mWinRate = paramString3;
    this.mGoodBranch = paramString4;
    this.mGoodHeroIconList = paramArrayList;
  }
  
  public String getGoodBranch()
  {
    return this.mGoodBranch;
  }
  
  public ArrayList<String> getGoodHeroIconList()
  {
    return this.mGoodHeroIconList;
  }
  
  public int getGradeLevel()
  {
    return this.mGradeLevel;
  }
  
  public String getMvpNum()
  {
    return this.mMvpNum;
  }
  
  public int getStarCnt()
  {
    return this.mStarCnt;
  }
  
  public String getWinNum()
  {
    return this.mWinNum;
  }
  
  public String getWinRate()
  {
    return this.mWinRate;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSmobaArchiveTemplate{mGradeLevel=");
    localStringBuilder.append(this.mGradeLevel);
    localStringBuilder.append(",mStarCnt=");
    localStringBuilder.append(this.mStarCnt);
    localStringBuilder.append(",mWinNum=");
    localStringBuilder.append(this.mWinNum);
    localStringBuilder.append(",mMvpNum=");
    localStringBuilder.append(this.mMvpNum);
    localStringBuilder.append(",mWinRate=");
    localStringBuilder.append(this.mWinRate);
    localStringBuilder.append(",mGoodBranch=");
    localStringBuilder.append(this.mGoodBranch);
    localStringBuilder.append(",mGoodHeroIconList=");
    localStringBuilder.append(this.mGoodHeroIconList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProSmobaArchiveTemplate
 * JD-Core Version:    0.7.0.1
 */