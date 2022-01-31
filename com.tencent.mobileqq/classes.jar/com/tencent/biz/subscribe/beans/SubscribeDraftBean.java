package com.tencent.biz.subscribe.beans;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import java.io.Serializable;

public class SubscribeDraftBean
  implements Serializable, Comparable<SubscribeDraftBean>
{
  public static int TYPE_IMAGES = 2;
  public static int TYPE_VIDEO = 1;
  private static final long serialVersionUID = -7113155010157016109L;
  private int height;
  private String mCoverUrl;
  private String mDescribe;
  private transient CertifiedAccountMeta.StFeed mDraftFeed;
  private long mDraftId;
  private int mDraftType = TYPE_VIDEO;
  private long mDuration;
  private String mTitle;
  private int width;
  
  public int compareTo(@NonNull SubscribeDraftBean paramSubscribeDraftBean)
  {
    return (int)(paramSubscribeDraftBean.getDraftId() - getDraftId());
  }
  
  public String getCoverUrl()
  {
    return this.mCoverUrl;
  }
  
  public String getDescirbe()
  {
    return this.mDescribe;
  }
  
  public int getDrafTtype()
  {
    return this.mDraftType;
  }
  
  public long getDraftId()
  {
    return this.mDraftId;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public SubscribeDraftBean setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    return this;
  }
  
  public SubscribeDraftBean setDescirbe(String paramString)
  {
    this.mDescribe = paramString;
    return this;
  }
  
  public SubscribeDraftBean setDrafTtype(int paramInt)
  {
    this.mDraftType = paramInt;
    return this;
  }
  
  public SubscribeDraftBean setDraftId(long paramLong)
  {
    this.mDraftId = paramLong;
    return this;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public SubscribeDraftBean setTitle(String paramString)
  {
    this.mTitle = paramString;
    return this;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.SubscribeDraftBean
 * JD-Core Version:    0.7.0.1
 */