package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArkAppFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.CommentInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;

public class BaseArticleInfo
  extends Entity
  implements IVideoCardUIModel
{
  @notColumn
  private static final String TAG = "Q.readinjoy.BaseArticleInfo";
  public int articleStyle;
  public int busiType = 1;
  public long businessId;
  public String businessName = "";
  public String businessNamePrefix = "";
  public String businessUrl = "";
  @notColumn
  public int feedsFirstExposurePos = -1;
  public String galleryReprotExdData;
  @notColumn
  public boolean hintFlag;
  public String innerUniqueID;
  public String interfaceData;
  @notColumn
  public boolean isNeedShowBtnWhenFollowed;
  @notColumn
  public boolean like;
  public int mAbandonRepeatFlag;
  public int mAccountLess;
  public long mAlgorithmID = -1L;
  @notColumn
  public ArkAppFeedsInfo mArkAppFeedsInfo;
  public byte[] mArkAppFeedsInfoBytes;
  public String mArticleContentUrl = "";
  public String mArticleFriendLikeText;
  public long mArticleID = -1L;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  @notColumn
  private URL mCacheVideoURL;
  public long mChannelID = -1L;
  public String mChannelInfoDisplayName;
  public int mChannelInfoId = -1;
  public String mChannelInfoName;
  public int mChannelInfoType = -1;
  public long mCircleId;
  public long mCommentCount = -1L;
  public int mCommentIconType;
  public byte[] mCommentInfoBytes;
  @notColumn
  public List mCommentsObj;
  public String mDiskLikeInfoString;
  @notColumn
  public ArrayList mDislikeInfos;
  public String mFeedCookie;
  public long mFeedId;
  @notColumn
  public long mFeedIndexInGroup;
  public int mFeedType;
  public String mFirstPagePicUrl = "";
  public int mGalleryPicNumber;
  @notColumn
  public long mGroupCount;
  @notColumn
  public long mGroupId = -1L;
  @notColumn
  public List mGroupSubArticleList;
  @notColumn
  public URL mHeaderIconUrl;
  public int mIsDispTimestamp;
  public int mIsGallery;
  @notColumn
  public boolean mIsInPolymeric;
  public String mJsonPictureList;
  public String mJsonVideoList;
  @notColumn
  public List mLabelListObj;
  public byte[] mLableListInfoBytes;
  public long mMergeVideoId;
  @notColumn
  private IVideoCardUIModel mModel;
  public String mOriginalUrl = "";
  public boolean mPUinIsActive;
  public byte[] mPackInfoBytes;
  @notColumn
  public oidb_cmd0x68b.PackInfo mPackInfoObj;
  @notColumn
  public URL[] mPictures;
  @notColumn
  public PolymericInfo mPolymericInfo;
  @notColumn
  public URL mPolymericSmallVideoCoverUrl;
  @notColumn
  public TemplateBean mProteusTemplateBean;
  public long mRecommendSeq = -1L;
  public long mRecommendTime = -1L;
  public String mRecommentdReason = "";
  public byte[] mServerContext;
  public boolean mShowBigPicture;
  @notColumn
  public URL mSinglePicture;
  @notColumn
  public SocializeFeedsInfo mSocialFeedInfo;
  public byte[] mSocialFeedInfoByte;
  public String mStrCircleId;
  public int mStrategyId;
  public byte[] mSubArticleListBytes;
  @notColumn
  public List mSubArtilceList;
  @notColumn
  public List mSubSummaryListObj;
  public String mSubscribeID = "";
  public byte[] mSubscribeInfoBytes;
  @notColumn
  public oidb_cmd0x68b.SubscribeInfo mSubscribeInfoObj;
  public String mSubscribeName = "";
  public String mSummary = "";
  @notColumn
  public String mThirdVideoURL;
  @notColumn
  public long mThirdVideoURLExpireTime;
  public long mTime = -1L;
  public String mTitle = "";
  public String mTopicPicInfo = "";
  public double mTopicPicWHRatio;
  @notColumn
  public TopicRecommendFeedsInfo mTopicRecommendFeedsInfo;
  public byte[] mTopicRecommendFeedsInfoByte;
  public int mVideoAdsJumpType;
  public String mVideoAdsJumpUrl;
  public int mVideoAdsSource;
  public String mVideoArticleSubsColor;
  public String mVideoArticleSubsText;
  public int mVideoCommentCount;
  @notColumn
  private BaseArticleInfo.OnVideoCoverInterceptor mVideoCoverInterceptor;
  @notColumn
  public URL mVideoCoverUrl;
  @notColumn
  public int mVideoDuration;
  @notColumn
  public int mVideoJsonHeight;
  @notColumn
  public int mVideoJsonWidth;
  public int mVideoPlayCount;
  public int mVideoType;
  @notColumn
  public String mVideoVid;
  @notColumn
  public long mXGFileSize;
  public String proteusItemsData;
  public long publishUin;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @notColumn
  public String thirdUin;
  @notColumn
  public String thirdUinName;
  public int videoJumpChannelID = -1;
  public String videoJumpChannelName = "";
  public int videoJumpChannelType = -1;
  
  private IVideoCardUIModel getLazyModel()
  {
    if (this.mModel == null) {
      this.mModel = VideoCardUIModelUtils.a(this);
    }
    return this.mModel;
  }
  
  public int getCommentCount()
  {
    return getLazyModel().getCommentCount();
  }
  
  public String getInnerUniqueID()
  {
    return getLazyModel().getInnerUniqueID();
  }
  
  public String getShareUrl()
  {
    return getLazyModel().getShareUrl();
  }
  
  public String getSubscribeName()
  {
    return getLazyModel().getSubscribeName();
  }
  
  public String getSubscribeUin()
  {
    return getLazyModel().getSubscribeUin();
  }
  
  public URL getVideoCoverURL()
  {
    if (this.mCacheVideoURL == null)
    {
      this.mCacheVideoURL = getLazyModel().getVideoCoverURL();
      if (this.mVideoCoverInterceptor != null) {
        this.mCacheVideoURL = this.mVideoCoverInterceptor.a(this.mCacheVideoURL);
      }
    }
    return this.mCacheVideoURL;
  }
  
  public int getVideoDuration()
  {
    return getLazyModel().getVideoDuration();
  }
  
  public int getVideoHeight()
  {
    return getLazyModel().getVideoHeight();
  }
  
  public String getVideoVid()
  {
    return getLazyModel().getVideoVid();
  }
  
  public int getVideoWidth()
  {
    return getLazyModel().getVideoWidth();
  }
  
  public boolean hasOnlyTwoVideoFeeds()
  {
    if ((!ReadInJoyUtils.a(this)) && (!ReadInJoyUtils.g(this))) {
      return false;
    }
    if ((this.mSubArtilceList != null) && (this.mSubArtilceList.size() == 1))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.mSubArtilceList.get(0);
      if ((localArticleInfo != null) && ((ReadInJoyUtils.a(localArticleInfo)) || (ReadInJoyUtils.g(localArticleInfo)))) {
        return true;
      }
    }
    return false;
  }
  
  public void invalidateProteusTemplateBean()
  {
    this.mProteusTemplateBean = null;
  }
  
  public boolean isSocialFeed()
  {
    return (this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.a != null);
  }
  
  public boolean isSubscriptFeed()
  {
    return (this.mSubscribeInfoObj != null) && (this.mSubscribeInfoObj.uint32_is_subscribed.has()) && (this.mSubscribeInfoObj.uint32_is_subscribed.get() == 1);
  }
  
  public boolean isTwoItemVideoFeed()
  {
    if (this.mChannelID == 40677L) {
      return false;
    }
    return hasOnlyTwoVideoFeeds();
  }
  
  public boolean isVideoItemForAdJump()
  {
    return (this.mVideoAdsJumpType == 1) && (!TextUtils.isEmpty(this.mVideoAdsJumpUrl));
  }
  
  public boolean isWeishiGridTwoItemFeed()
  {
    if (this.mChannelID == 40677L) {
      return hasOnlyTwoVideoFeeds();
    }
    return false;
  }
  
  public void postRead()
  {
    Object localObject;
    if ((this.mCommentInfoBytes != null) && (this.mCommentInfoBytes.length > 0))
    {
      CodedInputStreamMicro localCodedInputStreamMicro1 = CodedInputStreamMicro.newInstance(this.mCommentInfoBytes);
      localObject = PBField.initRepeatMessage(oidb_cmd0x68b.CommentInfo.class);
      try
      {
        while (!localCodedInputStreamMicro1.isAtEnd())
        {
          localCodedInputStreamMicro1.readTag();
          ((PBRepeatMessageField)localObject).readFrom(localCodedInputStreamMicro1);
        }
        if (this.mPackInfoBytes == null) {
          break label139;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.mCommentsObj = ((PBRepeatMessageField)localObject).get();
      }
    }
    if (this.mPackInfoBytes.length > 0) {
      this.mPackInfoObj = new oidb_cmd0x68b.PackInfo();
    }
    label773:
    label774:
    for (;;)
    {
      try
      {
        this.mPackInfoObj.mergeFrom(this.mPackInfoBytes);
        this.mGroupId = this.mPackInfoObj.uint64_pack_id.get();
        if (this.mPackInfoObj != null) {
          this.mPolymericInfo = PolymericInfo.a(this.mPackInfoObj);
        }
        label139:
        if ((this.mSubscribeInfoBytes != null) && (this.mSubscribeInfoBytes.length > 0)) {
          this.mSubscribeInfoObj = new oidb_cmd0x68b.SubscribeInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
      {
        try
        {
          this.mSubscribeInfoObj.mergeFrom(this.mSubscribeInfoBytes);
          if ((this.mSocialFeedInfoByte != null) && (this.mSocialFeedInfoByte.length > 0)) {
            localObject = new oidb_cmd0x68b.SocializeFeedsInfo();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
        {
          try
          {
            ((oidb_cmd0x68b.SocializeFeedsInfo)localObject).mergeFrom(this.mSocialFeedInfoByte);
            this.mSocialFeedInfo = SocializeFeedsInfo.a((oidb_cmd0x68b.SocializeFeedsInfo)localObject);
            if ((this.mLableListInfoBytes != null) && (this.mLableListInfoBytes.length > 0))
            {
              CodedInputStreamMicro localCodedInputStreamMicro2 = CodedInputStreamMicro.newInstance(this.mLableListInfoBytes);
              localObject = PBField.initRepeatMessage(oidb_cmd0x68b.ChannelInfo.class);
              try
              {
                if (!localCodedInputStreamMicro2.isAtEnd())
                {
                  localCodedInputStreamMicro2.readTag();
                  ((PBRepeatMessageField)localObject).readFrom(localCodedInputStreamMicro2);
                  continue;
                }
                if (this.mTopicRecommendFeedsInfoByte == null) {
                  continue;
                }
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                this.mLabelListObj = ((PBRepeatMessageField)localObject).get();
              }
            }
            if (this.mTopicRecommendFeedsInfoByte.length > 0) {
              localObject = new oidb_cmd0x68b.TopicRecommendFeedsInfo();
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
          {
            try
            {
              ((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject).mergeFrom(this.mTopicRecommendFeedsInfoByte);
              this.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject);
              if ((this.mArkAppFeedsInfoBytes != null) && (this.mArkAppFeedsInfoBytes.length > 0)) {
                localObject = new oidb_cmd0x68b.ArkAppFeedsInfo();
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
            {
              try
              {
                ((oidb_cmd0x68b.ArkAppFeedsInfo)localObject).mergeFrom(this.mArkAppFeedsInfoBytes);
                this.mArkAppFeedsInfo = ArkAppFeedsInfo.a((oidb_cmd0x68b.ArkAppFeedsInfo)localObject);
                if ((this.mSubArticleListBytes != null) && (this.mSubArticleListBytes.length > 0))
                {
                  CodedInputStreamMicro localCodedInputStreamMicro3 = CodedInputStreamMicro.newInstance(this.mSubArticleListBytes);
                  localObject = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleSummary.class);
                  try
                  {
                    if (!localCodedInputStreamMicro3.isAtEnd())
                    {
                      localCodedInputStreamMicro3.readTag();
                      ((PBRepeatMessageField)localObject).readFrom(localCodedInputStreamMicro3);
                      continue;
                    }
                    if (this.mSubSummaryListObj.size() <= 0) {
                      break label773;
                    }
                  }
                  catch (Exception localException3)
                  {
                    localException3.printStackTrace();
                    this.mSubSummaryListObj = ((PBRepeatMessageField)localObject).get();
                    if (this.mSubSummaryListObj == null) {
                      break label773;
                    }
                  }
                  localObject = new ArrayList(this.mSubSummaryListObj.size());
                  Iterator localIterator = this.mSubSummaryListObj.iterator();
                  int i = 0;
                  if (localIterator.hasNext())
                  {
                    ArticleInfo localArticleInfo = ReadInJoyMSFHandlerUtils.a((oidb_cmd0x68b.ArticleSummary)localIterator.next(), (int)this.mChannelID, null);
                    ((ArrayList)localObject).add(localArticleInfo);
                    if ((!QLog.isColorLevel()) || (localArticleInfo == null)) {
                      break label774;
                    }
                    StringBuilder localStringBuilder = new StringBuilder().append("postRead(): 解析 sub articleSummary【");
                    int j = i + 1;
                    QLog.e("Q.readinjoy.BaseArticleInfo", 2, i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + ReadInJoyUtils.d(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
                    i = j;
                    continue;
                    localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
                    localInvalidProtocolBufferMicroException1.printStackTrace();
                    this.mPackInfoObj = null;
                    continue;
                    localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
                    localInvalidProtocolBufferMicroException2.printStackTrace();
                    this.mSubscribeInfoObj = null;
                    continue;
                    localInvalidProtocolBufferMicroException3 = localInvalidProtocolBufferMicroException3;
                    localInvalidProtocolBufferMicroException3.printStackTrace();
                    this.mSocialFeedInfo = null;
                    continue;
                    localInvalidProtocolBufferMicroException4 = localInvalidProtocolBufferMicroException4;
                    localInvalidProtocolBufferMicroException4.printStackTrace();
                    this.mTopicRecommendFeedsInfo = null;
                  }
                }
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
              {
                localInvalidProtocolBufferMicroException5.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.readinjoy.", 2, "arkAppFeedsInfo convertPBToInfo failed.");
                }
                this.mArkAppFeedsInfo = null;
                continue;
                this.mSubArtilceList = localInvalidProtocolBufferMicroException5;
              }
            }
          }
        }
      }
      return;
    }
  }
  
  protected void prewrite()
  {
    Object localObject;
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((this.mCommentsObj != null) && (this.mCommentsObj.size() > 0))
    {
      localObject = PBField.initRepeatMessage(oidb_cmd0x68b.CommentInfo.class);
      ((PBRepeatMessageField)localObject).addAll(this.mCommentsObj);
      localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
    }
    try
    {
      localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
      ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      this.mCommentInfoBytes = localByteArrayOutputStream.toByteArray();
      if (this.mPackInfoObj != null) {
        this.mPackInfoBytes = this.mPackInfoObj.toByteArray();
      }
      if (this.mSubscribeInfoObj != null) {
        this.mSubscribeInfoBytes = this.mSubscribeInfoObj.toByteArray();
      }
      if (this.mSocialFeedInfo != null)
      {
        this.mSocialFeedInfoByte = this.mSocialFeedInfo.a();
        if (this.mSocialFeedInfo.a != null) {
          this.publishUin = this.mSocialFeedInfo.a.a;
        }
      }
      if (this.mTopicRecommendFeedsInfo != null) {
        this.mTopicRecommendFeedsInfoByte = this.mTopicRecommendFeedsInfo.a().toByteArray();
      }
      if (this.mArkAppFeedsInfo != null)
      {
        localObject = this.mArkAppFeedsInfo.a();
        if (localObject != null) {
          this.mArkAppFeedsInfoBytes = ((oidb_cmd0x68b.ArkAppFeedsInfo)localObject).toByteArray();
        }
      }
      if ((this.mLabelListObj != null) && (this.mLabelListObj.size() > 0))
      {
        localObject = PBField.initRepeatMessage(oidb_cmd0x68b.ChannelInfo.class);
        ((PBRepeatMessageField)localObject).addAll(this.mLabelListObj);
        localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
      }
    }
    catch (IOException localIOException1)
    {
      try
      {
        CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
        ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
        localCodedOutputStreamMicro.flush();
        this.mLableListInfoBytes = localByteArrayOutputStream.toByteArray();
        if ((this.mSubSummaryListObj != null) && (this.mSubSummaryListObj.size() > 0))
        {
          localObject = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleSummary.class);
          ((PBRepeatMessageField)localObject).addAll(this.mSubSummaryListObj);
          localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
        }
        try
        {
          localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
          ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
          localCodedOutputStreamMicro.flush();
          this.mSubArticleListBytes = localByteArrayOutputStream.toByteArray();
          return;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
        }
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
  }
  
  public void setOnVideoCoverInterceptor(BaseArticleInfo.OnVideoCoverInterceptor paramOnVideoCoverInterceptor)
  {
    this.mVideoCoverInterceptor = paramOnVideoCoverInterceptor;
  }
  
  public String toSString()
  {
    return "BaseArticleInfo{mArticleID=" + this.mArticleID + ", mTitle='" + this.mTitle + '\'' + ", mSummary='" + this.mSummary + '\'' + ", mFirstPagePicUrl='" + this.mFirstPagePicUrl + '\'' + ", mOriginalUrl='" + this.mOriginalUrl + '\'' + ", mArticleContentUrl='" + this.mArticleContentUrl + '\'' + ", mTime=" + this.mTime + ", mCommentCount=" + this.mCommentCount + ", mSubscribeID='" + this.mSubscribeID + '\'' + ", mSubscribeName='" + this.mSubscribeName + '\'' + ", mRecommendTime=" + this.mRecommendTime + ", mChannelID=" + this.mChannelID + ", mRecommendSeq=" + this.mRecommendSeq + ", mShowBigPicture=" + this.mShowBigPicture + ", mAlgorithmID=" + this.mAlgorithmID + ", mRecommentdReason='" + this.mRecommentdReason + '\'' + ", mJsonVideoList='" + this.mJsonVideoList + '\'' + ", mJsonPictureList='" + this.mJsonPictureList + '\'' + ", mAbandonRepeatFlag=" + this.mAbandonRepeatFlag + ", mArticleSubscriptText='" + this.mArticleSubscriptText + '\'' + ", mArticleSubscriptColor='" + this.mArticleSubscriptColor + '\'' + ", mArticleFriendLikeText='" + this.mArticleFriendLikeText + '\'' + ", mStrategyId=" + this.mStrategyId + ", mTopicPicWHRatio=" + this.mTopicPicWHRatio + ", mTopicPicInfo='" + this.mTopicPicInfo + '\'' + ", thirdIcon='" + this.thirdIcon + '\'' + ", thirdName='" + this.thirdName + '\'' + ", thirdAction='" + this.thirdAction + '\'' + ", busiType=" + this.busiType + ", innerUniqueID='" + this.innerUniqueID + '\'' + ", mVideoType=" + this.mVideoType + ", mChannelInfoId=" + this.mChannelInfoId + ", mChannelInfoName='" + this.mChannelInfoName + '\'' + ", mChannelInfoType=" + this.mChannelInfoType + ", mChannelInfoDisplayName='" + this.mChannelInfoDisplayName + '\'' + ", mCommentIconType=" + this.mCommentIconType + ", mServerContext=" + Arrays.toString(this.mServerContext) + ", mDiskLikeInfoString='" + this.mDiskLikeInfoString + '\'' + ", mSocialFeedInfoByte=" + Arrays.toString(this.mSocialFeedInfoByte) + ", mTopicRecommendFeedsInfoByte=" + Arrays.toString(this.mTopicRecommendFeedsInfoByte) + ", mFeedId=" + this.mFeedId + ", mFeedType=" + this.mFeedType + ", mCircleId=" + this.mCircleId + ", mStrCircleId='" + this.mStrCircleId + '\'' + ", mPUinIsActive=" + this.mPUinIsActive + ", mIsDispTimestamp=" + this.mIsDispTimestamp + ", mIsGallery=" + this.mIsGallery + ", mGalleryPicNumber=" + this.mGalleryPicNumber + ", mCommentInfoBytes=" + Arrays.toString(this.mCommentInfoBytes) + ", mPackInfoBytes=" + Arrays.toString(this.mPackInfoBytes) + ", mSubscribeInfoBytes=" + Arrays.toString(this.mSubscribeInfoBytes) + ", mVideoPlayCount=" + this.mVideoPlayCount + ", mLableListInfoBytes=" + Arrays.toString(this.mLableListInfoBytes) + ", videoJumpChannelID=" + this.videoJumpChannelID + ", videoJumpChannelType=" + this.videoJumpChannelType + ", videoJumpChannelName='" + this.videoJumpChannelName + '\'' + ", businessId=" + this.businessId + ", businessName='" + this.businessName + '\'' + ", businessUrl='" + this.businessUrl + '\'' + ", businessNamePrefix='" + this.businessNamePrefix + '\'' + ", mAccountLess=" + this.mAccountLess + ", publishUin=" + this.publishUin + ", interfaceData='" + this.interfaceData + '\'' + ", galleryReprotExdData='" + this.galleryReprotExdData + '\'' + ", articleStyle=" + this.articleStyle + ", proteusItemsData='" + this.proteusItemsData + '\'' + ", mArkAppFeedsInfo=" + this.mArkAppFeedsInfo + ", mArkAppFeedsInfoBytes=" + Arrays.toString(this.mArkAppFeedsInfoBytes) + ", mDislikeInfos=" + this.mDislikeInfos + ", like=" + this.like + ", mPictures=" + Arrays.toString(this.mPictures) + ", mSinglePicture=" + this.mSinglePicture + ", mVideoCoverUrl=" + this.mVideoCoverUrl + ", mVideoVid='" + this.mVideoVid + '\'' + ", mVideoDuration=" + this.mVideoDuration + ", mVideoJsonWidth=" + this.mVideoJsonWidth + ", mVideoJsonHeight=" + this.mVideoJsonHeight + ", mXGFileSize=" + this.mXGFileSize + ", mThirdVideoURL='" + this.mThirdVideoURL + '\'' + ", mThirdVideoURLExpireTime=" + this.mThirdVideoURLExpireTime + ", thirdUin='" + this.thirdUin + '\'' + ", thirdUinName='" + this.thirdUinName + '\'' + ", mCommentsObj=" + this.mCommentsObj + ", mPackInfoObj=" + this.mPackInfoObj + ", mPolymericInfo=" + this.mPolymericInfo + ", mIsInPolymeric=" + this.mIsInPolymeric + ", mSubscribeInfoObj=" + this.mSubscribeInfoObj + ", mGroupId=" + this.mGroupId + ", mGroupCount=" + this.mGroupCount + ", mFeedIndexInGroup=" + this.mFeedIndexInGroup + ", mHeaderIconUrl=" + this.mHeaderIconUrl + ", mSocialFeedInfo=" + this.mSocialFeedInfo + ", mLabelListObj=" + this.mLabelListObj + ", mTopicRecommendFeedsInfo=" + this.mTopicRecommendFeedsInfo + ", isNeedShowBtnWhenFollowed=" + this.isNeedShowBtnWhenFollowed + ", feedsFirstExposurePos=" + this.feedsFirstExposurePos + ", mSubArticleListBytes=" + Arrays.toString(this.mSubArticleListBytes) + ", mSubSummaryListObj=" + this.mSubSummaryListObj + ", mSubArtilceList=" + this.mSubArtilceList + ", mMergeVideoId=" + this.mMergeVideoId + ", mGroupSubArticleList=" + this.mGroupSubArticleList + ", mVideoCommentCount=" + this.mVideoCommentCount + ", mProteusTemplateBean=" + this.mProteusTemplateBean + ", mVideoArticleSubsText='" + this.mVideoArticleSubsText + '\'' + ", mVideoArticleSubsColor='" + this.mVideoArticleSubsColor + '\'' + ", mVideoAdsJumpUrl='" + this.mVideoAdsJumpUrl + '\'' + ", mVideoAdsJumpType=" + this.mVideoAdsJumpType + ", mVideoAdsSource=" + this.mVideoAdsSource + '}';
  }
  
  public String toString()
  {
    return "BaseArticleInfo{mArticleID=" + this.mArticleID + "\n, mRecommendSeq=" + this.mRecommendSeq + "\n, mTitle='" + this.mTitle + "\n, mPUinIsActive=" + this.mPUinIsActive + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */