package com.tencent.biz.pubaccount.readinjoy.struct;

import aekt;
import amap;
import android.graphics.Paint;
import android.text.TextUtils;
import awbv;
import awdg;
import aynt;
import bdcb;
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
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaLogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import pai;
import pb.unite.search.RequestSearchWord.Rcmd;
import pcq;
import pcr;
import puy;
import pww;
import qjy;
import qkf;
import qkh;
import qkj;
import qks;
import qku;
import qky;
import qla;
import qlb;
import qli;
import qlj;
import qlo;
import qlt;
import qlx;
import qmc;
import qme;
import qmr;
import qmw;
import qnm;
import qnp;
import qns;
import slx;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
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
  extends awbv
  implements qla
{
  @awdg
  public static final int ARTICLE_TYPE_NOMAL = 0;
  @awdg
  public static final int ARTICLE_TYPE_SHORT_CONTENT = 1;
  @awdg
  private static final String TAG = "Q.readinjoy.BaseArticleInfo";
  public String adReportCommonData;
  public int articleStyle;
  @awdg
  public slx articleViewModel;
  public String avatar;
  public int busiType = 1;
  public long businessId;
  public String businessName = "";
  public String businessNamePrefix = "";
  public String businessUrl = "";
  public byte[] bytesBusiData;
  public int click_area;
  public String click_jump_target;
  @awdg
  public List<VideoColumnInfo> columnEntrances;
  public byte[] columnEntrancesBytes;
  public String commentBtnJumpUrl;
  public String comment_id;
  public String comment_jump_url;
  public String content;
  @awdg
  public qku familyCommentInfo;
  public byte[] familyCommentInfoByte;
  @awdg
  public int feedsFirstExposurePos = -1;
  public String galleryReprotExdData;
  public String gifCoverUrl;
  public boolean hasAwesome;
  public boolean hasWalletIcon;
  @awdg
  public boolean hintFlag;
  @awdg
  public qky hotWordInfo;
  public byte[] hotWordInfoListBytes;
  public int icon_height;
  public String icon_url;
  public int icon_with;
  public String innerUniqueID;
  public String interfaceData;
  public boolean isAccountShown;
  public int isCardJumpUrlAvailable;
  public int isCloseDislike;
  public boolean isColumnAnimationPlay;
  public boolean isExtraBiuExpanded;
  @awdg
  public boolean isNeeaRealExposureFilter;
  @awdg
  public boolean isNeedShowBtnWhenFollowed;
  @awdg
  public boolean isPublicAccountFollowed;
  public boolean isShowColumnAnimation;
  @awdg
  public boolean isShowFreeNetFlow;
  @awdg
  public boolean isShowGif;
  @awdg
  public boolean isShowRecommendList;
  public int isSuperTop;
  public boolean isSuperTopic;
  @awdg
  public boolean isTwoItem;
  public boolean isUseGif;
  public String jump_url;
  @awdg
  public boolean like;
  public int mAbandonRepeatFlag;
  public int mAccountLess;
  public long mAlgorithmGroup = -1L;
  public long mAlgorithmID = -1L;
  @awdg
  public qkf mArkAppFeedsInfo;
  public byte[] mArkAppFeedsInfoBytes;
  public String mArticleContentUrl = "";
  public String mArticleFriendLikeText;
  public long mArticleID = -1L;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  public int mArticleType;
  @awdg
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
  @awdg
  public List<articlesummary.CommentInfo> mCommentsObj;
  @awdg
  public int mCurrentX;
  public String mDianDianLabelIconUrl;
  public String mDianDianLabelText;
  public String mDiskLikeInfoString;
  @awdg
  public ArrayList<DislikeInfo> mDislikeInfos;
  public byte[] mExtraBiuBriefBytes;
  @awdg
  public qks mExtraBiuBriefInfo;
  public String mFeedCookie;
  public long mFeedId;
  @awdg
  public long mFeedIndexInGroup;
  public int mFeedType;
  public String mFirstPagePicUrl = "";
  public String mGWCommonData;
  @awdg
  public galleryFeeds.GalleryFeedsInfo mGalleryFeedsInfo;
  public int mGalleryPicNumber;
  @awdg
  public long mGroupCount;
  @awdg
  public long mGroupId = -1L;
  @awdg
  public List<BaseArticleInfo> mGroupSubArticleList;
  @awdg
  public URL mHeaderIconUrl;
  public int mIsDispTimestamp;
  public int mIsGallery;
  @awdg
  public boolean mIsGalleryChannel;
  @awdg
  public boolean mIsInPolymeric;
  public boolean mIsPolymericGallery;
  public int mIsShowSearchord;
  public String mJsonPictureList;
  public String mJsonVideoList;
  @awdg
  public int mJumpType;
  @awdg
  public qlb mKdLiveInfo;
  public byte[] mKdLiveInfoBytes;
  @awdg
  public List<articlesummary.ChannelInfo> mLabelListObj;
  public byte[] mLableListInfoBytes;
  public long mMergeVideoId;
  @awdg
  private qla mModel;
  public byte[] mMultiBiuSameListBytes;
  @awdg
  public List<articlesummary.MultiBiuSameContent> mMultiBiuSameListObj;
  public byte[] mNewPackInfoBytes;
  @awdg
  public qlj mNewPolymericInfo;
  public String mOriginalUrl = "";
  public boolean mPUinIsActive;
  public byte[] mPackInfoBytes;
  @awdg
  public articlesummary.PackInfo mPackInfoObj;
  @awdg
  public articlesummary.PartnerAccountInfo mPartnerAccountInfo;
  public byte[] mPartnerAccountInfoBytes;
  @awdg
  public URL[] mPictures;
  @awdg
  public qlo mPolymericInfo;
  @awdg
  public URL mPolymericSmallVideoCoverUrl;
  @awdg
  public volatile TemplateBean mProteusTemplateBean;
  public long mRecommendFollowId;
  public byte[] mRecommendFollowInfoBytes;
  @awdg
  public qlt mRecommendFollowInfos;
  public long mRecommendSeq = -1L;
  public long mRecommendTime = -1L;
  public String mRecommentdReason = "";
  @awdg
  public String mRefreshTime = "0";
  public String mReportCommonData;
  @awdg
  public int mResolvedFeedType;
  public String mSearchWordSessionId;
  public String mSearchWordTitle;
  public ArrayList<RequestSearchWord.Rcmd> mSearchWords = new ArrayList();
  public byte[] mServerContext;
  public boolean mShowBigPicture;
  @awdg
  public VideoColumnInfo mSimpleVideoColumnInfo;
  public byte[] mSimpleVideoColumnInfoBytes;
  @awdg
  public URL mSinglePicture;
  @awdg
  public SocializeFeedsInfo mSocialFeedInfo;
  public byte[] mSocialFeedInfoByte;
  public String mStrCircleId;
  public int mStrategyId;
  public byte[] mSubArticleListBytes;
  @awdg
  public List<ArticleInfo> mSubArtilceList;
  @awdg
  public List<articlesummary.ArticleSummary> mSubSummaryListObj;
  public String mSubscribeID = "";
  public byte[] mSubscribeInfoBytes;
  @awdg
  public articlesummary.SubscribeInfo mSubscribeInfoObj;
  public String mSubscribeName = "";
  public String mSummary = "";
  @awdg
  public String mThirdVideoURL;
  @awdg
  public long mThirdVideoURLExpireTime;
  public long mTime = -1L;
  public String mTitle = "";
  public String mTopicPicInfo = "";
  public double mTopicPicWHRatio;
  @awdg
  public qnm mTopicRecommendFeedsInfo;
  public byte[] mTopicRecommendFeedsInfoByte;
  public int mVideoAdsJumpType;
  public String mVideoAdsJumpUrl;
  public int mVideoAdsSource;
  public String mVideoArticleSubsColor;
  public String mVideoArticleSubsText;
  @awdg
  public VideoColumnInfo mVideoColumnInfo;
  public byte[] mVideoColumnInfoBytes;
  public int mVideoCommentCount;
  @awdg
  private qkj mVideoCoverInterceptor;
  @awdg
  public URL mVideoCoverUrl;
  @awdg
  public articlesummary.VideoDownloadBarInfo mVideoDownloadBarInfo;
  public byte[] mVideoDownloadBarInfoBytes;
  @awdg
  public int mVideoDuration;
  @awdg
  public int mVideoJsonHeight;
  @awdg
  public int mVideoJsonWidth;
  public String mVideoLogoUrl;
  public int mVideoPlayCount;
  public int mVideoType;
  @awdg
  public String mVideoVid;
  public byte[] mWeishiUGInfo;
  @awdg
  public long mXGFileSize;
  public String msgBoxBriefContent;
  public String msgBoxBriefPreFix;
  public int msgBoxBriefPreFixType;
  @awdg
  public ArrayList<MultiBiuSameContent> multiBiuSameContentList;
  @awdg
  public qli multiVideoColumnInfo;
  public byte[] multiVideoColumnInfoBytes;
  public String nick_name;
  @awdg
  public qkh patchStatus = new qkh();
  public String proteusItemsData;
  @awdg
  public PTSItemData ptsItemData;
  public byte[] ptsItemDataBytes;
  public String ptsLiteAppName;
  public long publishUin;
  public String rawkey;
  @awdg
  public qlx scripCmsInfo;
  public byte[] scripCmsInfoByte;
  public boolean showBreathAnimation;
  @awdg
  public List<articlesummary.SRTUniversalID> srtUniversalID;
  public byte[] srtUniversalIDBytesList;
  public pcq strategy;
  public pcr strategyCallback;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @awdg
  public String thirdUin;
  @awdg
  public String thirdUinName;
  public long uin;
  public String vIconUrl;
  public int videoJumpChannelID = -1;
  public String videoJumpChannelName = "";
  public int videoJumpChannelType = -1;
  public String videoReportInfo;
  public String viewRowkey;
  @awdg
  public pai waterFallPic;
  @awdg
  public articlesummary.WeishiUGInfo weishiUGInfo;
  private String wormholeData;
  private String wormholeId;
  
  private qla getLazyModel()
  {
    if (this.mModel == null) {
      this.mModel = qns.a(this);
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
  
  private String getSocialCardJumpInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("card_jump_url", this.mCardJumpUrl);
    return localJSONObject.toString();
  }
  
  private String getSocialInfo()
  {
    if (this.mSocialFeedInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("like_count", this.mSocialFeedInfo.b).put("myself_like_status", this.mSocialFeedInfo.c).put("comments_count", this.mSocialFeedInfo.d).put("biu_count", this.mSocialFeedInfo.f).put("follow_status", this.mSocialFeedInfo.h).put("follow_count", this.mSocialFeedInfo.i).put("card_jump_info", getSocialCardJumpInfo());
    return localJSONObject.toString();
  }
  
  private void handlerFeedsTypeInOldVersionDatabase()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qna != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for wenda article articleinfo = " + toString());
      }
      if ((this.mFeedType != 1) || (this.mSocialFeedInfo.jdField_a_of_type_Qmc == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qmc.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qmw == null)) {
        break label529;
      }
      if ((this.mSocialFeedInfo.jdField_a_of_type_Qmw.b != 3) || (this.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue() == 21)) {
        break label463;
      }
      this.mSocialFeedInfo.jdField_a_of_type_Qmc.b = Long.valueOf(21L);
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
          if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qmr.c == 1) && ((this.mSocialFeedInfo.jdField_a_of_type_Int == 9) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 3) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 8)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for gallery card articleinfo = " + toString());
            }
            if (this.mFeedType != 1) {
              break;
            }
            if (this.mSocialFeedInfo.jdField_a_of_type_Qmc == null) {
              this.mSocialFeedInfo.jdField_a_of_type_Qmc = new qmc();
            }
            if ((this.mSocialFeedInfo.jdField_a_of_type_Qmc.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue() != 23))
            {
              this.mSocialFeedInfo.jdField_a_of_type_Qmc.b = new Long(23L);
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu gallery card");
              }
            }
          }
          return;
          if ((this.mSocialFeedInfo.jdField_a_of_type_Qmw.b == 4) && (this.mSocialFeedInfo.jdField_a_of_type_Qmc.b.intValue() != 22))
          {
            this.mSocialFeedInfo.jdField_a_of_type_Qmc.b = Long.valueOf(22L);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu answer card");
              continue;
              if ((this.mFeedType != 1) && (this.mSocialFeedInfo.jdField_a_of_type_Qmw != null)) {
                if ((this.mSocialFeedInfo.jdField_a_of_type_Qmw.b == 3) && (this.mFeedType != 21))
                {
                  this.mFeedType = 21;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for question card");
                  }
                }
                else if ((this.mSocialFeedInfo.jdField_a_of_type_Qmw.b == 4) && (this.mFeedType != 22))
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
      qla localqla = getLazyModel();
      if ((localqla instanceof qnp)) {
        this.mPolymericSmallVideoCoverUrl = ((qnp)localqla).getVideoCoverWithSmartCut(paramInt1, paramInt2);
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
        this.mPolymericSmallVideoCoverUrl = ors.a(ors.a(paramString, paramInt1, paramInt2));
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
  
  public String getWormholeData()
  {
    if (this.wormholeData != null) {
      return this.wormholeData;
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("feeds_type", this.mFeedType).put("feeds_id", this.mFeedId).put("rowkey", this.innerUniqueID).put("article_id", String.valueOf(this.mArticleID)).put("article_title", this.mTitle).put("video_json", this.mJsonVideoList).put("article_content_url", this.mArticleContentUrl).put("comment_count", this.mCommentCount).put("video_comment_count", this.mVideoCommentCount).put("firstpage_pic_url", this.mFirstPagePicUrl).put("video_logo_url", this.mVideoLogoUrl).put("socialize_info", getSocialInfo()).put("bind_json", this.proteusItemsData).put("video_play_count", this.mVideoPlayCount).put("ads_jump_url", this.mVideoAdsJumpUrl).put("ads_jump_type", this.mVideoAdsJumpType).put("ads_source", this.mVideoAdsSource).put("channel_id", this.mChannelID).put("algorithm_id", this.mAlgorithmID).put("strategy_id", this.mStrategyId).put("article_type", this.mArticleType).put("recommend_time", this.mRecommendTime).put("recommend_seq", this.mRecommendSeq).put("article_time", this.mTime).put("article_style", getWormholeId());
      localJSONObject1.put("loadInstance", new JSONObject().put("id", getWormholeId()).put("param", localJSONObject2));
      this.wormholeData = localJSONObject1.toString();
      return this.wormholeData;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ViolaLogUtils.e("Q.readinjoy.BaseArticleInfo", "createDataError: " + localJSONException.getMessage());
      }
    }
  }
  
  public String getWormholeId()
  {
    if (this.wormholeId == null) {
      this.wormholeId = (this.mChannelID + "_" + this.articleStyle + "_" + this.mArticleID);
    }
    return this.wormholeId;
  }
  
  public boolean hasFamilyCommentIcon()
  {
    return (this.familyCommentInfo != null) && (this.familyCommentInfo.a());
  }
  
  public boolean hasOnlyTwoVideoFeeds()
  {
    if ((!ors.a(this)) && (!ors.w(this))) {
      return false;
    }
    if ((this.mSubArtilceList != null) && (this.mSubArtilceList.size() == 1))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.mSubArtilceList.get(0);
      if ((localArticleInfo != null) && ((ors.a(localArticleInfo)) || (ors.w(localArticleInfo)))) {
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
    return ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean)) || (this.mArticleType == 1);
  }
  
  public boolean isSocialFeed()
  {
    return (this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Qme != null);
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
  
  public boolean isWormhole()
  {
    return this.mFeedType == 55;
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
      catch (Exception localException8)
      {
        localException8.printStackTrace();
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
      catch (Exception localException9)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead_mMultiBiuSameListBytes" + QLog.getStackTraceString(localException9));
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
        this.mPolymericInfo = qlo.a(this.mPackInfoObj);
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
              this.multiVideoColumnInfo = qli.a((articlesummary.VideoColumnInfo)localObject1);
              if ((this.mKdLiveInfoBytes != null) && (this.mKdLiveInfoBytes.length > 0)) {
                localObject1 = new articlesummary.KdLiveInfo();
              }
            }
            catch (Exception localInvalidProtocolBufferMicroException4)
            {
              try
              {
                ((articlesummary.KdLiveInfo)localObject1).mergeFrom(this.mKdLiveInfoBytes);
                this.mKdLiveInfo = qlb.a((articlesummary.KdLiveInfo)localObject1);
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
                    this.scripCmsInfo = qlx.a((articlesummary.ScripCmsInfo)localObject1);
                    if ((this.familyCommentInfoByte != null) && (this.familyCommentInfoByte.length > 0)) {
                      localObject1 = new articlesummary.FamilyCommentInfo();
                    }
                  }
                  catch (Exception localInvalidProtocolBufferMicroException4)
                  {
                    try
                    {
                      ((articlesummary.FamilyCommentInfo)localObject1).mergeFrom(this.familyCommentInfoByte);
                      this.familyCommentInfo = qku.a((articlesummary.FamilyCommentInfo)localObject1);
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
                            break label677;
                          }
                        }
                        catch (Exception localException10)
                        {
                          localException10.printStackTrace();
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
                        this.mTopicRecommendFeedsInfo = qnm.a((articlesummary.TopicRecommendFeedsInfo)localObject1);
                        label677:
                        if ((this.mArkAppFeedsInfoBytes != null) && (this.mArkAppFeedsInfoBytes.length > 0)) {
                          localObject1 = new articlesummary.ArkAppFeedsInfo();
                        }
                      }
                      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
                      {
                        label1209:
                        label1752:
                        try
                        {
                          for (;;)
                          {
                            ((articlesummary.ArkAppFeedsInfo)localObject1).mergeFrom(this.mArkAppFeedsInfoBytes);
                            this.mArkAppFeedsInfo = qkf.a((articlesummary.ArkAppFeedsInfo)localObject1);
                            if ((this.mSubArticleListBytes == null) || (this.mSubArticleListBytes.length <= 0)) {
                              break label1209;
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
                                break label1209;
                              }
                            }
                            catch (Exception localException11)
                            {
                              localException11.printStackTrace();
                              this.mSubSummaryListObj = ((PBRepeatMessageField)localObject1).get();
                              if (this.mSubSummaryListObj == null) {
                                break label1209;
                              }
                            }
                            localObject1 = new ArrayList(this.mSubSummaryListObj.size());
                            localObject5 = this.mSubSummaryListObj.iterator();
                            int j;
                            for (int i = 0; ((Iterator)localObject5).hasNext(); i = j)
                            {
                              ArticleInfo localArticleInfo = puy.a((articlesummary.ArticleSummary)((Iterator)localObject5).next(), (int)this.mChannelID, 0, null);
                              ((ArrayList)localObject1).add(localArticleInfo);
                              if ((!QLog.isColorLevel()) || (localArticleInfo == null)) {
                                break label1898;
                              }
                              StringBuilder localStringBuilder = new StringBuilder().append("postRead(): 解析 sub articleSummary【");
                              j = i + 1;
                              QLog.e("Q.readinjoy.BaseArticleInfo", 2, i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + ors.c(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " algorithmID : " + localArticleInfo.mAlgorithmID + " mAlgorithmGroup:" + localArticleInfo.mAlgorithmGroup + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
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
                          }
                          localInvalidProtocolBufferMicroException4 = localInvalidProtocolBufferMicroException4;
                          localInvalidProtocolBufferMicroException4.printStackTrace();
                          this.mTopicRecommendFeedsInfo = null;
                        }
                        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException5)
                        {
                          label1641:
                          label1898:
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
                            Object localObject2;
                            if ((this.mNewPackInfoBytes != null) && (this.mNewPackInfoBytes.length > 0)) {
                              localObject2 = new articlesummary.NewPackInfo();
                            }
                            try
                            {
                              ((articlesummary.NewPackInfo)localObject2).mergeFrom(this.mNewPackInfoBytes);
                              if (localObject2 != null) {
                                this.mNewPolymericInfo = qlj.a((articlesummary.NewPackInfo)localObject2);
                              }
                              if ((this.mRecommendFollowInfoBytes != null) && (this.mRecommendFollowInfoBytes.length > 0)) {
                                localObject2 = new articlesummary.RecommendFollowInfos();
                              }
                            }
                            catch (InvalidProtocolBufferMicroException localException7)
                            {
                              try
                              {
                                ((articlesummary.RecommendFollowInfos)localObject2).mergeFrom(this.mRecommendFollowInfoBytes);
                                if (localObject2 != null) {
                                  this.mRecommendFollowInfos = qlt.a((articlesummary.RecommendFollowInfos)localObject2);
                                }
                                if ((this.hotWordInfoListBytes != null) && (this.hotWordInfoListBytes.length > 0)) {
                                  localObject2 = new articlesummary.HotWordInfo();
                                }
                              }
                              catch (InvalidProtocolBufferMicroException localException7)
                              {
                                try
                                {
                                  ((articlesummary.HotWordInfo)localObject2).mergeFrom(this.hotWordInfoListBytes);
                                  if (localObject2 != null) {
                                    this.hotWordInfo = qky.a((articlesummary.HotWordInfo)localObject2);
                                  }
                                  if ((this.mExtraBiuBriefBytes != null) && (this.mExtraBiuBriefBytes.length > 0)) {
                                    localObject2 = new articlesummary.AggregatedList();
                                  }
                                }
                                catch (InvalidProtocolBufferMicroException localException7)
                                {
                                  try
                                  {
                                    ((articlesummary.AggregatedList)localObject2).mergeFrom(this.mExtraBiuBriefBytes);
                                    if (localObject2 != null) {
                                      this.mExtraBiuBriefInfo = qks.a((articlesummary.AggregatedList)localObject2);
                                    }
                                    handlerFeedsTypeInOldVersionDatabase();
                                    if ((this.bytesBusiData != null) && (this.bytesBusiData.length > 0)) {
                                      this.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
                                    }
                                  }
                                  catch (InvalidProtocolBufferMicroException localException7)
                                  {
                                    try
                                    {
                                      this.mGalleryFeedsInfo.mergeFrom(this.bytesBusiData);
                                      if ((this.mVideoDownloadBarInfoBytes != null) && (this.mVideoDownloadBarInfoBytes.length > 0)) {
                                        this.mVideoDownloadBarInfo = new articlesummary.VideoDownloadBarInfo();
                                      }
                                    }
                                    catch (InvalidProtocolBufferMicroException localException7)
                                    {
                                      try
                                      {
                                        this.mVideoDownloadBarInfo.mergeFrom(this.mVideoDownloadBarInfoBytes);
                                        if ((this.mPartnerAccountInfoBytes != null) && (this.mPartnerAccountInfoBytes.length > 0)) {
                                          this.mPartnerAccountInfo = new articlesummary.PartnerAccountInfo();
                                        }
                                      }
                                      catch (InvalidProtocolBufferMicroException localException7)
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
                                                break label1641;
                                              }
                                            }
                                            catch (Exception localException12)
                                            {
                                              if (QLog.isColorLevel()) {
                                                QLog.e("Q.readinjoy.BaseArticleInfo", 2, "postRead_mMultiBiuSameListBytes" + QLog.getStackTraceString(localException12));
                                              }
                                              this.srtUniversalID = ((PBRepeatMessageField)localObject2).get();
                                            }
                                          }
                                          if (this.mWeishiUGInfo.length > 0) {
                                            this.weishiUGInfo = new articlesummary.WeishiUGInfo();
                                          }
                                        }
                                        catch (Exception localException7)
                                        {
                                          try
                                          {
                                            for (;;)
                                            {
                                              this.weishiUGInfo.mergeFrom(this.mWeishiUGInfo);
                                              qjy.a(this);
                                              if ((this.columnEntrancesBytes != null) && (this.columnEntrancesBytes.length > 0))
                                              {
                                                CodedInputStreamMicro localCodedInputStreamMicro5 = CodedInputStreamMicro.newInstance(this.columnEntrancesBytes);
                                                localObject2 = PBField.initRepeatMessage(articlesummary.VideoColumnInfo.class);
                                                try
                                                {
                                                  while (!localCodedInputStreamMicro5.isAtEnd())
                                                  {
                                                    localCodedInputStreamMicro5.readTag();
                                                    ((PBRepeatMessageField)localObject2).readFrom(localCodedInputStreamMicro5);
                                                  }
                                                  if (this.ptsItemDataBytes == null) {
                                                    break label1752;
                                                  }
                                                }
                                                catch (Exception localException13)
                                                {
                                                  QLog.e("Q.readinjoy.BaseArticleInfo", 1, "", localException13);
                                                  this.columnEntrances = VideoColumnInfo.a((PBRepeatMessageField)localObject2);
                                                }
                                              }
                                              if (this.ptsItemDataBytes.length > 0) {
                                                this.ptsItemData = ((PTSItemData)pww.a(this.ptsItemDataBytes, PTSItemData.CREATOR));
                                              }
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
                                            localException7 = localException7;
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
  
  public void prewrite()
  {
    Object localObject1;
    Object localObject2;
    if ((this.mCommentsObj != null) && (this.mCommentsObj.size() > 0))
    {
      localObject1 = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
      ((PBRepeatMessageField)localObject1).addAll(this.mCommentsObj);
      localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
    }
    CodedOutputStreamMicro localCodedOutputStreamMicro;
    try
    {
      localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
      ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      this.mCommentInfoBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
      if ((this.mMultiBiuSameListObj != null) && (this.mMultiBiuSameListObj.size() > 0))
      {
        localObject1 = PBField.initRepeatMessage(articlesummary.MultiBiuSameContent.class);
        ((PBRepeatMessageField)localObject1).addAll(this.mMultiBiuSameListObj);
        localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
      }
    }
    catch (IOException localIOException4)
    {
      try
      {
        localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
        ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
        localCodedOutputStreamMicro.flush();
        this.mMultiBiuSameListBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
        if (this.mPackInfoObj != null) {
          this.mPackInfoBytes = this.mPackInfoObj.toByteArray();
        }
        if (this.mSubscribeInfoObj != null) {
          this.mSubscribeInfoBytes = this.mSubscribeInfoObj.toByteArray();
        }
        if (this.mSocialFeedInfo != null)
        {
          this.mSocialFeedInfoByte = this.mSocialFeedInfo.a();
          if (this.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
            this.publishUin = this.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
          }
        }
        if (this.mTopicRecommendFeedsInfo != null) {
          this.mTopicRecommendFeedsInfoByte = this.mTopicRecommendFeedsInfo.a().toByteArray();
        }
        if (this.mArkAppFeedsInfo != null)
        {
          localObject1 = this.mArkAppFeedsInfo.a();
          if (localObject1 != null) {
            this.mArkAppFeedsInfoBytes = ((articlesummary.ArkAppFeedsInfo)localObject1).toByteArray();
          }
        }
        if ((this.mLabelListObj != null) && (this.mLabelListObj.size() > 0))
        {
          localObject1 = PBField.initRepeatMessage(articlesummary.ChannelInfo.class);
          ((PBRepeatMessageField)localObject1).addAll(this.mLabelListObj);
          localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
        }
      }
      catch (IOException localIOException4)
      {
        try
        {
          localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
          ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
          localCodedOutputStreamMicro.flush();
          this.mLableListInfoBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
          if ((this.mSubSummaryListObj != null) && (this.mSubSummaryListObj.size() > 0))
          {
            localObject1 = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
            ((PBRepeatMessageField)localObject1).addAll(this.mSubSummaryListObj);
            localObject2 = new ByteArrayOutputStream(((PBRepeatMessageField)localObject1).computeSize(1));
          }
        }
        catch (IOException localIOException4)
        {
          try
          {
            localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
            ((PBRepeatMessageField)localObject1).writeTo(localCodedOutputStreamMicro, 1);
            localCodedOutputStreamMicro.flush();
            this.mSubArticleListBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
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
                if ((this.columnEntrances == null) || (this.columnEntrances.size() <= 0)) {
                  break label823;
                }
                localObject1 = PBField.initRepeatMessage(articlesummary.VideoColumnInfo.class);
                localObject2 = this.columnEntrances.iterator();
                while (((Iterator)localObject2).hasNext()) {
                  ((PBRepeatMessageField)localObject1).add(((VideoColumnInfo)((Iterator)localObject2).next()).a());
                }
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
              localObject2 = new ByteArrayOutputStream(localException.computeSize(1));
            }
          }
        }
      }
    }
    try
    {
      localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance((OutputStream)localObject2);
      localException.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      this.columnEntrancesBytes = ((ByteArrayOutputStream)localObject2).toByteArray();
      label823:
      if (this.ptsItemData != null) {
        this.ptsItemDataBytes = pww.a(this.ptsItemData);
      }
      return;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        QLog.e("Q.readinjoy.BaseArticleInfo", 1, "", localIOException5);
      }
    }
  }
  
  public void setOnVideoCoverInterceptor(qkj paramqkj)
  {
    this.mVideoCoverInterceptor = paramqkj;
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
    localPaint.setTextSize(aekt.a(14.0F, ((QQAppInterface)localObject).getApp().getResources()));
    int i = (int)bdcb.k() - aekt.a(14.0F, ((QQAppInterface)localObject).getApp().getResources()) - (int)localPaint.measureText(paramString);
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
          k = aekt.a(38.0F, ((QQAppInterface)localObject).getApp().getResources()) + k;
          if (i - k > 0) {
            if (TextUtils.isEmpty(paramString))
            {
              paramString = paramString + localRcmd.word.get().toStringUtf8();
              label264:
              int m = aekt.a(14.0F, ((QQAppInterface)localObject).getApp().getResources());
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
      aynt.a(null, new ReportModelDC02528().module("all_result").action("exp_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(this.mArticleContentUrl).ver4(paramString).ver5(this.mTitle).ver6(paramPBRepeatMessageField).session_id(this.mSearchWordSessionId));
      ((amap)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "exp_Kdfeedsback_list", this.mSearchWordSessionId, this.mArticleContentUrl, paramString, this.mTitle, paramPBRepeatMessageField);
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
      return l + "\n, isShowRecommendList= " + this.isShowRecommendList + "\n, isPGCShortContent= " + isPGCShortContent() + "\n, isAccountShown= " + this.isAccountShown + "\n, mSocialFeedInfo= " + this.mSocialFeedInfo + "\n, mExtraBiuLevel= " + qks.a(this) + "\n, mArticleContentUrl= " + this.mArticleContentUrl + "\n, isCardJumpUrlAvailable= " + this.isCardJumpUrlAvailable + "\n, mCardJumpUrl= " + this.mCardJumpUrl + "\n, commentBtnJumpUrl= " + this.commentBtnJumpUrl + "\n, mPartnerAccountInfo= " + getPartnerAccountInfoStr() + "\n, comment_jump_url= " + this.comment_jump_url + "\n, adReportCommonData= " + this.adReportCommonData + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */