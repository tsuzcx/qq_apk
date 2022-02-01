package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProChannelPresenceInfo
{
  final ArrayList<GProChannelPresenceItemInfo> mItemList;
  final int mTemplateId;
  
  public GProChannelPresenceInfo(int paramInt, ArrayList<GProChannelPresenceItemInfo> paramArrayList)
  {
    this.mTemplateId = paramInt;
    this.mItemList = paramArrayList;
  }
  
  public ArrayList<GProChannelPresenceItemInfo> getItemList()
  {
    return this.mItemList;
  }
  
  public int getTemplateId()
  {
    return this.mTemplateId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannelPresenceInfo{mTemplateId=");
    localStringBuilder.append(this.mTemplateId);
    localStringBuilder.append(",mItemList=");
    localStringBuilder.append(this.mItemList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProChannelPresenceInfo
 * JD-Core Version:    0.7.0.1
 */