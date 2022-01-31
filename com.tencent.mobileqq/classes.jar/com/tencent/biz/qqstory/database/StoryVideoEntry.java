package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.unique;

public class StoryVideoEntry
  extends Entity
{
  public long addTime;
  public String address;
  public String addressText;
  public int allowComment;
  public String atImagePath;
  public String atJsonData;
  public String attachedFeedId;
  public int banType = -1;
  public int commentCount;
  public long createTime;
  public long databaseTime = System.currentTimeMillis();
  public int detailInfoState;
  public String doodleText;
  public String downloadNetType;
  public String groupId;
  public int hadRead;
  public int hasRelatedVideo;
  public String interactJsonData;
  public String interactThumbnailLocalPath;
  public String interactThumbnailUrl;
  public int isPicture;
  public String label;
  public int lastUploadFailErrorCode;
  public String lastUploadVid;
  public String likeEntryList;
  public String localCreateLocation;
  public long localCreateTime;
  public String localMaskPicPath;
  public String localSpecialItemId;
  public String localVideoPath;
  public String localVideoThumbnailPath;
  public int mInteractStatus;
  public byte[] mPollUsersBytes;
  public String mPublishDate;
  public byte[] mQimBytes;
  public int mSourceType = -1;
  public byte[] mTagBytes;
  public long mVideoIndex;
  public int mVideoSource;
  public String maskPicUrl;
  public String md5;
  public String ownerName;
  public String ownerUnionId;
  public String pollJsonData;
  public String pollNumbers;
  public int pollResult;
  public String pollThumbnailLocalPath;
  public String pollThumbnailUrl;
  @Deprecated
  public String pollUserUrls;
  public int rateResult = -1;
  public byte[] rateUsersBytes;
  public int retryUploadTimes;
  public String shareGroupId;
  public String sourceVid;
  public int storyType;
  public int strangerViewCount;
  @defaultValue(a=2147483647)
  public long timeZoneOffsetMillis;
  public int totalLikeNum;
  public int totalRateCount = -1;
  public long totalScore = -1L;
  public int uncheckLikeNum;
  public String unionId;
  public int uploadStatus = -1;
  @unique
  public String vid;
  public long videoBytes;
  public long videoDuration;
  public int videoHeight;
  public byte[] videoSpreadGroupList;
  public String videoThumbnailUrl;
  public String videoUrl;
  public int videoWidth;
  public int viewCount;
  public long viewTotalTime;
  
  public static String getLocalVideo()
  {
    return "uploadStatus<>5 AND uploadStatus<>7 AND uploadStatus<>-1 AND storyType<>2";
  }
  
  public static String getVidSelectionNoArgs()
  {
    return "vid=?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryVideoEntry
 * JD-Core Version:    0.7.0.1
 */