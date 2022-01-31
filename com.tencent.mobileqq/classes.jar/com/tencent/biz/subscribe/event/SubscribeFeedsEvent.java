package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
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
      this.mTargetId = ("fakeid_" + paramCertifiedFakeFeed.b());
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
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.mState = 4;
      this.mFakeFeedDataList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CertifiedFakeFeed localCertifiedFakeFeed = (CertifiedFakeFeed)paramList.next();
        this.mFakeFeedDataList.add(a(localCertifiedFakeFeed, 1));
      }
    }
  }
  
  private CertifiedAccountMeta.StFeed a(CertifiedFakeFeed paramCertifiedFakeFeed, int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    PBStringField localPBStringField = localStFeed.id;
    if (paramInt == 2)
    {
      str = paramCertifiedFakeFeed.a();
      label26:
      localPBStringField.set(str);
      localStFeed.title.set(paramCertifiedFakeFeed.c());
      localStFeed.content.set(paramCertifiedFakeFeed.d());
      localStFeed.poster.id.set(paramCertifiedFakeFeed.f());
      localStFeed.type.set(paramCertifiedFakeFeed.a());
      localStFeed.createTime.set(paramCertifiedFakeFeed.a());
      localPBStringField = localStFeed.cover.url;
      if (paramCertifiedFakeFeed.e() != null) {
        break label215;
      }
    }
    label215:
    for (String str = "";; str = paramCertifiedFakeFeed.e())
    {
      localPBStringField.set(str);
      switch (paramCertifiedFakeFeed.a())
      {
      case 1: 
      case 2: 
      default: 
        localStFeed.cover.width.set(paramCertifiedFakeFeed.b());
        localStFeed.cover.height.set(paramCertifiedFakeFeed.c());
        return localStFeed;
        str = "fakeid_" + paramCertifiedFakeFeed.b();
        break label26;
      }
    }
    localStFeed.video.width.set(paramCertifiedFakeFeed.b());
    localStFeed.video.height.set(paramCertifiedFakeFeed.c());
    localStFeed.video.duration.set(paramCertifiedFakeFeed.d());
    return localStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SubscribeFeedsEvent
 * JD-Core Version:    0.7.0.1
 */