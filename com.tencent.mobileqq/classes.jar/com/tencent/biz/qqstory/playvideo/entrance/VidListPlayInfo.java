package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import zdl;

public class VidListPlayInfo
  implements Serializable
{
  public final String mStartVid;
  public final String mStartVideoFeedId;
  public final List<String> mVidList;
  public final List<String> mVideoFeedIdList;
  
  public VidListPlayInfo(String paramString)
  {
    this.mStartVideoFeedId = "";
    this.mStartVid = paramString;
    this.mVidList = new ArrayList(1);
    this.mVidList.add(paramString);
    this.mVideoFeedIdList = new ArrayList(1);
    this.mVideoFeedIdList.add(this.mStartVideoFeedId);
  }
  
  public VidListPlayInfo(String paramString1, String paramString2)
  {
    this.mStartVideoFeedId = paramString1;
    this.mStartVid = paramString2;
    this.mVidList = new ArrayList(1);
    this.mVidList.add(paramString2);
    this.mVideoFeedIdList = new ArrayList(1);
    this.mVideoFeedIdList.add(this.mStartVideoFeedId);
  }
  
  public VidListPlayInfo(String paramString1, List<String> paramList, String paramString2)
  {
    this.mStartVideoFeedId = paramString1;
    this.mStartVid = paramString2;
    this.mVidList = paramList;
    this.mVideoFeedIdList = new ArrayList(1);
    this.mVideoFeedIdList.add(this.mStartVideoFeedId);
  }
  
  public VidListPlayInfo(List<String> paramList, String paramString)
  {
    this.mStartVideoFeedId = "";
    this.mStartVid = paramString;
    this.mVidList = paramList;
    this.mVideoFeedIdList = new ArrayList(1);
    this.mVideoFeedIdList.add(this.mStartVideoFeedId);
  }
  
  public VidListPlayInfo(List<String> paramList1, List<String> paramList2, String paramString1, String paramString2)
  {
    this.mStartVideoFeedId = paramString1;
    this.mStartVid = paramString2;
    this.mVidList = paramList2;
    this.mVideoFeedIdList = paramList1;
    if (paramList1.size() == paramList2.size()) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool, "vid size not equal feedId size");
      return;
    }
  }
  
  public String toString()
  {
    return "VidListPlayInfo{mStartVideoFeedId='" + this.mStartVideoFeedId + '\'' + ", mStartVid='" + this.mStartVid + '\'' + ", mVideoFeedIdList=" + this.mVideoFeedIdList + ", mVidList=" + this.mVidList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo
 * JD-Core Version:    0.7.0.1
 */