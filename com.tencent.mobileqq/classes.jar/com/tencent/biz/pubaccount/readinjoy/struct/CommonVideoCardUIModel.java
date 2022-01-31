package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import java.net.URL;

public class CommonVideoCardUIModel
  implements IVideoCardUIModel
{
  protected BaseArticleInfo a;
  
  public CommonVideoCardUIModel(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a = paramBaseArticleInfo;
  }
  
  public int getCommentCount()
  {
    return this.a.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return this.a.innerUniqueID;
  }
  
  public String getShareUrl()
  {
    return this.a.mArticleContentUrl;
  }
  
  public String getSubscribeName()
  {
    return this.a.mSubscribeName;
  }
  
  public String getSubscribeUin()
  {
    return this.a.mSubscribeID;
  }
  
  public URL getVideoCoverURL()
  {
    if (this.a.mVideoCoverUrl != null) {
      return this.a.mVideoCoverUrl;
    }
    if (this.a.mSinglePicture != null) {
      return this.a.mSinglePicture;
    }
    return ReadInJoyUtils.a(this.a.mFirstPagePicUrl);
  }
  
  public int getVideoDuration()
  {
    return this.a.mVideoDuration;
  }
  
  public int getVideoHeight()
  {
    return this.a.mVideoJsonHeight;
  }
  
  public String getVideoVid()
  {
    return this.a.mVideoVid;
  }
  
  public int getVideoWidth()
  {
    return this.a.mVideoJsonWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.CommonVideoCardUIModel
 * JD-Core Version:    0.7.0.1
 */