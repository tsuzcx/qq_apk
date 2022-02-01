package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryBanInfo;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONException;

@TargetApi(14)
public class StoryVideoTaskInfo
  extends BaseTaskInfo
{
  public long A;
  public VideoLinkInfo B;
  public String C;
  public String D;
  public int E;
  public int F;
  private String G;
  private PublishVideoEntry H;
  private VideoSpreadGroupList I;
  private GeneralFeedItem J;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public long m;
  public long n;
  public int o;
  public int p;
  public long q;
  public AddressItem r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public List<AddGroupVideoResponse.AddGroupFeed> z;
  
  public StoryVideoTaskInfo(StoryVideoItem paramStoryVideoItem)
  {
    this.G = paramStoryVideoItem.mVid;
    this.t = paramStoryVideoItem.getVideoUrl();
    this.v = paramStoryVideoItem.getThumbUrl();
    this.u = paramStoryVideoItem.mOriginalMaskPicUrl;
    this.y = paramStoryVideoItem.mAtImagePath;
    this.g = paramStoryVideoItem.mLocalVideoPath;
    this.h = e().thumbPath;
    this.j = e().doodlePath;
    this.m = paramStoryVideoItem.mVideoDuration;
    this.o = paramStoryVideoItem.mVideoWidth;
    this.p = paramStoryVideoItem.mVideoHeight;
    this.q = paramStoryVideoItem.mCreateTime;
    this.c = paramStoryVideoItem.mRetryUploadTimes;
    this.s = paramStoryVideoItem.mLastUploadVid;
    this.d = paramStoryVideoItem.mUpLoadFailedError;
    this.r = paramStoryVideoItem.mLocation;
    this.w = paramStoryVideoItem.mPollThumbnailUrl;
    this.k = paramStoryVideoItem.mPollThumbnailLocalPath;
    this.x = paramStoryVideoItem.mInteractThumbnailUrl;
    this.l = paramStoryVideoItem.mInteractThumbnailLocalPath;
    this.B = VideoLinkInfo.a(paramStoryVideoItem.mLinkInfoJson);
    this.C = paramStoryVideoItem.originalAuthorUnionId;
    this.D = paramStoryVideoItem.originalAuthorName;
  }
  
  public StoryVideoTaskInfo(PublishVideoEntry paramPublishVideoEntry)
  {
    this.H = paramPublishVideoEntry;
    this.q = paramPublishVideoEntry.createTime;
    this.G = paramPublishVideoEntry.fakeVid;
    this.h = paramPublishVideoEntry.thumbPath;
    this.j = paramPublishVideoEntry.doodlePath;
    this.m = paramPublishVideoEntry.videoDuration;
    this.o = paramPublishVideoEntry.videoWidth;
    this.p = paramPublishVideoEntry.videoHeight;
    if (!TextUtils.isEmpty(paramPublishVideoEntry.videoAddress)) {
      try
      {
        this.r = AddressItem.convertFromJson(paramPublishVideoEntry.videoAddress);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.y = paramPublishVideoEntry.atDoodlePath;
    this.k = e().getStringExtra("pl_pic", null);
    this.l = e().getStringExtra("il_pic", null);
    this.E = paramPublishVideoEntry.getIntExtra("extra_capture_mode", -1);
    this.F = paramPublishVideoEntry.publishFrom;
  }
  
  public StoryVideoTaskInfo(String paramString)
  {
    this.G = paramString;
    AssertUtils.checkNotNull(paramString);
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static PublishVideoEntry b(String paramString)
  {
    paramString = a(QQStoryContext.a().d().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    if ((paramString != null) && (paramString.size() > 0)) {
      paramString = (PublishVideoEntry)paramString.get(0);
    } else {
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new PublishVideoEntry();
    }
    if ((TextUtils.isEmpty(((PublishVideoEntry)localObject).multiFragmentGroupId)) && (((PublishVideoEntry)localObject).fragmentGroupId != 0)) {
      ((PublishVideoEntry)localObject).multiFragmentGroupId = String.format("%s.%d", new Object[] { QQStoryContext.a().g(), Integer.valueOf(((PublishVideoEntry)localObject).fragmentGroupId) });
    }
    return localObject;
  }
  
  private TagItem.TagInfoBase g()
  {
    Object localObject = e().tagInfoBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
      try
      {
        localTagInfoBase.mergeFrom((byte[])localObject);
        localObject = new TagItem.TagInfoBase(localTagInfoBase);
        return localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    return null;
  }
  
  private int h()
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.k();
    Object localObject = e().readerConfBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
      try
      {
        localVideoReaderConf.mergeFrom((byte[])localObject);
        int i1 = new QQStoryBanInfo(localAppInterface, localVideoReaderConf).a;
        return i1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createFakeStoryVideoItem VideoReaderConf: ");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(localInvalidProtocolBufferMicroException));
          QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return -1;
  }
  
  public void a(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.copy(this.J);
    localGeneralFeedItem.feedId = paramString;
    this.J = localGeneralFeedItem;
    ((FeedManager)SuperManager.a(11)).a(this.J);
  }
  
  public GeneralFeedItem b()
  {
    Object localObject = this.J;
    if (localObject != null) {
      return localObject;
    }
    String str2 = e().mLocalDate;
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    String str1 = localFeedManager.b(QQStoryContext.a().i(), str2);
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", str1);
    localObject = str1;
    if (TextUtils.isEmpty(str1))
    {
      localObject = VideoListFeedItem.makeFakeFeedId(QQStoryContext.a().i(), str2);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject);
    }
    this.J = ((GeneralFeedItem)localFeedManager.b((String)localObject));
    if (this.J == null)
    {
      this.J = GeneralFeedItem.createFakeFeedItem(str2);
      localFeedManager.a(this.J);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", this.J.feedId);
    }
    return this.J;
  }
  
  public StoryVideoItem c()
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.mVid = this.G;
    localStoryVideoItem.mLastUploadVid = this.s;
    localStoryVideoItem.mCreateTime = this.q;
    localStoryVideoItem.mVideoIndex = this.A;
    localStoryVideoItem.mSourceType = 0;
    localStoryVideoItem.mPublishDate = e().mLocalDate;
    if (TextUtils.isEmpty(localStoryVideoItem.mPublishDate)) {
      localStoryVideoItem.mPublishDate = FeedManager.h().format(new Date(this.q));
    }
    localStoryVideoItem.mVideoUrl = this.t;
    localStoryVideoItem.mVideoThumbnailUrl = this.v;
    localStoryVideoItem.mAtJsonData = e().atJsonData;
    localStoryVideoItem.mAtImagePath = this.y;
    localStoryVideoItem.mLocalCreateTime = (e().videoCreateTime * 1000L);
    localStoryVideoItem.mLocalCreateLocation = e().localCreateCity;
    localStoryVideoItem.mLocation = this.r;
    localStoryVideoItem.mUserSelectLocationText = e().videoLocationDescription;
    if (TextUtils.isEmpty(localStoryVideoItem.mUserSelectLocationText)) {
      localStoryVideoItem.mUserSelectLocationText = e().gpsFilterDescription;
    }
    localStoryVideoItem.mTimeZoneOffsetMillis = (e().timeZoneOffset / 1000L);
    if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
      localStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
    }
    localStoryVideoItem.mVideoLocalThumbnailPath = this.h;
    localStoryVideoItem.mVideoLocalThumbnailOrigFakePath = this.i;
    localStoryVideoItem.mLocalVideoPath = this.g;
    localStoryVideoItem.mVideoDuration = this.m;
    localStoryVideoItem.mVideoWidth = this.o;
    localStoryVideoItem.mVideoHeight = this.p;
    localStoryVideoItem.mDoodleText = e().videoDoodleDescription;
    localStoryVideoItem.mUploadStatus = this.a;
    localStoryVideoItem.mRetryUploadTimes = this.c;
    if (this.f != null) {
      localStoryVideoItem.mUpLoadFailedError = this.f.errorCode;
    }
    localStoryVideoItem.mOwnerUid = QQStoryContext.a().i();
    if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
    {
      localObject = ((UserManager)SuperManager.a(2)).c();
      if (localObject != null) {
        localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject).getDisplayName();
      }
    }
    localStoryVideoItem.mBanType = h();
    localStoryVideoItem.mVideoSpreadGroupList = f();
    localStoryVideoItem.mTagInfoBase = g();
    localStoryVideoItem.mPollLayoutJson = e().getStringExtra("pl", null);
    localStoryVideoItem.mPollThumbnailLocalPath = this.k;
    localStoryVideoItem.mPollThumbnailUrl = this.w;
    localStoryVideoItem.mInteractLayoutJson = e().getStringExtra("i_l", null);
    localStoryVideoItem.mInteractThumbnailLocalPath = this.l;
    localStoryVideoItem.mInteractThumbnailUrl = this.x;
    Object localObject = this.B;
    if (localObject != null) {
      localStoryVideoItem.mLinkInfoJson = ((VideoLinkInfo)localObject).a(false);
    }
    localStoryVideoItem.originalAuthorUnionId = this.C;
    localStoryVideoItem.originalAuthorName = this.D;
    e().getBooleanExtra("is_hw_encode", false);
    boolean bool = e().isLocalPublish;
    return localStoryVideoItem;
  }
  
  public String d()
  {
    return this.G;
  }
  
  @NonNull
  public PublishVideoEntry e()
  {
    PublishVideoEntry localPublishVideoEntry = this.H;
    if (localPublishVideoEntry != null) {
      return localPublishVideoEntry;
    }
    this.H = b(this.G);
    return this.H;
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
      paramObject = (StoryVideoTaskInfo)paramObject;
      String str = this.G;
      if (str != null) {
        return str.equals(paramObject.G);
      }
      return paramObject.G == null;
    }
    return false;
  }
  
  public VideoSpreadGroupList f()
  {
    if ((this.I == null) && (e().spreadGroupBytes != null) && (e().spreadGroupBytes.length > 0))
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      try
      {
        localVideoSpreadGroupList.mergeFrom(e().spreadGroupBytes);
        this.I = new VideoSpreadGroupList(localVideoSpreadGroupList);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "decode spread group fail", localInvalidProtocolBufferMicroException);
      }
    }
    return this.I;
  }
  
  public int hashCode()
  {
    String str = this.G;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoTaskInfo{createTime=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", fakeVid='");
    localStringBuilder.append(this.G);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", '");
    localStringBuilder.append(super.toString());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo
 * JD-Core Version:    0.7.0.1
 */