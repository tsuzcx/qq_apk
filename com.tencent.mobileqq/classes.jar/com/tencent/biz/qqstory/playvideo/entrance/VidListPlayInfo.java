package com.tencent.biz.qqstory.playvideo.entrance;

import com.tencent.biz.qqstory.utils.AssertUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    boolean bool;
    if (paramList1.size() == paramList2.size()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "vid size not equal feedId size");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidListPlayInfo{mStartVideoFeedId='");
    localStringBuilder.append(this.mStartVideoFeedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartVid='");
    localStringBuilder.append(this.mStartVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoFeedIdList=");
    localStringBuilder.append(this.mVideoFeedIdList);
    localStringBuilder.append(", mVidList=");
    localStringBuilder.append(this.mVidList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo
 * JD-Core Version:    0.7.0.1
 */