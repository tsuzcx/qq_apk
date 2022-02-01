package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.LocalStruct.PollUserItems;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_group.CommentLikeCount;
import com.tencent.biz.qqstory.network.pb.qqstory_group.NewlyLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoInfoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DiscoveryShareGroupVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.QimVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoBasicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VidPollInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.CompInfoBase;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.ArrayUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.StoryDebugUtils.StoryExceptionCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class StoryVideoItem
  extends BaseUIItem
  implements Copyable, Comparable<StoryVideoItem>
{
  public static final int BASIC_INFO_STATE_INIT = 0;
  public static final int BASIC_INFO_STATE_SUCC = 1;
  public static final String FAKE_VID_PRE = "fake_vid_";
  public static final int FILE_DOWNLOAD_FAIL = 0;
  public static final int FILE_DOWNLOAD_SUCC = 1;
  public static final int FILE_NOT_EXIST = -1;
  public static final int MAX_VIEW_COUNT = 100000;
  public static final int PLAYABLE_NO_DOODLE_HAS_NOT_DOWNLOADED = 1;
  public static final int PLAYABLE_NO_NOT_SUPPORT_STREAM = 4;
  public static final int PLAYABLE_YES_HAS_LOCAL_VIDEO_FILE = 3;
  public static final int PLAYABLE_YES_USE_TVK_SUPPORT_STREAM = 2;
  public static final int PLAYER_SCALE_TYPE_CENTERCROP = 0;
  public static final int PLAYER_SCALE_TYPE_CENTERINSIDE = 1;
  public static final int STORY_TYPE_QQSTORY = 1;
  public static final int STORY_TYPE_SHAREGROUP = 3;
  public static final int STORY_TYPE_TROOPSTORY = 2;
  public static final String TAG = "StoryVideoItem";
  public static final int VIDEO_TYPE_AT_WATERMARK = 3;
  public static final int VIDEO_TYPE_EMPTY = 0;
  public static final int VIDEO_TYPE_ONLY_AT = 2;
  public static final int VIDEO_TYPE_ONLY_WATERMARK = 1;
  public int comparedLevel;
  public String comparedVid;
  private int debugSourceType;
  public int hasParsedPollLayout = -1;
  public long mAddTime = -1L;
  public int mAllowComment;
  public String mAtImagePath;
  public String mAtJsonData;
  public String mAttachedFeedId;
  public int mBanType = -1;
  public int mBasicInfoState;
  public int mCommentCount = -1;
  public CompInfoBase mCompInfoBase;
  public long mCreateTime = -1L;
  public String mDoodleText;
  public String mDownloadNetType;
  public int mErrorCode;
  public VideoGameInfo mGameInfo;
  public String mGameInfoJson;
  public String mGroupId;
  public int mHadRead;
  public int mHasLike = -1;
  public int mHasRelatedVideo = -1;
  private StoryVideoItem.InteractPasterLayout mInteractLayoutAttr;
  public String mInteractLayoutJson;
  public int mInteractStatus;
  public String mInteractThumbnailLocalPath;
  public String mInteractThumbnailUrl;
  public int mIsPicture = -1;
  public int mIsPlaying;
  public String mLabel;
  public String mLastUploadVid;
  public int mLatitude;
  public List<LikeEntry> mLikeEntryList;
  public String mLinkInfoJson;
  public String mLocalCreateLocation;
  public long mLocalCreateTime = -1L;
  public String mLocalMaskPath;
  public String mLocalSpecialItemId = "";
  public String mLocalVideoPath;
  public AddressItem mLocation;
  public int mLongitude;
  public VideoLinkInfo mOALinkInfo;
  public String mOALinkInfoJson;
  public String mOriginalMaskPicUrl;
  public String mOwnerName = "";
  public String mOwnerUid = "";
  private StoryVideoItem.PollLayout mPollLayoutAttr;
  public String mPollLayoutJson;
  public int[] mPollNumbers = null;
  public int mPollResult = -1;
  public String mPollThumbnailLocalPath;
  public String mPollThumbnailUrl;
  public CopyOnWriteArrayList<QQUserUIItem> mPollUsers = new CopyOnWriteArrayList();
  public String mPreloadMsg;
  public String mPublishDate;
  public QimVideoInfoItem mQimVideoInfoItem;
  public int mRateResult = -1;
  public CopyOnWriteArrayList<QQUserUIItem> mRateUsers = new CopyOnWriteArrayList();
  public String mRecommendWording;
  public int mRetryUploadTimes;
  public int mSourceTagType;
  public int mSourceType;
  public int mStoryType;
  public int mStrangerLikeCount = -1;
  public int mStrangerViewCount = -1;
  public TagItem.TagInfoBase mTagInfoBase;
  public String mTempThumbUrl;
  public String mTempVideoUrl;
  public long mTimeZoneOffsetMillis = 2147483647L;
  public int mTotalLikeCount = -1;
  public int mTotalRateCount = -1;
  public long mTotalScore = -1L;
  public int mUnreadLikeCount = -1;
  public int mUpLoadFailedError;
  public int mUploadStatus = -1;
  public String mUserSelectLocationText;
  public String mVid;
  public long mVideoBytes = -1L;
  public long mVideoDuration = -1L;
  public int mVideoHeight = -1;
  public long mVideoIndex;
  public VideoLinkInfo mVideoLinkInfo;
  public String mVideoLocalThumbnailOrigFakePath;
  public String mVideoLocalThumbnailPath;
  public String mVideoMd5;
  public int mVideoSource;
  public VideoSpreadGroupList mVideoSpreadGroupList;
  public String mVideoThumbnailUrl;
  public String mVideoUrl;
  public int mVideoWidth = -1;
  public int mViewCount = -1;
  public long mViewTotalTime = -1L;
  public String mWsSchema = "";
  public String originalAuthorName;
  public String originalAuthorUnionId;
  public int playerScaleType;
  public int preloadPriority;
  public String shareGroupId;
  public String sourceVid;
  public long videoUrlExpireTime;
  
  public StoryVideoItem()
  {
    this.mBasicInfoState = 0;
    this.mInteractStatus = -1;
    this.preloadPriority = 1;
    this.mRetryUploadTimes = 0;
    this.mUpLoadFailedError = 0;
    this.mAllowComment = -1;
    this.mStoryType = 1;
    this.mVideoSource = -1;
    this.mHadRead = -1;
    this.mAttachedFeedId = "";
    this.mSourceType = -1;
    this.debugSourceType = 0;
    this.playerScaleType = -1;
    this.videoUrlExpireTime = -1L;
    this.comparedLevel = 0;
    this.mSourceTagType = -2147483648;
    this.debugSourceType = 100;
  }
  
  public StoryVideoItem(StoryVideoEntry paramStoryVideoEntry)
  {
    int j = 0;
    this.mBasicInfoState = 0;
    this.mInteractStatus = -1;
    this.preloadPriority = 1;
    this.mRetryUploadTimes = 0;
    this.mUpLoadFailedError = 0;
    this.mAllowComment = -1;
    this.mStoryType = 1;
    this.mVideoSource = -1;
    this.mHadRead = -1;
    this.mAttachedFeedId = "";
    this.mSourceType = -1;
    this.debugSourceType = 0;
    this.playerScaleType = -1;
    this.videoUrlExpireTime = -1L;
    this.comparedLevel = 0;
    this.mSourceTagType = -2147483648;
    this.mVid = paramStoryVideoEntry.vid;
    this.mLocalSpecialItemId = paramStoryVideoEntry.localSpecialItemId;
    this.mVideoUrl = paramStoryVideoEntry.videoUrl;
    this.mVideoThumbnailUrl = paramStoryVideoEntry.videoThumbnailUrl;
    this.mOriginalMaskPicUrl = paramStoryVideoEntry.maskPicUrl;
    this.mVideoLocalThumbnailPath = paramStoryVideoEntry.localVideoThumbnailPath;
    this.mLocalVideoPath = paramStoryVideoEntry.localVideoPath;
    this.mLocalMaskPath = paramStoryVideoEntry.localMaskPicPath;
    this.mViewCount = paramStoryVideoEntry.viewCount;
    this.mViewTotalTime = paramStoryVideoEntry.viewTotalTime;
    this.mCreateTime = paramStoryVideoEntry.createTime;
    this.mAddTime = paramStoryVideoEntry.addTime;
    this.mPublishDate = paramStoryVideoEntry.mPublishDate;
    if (TextUtils.isEmpty(this.mPublishDate)) {
      this.mPublishDate = FeedManager.a().format(new Date(this.mCreateTime));
    }
    this.mUploadStatus = paramStoryVideoEntry.uploadStatus;
    this.mRetryUploadTimes = paramStoryVideoEntry.retryUploadTimes;
    this.mUpLoadFailedError = paramStoryVideoEntry.lastUploadFailErrorCode;
    this.mLastUploadVid = paramStoryVideoEntry.lastUploadVid;
    this.mVideoDuration = paramStoryVideoEntry.videoDuration;
    this.mVideoWidth = paramStoryVideoEntry.videoWidth;
    this.mVideoHeight = paramStoryVideoEntry.videoHeight;
    this.mVideoBytes = paramStoryVideoEntry.videoBytes;
    this.mLabel = paramStoryVideoEntry.label;
    this.mHasRelatedVideo = paramStoryVideoEntry.hasRelatedVideo;
    this.mDoodleText = paramStoryVideoEntry.doodleText;
    this.mOwnerUid = paramStoryVideoEntry.ownerUnionId;
    this.mOwnerName = paramStoryVideoEntry.ownerName;
    this.mStrangerViewCount = paramStoryVideoEntry.strangerViewCount;
    this.mUnreadLikeCount = paramStoryVideoEntry.uncheckLikeNum;
    this.mTotalLikeCount = paramStoryVideoEntry.totalLikeNum;
    this.mCommentCount = paramStoryVideoEntry.commentCount;
    this.mLikeEntryList = LikeEntry.convertFromJson(paramStoryVideoEntry.likeEntryList);
    this.mBasicInfoState = paramStoryVideoEntry.detailInfoState;
    try
    {
      if (!TextUtils.isEmpty(paramStoryVideoEntry.address)) {
        this.mLocation = AddressItem.convertFromJson(paramStoryVideoEntry.address);
      }
    }
    catch (Exception localException)
    {
      SLog.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localException.toString());
      localException.printStackTrace();
    }
    this.mAllowComment = paramStoryVideoEntry.allowComment;
    this.mAtJsonData = paramStoryVideoEntry.atJsonData;
    this.mAtImagePath = paramStoryVideoEntry.atImagePath;
    this.mIsPicture = paramStoryVideoEntry.isPicture;
    this.mLocalCreateTime = (paramStoryVideoEntry.localCreateTime * 1000L);
    this.mLocalCreateLocation = paramStoryVideoEntry.localCreateLocation;
    this.mBanType = paramStoryVideoEntry.banType;
    this.mDownloadNetType = paramStoryVideoEntry.downloadNetType;
    this.mStoryType = paramStoryVideoEntry.storyType;
    Object localObject1;
    if ((paramStoryVideoEntry.videoSpreadGroupList != null) && (paramStoryVideoEntry.videoSpreadGroupList.length > 0))
    {
      localObject1 = new qqstory_struct.VideoSpreadGroupList();
      try
      {
        ((qqstory_struct.VideoSpreadGroupList)localObject1).mergeFrom(paramStoryVideoEntry.videoSpreadGroupList);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
      {
        if (QLog.isColorLevel()) {
          SLog.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localInvalidProtocolBufferMicroException5.toString());
        }
      }
      this.mVideoSpreadGroupList = new VideoSpreadGroupList((qqstory_struct.VideoSpreadGroupList)localObject1);
    }
    this.mVideoMd5 = paramStoryVideoEntry.md5;
    this.mGroupId = paramStoryVideoEntry.groupId;
    this.mHadRead = paramStoryVideoEntry.hadRead;
    this.mTimeZoneOffsetMillis = paramStoryVideoEntry.timeZoneOffsetMillis;
    this.mUserSelectLocationText = paramStoryVideoEntry.addressText;
    this.shareGroupId = paramStoryVideoEntry.shareGroupId;
    this.sourceVid = paramStoryVideoEntry.sourceVid;
    this.mAttachedFeedId = paramStoryVideoEntry.attachedFeedId;
    if (paramStoryVideoEntry.recommendWording != null) {
      this.mRecommendWording = paramStoryVideoEntry.recommendWording;
    }
    this.mVideoSource = paramStoryVideoEntry.mVideoSource;
    this.mVideoIndex = paramStoryVideoEntry.mVideoIndex;
    this.mInteractStatus = paramStoryVideoEntry.mInteractStatus;
    if ((paramStoryVideoEntry.mTagBytes != null) && (paramStoryVideoEntry.mTagBytes.length > 0))
    {
      localObject1 = new qqstory_struct.TagInfoBase();
      try
      {
        ((qqstory_struct.TagInfoBase)localObject1).mergeFrom(paramStoryVideoEntry.mTagBytes);
        this.mTagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)localObject1);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        if (QLog.isColorLevel()) {
          SLog.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localInvalidProtocolBufferMicroException1.toString());
        }
      }
    }
    if ((paramStoryVideoEntry.mCompBytes != null) && (paramStoryVideoEntry.mCompBytes.length > 0))
    {
      qqstory_struct.CompInfoBase localCompInfoBase = new qqstory_struct.CompInfoBase();
      try
      {
        localCompInfoBase.mergeFrom(paramStoryVideoEntry.mCompBytes);
        this.mCompInfoBase = new CompInfoBase(localCompInfoBase);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StoryVideoItem", 2, localInvalidProtocolBufferMicroException2.toString());
        }
      }
    }
    this.mPollLayoutJson = paramStoryVideoEntry.pollJsonData;
    Object localObject2;
    int i;
    if (!TextUtils.isEmpty(paramStoryVideoEntry.pollNumbers))
    {
      localObject2 = paramStoryVideoEntry.pollNumbers.split(",");
      int k = localObject2.length;
      this.mPollNumbers = new int[k];
      i = 0;
      while (i < k)
      {
        this.mPollNumbers[i] = Integer.parseInt(localObject2[i]);
        i += 1;
      }
    }
    if ((paramStoryVideoEntry.mPollUsersBytes != null) && (paramStoryVideoEntry.mPollUsersBytes.length > 0)) {}
    try
    {
      localObject2 = new LocalStruct.PollUserItems();
      ((LocalStruct.PollUserItems)localObject2).mergeFrom(paramStoryVideoEntry.mPollUsersBytes);
      i = 0;
      while (i < ((LocalStruct.PollUserItems)localObject2).users.size())
      {
        localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom((qqstory_struct.UserInfo)((LocalStruct.PollUserItems)localObject2).users.get(i));
        this.mPollUsers.add(localQQUserUIItem);
        i += 1;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
    {
      QQUserUIItem localQQUserUIItem;
      label1163:
      break label1163;
    }
    this.mPollThumbnailUrl = paramStoryVideoEntry.pollThumbnailUrl;
    this.mPollThumbnailLocalPath = paramStoryVideoEntry.pollThumbnailLocalPath;
    this.mPollResult = paramStoryVideoEntry.pollResult;
    this.mInteractLayoutJson = paramStoryVideoEntry.interactJsonData;
    this.mInteractThumbnailUrl = paramStoryVideoEntry.interactThumbnailUrl;
    this.mInteractThumbnailLocalPath = paramStoryVideoEntry.interactThumbnailLocalPath;
    this.mLinkInfoJson = paramStoryVideoEntry.linkInfoJson;
    this.mGameInfoJson = paramStoryVideoEntry.gameInfoJson;
    this.mOALinkInfoJson = paramStoryVideoEntry.oaLinkInfoJson;
    this.mRateResult = paramStoryVideoEntry.rateResult;
    this.mTotalRateCount = paramStoryVideoEntry.totalRateCount;
    this.mTotalScore = paramStoryVideoEntry.totalScore;
    this.mRateUsers.clear();
    if ((paramStoryVideoEntry.rateUsersBytes != null) && (paramStoryVideoEntry.rateUsersBytes.length > 0)) {}
    try
    {
      localObject2 = new LocalStruct.PollUserItems();
      ((LocalStruct.PollUserItems)localObject2).mergeFrom(paramStoryVideoEntry.rateUsersBytes);
      i = j;
      while (i < ((LocalStruct.PollUserItems)localObject2).users.size())
      {
        localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom((qqstory_struct.UserInfo)((LocalStruct.PollUserItems)localObject2).users.get(i));
        this.mRateUsers.add(localQQUserUIItem);
        i += 1;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
    {
      label1357:
      break label1357;
    }
    this.mQimVideoInfoItem = QimVideoInfoItem.a(paramStoryVideoEntry.mQimBytes);
    this.mSourceType = paramStoryVideoEntry.mSourceType;
    this.playerScaleType = paramStoryVideoEntry.playerScaleType;
    this.mWsSchema = paramStoryVideoEntry.wsSchema;
    this.originalAuthorUnionId = paramStoryVideoEntry.originalAuthorUnionId;
    this.originalAuthorName = paramStoryVideoEntry.originalAuthorName;
    this.videoUrlExpireTime = paramStoryVideoEntry.videoUrlExpireTime;
    this.comparedVid = paramStoryVideoEntry.comparedVid;
    this.comparedLevel = paramStoryVideoEntry.comparedLevel;
    this.mSourceTagType = paramStoryVideoEntry.sourceTagType;
  }
  
  public static boolean convertFromVideoAttr(StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2)
  {
    return convertFromVideoAttr(paramStoryVideoItem, paramString1, paramString2, false);
  }
  
  public static boolean convertFromVideoAttr(StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        paramStoryVideoItem.mVideoWidth = paramString1.optInt("video_width");
        paramStoryVideoItem.mVideoHeight = paramString1.optInt("video_height");
        paramStoryVideoItem.mVideoBytes = paramString1.optLong("video_bytes");
        paramStoryVideoItem.mIsPicture = paramString1.optInt("is_pic");
        paramStoryVideoItem.mDoodleText = paramString1.optString("video_doodle_text");
        paramStoryVideoItem.mAtJsonData = paramString1.optString("ml");
        paramStoryVideoItem.mLocalCreateTime = (paramString1.optLong("ct") * 1000L);
        paramStoryVideoItem.mLocalCreateLocation = paramString1.optString("loc");
        paramStoryVideoItem.mLatitude = paramString1.optInt("lat");
        paramStoryVideoItem.mLongitude = paramString1.optInt("lon");
        paramStoryVideoItem.mUserSelectLocationText = paramString1.optString("video_location");
        if (TextUtils.isEmpty(paramStoryVideoItem.mUserSelectLocationText)) {
          paramStoryVideoItem.mUserSelectLocationText = paramString1.optString("video_gps_filter");
        }
        if (paramBoolean) {
          break label568;
        }
        if (!paramString1.has("add_tz")) {
          break label562;
        }
      }
      catch (Exception paramStoryVideoItem)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        SLog.b(paramString2, "decode json fail", paramStoryVideoItem);
      }
      if (i != 0)
      {
        paramStoryVideoItem.mTimeZoneOffsetMillis = paramString1.optInt("add_tz", 2147483647);
        if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
          paramStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
        }
      }
      else
      {
        paramStoryVideoItem.mTimeZoneOffsetMillis = paramString1.optInt("tz", 2147483647);
        if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
          paramStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
        }
      }
      paramStoryVideoItem.mLocalSpecialItemId = paramString1.optString("mLocalSpecialItemId");
      localObject = paramString1.optJSONArray("ml");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramStoryVideoItem.mAtJsonData = ((JSONArray)localObject).toString();
        return true;
      }
      localObject = paramString1.optJSONObject("pl");
      if ((localObject != null) && (paramStoryVideoItem.hasParsedPollLayout != 1))
      {
        paramStoryVideoItem.mPollLayoutAttr = StoryVideoItem.PollLayout.a((JSONObject)localObject);
        if (paramStoryVideoItem.mPollLayoutAttr == null) {
          paramStoryVideoItem.mPollLayoutJson = null;
        } else {
          paramStoryVideoItem.mPollLayoutJson = paramStoryVideoItem.mPollLayoutAttr.a();
        }
        paramStoryVideoItem.hasParsedPollLayout = 1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pl: ");
        localStringBuilder.append(((JSONObject)localObject).toString());
        SLog.b(paramString2, localStringBuilder.toString());
      }
      paramStoryVideoItem.mPollThumbnailUrl = paramString1.optString("pl_pic");
      localObject = paramString1.optJSONObject("i_l");
      if (localObject != null)
      {
        paramStoryVideoItem.mInteractLayoutAttr = StoryVideoItem.InteractPasterLayout.a((JSONObject)localObject);
        if (paramStoryVideoItem.mInteractLayoutAttr == null) {
          paramStoryVideoItem.mInteractLayoutJson = null;
        } else {
          paramStoryVideoItem.mInteractLayoutJson = paramStoryVideoItem.mInteractLayoutAttr.a();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("il: ");
        localStringBuilder.append(((JSONObject)localObject).toString());
        SLog.b(paramString2, localStringBuilder.toString());
      }
      paramStoryVideoItem.mInteractThumbnailUrl = paramString1.optString("il_pic");
      paramStoryVideoItem.mGameInfoJson = paramString1.optString("game");
      paramStoryVideoItem.mGameInfo = VideoGameInfo.a(paramStoryVideoItem.mGameInfoJson);
      paramStoryVideoItem.comparedLevel = paramString1.optInt("comp_lv");
      return false;
      return false;
      label562:
      int i = 0;
      continue;
      label568:
      i = 1;
    }
  }
  
  /* Error */
  public static String convertToVideoAttr(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    // Byte code:
    //   0: new 733	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 861	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 193	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoWidth	I
    //   12: iconst_m1
    //   13: if_icmpeq +15 -> 28
    //   16: aload_3
    //   17: ldc_w 738
    //   20: aload_0
    //   21: getfield 193	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoWidth	I
    //   24: invokevirtual 865	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload_0
    //   29: getfield 195	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoHeight	I
    //   32: iconst_m1
    //   33: if_icmpeq +15 -> 48
    //   36: aload_3
    //   37: ldc_w 743
    //   40: aload_0
    //   41: getfield 195	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoHeight	I
    //   44: invokevirtual 865	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 197	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoBytes	J
    //   52: ldc2_w 174
    //   55: lcmp
    //   56: ifeq +15 -> 71
    //   59: aload_3
    //   60: ldc_w 745
    //   63: aload_0
    //   64: getfield 197	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoBytes	J
    //   67: invokevirtual 868	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   70: pop
    //   71: aload_0
    //   72: getfield 173	com/tencent/biz/qqstory/model/item/StoryVideoItem:mIsPicture	I
    //   75: iconst_m1
    //   76: if_icmpeq +15 -> 91
    //   79: aload_3
    //   80: ldc_w 751
    //   83: aload_0
    //   84: getfield 173	com/tencent/biz/qqstory/model/item/StoryVideoItem:mIsPicture	I
    //   87: invokevirtual 865	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   90: pop
    //   91: aload_0
    //   92: getfield 392	com/tencent/biz/qqstory/model/item/StoryVideoItem:mDoodleText	Ljava/lang/String;
    //   95: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +15 -> 113
    //   101: aload_3
    //   102: ldc_w 753
    //   105: aload_0
    //   106: getfield 392	com/tencent/biz/qqstory/model/item/StoryVideoItem:mDoodleText	Ljava/lang/String;
    //   109: invokevirtual 871	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload_0
    //   114: getfield 457	com/tencent/biz/qqstory/model/item/StoryVideoItem:mAtJsonData	Ljava/lang/String;
    //   117: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: istore_2
    //   121: iload_2
    //   122: ifne +37 -> 159
    //   125: aload_3
    //   126: ldc_w 759
    //   129: new 794	org/json/JSONArray
    //   132: dup
    //   133: aload_0
    //   134: getfield 457	com/tencent/biz/qqstory/model/item/StoryVideoItem:mAtJsonData	Ljava/lang/String;
    //   137: invokespecial 872	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 871	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: pop
    //   144: goto +15 -> 159
    //   147: aload_3
    //   148: ldc_w 759
    //   151: aload_0
    //   152: getfield 457	com/tencent/biz/qqstory/model/item/StoryVideoItem:mAtJsonData	Ljava/lang/String;
    //   155: invokevirtual 871	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload_0
    //   160: getfield 181	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalCreateTime	J
    //   163: ldc2_w 174
    //   166: lcmp
    //   167: ifeq +19 -> 186
    //   170: aload_3
    //   171: ldc_w 761
    //   174: aload_0
    //   175: getfield 181	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalCreateTime	J
    //   178: ldc2_w 469
    //   181: ldiv
    //   182: invokevirtual 868	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload_0
    //   187: getfield 475	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalCreateLocation	Ljava/lang/String;
    //   190: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +15 -> 208
    //   196: aload_3
    //   197: ldc_w 763
    //   200: aload_0
    //   201: getfield 475	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalCreateLocation	Ljava/lang/String;
    //   204: invokevirtual 871	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_0
    //   209: getfield 767	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLatitude	I
    //   212: iconst_m1
    //   213: if_icmpeq +15 -> 228
    //   216: aload_3
    //   217: ldc_w 765
    //   220: aload_0
    //   221: getfield 767	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLatitude	I
    //   224: invokevirtual 865	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload_0
    //   229: getfield 771	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLongitude	I
    //   232: iconst_m1
    //   233: if_icmpeq +15 -> 248
    //   236: aload_3
    //   237: ldc_w 769
    //   240: aload_0
    //   241: getfield 771	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLongitude	I
    //   244: invokevirtual 865	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload_3
    //   249: ldc_w 788
    //   252: aload_0
    //   253: getfield 171	com/tencent/biz/qqstory/model/item/StoryVideoItem:mLocalSpecialItemId	Ljava/lang/String;
    //   256: invokevirtual 871	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: goto +12 -> 272
    //   263: astore_0
    //   264: aload_1
    //   265: ldc_w 874
    //   268: aload_0
    //   269: invokestatic 856	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_3
    //   273: invokevirtual 823	org/json/JSONObject:toString	()Ljava/lang/String;
    //   276: areturn
    //   277: astore 4
    //   279: goto -132 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramStoryVideoItem	StoryVideoItem
    //   0	282	1	paramString	String
    //   120	2	2	bool	boolean
    //   7	266	3	localJSONObject	JSONObject
    //   277	1	4	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   8	28	263	org/json/JSONException
    //   28	48	263	org/json/JSONException
    //   48	71	263	org/json/JSONException
    //   71	91	263	org/json/JSONException
    //   91	113	263	org/json/JSONException
    //   113	121	263	org/json/JSONException
    //   147	159	263	org/json/JSONException
    //   159	186	263	org/json/JSONException
    //   186	208	263	org/json/JSONException
    //   208	228	263	org/json/JSONException
    //   228	248	263	org/json/JSONException
    //   248	260	263	org/json/JSONException
    //   125	144	277	org/json/JSONException
  }
  
  public static String dump(List<StoryVideoItem> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(((StoryVideoItem)paramList.next()).mVid);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String getCacheKey(String paramString)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (localStoryVideoItem == null) {
      return paramString;
    }
    if (TextUtils.isEmpty(localStoryVideoItem.mVideoMd5)) {
      return paramString;
    }
    return localStoryVideoItem.mVideoMd5;
  }
  
  public static int getPlayableFlag(String paramString, boolean paramBoolean)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMaskDownloaded() != 0))
    {
      if ((paramBoolean) && (VideoViewFactory.a(BaseApplicationImpl.getContext()).a()) && ((!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (!TextUtils.isEmpty(localStoryVideoItem.mTempVideoUrl)))) {
        return 2;
      }
      if (FileCacheUtils.a(paramString, 0, false, false) != null) {
        return 3;
      }
      return 4;
    }
    return 1;
  }
  
  public static boolean hasInteractVideo(List<StoryVideoItem> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((StoryVideoItem)paramList.next()).isInteractVideo()) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean hasPollVideo(List<StoryVideoItem> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((StoryVideoItem)paramList.next()).isPollVideo()) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isFakeVid(String paramString)
  {
    return paramString.contains("fake_vid_");
  }
  
  public static boolean isPlayable(String paramString, boolean paramBoolean)
  {
    return isPlayableFlag(getPlayableFlag(paramString, paramBoolean));
  }
  
  public static boolean isPlayableFlag(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static String makeFakeVid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake_vid_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("-");
    localStringBuilder.append(new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
    return localStringBuilder.toString();
  }
  
  public int compareTo(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return 0;
    }
    long l1 = paramStoryVideoItem.mCreateTime;
    long l2 = this.mCreateTime;
    if (l1 > l2) {
      return 1;
    }
    if (l1 < l2) {
      return -1;
    }
    return 0;
  }
  
  public void convertFrom(qqstory_group.CommentLikeCount paramCommentLikeCount)
  {
    this.debugSourceType = 10;
    this.mStoryType = 2;
    this.mVid = paramCommentLikeCount.story_id.get().toStringUtf8();
    this.mTotalLikeCount = paramCommentLikeCount.like_count.get();
    this.mCommentCount = paramCommentLikeCount.comment_count.get();
    if (paramCommentLikeCount.newly_three_like.has())
    {
      Object localObject = this.mLikeEntryList;
      if (localObject == null) {
        this.mLikeEntryList = new ArrayList();
      } else {
        ((List)localObject).clear();
      }
      paramCommentLikeCount = paramCommentLikeCount.newly_three_like.get().iterator();
      while (paramCommentLikeCount.hasNext())
      {
        localObject = (qqstory_group.NewlyLikeInfo)paramCommentLikeCount.next();
        this.mLikeEntryList.add(LikeEntry.convertFrom((qqstory_group.NewlyLikeInfo)localObject));
      }
      Collections.sort(this.mLikeEntryList);
    }
  }
  
  public void convertFrom(qqstory_struct.ShareGroupVideoInfo paramShareGroupVideoInfo)
  {
    this.debugSourceType = 9;
    if (paramShareGroupVideoInfo.owenr_name.has()) {
      this.mOwnerName = paramShareGroupVideoInfo.owenr_name.get().toStringUtf8();
    }
    if (paramShareGroupVideoInfo.union_id.has()) {
      this.mOwnerUid = paramShareGroupVideoInfo.union_id.get().toStringUtf8();
    }
    if (paramShareGroupVideoInfo.video_info.has())
    {
      qqstory_struct.FeedVideoInfo localFeedVideoInfo = (qqstory_struct.FeedVideoInfo)paramShareGroupVideoInfo.video_info.get();
      if (localFeedVideoInfo.video_cover.has()) {
        this.mVideoThumbnailUrl = localFeedVideoInfo.video_cover.get().toStringUtf8();
      }
      if (localFeedVideoInfo.vid.has()) {
        this.mVid = localFeedVideoInfo.vid.get().toStringUtf8();
      }
      if (localFeedVideoInfo.time.has()) {
        this.mCreateTime = (localFeedVideoInfo.time.get() * 1000L);
      }
    }
    if (paramShareGroupVideoInfo.feed_id.has()) {
      this.mAttachedFeedId = paramShareGroupVideoInfo.feed_id.get().toStringUtf8();
    }
  }
  
  public void convertFrom(qqstory_struct.StoryVideoFullInfo paramStoryVideoFullInfo)
  {
    this.debugSourceType = 6;
    this.mErrorCode = paramStoryVideoFullInfo.error.get();
    this.mVid = paramStoryVideoFullInfo.vid.get().toStringUtf8();
    this.mStoryType = paramStoryVideoFullInfo.type.get();
    this.mOwnerUid = paramStoryVideoFullInfo.union_id.get().toStringUtf8();
    this.mVideoUrl = paramStoryVideoFullInfo.video_url.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramStoryVideoFullInfo.video_cover.get().toStringUtf8();
    this.mOriginalMaskPicUrl = paramStoryVideoFullInfo.doodle_url.get().toStringUtf8();
    this.mCreateTime = (paramStoryVideoFullInfo.create_time.get() * 1000L);
    this.mVideoDuration = paramStoryVideoFullInfo.duration.get();
    this.mSourceType = paramStoryVideoFullInfo.source_type.get();
    convertFromVideoAttr(this, paramStoryVideoFullInfo.video_attr.get().toStringUtf8(), "StoryVideoFullInfo");
    this.mLinkInfoJson = paramStoryVideoFullInfo.video_extern_link_attr.get().toStringUtf8();
    if (paramStoryVideoFullInfo.ban_type.has()) {
      this.mBanType = paramStoryVideoFullInfo.ban_type.get();
    }
    if ((paramStoryVideoFullInfo.group_list != null) && (paramStoryVideoFullInfo.group_list.has())) {
      this.mVideoSpreadGroupList = new VideoSpreadGroupList(paramStoryVideoFullInfo.group_list);
    }
    if (paramStoryVideoFullInfo.video_source.has()) {
      this.mVideoSource = paramStoryVideoFullInfo.video_source.get();
    }
    if (paramStoryVideoFullInfo.url_flag.get() == 0)
    {
      this.mVideoUrl = paramStoryVideoFullInfo.video_url.get().toStringUtf8();
      this.mVideoThumbnailUrl = paramStoryVideoFullInfo.video_cover.get().toStringUtf8();
    }
    else
    {
      this.mTempVideoUrl = paramStoryVideoFullInfo.video_url.get().toStringUtf8();
      this.mTempThumbUrl = paramStoryVideoFullInfo.video_cover.get().toStringUtf8();
    }
    if (paramStoryVideoFullInfo.group_id.has()) {
      this.mGroupId = String.valueOf(paramStoryVideoFullInfo.group_id.get());
    }
    if (paramStoryVideoFullInfo.video_index.has()) {
      this.mVideoIndex = paramStoryVideoFullInfo.video_index.get();
    }
    if (paramStoryVideoFullInfo.video_tag.has()) {
      this.mTagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramStoryVideoFullInfo.video_tag.get());
    }
    if (paramStoryVideoFullInfo.qim_video_info.has()) {
      this.mQimVideoInfoItem = new QimVideoInfoItem((qqstory_struct.QimVideoInfo)paramStoryVideoFullInfo.qim_video_info.get());
    }
    if (paramStoryVideoFullInfo.player_scale_type.has()) {
      this.playerScaleType = paramStoryVideoFullInfo.player_scale_type.get();
    }
    if (paramStoryVideoFullInfo.ws_schema.has()) {
      this.mWsSchema = paramStoryVideoFullInfo.ws_schema.get().toStringUtf8();
    }
    if ((paramStoryVideoFullInfo.original_author_id.has()) && (paramStoryVideoFullInfo.original_author_name.has()))
    {
      this.originalAuthorUnionId = paramStoryVideoFullInfo.original_author_id.get();
      this.originalAuthorName = paramStoryVideoFullInfo.original_author_name.get().toStringUtf8();
    }
    if (paramStoryVideoFullInfo.video_url_expire_time.has()) {
      this.videoUrlExpireTime = (paramStoryVideoFullInfo.video_url_expire_time.get() * 1000L);
    }
    if (paramStoryVideoFullInfo.compared_vid.has()) {
      this.comparedVid = paramStoryVideoFullInfo.compared_vid.get().toStringUtf8();
    }
    if (paramStoryVideoFullInfo.video_source_tag_type.has())
    {
      this.mSourceTagType = paramStoryVideoFullInfo.video_source_tag_type.get();
      return;
    }
    this.mSourceTagType = 0;
  }
  
  public void convertFrom(String paramString, qqstory_group.VideoInfoItem paramVideoInfoItem)
  {
    this.debugSourceType = 5;
    this.mStoryType = 2;
    this.mVid = paramVideoInfoItem.story_id.get().toStringUtf8();
    this.mBasicInfoState = 1;
    this.mOwnerUid = paramVideoInfoItem.union_id.get().toStringUtf8();
    ((UserManager)SuperManager.a(2)).a(this.mOwnerUid, String.valueOf(paramVideoInfoItem.uin.get()));
    this.mCreateTime = (paramVideoInfoItem.publish_time.get() * 1000L);
    this.mVideoDuration = paramVideoInfoItem.duration.get();
    this.mVideoMd5 = paramVideoInfoItem.vid.get().toStringUtf8();
    if (paramVideoInfoItem.url_flag.get() == 0)
    {
      this.mVideoUrl = paramVideoInfoItem.download_url.get().toStringUtf8();
      this.mVideoThumbnailUrl = paramVideoInfoItem.cover_url.get().toStringUtf8();
    }
    else
    {
      this.mTempVideoUrl = paramVideoInfoItem.download_url.get().toStringUtf8();
      this.mTempThumbUrl = paramVideoInfoItem.cover_url.get().toStringUtf8();
    }
    convertFromVideoAttr(this, paramVideoInfoItem.video_attr.get().toStringUtf8(), paramString);
    if (paramVideoInfoItem.address.has()) {
      this.mLocation = AddressItem.getAddressFromProtoObject((qqstory_struct.Address)paramVideoInfoItem.address.get());
    }
    if (paramVideoInfoItem.group_id.has()) {
      this.mGroupId = String.valueOf(paramVideoInfoItem.group_id.get());
    }
    if (paramVideoInfoItem.doodle_url.has()) {
      this.mOriginalMaskPicUrl = paramVideoInfoItem.doodle_url.get().toStringUtf8();
    }
    if (paramVideoInfoItem.video_source.has()) {
      this.mVideoSource = paramVideoInfoItem.video_source.get();
    }
  }
  
  public void convertFrom(String paramString, qqstory_struct.DiscoveryShareGroupVideoInfo paramDiscoveryShareGroupVideoInfo)
  {
    this.mVid = paramDiscoveryShareGroupVideoInfo.vid.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramDiscoveryShareGroupVideoInfo.video_cover.get().toStringUtf8();
    this.mCreateTime = (paramDiscoveryShareGroupVideoInfo.time.get() * 1000L);
    convertFromVideoAttr(this, paramDiscoveryShareGroupVideoInfo.video_attr.get().toStringUtf8(), paramString, true);
  }
  
  public void convertFrom(String paramString, qqstory_struct.FeedVideoInfo paramFeedVideoInfo)
  {
    convertFrom(paramString, paramFeedVideoInfo, false);
  }
  
  public void convertFrom(String paramString, qqstory_struct.FeedVideoInfo paramFeedVideoInfo, boolean paramBoolean)
  {
    this.debugSourceType = 7;
    this.mVid = paramFeedVideoInfo.vid.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramFeedVideoInfo.video_cover.get().toStringUtf8();
    this.mCreateTime = (paramFeedVideoInfo.time.get() * 1000L);
    if (paramFeedVideoInfo.video_tag.has()) {
      this.mTagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramFeedVideoInfo.video_tag.get());
    }
    if (paramFeedVideoInfo.video_extern_link_attr.has()) {
      this.mLinkInfoJson = paramFeedVideoInfo.video_extern_link_attr.get().toStringUtf8();
    }
    convertFromVideoAttr(this, paramFeedVideoInfo.video_attr.get().toStringUtf8(), paramString, paramBoolean);
  }
  
  public void convertFrom(String paramString, qqstory_struct.GroupStoryInfo paramGroupStoryInfo)
  {
    this.debugSourceType = 1;
    this.mVid = paramGroupStoryInfo.story_id.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramGroupStoryInfo.video_cover.get().toStringUtf8();
    this.mOwnerUid = paramGroupStoryInfo.author_uin.get().toStringUtf8();
    this.mAddTime = paramGroupStoryInfo.vid_time.get();
    this.mVideoMd5 = paramGroupStoryInfo.story_id.get().toStringUtf8();
    this.mVideoSource = paramGroupStoryInfo.video_source.get();
  }
  
  public void convertFrom(String paramString, qqstory_struct.MultiRecommendItem paramMultiRecommendItem)
  {
    this.debugSourceType = 8;
    boolean bool = paramMultiRecommendItem.feed_id.has();
    String str3 = "";
    String str1;
    if (bool) {
      str1 = paramMultiRecommendItem.feed_id.get().toStringUtf8();
    } else {
      str1 = "";
    }
    String str2 = str3;
    if (paramMultiRecommendItem.rcmd_wording.has())
    {
      str2 = paramMultiRecommendItem.rcmd_wording.get();
      if (str2 == null) {
        str2 = str3;
      }
    }
    if (paramMultiRecommendItem.feed_video_info_list.has())
    {
      paramMultiRecommendItem = paramMultiRecommendItem.feed_video_info_list.get();
      if (!paramMultiRecommendItem.isEmpty())
      {
        convertFrom(paramString, (qqstory_struct.FeedVideoInfo)paramMultiRecommendItem.get(0));
        this.mAttachedFeedId = str1;
        this.mRecommendWording = str2;
      }
    }
  }
  
  public void convertFrom(String paramString, qqstory_struct.ShareGroupVideoInfo paramShareGroupVideoInfo)
  {
    convertFrom(paramString, (qqstory_struct.FeedVideoInfo)paramShareGroupVideoInfo.video_info.get(), true);
    this.mOwnerName = paramShareGroupVideoInfo.owenr_name.get().toStringUtf8();
    this.mOwnerUid = paramShareGroupVideoInfo.union_id.get().toStringUtf8();
  }
  
  public void convertFrom(String paramString, qqstory_struct.StoryVideoBasicInfo paramStoryVideoBasicInfo)
  {
    this.debugSourceType = 4;
    this.mCreateTime = (paramStoryVideoBasicInfo.create_time.get() * 1000L);
    this.mVid = paramStoryVideoBasicInfo.vid.get().toStringUtf8();
    this.mVideoUrl = paramStoryVideoBasicInfo.video_url.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramStoryVideoBasicInfo.video_cover.get().toStringUtf8();
    this.mVideoDuration = paramStoryVideoBasicInfo.video_total_time.get();
    this.mOwnerUid = paramStoryVideoBasicInfo.owner_union_id.get().toStringUtf8();
    convertFromVideoAttr(this, paramStoryVideoBasicInfo.video_attr.get().toStringUtf8(), paramString);
    if (paramStoryVideoBasicInfo.has_related_videos.has()) {
      this.mHasRelatedVideo = paramStoryVideoBasicInfo.has_related_videos.get();
    }
    this.mOriginalMaskPicUrl = paramStoryVideoBasicInfo.doodle_url.get().toStringUtf8();
    this.mLabel = paramStoryVideoBasicInfo.label.get().toStringUtf8();
    if (paramStoryVideoBasicInfo.ban_type.has()) {
      this.mBanType = paramStoryVideoBasicInfo.ban_type.get();
    }
    if (paramStoryVideoBasicInfo.address.has()) {
      this.mLocation = AddressItem.getAddressFromProtoObject((qqstory_struct.Address)paramStoryVideoBasicInfo.address.get());
    }
    if ((paramStoryVideoBasicInfo.group_list != null) && (paramStoryVideoBasicInfo.group_list.has())) {
      this.mVideoSpreadGroupList = new VideoSpreadGroupList(paramStoryVideoBasicInfo.group_list);
    }
    if (paramStoryVideoBasicInfo.video_source.has()) {
      this.mVideoSource = paramStoryVideoBasicInfo.video_source.get();
    }
    if (paramStoryVideoBasicInfo.video_index.has()) {
      this.mVideoIndex = paramStoryVideoBasicInfo.video_index.get();
    }
    if (paramStoryVideoBasicInfo.video_tag.has()) {
      this.mTagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramStoryVideoBasicInfo.video_tag.get());
    }
  }
  
  public void convertFrom(String paramString, qqstory_struct.StoryVideoFeature paramStoryVideoFeature)
  {
    this.debugSourceType = 3;
    this.mVid = paramStoryVideoFeature.vid.get().toStringUtf8();
    this.mViewCount = paramStoryVideoFeature.viewer_total_num.get();
    this.mStrangerViewCount = paramStoryVideoFeature.stranger_view_total_num.get();
    this.mUnreadLikeCount = paramStoryVideoFeature.uncheck_like_num.get();
    this.mTotalLikeCount = paramStoryVideoFeature.total_like_num.get();
    this.mCommentCount = paramStoryVideoFeature.total_comment_num.get();
    paramString = paramStoryVideoFeature.newest_like_list.get();
    this.mLikeEntryList = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      qqstory_struct.StoryVideoLikeInfo localStoryVideoLikeInfo = (qqstory_struct.StoryVideoLikeInfo)paramString.next();
      this.mLikeEntryList.add(LikeEntry.convertFrom(localStoryVideoLikeInfo));
    }
    Collections.sort(this.mLikeEntryList);
    this.mAllowComment = paramStoryVideoFeature.deny_comment.get();
    this.mViewTotalTime = paramStoryVideoFeature.viewing_total_num.get();
  }
  
  public void convertFrom(String paramString, qqstory_struct.StoryVideoSimpleInfo paramStoryVideoSimpleInfo)
  {
    this.debugSourceType = 2;
    this.mVid = paramStoryVideoSimpleInfo.vid.get().toStringUtf8();
    this.mVideoThumbnailUrl = paramStoryVideoSimpleInfo.video_cover.get().toStringUtf8();
    if (paramStoryVideoSimpleInfo.ban_type.has()) {
      this.mBanType = paramStoryVideoSimpleInfo.ban_type.get();
    }
    if ((paramStoryVideoSimpleInfo.group_list != null) && (paramStoryVideoSimpleInfo.group_list.has())) {
      this.mVideoSpreadGroupList = new VideoSpreadGroupList(paramStoryVideoSimpleInfo.group_list);
    }
    if (paramStoryVideoSimpleInfo.video_attr.has()) {
      convertFromVideoAttr(this, paramStoryVideoSimpleInfo.video_attr.get().toStringUtf8(), "StoryVideoSimpleInfo");
    }
  }
  
  public void convertFrom(String paramString, qqstory_struct.TagVideoInfo paramTagVideoInfo)
  {
    convertFrom(paramString, (qqstory_struct.FeedVideoInfo)paramTagVideoInfo.video_Info.get(), true);
    this.mOwnerName = paramTagVideoInfo.owner_name.get().toStringUtf8();
    this.mOwnerUid = paramTagVideoInfo.union_id.get().toStringUtf8();
    if (paramTagVideoInfo.feed_id.has()) {
      this.mAttachedFeedId = paramTagVideoInfo.feed_id.get().toStringUtf8();
    }
  }
  
  public void convertFrom(String paramString, qqstory_struct.VidPollInfo paramVidPollInfo)
  {
    this.mPollResult = paramVidPollInfo.self_poll_result.get();
    this.mPollUsers.clear();
    int j = paramVidPollInfo.video_poll_users.size();
    int i = 0;
    while (i < j)
    {
      paramString = (qqstory_struct.UserInfo)paramVidPollInfo.video_poll_users.get(i);
      QQUserUIItem localQQUserUIItem = new QQUserUIItem();
      localQQUserUIItem.convertFrom(paramString);
      this.mPollUsers.add(localQQUserUIItem);
      i += 1;
    }
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (StoryVideoItem)paramObject;
    this.mVid = paramObject.mVid;
    this.mErrorCode = paramObject.mErrorCode;
    int i = paramObject.mIsPicture;
    if (i != -1) {
      this.mIsPicture = i;
    }
    i = paramObject.mUploadStatus;
    if (i != -1) {
      this.mUploadStatus = i;
    }
    i = paramObject.mRetryUploadTimes;
    if (i != -1) {
      this.mRetryUploadTimes = i;
    }
    i = paramObject.mUpLoadFailedError;
    if (i != -1) {
      this.mUpLoadFailedError = i;
    }
    if (!TextUtils.isEmpty(paramObject.mLastUploadVid)) {
      this.mLastUploadVid = paramObject.mLastUploadVid;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoUrl)) {
      this.mVideoUrl = paramObject.mVideoUrl;
    }
    long l = paramObject.mCreateTime;
    if (l != -1L) {
      this.mCreateTime = l;
    }
    if (!TextUtils.isEmpty(paramObject.mPublishDate)) {
      this.mPublishDate = paramObject.mPublishDate;
    }
    i = paramObject.mViewCount;
    if (i != -1) {
      this.mViewCount = i;
    }
    l = paramObject.mViewTotalTime;
    if (l != -1L) {
      this.mViewTotalTime = l;
    }
    i = paramObject.mStrangerViewCount;
    if (i != -1) {
      this.mStrangerViewCount = i;
    }
    l = paramObject.mVideoDuration;
    if (l != -1L) {
      this.mVideoDuration = l;
    }
    i = paramObject.mVideoWidth;
    if (i != -1) {
      this.mVideoWidth = i;
    }
    i = paramObject.mVideoHeight;
    if (i != -1) {
      this.mVideoHeight = i;
    }
    l = paramObject.mVideoBytes;
    if (l != -1L) {
      this.mVideoBytes = l;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoThumbnailUrl)) {
      this.mVideoThumbnailUrl = paramObject.mVideoThumbnailUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mOriginalMaskPicUrl)) {
      this.mOriginalMaskPicUrl = paramObject.mOriginalMaskPicUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mLocalMaskPath)) {
      this.mLocalMaskPath = paramObject.mLocalMaskPath;
    }
    if (!TextUtils.isEmpty(paramObject.mAtJsonData)) {
      this.mAtJsonData = paramObject.mAtJsonData;
    }
    if (!TextUtils.isEmpty(paramObject.mAtImagePath)) {
      this.mAtImagePath = paramObject.mAtImagePath;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoLocalThumbnailPath)) {
      this.mVideoLocalThumbnailPath = paramObject.mVideoLocalThumbnailPath;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoLocalThumbnailOrigFakePath)) {
      this.mVideoLocalThumbnailOrigFakePath = paramObject.mVideoLocalThumbnailOrigFakePath;
    }
    if (!TextUtils.isEmpty(paramObject.mLocalVideoPath)) {
      this.mLocalVideoPath = paramObject.mLocalVideoPath;
    }
    if (!TextUtils.isEmpty(paramObject.mLabel)) {
      this.mLabel = paramObject.mLabel;
    }
    Object localObject = paramObject.mLocation;
    if (localObject != null) {
      this.mLocation = ((AddressItem)localObject);
    }
    if (!TextUtils.isEmpty(paramObject.mDoodleText)) {
      this.mDoodleText = paramObject.mDoodleText;
    }
    if (!TextUtils.isEmpty(paramObject.mOwnerUid)) {
      this.mOwnerUid = paramObject.mOwnerUid;
    }
    if (!TextUtils.isEmpty(paramObject.mOwnerName)) {
      this.mOwnerName = paramObject.mOwnerName;
    }
    i = paramObject.mHasRelatedVideo;
    if (i != -1) {
      this.mHasRelatedVideo = i;
    }
    this.mPreloadMsg = paramObject.mPreloadMsg;
    this.preloadPriority = paramObject.preloadPriority;
    i = paramObject.mUnreadLikeCount;
    if (i != -1) {
      this.mUnreadLikeCount = i;
    }
    i = paramObject.mTotalLikeCount;
    if (i != -1) {
      this.mTotalLikeCount = i;
    }
    i = paramObject.mCommentCount;
    if (i != -1) {
      this.mCommentCount = i;
    }
    localObject = paramObject.mLikeEntryList;
    if (localObject != null) {
      this.mLikeEntryList = ((List)localObject);
    }
    i = paramObject.mBasicInfoState;
    if (i != 0) {
      this.mBasicInfoState = i;
    }
    i = paramObject.mAllowComment;
    if (i != -1) {
      this.mAllowComment = i;
    }
    l = paramObject.mLocalCreateTime;
    if (l != -1L) {
      this.mLocalCreateTime = l;
    }
    localObject = paramObject.mLocalCreateLocation;
    if (localObject != null) {
      this.mLocalCreateLocation = ((String)localObject);
    }
    i = paramObject.mBanType;
    if (i != -1) {
      this.mBanType = i;
    }
    if (!TextUtils.isEmpty(paramObject.mDownloadNetType)) {
      this.mDownloadNetType = paramObject.mDownloadNetType;
    }
    if (!TextUtils.isEmpty(paramObject.mTempVideoUrl)) {
      this.mTempVideoUrl = paramObject.mTempVideoUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mTempThumbUrl)) {
      this.mTempThumbUrl = paramObject.mTempThumbUrl;
    }
    i = paramObject.mStoryType;
    if (i != 1) {
      this.mStoryType = i;
    }
    localObject = paramObject.mVideoSpreadGroupList;
    if (localObject != null) {
      this.mVideoSpreadGroupList = ((VideoSpreadGroupList)localObject);
    }
    if (!TextUtils.isEmpty(paramObject.mVideoMd5)) {
      this.mVideoMd5 = paramObject.mVideoMd5;
    }
    if (!TextUtils.isEmpty(paramObject.mGroupId)) {
      this.mGroupId = paramObject.mGroupId;
    }
    i = paramObject.mHadRead;
    if (i != -1) {
      this.mHadRead = i;
    }
    l = paramObject.mTimeZoneOffsetMillis;
    if (l != 2147483647L) {
      this.mTimeZoneOffsetMillis = l;
    }
    if (!TextUtils.isEmpty(paramObject.mUserSelectLocationText)) {
      this.mUserSelectLocationText = paramObject.mUserSelectLocationText;
    }
    if (!TextUtils.isEmpty(paramObject.shareGroupId)) {
      this.shareGroupId = paramObject.shareGroupId;
    }
    if (!TextUtils.isEmpty(paramObject.sourceVid)) {
      this.sourceVid = paramObject.sourceVid;
    }
    if (!TextUtils.isEmpty(paramObject.mAttachedFeedId)) {
      this.mAttachedFeedId = paramObject.mAttachedFeedId;
    }
    i = paramObject.mVideoSource;
    if (i != -1) {
      this.mVideoSource = i;
    }
    l = paramObject.mVideoIndex;
    if (l > 0L) {
      this.mVideoIndex = l;
    }
    i = paramObject.mInteractStatus;
    if (i != -1) {
      this.mInteractStatus = i;
    }
    localObject = paramObject.mTagInfoBase;
    if (localObject != null) {
      this.mTagInfoBase = ((TagItem.TagInfoBase)localObject);
    }
    localObject = paramObject.mCompInfoBase;
    if (localObject != null) {
      this.mCompInfoBase = ((CompInfoBase)localObject);
    }
    localObject = paramObject.mPollUsers;
    if (localObject != null) {
      this.mPollUsers = ((CopyOnWriteArrayList)localObject);
    }
    i = paramObject.mPollResult;
    if (i != -1) {
      this.mPollResult = i;
    }
    localObject = paramObject.mPollLayoutAttr;
    if (localObject != null) {
      this.mPollLayoutAttr = ((StoryVideoItem.PollLayout)localObject);
    }
    localObject = paramObject.mPollLayoutJson;
    if (localObject != null) {
      this.mPollLayoutJson = ((String)localObject);
    }
    localObject = paramObject.mPollNumbers;
    if (localObject != null) {
      this.mPollNumbers = ((int[])localObject);
    }
    if (!TextUtils.isEmpty(paramObject.mPollThumbnailUrl)) {
      this.mPollThumbnailUrl = paramObject.mPollThumbnailUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mPollThumbnailLocalPath)) {
      this.mPollThumbnailLocalPath = paramObject.mPollThumbnailLocalPath;
    }
    i = paramObject.hasParsedPollLayout;
    if (i != -1) {
      this.hasParsedPollLayout = i;
    }
    localObject = paramObject.mQimVideoInfoItem;
    if (localObject != null) {
      this.mQimVideoInfoItem = ((QimVideoInfoItem)localObject);
    }
    localObject = paramObject.mInteractLayoutJson;
    if (localObject != null) {
      this.mInteractLayoutJson = ((String)localObject);
    }
    localObject = paramObject.mInteractLayoutAttr;
    if (localObject != null) {
      this.mInteractLayoutAttr = ((StoryVideoItem.InteractPasterLayout)localObject);
    }
    i = paramObject.mRateResult;
    if (i != -1) {
      this.mRateResult = i;
    }
    i = paramObject.mTotalRateCount;
    if (i != -1) {
      this.mTotalRateCount = i;
    }
    l = paramObject.mTotalScore;
    if (l != -1L) {
      this.mTotalScore = l;
    }
    localObject = paramObject.mRateUsers;
    if (localObject != null) {
      this.mRateUsers = ((CopyOnWriteArrayList)localObject);
    }
    if (!TextUtils.isEmpty(paramObject.mInteractThumbnailUrl)) {
      this.mInteractThumbnailUrl = paramObject.mInteractThumbnailUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mInteractThumbnailLocalPath)) {
      this.mInteractThumbnailLocalPath = paramObject.mInteractThumbnailLocalPath;
    }
    if (!TextUtils.isEmpty(paramObject.mLinkInfoJson)) {
      this.mLinkInfoJson = paramObject.mLinkInfoJson;
    }
    if (!TextUtils.isEmpty(paramObject.mGameInfoJson)) {
      this.mGameInfoJson = paramObject.mGameInfoJson;
    }
    localObject = paramObject.mGameInfo;
    if (localObject != null) {
      this.mGameInfo = ((VideoGameInfo)localObject);
    }
    if (!TextUtils.isEmpty(paramObject.mOALinkInfoJson)) {
      this.mOALinkInfoJson = paramObject.mOALinkInfoJson;
    }
    localObject = paramObject.mOALinkInfo;
    if (localObject != null) {
      this.mOALinkInfo = ((VideoLinkInfo)localObject);
    }
    i = paramObject.mSourceType;
    if (i != -1) {
      this.mSourceType = i;
    }
    i = paramObject.playerScaleType;
    if (i != -1) {
      this.playerScaleType = i;
    }
    localObject = paramObject.mRecommendWording;
    if (localObject != null) {
      this.mRecommendWording = ((String)localObject);
    }
    if (TextUtils.isEmpty(paramObject.mWsSchema)) {
      this.mWsSchema = paramObject.mWsSchema;
    }
    l = paramObject.videoUrlExpireTime;
    if (l != -1L) {
      this.videoUrlExpireTime = l;
    }
    localObject = paramObject.comparedVid;
    if (localObject != null) {
      this.comparedVid = ((String)localObject);
    }
    i = paramObject.comparedLevel;
    if (i != 0) {
      this.comparedLevel = i;
    }
    i = paramObject.mSourceTagType;
    if (i != -2147483648) {
      this.mSourceTagType = i;
    }
    this.debugSourceType = paramObject.debugSourceType;
    if ((!TextUtils.isEmpty(paramObject.originalAuthorUnionId)) && (!TextUtils.isEmpty(paramObject.originalAuthorName)))
    {
      this.originalAuthorUnionId = paramObject.originalAuthorUnionId;
      this.originalAuthorName = paramObject.originalAuthorName;
    }
  }
  
  public StoryVideoEntry cover2StoryEntry()
  {
    StoryVideoEntry localStoryVideoEntry = new StoryVideoEntry();
    localStoryVideoEntry.vid = this.mVid;
    localStoryVideoEntry.localSpecialItemId = this.mLocalSpecialItemId;
    localStoryVideoEntry.videoUrl = this.mVideoUrl;
    localStoryVideoEntry.maskPicUrl = this.mOriginalMaskPicUrl;
    localStoryVideoEntry.videoThumbnailUrl = this.mVideoThumbnailUrl;
    localStoryVideoEntry.localVideoThumbnailPath = this.mVideoLocalThumbnailPath;
    localStoryVideoEntry.localVideoPath = this.mLocalVideoPath;
    localStoryVideoEntry.localMaskPicPath = this.mLocalMaskPath;
    localStoryVideoEntry.viewCount = this.mViewCount;
    localStoryVideoEntry.viewTotalTime = this.mViewTotalTime;
    localStoryVideoEntry.createTime = this.mCreateTime;
    localStoryVideoEntry.addTime = this.mAddTime;
    localStoryVideoEntry.mPublishDate = this.mPublishDate;
    localStoryVideoEntry.uploadStatus = this.mUploadStatus;
    localStoryVideoEntry.retryUploadTimes = this.mRetryUploadTimes;
    localStoryVideoEntry.lastUploadFailErrorCode = this.mUpLoadFailedError;
    localStoryVideoEntry.lastUploadVid = this.mLastUploadVid;
    localStoryVideoEntry.videoDuration = this.mVideoDuration;
    localStoryVideoEntry.videoWidth = this.mVideoWidth;
    localStoryVideoEntry.videoHeight = this.mVideoHeight;
    localStoryVideoEntry.videoBytes = this.mVideoBytes;
    localStoryVideoEntry.label = this.mLabel;
    localStoryVideoEntry.hasRelatedVideo = this.mHasRelatedVideo;
    localStoryVideoEntry.doodleText = this.mDoodleText;
    localStoryVideoEntry.ownerUnionId = this.mOwnerUid;
    localStoryVideoEntry.ownerName = this.mOwnerName;
    localStoryVideoEntry.strangerViewCount = this.mStrangerViewCount;
    localStoryVideoEntry.uncheckLikeNum = this.mUnreadLikeCount;
    localStoryVideoEntry.totalLikeNum = this.mTotalLikeCount;
    localStoryVideoEntry.detailInfoState = this.mBasicInfoState;
    localStoryVideoEntry.commentCount = this.mCommentCount;
    localStoryVideoEntry.likeEntryList = LikeEntry.convertFromItem(this.mLikeEntryList);
    Object localObject1 = this.mLocation;
    if (localObject1 != null) {
      localStoryVideoEntry.address = AddressItem.convertFromItem((AddressItem)localObject1);
    }
    localStoryVideoEntry.allowComment = this.mAllowComment;
    localStoryVideoEntry.atJsonData = this.mAtJsonData;
    localStoryVideoEntry.atImagePath = this.mAtImagePath;
    localStoryVideoEntry.isPicture = this.mIsPicture;
    localStoryVideoEntry.pollJsonData = this.mPollLayoutJson;
    localStoryVideoEntry.pollThumbnailLocalPath = this.mPollThumbnailLocalPath;
    localStoryVideoEntry.pollThumbnailUrl = this.mPollThumbnailUrl;
    localStoryVideoEntry.interactJsonData = this.mInteractLayoutJson;
    localStoryVideoEntry.interactThumbnailUrl = this.mInteractThumbnailUrl;
    localStoryVideoEntry.interactThumbnailLocalPath = this.mInteractThumbnailLocalPath;
    localStoryVideoEntry.localCreateTime = (this.mLocalCreateTime / 1000L);
    localStoryVideoEntry.localCreateLocation = this.mLocalCreateLocation;
    localStoryVideoEntry.banType = this.mBanType;
    localStoryVideoEntry.downloadNetType = this.mDownloadNetType;
    localStoryVideoEntry.storyType = this.mStoryType;
    localObject1 = this.mVideoSpreadGroupList;
    if (localObject1 != null)
    {
      localObject1 = ((VideoSpreadGroupList)localObject1).a();
      if ((localObject1 != null) && (((qqstory_struct.VideoSpreadGroupList)localObject1).has())) {
        localStoryVideoEntry.videoSpreadGroupList = ((qqstory_struct.VideoSpreadGroupList)localObject1).toByteArray();
      }
    }
    localStoryVideoEntry.md5 = this.mVideoMd5;
    localStoryVideoEntry.groupId = this.mGroupId;
    localStoryVideoEntry.hadRead = this.mHadRead;
    localStoryVideoEntry.timeZoneOffsetMillis = this.mTimeZoneOffsetMillis;
    localStoryVideoEntry.addressText = this.mUserSelectLocationText;
    localStoryVideoEntry.shareGroupId = this.shareGroupId;
    localStoryVideoEntry.sourceVid = this.sourceVid;
    localStoryVideoEntry.attachedFeedId = this.mAttachedFeedId;
    localStoryVideoEntry.mVideoSource = this.mVideoSource;
    localStoryVideoEntry.mVideoIndex = this.mVideoIndex;
    localStoryVideoEntry.mInteractStatus = this.mInteractStatus;
    localStoryVideoEntry.recommendWording = this.mRecommendWording;
    localObject1 = this.mTagInfoBase;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new qqstory_struct.TagInfoBase();
      ((qqstory_struct.TagInfoBase)localObject2).tag_id.set(((TagItem.TagInfoBase)localObject1).jdField_a_of_type_Long);
      ((qqstory_struct.TagInfoBase)localObject2).tag_type.set(((TagItem.TagInfoBase)localObject1).jdField_a_of_type_Int);
      ((qqstory_struct.TagInfoBase)localObject2).tag_name.set(((TagItem.TagInfoBase)localObject1).jdField_a_of_type_JavaLangString);
      ((qqstory_struct.TagInfoBase)localObject2).tag_desc.set(((TagItem.TagInfoBase)localObject1).b);
      localStoryVideoEntry.mTagBytes = ((qqstory_struct.TagInfoBase)localObject2).toByteArray();
    }
    localObject1 = this.mCompInfoBase;
    if (localObject1 != null)
    {
      localObject2 = new qqstory_struct.CompInfoBase();
      ((qqstory_struct.CompInfoBase)localObject2).title.set(((CompInfoBase)localObject1).jdField_a_of_type_JavaLangString);
      ((qqstory_struct.CompInfoBase)localObject2).backgroud_url.set(((CompInfoBase)localObject1).b);
      localStoryVideoEntry.mCompBytes = ((qqstory_struct.CompInfoBase)localObject2).toByteArray();
    }
    localObject1 = this.mPollNumbers;
    int i;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mPollNumbers[0]);
      i = 1;
      while (i < this.mPollNumbers.length)
      {
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(this.mPollNumbers[i]);
        i += 1;
      }
      localStoryVideoEntry.pollNumbers = ((StringBuilder)localObject1).toString();
    }
    QQUserUIItem localQQUserUIItem;
    if (this.mPollUsers.size() > 0)
    {
      localObject1 = new LocalStruct.PollUserItems();
      localObject2 = this.mPollUsers.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localQQUserUIItem = (QQUserUIItem)((Iterator)localObject2).next();
        if (localQQUserUIItem != null) {
          ((LocalStruct.PollUserItems)localObject1).users.add(localQQUserUIItem.toPBItem());
        } else {
          i = 1;
        }
      }
      localStoryVideoEntry.mPollUsersBytes = ((LocalStruct.PollUserItems)localObject1).toByteArray();
    }
    else
    {
      i = 0;
    }
    localStoryVideoEntry.pollResult = this.mPollResult;
    localStoryVideoEntry.rateResult = this.mRateResult;
    localStoryVideoEntry.totalRateCount = this.mTotalRateCount;
    localStoryVideoEntry.totalScore = this.mTotalScore;
    localStoryVideoEntry.linkInfoJson = this.mLinkInfoJson;
    localStoryVideoEntry.oaLinkInfoJson = this.mOALinkInfoJson;
    localStoryVideoEntry.gameInfoJson = this.mGameInfoJson;
    if (this.mRateUsers.size() > 0)
    {
      localObject1 = new LocalStruct.PollUserItems();
      localObject2 = this.mRateUsers.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localQQUserUIItem = (QQUserUIItem)((Iterator)localObject2).next();
        ((LocalStruct.PollUserItems)localObject1).users.add(localQQUserUIItem.toPBItem());
      }
      localStoryVideoEntry.rateUsersBytes = ((LocalStruct.PollUserItems)localObject1).toByteArray();
    }
    localObject1 = this.mQimVideoInfoItem;
    if (localObject1 != null) {
      localStoryVideoEntry.mQimBytes = ((QimVideoInfoItem)localObject1).a();
    }
    localStoryVideoEntry.mSourceType = this.mSourceType;
    localStoryVideoEntry.playerScaleType = this.playerScaleType;
    localStoryVideoEntry.wsSchema = this.mWsSchema;
    localStoryVideoEntry.originalAuthorUnionId = this.originalAuthorUnionId;
    localStoryVideoEntry.originalAuthorName = this.originalAuthorName;
    localStoryVideoEntry.videoUrlExpireTime = this.videoUrlExpireTime;
    localStoryVideoEntry.comparedVid = this.comparedVid;
    localStoryVideoEntry.comparedLevel = this.comparedLevel;
    localStoryVideoEntry.sourceTagType = this.mSourceTagType;
    if (i != 0)
    {
      new IllegalStateException("Error on cover2StoryEntry");
      SLog.e("StoryVideoItem", "cover2StoryEntry badData: vid=%s, polllist=%s", new Object[] { this.mVid, this.mPollUsers });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cover2StoryEntry, ");
      ((StringBuilder)localObject1).append(this.mPollUsers.toString());
      CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.a(((StringBuilder)localObject1).toString(), null), "StoryVideoItem::cover2StoryEntry bad data");
    }
    return localStoryVideoEntry;
  }
  
  public qqstory_struct.FeedVideoInfo covertToPBFeedVideoInfo(String paramString)
  {
    qqstory_struct.FeedVideoInfo localFeedVideoInfo = new qqstory_struct.FeedVideoInfo();
    localFeedVideoInfo.vid.set(ByteStringMicro.copyFromUtf8(this.mVid));
    localFeedVideoInfo.time.set(this.mCreateTime / 1000L);
    if (this.mTagInfoBase != null) {
      localFeedVideoInfo.video_tag.set(this.mTagInfoBase.a());
    }
    localFeedVideoInfo.video_cover.set(ByteStringMicro.copyFromUtf8(this.mVideoThumbnailUrl));
    localFeedVideoInfo.video_attr.set(ByteStringMicro.copyFromUtf8(convertToVideoAttr(this, paramString)));
    return localFeedVideoInfo;
  }
  
  public qqstory_struct.MultiRecommendItem covertToPBMultiRecommendItem(String paramString)
  {
    qqstory_struct.MultiRecommendItem localMultiRecommendItem = new qqstory_struct.MultiRecommendItem();
    if (!TextUtils.isEmpty(this.mAttachedFeedId)) {
      localMultiRecommendItem.feed_id.set(ByteStringMicro.copyFromUtf8(this.mAttachedFeedId));
    }
    if (this.mRecommendWording != null) {
      localMultiRecommendItem.rcmd_wording.set(this.mRecommendWording);
    }
    localMultiRecommendItem.feed_video_info_list.add(covertToPBFeedVideoInfo(paramString));
    return localMultiRecommendItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (StoryVideoItem)paramObject;
      return this.mVid.equals(paramObject.mVid);
    }
    return false;
  }
  
  public String getDownloadMaskUrl()
  {
    if (TextUtils.isEmpty(this.mOriginalMaskPicUrl)) {
      return this.mOriginalMaskPicUrl;
    }
    if (!this.mOriginalMaskPicUrl.endsWith(File.separator))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mOriginalMaskPicUrl);
      localStringBuilder.append(File.separator);
      this.mOriginalMaskPicUrl = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mOriginalMaskPicUrl);
    localStringBuilder.append("1000/");
    return localStringBuilder.toString();
  }
  
  public String getDownloadPollUrl()
  {
    if (TextUtils.isEmpty(this.mPollThumbnailUrl)) {
      return this.mPollThumbnailUrl;
    }
    if (!this.mPollThumbnailUrl.endsWith(File.separator))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mPollThumbnailUrl);
      localStringBuilder.append(File.separator);
      this.mPollThumbnailUrl = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPollThumbnailUrl);
    localStringBuilder.append("1000/");
    return localStringBuilder.toString();
  }
  
  public String getInteractDescription()
  {
    if (!isInteractVideo()) {
      return "NotInteractItem";
    }
    return String.format("InteractItem%s-%s-%s-%s", new Object[] { this.mVid, String.valueOf(this.mRateResult), String.valueOf(this.mTotalScore), String.valueOf(this.mTotalRateCount) });
  }
  
  public StoryVideoItem.InteractPasterLayout getInteractLayout()
  {
    if (!isInteractVideo()) {
      return null;
    }
    if (this.mInteractLayoutAttr == null) {
      this.mInteractLayoutAttr = StoryVideoItem.InteractPasterLayout.a(this.mInteractLayoutJson);
    }
    return this.mInteractLayoutAttr;
  }
  
  public VideoLinkInfo getOALinkInfo()
  {
    if (this.mOALinkInfo == null) {
      this.mOALinkInfo = VideoLinkInfo.a(this.mOALinkInfoJson);
    }
    return this.mOALinkInfo;
  }
  
  public String getPollDescription()
  {
    if (!isPollVideo()) {
      return "NotPollItem";
    }
    return String.format("PollItem%s-%s-%s", new Object[] { this.mVid, String.valueOf(ArrayUtils.a(this.mPollNumbers)), String.valueOf(this.mPollResult) });
  }
  
  public StoryVideoItem.PollLayout getPollLayout()
  {
    if ((this.mPollLayoutAttr == null) && (this.hasParsedPollLayout != 1) && (!TextUtils.isEmpty(this.mPollLayoutJson)))
    {
      this.mPollLayoutAttr = StoryVideoItem.PollLayout.a(this.mPollLayoutJson);
      this.hasParsedPollLayout = 1;
      return this.mPollLayoutAttr;
    }
    return this.mPollLayoutAttr;
  }
  
  public String getThumbUrl()
  {
    if (TextUtils.isEmpty(this.mVideoThumbnailUrl)) {
      return this.mTempThumbUrl;
    }
    return this.mVideoThumbnailUrl;
  }
  
  public VideoGameInfo getVideoGameInfo()
  {
    VideoLinkInfo localVideoLinkInfo = getOALinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a != null)) {
      return localVideoLinkInfo.a;
    }
    if (this.mGameInfo == null) {
      this.mGameInfo = VideoGameInfo.a(this.mGameInfoJson);
    }
    return this.mGameInfo;
  }
  
  public VideoLinkInfo getVideoLinkInfo()
  {
    if (this.mVideoLinkInfo == null) {
      this.mVideoLinkInfo = VideoLinkInfo.a(this.mLinkInfoJson);
    }
    return this.mVideoLinkInfo;
  }
  
  public int getVideoMaskType()
  {
    boolean bool1 = isMaskVideo();
    boolean bool2 = FileUtils.c(this.mAtImagePath);
    if (bool1)
    {
      if (bool2) {
        return 3;
      }
      return 1;
    }
    if (bool2) {
      return 2;
    }
    return 0;
  }
  
  public String getVideoUrl()
  {
    if (TextUtils.isEmpty(this.mVideoUrl)) {
      return this.mTempVideoUrl;
    }
    return this.mVideoUrl;
  }
  
  public boolean hasRelativeVideo()
  {
    return this.mHasRelatedVideo == 1;
  }
  
  public int hashCode()
  {
    return this.mVid.hashCode();
  }
  
  public boolean isBasicInfoOK()
  {
    return (!TextUtils.isEmpty(this.mVideoUrl)) || (!TextUtils.isEmpty(this.mTempVideoUrl)) || (isFakeVid(this.mVid));
  }
  
  public boolean isCancel()
  {
    return this.mUploadStatus == 7;
  }
  
  public boolean isGameVideo()
  {
    return getVideoGameInfo() != null;
  }
  
  public boolean isInteractVideo()
  {
    return TextUtils.isEmpty(this.mInteractLayoutJson) ^ true;
  }
  
  public boolean isLocalAddShareGroupVideo()
  {
    return TextUtils.isEmpty(this.sourceVid) ^ true;
  }
  
  public int isMaskDownloaded()
  {
    if (TextUtils.isEmpty(this.mOriginalMaskPicUrl)) {
      return -1;
    }
    if (FileCacheUtils.a(this.mVid, 1, false, false) != null) {
      return 1;
    }
    return 0;
  }
  
  public boolean isMaskVideo()
  {
    String str = this.mLocalMaskPath;
    if ((str == null) || (str.equals(""))) {
      str = this.mOriginalMaskPicUrl;
    }
    return (str != null) && (!str.equals(""));
  }
  
  public boolean isMine()
  {
    return QQStoryContext.a().b().equals(this.mOwnerUid);
  }
  
  public boolean isPollVideo()
  {
    return StringUtil.a(this.mPollLayoutJson) ^ true;
  }
  
  public boolean isTroopLocalVideoOnly()
  {
    VideoSpreadGroupList localVideoSpreadGroupList = this.mVideoSpreadGroupList;
    return (localVideoSpreadGroupList != null) && (localVideoSpreadGroupList.jdField_a_of_type_Int == 4);
  }
  
  public boolean isUploadFail()
  {
    int i = this.mUploadStatus;
    return (i == 6) || (i == 3);
  }
  
  public boolean isUploadSuc()
  {
    int i = this.mUploadStatus;
    return (i == 5) || (i == -1);
  }
  
  public boolean isUploading()
  {
    return (!isUploadFail()) && (!isUploadSuc()) && (!isCancel());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoItem{mVid='");
    localStringBuilder.append(this.mVid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCreateTime=");
    localStringBuilder.append(this.mCreateTime);
    localStringBuilder.append(", mUploadStatus=");
    localStringBuilder.append(this.mUploadStatus);
    localStringBuilder.append(", mOwnerUid=");
    localStringBuilder.append(this.mOwnerUid);
    localStringBuilder.append(", mOwnerName=");
    localStringBuilder.append(this.mOwnerName);
    localStringBuilder.append(", mVideoUrl='");
    localStringBuilder.append(this.mVideoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoThumbnailUrl='");
    localStringBuilder.append(this.mVideoThumbnailUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOriginalMaskPicUrl='");
    localStringBuilder.append(this.mOriginalMaskPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mViewCount=");
    localStringBuilder.append(this.mViewCount);
    localStringBuilder.append(", mViewTotalTime=");
    localStringBuilder.append(this.mViewTotalTime);
    localStringBuilder.append(", mVideoDuration=");
    localStringBuilder.append(this.mVideoDuration);
    localStringBuilder.append(", mVideoWidth=");
    localStringBuilder.append(this.mVideoWidth);
    localStringBuilder.append(", mVideoHeight=");
    localStringBuilder.append(this.mVideoHeight);
    localStringBuilder.append(", mVideoBytes=");
    localStringBuilder.append(this.mVideoBytes);
    localStringBuilder.append(", mVideoLocalThumbnailPath='");
    localStringBuilder.append(this.mVideoLocalThumbnailPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLocalVideoPath='");
    localStringBuilder.append(this.mLocalVideoPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLocalMaskPath='");
    localStringBuilder.append(this.mLocalMaskPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mHasRelatedVideo=");
    localStringBuilder.append(this.mHasRelatedVideo);
    localStringBuilder.append(", mDoodleText='");
    localStringBuilder.append(this.mDoodleText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStrangerViewCount=");
    localStringBuilder.append(this.mStrangerViewCount);
    localStringBuilder.append(", mUnreadLikeCount=");
    localStringBuilder.append(this.mUnreadLikeCount);
    localStringBuilder.append(", mTotalLikeCount=");
    localStringBuilder.append(this.mTotalLikeCount);
    localStringBuilder.append(", mStrangerLikeCount=");
    localStringBuilder.append(this.mStrangerLikeCount);
    localStringBuilder.append(", mIsPlaying=");
    localStringBuilder.append(this.mIsPlaying);
    localStringBuilder.append(", mPreloadMsg='");
    localStringBuilder.append(this.mPreloadMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", preloadPriority=");
    localStringBuilder.append(this.preloadPriority);
    localStringBuilder.append(", mUpLoadFailedError=");
    localStringBuilder.append(this.mUpLoadFailedError);
    localStringBuilder.append(", mBasicInfoState=");
    localStringBuilder.append(this.mBasicInfoState);
    localStringBuilder.append(", mAllowComment=");
    localStringBuilder.append(this.mAllowComment);
    localStringBuilder.append(", mAtJsonData='");
    localStringBuilder.append(this.mAtJsonData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAtImagePath='");
    localStringBuilder.append(this.mAtImagePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsPicture='");
    localStringBuilder.append(this.mIsPicture);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDownloadNetType='");
    localStringBuilder.append(this.mDownloadNetType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTempVideoUrl='");
    localStringBuilder.append(this.mTempVideoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTempThumbUrl='");
    localStringBuilder.append(this.mTempThumbUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStoryType='");
    localStringBuilder.append(this.mStoryType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoMd5='");
    localStringBuilder.append(this.mVideoMd5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mGroupId='");
    localStringBuilder.append(this.mGroupId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoSource=");
    localStringBuilder.append(this.mVideoSource);
    localStringBuilder.append(", mVideoIndex=");
    localStringBuilder.append(this.mVideoIndex);
    localStringBuilder.append(",debugSourceType=");
    localStringBuilder.append(this.debugSourceType);
    localStringBuilder.append(",mErrorCode=");
    localStringBuilder.append(this.mErrorCode);
    localStringBuilder.append(", mQimVideoInfoItem=");
    localStringBuilder.append(String.valueOf(this.mQimVideoInfoItem));
    localStringBuilder.append(", comparedVid=");
    localStringBuilder.append(this.comparedVid);
    localStringBuilder.append(", comparedLevel=");
    localStringBuilder.append(this.comparedLevel);
    localStringBuilder.append(", sourceTagType=");
    localStringBuilder.append(this.mSourceTagType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public long uniqueKey()
  {
    return (this.mVid.hashCode() << 32) + this.mOwnerUid.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoItem
 * JD-Core Version:    0.7.0.1
 */