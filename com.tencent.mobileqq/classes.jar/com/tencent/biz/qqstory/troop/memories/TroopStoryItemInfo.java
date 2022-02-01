package com.tencent.biz.qqstory.troop.memories;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.database.TroopStoryEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;

public class TroopStoryItemInfo
  extends BaseUIItem
  implements Parcelable
{
  public static final Parcelable.Creator<TroopStoryItemInfo> CREATOR = new TroopStoryItemInfo.1();
  public static final int ITEM_TYPE_DAY = 1;
  public static final int ITEM_TYPE_EMPTY = 4;
  public static final int ITEM_TYPE_SHOOTING = 3;
  public static final int ITEM_TYPE_SUBMIT_FAIL = 6;
  public static final int ITEM_TYPE_UPLOADING = 5;
  public static final int ITEM_TYPE_VIDEO = 2;
  public static final int ITEM_TYPE_YEAR = 0;
  public static final int UNION_ID_TYPE_NORMAL = 1;
  public static final int UNION_ID_TYPE_VIP = 2;
  public int commentCount;
  public int dayCommentCount = -1;
  public int dayLikeCount = -1;
  public int dayVideoCount;
  public int dayVideoIndex;
  public String feedId;
  public int itemType = 2;
  public int likeCount;
  public String nickName;
  public int publishCount;
  public long publishTime;
  public String storyId;
  public long troopId;
  public String uin;
  public String unionId;
  public int unionIdRole;
  public String vid;
  public String videoThumbUrl;
  
  public TroopStoryItemInfo() {}
  
  protected TroopStoryItemInfo(Parcel paramParcel)
  {
    this.troopId = paramParcel.readLong();
    this.itemType = paramParcel.readInt();
    this.publishTime = paramParcel.readLong();
    this.publishCount = paramParcel.readInt();
    this.storyId = paramParcel.readString();
    this.vid = paramParcel.readString();
    this.uin = paramParcel.readString();
    this.unionId = paramParcel.readString();
    this.videoThumbUrl = paramParcel.readString();
    this.likeCount = paramParcel.readInt();
    this.commentCount = paramParcel.readInt();
    this.nickName = paramParcel.readString();
    this.dayVideoCount = paramParcel.readInt();
    this.dayVideoIndex = paramParcel.readInt();
    this.feedId = paramParcel.readString();
    this.unionIdRole = paramParcel.readInt();
  }
  
  public static TroopStoryItemInfo createEmptyItem()
  {
    TroopStoryItemInfo localTroopStoryItemInfo = new TroopStoryItemInfo();
    localTroopStoryItemInfo.itemType = 4;
    return localTroopStoryItemInfo;
  }
  
  public static TroopStoryItemInfo createShootingItem()
  {
    TroopStoryItemInfo localTroopStoryItemInfo = new TroopStoryItemInfo();
    localTroopStoryItemInfo.itemType = 3;
    localTroopStoryItemInfo.publishTime = System.currentTimeMillis();
    return localTroopStoryItemInfo;
  }
  
  public static TroopStoryItemInfo createThisYearItem()
  {
    TroopStoryItemInfo localTroopStoryItemInfo = new TroopStoryItemInfo();
    localTroopStoryItemInfo.itemType = 0;
    localTroopStoryItemInfo.publishTime = System.currentTimeMillis();
    return localTroopStoryItemInfo;
  }
  
  public static TroopStoryItemInfo createTodayItem()
  {
    TroopStoryItemInfo localTroopStoryItemInfo = new TroopStoryItemInfo();
    localTroopStoryItemInfo.itemType = 1;
    localTroopStoryItemInfo.publishTime = System.currentTimeMillis();
    return localTroopStoryItemInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void from(TroopStoryEntry paramTroopStoryEntry)
  {
    this.id = paramTroopStoryEntry.getId();
    this.troopId = paramTroopStoryEntry.troopId;
    this.itemType = paramTroopStoryEntry.itemType;
    this.publishTime = paramTroopStoryEntry.publishTime;
    this.publishCount = paramTroopStoryEntry.publishCount;
    this.vid = paramTroopStoryEntry.vid;
    this.storyId = paramTroopStoryEntry.storyId;
    this.feedId = paramTroopStoryEntry.feedId;
    this.unionId = paramTroopStoryEntry.unionId;
    this.unionIdRole = paramTroopStoryEntry.unionIdRole;
    this.uin = paramTroopStoryEntry.uin;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopStoryItemInfo{troopId='");
    localStringBuilder.append(this.troopId);
    localStringBuilder.append(", itemType=");
    localStringBuilder.append(this.itemType);
    localStringBuilder.append(", publishTime=");
    localStringBuilder.append(this.publishTime);
    localStringBuilder.append(", publishCount=");
    localStringBuilder.append(this.publishCount);
    localStringBuilder.append(", storyId=");
    localStringBuilder.append(this.storyId);
    localStringBuilder.append(", vid=");
    localStringBuilder.append(this.vid);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", unionId=");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append(", unionIdRole=");
    localStringBuilder.append(this.unionIdRole);
    localStringBuilder.append(", videoThumbUrl=");
    localStringBuilder.append(this.videoThumbUrl);
    localStringBuilder.append(", likeCount=");
    localStringBuilder.append(this.likeCount);
    localStringBuilder.append(", commentCount=");
    localStringBuilder.append(this.commentCount);
    localStringBuilder.append(", feedId=");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.troopId);
    paramParcel.writeInt(this.itemType);
    paramParcel.writeLong(this.publishTime);
    paramParcel.writeInt(this.publishCount);
    paramParcel.writeString(this.storyId);
    paramParcel.writeString(this.vid);
    paramParcel.writeString(this.uin);
    paramParcel.writeString(this.unionId);
    paramParcel.writeString(this.videoThumbUrl);
    paramParcel.writeInt(this.likeCount);
    paramParcel.writeInt(this.commentCount);
    paramParcel.writeString(this.nickName);
    paramParcel.writeInt(this.dayVideoCount);
    paramParcel.writeInt(this.dayVideoIndex);
    paramParcel.writeString(this.feedId);
    paramParcel.writeInt(this.unionIdRole);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo
 * JD-Core Version:    0.7.0.1
 */