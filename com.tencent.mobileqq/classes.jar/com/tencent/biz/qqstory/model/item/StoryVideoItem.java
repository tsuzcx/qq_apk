package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import awpu;
import baip;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.LocalStruct.PollUserItems;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
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
import org.json.JSONException;
import org.json.JSONObject;
import sfp;
import shq;
import sqd;
import sqg;
import sqs;
import sro;
import srp;
import srq;
import srt;
import srv;
import srx;
import tri;
import uje;
import urk;
import vid;
import vil;
import vkv;
import vlm;
import vmn;

public class StoryVideoItem
  extends BaseUIItem
  implements Comparable<StoryVideoItem>, sfp
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
  public int mAllowComment = -1;
  public String mAtImagePath;
  public String mAtJsonData;
  public String mAttachedFeedId = "";
  public int mBanType = -1;
  public int mBasicInfoState = 0;
  public int mCommentCount = -1;
  public vid mCompInfoBase;
  public long mCreateTime = -1L;
  public String mDoodleText;
  public String mDownloadNetType;
  public int mErrorCode;
  public srt mGameInfo;
  public String mGameInfoJson;
  public String mGroupId;
  public int mHadRead = -1;
  public int mHasLike = -1;
  public int mHasRelatedVideo = -1;
  private srp mInteractLayoutAttr;
  public String mInteractLayoutJson;
  public int mInteractStatus = -1;
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
  public srv mOALinkInfo;
  public String mOALinkInfoJson;
  public String mOriginalMaskPicUrl;
  public String mOwnerName = "";
  public String mOwnerUid = "";
  private srq mPollLayoutAttr;
  public String mPollLayoutJson;
  public int[] mPollNumbers;
  public int mPollResult = -1;
  public String mPollThumbnailLocalPath;
  public String mPollThumbnailUrl;
  public CopyOnWriteArrayList<QQUserUIItem> mPollUsers = new CopyOnWriteArrayList();
  public String mPreloadMsg;
  public String mPublishDate;
  public sro mQimVideoInfoItem;
  public int mRateResult = -1;
  public CopyOnWriteArrayList<QQUserUIItem> mRateUsers = new CopyOnWriteArrayList();
  public String mRecommendWording;
  public int mRetryUploadTimes;
  public int mSourceTagType = -2147483648;
  public int mSourceType = -1;
  public int mStoryType = 1;
  public int mStrangerLikeCount = -1;
  public int mStrangerViewCount = -1;
  public vil mTagInfoBase;
  public String mTempThumbUrl;
  public String mTempVideoUrl;
  public long mTimeZoneOffsetMillis = 2147483647L;
  public int mTotalLikeCount = -1;
  public int mTotalRateCount = -1;
  public long mTotalScore = -1L;
  public int mUnreadLikeCount = -1;
  public int mUpLoadFailedError = 0;
  public int mUploadStatus = -1;
  public String mUserSelectLocationText;
  public String mVid;
  public long mVideoBytes = -1L;
  public long mVideoDuration = -1L;
  public int mVideoHeight = -1;
  public long mVideoIndex;
  public srv mVideoLinkInfo;
  public String mVideoLocalThumbnailOrigFakePath;
  public String mVideoLocalThumbnailPath;
  public String mVideoMd5;
  public int mVideoSource = -1;
  public srx mVideoSpreadGroupList;
  public String mVideoThumbnailUrl;
  public String mVideoUrl;
  public int mVideoWidth = -1;
  public int mViewCount = -1;
  public long mViewTotalTime = -1L;
  public String mWsSchema = "";
  public String originalAuthorName;
  public String originalAuthorUnionId;
  public int playerScaleType = -1;
  public int preloadPriority = 1;
  public String shareGroupId;
  public String sourceVid;
  public long videoUrlExpireTime = -1L;
  
  public StoryVideoItem()
  {
    this.debugSourceType = 100;
  }
  
  public StoryVideoItem(StoryVideoEntry paramStoryVideoEntry)
  {
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
      this.mPublishDate = uje.a().format(new Date(this.mCreateTime));
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
      this.mAllowComment = paramStoryVideoEntry.allowComment;
      this.mAtJsonData = paramStoryVideoEntry.atJsonData;
      this.mAtImagePath = paramStoryVideoEntry.atImagePath;
      this.mIsPicture = paramStoryVideoEntry.isPicture;
      this.mLocalCreateTime = (paramStoryVideoEntry.localCreateTime * 1000L);
      this.mLocalCreateLocation = paramStoryVideoEntry.localCreateLocation;
      this.mBanType = paramStoryVideoEntry.banType;
      this.mDownloadNetType = paramStoryVideoEntry.downloadNetType;
      this.mStoryType = paramStoryVideoEntry.storyType;
      if ((paramStoryVideoEntry.videoSpreadGroupList != null) && (paramStoryVideoEntry.videoSpreadGroupList.length > 0)) {
        localObject = new qqstory_struct.VideoSpreadGroupList();
      }
    }
    catch (Exception localInvalidProtocolBufferMicroException1)
    {
      try
      {
        ((qqstory_struct.VideoSpreadGroupList)localObject).mergeFrom(paramStoryVideoEntry.videoSpreadGroupList);
        this.mVideoSpreadGroupList = new srx((qqstory_struct.VideoSpreadGroupList)localObject);
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
        if ((paramStoryVideoEntry.mTagBytes != null) && (paramStoryVideoEntry.mTagBytes.length > 0)) {
          localObject = new qqstory_struct.TagInfoBase();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          ((qqstory_struct.TagInfoBase)localObject).mergeFrom(paramStoryVideoEntry.mTagBytes);
          this.mTagInfoBase = new vil((qqstory_struct.TagInfoBase)localObject);
          if ((paramStoryVideoEntry.mCompBytes != null) && (paramStoryVideoEntry.mCompBytes.length > 0)) {
            localObject = new qqstory_struct.CompInfoBase();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            do
            {
              for (;;)
              {
                ((qqstory_struct.CompInfoBase)localObject).mergeFrom(paramStoryVideoEntry.mCompBytes);
                this.mCompInfoBase = new vid((qqstory_struct.CompInfoBase)localObject);
                this.mPollLayoutJson = paramStoryVideoEntry.pollJsonData;
                if (TextUtils.isEmpty(paramStoryVideoEntry.pollNumbers)) {
                  break;
                }
                Object localObject = paramStoryVideoEntry.pollNumbers.split(",");
                int k = localObject.length;
                this.mPollNumbers = new int[k];
                i = 0;
                while (i < k)
                {
                  this.mPollNumbers[i] = Integer.parseInt(localObject[i]);
                  i += 1;
                }
                localException = localException;
                urk.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localException.toString());
                localException.printStackTrace();
                continue;
                localInvalidProtocolBufferMicroException5 = localInvalidProtocolBufferMicroException5;
                if (QLog.isColorLevel()) {
                  urk.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localInvalidProtocolBufferMicroException5.toString());
                }
              }
              localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
            } while (!QLog.isColorLevel());
            urk.b("StoryVideoItem ,StoryVideoItem(StoryVideoEntry entry) error :", localInvalidProtocolBufferMicroException1.toString());
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            int i;
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("StoryVideoItem", 2, localInvalidProtocolBufferMicroException2.toString());
              }
            }
            QQUserUIItem localQQUserUIItem;
            if ((paramStoryVideoEntry.mPollUsersBytes != null) && (paramStoryVideoEntry.mPollUsersBytes.length > 0)) {
              try
              {
                LocalStruct.PollUserItems localPollUserItems1 = new LocalStruct.PollUserItems();
                localPollUserItems1.mergeFrom(paramStoryVideoEntry.mPollUsersBytes);
                i = 0;
                while (i < localPollUserItems1.users.size())
                {
                  localQQUserUIItem = new QQUserUIItem();
                  localQQUserUIItem.convertFrom((qqstory_struct.UserInfo)localPollUserItems1.users.get(i));
                  this.mPollUsers.add(localQQUserUIItem);
                  i += 1;
                }
                this.mPollThumbnailUrl = paramStoryVideoEntry.pollThumbnailUrl;
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3) {}
            }
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
            if ((paramStoryVideoEntry.rateUsersBytes != null) && (paramStoryVideoEntry.rateUsersBytes.length > 0)) {
              try
              {
                LocalStruct.PollUserItems localPollUserItems2 = new LocalStruct.PollUserItems();
                localPollUserItems2.mergeFrom(paramStoryVideoEntry.rateUsersBytes);
                i = j;
                while (i < localPollUserItems2.users.size())
                {
                  localQQUserUIItem = new QQUserUIItem();
                  localQQUserUIItem.convertFrom((qqstory_struct.UserInfo)localPollUserItems2.users.get(i));
                  this.mRateUsers.add(localQQUserUIItem);
                  i += 1;
                }
                this.mQimVideoInfoItem = sro.a(paramStoryVideoEntry.mQimBytes);
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4) {}
            }
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
        }
      }
    }
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
          break label543;
        }
        if (!paramString1.has("add_tz")) {
          break label549;
        }
      }
      catch (Exception paramStoryVideoItem)
      {
        urk.b(paramString2, "decode json fail", paramStoryVideoItem);
      }
      if (i != 0)
      {
        paramStoryVideoItem.mTimeZoneOffsetMillis = paramString1.optInt("add_tz", 2147483647);
        if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
          paramStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
        }
        paramStoryVideoItem.mLocalSpecialItemId = paramString1.optString("mLocalSpecialItemId");
        localObject = paramString1.optJSONArray("ml");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramStoryVideoItem.mAtJsonData = ((JSONArray)localObject).toString();
          return true;
        }
      }
      else
      {
        paramStoryVideoItem.mTimeZoneOffsetMillis = paramString1.optInt("tz", 2147483647);
        if (paramStoryVideoItem.mTimeZoneOffsetMillis == 2147483647L) {
          continue;
        }
        paramStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
        continue;
        return false;
      }
      Object localObject = paramString1.optJSONObject("pl");
      if ((localObject != null) && (paramStoryVideoItem.hasParsedPollLayout != 1))
      {
        paramStoryVideoItem.mPollLayoutAttr = srq.a((JSONObject)localObject);
        if (paramStoryVideoItem.mPollLayoutAttr == null)
        {
          paramStoryVideoItem.mPollLayoutJson = null;
          label361:
          paramStoryVideoItem.hasParsedPollLayout = 1;
          urk.b(paramString2, "pl: " + ((JSONObject)localObject).toString());
        }
      }
      else
      {
        paramStoryVideoItem.mPollThumbnailUrl = paramString1.optString("pl_pic");
        localObject = paramString1.optJSONObject("i_l");
        if (localObject != null)
        {
          paramStoryVideoItem.mInteractLayoutAttr = srp.a((JSONObject)localObject);
          if (paramStoryVideoItem.mInteractLayoutAttr != null) {
            break label529;
          }
        }
      }
      label529:
      for (paramStoryVideoItem.mInteractLayoutJson = null;; paramStoryVideoItem.mInteractLayoutJson = paramStoryVideoItem.mInteractLayoutAttr.a())
      {
        urk.b(paramString2, "il: " + ((JSONObject)localObject).toString());
        paramStoryVideoItem.mInteractThumbnailUrl = paramString1.optString("il_pic");
        paramStoryVideoItem.mGameInfoJson = paramString1.optString("game");
        paramStoryVideoItem.mGameInfo = srt.a(paramStoryVideoItem.mGameInfoJson);
        paramStoryVideoItem.comparedLevel = paramString1.optInt("comp_lv");
        break;
        paramStoryVideoItem.mPollLayoutJson = paramStoryVideoItem.mPollLayoutAttr.a();
        break label361;
      }
      label543:
      int i = 1;
      continue;
      label549:
      i = 0;
    }
  }
  
  public static String convertToVideoAttr(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (paramStoryVideoItem.mVideoWidth != -1) {
          localJSONObject.put("video_width", paramStoryVideoItem.mVideoWidth);
        }
        if (paramStoryVideoItem.mVideoHeight != -1) {
          localJSONObject.put("video_height", paramStoryVideoItem.mVideoHeight);
        }
        if (paramStoryVideoItem.mVideoBytes != -1L) {
          localJSONObject.put("video_bytes", paramStoryVideoItem.mVideoBytes);
        }
        if (paramStoryVideoItem.mIsPicture != -1) {
          localJSONObject.put("is_pic", paramStoryVideoItem.mIsPicture);
        }
        if (!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) {
          localJSONObject.put("video_doodle_text", paramStoryVideoItem.mDoodleText);
        }
        boolean bool = TextUtils.isEmpty(paramStoryVideoItem.mAtJsonData);
        if (bool) {}
      }
      catch (JSONException paramStoryVideoItem)
      {
        urk.b(paramString, "encode json fail", paramStoryVideoItem);
        continue;
      }
      try
      {
        localJSONObject.put("ml", new JSONArray(paramStoryVideoItem.mAtJsonData));
        if (paramStoryVideoItem.mLocalCreateTime != -1L) {
          localJSONObject.put("ct", paramStoryVideoItem.mLocalCreateTime / 1000L);
        }
        if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalCreateLocation)) {
          localJSONObject.put("loc", paramStoryVideoItem.mLocalCreateLocation);
        }
        if (paramStoryVideoItem.mLatitude != -1) {
          localJSONObject.put("lat", paramStoryVideoItem.mLatitude);
        }
        if (paramStoryVideoItem.mLongitude != -1) {
          localJSONObject.put("lon", paramStoryVideoItem.mLongitude);
        }
        localJSONObject.put("mLocalSpecialItemId", paramStoryVideoItem.mLocalSpecialItemId);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONObject.put("ml", paramStoryVideoItem.mAtJsonData);
      }
    }
  }
  
  public static String dump(List<StoryVideoItem> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((StoryVideoItem)paramList.next()).mVid).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String getCacheKey(String paramString)
  {
    StoryVideoItem localStoryVideoItem = ((sqd)sqg.a(5)).a(paramString);
    if (localStoryVideoItem == null) {}
    while (TextUtils.isEmpty(localStoryVideoItem.mVideoMd5)) {
      return paramString;
    }
    return localStoryVideoItem.mVideoMd5;
  }
  
  public static int getPlayableFlag(String paramString, boolean paramBoolean)
  {
    StoryVideoItem localStoryVideoItem = ((sqd)sqg.a(5)).a(paramString);
    if ((localStoryVideoItem == null) || (localStoryVideoItem.isMaskDownloaded() == 0)) {
      return 1;
    }
    if ((paramBoolean) && (tri.a(BaseApplicationImpl.getContext()).a()) && ((!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (!TextUtils.isEmpty(localStoryVideoItem.mTempVideoUrl)))) {
      return 2;
    }
    if (shq.a(paramString, 0, false, false) != null) {
      return 3;
    }
    return 4;
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
    return "fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt();
  }
  
  public int compareTo(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    do
    {
      return 0;
      if (paramStoryVideoItem.mCreateTime > this.mCreateTime) {
        return 1;
      }
    } while (paramStoryVideoItem.mCreateTime >= this.mCreateTime);
    return -1;
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
      if (this.mLikeEntryList == null) {
        this.mLikeEntryList = new ArrayList();
      }
      for (;;)
      {
        paramCommentLikeCount = paramCommentLikeCount.newly_three_like.get().iterator();
        while (paramCommentLikeCount.hasNext())
        {
          qqstory_group.NewlyLikeInfo localNewlyLikeInfo = (qqstory_group.NewlyLikeInfo)paramCommentLikeCount.next();
          this.mLikeEntryList.add(LikeEntry.convertFrom(localNewlyLikeInfo));
        }
        this.mLikeEntryList.clear();
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
      this.mVideoSpreadGroupList = new srx(paramStoryVideoFullInfo.group_list);
    }
    if (paramStoryVideoFullInfo.video_source.has()) {
      this.mVideoSource = paramStoryVideoFullInfo.video_source.get();
    }
    if (paramStoryVideoFullInfo.url_flag.get() == 0)
    {
      this.mVideoUrl = paramStoryVideoFullInfo.video_url.get().toStringUtf8();
      this.mVideoThumbnailUrl = paramStoryVideoFullInfo.video_cover.get().toStringUtf8();
    }
    for (;;)
    {
      if (paramStoryVideoFullInfo.group_id.has()) {
        this.mGroupId = String.valueOf(paramStoryVideoFullInfo.group_id.get());
      }
      if (paramStoryVideoFullInfo.video_index.has()) {
        this.mVideoIndex = paramStoryVideoFullInfo.video_index.get();
      }
      if (paramStoryVideoFullInfo.video_tag.has()) {
        this.mTagInfoBase = new vil((qqstory_struct.TagInfoBase)paramStoryVideoFullInfo.video_tag.get());
      }
      if (paramStoryVideoFullInfo.qim_video_info.has()) {
        this.mQimVideoInfoItem = new sro((qqstory_struct.QimVideoInfo)paramStoryVideoFullInfo.qim_video_info.get());
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
      if (!paramStoryVideoFullInfo.video_source_tag_type.has()) {
        break;
      }
      this.mSourceTagType = paramStoryVideoFullInfo.video_source_tag_type.get();
      return;
      this.mTempVideoUrl = paramStoryVideoFullInfo.video_url.get().toStringUtf8();
      this.mTempThumbUrl = paramStoryVideoFullInfo.video_cover.get().toStringUtf8();
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
    ((sqs)sqg.a(2)).a(this.mOwnerUid, String.valueOf(paramVideoInfoItem.uin.get()));
    this.mCreateTime = (paramVideoInfoItem.publish_time.get() * 1000L);
    this.mVideoDuration = paramVideoInfoItem.duration.get();
    this.mVideoMd5 = paramVideoInfoItem.vid.get().toStringUtf8();
    if (paramVideoInfoItem.url_flag.get() == 0)
    {
      this.mVideoUrl = paramVideoInfoItem.download_url.get().toStringUtf8();
      this.mVideoThumbnailUrl = paramVideoInfoItem.cover_url.get().toStringUtf8();
    }
    for (;;)
    {
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
      return;
      this.mTempVideoUrl = paramVideoInfoItem.download_url.get().toStringUtf8();
      this.mTempThumbUrl = paramVideoInfoItem.cover_url.get().toStringUtf8();
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
      this.mTagInfoBase = new vil((qqstory_struct.TagInfoBase)paramFeedVideoInfo.video_tag.get());
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
    if (paramMultiRecommendItem.feed_id.has()) {}
    for (String str1 = paramMultiRecommendItem.feed_id.get().toStringUtf8();; str1 = "")
    {
      Object localObject = "";
      if (paramMultiRecommendItem.rcmd_wording.has())
      {
        String str2 = paramMultiRecommendItem.rcmd_wording.get();
        localObject = str2;
        if (str2 == null) {
          localObject = "";
        }
      }
      for (;;)
      {
        if (paramMultiRecommendItem.feed_video_info_list.has())
        {
          paramMultiRecommendItem = paramMultiRecommendItem.feed_video_info_list.get();
          if (!paramMultiRecommendItem.isEmpty())
          {
            convertFrom(paramString, (qqstory_struct.FeedVideoInfo)paramMultiRecommendItem.get(0));
            this.mAttachedFeedId = str1;
            this.mRecommendWording = ((String)localObject);
          }
        }
        return;
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
      this.mVideoSpreadGroupList = new srx(paramStoryVideoBasicInfo.group_list);
    }
    if (paramStoryVideoBasicInfo.video_source.has()) {
      this.mVideoSource = paramStoryVideoBasicInfo.video_source.get();
    }
    if (paramStoryVideoBasicInfo.video_index.has()) {
      this.mVideoIndex = paramStoryVideoBasicInfo.video_index.get();
    }
    if (paramStoryVideoBasicInfo.video_tag.has()) {
      this.mTagInfoBase = new vil((qqstory_struct.TagInfoBase)paramStoryVideoBasicInfo.video_tag.get());
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
      this.mVideoSpreadGroupList = new srx(paramStoryVideoSimpleInfo.group_list);
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
    if (paramObject.mIsPicture != -1) {
      this.mIsPicture = paramObject.mIsPicture;
    }
    if (paramObject.mUploadStatus != -1) {
      this.mUploadStatus = paramObject.mUploadStatus;
    }
    if (paramObject.mRetryUploadTimes != -1) {
      this.mRetryUploadTimes = paramObject.mRetryUploadTimes;
    }
    if (paramObject.mUpLoadFailedError != -1) {
      this.mUpLoadFailedError = paramObject.mUpLoadFailedError;
    }
    if (!TextUtils.isEmpty(paramObject.mLastUploadVid)) {
      this.mLastUploadVid = paramObject.mLastUploadVid;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoUrl)) {
      this.mVideoUrl = paramObject.mVideoUrl;
    }
    if (paramObject.mCreateTime != -1L) {
      this.mCreateTime = paramObject.mCreateTime;
    }
    if (!TextUtils.isEmpty(paramObject.mPublishDate)) {
      this.mPublishDate = paramObject.mPublishDate;
    }
    if (paramObject.mViewCount != -1) {
      this.mViewCount = paramObject.mViewCount;
    }
    if (paramObject.mViewTotalTime != -1L) {
      this.mViewTotalTime = paramObject.mViewTotalTime;
    }
    if (paramObject.mStrangerViewCount != -1) {
      this.mStrangerViewCount = paramObject.mStrangerViewCount;
    }
    if (paramObject.mVideoDuration != -1L) {
      this.mVideoDuration = paramObject.mVideoDuration;
    }
    if (paramObject.mVideoWidth != -1) {
      this.mVideoWidth = paramObject.mVideoWidth;
    }
    if (paramObject.mVideoHeight != -1) {
      this.mVideoHeight = paramObject.mVideoHeight;
    }
    if (paramObject.mVideoBytes != -1L) {
      this.mVideoBytes = paramObject.mVideoBytes;
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
    if (paramObject.mLocation != null) {
      this.mLocation = paramObject.mLocation;
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
    if (paramObject.mHasRelatedVideo != -1) {
      this.mHasRelatedVideo = paramObject.mHasRelatedVideo;
    }
    this.mPreloadMsg = paramObject.mPreloadMsg;
    this.preloadPriority = paramObject.preloadPriority;
    if (paramObject.mUnreadLikeCount != -1) {
      this.mUnreadLikeCount = paramObject.mUnreadLikeCount;
    }
    if (paramObject.mTotalLikeCount != -1) {
      this.mTotalLikeCount = paramObject.mTotalLikeCount;
    }
    if (paramObject.mCommentCount != -1) {
      this.mCommentCount = paramObject.mCommentCount;
    }
    if (paramObject.mLikeEntryList != null) {
      this.mLikeEntryList = paramObject.mLikeEntryList;
    }
    if (paramObject.mBasicInfoState != 0) {
      this.mBasicInfoState = paramObject.mBasicInfoState;
    }
    if (paramObject.mAllowComment != -1) {
      this.mAllowComment = paramObject.mAllowComment;
    }
    if (paramObject.mLocalCreateTime != -1L) {
      this.mLocalCreateTime = paramObject.mLocalCreateTime;
    }
    if (paramObject.mLocalCreateLocation != null) {
      this.mLocalCreateLocation = paramObject.mLocalCreateLocation;
    }
    if (paramObject.mBanType != -1) {
      this.mBanType = paramObject.mBanType;
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
    if (paramObject.mStoryType != 1) {
      this.mStoryType = paramObject.mStoryType;
    }
    if (paramObject.mVideoSpreadGroupList != null) {
      this.mVideoSpreadGroupList = paramObject.mVideoSpreadGroupList;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoMd5)) {
      this.mVideoMd5 = paramObject.mVideoMd5;
    }
    if (!TextUtils.isEmpty(paramObject.mGroupId)) {
      this.mGroupId = paramObject.mGroupId;
    }
    if (paramObject.mHadRead != -1) {
      this.mHadRead = paramObject.mHadRead;
    }
    if (paramObject.mTimeZoneOffsetMillis != 2147483647L) {
      this.mTimeZoneOffsetMillis = paramObject.mTimeZoneOffsetMillis;
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
    if (paramObject.mVideoSource != -1) {
      this.mVideoSource = paramObject.mVideoSource;
    }
    if (paramObject.mVideoIndex > 0L) {
      this.mVideoIndex = paramObject.mVideoIndex;
    }
    if (paramObject.mInteractStatus != -1) {
      this.mInteractStatus = paramObject.mInteractStatus;
    }
    if (paramObject.mTagInfoBase != null) {
      this.mTagInfoBase = paramObject.mTagInfoBase;
    }
    if (paramObject.mCompInfoBase != null) {
      this.mCompInfoBase = paramObject.mCompInfoBase;
    }
    if (paramObject.mPollUsers != null) {
      this.mPollUsers = paramObject.mPollUsers;
    }
    if (paramObject.mPollResult != -1) {
      this.mPollResult = paramObject.mPollResult;
    }
    if (paramObject.mPollLayoutAttr != null) {
      this.mPollLayoutAttr = paramObject.mPollLayoutAttr;
    }
    if (paramObject.mPollLayoutJson != null) {
      this.mPollLayoutJson = paramObject.mPollLayoutJson;
    }
    if (paramObject.mPollNumbers != null) {
      this.mPollNumbers = paramObject.mPollNumbers;
    }
    if (!TextUtils.isEmpty(paramObject.mPollThumbnailUrl)) {
      this.mPollThumbnailUrl = paramObject.mPollThumbnailUrl;
    }
    if (!TextUtils.isEmpty(paramObject.mPollThumbnailLocalPath)) {
      this.mPollThumbnailLocalPath = paramObject.mPollThumbnailLocalPath;
    }
    if (paramObject.hasParsedPollLayout != -1) {
      this.hasParsedPollLayout = paramObject.hasParsedPollLayout;
    }
    if (paramObject.mQimVideoInfoItem != null) {
      this.mQimVideoInfoItem = paramObject.mQimVideoInfoItem;
    }
    if (paramObject.mInteractLayoutJson != null) {
      this.mInteractLayoutJson = paramObject.mInteractLayoutJson;
    }
    if (paramObject.mInteractLayoutAttr != null) {
      this.mInteractLayoutAttr = paramObject.mInteractLayoutAttr;
    }
    if (paramObject.mRateResult != -1) {
      this.mRateResult = paramObject.mRateResult;
    }
    if (paramObject.mTotalRateCount != -1) {
      this.mTotalRateCount = paramObject.mTotalRateCount;
    }
    if (paramObject.mTotalScore != -1L) {
      this.mTotalScore = paramObject.mTotalScore;
    }
    if (paramObject.mRateUsers != null) {
      this.mRateUsers = paramObject.mRateUsers;
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
    if (paramObject.mGameInfo != null) {
      this.mGameInfo = paramObject.mGameInfo;
    }
    if (!TextUtils.isEmpty(paramObject.mOALinkInfoJson)) {
      this.mOALinkInfoJson = paramObject.mOALinkInfoJson;
    }
    if (paramObject.mOALinkInfo != null) {
      this.mOALinkInfo = paramObject.mOALinkInfo;
    }
    if (paramObject.mSourceType != -1) {
      this.mSourceType = paramObject.mSourceType;
    }
    if (paramObject.playerScaleType != -1) {
      this.playerScaleType = paramObject.playerScaleType;
    }
    if (paramObject.mRecommendWording != null) {
      this.mRecommendWording = paramObject.mRecommendWording;
    }
    if (TextUtils.isEmpty(paramObject.mWsSchema)) {
      this.mWsSchema = paramObject.mWsSchema;
    }
    if (paramObject.videoUrlExpireTime != -1L) {
      this.videoUrlExpireTime = paramObject.videoUrlExpireTime;
    }
    if (paramObject.comparedVid != null) {
      this.comparedVid = paramObject.comparedVid;
    }
    if (paramObject.comparedLevel != 0) {
      this.comparedLevel = paramObject.comparedLevel;
    }
    if (paramObject.mSourceTagType != -2147483648) {
      this.mSourceTagType = paramObject.mSourceTagType;
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
    if (this.mLocation != null) {
      localStoryVideoEntry.address = AddressItem.convertFromItem(this.mLocation);
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
    if (this.mVideoSpreadGroupList != null)
    {
      localObject1 = this.mVideoSpreadGroupList.a();
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
    Object localObject1 = this.mTagInfoBase;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new qqstory_struct.TagInfoBase();
      ((qqstory_struct.TagInfoBase)localObject2).tag_id.set(((vil)localObject1).jdField_a_of_type_Long);
      ((qqstory_struct.TagInfoBase)localObject2).tag_type.set(((vil)localObject1).jdField_a_of_type_Int);
      ((qqstory_struct.TagInfoBase)localObject2).tag_name.set(((vil)localObject1).jdField_a_of_type_JavaLangString);
      ((qqstory_struct.TagInfoBase)localObject2).tag_desc.set(((vil)localObject1).b);
      localStoryVideoEntry.mTagBytes = ((qqstory_struct.TagInfoBase)localObject2).toByteArray();
    }
    localObject1 = this.mCompInfoBase;
    if (localObject1 != null)
    {
      localObject2 = new qqstory_struct.CompInfoBase();
      ((qqstory_struct.CompInfoBase)localObject2).title.set(((vid)localObject1).jdField_a_of_type_JavaLangString);
      ((qqstory_struct.CompInfoBase)localObject2).backgroud_url.set(((vid)localObject1).b);
      localStoryVideoEntry.mCompBytes = ((qqstory_struct.CompInfoBase)localObject2).toByteArray();
    }
    int i;
    if ((this.mPollNumbers != null) && (this.mPollNumbers.length > 0))
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
      if (((Iterator)localObject2).hasNext())
      {
        localQQUserUIItem = (QQUserUIItem)((Iterator)localObject2).next();
        if (localQQUserUIItem != null) {
          ((LocalStruct.PollUserItems)localObject1).users.add(localQQUserUIItem.toPBItem());
        }
        for (;;)
        {
          break;
          i = 1;
        }
      }
      localStoryVideoEntry.mPollUsersBytes = ((LocalStruct.PollUserItems)localObject1).toByteArray();
    }
    for (;;)
    {
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
      if (this.mQimVideoInfoItem != null) {
        localStoryVideoEntry.mQimBytes = this.mQimVideoInfoItem.a();
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
        urk.e("StoryVideoItem", "cover2StoryEntry badData: vid=%s, polllist=%s", new Object[] { this.mVid, this.mPollUsers });
        awpu.a(vmn.a("cover2StoryEntry, " + this.mPollUsers.toString(), null), "StoryVideoItem::cover2StoryEntry bad data");
      }
      return localStoryVideoEntry;
      i = 0;
    }
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
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (StoryVideoItem)paramObject;
    return this.mVid.equals(paramObject.mVid);
  }
  
  public String getDownloadMaskUrl()
  {
    if (TextUtils.isEmpty(this.mOriginalMaskPicUrl)) {
      return this.mOriginalMaskPicUrl;
    }
    if (!this.mOriginalMaskPicUrl.endsWith(File.separator)) {
      this.mOriginalMaskPicUrl += File.separator;
    }
    return this.mOriginalMaskPicUrl + "1000/";
  }
  
  public String getDownloadPollUrl()
  {
    if (TextUtils.isEmpty(this.mPollThumbnailUrl)) {
      return this.mPollThumbnailUrl;
    }
    if (!this.mPollThumbnailUrl.endsWith(File.separator)) {
      this.mPollThumbnailUrl += File.separator;
    }
    return this.mPollThumbnailUrl + "1000/";
  }
  
  public String getInteractDescription()
  {
    if (!isInteractVideo()) {
      return "NotInteractItem";
    }
    return String.format("InteractItem%s-%s-%s-%s", new Object[] { this.mVid, String.valueOf(this.mRateResult), String.valueOf(this.mTotalScore), String.valueOf(this.mTotalRateCount) });
  }
  
  public srp getInteractLayout()
  {
    if (!isInteractVideo()) {
      return null;
    }
    if (this.mInteractLayoutAttr == null) {
      this.mInteractLayoutAttr = srp.a(this.mInteractLayoutJson);
    }
    return this.mInteractLayoutAttr;
  }
  
  public srv getOALinkInfo()
  {
    if (this.mOALinkInfo == null) {
      this.mOALinkInfo = srv.a(this.mOALinkInfoJson);
    }
    return this.mOALinkInfo;
  }
  
  public String getPollDescription()
  {
    if (!isPollVideo()) {
      return "NotPollItem";
    }
    return String.format("PollItem%s-%s-%s", new Object[] { this.mVid, String.valueOf(vkv.a(this.mPollNumbers)), String.valueOf(this.mPollResult) });
  }
  
  public srq getPollLayout()
  {
    if ((this.mPollLayoutAttr != null) || (this.hasParsedPollLayout == 1) || (TextUtils.isEmpty(this.mPollLayoutJson))) {
      return this.mPollLayoutAttr;
    }
    this.mPollLayoutAttr = srq.a(this.mPollLayoutJson);
    this.hasParsedPollLayout = 1;
    return this.mPollLayoutAttr;
  }
  
  public String getThumbUrl()
  {
    if (TextUtils.isEmpty(this.mVideoThumbnailUrl)) {
      return this.mTempThumbUrl;
    }
    return this.mVideoThumbnailUrl;
  }
  
  public srt getVideoGameInfo()
  {
    srv localsrv = getOALinkInfo();
    if ((localsrv != null) && (localsrv.a != null)) {
      return localsrv.a;
    }
    if (this.mGameInfo == null) {
      this.mGameInfo = srt.a(this.mGameInfoJson);
    }
    return this.mGameInfo;
  }
  
  public srv getVideoLinkInfo()
  {
    if (this.mVideoLinkInfo == null) {
      this.mVideoLinkInfo = srv.a(this.mLinkInfoJson);
    }
    return this.mVideoLinkInfo;
  }
  
  public int getVideoMaskType()
  {
    boolean bool1 = isMaskVideo();
    boolean bool2 = vlm.c(this.mAtImagePath);
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
    return !TextUtils.isEmpty(this.mInteractLayoutJson);
  }
  
  public boolean isLocalAddShareGroupVideo()
  {
    return !TextUtils.isEmpty(this.sourceVid);
  }
  
  public int isMaskDownloaded()
  {
    int i = 1;
    if (TextUtils.isEmpty(this.mOriginalMaskPicUrl)) {
      i = -1;
    }
    while (shq.a(this.mVid, 1, false, false) != null) {
      return i;
    }
    return 0;
  }
  
  public boolean isMaskVideo()
  {
    return ((this.mLocalMaskPath != null) && (!this.mLocalMaskPath.equals(""))) || ((this.mOriginalMaskPicUrl != null) && (!this.mOriginalMaskPicUrl.equals("")));
  }
  
  public boolean isMine()
  {
    return QQStoryContext.a().b().equals(this.mOwnerUid);
  }
  
  public boolean isPollVideo()
  {
    return !baip.a(this.mPollLayoutJson);
  }
  
  public boolean isTroopLocalVideoOnly()
  {
    return (this.mVideoSpreadGroupList != null) && (this.mVideoSpreadGroupList.jdField_a_of_type_Int == 4);
  }
  
  public boolean isUploadFail()
  {
    return (this.mUploadStatus == 6) || (this.mUploadStatus == 3);
  }
  
  public boolean isUploadSuc()
  {
    return (this.mUploadStatus == 5) || (this.mUploadStatus == -1);
  }
  
  public boolean isUploading()
  {
    return (!isUploadFail()) && (!isUploadSuc()) && (!isCancel());
  }
  
  public String toString()
  {
    return "StoryVideoItem{mVid='" + this.mVid + '\'' + ", mCreateTime=" + this.mCreateTime + ", mUploadStatus=" + this.mUploadStatus + ", mOwnerUid=" + this.mOwnerUid + ", mOwnerName=" + this.mOwnerName + ", mVideoUrl='" + this.mVideoUrl + '\'' + ", mVideoThumbnailUrl='" + this.mVideoThumbnailUrl + '\'' + ", mOriginalMaskPicUrl='" + this.mOriginalMaskPicUrl + '\'' + ", mViewCount=" + this.mViewCount + ", mViewTotalTime=" + this.mViewTotalTime + ", mVideoDuration=" + this.mVideoDuration + ", mVideoWidth=" + this.mVideoWidth + ", mVideoHeight=" + this.mVideoHeight + ", mVideoBytes=" + this.mVideoBytes + ", mVideoLocalThumbnailPath='" + this.mVideoLocalThumbnailPath + '\'' + ", mLocalVideoPath='" + this.mLocalVideoPath + '\'' + ", mLocalMaskPath='" + this.mLocalMaskPath + '\'' + ", mHasRelatedVideo=" + this.mHasRelatedVideo + ", mDoodleText='" + this.mDoodleText + '\'' + ", mStrangerViewCount=" + this.mStrangerViewCount + ", mUnreadLikeCount=" + this.mUnreadLikeCount + ", mTotalLikeCount=" + this.mTotalLikeCount + ", mStrangerLikeCount=" + this.mStrangerLikeCount + ", mIsPlaying=" + this.mIsPlaying + ", mPreloadMsg='" + this.mPreloadMsg + '\'' + ", preloadPriority=" + this.preloadPriority + ", mUpLoadFailedError=" + this.mUpLoadFailedError + ", mBasicInfoState=" + this.mBasicInfoState + ", mAllowComment=" + this.mAllowComment + ", mAtJsonData='" + this.mAtJsonData + '\'' + ", mAtImagePath='" + this.mAtImagePath + '\'' + ", mIsPicture='" + this.mIsPicture + '\'' + ", mDownloadNetType='" + this.mDownloadNetType + '\'' + ", mTempVideoUrl='" + this.mTempVideoUrl + '\'' + ", mTempThumbUrl='" + this.mTempThumbUrl + '\'' + ", mStoryType='" + this.mStoryType + '\'' + ", mVideoMd5='" + this.mVideoMd5 + '\'' + ", mGroupId='" + this.mGroupId + '\'' + ", mVideoSource=" + this.mVideoSource + ", mVideoIndex=" + this.mVideoIndex + ",debugSourceType=" + this.debugSourceType + ",mErrorCode=" + this.mErrorCode + ", mQimVideoInfoItem=" + String.valueOf(this.mQimVideoInfoItem) + ", comparedVid=" + this.comparedVid + ", comparedLevel=" + this.comparedLevel + ", sourceTagType=" + this.mSourceTagType + '}';
  }
  
  public long uniqueKey()
  {
    return (this.mVid.hashCode() << 32) + this.mOwnerUid.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoItem
 * JD-Core Version:    0.7.0.1
 */