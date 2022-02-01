package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import ozs;
import qhx;
import quu;
import qvj;
import qvk;
import qvv;
import qwt;
import qxt;
import qzb;
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
    return new qvk();
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
    if (paramParcel.readByte() != 0) {}
    for (boolean bool1 = true;; bool1 = false)
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
        paramArticleInfo.mPictures[i] = ozs.a(paramParcel.readString());
        i += 1;
      }
    }
    paramArticleInfo.mSinglePicture = ozs.a(paramParcel.readString());
    paramArticleInfo.mVideoCoverUrl = ozs.a(paramParcel.readString());
    paramArticleInfo.mVideoVid = paramParcel.readString();
    paramArticleInfo.mVideoDuration = paramParcel.readInt();
    paramArticleInfo.mCommentIconType = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      paramArticleInfo.mServerContext = null;
      i = paramParcel.readInt();
      if (i != -1) {
        break label836;
      }
      paramArticleInfo.mCommentInfoBytes = null;
      label317:
      i = paramParcel.readInt();
      if (i != -1) {
        break label858;
      }
      paramArticleInfo.mPackInfoBytes = null;
      label332:
      paramArticleInfo.postRead();
      paramArticleInfo.mCircleId = paramParcel.readLong();
      paramArticleInfo.mStrCircleId = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label880;
      }
      bool1 = true;
      label362:
      paramArticleInfo.mPUinIsActive = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label886;
      }
      paramArticleInfo.mSubscribeInfoBytes = null;
      label383:
      paramArticleInfo.mFeedType = paramParcel.readInt();
      paramArticleInfo.mFeedId = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i > 0) {
        break label908;
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
        break label975;
      }
      paramArticleInfo.mTopicRecommendFeedsInfoByte = null;
      label467:
      i = paramParcel.readInt();
      if (i > 0) {
        break label1042;
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
        break label1118;
      }
      bool1 = true;
      label580:
      paramArticleInfo.isTwoItem = bool1;
      if (paramParcel.readByte() != 1) {
        break label1124;
      }
      bool1 = true;
      label597:
      paramArticleInfo.isSuperTopic = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1130;
      }
      paramArticleInfo.mNewPackInfoBytes = null;
      label618:
      i = paramParcel.readInt();
      if (i > 0) {
        break label1152;
      }
      paramArticleInfo.mRecommendFollowInfoBytes = null;
      label632:
      paramArticleInfo.mRecommendFollowId = paramParcel.readLong();
      paramArticleInfo.gifCoverUrl = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label1170;
      }
      bool1 = true;
      label659:
      paramArticleInfo.isUseGif = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1176;
      }
      paramArticleInfo.mExtraBiuBriefBytes = null;
      label680:
      i = paramParcel.readInt();
      if (i != -1) {
        break label1198;
      }
      paramArticleInfo.mMultiBiuSameListBytes = null;
      label695:
      paramArticleInfo.mIsGallery = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label1220;
      }
      bool1 = bool2;
      label715:
      paramArticleInfo.mIsGalleryChannel = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label1226;
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
            quu.a(paramArticleInfo);
            i = paramParcel.readInt();
            if (i <= 0) {
              break label1248;
            }
            paramArticleInfo.ptsItemDataBytes = new byte[i];
            paramParcel.readByteArray(paramArticleInfo.ptsItemDataBytes);
            paramArticleInfo.ptsItemData = ((PTSItemData)qhx.a(paramArticleInfo.ptsItemDataBytes, PTSItemData.CREATOR));
            return;
            paramArticleInfo.mServerContext = new byte[i];
            if (i <= 0) {
              break;
            }
            paramParcel.readByteArray(paramArticleInfo.mServerContext);
            break;
            label836:
            paramArticleInfo.mCommentInfoBytes = new byte[i];
            if (i <= 0) {
              break label317;
            }
            paramParcel.readByteArray(paramArticleInfo.mCommentInfoBytes);
            break label317;
            label858:
            paramArticleInfo.mPackInfoBytes = new byte[i];
            if (i <= 0) {
              break label332;
            }
            paramParcel.readByteArray(paramArticleInfo.mPackInfoBytes);
            break label332;
            label880:
            bool1 = false;
            break label362;
            label886:
            paramArticleInfo.mSubscribeInfoBytes = new byte[i];
            if (i <= 0) {
              break label383;
            }
            paramParcel.readByteArray(paramArticleInfo.mSubscribeInfoBytes);
            break label383;
            label908:
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
          label975:
          paramArticleInfo.mTopicRecommendFeedsInfoByte = new byte[i];
          paramParcel.readByteArray(paramArticleInfo.mTopicRecommendFeedsInfoByte);
          articlesummary.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new articlesummary.TopicRecommendFeedsInfo();
          try
          {
            localTopicRecommendFeedsInfo.mergeFrom(paramArticleInfo.mTopicRecommendFeedsInfoByte);
            paramArticleInfo.mTopicRecommendFeedsInfo = qzb.a(localTopicRecommendFeedsInfo);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            QLog.e("ArticleInfo", 1, "createFromParcel: ", localInvalidProtocolBufferMicroException2);
            paramArticleInfo.mSocialFeedInfo = null;
          }
        }
        break label467;
        label1042:
        paramArticleInfo.mArkAppFeedsInfoBytes = new byte[i];
        paramParcel.readByteArray(paramArticleInfo.mArkAppFeedsInfoBytes);
        articlesummary.ArkAppFeedsInfo localArkAppFeedsInfo = new articlesummary.ArkAppFeedsInfo();
        try
        {
          localArkAppFeedsInfo.mergeFrom(paramArticleInfo.mArkAppFeedsInfoBytes);
          paramArticleInfo.mArkAppFeedsInfo = qvj.a(localArkAppFeedsInfo);
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
      label1118:
      bool1 = false;
      break label580;
      label1124:
      bool1 = false;
      break label597;
      label1130:
      paramArticleInfo.mNewPackInfoBytes = new byte[i];
      if (i <= 0) {
        break label618;
      }
      paramParcel.readByteArray(paramArticleInfo.mNewPackInfoBytes);
      break label618;
      label1152:
      paramArticleInfo.mRecommendFollowInfoBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mRecommendFollowInfoBytes);
      break label632;
      label1170:
      bool1 = false;
      break label659;
      label1176:
      if (i <= 0) {
        break label680;
      }
      paramArticleInfo.mExtraBiuBriefBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mExtraBiuBriefBytes);
      break label680;
      label1198:
      if (i <= 0) {
        break label695;
      }
      paramArticleInfo.mMultiBiuSameListBytes = new byte[i];
      paramParcel.readByteArray(paramArticleInfo.mMultiBiuSameListBytes);
      break label695;
      label1220:
      bool1 = false;
      break label715;
      label1226:
      if (i > 0)
      {
        paramArticleInfo.hotWordInfoListBytes = new byte[i];
        paramParcel.readByteArray(paramArticleInfo.hotWordInfoListBytes);
      }
    }
    label1248:
    paramArticleInfo.ptsItemDataBytes = null;
    paramArticleInfo.ptsItemData = null;
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
  
  public qvv makeDislikeParam(ArrayList<DislikeInfo> paramArrayList)
  {
    return makeDislikeParam(paramArrayList, this.innerUniqueID);
  }
  
  public qvv makeDislikeParam(ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    qvv localqvv = new qvv();
    if ((paramString != null) && (paramString.length() > 0)) {
      localqvv.jdField_a_of_type_JavaLangString = paramString;
    }
    localqvv.jdField_a_of_type_Long = this.mArticleID;
    localqvv.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (this.mSocialFeedInfo != null)
    {
      localqvv.b = this.mSocialFeedInfo.jdField_a_of_type_Long;
      localqvv.c = this.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
    }
    if (ozs.l(this))
    {
      localqvv.c = this.mPolymericInfo.b;
      localqvv.d = this.mPolymericInfo.f;
      localqvv.jdField_a_of_type_Long = 0L;
    }
    return localqvv;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */