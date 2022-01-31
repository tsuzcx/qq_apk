package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import obz;
import por;
import pos;
import ppa;
import ppz;
import pqo;
import prv;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

public class ArticleInfo
  extends BaseArticleInfo
  implements Parcelable, Cloneable, Comparable<ArticleInfo>
{
  public static final Parcelable.Creator<ArticleInfo> CREATOR = makeArticleInfoCreator();
  public static final long SUBSCRIBE_ARTICLE_ID = -3L;
  public static final long SUBSCRIBE_RECOMMEND_SEQ = -3L;
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public static final String TAG = "ArticleInfo";
  public static final long TOPIC_ARTICLE_ID = -2L;
  public static final long TOPIC_RECOMMEND_SEQ = -2L;
  public int recommentFlag;
  
  public ArticleInfo() {}
  
  public ArticleInfo(Parcel paramParcel)
  {
    readFromParcel(this, paramParcel);
  }
  
  public static Parcelable.Creator<ArticleInfo> makeArticleInfoCreator()
  {
    return new pos();
  }
  
  private void readFromParcel(ArticleInfo paramArticleInfo, Parcel paramParcel)
  {
    boolean bool2 = true;
    paramArticleInfo.mArticleID = paramParcel.readLong();
    paramArticleInfo.mTitle = paramParcel.readString();
    paramArticleInfo.mSummary = paramParcel.readString();
    paramArticleInfo.mFirstPagePicUrl = paramParcel.readString();
    paramArticleInfo.mOriginalUrl = paramParcel.readString();
    paramArticleInfo.mArticleContentUrl = paramParcel.readString();
    paramArticleInfo.mTime = paramParcel.readLong();
    paramArticleInfo.mCommentCount = paramParcel.readLong();
    paramArticleInfo.mSubscribeID = paramParcel.readString();
    paramArticleInfo.mSubscribeName = paramParcel.readString();
    paramArticleInfo.mRecommendTime = paramParcel.readLong();
    paramArticleInfo.mChannelID = paramParcel.readLong();
    paramArticleInfo.mRecommendSeq = paramParcel.readLong();
    if (paramParcel.readByte() == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      paramArticleInfo.mShowBigPicture = bool1;
      paramArticleInfo.mStrategyId = paramParcel.readInt();
      paramArticleInfo.articleStyle = paramParcel.readInt();
      paramArticleInfo.interfaceData = paramParcel.readString();
      paramArticleInfo.galleryReprotExdData = paramParcel.readString();
      paramArticleInfo.mAlgorithmID = paramParcel.readLong();
      paramArticleInfo.mArticleFriendLikeText = paramParcel.readString();
      paramArticleInfo.mTopicPicWHRatio = paramParcel.readDouble();
      paramArticleInfo.mTopicPicInfo = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      paramArticleInfo.mPictures = new URL[j];
      i = 0;
      while (i < j)
      {
        paramArticleInfo.mPictures[i] = obz.a(paramParcel.readString());
        i += 1;
      }
    }
    paramArticleInfo.mSinglePicture = obz.a(paramParcel.readString());
    paramArticleInfo.mVideoCoverUrl = obz.a(paramParcel.readString());
    paramArticleInfo.mVideoVid = paramParcel.readString();
    paramArticleInfo.mVideoDuration = paramParcel.readInt();
    paramArticleInfo.mCommentIconType = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramArticleInfo.mServerContext = null;
      i = paramParcel.readInt();
      if (i != -1) {
        break label791;
      }
      paramArticleInfo.mCommentInfoBytes = null;
      label317:
      i = paramParcel.readInt();
      if (i != -1) {
        break label813;
      }
      paramArticleInfo.mPackInfoBytes = null;
      label332:
      paramArticleInfo.postRead();
      paramArticleInfo.mCircleId = paramParcel.readLong();
      paramArticleInfo.mStrCircleId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label835;
      }
      bool1 = true;
      label362:
      paramArticleInfo.mPUinIsActive = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label841;
      }
      paramArticleInfo.mSubscribeInfoBytes = null;
      label383:
      paramArticleInfo.mFeedType = paramParcel.readInt();
      paramArticleInfo.mFeedId = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i > 0) {
        break label863;
      }
      paramArticleInfo.mSocialFeedInfoByte = null;
      label413:
      paramArticleInfo.innerUniqueID = paramParcel.readString();
      paramArticleInfo.businessId = paramParcel.readLong();
      paramArticleInfo.businessName = paramParcel.readString();
      paramArticleInfo.businessUrl = paramParcel.readString();
      paramArticleInfo.businessNamePrefix = paramParcel.readString();
      i = paramParcel.readInt();
      if (i > 0) {
        break label930;
      }
      paramArticleInfo.mTopicRecommendFeedsInfoByte = null;
      label467:
      i = paramParcel.readInt();
      if (i > 0) {
        break label997;
      }
      paramArticleInfo.mArkAppFeedsInfoBytes = null;
      label481:
      paramArticleInfo.publishUin = paramParcel.readLong();
      paramArticleInfo.mMergeVideoId = paramParcel.readLong();
      paramArticleInfo.mVideoCommentCount = paramParcel.readInt();
      paramArticleInfo.proteusItemsData = paramParcel.readString();
      paramArticleInfo.mAccountLess = paramParcel.readInt();
      paramArticleInfo.mVideoArticleSubsText = paramParcel.readString();
      paramArticleInfo.mVideoArticleSubsColor = paramParcel.readString();
      paramArticleInfo.mVideoAdsJumpUrl = paramParcel.readString();
      paramArticleInfo.mVideoAdsJumpType = paramParcel.readInt();
      paramArticleInfo.mVideoAdsSource = paramParcel.readInt();
      paramArticleInfo.videoReportInfo = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label1073;
      }
      bool1 = true;
      label580:
      paramArticleInfo.isTwoItem = bool1;
      if (paramParcel.readByte() != 1) {
        break label1079;
      }
      bool1 = true;
      label597:
      paramArticleInfo.isSuperTopic = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1085;
      }
      paramArticleInfo.mNewPackInfoBytes = null;
      label618:
      i = paramParcel.readInt();
      if (i > 0) {
        break label1107;
      }
      paramArticleInfo.mRecommendFollowInfoBytes = null;
      label632:
      paramArticleInfo.mRecommendFollowId = paramParcel.readLong();
      paramArticleInfo.gifCoverUrl = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label1125;
      }
      bool1 = true;
      label659:
      paramArticleInfo.isUseGif = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1131;
      }
      paramArticleInfo.mExtraBiuBriefBytes = null;
      label680:
      i = paramParcel.readInt();
      if (i != -1) {
        break label1153;
      }
      paramArticleInfo.mMultiBiuSameListBytes = null;
      label695:
      paramArticleInfo.mIsGallery = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label1175;
      }
      bool1 = bool2;
      label715:
      paramArticleInfo.mIsGalleryChannel = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1181;
      }
      paramArticleInfo.hotWordInfoListBytes = null;
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            this.busiType = paramParcel.readInt();
            paramArticleInfo.mGWCommonData = paramParcel.readString();
            paramArticleInfo.mReportCommonData = paramParcel.readString();
            paramArticleInfo.recommentFlag = paramParcel.readInt();
            return;
            paramArticleInfo.mServerContext = new byte[i];
            if (i <= 0) {
              break;
            }
            paramParcel.readByteArray(paramArticleInfo.mServerContext);
            break;
            label791:
            paramArticleInfo.mCommentInfoBytes = new byte[i];
            if (i <= 0) {
              break label317;
            }
            paramParcel.readByteArray(paramArticleInfo.mCommentInfoBytes);
            break label317;
            label813:
            paramArticleInfo.mPackInfoBytes = new byte[i];
            if (i <= 0) {
              break label332;
            }
            paramParcel.readByteArray(paramArticleInfo.mPackInfoBytes);
            break label332;
            label835:
            bool1 = false;
            break label362;
            label841:
            paramArticleInfo.mSubscribeInfoBytes = new byte[i];
            if (i <= 0) {
              break label383;
            }
            paramParcel.readByteArray(paramArticleInfo.mSubscribeInfoBytes);
            break label383;
            label863:
            paramArticleInfo.mSocialFeedInfoByte = new byte[i];
            paramParcel.readByteArray(paramArticleInfo.mSocialFeedInfoByte);
            articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
            try
            {
              localSocializeFeedsInfo.mergeFrom(paramArticleInfo.mSocialFeedInfoByte);
              paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a(localSocializeFeedsInfo);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
            {
              QLog.e("ArticleInfo", 1, "createFromParcel: ", localInvalidProtocolBufferMicroException1);
              paramArticleInfo.mSocialFeedInfo = null;
            }
          }
          break label413;
          label930:
          paramArticleInfo.mTopicRecommendFeedsInfoByte = new byte[i];
          paramParcel.readByteArray(paramArticleInfo.mTopicRecommendFeedsInfoByte);
          articlesummary.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new articlesummary.TopicRecommendFeedsInfo();
          try
          {
            localTopicRecommendFeedsInfo.mergeFrom(paramArticleInfo.mTopicRecommendFeedsInfoByte);
            paramArticleInfo.mTopicRecommendFeedsInfo = prv.a(localTopicRecommendFeedsInfo);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            QLog.e("ArticleInfo", 1, "createFromParcel: ", localInvalidProtocolBufferMicroException2);
            paramArticleInfo.mSocialFeedInfo = null;
          }
        }
        break label467;
        label997:
        paramArticleInfo.mArkAppFeedsInfoBytes = new byte[i];
        paramParcel.readByteArray(paramArticleInfo.mArkAppFeedsInfoBytes);
        articlesummary.ArkAppFeedsInfo localArkAppFeedsInfo = new articlesummary.ArkAppFeedsInfo();
        try
        {
          localArkAppFeedsInfo.mergeFrom(paramArticleInfo.mArkAppFeedsInfoBytes);
          paramArticleInfo.mArkAppFeedsInfo = por.a(localArkAppFeedsInfo);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
        {
          localInvalidProtocolBufferMicroException3.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfo", 2, "convertPBToInfo arkAppFeedsInfo failed.");
          }
          paramArticleInfo.mArkAppFeedsInfo = null;
        }
      }
      break label481;
      label1073:
      bool1 = false;
      break label580;
      label1079:
      bool1 = false;
      break label597;
      label1085:
      paramArticleInfo.mNewPackInfoBytes = new byte[i];
      if (i <= 0) {
        break label618;
      }
      paramParcel.readByteArray(paramArticleInfo.mNewPackInfoBytes);
      break label618;
      label1107:
      paramArticleInfo.mRecommendFollowInfoBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mRecommendFollowInfoBytes);
      break label632;
      label1125:
      bool1 = false;
      break label659;
      label1131:
      if (i <= 0) {
        break label680;
      }
      paramArticleInfo.mExtraBiuBriefBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mExtraBiuBriefBytes);
      break label680;
      label1153:
      if (i <= 0) {
        break label695;
      }
      paramArticleInfo.mMultiBiuSameListBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mMultiBiuSameListBytes);
      break label695;
      label1175:
      bool1 = false;
      break label715;
      label1181:
      if (i > 0)
      {
        paramArticleInfo.hotWordInfoListBytes = new byte[i];
        paramParcel.readByteArray(paramArticleInfo.hotWordInfoListBytes);
      }
    }
  }
  
  public ArticleInfo clone()
  {
    try
    {
      ArticleInfo localArticleInfo = (ArticleInfo)super.clone();
      return localArticleInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfo", 2, "ArticleInfo CloneNotSupportedException e= " + localCloneNotSupportedException);
      }
    }
    return null;
  }
  
  public int compareTo(ArticleInfo paramArticleInfo)
  {
    if (this.mTime == paramArticleInfo.mTime) {
      return 0;
    }
    if (this.mTime < paramArticleInfo.mTime) {
      return -1;
    }
    return 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean hasChannelInfo()
  {
    return (this.mChannelInfoId != -1) && (!TextUtils.isEmpty(this.mChannelInfoName)) && (this.mChannelInfoType != -1) && (!TextUtils.isEmpty(this.mChannelInfoDisplayName));
  }
  
  public ppa makeDislikeParam(ArrayList<DislikeInfo> paramArrayList)
  {
    return makeDislikeParam(paramArrayList, this.innerUniqueID);
  }
  
  public ppa makeDislikeParam(ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    ppa localppa = new ppa();
    if ((paramString != null) && (paramString.length() > 0)) {
      localppa.jdField_a_of_type_JavaLangString = paramString;
    }
    localppa.jdField_a_of_type_Long = this.mArticleID;
    localppa.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.mSocialFeedInfo != null)
    {
      localppa.b = this.mSocialFeedInfo.jdField_a_of_type_Long;
      localppa.c = this.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
    }
    if (obz.l(this))
    {
      localppa.c = this.mPolymericInfo.b;
      localppa.d = this.mPolymericInfo.f;
      localppa.jdField_a_of_type_Long = 0L;
    }
    return localppa;
  }
  
  public void prewrite()
  {
    super.prewrite();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    int i = -1;
    prewrite();
    paramParcel.writeLong(this.mArticleID);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.mFirstPagePicUrl);
    paramParcel.writeString(this.mOriginalUrl);
    paramParcel.writeString(this.mArticleContentUrl);
    paramParcel.writeLong(this.mTime);
    paramParcel.writeLong(this.mCommentCount);
    paramParcel.writeString(this.mSubscribeID);
    paramParcel.writeString(this.mSubscribeName);
    paramParcel.writeLong(this.mRecommendTime);
    paramParcel.writeLong(this.mChannelID);
    paramParcel.writeLong(this.mRecommendSeq);
    if (this.mShowBigPicture)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mStrategyId);
      paramParcel.writeInt(this.articleStyle);
      paramParcel.writeString(this.interfaceData);
      paramParcel.writeString(this.galleryReprotExdData);
      paramParcel.writeLong(this.mAlgorithmID);
      paramParcel.writeString(this.mArticleFriendLikeText);
      paramParcel.writeDouble(this.mTopicPicWHRatio);
      paramParcel.writeString(this.mTopicPicInfo);
      if (this.mPictures == null) {
        break label270;
      }
      paramInt = this.mPictures.length;
      label205:
      paramParcel.writeInt(paramInt);
      if (this.mPictures == null) {
        break label285;
      }
      URL[] arrayOfURL = this.mPictures;
      int k = arrayOfURL.length;
      paramInt = 0;
      label230:
      if (paramInt >= k) {
        break label285;
      }
      localObject = arrayOfURL[paramInt];
      if (localObject != null) {
        break label275;
      }
    }
    label270:
    label275:
    for (Object localObject = "";; localObject = ((URL)localObject).toString())
    {
      paramParcel.writeString((String)localObject);
      paramInt += 1;
      break label230;
      paramInt = 0;
      break;
      paramInt = 0;
      break label205;
    }
    label285:
    if (this.mSinglePicture != null) {
      if (this.mSinglePicture.getProtocol().equals("pubaccountimage"))
      {
        localObject = this.mSinglePicture.getFile();
        paramParcel.writeString((String)localObject);
        if (this.mVideoCoverUrl == null) {
          break label1101;
        }
        localObject = this.mVideoCoverUrl.toString();
        label339:
        paramParcel.writeString((String)localObject);
        if (this.mVideoVid == null) {
          break label1109;
        }
        localObject = this.mVideoVid;
        label358:
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(this.mVideoDuration);
        paramParcel.writeInt(this.mCommentIconType);
        if (this.mServerContext != null) {
          break label1117;
        }
        paramInt = -1;
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mServerContext);
        }
        if (this.mCommentInfoBytes != null) {
          break label1126;
        }
        paramInt = -1;
        label415:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mCommentInfoBytes);
        }
        if (this.mPackInfoBytes != null) {
          break label1135;
        }
        paramInt = -1;
        label441:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mPackInfoBytes);
        }
        paramParcel.writeLong(this.mCircleId);
        paramParcel.writeString(this.mStrCircleId);
        if (!this.mPUinIsActive) {
          break label1144;
        }
        paramInt = 1;
        label483:
        paramParcel.writeByte((byte)paramInt);
        if (this.mSubscribeInfoBytes != null) {
          break label1149;
        }
        paramInt = -1;
        label498:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mSubscribeInfoBytes);
        }
        paramParcel.writeInt(this.mFeedType);
        paramParcel.writeLong(this.mFeedId);
        if (this.mSocialFeedInfoByte != null) {
          break label1158;
        }
        paramInt = -1;
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mSocialFeedInfoByte);
        }
        paramParcel.writeString(this.innerUniqueID);
        paramParcel.writeLong(this.businessId);
        if (this.businessName == null) {
          break label1167;
        }
        localObject = this.businessName.toString();
        label589:
        paramParcel.writeString((String)localObject);
        if (this.businessUrl == null) {
          break label1175;
        }
        localObject = this.businessUrl.toString();
        label611:
        paramParcel.writeString((String)localObject);
        if (this.businessNamePrefix == null) {
          break label1183;
        }
        localObject = this.businessNamePrefix.toString();
        label633:
        paramParcel.writeString((String)localObject);
        if (this.mTopicRecommendFeedsInfoByte != null) {
          break label1191;
        }
        paramInt = -1;
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mTopicRecommendFeedsInfoByte);
        }
        if (this.mArkAppFeedsInfoBytes != null) {
          break label1200;
        }
        paramInt = -1;
        label674:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mArkAppFeedsInfoBytes);
        }
        paramParcel.writeLong(this.publishUin);
        paramParcel.writeLong(this.mMergeVideoId);
        paramParcel.writeInt(this.mVideoCommentCount);
        paramParcel.writeString(this.proteusItemsData);
        paramParcel.writeInt(this.mAccountLess);
        if (this.mVideoArticleSubsText == null) {
          break label1209;
        }
        localObject = this.mVideoArticleSubsText;
        label744:
        paramParcel.writeString((String)localObject);
        if (this.mVideoArticleSubsColor == null) {
          break label1217;
        }
        localObject = this.mVideoArticleSubsColor;
        label763:
        paramParcel.writeString((String)localObject);
        if (this.mVideoAdsJumpUrl == null) {
          break label1225;
        }
        localObject = this.mVideoAdsJumpUrl;
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(this.mVideoAdsJumpType);
        paramParcel.writeInt(this.mVideoAdsSource);
        paramParcel.writeString(this.videoReportInfo);
        if (!this.isTwoItem) {
          break label1233;
        }
        paramInt = 1;
        label821:
        paramParcel.writeByte((byte)paramInt);
        if (!this.isSuperTopic) {
          break label1238;
        }
        paramInt = 1;
        label836:
        paramParcel.writeByte((byte)paramInt);
        if (this.mNewPackInfoBytes != null) {
          break label1243;
        }
        paramInt = -1;
        label851:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mNewPackInfoBytes);
        }
        if (this.mRecommendFollowInfoBytes != null) {
          break label1252;
        }
        paramInt = -1;
        label877:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mRecommendFollowInfoBytes);
        }
        paramParcel.writeLong(this.mRecommendFollowId);
        paramParcel.writeString(this.gifCoverUrl);
        if (!this.isUseGif) {
          break label1261;
        }
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (this.mExtraBiuBriefBytes != null) {
          break label1266;
        }
        paramInt = -1;
        label934:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mExtraBiuBriefBytes);
        }
        if (this.mMultiBiuSameListBytes != null) {
          break label1275;
        }
        paramInt = -1;
        label960:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mMultiBiuSameListBytes);
        }
        paramParcel.writeInt(this.mIsGallery);
        if (!this.mIsGalleryChannel) {
          break label1284;
        }
        paramInt = j;
        label995:
        paramParcel.writeInt(paramInt);
        if (this.hotWordInfoListBytes != null) {
          break label1289;
        }
        paramInt = i;
        label1009:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.hotWordInfoListBytes);
        }
        paramParcel.writeInt(this.busiType);
        if (this.mGWCommonData == null) {
          break label1298;
        }
        localObject = this.mGWCommonData;
        paramParcel.writeString((String)localObject);
        if (this.mReportCommonData == null) {
          break label1306;
        }
      }
    }
    label389:
    label540:
    for (localObject = this.mReportCommonData;; localObject = "")
    {
      paramParcel.writeString((String)localObject);
      paramParcel.writeInt(this.recommentFlag);
      return;
      localObject = this.mSinglePicture.toString();
      break;
      localObject = "";
      break;
      label1101:
      localObject = "";
      break label339;
      label1109:
      localObject = "";
      break label358;
      label1117:
      paramInt = this.mServerContext.length;
      break label389;
      label1126:
      paramInt = this.mCommentInfoBytes.length;
      break label415;
      label1135:
      paramInt = this.mPackInfoBytes.length;
      break label441;
      label1144:
      paramInt = 0;
      break label483;
      label1149:
      paramInt = this.mSubscribeInfoBytes.length;
      break label498;
      paramInt = this.mSocialFeedInfoByte.length;
      break label540;
      localObject = "";
      break label589;
      localObject = "";
      break label611;
      label1183:
      localObject = "";
      break label633;
      label1191:
      paramInt = this.mTopicRecommendFeedsInfoByte.length;
      break label648;
      label1200:
      paramInt = this.mArkAppFeedsInfoBytes.length;
      break label674;
      label1209:
      localObject = "";
      break label744;
      label1217:
      localObject = "";
      break label763;
      label1225:
      localObject = "";
      break label782;
      label1233:
      paramInt = 0;
      break label821;
      label1238:
      paramInt = 0;
      break label836;
      label1243:
      paramInt = this.mNewPackInfoBytes.length;
      break label851;
      label1252:
      paramInt = this.mRecommendFollowInfoBytes.length;
      break label877;
      label1261:
      paramInt = 0;
      break label919;
      label1266:
      paramInt = this.mExtraBiuBriefBytes.length;
      break label934;
      label1275:
      paramInt = this.mMultiBiuSameListBytes.length;
      break label960;
      paramInt = 0;
      break label995;
      paramInt = this.hotWordInfoListBytes.length;
      break label1009;
      localObject = "";
      break label1047;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */