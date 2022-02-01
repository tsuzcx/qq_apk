package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public abstract class VideoListFeedItem<T extends StoryHomeFeed, E extends IFeedOwner>
  extends CommentLikeFeedItem<T, E>
{
  public static final String TAG = "VideoListFeedItem";
  public boolean isReportedAutoPlay = false;
  public boolean mHasPublicVideo = false;
  public boolean mHasTag = false;
  public boolean mIsContribute = false;
  public boolean mIsVideoEnd;
  public String mQimSyncWording = null;
  public String mVideoNextCookie = "";
  public int mVideoPullType = 0;
  public int mVideoSeq = -1;
  
  @NonNull
  public static String makeFakeFeedId(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake-");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (VideoListFeedItem)paramObject;
    int i = paramObject.mVideoSeq;
    if (i != -1) {
      this.mVideoSeq = i;
    }
    if (!TextUtils.isEmpty(paramObject.mVideoNextCookie)) {
      this.mVideoNextCookie = paramObject.mVideoNextCookie;
    }
    this.mIsVideoEnd = paramObject.mIsVideoEnd;
    i = paramObject.mVideoPullType;
    if (i != -1) {
      this.mVideoPullType = i;
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
    super.readCommentLikeFeedLocalPB(paramVideoListFeed.commet_like_feed);
    this.mVideoSeq = paramVideoListFeed.video_seq.get();
    this.mVideoNextCookie = paramVideoListFeed.video_next_cookie.get();
    this.mVideoPullType = paramVideoListFeed.video_pull_type.get();
    int i = paramVideoListFeed.is_video_end.get();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsVideoEnd = bool1;
    if (paramVideoListFeed.is_contribute.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsContribute = bool1;
    if (paramVideoListFeed.has_tag.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mHasTag = bool1;
    boolean bool1 = bool2;
    if (paramVideoListFeed.has_public_video.get() == 1) {
      bool1 = true;
    }
    this.mHasPublicVideo = bool1;
    if (paramVideoListFeed.qim_sync_wording.has()) {
      this.mQimSyncWording = paramVideoListFeed.qim_sync_wording.get().toStringUtf8();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoListFeedItem{feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.date);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dateTimeMillis='");
    localStringBuilder.append(this.dateTimeMillis);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoListFeedItem{mIsContribute=");
    localStringBuilder.append(this.mIsContribute);
    localStringBuilder.append("mHasTag=");
    localStringBuilder.append(this.mHasTag);
    localStringBuilder.append("mHasPublicVideo=");
    localStringBuilder.append(this.mHasPublicVideo);
    localStringBuilder.append(", mVideoSeq=");
    localStringBuilder.append(this.mVideoSeq);
    localStringBuilder.append(", mVideoNextCookie='");
    localStringBuilder.append(this.mVideoNextCookie);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsVideoEnd=");
    localStringBuilder.append(this.mIsVideoEnd);
    localStringBuilder.append(", mVideoPullType=");
    localStringBuilder.append(this.mVideoPullType);
    localStringBuilder.append(", mQimSyncWording=");
    localStringBuilder.append(this.mQimSyncWording);
    localStringBuilder.append('}');
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem
 * JD-Core Version:    0.7.0.1
 */