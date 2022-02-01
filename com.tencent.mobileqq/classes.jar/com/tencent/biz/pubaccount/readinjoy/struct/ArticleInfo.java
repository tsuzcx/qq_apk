package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSParcelableUtil;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ShortWithLongContentUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
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
  public int recommentFlag = 0;
  
  public ArticleInfo() {}
  
  public ArticleInfo(Parcel paramParcel)
  {
    readFromParcel(this, paramParcel);
  }
  
  public static Parcelable.Creator<ArticleInfo> makeArticleInfoCreator()
  {
    return new ArticleInfo.1();
  }
  
  private void readArkAppFeedsInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramArticleInfo.mArkAppFeedsInfoBytes = null;
      return;
    }
    paramArticleInfo.mArkAppFeedsInfoBytes = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mArkAppFeedsInfoBytes);
    paramParcel = new articlesummary.ArkAppFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramArticleInfo.mArkAppFeedsInfoBytes);
      paramArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      paramParcel.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfo", 2, "convertPBToInfo arkAppFeedsInfo failed.");
      }
      paramArticleInfo.mArkAppFeedsInfo = null;
    }
  }
  
  private void readCommentInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mCommentInfoBytes = null;
    }
    do
    {
      return;
      paramArticleInfo.mCommentInfoBytes = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(paramArticleInfo.mCommentInfoBytes);
  }
  
  private void readExtraBiuBrief(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mExtraBiuBriefBytes = null;
    }
    while (i <= 0) {
      return;
    }
    paramArticleInfo.mExtraBiuBriefBytes = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mExtraBiuBriefBytes);
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
    paramArticleInfo.mShareCount = paramParcel.readInt();
    paramArticleInfo.mSubscribeID = paramParcel.readString();
    paramArticleInfo.mSubscribeName = paramParcel.readString();
    paramArticleInfo.mRecommendTime = paramParcel.readLong();
    paramArticleInfo.mChannelID = paramParcel.readLong();
    paramArticleInfo.mRecommendSeq = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      paramArticleInfo.mShowBigPicture = bool1;
      paramArticleInfo.mStrategyId = paramParcel.readInt();
      paramArticleInfo.articleStyle = paramParcel.readInt();
      paramArticleInfo.interfaceData = paramParcel.readString();
      paramArticleInfo.galleryReprotExdData = paramParcel.readString();
      paramArticleInfo.mAlgorithmID = paramParcel.readLong();
      paramArticleInfo.mArticleFriendLikeText = paramParcel.readString();
      paramArticleInfo.mTopicPicWHRatio = paramParcel.readDouble();
      paramArticleInfo.mTopicPicInfo = paramParcel.readString();
      readPictureInfo(paramArticleInfo, paramParcel);
      paramArticleInfo.mVideoCoverUrl = RIJPreParseData.a(paramParcel.readString());
      paramArticleInfo.mVideoVid = paramParcel.readString();
      paramArticleInfo.mVideoDuration = paramParcel.readInt();
      paramArticleInfo.mCommentIconType = paramParcel.readInt();
      readServeContext(paramArticleInfo, paramParcel);
      readCommentInfo(paramArticleInfo, paramParcel);
      readPackInfo(paramArticleInfo, paramParcel);
      paramArticleInfo.postRead();
      paramArticleInfo.mCircleId = paramParcel.readLong();
      paramArticleInfo.mStrCircleId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label617;
      }
      bool1 = true;
      label281:
      paramArticleInfo.mPUinIsActive = bool1;
      readSubscribeInfo(paramArticleInfo, paramParcel);
      paramArticleInfo.mFeedType = paramParcel.readInt();
      paramArticleInfo.mFeedId = paramParcel.readLong();
      readSocialFeedInfo(paramArticleInfo, paramParcel);
      paramArticleInfo.innerUniqueID = paramParcel.readString();
      paramArticleInfo.businessId = paramParcel.readLong();
      paramArticleInfo.businessName = paramParcel.readString();
      paramArticleInfo.businessUrl = paramParcel.readString();
      paramArticleInfo.businessNamePrefix = paramParcel.readString();
      readTopicRecommendFeedsInfo(paramArticleInfo, paramParcel);
      readArkAppFeedsInfo(paramArticleInfo, paramParcel);
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
        break label622;
      }
      bool1 = true;
      label464:
      paramArticleInfo.isTwoItem = bool1;
      if (paramParcel.readByte() != 1) {
        break label627;
      }
      bool1 = true;
      label479:
      paramArticleInfo.isSuperTopic = bool1;
      readNewPackInfo(paramArticleInfo, paramParcel);
      readRecommendFollowInfo(paramArticleInfo, paramParcel);
      paramArticleInfo.mRecommendFollowId = paramParcel.readLong();
      paramArticleInfo.gifCoverUrl = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label632;
      }
      bool1 = true;
      label522:
      paramArticleInfo.isUseGif = bool1;
      readExtraBiuBrief(paramArticleInfo, paramParcel);
      readMultiBiuSameList(paramArticleInfo, paramParcel);
      paramArticleInfo.mIsGallery = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label637;
      }
    }
    label617:
    label622:
    label627:
    label632:
    label637:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArticleInfo.mIsGalleryChannel = bool1;
      readHotWordInfo(paramArticleInfo, paramParcel);
      this.busiType = paramParcel.readInt();
      paramArticleInfo.mGWCommonData = paramParcel.readString();
      paramArticleInfo.mReportCommonData = paramParcel.readString();
      paramArticleInfo.recommentFlag = paramParcel.readInt();
      ShortWithLongContentUtil.a(paramArticleInfo);
      readPtsItemData(paramArticleInfo, paramParcel);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label281;
      bool1 = false;
      break label464;
      bool1 = false;
      break label479;
      bool1 = false;
      break label522;
    }
  }
  
  private void readHotWordInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.hotWordInfoListBytes = null;
    }
    while (i <= 0) {
      return;
    }
    paramArticleInfo.hotWordInfoListBytes = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.hotWordInfoListBytes);
  }
  
  private void readMultiBiuSameList(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mMultiBiuSameListBytes = null;
    }
    while (i <= 0) {
      return;
    }
    paramArticleInfo.mMultiBiuSameListBytes = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mMultiBiuSameListBytes);
  }
  
  private void readNewPackInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mNewPackInfoBytes = null;
    }
    do
    {
      return;
      paramArticleInfo.mNewPackInfoBytes = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(paramArticleInfo.mNewPackInfoBytes);
  }
  
  private void readPackInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mPackInfoBytes = null;
    }
    do
    {
      return;
      paramArticleInfo.mPackInfoBytes = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(paramArticleInfo.mPackInfoBytes);
  }
  
  private void readPictureInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    if (j > 0)
    {
      paramArticleInfo.mPictures = new URL[j];
      int i = 0;
      while (i < j)
      {
        paramArticleInfo.mPictures[i] = RIJPreParseData.a(paramParcel.readString());
        i += 1;
      }
    }
    paramArticleInfo.mSinglePicture = RIJPreParseData.a(paramParcel.readString());
  }
  
  private void readPtsItemData(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i > 0)
    {
      paramArticleInfo.ptsItemDataBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.ptsItemDataBytes);
      paramArticleInfo.ptsItemData = ((PTSItemData)PTSParcelableUtil.a(paramArticleInfo.ptsItemDataBytes, PTSItemData.CREATOR));
      return;
    }
    paramArticleInfo.ptsItemDataBytes = null;
    paramArticleInfo.ptsItemData = null;
  }
  
  private void readRecommendFollowInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramArticleInfo.mRecommendFollowInfoBytes = null;
      return;
    }
    paramArticleInfo.mRecommendFollowInfoBytes = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mRecommendFollowInfoBytes);
  }
  
  private void readServeContext(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mServerContext = null;
    }
    do
    {
      return;
      paramArticleInfo.mServerContext = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(paramArticleInfo.mServerContext);
  }
  
  private void readSocialFeedInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramArticleInfo.mSocialFeedInfoByte = null;
      return;
    }
    paramArticleInfo.mSocialFeedInfoByte = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mSocialFeedInfoByte);
    paramParcel = new articlesummary.SocializeFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramArticleInfo.mSocialFeedInfoByte);
      paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      QLog.e("ArticleInfo", 1, "createFromParcel: ", paramParcel);
      paramArticleInfo.mSocialFeedInfo = null;
    }
  }
  
  private void readSubscribeInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -1) {
      paramArticleInfo.mSubscribeInfoBytes = null;
    }
    do
    {
      return;
      paramArticleInfo.mSubscribeInfoBytes = new byte[i];
    } while (i <= 0);
    paramParcel.readByteArray(paramArticleInfo.mSubscribeInfoBytes);
  }
  
  private void readTopicRecommendFeedsInfo(@NotNull ArticleInfo paramArticleInfo, @NotNull Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i <= 0)
    {
      paramArticleInfo.mTopicRecommendFeedsInfoByte = null;
      return;
    }
    paramArticleInfo.mTopicRecommendFeedsInfoByte = new byte[i];
    paramParcel.readByteArray(paramArticleInfo.mTopicRecommendFeedsInfoByte);
    paramParcel = new articlesummary.TopicRecommendFeedsInfo();
    try
    {
      paramParcel.mergeFrom(paramArticleInfo.mTopicRecommendFeedsInfoByte);
      paramArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a(paramParcel);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramParcel)
    {
      QLog.e("ArticleInfo", 1, "createFromParcel: ", paramParcel);
      paramArticleInfo.mSocialFeedInfo = null;
    }
  }
  
  private void writeByteArrayDataToParcel(@NotNull byte[] paramArrayOfByte, @NotNull Parcel paramParcel)
  {
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      paramParcel.writeInt(i);
      if (i > 0) {
        paramParcel.writeByteArray(paramArrayOfByte);
      }
      return;
    }
  }
  
  private void writeByteDataToParcel(boolean paramBoolean, @NotNull Parcel paramParcel)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
  
  private void writePictureToParcel(@NotNull Parcel paramParcel)
  {
    int j = 0;
    int i;
    if (this.mPictures != null)
    {
      i = this.mPictures.length;
      paramParcel.writeInt(i);
      if (this.mPictures == null) {
        break label90;
      }
      URL[] arrayOfURL = this.mPictures;
      int k = arrayOfURL.length;
      i = j;
      label40:
      if (i >= k) {
        break label90;
      }
      localObject = arrayOfURL[i];
      if (localObject != null) {
        break label80;
      }
    }
    label80:
    for (Object localObject = "";; localObject = ((URL)localObject).toString())
    {
      paramParcel.writeString((String)localObject);
      i += 1;
      break label40;
      i = 0;
      break;
    }
    label90:
    if (this.mSinglePicture != null) {
      if (this.mSinglePicture.getProtocol().equals("pubaccountimage")) {
        localObject = this.mSinglePicture.getFile();
      }
    }
    for (;;)
    {
      paramParcel.writeString((String)localObject);
      return;
      localObject = this.mSinglePicture.toString();
      continue;
      localObject = "";
    }
  }
  
  private void writeStringToParcel(@NotNull String paramString, @NotNull Parcel paramParcel)
  {
    if (paramString != null) {}
    for (;;)
    {
      paramParcel.writeString(paramString);
      return;
      paramString = "";
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
  
  public DislikeParam makeDislikeParam(ArrayList<DislikeInfo> paramArrayList)
  {
    return makeDislikeParam(paramArrayList, this.innerUniqueID);
  }
  
  public DislikeParam makeDislikeParam(ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    DislikeParam localDislikeParam = new DislikeParam();
    if ((paramString != null) && (paramString.length() > 0)) {
      localDislikeParam.jdField_a_of_type_JavaLangString = paramString;
    }
    localDislikeParam.jdField_a_of_type_Long = this.mArticleID;
    localDislikeParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.mSocialFeedInfo != null)
    {
      localDislikeParam.b = this.mSocialFeedInfo.jdField_a_of_type_Long;
      localDislikeParam.c = this.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
    }
    if (RIJFeedsType.l(this))
    {
      localDislikeParam.c = this.mPolymericInfo.b;
      localDislikeParam.d = this.mPolymericInfo.f;
      localDislikeParam.jdField_a_of_type_Long = 0L;
    }
    return localDislikeParam;
  }
  
  public void prewrite()
  {
    super.prewrite();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    prewrite();
    paramParcel.writeLong(this.mArticleID);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSummary);
    paramParcel.writeString(this.mFirstPagePicUrl);
    paramParcel.writeString(this.mOriginalUrl);
    paramParcel.writeString(this.mArticleContentUrl);
    paramParcel.writeLong(this.mTime);
    paramParcel.writeLong(this.mCommentCount);
    paramParcel.writeInt(this.mShareCount);
    paramParcel.writeString(this.mSubscribeID);
    paramParcel.writeString(this.mSubscribeName);
    paramParcel.writeLong(this.mRecommendTime);
    paramParcel.writeLong(this.mChannelID);
    paramParcel.writeLong(this.mRecommendSeq);
    writeByteDataToParcel(this.mShowBigPicture, paramParcel);
    paramParcel.writeInt(this.mStrategyId);
    paramParcel.writeInt(this.articleStyle);
    paramParcel.writeString(this.interfaceData);
    paramParcel.writeString(this.galleryReprotExdData);
    paramParcel.writeLong(this.mAlgorithmID);
    paramParcel.writeString(this.mArticleFriendLikeText);
    paramParcel.writeDouble(this.mTopicPicWHRatio);
    paramParcel.writeString(this.mTopicPicInfo);
    writePictureToParcel(paramParcel);
    if (this.mVideoCoverUrl != null) {}
    for (String str = this.mVideoCoverUrl.toString();; str = "")
    {
      paramParcel.writeString(str);
      writeStringToParcel(this.mVideoVid, paramParcel);
      paramParcel.writeInt(this.mVideoDuration);
      paramParcel.writeInt(this.mCommentIconType);
      writeByteArrayDataToParcel(this.mServerContext, paramParcel);
      writeByteArrayDataToParcel(this.mCommentInfoBytes, paramParcel);
      writeByteArrayDataToParcel(this.mPackInfoBytes, paramParcel);
      paramParcel.writeLong(this.mCircleId);
      paramParcel.writeString(this.mStrCircleId);
      writeByteDataToParcel(this.mPUinIsActive, paramParcel);
      writeByteArrayDataToParcel(this.mSubscribeInfoBytes, paramParcel);
      paramParcel.writeInt(this.mFeedType);
      paramParcel.writeLong(this.mFeedId);
      writeByteArrayDataToParcel(this.mSocialFeedInfoByte, paramParcel);
      paramParcel.writeString(this.innerUniqueID);
      paramParcel.writeLong(this.businessId);
      writeStringToParcel(this.businessName, paramParcel);
      writeStringToParcel(this.businessUrl, paramParcel);
      writeStringToParcel(this.businessNamePrefix, paramParcel);
      writeByteArrayDataToParcel(this.mTopicRecommendFeedsInfoByte, paramParcel);
      writeByteArrayDataToParcel(this.mArkAppFeedsInfoBytes, paramParcel);
      paramParcel.writeLong(this.publishUin);
      paramParcel.writeLong(this.mMergeVideoId);
      paramParcel.writeInt(this.mVideoCommentCount);
      paramParcel.writeString(this.proteusItemsData);
      paramParcel.writeInt(this.mAccountLess);
      writeStringToParcel(this.mVideoArticleSubsText, paramParcel);
      writeStringToParcel(this.mVideoArticleSubsColor, paramParcel);
      writeStringToParcel(this.mVideoAdsJumpUrl, paramParcel);
      paramParcel.writeInt(this.mVideoAdsJumpType);
      paramParcel.writeInt(this.mVideoAdsSource);
      paramParcel.writeString(this.videoReportInfo);
      writeByteDataToParcel(this.isTwoItem, paramParcel);
      writeByteDataToParcel(this.isSuperTopic, paramParcel);
      writeByteArrayDataToParcel(this.mNewPackInfoBytes, paramParcel);
      writeByteArrayDataToParcel(this.mRecommendFollowInfoBytes, paramParcel);
      paramParcel.writeLong(this.mRecommendFollowId);
      paramParcel.writeString(this.gifCoverUrl);
      writeByteDataToParcel(this.isUseGif, paramParcel);
      writeByteArrayDataToParcel(this.mExtraBiuBriefBytes, paramParcel);
      writeByteArrayDataToParcel(this.mMultiBiuSameListBytes, paramParcel);
      paramParcel.writeInt(this.mIsGallery);
      writeByteDataToParcel(this.mIsGalleryChannel, paramParcel);
      writeByteArrayDataToParcel(this.hotWordInfoListBytes, paramParcel);
      paramParcel.writeInt(this.busiType);
      writeStringToParcel(this.mGWCommonData, paramParcel);
      writeStringToParcel(this.mReportCommonData, paramParcel);
      paramParcel.writeInt(this.recommentFlag);
      writeByteArrayDataToParcel(this.ptsItemDataBytes, paramParcel);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */