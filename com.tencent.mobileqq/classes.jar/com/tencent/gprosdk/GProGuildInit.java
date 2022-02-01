package com.tencent.gprosdk;

import java.util.ArrayList;
import java.util.HashMap;

public final class GProGuildInit
{
  final ArrayList<GProCategoryChannelIdList> mCategoryList;
  final HashMap<Long, GProChannel> mChannelMap;
  final long mGuildId;
  final GProCategoryChannelIdList mUncategorizedChannels;
  
  public GProGuildInit(long paramLong, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    this.mGuildId = paramLong;
    this.mChannelMap = paramHashMap;
    this.mUncategorizedChannels = paramGProCategoryChannelIdList;
    this.mCategoryList = paramArrayList;
  }
  
  public ArrayList<GProCategoryChannelIdList> getCategoryList()
  {
    return this.mCategoryList;
  }
  
  public HashMap<Long, GProChannel> getChannelMap()
  {
    return this.mChannelMap;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public GProCategoryChannelIdList getUncategorizedChannels()
  {
    return this.mUncategorizedChannels;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildInit{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChannelMap=");
    localStringBuilder.append(this.mChannelMap);
    localStringBuilder.append(",mUncategorizedChannels=");
    localStringBuilder.append(this.mUncategorizedChannels);
    localStringBuilder.append(",mCategoryList=");
    localStringBuilder.append(this.mCategoryList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildInit
 * JD-Core Version:    0.7.0.1
 */