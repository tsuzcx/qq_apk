package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import mba;

public class ArticleInfo
  extends BaseArticleInfo
  implements Parcelable, Cloneable, Comparable
{
  public static final Parcelable.Creator CREATOR = makeArticleInfoCreator();
  public static final long SUBSCRIBE_ARTICLE_ID = -3L;
  public static final long SUBSCRIBE_RECOMMEND_SEQ = -3L;
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public static final String TAG = "ArticleInfo";
  public static final long TOPIC_ARTICLE_ID = -2L;
  public static final long TOPIC_RECOMMEND_SEQ = -2L;
  
  public static Parcelable.Creator makeArticleInfoCreator()
  {
    return new mba();
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
  
  public DislikeParam makeDislikeParam(ArrayList paramArrayList)
  {
    return makeDislikeParam(paramArrayList, null);
  }
  
  public DislikeParam makeDislikeParam(ArrayList paramArrayList, String paramString)
  {
    DislikeParam localDislikeParam = new DislikeParam();
    if ((paramString != null) && (paramString.length() > 0)) {
      localDislikeParam.jdField_a_of_type_JavaLangString = paramString;
    }
    for (;;)
    {
      localDislikeParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      if (this.mSocialFeedInfo != null)
      {
        localDislikeParam.b = this.mSocialFeedInfo.jdField_a_of_type_Long;
        localDislikeParam.c = this.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      if (ReadInJoyUtils.f(this))
      {
        localDislikeParam.c = this.mPolymericInfo.b;
        localDislikeParam.d = this.mPolymericInfo.f;
        localDislikeParam.jdField_a_of_type_Long = 0L;
      }
      return localDislikeParam;
      localDislikeParam.jdField_a_of_type_Long = this.mArticleID;
    }
  }
  
  protected void prewrite()
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
          break label834;
        }
        localObject = this.mVideoCoverUrl.toString();
        label339:
        paramParcel.writeString((String)localObject);
        if (this.mVideoVid == null) {
          break label842;
        }
        localObject = this.mVideoVid;
        label358:
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(this.mVideoDuration);
        paramParcel.writeInt(this.mCommentIconType);
        if (this.mServerContext != null) {
          break label850;
        }
        paramInt = -1;
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mServerContext);
        }
        if (this.mCommentInfoBytes != null) {
          break label859;
        }
        paramInt = -1;
        label415:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mCommentInfoBytes);
        }
        if (this.mPackInfoBytes != null) {
          break label868;
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
          break label877;
        }
        paramInt = j;
        label484:
        paramParcel.writeByte((byte)paramInt);
        if (this.mSubscribeInfoBytes != null) {
          break label882;
        }
        paramInt = -1;
        label499:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mSubscribeInfoBytes);
        }
        paramParcel.writeInt(this.mFeedType);
        paramParcel.writeLong(this.mFeedId);
        if (this.mSocialFeedInfoByte != null) {
          break label891;
        }
        paramInt = -1;
        label541:
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mSocialFeedInfoByte);
        }
        paramParcel.writeString(this.innerUniqueID);
        paramParcel.writeLong(this.businessId);
        if (this.businessName == null) {
          break label900;
        }
        localObject = this.businessName.toString();
        label590:
        paramParcel.writeString((String)localObject);
        if (this.businessUrl == null) {
          break label908;
        }
        localObject = this.businessUrl.toString();
        label612:
        paramParcel.writeString((String)localObject);
        if (this.businessNamePrefix == null) {
          break label916;
        }
        localObject = this.businessNamePrefix.toString();
        label634:
        paramParcel.writeString((String)localObject);
        if (this.mTopicRecommendFeedsInfoByte != null) {
          break label924;
        }
        paramInt = -1;
        paramParcel.writeInt(paramInt);
        if (paramInt > 0) {
          paramParcel.writeByteArray(this.mTopicRecommendFeedsInfoByte);
        }
        if (this.mArkAppFeedsInfoBytes != null) {
          break label933;
        }
        paramInt = i;
        label675:
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
          break label942;
        }
        localObject = this.mVideoArticleSubsText;
        label745:
        paramParcel.writeString((String)localObject);
        if (this.mVideoArticleSubsColor == null) {
          break label950;
        }
        localObject = this.mVideoArticleSubsColor;
        label764:
        paramParcel.writeString((String)localObject);
        if (this.mVideoAdsJumpUrl == null) {
          break label958;
        }
      }
    }
    label389:
    label649:
    label908:
    label916:
    label924:
    label933:
    label942:
    label950:
    label958:
    for (localObject = this.mVideoAdsJumpUrl;; localObject = "")
    {
      paramParcel.writeString((String)localObject);
      paramParcel.writeInt(this.mVideoAdsJumpType);
      paramParcel.writeInt(this.mVideoAdsSource);
      paramParcel.writeString(this.videoReportInfo);
      return;
      localObject = this.mSinglePicture.toString();
      break;
      localObject = "";
      break;
      label834:
      localObject = "";
      break label339;
      label842:
      localObject = "";
      break label358;
      label850:
      paramInt = this.mServerContext.length;
      break label389;
      label859:
      paramInt = this.mCommentInfoBytes.length;
      break label415;
      label868:
      paramInt = this.mPackInfoBytes.length;
      break label441;
      label877:
      paramInt = 0;
      break label484;
      label882:
      paramInt = this.mSubscribeInfoBytes.length;
      break label499;
      label891:
      paramInt = this.mSocialFeedInfoByte.length;
      break label541;
      localObject = "";
      break label590;
      localObject = "";
      break label612;
      localObject = "";
      break label634;
      paramInt = this.mTopicRecommendFeedsInfoByte.length;
      break label649;
      paramInt = this.mArkAppFeedsInfoBytes.length;
      break label675;
      localObject = "";
      break label745;
      localObject = "";
      break label764;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */