package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.feed.CertifiedFakeFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubscribeFeedsEvent
  extends SimpleBaseEvent
{
  public static final int STATE_COMPLETE = 2;
  public static final int STATE_CREATE = 1;
  public static final int STATE_DELETE = 3;
  public static final int STATE_INIT_FAKE_DATA = 4;
  public List<CertifiedAccountMeta.StFeed> mFakeFeedDataList;
  public CertifiedAccountMeta.StFeed mSingleFakeFeed;
  public int mState;
  public String mTargetId;
  
  public SubscribeFeedsEvent(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public SubscribeFeedsEvent(CertifiedFakeFeed paramCertifiedFakeFeed, int paramInt)
  {
    this.mState = paramInt;
    if (paramCertifiedFakeFeed != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeid_");
      localStringBuilder.append(paramCertifiedFakeFeed.getClientKey());
      this.mTargetId = localStringBuilder.toString();
      this.mSingleFakeFeed = a(paramCertifiedFakeFeed, paramInt);
    }
  }
  
  public SubscribeFeedsEvent(String paramString, int paramInt)
  {
    this.mState = paramInt;
    if (paramString != null) {
      this.mTargetId = paramString;
    }
  }
  
  public SubscribeFeedsEvent(List<CertifiedFakeFeed> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mState = 4;
    this.mFakeFeedDataList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CertifiedFakeFeed localCertifiedFakeFeed = (CertifiedFakeFeed)paramList.next();
      this.mFakeFeedDataList.add(a(localCertifiedFakeFeed, 1));
    }
  }
  
  private CertifiedAccountMeta.StFeed a(CertifiedFakeFeed paramCertifiedFakeFeed, int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    PBStringField localPBStringField = localStFeed.id;
    Object localObject;
    if (paramInt == 2)
    {
      localObject = paramCertifiedFakeFeed.getFeedId();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fakeid_");
      ((StringBuilder)localObject).append(paramCertifiedFakeFeed.getClientKey());
      localObject = ((StringBuilder)localObject).toString();
    }
    localPBStringField.set((String)localObject);
    localStFeed.title.set(paramCertifiedFakeFeed.getTitle());
    localStFeed.content.set(paramCertifiedFakeFeed.getContent());
    localStFeed.poster.id.set(paramCertifiedFakeFeed.getPuin());
    localStFeed.poster.setHasFlag(true);
    localStFeed.type.set(paramCertifiedFakeFeed.getFeedType());
    localStFeed.createTime.set(paramCertifiedFakeFeed.getCreateTime());
    localPBStringField = localStFeed.cover.url;
    if (paramCertifiedFakeFeed.getCoverPath() == null) {
      localObject = "";
    } else {
      localObject = paramCertifiedFakeFeed.getCoverPath();
    }
    localPBStringField.set((String)localObject);
    localStFeed.cover.setHasFlag(true);
    paramInt = paramCertifiedFakeFeed.getFeedType();
    if ((paramInt != 0) && (paramInt != 3))
    {
      localStFeed.cover.width.set(paramCertifiedFakeFeed.getWidth());
      localStFeed.cover.height.set(paramCertifiedFakeFeed.getHeight());
      return localStFeed;
    }
    localStFeed.video.width.set(paramCertifiedFakeFeed.getWidth());
    localStFeed.video.height.set(paramCertifiedFakeFeed.getHeight());
    localStFeed.video.duration.set(paramCertifiedFakeFeed.getDuration());
    localStFeed.video.setHasFlag(true);
    return localStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SubscribeFeedsEvent
 * JD-Core Version:    0.7.0.1
 */