package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProCategoryChannelIdList
{
  final long mCategoryId;
  final ArrayList<Long> mChannelList;
  final String mName;
  
  public GProCategoryChannelIdList(String paramString, long paramLong, ArrayList<Long> paramArrayList)
  {
    this.mName = paramString;
    this.mCategoryId = paramLong;
    this.mChannelList = paramArrayList;
  }
  
  public long getCategoryId()
  {
    return this.mCategoryId;
  }
  
  public ArrayList<Long> getChannelList()
  {
    return this.mChannelList;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProCategoryChannelIdList{mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mCategoryId=");
    localStringBuilder.append(this.mCategoryId);
    localStringBuilder.append(",mChannelList=");
    localStringBuilder.append(this.mChannelList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProCategoryChannelIdList
 * JD-Core Version:    0.7.0.1
 */