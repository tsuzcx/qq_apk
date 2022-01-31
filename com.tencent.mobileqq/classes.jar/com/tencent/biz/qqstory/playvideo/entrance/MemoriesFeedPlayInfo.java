package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;
import java.util.ArrayList;

public class MemoriesFeedPlayInfo
  implements Serializable
{
  public static final int DATA_TYPE_PERSON = 0;
  public final String mContext;
  public final int mDataType;
  public boolean mIsEnd;
  public final ArrayList<String> mKeyList;
  public final String mStartFeedId;
  public final String mStartVid;
  public final String mUid;
  
  public MemoriesFeedPlayInfo(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    this.mUid = paramString1;
    this.mStartFeedId = paramString2;
    this.mStartVid = paramString3;
    this.mContext = paramString4;
    this.mKeyList = paramArrayList;
    this.mIsEnd = paramBoolean;
    this.mDataType = paramInt;
  }
  
  public String toString()
  {
    return "MemoriesFeedPlayInfo{mKeyList=" + this.mKeyList + ", mIsEnd=" + this.mIsEnd + ", mStartFeedId='" + this.mStartFeedId + '\'' + ", mStartVid='" + this.mStartVid + '\'' + ", mUid='" + this.mUid + '\'' + ", mContext='" + this.mContext + '\'' + ", mDataType=" + this.mDataType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo
 * JD-Core Version:    0.7.0.1
 */