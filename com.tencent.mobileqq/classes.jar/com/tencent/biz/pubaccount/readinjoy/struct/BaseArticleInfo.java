package com.tencent.biz.pubaccount.readinjoy.struct;

import actj;
import akiz;
import android.graphics.Paint;
import android.text.TextUtils;
import auko;
import aulz;
import awsq;
import bbdh;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import ove;
import oxl;
import oxm;
import pb.unite.search.RequestSearchWord.Rcmd;
import poq;
import qad;
import qak;
import qan;
import qav;
import qax;
import qbc;
import qbe;
import qbf;
import qbm;
import qbn;
import qbs;
import qbx;
import qcb;
import qcg;
import qci;
import qcv;
import qda;
import qdq;
import qdt;
import qdv;
import rvk;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FusionBiuInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class BaseArticleInfo
  extends auko
  implements qbe
{
  @aulz
  public static final int ARTICLE_TYPE_NOMAL = 0;
  @aulz
  public static final int ARTICLE_TYPE_SHORT_CONTENT = 1;
  @aulz
  private static final String TAG = "Q.readinjoy.BaseArticleInfo";
  public String adReportCommonData;
  public int articleStyle;
  @aulz
  public rvk articleViewModel;
  public String avatar;
  public int busiType = 1;
  public long businessId;
  public String businessName = "";
  public String businessNamePrefix = "";
  public String businessUrl = "";
  public byte[] bytesBusiData;
  public int click_area;
  public String comment_id;
  public String comment_jump_url;
  public String content;
  @aulz
  public qax familyCommentInfo;
  public byte[] familyCommentInfoByte;
  @aulz
  public int feedsFirstExposurePos = -1;
  @aulz
  public FusionBiuInfo fusionBiuInfo;
  public byte[] fusionBiuInfoByte;
  public String galleryReprotExdData;
  public String gifCoverUrl;
  public boolean hasAwesome;
  @aulz
  public boolean hintFlag;
  @aulz
  public qbc hotWordInfo;
  public byte[] hotWordInfoListBytes;
  public int icon_height;
  public String icon_url;
  public int icon_with;
  public String innerUniqueID;
  public String interfaceData;
  public boolean isAccountShown;
  public int isCardJumpUrlAvailable;
  public int isCloseDislike;
  public boolean isExtraBiuExpanded;
  @aulz
  public boolean isNeeaRealExposureFilter;
  @aulz
  public boolean isNeedShowBtnWhenFollowed;
  @aulz
  public boolean isPublicAccountFollowed;
  @aulz
  public boolean isShowFreeNetFlow;
  @aulz
  public boolean isShowGif;
  @aulz
  public boolean isShowRecommendList;
  public int isSuperTop;
  public boolean isSuperTopic;
  @aulz
  public boolean isTwoItem;
  public boolean isUseGif;
  public String jump_url;
  @aulz
  public boolean like;
  public int mAbandonRepeatFlag;
  public int mAccountLess;
  public long mAlgorithmGroup = -1L;
  public long mAlgorithmID = -1L;
  @aulz
  public qak mArkAppFeedsInfo;
  public byte[] mArkAppFeedsInfoBytes;
  public String mArticleContentUrl = "";
  public String mArticleFriendLikeText;
  public long mArticleID = -1L;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  public int mArticleType;
  @aulz
  private URL mCacheVideoURL;
  public String mCardJumpUrl;
  public long mChannelID = -1L;
  public String mChannelInfoDisplayName;
  public int mChannelInfoId = -1;
  public String mChannelInfoName;
  public int mChannelInfoType = -1;
  public long mCircleId;
  public long mCommentCount = -1L;
  public int mCommentIconType;
  public byte[] mCommentInfoBytes;
  @aulz
  public List<articlesummary.CommentInfo> mCommentsObj;
  @aulz
  public int mCurrentX;
  public String mDianDianLabelIconUrl;
  public String mDianDianLabelText;
  public String mDiskLikeInfoString;
  @aulz
  public ArrayList<DislikeInfo> mDislikeInfos;
  public byte[] mExtraBiuBriefBytes;
  @aulz
  public qav mExtraBiuBriefInfo;
  public String mFeedCookie;
  public long mFeedId;
  @aulz
  public long mFeedIndexInGroup;
  public int mFeedType;
  public String mFirstPagePicUrl = "";
  public String mGWCommonData;
  @aulz
  public galleryFeeds.GalleryFeedsInfo mGalleryFeedsInfo;
  public int mGalleryPicNumber;
  @aulz
  public long mGroupCount;
  @aulz
  public long mGroupId = -1L;
  @aulz
  public List<BaseArticleInfo> mGroupSubArticleList;
  @aulz
  public URL mHeaderIconUrl;
  public int mIsDispTimestamp;
  public int mIsGallery;
  @aulz
  public boolean mIsGalleryChannel;
  @aulz
  public boolean mIsInPolymeric;
  public boolean mIsPolymericGallery;
  public int mIsShowSearchord;
  public String mJsonPictureList;
  public String mJsonVideoList;
  @aulz
  public int mJumpType;
  @aulz
  public qbf mKdLiveInfo;
  public byte[] mKdLiveInfoBytes;
  @aulz
  public List<articlesummary.ChannelInfo> mLabelListObj;
  public byte[] mLableListInfoBytes;
  public long mMergeVideoId;
  @aulz
  private qbe mModel;
  public byte[] mMultiBiuSameListBytes;
  @aulz
  public List<articlesummary.MultiBiuSameContent> mMultiBiuSameListObj;
  public byte[] mNewPackInfoBytes;
  @aulz
  public qbn mNewPolymericInfo;
  public String mOriginalUrl = "";
  public boolean mPUinIsActive;
  public byte[] mPackInfoBytes;
  @aulz
  public articlesummary.PackInfo mPackInfoObj;
  @aulz
  public articlesummary.PartnerAccountInfo mPartnerAccountInfo;
  public byte[] mPartnerAccountInfoBytes;
  @aulz
  public URL[] mPictures;
  @aulz
  public qbs mPolymericInfo;
  @aulz
  public URL mPolymericSmallVideoCoverUrl;
  @aulz
  public TemplateBean mProteusTemplateBean;
  public long mRecommendFollowId;
  public byte[] mRecommendFollowInfoBytes;
  @aulz
  public qbx mRecommendFollowInfos;
  public long mRecommendSeq = -1L;
  public long mRecommendTime = -1L;
  public String mRecommentdReason = "";
  @aulz
  public String mRefreshTime = "0";
  public String mReportCommonData;
  @aulz
  public int mResolvedFeedType;
  public String mSearchWordSessionId;
  public String mSearchWordTitle;
  public ArrayList<RequestSearchWord.Rcmd> mSearchWords = new ArrayList();
  public byte[] mServerContext;
  public boolean mShowBigPicture;
  @aulz
  public VideoColumnInfo mSimpleVideoColumnInfo;
  public byte[] mSimpleVideoColumnInfoBytes;
  @aulz
  public URL mSinglePicture;
  @aulz
  public SocializeFeedsInfo mSocialFeedInfo;
  public byte[] mSocialFeedInfoByte;
  public String mStrCircleId;
  public int mStrategyId;
  public byte[] mSubArticleListBytes;
  @aulz
  public List<ArticleInfo> mSubArtilceList;
  @aulz
  public List<articlesummary.ArticleSummary> mSubSummaryListObj;
  public String mSubscribeID = "";
  public byte[] mSubscribeInfoBytes;
  @aulz
  public articlesummary.SubscribeInfo mSubscribeInfoObj;
  public String mSubscribeName = "";
  public String mSummary = "";
  @aulz
  public String mThirdVideoURL;
  @aulz
  public long mThirdVideoURLExpireTime;
  public long mTime = -1L;
  public String mTitle = "";
  public String mTopicPicInfo = "";
  public double mTopicPicWHRatio;
  @aulz
  public qdq mTopicRecommendFeedsInfo;
  public byte[] mTopicRecommendFeedsInfoByte;
  public int mVideoAdsJumpType;
  public String mVideoAdsJumpUrl;
  public int mVideoAdsSource;
  public String mVideoArticleSubsColor;
  public String mVideoArticleSubsText;
  @aulz
  public VideoColumnInfo mVideoColumnInfo;
  public byte[] mVideoColumnInfoBytes;
  public int mVideoCommentCount;
  @aulz
  private qan mVideoCoverInterceptor;
  @aulz
  public URL mVideoCoverUrl;
  @aulz
  public articlesummary.VideoDownloadBarInfo mVideoDownloadBarInfo;
  public byte[] mVideoDownloadBarInfoBytes;
  @aulz
  public int mVideoDuration;
  @aulz
  public int mVideoJsonHeight;
  @aulz
  public int mVideoJsonWidth;
  public String mVideoLogoUrl;
  public int mVideoPlayCount;
  public int mVideoType;
  @aulz
  public String mVideoVid;
  public byte[] mWeishiUGInfo;
  @aulz
  public long mXGFileSize;
  public String msgBoxBriefContent;
  public String msgBoxBriefPreFix;
  public int msgBoxBriefPreFixType;
  @aulz
  public ArrayList<MultiBiuSameContent> multiBiuSameContentList;
  @aulz
  public qbm multiVideoColumnInfo;
  public byte[] multiVideoColumnInfoBytes;
  public String nick_name;
  public String proteusItemsData;
  public long publishUin;
  public String rawkey;
  @aulz
  public qcb scripCmsInfo;
  public byte[] scripCmsInfoByte;
  @aulz
  public List<articlesummary.SRTUniversalID> srtUniversalID;
  public byte[] srtUniversalIDBytesList;
  public oxl strategy;
  public oxm strategyCallback;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @aulz
  public String thirdUin;
  @aulz
  public String thirdUinName;
  public long uin;
  public String vIconUrl;
  public int videoJumpChannelID = -1;
  public String videoJumpChannelName = "";
  public int videoJumpChannelType = -1;
  public String videoReportInfo;
  public String viewRowkey;
  @aulz
  public ove waterFallPic;
  @aulz
  public articlesummary.WeishiUGInfo weishiUGInfo;
  
  private qbe getLazyModel()
  {
    if (this.mModel == null) {
      this.mModel = qdv.a(this);
    }
    return this.mModel;
  }
  
  private String getPartnerAccountInfoStr()
  {
    if (this.mPartnerAccountInfo != null) {
      return String.format("{uin: %d, head jump url: %s, reason: %s, icon_url: %s}", new Object[] { Long.valueOf(this.mPartnerAccountInfo.uint64_uin.get()), this.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8(), this.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), this.mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8() });
    }
    return null;
  }
  
  private void handlerFeedsTypeInOldVersionDatabase()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qde != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for wenda article articleinfo = " + toString());
      }
      if ((this.mFeedType != 1) || (this.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qcg.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qda == null)) {
        break label529;
      }
      if ((this.mSocialFeedInfo.jdField_a_of_type_Qda.b != 3) || (this.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue() == 21)) {
        break label463;
      }
      this.mSocialFeedInfo.jdField_a_of_type_Qcg.b = Long.valueOf(21L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu question card");
      }
    }
    label463:
    do
    {
      do
      {
        for (;;)
        {
          if ((this.mNewPolymericInfo != null) && (this.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (this.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for new pack card articleinfo = " + toString());
            }
            if ((this.mFeedType != 24) && (this.mFeedType != 29))
            {
              this.mFeedType = 24;
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for new pack card");
              }
            }
          }
          if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qcv.c == 1) && ((this.mSocialFeedInfo.jdField_a_of_type_Int == 9) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 3) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 8)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for gallery card articleinfo = " + toString());
            }
            if (this.mFeedType != 1) {
              break;
            }
            if (this.mSocialFeedInfo.jdField_a_of_type_Qcg == null) {
              this.mSocialFeedInfo.jdField_a_of_type_Qcg = new qcg();
            }
            if ((this.mSocialFeedInfo.jdField_a_of_type_Qcg.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue() != 23))
            {
              this.mSocialFeedInfo.jdField_a_of_type_Qcg.b = new Long(23L);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu gallery card");
              }
            }
          }
          return;
          if ((this.mSocialFeedInfo.jdField_a_of_type_Qda.b == 4) && (this.mSocialFeedInfo.jdField_a_of_type_Qcg.b.intValue() != 22))
          {
            this.mSocialFeedInfo.jdField_a_of_type_Qcg.b = Long.valueOf(22L);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu answer card");
              continue;
              if ((this.mFeedType != 1) && (this.mSocialFeedInfo.jdField_a_of_type_Qda != null)) {
                if ((this.mSocialFeedInfo.jdField_a_of_type_Qda.b == 3) && (this.mFeedType != 21))
                {
                  this.mFeedType = 21;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for question card");
                  }
                }
                else if ((this.mSocialFeedInfo.jdField_a_of_type_Qda.b == 4) && (this.mFeedType != 22))
                {
                  this.mFeedType = 22;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for answer card");
                  }
                }
              }
            }
          }
        }
      } while ((this.mFeedType != 6) && (this.mFeedType != 7) && (this.mFeedType != 8) && (this.mFeedType != 9) && (this.mFeedType != 12));
      this.mFeedType = 23;
    } while (!QLog.isColorLevel());
    label529:
    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for gallery card");
  }
  
  public String getCardJumpUrl()
  {
    return this.mCardJumpUrl;
  }
  
  public int getCommentCount()
  {
    return getLazyModel().getCommentCount();
  }
  
  public String getInnerUniqueID()
  {
    return getLazyModel().getInnerUniqueID();
  }
  
  public JSONObject getProteusItemData()
  {
    if (this.proteusItemsData != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.proteusItemsData);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.readinjoy.BaseArticleInfo", 2, localJSONException, new Object[0]);
      }
    }
    return null;
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
  
  public URL getVideoCoverUrlWithSmartCut(int paramInt1, int paramInt2)
  {
    if (this.mPolymericSmallVideoCoverUrl == null)
    {
      qbe localqbe = getLazyModel();
      if ((localqbe instanceof qdt)) {
        this.mPolymericSmallVideoCoverUrl = ((qdt)localqbe).getVideoCoverWithSmartCut(paramInt1, paramInt2);
      }
    }
    else
    {
      return this.mPolymericSmallVideoCoverUrl;
    }
    return getVideoCoverURL();
  }
  
  public URL getVideoCoverUrlWithSmartCut(int paramInt1, int paramInt2, String paramString)
  {
    if (this.mPolymericSmallVideoCoverUrl == null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.mPolymericSmallVideoCoverUrl = onh.a(onh.a(paramString, paramInt1, paramInt2));
      }
    }
    else {
      return this.mPolymericSmallVideoCoverUrl;
    }
    return null;
  }
  
  public URL getVideoCoverUrlWithSmartCut(boolean paramBoolean)
  {
    return getLazyModel().getVideoCoverUrlWithSmartCut(paramBoolean);
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    return getLazyModel().getVideoCoverWithSmartCut(paramInt1, paramInt2);
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
  
  public boolean hasFamilyCommentIcon()
  {
    return (this.familyCommentInfo != null) && (this.familyCommentInfo.a());
  }
  
  public boolean hasOnlyTwoVideoFeeds()
  {
    if ((!onh.a(this)) && (!onh.w(this))) {
      return false;
    }
    if ((this.mSubArtilceList != null) && (this.mSubArtilceList.size() == 1))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.mSubArtilceList.get(0);
      if ((localArticleInfo != null) && ((onh.a(localArticleInfo)) || (onh.w(localArticleInfo)))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasSearchWordInfo()
  {
    return (!TextUtils.isEmpty(this.mSearchWordTitle)) && (this.mSearchWords.size() != 0);
  }
  
  public void invalidateProteusTemplateBean()
  {
    this.mProteusTemplateBean = null;
  }
  
  public boolean isPGCShortContent()
  {
    return ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean)) || (this.mArticleType == 1);
  }
  
  public boolean isSocialFeed()
  {
    return (this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qci != null);
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
  
  public boolean isVideoItemForCommonUrlJump()
  {
    return (this.mVideoAdsJumpType == 3) && (!TextUtils.isEmpty(this.mVideoAdsJumpUrl));
  }
  
  public boolean isVideoItemForWeishiJump()
  {
    return this.mVideoAdsJumpType == 2;
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
    Object localObject1;
    if ((this.mCommentInfoBytes != null) && (this.mCommentInfoBytes.length > 0))
    {
      CodedInputStreamMicro localCodedInputStreamMicro1 = CodedInputStreamMicro.newInstance(this.mCommentInfoBytes);
      localObject1 = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
      try
      {
        while (!localCodedInputStreamMicro1.isAtEnd())
        {
          localCodedInputStreamMicro1.readTag();
          ((PBRepeatMessageField)localObject1).readFrom(localCodedInputStreamMicro1);
        }
        if (this.mMultiBiuSameListBytes == null) {
          break label180;
        }
      }
      catch (Exception localException9)
      {
        localException9.printStackTrace();
        this.mCommentsObj = ((PBRepeatMessageField)localObject1).get();
      }
    }
    if (this.mMultiBiuSameListBytes.length > 0)
    {
      CodedInputStreamMicro localCodedInputStreamMicro2 = CodedInputStreamMicro.newInstance(this.mMultiBiuSameListBytes);
      localObject1 = PBField.initRepeatMessage(articlesummary.MultiBiuSameContent.class);
      try
      {
        while (!localCodedInputStreamMicro2.isAtEnd())
        {
          localCodedInputStreamMicro2.readTag();
          ((PBRepeatMessageField)localObject1).readFrom(localCodedInputStreamMicro2);
        }
        if (this.mPackInfoBytes == null) {
          break label250;
        }
      }
      catch (Exception localException10)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead_mMultiBiuSameListBytes" + QLog.getStackTraceString(localException10));
        }
        this.mMultiBiuSameListObj = ((PBRepeatMessageField)localObject1).get();
        this.multiBiuSameContentList = MultiBiuSameContent.a(this.mMultiBiuSameListObj);
      }
    }
    label180:
    if (this.mPackInfoBytes.length > 0) {
      this.mPackInfoObj = new articlesummary.PackInfo();
    }
    try
    {
      this.mPackInfoObj.mergeFrom(this.mPackInfoBytes);
      this.mGroupId = this.mPackInfoObj.uint64_pack_id.get();
      if (this.mPackInfoObj != null) {
        this.mPolymericInfo = qbs.a(this.mPackInfoObj);
      }
      label250:
      if ((this.mSubscribeInfoBytes != null) && (this.mSubscribeInfoBytes.length > 0)) {
        this.mSubscribeInfoObj = new articlesummary.SubscribeInfo();
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
    {
      try
      {
        this.mSubscribeInfoObj.mergeFrom(this.mSubscribeInfoBytes);
        if ((this.mSocialFeedInfoByte != null) && (this.mSocialFeedInfoByte.length > 0)) {
          localObject1 = new articlesummary.SocializeFeedsInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
      {
        try
        {
          ((articlesummary.SocializeFeedsInfo)localObject1).mergeFrom(this.mSocialFeedInfoByte);
          this.mSocialFeedInfo = SocializeFeedsInfo.a((articlesummary.SocializeFeedsInfo)localObject1);
          if ((this.mVideoColumnInfoBytes != null) && (this.mVideoColumnInfoBytes.length > 0)) {
            localObject1 = new articlesummary.VideoColumnInfo();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
        {
          try
          {
            ((articlesummary.VideoColumnInfo)localObject1).mergeFrom(this.mVideoColumnInfoBytes);
            this.mVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject1);
            if ((this.multiVideoColumnInfoBytes != null) && (this.multiVideoColumnInfoBytes.length > 0)) {
              localObject1 = new articlesummary.VideoColumnInfo();
            }
          }
          catch (Exception localInvalidProtocolBufferMicroException4)
          {
            try
            {
              ((articlesummary.VideoColumnInfo)localObject1).mergeFrom(this.multiVideoColumnInfoBytes);
              this.multiVideoColumnInfo = qbm.a((articlesummary.VideoColumnInfo)localObject1);
              if ((this.mKdLiveInfoBytes != null) && (this.mKdLiveInfoBytes.length > 0)) {
                localObject1 = new articlesummary.KdLiveInfo();
              }
            }
            catch (Exception localInvalidProtocolBufferMicroException4)
            {
              try
              {
                ((articlesummary.KdLiveInfo)localObject1).mergeFrom(this.mKdLiveInfoBytes);
                this.mKdLiveInfo = qbf.a((articlesummary.KdLiveInfo)localObject1);
                if ((this.mSimpleVideoColumnInfoBytes != null) && (this.mSimpleVideoColumnInfoBytes.length > 0)) {
                  localObject1 = new articlesummary.VideoColumnInfo();
                }
              }
              catch (Exception localInvalidProtocolBufferMicroException4)
              {
                try
                {
                  ((articlesummary.VideoColumnInfo)localObject1).mergeFrom(this.mSimpleVideoColumnInfoBytes);
                  this.mSimpleVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject1);
                  if ((this.scripCmsInfoByte != null) && (this.scripCmsInfoByte.length > 0)) {
                    localObject1 = new articlesummary.ScripCmsInfo();
                  }
                }
                catch (Exception localInvalidProtocolBufferMicroException4)
                {
                  try
                  {
                    ((articlesummary.ScripCmsInfo)localObject1).mergeFrom(this.scripCmsInfoByte);
                    this.scripCmsInfo = qcb.a((articlesummary.ScripCmsInfo)localObject1);
                    if ((this.familyCommentInfoByte != null) && (this.familyCommentInfoByte.length > 0)) {
                      localObject1 = new articlesummary.FamilyCommentInfo();
                    }
                  }
                  catch (Exception localInvalidProtocolBufferMicroException4)
                  {
                    try
                    {
                      ((articlesummary.FamilyCommentInfo)localObject1).mergeFrom(this.familyCommentInfoByte);
                      this.familyCommentInfo = qax.a((articlesummary.FamilyCommentInfo)localObject1);
                      if ((this.fusionBiuInfoByte != null) && (this.fusionBiuInfoByte.length > 0)) {
                        localObject1 = new articlesummary.FusionBiuInfo();
                      }
                    }
                    catch (Exception localInvalidProtocolBufferMicroException4)
                    {
                      try
                      {
                        ((articlesummary.FusionBiuInfo)localObject1).mergeFrom(this.fusionBiuInfoByte);
                        this.fusionBiuInfo = FusionBiuInfo.a((articlesummary.FusionBiuInfo)localObject1);
                        if ((this.mLableListInfoBytes != null) && (this.mLableListInfoBytes.length > 0))
                        {
                          CodedInputStreamMicro localCodedInputStreamMicro3 = CodedInputStreamMicro.newInstance(this.mLableListInfoBytes);
                          localObject1 = PBField.initRepeatMessage(articlesummary.ChannelInfo.class);
                          try
                          {
                            while (!localCodedInputStreamMicro3.isAtEnd())
                            {
                              localCodedInputStreamMicro3.readTag();
                              ((PBRepeatMessageField)localObject1).readFrom(localCodedInputStreamMicro3);
                            }
                            if (this.mTopicRecommendFeedsInfoByte == null) {
                              break label717;
                            }
                          }
                          catch (Exception localException11)
                          {
                            localException11.printStackTrace();
                            this.mLabelListObj = ((PBRepeatMessageField)localObject1).get();
                          }
                        }
                        if (this.mTopicRecommendFeedsInfoByte.length > 0) {
                          localObject1 = new articlesummary.TopicRecommendFeedsInfo();
                        }
                      }
                      catch (Exception localInvalidProtocolBufferMicroException4)
                      {
                        try
                        {
                          ((articlesummary.TopicRecommendFeedsInfo)localObject1).mergeFrom(this.mTopicRecommendFeedsInfoByte);
                          this.mTopicRecommendFeedsInfo = qdq.a((articlesummary.TopicRecommendFeedsInfo)localObject1);
                          label717:
                          if ((this.mArkAppFeedsInfoBytes != null) && (this.mArkAppFeedsInfoBytes.length > 0)) {
                            localObject1 = new articlesummary.ArkAppFeedsInfo();
                          }
                        }
                        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
                        {
                          try
                          {
                            for (;;)
                            {
                              ((articlesummary.ArkAppFeedsInfo)localObject1).mergeFrom(this.mArkAppFeedsInfoBytes);
                              this.mArkAppFeedsInfo = qak.a((articlesummary.ArkAppFeedsInfo)localObject1);
                              if ((this.mSubArticleListBytes == null) || (this.mSubArticleListBytes.length <= 0)) {
                                break label1258;
                              }
                              CodedInputStreamMicro localCodedInputStreamMicro4 = CodedInputStreamMicro.newInstance(this.mSubArticleListBytes);
                              localObject1 = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
                              try
                              {
                                while (!localCodedInputStreamMicro4.isAtEnd())
                                {
                                  localCodedInputStreamMicro4.readTag();
                                  ((PBRepeatMessageField)localObject1).readFrom(localCodedInputStreamMicro4);
                                }
                                if (this.mSubSummaryListObj.size() <= 0) {
                                  break label1258;
                                }
                              }
                              catch (Exception localException12)
                              {
                                localException12.printStackTrace();
                                this.mSubSummaryListObj = ((PBRepeatMessageField)localObject1).get();
                                if (this.mSubSummaryListObj == null) {
                                  break label1258;
                                }
                              }
                              localObject1 = new ArrayList(this.mSubSummaryListObj.size());
                              localObject5 = this.mSubSummaryListObj.iterator();
                              int j;
                              for (int i = 0; ((Iterator)localObject5).hasNext(); i = j)
                              {
                                ArticleInfo localArticleInfo = poq.a((articlesummary.ArticleSummary)((Iterator)localObject5).next(), (int)this.mChannelID, 0, null);
                                ((ArrayList)localObject1).add(localArticleInfo);
                                if ((!QLog.isColorLevel()) || (localArticleInfo == null)) {
                                  break label1840;
                                }
                                StringBuilder localStringBuilder = new StringBuilder().append("postRead(): 解析 sub articleSummary【");
                                j = i + 1;
                                QLog.e("Q.readinjoy.BaseArticleInfo", 2, i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + onh.c(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " algorithmID : " + localArticleInfo.mAlgorithmID + " mAlgorithmGroup:" + localArticleInfo.mAlgorithmGroup + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
                              }
                              localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
                              localInvalidProtocolBufferMicroException1.printStackTrace();
                              this.mPackInfoObj = null;
                              continue;
                              localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
                              localInvalidProtocolBufferMicroException2.printStackTrace();
                              this.mSubscribeInfoObj = null;
                              continue;
                              localInvalidProtocolBufferMicroException3 = localInvalidProtocolBufferMicroException3;
                              QLog.e("Q.readinjoy.BaseArticleInfo", 1, "postRead: ", localInvalidProtocolBufferMicroException3);
                              this.mSocialFeedInfo = null;
                              continue;
                              localException1 = localException1;
                              QLog.e("Q.readinjoy.BaseArticleInfo", 1, "mergeFrom VideoColumnInfo error: ", localException1);
                              this.mVideoColumnInfo = null;
                              continue;
                              localException2 = localException2;
                              this.multiVideoColumnInfo = null;
                              continue;
                              localException3 = localException3;
                              this.mKdLiveInfo = null;
                              continue;
                              localException4 = localException4;
                              this.mSimpleVideoColumnInfo = null;
                              continue;
                              localException5 = localException5;
                              this.scripCmsInfo = null;
                              continue;
                              localException6 = localException6;
                              this.familyCommentInfo = null;
                              continue;
                              localException7 = localException7;
                              this.fusionBiuInfo = null;
                            }
                            localInvalidProtocolBufferMicroException4 = localInvalidProtocolBufferMicroException4;
                            localInvalidProtocolBufferMicroException4.printStackTrace();
                            this.mTopicRecommendFeedsInfo = null;
                          }
                          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
                          {
                            label1690:
                            label1840:
                            for (;;)
                            {
                              Object localObject5;
                              localInvalidProtocolBufferMicroException5.printStackTrace();
                              if (QLog.isColorLevel()) {
                                QLog.d("Q.readinjoy.", 2, "arkAppFeedsInfo convertPBToInfo failed.");
                              }
                              this.mArkAppFeedsInfo = null;
                              continue;
                              this.mSubArtilceList = localInvalidProtocolBufferMicroException5;
                              label1258:
                              Object localObject2;
                              if ((this.mNewPackInfoBytes != null) && (this.mNewPackInfoBytes.length > 0)) {
                                localObject2 = new articlesummary.NewPackInfo();
                              }
                              try
                              {
                                ((articlesummary.NewPackInfo)localObject2).mergeFrom(this.mNewPackInfoBytes);
                                if (localObject2 != null) {
                                  this.mNewPolymericInfo = qbn.a((articlesummary.NewPackInfo)localObject2);
                                }
                                if ((this.mRecommendFollowInfoBytes != null) && (this.mRecommendFollowInfoBytes.length > 0)) {
                                  localObject2 = new articlesummary.RecommendFollowInfos();
                                }
                              }
                              catch (InvalidProtocolBufferMicroException localException8)
                              {
                                try
                                {
                                  ((articlesummary.RecommendFollowInfos)localObject2).mergeFrom(this.mRecommendFollowInfoBytes);
                                  if (localObject2 != null) {
                                    this.mRecommendFollowInfos = qbx.a((articlesummary.RecommendFollowInfos)localObject2);
                                  }
                                  if ((this.hotWordInfoListBytes != null) && (this.hotWordInfoListBytes.length > 0)) {
                                    localObject2 = new articlesummary.HotWordInfo();
                                  }
                                }
                                catch (InvalidProtocolBufferMicroException localException8)
                                {
                                  try
                                  {
                                    ((articlesummary.HotWordInfo)localObject2).mergeFrom(this.hotWordInfoListBytes);
                                    if (localObject2 != null) {
                                      this.hotWordInfo = qbc.a((articlesummary.HotWordInfo)localObject2);
                                    }
                                    if ((this.mExtraBiuBriefBytes != null) && (this.mExtraBiuBriefBytes.length > 0)) {
                                      localObject2 = new articlesummary.AggregatedList();
                                    }
                                  }
                                  catch (InvalidProtocolBufferMicroException localException8)
                                  {
                                    try
                                    {
                                      ((articlesummary.AggregatedList)localObject2).mergeFrom(this.mExtraBiuBriefBytes);
                                      if (localObject2 != null) {
                                        this.mExtraBiuBriefInfo = qav.a((articlesummary.AggregatedList)localObject2);
                                      }
                                      handlerFeedsTypeInOldVersionDatabase();
                                      if ((this.bytesBusiData != null) && (this.bytesBusiData.length > 0)) {
                                        this.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
                                      }
                                    }
                                    catch (InvalidProtocolBufferMicroException localException8)
                                    {
                                      try
                                      {
                                        this.mGalleryFeedsInfo.mergeFrom(this.bytesBusiData);
                                        if ((this.mVideoDownloadBarInfoBytes != null) && (this.mVideoDownloadBarInfoBytes.length > 0)) {
                                          this.mVideoDownloadBarInfo = new articlesummary.VideoDownloadBarInfo();
                                        }
                                      }
                                      catch (InvalidProtocolBufferMicroException localException8)
                                      {
                                        try
                                        {
                                          this.mVideoDownloadBarInfo.mergeFrom(this.mVideoDownloadBarInfoBytes);
                                          if ((this.mPartnerAccountInfoBytes != null) && (this.mPartnerAccountInfoBytes.length > 0)) {
                                            this.mPartnerAccountInfo = new articlesummary.PartnerAccountInfo();
                                          }
                                        }
                                        catch (InvalidProtocolBufferMicroException localException8)
                                        {
                                          try
                                          {
                                            this.mPartnerAccountInfo.mergeFrom(this.mPartnerAccountInfoBytes);
                                            if ((this.srtUniversalIDBytesList != null) && (this.srtUniversalIDBytesList.length > 0))
                                            {
                                              localObject5 = CodedInputStreamMicro.newInstance(this.srtUniversalIDBytesList);
                                              localObject2 = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
                                              try
                                              {
                                                while (!((CodedInputStreamMicro)localObject5).isAtEnd())
                                                {
                                                  ((CodedInputStreamMicro)localObject5).readTag();
                                                  ((PBRepeatMessageField)localObject2).readFrom((CodedInputStreamMicro)localObject5);
                                                }
                                                if (this.mWeishiUGInfo == null) {
                                                  break label1690;
                                                }
                                              }
                                              catch (Exception localException13)
                                              {
                                                if (QLog.isColorLevel()) {
                                                  QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead_mMultiBiuSameListBytes" + QLog.getStackTraceString(localException13));
                                                }
                                                this.srtUniversalID = ((PBRepeatMessageField)localObject2).get();
                                              }
                                            }
                                            if (this.mWeishiUGInfo.length > 0) {
                                              this.weishiUGInfo = new articlesummary.WeishiUGInfo();
                                            }
                                          }
                                          catch (Exception localException8)
                                          {
                                            try
                                            {
                                              for (;;)
                                              {
                                                this.weishiUGInfo.mergeFrom(this.mWeishiUGInfo);
                                                qad.a(this);
                                                return;
                                                localInvalidProtocolBufferMicroException6 = localInvalidProtocolBufferMicroException6;
                                                localInvalidProtocolBufferMicroException6.printStackTrace();
                                                Object localObject3 = null;
                                                continue;
                                                localInvalidProtocolBufferMicroException11 = localInvalidProtocolBufferMicroException11;
                                                if (QLog.isColorLevel())
                                                {
                                                  QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead" + QLog.getStackTraceString(localInvalidProtocolBufferMicroException11));
                                                  continue;
                                                  localInvalidProtocolBufferMicroException12 = localInvalidProtocolBufferMicroException12;
                                                  if (QLog.isColorLevel())
                                                  {
                                                    QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead" + QLog.getStackTraceString(localInvalidProtocolBufferMicroException12));
                                                    continue;
                                                    localInvalidProtocolBufferMicroException7 = localInvalidProtocolBufferMicroException7;
                                                    localInvalidProtocolBufferMicroException7.printStackTrace();
                                                    Object localObject4 = null;
                                                    continue;
                                                    localInvalidProtocolBufferMicroException8 = localInvalidProtocolBufferMicroException8;
                                                    localInvalidProtocolBufferMicroException8.printStackTrace();
                                                    continue;
                                                    localInvalidProtocolBufferMicroException9 = localInvalidProtocolBufferMicroException9;
                                                    localInvalidProtocolBufferMicroException9.printStackTrace();
                                                    this.mVideoDownloadBarInfo = null;
                                                  }
                                                }
                                              }
                                              localException8 = localException8;
                                              this.mPartnerAccountInfo = null;
                                            }
                                            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException10)
                                            {
                                              for (;;)
                                              {
                                                localInvalidProtocolBufferMicroException10.printStackTrace();
                                                this.weishiUGInfo = null;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void prewrite()
  {
    Object localObject;
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((this.mCommentsObj != null) && (this.mCommentsObj.size() > 0))
    {
      localObject = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
      ((PBRepeatMessageField)localObject).addAll(this.mCommentsObj);
      localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
    }
    try
    {
      localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
      ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      this.mCommentInfoBytes = localByteArrayOutputStream.toByteArray();
      if ((this.mMultiBiuSameListObj != null) && (this.mMultiBiuSameListObj.size() > 0))
      {
        localObject = PBField.initRepeatMessage(articlesummary.MultiBiuSameContent.class);
        ((PBRepeatMessageField)localObject).addAll(this.mMultiBiuSameListObj);
        localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
      }
    }
    catch (IOException localIOException4)
    {
      try
      {
        localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
        ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
        localCodedOutputStreamMicro.flush();
        this.mMultiBiuSameListBytes = localByteArrayOutputStream.toByteArray();
        if (this.mPackInfoObj != null) {
          this.mPackInfoBytes = this.mPackInfoObj.toByteArray();
        }
        if (this.mSubscribeInfoObj != null) {
          this.mSubscribeInfoBytes = this.mSubscribeInfoObj.toByteArray();
        }
        if (this.mSocialFeedInfo != null)
        {
          this.mSocialFeedInfoByte = this.mSocialFeedInfo.a();
          if (this.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
            this.publishUin = this.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
          }
        }
        if (this.mTopicRecommendFeedsInfo != null) {
          this.mTopicRecommendFeedsInfoByte = this.mTopicRecommendFeedsInfo.a().toByteArray();
        }
        if (this.mArkAppFeedsInfo != null)
        {
          localObject = this.mArkAppFeedsInfo.a();
          if (localObject != null) {
            this.mArkAppFeedsInfoBytes = ((articlesummary.ArkAppFeedsInfo)localObject).toByteArray();
          }
        }
        if ((this.mLabelListObj != null) && (this.mLabelListObj.size() > 0))
        {
          localObject = PBField.initRepeatMessage(articlesummary.ChannelInfo.class);
          ((PBRepeatMessageField)localObject).addAll(this.mLabelListObj);
          localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
        }
      }
      catch (IOException localIOException4)
      {
        try
        {
          localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
          ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
          localCodedOutputStreamMicro.flush();
          this.mLableListInfoBytes = localByteArrayOutputStream.toByteArray();
          if ((this.mSubSummaryListObj != null) && (this.mSubSummaryListObj.size() > 0))
          {
            localObject = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
            ((PBRepeatMessageField)localObject).addAll(this.mSubSummaryListObj);
            localByteArrayOutputStream = new ByteArrayOutputStream(((PBRepeatMessageField)localObject).computeSize(1));
          }
        }
        catch (IOException localIOException4)
        {
          try
          {
            CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
            ((PBRepeatMessageField)localObject).writeTo(localCodedOutputStreamMicro, 1);
            localCodedOutputStreamMicro.flush();
            this.mSubArticleListBytes = localByteArrayOutputStream.toByteArray();
            if (this.mVideoColumnInfo != null) {
              this.mVideoColumnInfoBytes = this.mVideoColumnInfo.a();
            }
            if (this.mSimpleVideoColumnInfo != null) {
              this.mSimpleVideoColumnInfoBytes = this.mSimpleVideoColumnInfo.a();
            }
            if (this.mNewPolymericInfo != null)
            {
              this.mNewPackInfoBytes = this.mNewPolymericInfo.a();
              if ((this.mNewPolymericInfo.jdField_a_of_type_Boolean) && (this.publishUin == 0L)) {
                if (this.mNewPolymericInfo.jdField_a_of_type_Int != 6) {
                  if (this.mNewPolymericInfo.jdField_a_of_type_Int != 11) {
                    break label514;
                  }
                }
              }
            }
          }
          catch (IOException localIOException4)
          {
            try
            {
              for (;;)
              {
                this.publishUin = Long.parseLong(this.mSubscribeID);
                label514:
                if (this.mExtraBiuBriefInfo != null) {
                  this.mExtraBiuBriefBytes = this.mExtraBiuBriefInfo.a();
                }
                if (this.mRecommendFollowInfos != null) {
                  this.mRecommendFollowInfoBytes = this.mRecommendFollowInfos.a();
                }
                if (this.hotWordInfo != null) {
                  this.hotWordInfoListBytes = this.hotWordInfo.a();
                }
                if (this.mVideoDownloadBarInfo != null) {
                  this.mVideoDownloadBarInfoBytes = this.mVideoDownloadBarInfo.toByteArray();
                }
                if (this.mPartnerAccountInfo != null) {
                  this.mPartnerAccountInfoBytes = this.mPartnerAccountInfo.toByteArray();
                }
                return;
                localIOException1 = localIOException1;
                localIOException1.printStackTrace();
                continue;
                localIOException2 = localIOException2;
                if (QLog.isColorLevel())
                {
                  QLog.e("Q.readinjoy.BaseArticleInfo", 2, "prewrite_mMultiBiuSameListBytes" + QLog.getStackTraceString(localIOException2));
                  continue;
                  localIOException3 = localIOException3;
                  localIOException3.printStackTrace();
                }
              }
              localIOException4 = localIOException4;
              localIOException4.printStackTrace();
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("Q.readinjoy.BaseArticleInfo", 2, "新聚合卡片帐号pgc类uin解析失败，e = " + localException + " articleID = " + this.mArticleID + " mSubscribeID = " + this.mSubscribeID);
              }
            }
          }
        }
      }
    }
  }
  
  public void setOnVideoCoverInterceptor(qan paramqan)
  {
    this.mVideoCoverInterceptor = paramqan;
  }
  
  public void setSearchWordInfo(String paramString, PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mSearchWordTitle = null;
      this.mSearchWords.clear();
      return;
    }
    Object localObject = Aladdin.getConfig(201);
    if (localObject != null) {
      this.mSearchWordTitle = ((AladdinConfig)localObject).getString("feeds_searchterm_text", paramString);
    }
    this.mSearchWords.clear();
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Paint localPaint = new Paint();
    localPaint.setTextSize(actj.a(14.0F, ((QQAppInterface)localObject).getApp().getResources()));
    int i = (int)bbdh.k() - actj.a(14.0F, ((QQAppInterface)localObject).getApp().getResources()) - (int)localPaint.measureText(paramString);
    int j;
    label146:
    RequestSearchWord.Rcmd localRcmd;
    if (paramPBStringField.has())
    {
      paramString = paramPBStringField.get();
      this.mSearchWordSessionId = paramString;
      paramString = "";
      j = 0;
      if (j >= 4) {
        break label381;
      }
      paramPBStringField = paramPBRepeatMessageField.get().iterator();
      for (;;)
      {
        if (paramPBStringField.hasNext())
        {
          localRcmd = (RequestSearchWord.Rcmd)paramPBStringField.next();
          int k = (int)localPaint.measureText(localRcmd.word.get().toStringUtf8());
          k = actj.a(38.0F, ((QQAppInterface)localObject).getApp().getResources()) + k;
          if (i - k > 0) {
            if (TextUtils.isEmpty(paramString))
            {
              paramString = paramString + localRcmd.word.get().toStringUtf8();
              label264:
              int m = actj.a(14.0F, ((QQAppInterface)localObject).getApp().getResources());
              this.mSearchWords.add(localRcmd);
              paramPBStringField.remove();
              i -= k - m;
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label146;
      paramString = ((QQAppInterface)localObject).getCurrentAccountUin() + System.currentTimeMillis();
      break;
      paramString = paramString + "::" + localRcmd.word.get().toStringUtf8();
      break label264;
      label381:
      paramPBRepeatMessageField = " ";
      if (this.innerUniqueID != null) {
        paramPBRepeatMessageField = ByteStringMicro.copyFromUtf8(this.innerUniqueID).toStringUtf8();
      }
      awsq.a(null, new ReportModelDC02528().module("all_result").action("exp_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(this.mArticleContentUrl).ver4(paramString).ver5(this.mTitle).ver6(paramPBRepeatMessageField).session_id(this.mSearchWordSessionId));
      ((akiz)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "exp_Kdfeedsback_list", this.mSearchWordSessionId, this.mArticleContentUrl, paramString, this.mTitle, paramPBRepeatMessageField);
      return;
    }
  }
  
  public String toProteusOnlineString()
  {
    return "ProteusOnlineArticleInfo = {\nmArticleID = " + this.mArticleID + ", \nmArticleContentUrl = " + this.mArticleContentUrl + ", \nmRecommendSeq = " + this.mRecommendSeq + ", \nmTitle = " + this.mTitle + "\nmFeedsType = " + this.mFeedType + "\nmRowKey = " + this.innerUniqueID + "\nmFirstPagePicUrl = " + this.mFirstPagePicUrl + "\nmJsonPictureList = " + this.mJsonPictureList + "\nmJsonVideoList = " + this.mJsonVideoList + "\nproteusItemData = " + this.proteusItemsData + "\nmNewPolymericInfo = " + this.mNewPolymericInfo + "\n}";
  }
  
  public String toSString()
  {
    return "BaseArticleInfo{mArticleID=" + this.mArticleID + ", mTitle='" + this.mTitle + '\'' + ", mSummary='" + this.mSummary + '\'' + ", mFirstPagePicUrl='" + this.mFirstPagePicUrl + '\'' + ", mOriginalUrl='" + this.mOriginalUrl + '\'' + ", mArticleContentUrl='" + this.mArticleContentUrl + '\'' + ", mTime=" + this.mTime + ", mCommentCount=" + this.mCommentCount + ", mSubscribeID='" + this.mSubscribeID + '\'' + ", mSubscribeName='" + this.mSubscribeName + '\'' + ", mRecommendTime=" + this.mRecommendTime + ", mChannelID=" + this.mChannelID + ", mRecommendSeq=" + this.mRecommendSeq + ", mShowBigPicture=" + this.mShowBigPicture + ", mAlgorithmID=" + this.mAlgorithmID + ", mAlgorithmGroup=" + this.mAlgorithmGroup + ", mRecommentdReason='" + this.mRecommentdReason + '\'' + ", mJsonVideoList='" + this.mJsonVideoList + '\'' + ", mJsonPictureList='" + this.mJsonPictureList + '\'' + ", mAbandonRepeatFlag=" + this.mAbandonRepeatFlag + ", mArticleSubscriptText='" + this.mArticleSubscriptText + '\'' + ", mArticleSubscriptColor='" + this.mArticleSubscriptColor + '\'' + ", mArticleFriendLikeText='" + this.mArticleFriendLikeText + '\'' + ", mStrategyId=" + this.mStrategyId + ", mTopicPicWHRatio=" + this.mTopicPicWHRatio + ", mTopicPicInfo='" + this.mTopicPicInfo + '\'' + ", thirdIcon='" + this.thirdIcon + '\'' + ", thirdName='" + this.thirdName + '\'' + ", thirdAction='" + this.thirdAction + '\'' + ", busiType=" + this.busiType + ", innerUniqueID='" + this.innerUniqueID + '\'' + ", mVideoType=" + this.mVideoType + ", mChannelInfoId=" + this.mChannelInfoId + ", mChannelInfoName='" + this.mChannelInfoName + '\'' + ", mChannelInfoType=" + this.mChannelInfoType + ", mChannelInfoDisplayName='" + this.mChannelInfoDisplayName + '\'' + ", mCommentIconType=" + this.mCommentIconType + ", mServerContext=" + Arrays.toString(this.mServerContext) + ", mDiskLikeInfoString='" + this.mDiskLikeInfoString + '\'' + ", mSocialFeedInfoByte=" + Arrays.toString(this.mSocialFeedInfoByte) + ", mTopicRecommendFeedsInfoByte=" + Arrays.toString(this.mTopicRecommendFeedsInfoByte) + ", mFeedId=" + this.mFeedId + ", mFeedType=" + this.mFeedType + ", mCircleId=" + this.mCircleId + ", mStrCircleId='" + this.mStrCircleId + '\'' + ", mPUinIsActive=" + this.mPUinIsActive + ", mIsDispTimestamp=" + this.mIsDispTimestamp + ", mIsGallery=" + this.mIsGallery + ", mGalleryPicNumber=" + this.mGalleryPicNumber + ", mCommentInfoBytes=" + Arrays.toString(this.mCommentInfoBytes) + ", mPackInfoBytes=" + Arrays.toString(this.mPackInfoBytes) + ", mSubscribeInfoBytes=" + Arrays.toString(this.mSubscribeInfoBytes) + ", mVideoPlayCount=" + this.mVideoPlayCount + ", mLableListInfoBytes=" + Arrays.toString(this.mLableListInfoBytes) + ", videoJumpChannelID=" + this.videoJumpChannelID + ", videoJumpChannelType=" + this.videoJumpChannelType + ", videoJumpChannelName='" + this.videoJumpChannelName + '\'' + ", businessId=" + this.businessId + ", businessName='" + this.businessName + '\'' + ", businessUrl='" + this.businessUrl + '\'' + ", businessNamePrefix='" + this.businessNamePrefix + '\'' + ", mAccountLess=" + this.mAccountLess + ", publishUin=" + this.publishUin + ", interfaceData='" + this.interfaceData + '\'' + ", galleryReprotExdData='" + this.galleryReprotExdData + '\'' + ", articleStyle=" + this.articleStyle + ", proteusItemsData='" + this.proteusItemsData + '\'' + ", mArkAppFeedsInfo=" + this.mArkAppFeedsInfo + ", mArkAppFeedsInfoBytes=" + Arrays.toString(this.mArkAppFeedsInfoBytes) + ", mDislikeInfos=" + this.mDislikeInfos + ", like=" + this.like + ", mPictures=" + Arrays.toString(this.mPictures) + ", mSinglePicture=" + this.mSinglePicture + ", mVideoCoverUrl=" + this.mVideoCoverUrl + ", mVideoVid='" + this.mVideoVid + '\'' + ", mVideoDuration=" + this.mVideoDuration + ", mVideoJsonWidth=" + this.mVideoJsonWidth + ", mVideoJsonHeight=" + this.mVideoJsonHeight + ", mXGFileSize=" + this.mXGFileSize + ", mThirdVideoURL='" + this.mThirdVideoURL + '\'' + ", mThirdVideoURLExpireTime=" + this.mThirdVideoURLExpireTime + ", thirdUin='" + this.thirdUin + '\'' + ", thirdUinName='" + this.thirdUinName + '\'' + ", mCommentsObj=" + this.mCommentsObj + ", mPackInfoObj=" + this.mPackInfoObj + ", mPolymericInfo=" + this.mPolymericInfo + ", mIsInPolymeric=" + this.mIsInPolymeric + ", mSubscribeInfoObj=" + this.mSubscribeInfoObj + ", mGroupId=" + this.mGroupId + ", mGroupCount=" + this.mGroupCount + ", mFeedIndexInGroup=" + this.mFeedIndexInGroup + ", mHeaderIconUrl=" + this.mHeaderIconUrl + ", mSocialFeedInfo=" + this.mSocialFeedInfo + ", mLabelListObj=" + this.mLabelListObj + ", mTopicRecommendFeedsInfo=" + this.mTopicRecommendFeedsInfo + ", isNeedShowBtnWhenFollowed=" + this.isNeedShowBtnWhenFollowed + ", feedsFirstExposurePos=" + this.feedsFirstExposurePos + ", mSubArticleListBytes=" + Arrays.toString(this.mSubArticleListBytes) + ", mSubSummaryListObj=" + this.mSubSummaryListObj + ", mSubArtilceList=" + this.mSubArtilceList + ", mMergeVideoId=" + this.mMergeVideoId + ", mGroupSubArticleList=" + this.mGroupSubArticleList + ", mVideoCommentCount=" + this.mVideoCommentCount + ", mProteusTemplateBean=" + this.mProteusTemplateBean + ", mVideoArticleSubsText='" + this.mVideoArticleSubsText + '\'' + ", mVideoArticleSubsColor='" + this.mVideoArticleSubsColor + '\'' + ", mVideoAdsJumpUrl='" + this.mVideoAdsJumpUrl + '\'' + ", mVideoAdsJumpType=" + this.mVideoAdsJumpType + ", mVideoAdsSource=" + this.mVideoAdsSource + ", mVideoLogoUrl=" + this.mVideoLogoUrl + '}';
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BaseArticleInfo{mArticleID=").append(this.mArticleID).append("\n, mRecommendSeq=").append(this.mRecommendSeq).append("\n, mTitle=").append(this.mTitle).append("\n, mSummary=").append(this.mSummary).append("\n, mPUinIsActive=").append(this.mPUinIsActive).append("\n, mFeedType=").append(this.mFeedType).append("\n, mResolvedFeedType=").append(this.mResolvedFeedType).append("\n, mRowKey=").append(this.innerUniqueID).append("\n, icon_url=").append(this.icon_url).append("\n, icon_with=").append(this.icon_with).append("\n, icon_height=").append(this.icon_height).append("\n, uin=").append(this.uin).append("\n, nick_name=").append(this.nick_name).append("\n, comment_id=").append(this.comment_id).append("\n, content=").append(this.content).append("\n, jump_url=").append(this.jump_url).append("\n, isUseGif=").append(this.isUseGif).append("\n, mFirstPagePicUrl= ").append(this.mFirstPagePicUrl).append("\n, mJsonPictureList= ").append(this.mJsonPictureList).append("\n, mJsonVideoList= ").append(this.mJsonVideoList).append("\n, proteusItemsData= ").append(this.proteusItemsData).append("\n, mNewPolymericInfo= ").append(this.mNewPolymericInfo).append("\n, mFeedId=");
    if (this.mSocialFeedInfo != null) {}
    for (long l = this.mSocialFeedInfo.jdField_a_of_type_Long;; l = 0L) {
      return l + "\n, isShowRecommendList= " + this.isShowRecommendList + "\n, isPGCShortContent= " + isPGCShortContent() + "\n, isAccountShown= " + this.isAccountShown + "\n, mSocialFeedInfo= " + this.mSocialFeedInfo + "\n, mExtraBiuLevel= " + qav.a(this) + "\n, mArticleContentUrl= " + this.mArticleContentUrl + "\n, isCardJumpUrlAvailable= " + this.isCardJumpUrlAvailable + "\n, mCardJumpUrl= " + this.mCardJumpUrl + "\n, mPartnerAccountInfo= " + getPartnerAccountInfoStr() + "\n, comment_jump_url= " + this.comment_jump_url + "\n, adReportCommonData= " + this.adReportCommonData + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */