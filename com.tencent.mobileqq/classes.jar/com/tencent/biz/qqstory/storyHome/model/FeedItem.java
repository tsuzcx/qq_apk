package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ulj;
import uxd;
import uxe;
import woy;
import wqn;
import wxe;
import xqq;

public abstract class FeedItem<T extends wqn, E extends uxe>
  extends BaseUIItem
  implements ulj
{
  public static final int BANNER_FEED_ITEM = 5;
  public static final String FAKE_START = "fake-";
  public static final int GENERAL_FEED_ITEM = 1;
  public static final int GENERAL_RECOMMEND_FEED_ITEM = 3;
  public static final int HOT_RECOMMEND_FEED_ITEM = 7;
  public static final int SHARE_GROUP_FEED_ITEM = 2;
  public static final int SHARE_GROUP_RECOMMEND_FEED_ITEM = 4;
  public static final int TAG_FEED_ITEM = 6;
  public String date;
  public long dateTimeMillis;
  public String feedId;
  public int feedSourceTagType;
  @Deprecated
  public String ownerId;
  public final int type = assignType();
  
  public static FeedItem createFeedItemByType(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      wxe.e("Q.qqstory", "It can not create the illegal type:%s feed!", new Object[] { Integer.valueOf(paramInt) });
      return null;
    case 1: 
      return new GeneralFeedItem();
    case 2: 
      return new ShareGroupFeedItem();
    case 3: 
      return new GeneralRecommendFeedItem();
    case 5: 
      return new BannerFeedItem();
    case 6: 
      return new TagFeedItem();
    }
    return new HotRecommendFeedItem();
  }
  
  public static boolean isFakeFeedId(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("fake-"));
  }
  
  public abstract int assignType();
  
  public abstract void convertFromFeedFeature(uxd paramuxd);
  
  public void copy(Object paramObject)
  {
    paramObject = (FeedItem)paramObject;
    this.feedId = paramObject.feedId;
    this.ownerId = paramObject.ownerId;
    if (!TextUtils.isEmpty(paramObject.date)) {
      setDate(paramObject.date);
    }
    this.feedSourceTagType = paramObject.feedSourceTagType;
  }
  
  public void covertFromEntry(FeedEntry paramFeedEntry)
  {
    boolean bool;
    if (this.type == paramFeedEntry.type) {
      bool = true;
    }
    for (;;)
    {
      xqq.a(bool, "type类型不对应");
      this.feedId = paramFeedEntry.feedId;
      setDate(paramFeedEntry.date);
      this.ownerId = paramFeedEntry.ownerId;
      if ((paramFeedEntry.extraInfo != null) && (paramFeedEntry.extraInfo.length > 0)) {}
      try
      {
        readFromLocalByte(paramFeedEntry.extraInfo);
        this.feedSourceTagType = paramFeedEntry.feedSourceTagType;
        onCovertFromEntry();
        return;
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          wxe.b("Q.qqstory", "invalid pb", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
  
  public abstract byte[] covertToByte();
  
  public FeedEntry covertToEntry()
  {
    onCovertToEntry();
    FeedEntry localFeedEntry = new FeedEntry();
    localFeedEntry.feedId = this.feedId;
    localFeedEntry.date = this.date;
    localFeedEntry.type = this.type;
    localFeedEntry.ownerId = this.ownerId;
    localFeedEntry.extraInfo = covertToByte();
    localFeedEntry.feedSourceTagType = this.feedSourceTagType;
    return localFeedEntry;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FeedItem)paramObject;
      if (this.feedId != null) {
        return this.feedId.equals(paramObject.feedId);
      }
    } while (paramObject.feedId == null);
    return false;
  }
  
  public T generateAndPackageHomeFeedFromDB()
  {
    wqn localwqn = generateHomeFeed();
    localwqn.b();
    return localwqn;
  }
  
  @NonNull
  public abstract T generateHomeFeed();
  
  @NonNull
  public abstract E getOwner();
  
  public int hashCode()
  {
    if (this.feedId != null) {
      return this.feedId.hashCode();
    }
    return 0;
  }
  
  protected void onCovertFromEntry() {}
  
  protected void onCovertToEntry() {}
  
  public void onRefresh() {}
  
  public abstract void readFromLocalByte(byte[] paramArrayOfByte);
  
  protected void readParcel() {}
  
  public abstract void reset();
  
  public void setDate(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = woy.a().format(new Date());
    }
    this.date = str;
    try
    {
      this.dateTimeMillis = woy.a().parse(str).getTime();
      return;
    }
    catch (ParseException paramString)
    {
      wxe.c("Q.qqstory.home", "parse date", paramString);
    }
  }
  
  public String toString()
  {
    return "FeedItem{type=" + this.type + ", feedId='" + this.feedId + '\'' + ", ownerId='" + this.ownerId + '\'' + ", date='" + this.date + '\'' + ", dateTimeMillis=" + this.dateTimeMillis + ", feedSourceTagType=" + this.feedSourceTagType + '}';
  }
  
  protected void writeParcel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedItem
 * JD-Core Version:    0.7.0.1
 */