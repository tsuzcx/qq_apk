package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.CommentLikeFeed;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import wqq;
import yjy;

public abstract class VideoListFeedItem<T extends yjy, E extends wqq>
  extends CommentLikeFeedItem<T, E>
{
  public static final String TAG = "VideoListFeedItem";
  public boolean isReportedAutoPlay;
  public boolean mHasPublicVideo;
  public boolean mHasTag;
  public boolean mIsContribute;
  public boolean mIsVideoEnd;
  public String mQimSyncWording;
  public String mVideoNextCookie = "";
  public int mVideoPullType = 0;
  public int mVideoSeq = -1;
  
  @NonNull
  public static String makeFakeFeedId(String paramString1, String paramString2)
  {
    return "fake-" + paramString1 + paramString2;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (VideoListFeedItem)paramObject;
    if (paramObject.mVideoSeq != -1) {
      this.mVideoSeq = paramObject.mVideoSeq;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoNextCookie)) {
      this.mVideoNextCookie = paramObject.mVideoNextCookie;
    }
    this.mIsVideoEnd = paramObject.mIsVideoEnd;
    if (paramObject.mVideoPullType != -1) {
      this.mVideoPullType = paramObject.mVideoPullType;
    }
    this.mIsContribute = paramObject.mIsContribute;
    this.mHasTag = paramObject.mHasTag;
    this.mHasPublicVideo = paramObject.mHasPublicVideo;
    this.mQimSyncWording = paramObject.mQimSyncWording;
  }
  
  public FeedVideoInfo getVideoInfo()
  {
    FeedVideoInfo localFeedVideoInfo = new FeedVideoInfo();
    localFeedVideoInfo.feedId = this.feedId;
    localFeedVideoInfo.mVideoSeq = this.mVideoSeq;
    localFeedVideoInfo.mIsVideoEnd = this.mIsVideoEnd;
    localFeedVideoInfo.mVideoNextCookie = this.mVideoNextCookie;
    localFeedVideoInfo.mVideoPullType = this.mVideoPullType;
    return localFeedVideoInfo;
  }
  
  public boolean isFakeFeedItem()
  {
    return isFakeFeedId(this.feedId);
  }
  
  public abstract boolean isMyFeedItem();
  
  public void onRefresh()
  {
    super.onRefresh();
    this.isReportedAutoPlay = false;
  }
  
  protected void readVideoListFeedLocalPB(SerializationPB.VideoListFeed paramVideoListFeed)
  {
    boolean bool2 = true;
    super.readCommentLikeFeedLocalPB(paramVideoListFeed.commet_like_feed);
    this.mVideoSeq = paramVideoListFeed.video_seq.get();
    this.mVideoNextCookie = paramVideoListFeed.video_next_cookie.get();
    this.mVideoPullType = paramVideoListFeed.video_pull_type.get();
    if (paramVideoListFeed.is_video_end.get() == 1)
    {
      bool1 = true;
      this.mIsVideoEnd = bool1;
      if (paramVideoListFeed.is_contribute.get() != 1) {
        break label145;
      }
      bool1 = true;
      label74:
      this.mIsContribute = bool1;
      if (paramVideoListFeed.has_tag.get() != 1) {
        break label150;
      }
      bool1 = true;
      label92:
      this.mHasTag = bool1;
      if (paramVideoListFeed.has_public_video.get() != 1) {
        break label155;
      }
    }
    label145:
    label150:
    label155:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mHasPublicVideo = bool1;
      if (paramVideoListFeed.qim_sync_wording.has()) {
        this.mQimSyncWording = paramVideoListFeed.qim_sync_wording.get().toStringUtf8();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label74;
      bool1 = false;
      break label92;
    }
  }
  
  public void reset()
  {
    super.reset();
    this.mIsContribute = false;
    this.mHasTag = false;
  }
  
  public String toSimpleString()
  {
    return "VideoListFeedItem{feedId='" + this.feedId + '\'' + ", date='" + this.date + '\'' + ", dateTimeMillis='" + this.dateTimeMillis + '\'' + '}';
  }
  
  public String toString()
  {
    return "VideoListFeedItem{mIsContribute=" + this.mIsContribute + "mHasTag=" + this.mHasTag + "mHasPublicVideo=" + this.mHasPublicVideo + ", mVideoSeq=" + this.mVideoSeq + ", mVideoNextCookie='" + this.mVideoNextCookie + '\'' + ", mIsVideoEnd=" + this.mIsVideoEnd + ", mVideoPullType=" + this.mVideoPullType + ", mQimSyncWording=" + this.mQimSyncWording + '}' + super.toString();
  }
  
  public void updateVideoInfo(FeedVideoInfo paramFeedVideoInfo)
  {
    this.mVideoSeq = paramFeedVideoInfo.mVideoSeq;
    this.mVideoNextCookie = paramFeedVideoInfo.mVideoNextCookie;
    this.mIsVideoEnd = paramFeedVideoInfo.mIsVideoEnd;
    this.mVideoPullType = paramFeedVideoInfo.mVideoPullType;
  }
  
  protected SerializationPB.VideoListFeed writeVideoListFeedLocalPB()
  {
    int j = 1;
    SerializationPB.VideoListFeed localVideoListFeed = new SerializationPB.VideoListFeed();
    localVideoListFeed.video_seq.set(this.mVideoSeq);
    Object localObject2 = localVideoListFeed.video_next_cookie;
    int i;
    if (TextUtils.isEmpty(this.mVideoNextCookie))
    {
      localObject1 = "";
      ((PBStringField)localObject2).set((String)localObject1);
      localVideoListFeed.video_pull_type.set(this.mVideoPullType);
      localObject1 = localVideoListFeed.is_video_end;
      if (!this.mIsVideoEnd) {
        break label190;
      }
      i = 1;
      label76:
      ((PBUInt32Field)localObject1).set(i);
      localObject1 = localVideoListFeed.is_contribute;
      if (!this.mIsContribute) {
        break label195;
      }
      i = 1;
      label96:
      ((PBUInt32Field)localObject1).set(i);
      localObject1 = localVideoListFeed.has_tag;
      if (!this.mHasTag) {
        break label200;
      }
      i = 1;
      label116:
      ((PBUInt32Field)localObject1).set(i);
      localObject1 = localVideoListFeed.has_public_video;
      if (!this.mHasPublicVideo) {
        break label205;
      }
      i = j;
      label136:
      ((PBUInt32Field)localObject1).set(i);
      localVideoListFeed.commet_like_feed.set(super.writeCommentLikeFeedlocalPB());
      localObject2 = localVideoListFeed.qim_sync_wording;
      if (this.mQimSyncWording != null) {
        break label210;
      }
    }
    label190:
    label195:
    label200:
    label205:
    label210:
    for (Object localObject1 = "";; localObject1 = this.mQimSyncWording)
    {
      ((PBBytesField)localObject2).set(ByteStringMicro.copyFromUtf8((String)localObject1));
      return localVideoListFeed;
      localObject1 = this.mVideoNextCookie;
      break;
      i = 0;
      break label76;
      i = 0;
      break label96;
      i = 0;
      break label116;
      i = 0;
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem
 * JD-Core Version:    0.7.0.1
 */