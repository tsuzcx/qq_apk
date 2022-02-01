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
  public AddressItem a;
  public VideoLinkInfo a;
  private VideoSpreadGroupList jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList;
  private GeneralFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
  private PublishVideoEntry jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
  public String a;
  public long b;
  public String b;
  public List<AddGroupVideoResponse.AddGroupFeed> b;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  private String p;
  
  public StoryVideoTaskInfo(StoryVideoItem paramStoryVideoItem)
  {
    this.p = paramStoryVideoItem.mVid;
    this.h = paramStoryVideoItem.getVideoUrl();
    this.j = paramStoryVideoItem.getThumbUrl();
    this.i = paramStoryVideoItem.mOriginalMaskPicUrl;
    this.m = paramStoryVideoItem.mAtImagePath;
    this.jdField_a_of_type_JavaLangString = paramStoryVideoItem.mLocalVideoPath;
    this.jdField_b_of_type_JavaLangString = a().thumbPath;
    this.jdField_d_of_type_JavaLangString = a().doodlePath;
    this.jdField_b_of_type_Long = paramStoryVideoItem.mVideoDuration;
    this.jdField_d_of_type_Int = paramStoryVideoItem.mVideoWidth;
    this.jdField_e_of_type_Int = paramStoryVideoItem.mVideoHeight;
    this.jdField_d_of_type_Long = paramStoryVideoItem.mCreateTime;
    this.jdField_b_of_type_Int = paramStoryVideoItem.mRetryUploadTimes;
    this.jdField_g_of_type_JavaLangString = paramStoryVideoItem.mLastUploadVid;
    this.jdField_c_of_type_Int = paramStoryVideoItem.mUpLoadFailedError;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramStoryVideoItem.mLocation;
    this.k = paramStoryVideoItem.mPollThumbnailUrl;
    this.jdField_e_of_type_JavaLangString = paramStoryVideoItem.mPollThumbnailLocalPath;
    this.l = paramStoryVideoItem.mInteractThumbnailUrl;
    this.jdField_f_of_type_JavaLangString = paramStoryVideoItem.mInteractThumbnailLocalPath;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = VideoLinkInfo.a(paramStoryVideoItem.mLinkInfoJson);
    this.n = paramStoryVideoItem.originalAuthorUnionId;
    this.o = paramStoryVideoItem.originalAuthorName;
  }
  
  public StoryVideoTaskInfo(PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_d_of_type_Long = paramPublishVideoEntry.createTime;
    this.p = paramPublishVideoEntry.fakeVid;
    this.jdField_b_of_type_JavaLangString = paramPublishVideoEntry.thumbPath;
    this.jdField_d_of_type_JavaLangString = paramPublishVideoEntry.doodlePath;
    this.jdField_b_of_type_Long = paramPublishVideoEntry.videoDuration;
    this.jdField_d_of_type_Int = paramPublishVideoEntry.videoWidth;
    this.jdField_e_of_type_Int = paramPublishVideoEntry.videoHeight;
    if (!TextUtils.isEmpty(paramPublishVideoEntry.videoAddress)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = AddressItem.convertFromJson(paramPublishVideoEntry.videoAddress);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.m = paramPublishVideoEntry.atDoodlePath;
    this.jdField_e_of_type_JavaLangString = a().getStringExtra("pl_pic", null);
    this.jdField_f_of_type_JavaLangString = a().getStringExtra("il_pic", null);
    this.jdField_f_of_type_Int = paramPublishVideoEntry.getIntExtra("extra_capture_mode", -1);
    this.jdField_g_of_type_Int = paramPublishVideoEntry.publishFrom;
  }
  
  public StoryVideoTaskInfo(String paramString)
  {
    this.p = paramString;
    AssertUtils.checkNotNull(paramString);
  }
  
  private int a()
  {
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.a();
    Object localObject = a().readerConfBytes;
    if ((localObject != null) && (localObject.length > 0))
    {
      qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
      try
      {
        localVideoReaderConf.mergeFrom((byte[])localObject);
        int i1 = new QQStoryBanInfo(localAppInterface, localVideoReaderConf).jdField_a_of_type_Int;
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
  
  private TagItem.TagInfoBase a()
  {
    Object localObject = a().tagInfoBytes;
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
  
  public static PublishVideoEntry a(String paramString)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
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
      ((PublishVideoEntry)localObject).multiFragmentGroupId = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf(((PublishVideoEntry)localObject).fragmentGroupId) });
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public StoryVideoItem a()
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.mVid = this.p;
    localStoryVideoItem.mLastUploadVid = this.jdField_g_of_type_JavaLangString;
    localStoryVideoItem.mCreateTime = this.jdField_d_of_type_Long;
    localStoryVideoItem.mVideoIndex = this.jdField_e_of_type_Long;
    localStoryVideoItem.mSourceType = 0;
    localStoryVideoItem.mPublishDate = a().mLocalDate;
    if (TextUtils.isEmpty(localStoryVideoItem.mPublishDate)) {
      localStoryVideoItem.mPublishDate = FeedManager.a().format(new Date(this.jdField_d_of_type_Long));
    }
    localStoryVideoItem.mVideoUrl = this.h;
    localStoryVideoItem.mVideoThumbnailUrl = this.j;
    localStoryVideoItem.mAtJsonData = a().atJsonData;
    localStoryVideoItem.mAtImagePath = this.m;
    localStoryVideoItem.mLocalCreateTime = (a().videoCreateTime * 1000L);
    localStoryVideoItem.mLocalCreateLocation = a().localCreateCity;
    localStoryVideoItem.mLocation = this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem;
    localStoryVideoItem.mUserSelectLocationText = a().videoLocationDescription;
    if (TextUtils.isEmpty(localStoryVideoItem.mUserSelectLocationText)) {
      localStoryVideoItem.mUserSelectLocationText = a().gpsFilterDescription;
    }
    localStoryVideoItem.mTimeZoneOffsetMillis = (a().timeZoneOffset / 1000L);
    if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
      localStoryVideoItem.mTimeZoneOffsetMillis *= 1000L;
    }
    localStoryVideoItem.mVideoLocalThumbnailPath = this.jdField_b_of_type_JavaLangString;
    localStoryVideoItem.mVideoLocalThumbnailOrigFakePath = this.jdField_c_of_type_JavaLangString;
    localStoryVideoItem.mLocalVideoPath = this.jdField_a_of_type_JavaLangString;
    localStoryVideoItem.mVideoDuration = this.jdField_b_of_type_Long;
    localStoryVideoItem.mVideoWidth = this.jdField_d_of_type_Int;
    localStoryVideoItem.mVideoHeight = this.jdField_e_of_type_Int;
    localStoryVideoItem.mDoodleText = a().videoDoodleDescription;
    localStoryVideoItem.mUploadStatus = this.jdField_a_of_type_Int;
    localStoryVideoItem.mRetryUploadTimes = this.jdField_b_of_type_Int;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
      localStoryVideoItem.mUpLoadFailedError = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    localStoryVideoItem.mOwnerUid = QQStoryContext.a().b();
    if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
    {
      localObject = ((UserManager)SuperManager.a(2)).a();
      if (localObject != null) {
        localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject).getDisplayName();
      }
    }
    localStoryVideoItem.mBanType = a();
    localStoryVideoItem.mVideoSpreadGroupList = a();
    localStoryVideoItem.mTagInfoBase = a();
    localStoryVideoItem.mPollLayoutJson = a().getStringExtra("pl", null);
    localStoryVideoItem.mPollThumbnailLocalPath = this.jdField_e_of_type_JavaLangString;
    localStoryVideoItem.mPollThumbnailUrl = this.k;
    localStoryVideoItem.mInteractLayoutJson = a().getStringExtra("i_l", null);
    localStoryVideoItem.mInteractThumbnailLocalPath = this.jdField_f_of_type_JavaLangString;
    localStoryVideoItem.mInteractThumbnailUrl = this.l;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    if (localObject != null) {
      localStoryVideoItem.mLinkInfoJson = ((VideoLinkInfo)localObject).a(false);
    }
    localStoryVideoItem.originalAuthorUnionId = this.n;
    localStoryVideoItem.originalAuthorName = this.o;
    a().getBooleanExtra("is_hw_encode", false);
    boolean bool = a().isLocalPublish;
    return localStoryVideoItem;
  }
  
  public VideoSpreadGroupList a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList == null) && (a().spreadGroupBytes != null) && (a().spreadGroupBytes.length > 0))
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      try
      {
        localVideoSpreadGroupList.mergeFrom(a().spreadGroupBytes);
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList = new VideoSpreadGroupList(localVideoSpreadGroupList);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "decode spread group fail", localInvalidProtocolBufferMicroException);
      }
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoSpreadGroupList;
  }
  
  public GeneralFeedItem a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
    if (localObject != null) {
      return localObject;
    }
    String str2 = a().mLocalDate;
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    String str1 = localFeedManager.a(QQStoryContext.a().b(), str2);
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "find true feedId:%s", str1);
    localObject = str1;
    if (TextUtils.isEmpty(str1))
    {
      localObject = VideoListFeedItem.makeFakeFeedId(QQStoryContext.a().b(), str2);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "make fake feedId:%s", localObject);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = ((GeneralFeedItem)localFeedManager.a((String)localObject));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = GeneralFeedItem.createFakeFeedItem(str2);
      localFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "save fake item %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
  }
  
  @NonNull
  public PublishVideoEntry a()
  {
    PublishVideoEntry localPublishVideoEntry = this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
    if (localPublishVideoEntry != null) {
      return localPublishVideoEntry;
    }
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = a(this.p);
    return this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
  }
  
  public String a()
  {
    return this.p;
  }
  
  public void a(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.copy(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
    localGeneralFeedItem.feedId = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localGeneralFeedItem;
    ((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
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
      String str = this.p;
      if (str != null) {
        return str.equals(paramObject.p);
      }
      return paramObject.p == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.p;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoTaskInfo{createTime=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", fakeVid='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", '");
    localStringBuilder.append(super.toString());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo
 * JD-Core Version:    0.7.0.1
 */