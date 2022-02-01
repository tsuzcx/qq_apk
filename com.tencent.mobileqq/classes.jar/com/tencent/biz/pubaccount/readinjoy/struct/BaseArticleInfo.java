package com.tencent.biz.pubaccount.readinjoy.struct;

import andr;
import android.graphics.Paint;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import bbda;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
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
import pay;
import pb.unite.search.RequestSearchWord.Rcmd;
import pof;
import prk;
import prl;
import qlg;
import qlh;
import qoa;
import rbs;
import rch;
import rcj;
import rcl;
import rcm;
import rcv;
import rcx;
import rcy;
import rdb;
import rdd;
import rde;
import rdl;
import rdm;
import rdr;
import rdw;
import rea;
import rep;
import rer;
import rfe;
import rfj;
import rga;
import rgd;
import rgg;
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
import tfp;
import trt;

public class BaseArticleInfo
  extends Entity
  implements rdd
{
  @notColumn
  public static final int ARTICLE_TYPE_NOMAL = 0;
  @notColumn
  public static final int ARTICLE_TYPE_SHORT_CONTENT = 1;
  @notColumn
  private static final String TAG = "Q.readinjoy.BaseArticleInfo";
  public static int TYPE_ARTICLE_BROWSER = 1;
  public static int TYPE_ARTICLE_KANDIAN;
  public static int TYPE_ARTICLE_NOVEL = 2;
  public static int TYPE_FOLLOWED_BUTTON = 2;
  public static int TYPE_UNFOLLOW_BUTTON = 1;
  public String adReportCommonData;
  public String aioShareUrl;
  public int articleStyle;
  @notColumn
  public tfp articleViewModel;
  public String avatar;
  public boolean bindShowFollowButton;
  public int busiType = 1;
  public long businessId;
  public String businessName = "";
  public String businessNamePrefix = "";
  public String businessUrl = "";
  public byte[] bytesBusiData;
  public int clickArea;
  public String clickJumpTarget;
  @notColumn
  public List<VideoColumnInfo> columnEntrances;
  public byte[] columnEntrancesBytes;
  public int columnStyle;
  public String commentBtnJumpUrl;
  public String commentId;
  public String commentJumpUrl;
  public String commentShareUrl;
  public int commentSrc;
  public String content;
  public String dtReportBackendInfo = "";
  public int dtReportContentType = 5;
  @notColumn
  public rcx familyCommentInfo;
  public byte[] familyCommentInfoByte;
  @notColumn
  public int feedsFirstExposurePos = -1;
  @notColumn
  private rcy firstFrameInfo;
  public String galleryReprotExdData;
  public String gifCoverUrl;
  public boolean hasAwesome;
  @notColumn
  public boolean hasBeenInsertIntoList;
  public boolean hasWalletIcon;
  @notColumn
  public boolean hintFlag;
  @notColumn
  public rdb hotWordInfo;
  public byte[] hotWordInfoListBytes;
  public int iconHeight;
  public String iconUrl;
  public int iconWith;
  public String innerUniqueID;
  public String interfaceData;
  public boolean isAccountShown;
  public int isCardJumpUrlAvailable;
  public int isCloseDislike;
  public boolean isColumnAnimationPlay;
  public boolean isExtraBiuExpanded;
  public boolean isForbidReprint;
  @notColumn
  public boolean isNeeaRealExposureFilter;
  @notColumn
  public boolean isNeedShowBtnWhenFollowed;
  @notColumn
  public boolean isPublicAccountFollowed;
  public boolean isShowColumnAnimation;
  public int isShowFollowButton;
  @notColumn
  public boolean isShowFreeNetFlow;
  @notColumn
  public boolean isShowGif;
  @notColumn
  public boolean isShowRecommendList;
  public int isSuperTop;
  public boolean isSuperTopic;
  @notColumn
  public boolean isTwoItem;
  public boolean isUseGif;
  public String jumpUrl;
  @notColumn
  public boolean like;
  public int mAbandonRepeatFlag;
  public int mAccountLess;
  public long mAlgorithmGroup = -1L;
  public long mAlgorithmID = -1L;
  @notColumn
  public rch mArkAppFeedsInfo;
  public byte[] mArkAppFeedsInfoBytes;
  public String mArticleContentUrl = "";
  public String mArticleFriendLikeText;
  public long mArticleID = -1L;
  public String mArticleSubscriptColor;
  public String mArticleSubscriptText;
  public int mArticleType;
  @notColumn
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
  @notColumn
  public List<articlesummary.CommentInfo> mCommentsObj;
  @notColumn
  public int mCurrentX;
  public String mDianDianLabelIconUrl;
  public String mDianDianLabelText;
  public String mDiskLikeInfoString;
  @notColumn
  public ArrayList<DislikeInfo> mDislikeInfos;
  public byte[] mExtraBiuBriefBytes;
  @notColumn
  public rcv mExtraBiuBriefInfo;
  public String mFeedCookie;
  public long mFeedId;
  @notColumn
  public long mFeedIndexInGroup;
  public int mFeedType;
  public String mFirstPagePicUrl = "";
  public String mGWCommonData;
  @notColumn
  public galleryFeeds.GalleryFeedsInfo mGalleryFeedsInfo;
  public int mGalleryPicNumber;
  @notColumn
  public long mGroupCount;
  @notColumn
  public long mGroupId = -1L;
  @notColumn
  public List<BaseArticleInfo> mGroupSubArticleList;
  @notColumn
  public URL mHeaderIconUrl;
  public int mIsDispTimestamp;
  public int mIsGallery;
  @notColumn
  public boolean mIsGalleryChannel;
  @notColumn
  public boolean mIsInPolymeric;
  public boolean mIsPolymericGallery;
  public int mIsShowSearchord;
  public String mJsonPictureList;
  public String mJsonVideoList;
  @notColumn
  public int mJumpType;
  @notColumn
  public rde mKdLiveInfo;
  public byte[] mKdLiveInfoBytes;
  @notColumn
  public List<articlesummary.ChannelInfo> mLabelListObj;
  public byte[] mLableListInfoBytes;
  public long mMergeVideoId;
  @notColumn
  private rdd mModel;
  public byte[] mMultiBiuSameListBytes;
  @notColumn
  public List<articlesummary.MultiBiuSameContent> mMultiBiuSameListObj;
  public byte[] mNewPackInfoBytes;
  @notColumn
  public rdm mNewPolymericInfo;
  public String mOriginalUrl = "";
  public boolean mPUinIsActive = true;
  public byte[] mPackInfoBytes;
  @notColumn
  public articlesummary.PackInfo mPackInfoObj;
  @notColumn
  public articlesummary.PartnerAccountInfo mPartnerAccountInfo;
  public byte[] mPartnerAccountInfoBytes;
  @notColumn
  public URL[] mPictures;
  @notColumn
  public rdr mPolymericInfo;
  @notColumn
  public URL mPolymericSmallVideoCoverUrl;
  @notColumn
  public volatile TemplateBean mProteusTemplateBean;
  public long mRecommendFollowId;
  public byte[] mRecommendFollowInfoBytes;
  @notColumn
  public rdw mRecommendFollowInfos;
  public long mRecommendSeq = -1L;
  public long mRecommendTime = -1L;
  public String mRecommentdReason = "";
  @notColumn
  public String mRefreshTime = "0";
  public String mReportCommonData;
  @notColumn
  public int mResolvedFeedType;
  public String mSearchWordSessionId;
  public String mSearchWordTitle;
  public ArrayList<RequestSearchWord.Rcmd> mSearchWords = new ArrayList();
  public byte[] mServerContext;
  public boolean mShowBigPicture;
  @notColumn
  public VideoColumnInfo mSimpleVideoColumnInfo;
  public byte[] mSimpleVideoColumnInfoBytes;
  @notColumn
  public URL mSinglePicture;
  @notColumn
  public trt mSmallMiniGameInfo;
  @notColumn
  public SocializeFeedsInfo mSocialFeedInfo;
  public byte[] mSocialFeedInfoByte;
  public String mStrCircleId;
  public int mStrategyId;
  public byte[] mSubArticleListBytes;
  @notColumn
  public List<ArticleInfo> mSubArtilceList;
  @notColumn
  public List<articlesummary.ArticleSummary> mSubSummaryListObj;
  public String mSubscribeID = "";
  public byte[] mSubscribeInfoBytes;
  @notColumn
  public articlesummary.SubscribeInfo mSubscribeInfoObj;
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
  public rga mTopicRecommendFeedsInfo;
  public byte[] mTopicRecommendFeedsInfoByte;
  public int mVideoAdsJumpType;
  public String mVideoAdsJumpUrl;
  public int mVideoAdsSource;
  public String mVideoArticleSubsColor;
  public String mVideoArticleSubsText;
  @notColumn
  public VideoColumnInfo mVideoColumnInfo;
  public byte[] mVideoColumnInfoBytes;
  public int mVideoCommentCount;
  @notColumn
  private rcm mVideoCoverInterceptor;
  @notColumn
  public URL mVideoCoverUrl;
  @notColumn
  public articlesummary.VideoDownloadBarInfo mVideoDownloadBarInfo;
  public byte[] mVideoDownloadBarInfoBytes;
  @notColumn
  public int mVideoDuration;
  @notColumn
  public int mVideoJsonHeight;
  @notColumn
  public int mVideoJsonWidth;
  public String mVideoLogoUrl;
  public int mVideoPlayCount;
  public int mVideoType;
  @notColumn
  public String mVideoVid;
  public byte[] mWeishiUGInfo;
  @notColumn
  public long mXGFileSize;
  public String msgBoxBriefContent;
  public String msgBoxBriefPreFix;
  public int msgBoxBriefPreFixType;
  @notColumn
  public ArrayList<MultiBiuSameContent> multiBiuSameContentList;
  @notColumn
  public rdl multiVideoColumnInfo;
  public byte[] multiVideoColumnInfoBytes;
  @notColumn
  public boolean needShowFollwedButton;
  public String nickName;
  public String oldCommentId;
  @notColumn
  public rcj patchStatus = new rcj();
  public String proteusItemsData;
  @notColumn
  public PTSComposer ptsComposer;
  @notColumn
  public PTSItemData ptsItemData;
  public byte[] ptsItemDataBytes;
  public String ptsLitePageName;
  @notColumn
  public boolean ptsRoundCornerCard;
  @notColumn
  public boolean ptsSpecialCard;
  @notColumn
  public PTSComposer.IPTSUpdateDataListener ptsUpdateDataListener = new rcl(this);
  public long publishUin;
  public String qzoneShareUrl;
  public String rawkey;
  @notColumn
  public rea scripCmsInfo;
  public byte[] scripCmsInfoByte;
  public boolean showBreathAnimation;
  public int showFollowButtonType = TYPE_UNFOLLOW_BUTTON;
  @notColumn
  public int showMyFollowText;
  public String smallGameData;
  @notColumn
  public List<articlesummary.SRTUniversalID> srtUniversalID;
  public byte[] srtUniversalIDBytesList;
  public prk strategy;
  public prl strategyCallback;
  public String subscriptBgColor;
  public int subscriptLocation;
  public int subscriptType;
  public String subscriptWording;
  public String subscriptWordingColor;
  public String thirdAction;
  public String thirdIcon;
  public String thirdName;
  @notColumn
  public String thirdUin;
  @notColumn
  public String thirdUinName;
  public long uin;
  public boolean unowned;
  public String vIconUrl;
  public int videoJumpChannelID = -1;
  public String videoJumpChannelName = "";
  public int videoJumpChannelType = -1;
  public String videoReportInfo;
  public String viewRowkey;
  @notColumn
  public pof waterFallPic;
  public String wechatShareUrl;
  @notColumn
  public articlesummary.WeishiUGInfo weishiUGInfo;
  private String wormholeData;
  private String wormholeId;
  
  private void ensureFirstFrameInfoNonNull()
  {
    if (this.firstFrameInfo == null) {
      this.firstFrameInfo = new rcy();
    }
  }
  
  private rdd getLazyModel()
  {
    if (this.mModel == null) {
      this.mModel = rgg.a(this);
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
  
  private void handleFeedsTypeInOldVersionDatabaseForGalleryCard()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rfe.c == 1) && ((this.mSocialFeedInfo.jdField_a_of_type_Int == 9) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 3) || (this.mSocialFeedInfo.jdField_a_of_type_Int == 8)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for gallery card articleinfo = " + toString());
      }
      if (this.mFeedType != 1) {
        break label200;
      }
      if (this.mSocialFeedInfo.jdField_a_of_type_Rep == null) {
        this.mSocialFeedInfo.jdField_a_of_type_Rep = new rep();
      }
      if ((this.mSocialFeedInfo.jdField_a_of_type_Rep.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Rep.b.intValue() != 23))
      {
        this.mSocialFeedInfo.jdField_a_of_type_Rep.b = new Long(23L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu gallery card");
        }
      }
    }
    label200:
    do
    {
      do
      {
        return;
      } while ((this.mFeedType != 6) && (this.mFeedType != 7) && (this.mFeedType != 8) && (this.mFeedType != 9) && (this.mFeedType != 12));
      this.mFeedType = 23;
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for gallery card");
  }
  
  private void handleFeedsTypeInOldVersionDatabaseForNewPolymericInfo()
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
  }
  
  private void handleFeedsTypeInOldVersionDatabaseForQACard()
  {
    if ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rfn != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "rewrite feedstype for wenda article articleinfo = " + toString());
      }
      if ((this.mFeedType != 1) || (this.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (this.mSocialFeedInfo.jdField_a_of_type_Rep.b == null) || (this.mSocialFeedInfo.jdField_a_of_type_Rfj == null)) {
        break label221;
      }
      if ((this.mSocialFeedInfo.jdField_a_of_type_Rfj.b != 3) || (this.mSocialFeedInfo.jdField_a_of_type_Rep.b.intValue() == 21)) {
        break label157;
      }
      this.mSocialFeedInfo.jdField_a_of_type_Rep.b = Long.valueOf(21L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu question card");
      }
    }
    label156:
    label157:
    label221:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label156;
              break label156;
              break label156;
              do
              {
                return;
              } while ((this.mSocialFeedInfo.jdField_a_of_type_Rfj.b != 4) || (this.mSocialFeedInfo.jdField_a_of_type_Rep.b.intValue() == 22));
              this.mSocialFeedInfo.jdField_a_of_type_Rep.b = Long.valueOf(22L);
            } while (!QLog.isColorLevel());
            QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for biu answer card");
            return;
          } while ((this.mFeedType == 1) || (this.mSocialFeedInfo.jdField_a_of_type_Rfj == null));
          if ((this.mSocialFeedInfo.jdField_a_of_type_Rfj.b != 3) || (this.mFeedType == 21)) {
            break;
          }
          this.mFeedType = 21;
        } while (!QLog.isColorLevel());
        QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for question card");
        return;
      } while ((this.mSocialFeedInfo.jdField_a_of_type_Rfj.b != 4) || (this.mFeedType == 22));
      this.mFeedType = 22;
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.BaseArticleInfo", 2, "real rewrite feedstype for answer card");
  }
  
  private void handlePBValueFromStream1()
  {
    this.mCommentsObj = qlg.a(this.mCommentInfoBytes, articlesummary.CommentInfo.class);
    this.mMultiBiuSameListObj = qlg.a(this.mMultiBiuSameListBytes, articlesummary.MultiBiuSameContent.class);
    if (this.mMultiBiuSameListObj != null) {
      this.multiBiuSameContentList = MultiBiuSameContent.a(this.mMultiBiuSameListObj);
    }
    this.mPackInfoObj = ((articlesummary.PackInfo)qlg.a(this.mPackInfoBytes, new articlesummary.PackInfo()));
    if (this.mPackInfoObj != null)
    {
      this.mGroupId = qlg.a(this.mPackInfoObj.uint64_pack_id);
      this.mPolymericInfo = rdr.a(this.mPackInfoObj);
    }
    this.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)qlg.a(this.mSubscribeInfoBytes, new articlesummary.SubscribeInfo()));
    Object localObject = (articlesummary.SocializeFeedsInfo)qlg.a(this.mSocialFeedInfoByte, new articlesummary.SocializeFeedsInfo());
    if (localObject != null) {
      this.mSocialFeedInfo = SocializeFeedsInfo.a((articlesummary.SocializeFeedsInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)qlg.a(this.mVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.mVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)qlg.a(this.multiVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.multiVideoColumnInfo = rdl.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.KdLiveInfo)qlg.a(this.mKdLiveInfoBytes, new articlesummary.KdLiveInfo());
    if (localObject != null) {
      this.mKdLiveInfo = rde.a((articlesummary.KdLiveInfo)localObject);
    }
    localObject = (articlesummary.VideoColumnInfo)qlg.a(this.mSimpleVideoColumnInfoBytes, new articlesummary.VideoColumnInfo());
    if (localObject != null) {
      this.mSimpleVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)localObject);
    }
    localObject = (articlesummary.ScripCmsInfo)qlg.a(this.scripCmsInfoByte, new articlesummary.ScripCmsInfo());
    if (localObject != null) {
      this.scripCmsInfo = rea.a((articlesummary.ScripCmsInfo)localObject);
    }
    localObject = (articlesummary.FamilyCommentInfo)qlg.a(this.familyCommentInfoByte, new articlesummary.FamilyCommentInfo());
    if (localObject != null) {
      this.familyCommentInfo = rcx.a((articlesummary.FamilyCommentInfo)localObject);
    }
  }
  
  private void handlePBValueFromStream2()
  {
    this.mLabelListObj = qlg.a(this.mLableListInfoBytes, articlesummary.ChannelInfo.class);
    Object localObject = (articlesummary.TopicRecommendFeedsInfo)qlg.a(this.mTopicRecommendFeedsInfoByte, new articlesummary.TopicRecommendFeedsInfo());
    if (localObject != null) {
      this.mTopicRecommendFeedsInfo = rga.a((articlesummary.TopicRecommendFeedsInfo)localObject);
    }
    localObject = (articlesummary.ArkAppFeedsInfo)qlg.a(this.mArkAppFeedsInfoBytes, new articlesummary.ArkAppFeedsInfo());
    if (localObject != null) {
      this.mArkAppFeedsInfo = rch.a((articlesummary.ArkAppFeedsInfo)localObject);
    }
    this.mSubSummaryListObj = qlg.a(this.mSubArticleListBytes, articlesummary.ArticleSummary.class);
    if ((this.mSubSummaryListObj != null) && (this.mSubSummaryListObj.size() > 0))
    {
      localObject = new ArrayList(this.mSubSummaryListObj.size());
      Iterator localIterator = this.mSubSummaryListObj.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(qlh.a((articlesummary.ArticleSummary)localIterator.next(), (int)this.mChannelID, 0, null));
      }
      this.mSubArtilceList = ((List)localObject);
    }
    localObject = (articlesummary.NewPackInfo)qlg.a(this.mNewPackInfoBytes, new articlesummary.NewPackInfo());
    if (localObject != null) {
      this.mNewPolymericInfo = rdm.a((articlesummary.NewPackInfo)localObject);
    }
    localObject = (articlesummary.RecommendFollowInfos)qlg.a(this.mRecommendFollowInfoBytes, new articlesummary.RecommendFollowInfos());
    if (localObject != null) {
      this.mRecommendFollowInfos = rdw.a((articlesummary.RecommendFollowInfos)localObject);
    }
    localObject = (articlesummary.HotWordInfo)qlg.a(this.hotWordInfoListBytes, new articlesummary.HotWordInfo());
    if (localObject != null) {
      this.hotWordInfo = rdb.a((articlesummary.HotWordInfo)localObject);
    }
    localObject = (articlesummary.AggregatedList)qlg.a(this.mExtraBiuBriefBytes, new articlesummary.AggregatedList());
    if (localObject != null) {
      this.mExtraBiuBriefInfo = rcv.a((articlesummary.AggregatedList)localObject);
    }
    handlerFeedsTypeInOldVersionDatabase();
    this.mGalleryFeedsInfo = ((galleryFeeds.GalleryFeedsInfo)qlg.a(this.bytesBusiData, new galleryFeeds.GalleryFeedsInfo()));
    this.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)qlg.a(this.mVideoDownloadBarInfoBytes, new articlesummary.VideoDownloadBarInfo()));
    this.mPartnerAccountInfo = ((articlesummary.PartnerAccountInfo)qlg.a(this.mPartnerAccountInfoBytes, new articlesummary.PartnerAccountInfo()));
    this.srtUniversalID = qlg.a(this.srtUniversalIDBytesList, articlesummary.SRTUniversalID.class);
    this.weishiUGInfo = ((articlesummary.WeishiUGInfo)qlg.a(this.mWeishiUGInfo, new articlesummary.WeishiUGInfo()));
    rbs.a(this);
  }
  
  public String getCardJumpUrl()
  {
    return this.mCardJumpUrl;
  }
  
  public int getCommentCount()
  {
    return getLazyModel().getCommentCount();
  }
  
  public int getFirstFrameHeight()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.b();
  }
  
  public URL getFirstFrameUrl()
  {
    ensureFirstFrameInfoNonNull();
    URL localURL = this.firstFrameInfo.a();
    if (localURL != null) {
      return localURL;
    }
    return getVideoCoverURL();
  }
  
  public int getFirstFrameWidth()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.a();
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
      rdd localrdd = getLazyModel();
      if ((localrdd instanceof rgd)) {
        this.mPolymericSmallVideoCoverUrl = ((rgd)localrdd).getVideoCoverWithSmartCut(paramInt1, paramInt2);
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
        this.mPolymericSmallVideoCoverUrl = pay.a(pay.a(paramString, paramInt1, paramInt2));
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
  
  @VisibleForTesting
  void handlerFeedsTypeInOldVersionDatabase()
  {
    handleFeedsTypeInOldVersionDatabaseForQACard();
    handleFeedsTypeInOldVersionDatabaseForNewPolymericInfo();
    handleFeedsTypeInOldVersionDatabaseForGalleryCard();
  }
  
  public boolean hasFamilyCommentIcon()
  {
    return (this.familyCommentInfo != null) && (this.familyCommentInfo.a());
  }
  
  public boolean hasFirstFramePreload()
  {
    ensureFirstFrameInfoNonNull();
    return this.firstFrameInfo.a();
  }
  
  public boolean hasOnlyTwoVideoFeeds()
  {
    if ((!pay.a(this)) && (!pay.w(this))) {}
    while ((this.mSubArtilceList == null) || (this.mSubArtilceList.size() != 1)) {
      return false;
    }
    ArticleInfo localArticleInfo = (ArticleInfo)this.mSubArtilceList.get(0);
    if ((localArticleInfo != null) && ((pay.a(localArticleInfo)) || (pay.w(localArticleInfo)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    return ((this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Boolean)) || (this.mArticleType == 1);
  }
  
  public boolean isSocialFeed()
  {
    return (this.mSocialFeedInfo != null) && (this.mSocialFeedInfo.jdField_a_of_type_Rer != null);
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
    handlePBValueFromStream1();
    handlePBValueFromStream2();
    PBRepeatMessageField localPBRepeatMessageField = qlg.a(this.columnEntrancesBytes, articlesummary.VideoColumnInfo.class);
    if (localPBRepeatMessageField != null) {
      this.columnEntrances = VideoColumnInfo.a(localPBRepeatMessageField);
    }
    if ((this.ptsItemDataBytes != null) && (this.ptsItemDataBytes.length > 0)) {
      this.ptsItemData = ((PTSItemData)qoa.a(this.ptsItemDataBytes, PTSItemData.CREATOR));
    }
    if (!TextUtils.isEmpty(this.smallGameData)) {
      this.mSmallMiniGameInfo = trt.a(this.smallGameData);
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
          if (this.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
            this.publishUin = this.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
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
        this.ptsItemDataBytes = qoa.a(this.ptsItemData);
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
  
  public void setFirstFrameHeight(int paramInt)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.b(paramInt);
  }
  
  public void setFirstFrameUrl(URL paramURL)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramURL);
  }
  
  public void setFirstFrameWidth(int paramInt)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramInt);
  }
  
  public void setHasFirstFramePreload(boolean paramBoolean)
  {
    ensureFirstFrameInfoNonNull();
    this.firstFrameInfo.a(paramBoolean);
  }
  
  public void setOnVideoCoverInterceptor(rcm paramrcm)
  {
    this.mVideoCoverInterceptor = paramrcm;
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
    localPaint.setTextSize(AIOUtils.dp2px(14.0F, ((QQAppInterface)localObject).getApp().getResources()));
    int i = (int)DeviceInfoUtil.getWidth() - AIOUtils.dp2px(14.0F, ((QQAppInterface)localObject).getApp().getResources()) - (int)localPaint.measureText(paramString);
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
          k = AIOUtils.dp2px(38.0F, ((QQAppInterface)localObject).getApp().getResources()) + k;
          if (i - k > 0) {
            if (TextUtils.isEmpty(paramString))
            {
              paramString = paramString + localRcmd.word.get().toStringUtf8();
              label264:
              int m = AIOUtils.dp2px(14.0F, ((QQAppInterface)localObject).getApp().getResources());
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
      bbda.a(null, new ReportModelDC02528().module("all_result").action("exp_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(this.mArticleContentUrl).ver4(paramString).ver5(this.mTitle).ver6(paramPBRepeatMessageField).session_id(this.mSearchWordSessionId));
      ((andr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(111)).a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "exp_Kdfeedsback_list", this.mSearchWordSessionId, this.mArticleContentUrl, paramString, this.mTitle, paramPBRepeatMessageField);
      return;
    }
  }
  
  public String toProteusOnlineString()
  {
    return "ProteusOnlineArticleInfo = {\nmArticleID = " + this.mArticleID + ", \nmArticleContentUrl = " + this.mArticleContentUrl + ", \nmRecommendSeq = " + this.mRecommendSeq + ", \nmTitle = " + this.mTitle + "\nmFeedsType = " + this.mFeedType + "\nmRowKey = " + this.innerUniqueID + "\nmFirstPagePicUrl = " + this.mFirstPagePicUrl + "\nmJsonPictureList = " + this.mJsonPictureList + "\nmJsonVideoList = " + this.mJsonVideoList + "\nproteusItemData = " + this.proteusItemsData + "\nmNewPolymericInfo = " + this.mNewPolymericInfo + "\n}";
  }
  
  public String toSString()
  {
    return "BaseArticleInfo{mArticleID=" + this.mArticleID + ", mTitle='" + this.mTitle + '\'' + ", mSummary='" + this.mSummary + '\'' + ", mFirstPagePicUrl='" + this.mFirstPagePicUrl + '\'' + ", mOriginalUrl='" + this.mOriginalUrl + '\'' + ", mArticleContentUrl='" + this.mArticleContentUrl + '\'' + ", mTime=" + this.mTime + ", mCommentCount=" + this.mCommentCount + ", mCommentShareUrl=" + this.commentShareUrl + ", mSubscribeID='" + this.mSubscribeID + '\'' + ", mSubscribeName='" + this.mSubscribeName + '\'' + ", mRecommendTime=" + this.mRecommendTime + ", mChannelID=" + this.mChannelID + ", mRecommendSeq=" + this.mRecommendSeq + ", mShowBigPicture=" + this.mShowBigPicture + ", mAlgorithmID=" + this.mAlgorithmID + ", mAlgorithmGroup=" + this.mAlgorithmGroup + ", mRecommentdReason='" + this.mRecommentdReason + '\'' + ", mJsonVideoList='" + this.mJsonVideoList + '\'' + ", mJsonPictureList='" + this.mJsonPictureList + '\'' + ", mAbandonRepeatFlag=" + this.mAbandonRepeatFlag + ", mArticleSubscriptText='" + this.mArticleSubscriptText + '\'' + ", mArticleSubscriptColor='" + this.mArticleSubscriptColor + '\'' + ", mArticleFriendLikeText='" + this.mArticleFriendLikeText + '\'' + ", mStrategyId=" + this.mStrategyId + ", mTopicPicWHRatio=" + this.mTopicPicWHRatio + ", mTopicPicInfo='" + this.mTopicPicInfo + '\'' + ", thirdIcon='" + this.thirdIcon + '\'' + ", thirdName='" + this.thirdName + '\'' + ", thirdAction='" + this.thirdAction + '\'' + ", busiType=" + this.busiType + ", innerUniqueID='" + this.innerUniqueID + '\'' + ", mVideoType=" + this.mVideoType + ", mChannelInfoId=" + this.mChannelInfoId + ", mChannelInfoName='" + this.mChannelInfoName + '\'' + ", mChannelInfoType=" + this.mChannelInfoType + ", mChannelInfoDisplayName='" + this.mChannelInfoDisplayName + '\'' + ", mCommentIconType=" + this.mCommentIconType + ", mServerContext=" + Arrays.toString(this.mServerContext) + ", mDiskLikeInfoString='" + this.mDiskLikeInfoString + '\'' + ", mSocialFeedInfoByte=" + Arrays.toString(this.mSocialFeedInfoByte) + ", mTopicRecommendFeedsInfoByte=" + Arrays.toString(this.mTopicRecommendFeedsInfoByte) + ", mFeedId=" + this.mFeedId + ", mFeedType=" + this.mFeedType + ", mCircleId=" + this.mCircleId + ", mStrCircleId='" + this.mStrCircleId + '\'' + ", mPUinIsActive=" + this.mPUinIsActive + ", mIsDispTimestamp=" + this.mIsDispTimestamp + ", mIsGallery=" + this.mIsGallery + ", mGalleryPicNumber=" + this.mGalleryPicNumber + ", mCommentInfoBytes=" + Arrays.toString(this.mCommentInfoBytes) + ", mPackInfoBytes=" + Arrays.toString(this.mPackInfoBytes) + ", mSubscribeInfoBytes=" + Arrays.toString(this.mSubscribeInfoBytes) + ", mVideoPlayCount=" + this.mVideoPlayCount + ", mLableListInfoBytes=" + Arrays.toString(this.mLableListInfoBytes) + ", videoJumpChannelID=" + this.videoJumpChannelID + ", videoJumpChannelType=" + this.videoJumpChannelType + ", videoJumpChannelName='" + this.videoJumpChannelName + '\'' + ", businessId=" + this.businessId + ", businessName='" + this.businessName + '\'' + ", businessUrl='" + this.businessUrl + '\'' + ", businessNamePrefix='" + this.businessNamePrefix + '\'' + ", mAccountLess=" + this.mAccountLess + ", publishUin=" + this.publishUin + ", interfaceData='" + this.interfaceData + '\'' + ", galleryReprotExdData='" + this.galleryReprotExdData + '\'' + ", articleStyle=" + this.articleStyle + ", proteusItemsData='" + this.proteusItemsData + '\'' + ", mArkAppFeedsInfo=" + this.mArkAppFeedsInfo + ", mArkAppFeedsInfoBytes=" + Arrays.toString(this.mArkAppFeedsInfoBytes) + ", mDislikeInfos=" + this.mDislikeInfos + ", like=" + this.like + ", mPictures=" + Arrays.toString(this.mPictures) + ", mSinglePicture=" + this.mSinglePicture + ", mVideoCoverUrl=" + this.mVideoCoverUrl + ", mVideoVid='" + this.mVideoVid + '\'' + ", mVideoDuration=" + this.mVideoDuration + ", mVideoJsonWidth=" + this.mVideoJsonWidth + ", mVideoJsonHeight=" + this.mVideoJsonHeight + ", mXGFileSize=" + this.mXGFileSize + ", mThirdVideoURL='" + this.mThirdVideoURL + '\'' + ", mThirdVideoURLExpireTime=" + this.mThirdVideoURLExpireTime + ", thirdUin='" + this.thirdUin + '\'' + ", thirdUinName='" + this.thirdUinName + '\'' + ", mCommentsObj=" + this.mCommentsObj + ", mPackInfoObj=" + this.mPackInfoObj + ", mPolymericInfo=" + this.mPolymericInfo + ", mIsInPolymeric=" + this.mIsInPolymeric + ", mSubscribeInfoObj=" + this.mSubscribeInfoObj + ", mGroupId=" + this.mGroupId + ", mGroupCount=" + this.mGroupCount + ", mFeedIndexInGroup=" + this.mFeedIndexInGroup + ", mHeaderIconUrl=" + this.mHeaderIconUrl + ", mSocialFeedInfo=" + this.mSocialFeedInfo + ", mLabelListObj=" + this.mLabelListObj + ", mTopicRecommendFeedsInfo=" + this.mTopicRecommendFeedsInfo + ", isNeedShowBtnWhenFollowed=" + this.isNeedShowBtnWhenFollowed + ", feedsFirstExposurePos=" + this.feedsFirstExposurePos + ", mSubArticleListBytes=" + Arrays.toString(this.mSubArticleListBytes) + ", mSubSummaryListObj=" + this.mSubSummaryListObj + ", mSubArtilceList=" + this.mSubArtilceList + ", mMergeVideoId=" + this.mMergeVideoId + ", mGroupSubArticleList=" + this.mGroupSubArticleList + ", mVideoCommentCount=" + this.mVideoCommentCount + ", mProteusTemplateBean=" + this.mProteusTemplateBean + ", mVideoArticleSubsText='" + this.mVideoArticleSubsText + '\'' + ", mVideoArticleSubsColor='" + this.mVideoArticleSubsColor + '\'' + ", mVideoAdsJumpUrl='" + this.mVideoAdsJumpUrl + '\'' + ", mVideoAdsJumpType=" + this.mVideoAdsJumpType + ", mVideoAdsSource=" + this.mVideoAdsSource + ", mVideoLogoUrl=" + this.mVideoLogoUrl + '}';
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BaseArticleInfo{mArticleID=").append(this.mArticleID).append("\n, mRecommendSeq=").append(this.mRecommendSeq).append("\n, mTitle=").append(this.mTitle).append("\n, mSummary=").append(this.mSummary).append("\n, mPUinIsActive=").append(this.mPUinIsActive).append("\n, mFeedType=").append(this.mFeedType).append("\n, mResolvedFeedType=").append(this.mResolvedFeedType).append("\n, mRowKey=").append(this.innerUniqueID).append("\n, icon_url=").append(this.iconUrl).append("\n, icon_with=").append(this.iconWith).append("\n, icon_height=").append(this.iconHeight).append("\n, uin=").append(this.uin).append("\n, nick_name=").append(this.nickName).append("\n, comment_id=").append(this.oldCommentId).append("\n, content=").append(this.content).append("\n, jump_url=").append(this.jumpUrl).append("\n, isUseGif=").append(this.isUseGif).append("\n, mFirstPagePicUrl= ").append(this.mFirstPagePicUrl).append("\n, mJsonPictureList= ").append(this.mJsonPictureList).append("\n, mJsonVideoList= ").append(this.mJsonVideoList).append("\n, proteusItemsData= ").append(this.proteusItemsData).append("\n, mNewPolymericInfo= ").append(this.mNewPolymericInfo).append("\n, mFeedId=");
    if (this.mSocialFeedInfo != null) {}
    for (long l = this.mSocialFeedInfo.jdField_a_of_type_Long;; l = 0L) {
      return l + "\n, isShowRecommendList= " + this.isShowRecommendList + "\n, isPGCShortContent= " + isPGCShortContent() + "\n, isAccountShown= " + this.isAccountShown + "\n, mSocialFeedInfo= " + this.mSocialFeedInfo + "\n, mExtraBiuLevel= " + rcv.a(this) + "\n, mArticleContentUrl= " + this.mArticleContentUrl + "\n, isCardJumpUrlAvailable= " + this.isCardJumpUrlAvailable + "\n, mCardJumpUrl= " + this.mCardJumpUrl + "\n, commentBtnJumpUrl= " + this.commentBtnJumpUrl + "\n, mPartnerAccountInfo= " + getPartnerAccountInfoStr() + "\n, comment_jump_url= " + this.commentJumpUrl + "\n, adReportCommonData= " + this.adReportCommonData + "\n, isForbidReprint=" + this.isForbidReprint + "\n, isShowFollowButton=" + this.isShowFollowButton + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo
 * JD-Core Version:    0.7.0.1
 */