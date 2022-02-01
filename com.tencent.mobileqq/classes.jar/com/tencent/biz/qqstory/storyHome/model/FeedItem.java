package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FeedItem<T extends StoryHomeFeed, E extends IFeedOwner>
  extends BaseUIItem
  implements Copyable
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
  public int feedSourceTagType = 0;
  @Deprecated
  public String ownerId;
  public final int type = assignType();
  
  public static FeedItem createFeedItemByType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7)
              {
                SLog.e("Q.qqstory", "It can not create the illegal type:%s feed!", new Object[] { Integer.valueOf(paramInt) });
                return null;
              }
              return new HotRecommendFeedItem();
            }
            return new TagFeedItem();
          }
          return new BannerFeedItem();
        }
        return new GeneralRecommendFeedItem();
      }
      return new ShareGroupFeedItem();
    }
    return new GeneralFeedItem();
  }
  
  public static boolean isFakeFeedId(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("fake-"));
  }
  
  protected abstract int assignType();
  
  public abstract void convertFromFeedFeature(FeedFeatureItem paramFeedFeatureItem);
  
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
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "type类型不对应");
    this.feedId = paramFeedEntry.feedId;
    setDate(paramFeedEntry.date);
    this.ownerId = paramFeedEntry.ownerId;
    if ((paramFeedEntry.extraInfo != null) && (paramFeedEntry.extraInfo.length > 0)) {
      try
      {
        readFromLocalByte(paramFeedEntry.extraInfo);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        SLog.b("Q.qqstory", "invalid pb", localInvalidProtocolBufferMicroException);
      }
    }
    this.feedSourceTagType = paramFeedEntry.feedSourceTagType;
    onCovertFromEntry();
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FeedItem)paramObject;
      String str = this.feedId;
      if (str != null) {
        return str.equals(paramObject.feedId);
      }
      return paramObject.feedId == null;
    }
    return false;
  }
  
  public T generateAndPackageHomeFeedFromDB()
  {
    StoryHomeFeed localStoryHomeFeed = generateHomeFeed();
    localStoryHomeFeed.e();
    return localStoryHomeFeed;
  }
  
  @NonNull
  public abstract T generateHomeFeed();
  
  @NonNull
  public abstract E getOwner();
  
  public int hashCode()
  {
    String str = this.feedId;
    if (str != null) {
      return str.hashCode();
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
      str = FeedManager.h().format(new Date());
    }
    this.date = str;
    try
    {
      this.dateTimeMillis = FeedManager.h().parse(str).getTime();
      return;
    }
    catch (ParseException paramString)
    {
      SLog.c("Q.qqstory.home", "parse date", paramString);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedItem{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ownerId='");
    localStringBuilder.append(this.ownerId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dateTimeMillis=");
    localStringBuilder.append(this.dateTimeMillis);
    localStringBuilder.append(", feedSourceTagType=");
    localStringBuilder.append(this.feedSourceTagType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  protected void writeParcel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedItem
 * JD-Core Version:    0.7.0.1
 */