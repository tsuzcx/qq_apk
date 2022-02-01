package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class RIJBiuAndCommentRequestData
  implements Serializable
{
  private int mCommentType;
  private int mContentSrc;
  private String mContentString;
  private boolean mIsBiu;
  private boolean mIsDiffuseToFriends;
  private boolean mIsSecondReply;
  private int mListShowType;
  private String mMediaPicHeight;
  private String mMediaPicUrl;
  private String mMediaPicWidth;
  private String mMediaTextInfo;
  private String mReplyCommentId;
  private String mReplyParentCommentId;
  private String mReplyUin;
  private String mRowKey;
  
  public int getCommentType()
  {
    return this.mCommentType;
  }
  
  public int getContentSrc()
  {
    return this.mContentSrc;
  }
  
  public String getContentString()
  {
    return this.mContentString;
  }
  
  public int getListShowType()
  {
    return this.mListShowType;
  }
  
  public String getMediaPicHeight()
  {
    return this.mMediaPicHeight;
  }
  
  public String getMediaPicUrl()
  {
    return this.mMediaPicUrl;
  }
  
  public String getMediaPicWidth()
  {
    return this.mMediaPicWidth;
  }
  
  public String getMediaTextInfo()
  {
    return this.mMediaTextInfo;
  }
  
  public String getReplyCommentId()
  {
    return this.mReplyCommentId;
  }
  
  public String getReplyParentCommentId()
  {
    return this.mReplyParentCommentId;
  }
  
  public String getReplyUin()
  {
    return this.mReplyUin;
  }
  
  public String getRowKey()
  {
    return this.mRowKey;
  }
  
  public boolean isBiu()
  {
    return this.mIsBiu;
  }
  
  public boolean isDiffuseToFriends()
  {
    return this.mIsDiffuseToFriends;
  }
  
  public boolean isIsSecondReply()
  {
    return this.mIsSecondReply;
  }
  
  public void setBiu(boolean paramBoolean)
  {
    this.mIsBiu = paramBoolean;
  }
  
  public void setCommentType(int paramInt)
  {
    this.mCommentType = paramInt;
  }
  
  public void setContentSrc(int paramInt)
  {
    this.mContentSrc = paramInt;
  }
  
  public void setContentString(String paramString)
  {
    this.mContentString = paramString;
  }
  
  public void setDiffuseToFriends(boolean paramBoolean)
  {
    this.mIsDiffuseToFriends = paramBoolean;
  }
  
  public void setIsSecondReply(boolean paramBoolean)
  {
    this.mIsSecondReply = paramBoolean;
  }
  
  public void setListShowType(int paramInt)
  {
    this.mListShowType = paramInt;
  }
  
  public void setMediaPicHeight(String paramString)
  {
    this.mMediaPicHeight = paramString;
  }
  
  public void setMediaPicUrl(String paramString)
  {
    this.mMediaPicUrl = paramString;
  }
  
  public void setMediaPicWidth(String paramString)
  {
    this.mMediaPicWidth = paramString;
  }
  
  public void setMediaTextInfo(String paramString)
  {
    this.mMediaTextInfo = paramString;
  }
  
  public void setReplyCommentId(String paramString)
  {
    this.mReplyCommentId = paramString;
  }
  
  public void setReplyParentCommentId(String paramString)
  {
    this.mReplyParentCommentId = paramString;
  }
  
  public void setReplyUin(String paramString)
  {
    this.mReplyUin = paramString;
  }
  
  public void setRowKey(String paramString)
  {
    this.mRowKey = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJBiuAndCommentRequestData{mRowKey='" + this.mRowKey + '\'' + ", mContentSrc=" + this.mContentSrc + ", mIsBiu=" + this.mIsBiu + ", mIsDiffuseToFriends=" + this.mIsDiffuseToFriends + ", mContentString='" + this.mContentString + '\'' + ", mIsSecondReply=" + this.mIsSecondReply + ", mLocalCommentId='" + this.mReplyCommentId + '\'' + ", mReplyUin='" + this.mReplyUin + '\'' + ", mCommentType=" + this.mCommentType + ", mListShowType=" + this.mListShowType + ", mMediaTextInfo='" + this.mMediaTextInfo + '\'' + ", mMediaPicUrl='" + this.mMediaPicUrl + '\'' + ", mMediaPicWidth='" + this.mMediaPicWidth + '\'' + ", mMediaPicHeight='" + this.mMediaPicHeight + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData
 * JD-Core Version:    0.7.0.1
 */