package com.tencent.biz.pubaccount.readinjoy.viewmodels;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.OutsideLinkInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.text.ShortContentWithLinkSpan;
import com.tencent.biz.pubaccount.readinjoy.view.text.UserSpan;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Utils
{
  public static IReadInJoyModel a(ArticleInfo paramArticleInfo)
  {
    return new ReadInJoyModelImpl(null, paramArticleInfo, RIJItemViewType.a(paramArticleInfo), (int)paramArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  static CharSequence a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      localObject2 = paramBaseArticleInfo.mSocialFeedInfo;
      if ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() > 0) && ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).mBiuComment)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.get(0)).mBiuComment, "：")))))
      {
        localObject1 = new SpannableStringBuilder();
        localObject2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a(paramInt, (ArticleInfo)paramBaseArticleInfo, "5", paramRefreshUserInfoCallBack);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramRefreshUserInfoCallBack = a(paramInt, (CharSequence)localObject1, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
      QLog.d("Utils", 2, "makeBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + paramRefreshUserInfoCallBack + " condition flag: " + i + ", linkTextColor " + paramInt);
      return paramRefreshUserInfoCallBack;
      if (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString))
      {
        if (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.length() >= 100) {
          ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString = (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.substring(0, 99) + '…');
        }
        localObject1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString;
        i = 1;
      }
      else
      {
        i = 0;
        localObject1 = "";
      }
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, long paramLong, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject = new StringBuilder().append(ReadInJoyUserInfoModule.a(paramLong, paramRefreshUserInfoCallBack, ReadInJoyUserInfoModule.a()));
    if (!TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {}
    for (paramRefreshUserInfoCallBack = " ";; paramRefreshUserInfoCallBack = "：")
    {
      paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack;
      localObject = new SpannableStringBuilder(paramRefreshUserInfoCallBack);
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new UserSpan(paramLong, "2", (ArticleInfo)paramBaseArticleInfo, paramInt), 0, paramRefreshUserInfoCallBack.length(), 18);
      QLog.d("Utils", 1, "addPreAuthor: " + localObject + ", linkTextColor: " + paramInt);
      return localObject;
    }
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel != null)
      {
        if (TextUtils.isEmpty(paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString)) {
          break label113;
        }
        paramCharSequence = a(paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString);
      }
    }
    label113:
    for (;;)
    {
      localCharSequence = paramCharSequence;
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long != 0L) {
        localCharSequence = a(paramInt, paramCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Long, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
      }
      if (paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int != 0) {
        localCharSequence = a(localCharSequence, paramBaseArticleInfo.articleViewModel.jdField_a_of_type_Int);
      }
      for (;;)
      {
        return new QQText(localCharSequence, 3, 16);
      }
    }
  }
  
  @NotNull
  private static CharSequence a(ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
      }
    }
    while (paramArticleInfo.mTitle == null) {
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append(paramArticleInfo.mTitle);
    return localSpannableStringBuilder;
  }
  
  private static CharSequence a(ArticleInfo paramArticleInfo, CharSequence paramCharSequence)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString)))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 19191924) {
        try
        {
          paramArticleInfo = ShortContentWithLinkSpan.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.b, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.jdField_a_of_type_JavaLangString, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.c, paramArticleInfo);
          return paramArticleInfo;
        }
        catch (NullPointerException paramArticleInfo)
        {
          QLog.e("Utils", 2, paramArticleInfo.toString());
          return paramCharSequence;
        }
      }
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString;
    }
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mTitle))) {
      return paramArticleInfo.mTitle;
    }
    return "";
  }
  
  @NotNull
  private static CharSequence a(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(HardCodeUtil.a(2131715860));
    TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo;
    StringBuilder localStringBuilder2;
    if (!RIJItemViewType.l(paramBaseArticleInfo))
    {
      localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0);
      localStringBuilder2 = localStringBuilder1.append("“");
      if (!TextUtils.isEmpty(localTopicRecommendInfo.c)) {
        break label92;
      }
      paramBaseArticleInfo = "";
      localStringBuilder2 = localStringBuilder2.append(paramBaseArticleInfo);
      if (!TextUtils.isEmpty(localTopicRecommendInfo.jdField_a_of_type_JavaLangString)) {
        break label100;
      }
    }
    label92:
    label100:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = localTopicRecommendInfo.jdField_a_of_type_JavaLangString)
    {
      localStringBuilder2.append(paramBaseArticleInfo).append("”");
      return localStringBuilder1;
      paramBaseArticleInfo = localTopicRecommendInfo.c;
      break;
    }
  }
  
  static CharSequence a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return a(-15504151, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localSpannableStringBuilder.append(" ");
      i += 1;
    }
    localSpannableStringBuilder.append(paramCharSequence);
    QLog.d("Utils", 1, "addPreBlank: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return a(-15504151, paramCharSequence, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    QLog.d("Utils", 1, "addPreCommentText: " + localSpannableStringBuilder);
    return localSpannableStringBuilder;
  }
  
  @NotNull
  private static CharSequence a(String paramString)
  {
    String str2 = ReadInJoyDisplayUtils.a(paramString);
    String str1 = str2;
    if (TextUtils.equals(str2, paramString)) {
      str1 = EmotionCodecUtils.b(paramString);
    }
    return new QQText(str1, 3, 16);
  }
  
  public static CharSequence b(int paramInt, BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    QLog.d("Utils", 1, "makeSummaryText: " + paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBaseArticleInfo = a((ArticleInfo)paramBaseArticleInfo);
    NativeSummaryView.a(paramInt, paramBaseArticleInfo, localSpannableStringBuilder, paramRefreshUserInfoCallBack);
    NativeSummaryView.a(paramBaseArticleInfo, localSpannableStringBuilder, paramRefreshUserInfoCallBack);
    return localSpannableStringBuilder;
  }
  
  static CharSequence b(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    int i1 = 0;
    int n = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (localArticleInfo == null) {
      return "";
    }
    String str = "";
    int j;
    int k;
    int m;
    Object localObject;
    switch (RIJItemViewType.a(localArticleInfo))
    {
    default: 
      j = 0;
      k = 0;
      m = 0;
      i = n;
      localObject = str;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramBaseArticleInfo.isPGCShortContent())
        {
          i = 9;
          localObject = a(localArticleInfo, "");
        }
      }
      else
      {
        label177:
        paramRefreshUserInfoCallBack = a((CharSequence)localObject, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
        QLog.d("Utils", 2, "makeNonBiuComment: " + paramBaseArticleInfo.rawkey + " ssb: " + paramRefreshUserInfoCallBack + " condition flag: " + i);
        return paramRefreshUserInfoCallBack;
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      k = 0;
      j = 1;
      m = i;
      break;
      j = 0;
      k = 1;
      m = 0;
      break;
      if (k != 0)
      {
        localObject = localArticleInfo.mTitle;
        i = 1;
        break label177;
      }
      if ((RIJItemViewType.a(localArticleInfo)) || (RIJItemViewType.i(localArticleInfo)) || (RIJItemViewType.h(localArticleInfo)))
      {
        if (m != 0)
        {
          localObject = a(localArticleInfo);
          i = 2;
          break label177;
        }
        if (j != 0)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {}
          for (localObject = localArticleInfo.mTitle;; localObject = localArticleInfo.mSummary)
          {
            i = 3;
            break;
          }
        }
        if (RIJItemViewType.i(localArticleInfo))
        {
          localObject = a(paramBaseArticleInfo);
          i = 4;
          break label177;
        }
        localObject = localArticleInfo.mSummary;
        i = 5;
        break label177;
      }
      i = n;
      localObject = str;
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break label177;
      }
      SocializeFeedsInfo.UGCFeedsInfo localUGCFeedsInfo = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
      if (RIJFeedsType.a(localUGCFeedsInfo))
      {
        localObject = localUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a(localArticleInfo, "3", paramRefreshUserInfoCallBack);
        i = 6;
        break label177;
      }
      if ((CmpCtxt.c(localArticleInfo)) && (!RIJItemViewType.q(localArticleInfo)))
      {
        localObject = ((SocializeFeedsInfo.UGCVideoInfo)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).e;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label562;
        }
        localObject = a((String)localObject);
      }
      for (i = 7;; i = i1)
      {
        break;
        i = n;
        localObject = str;
        if (TextUtils.isEmpty(localUGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        localObject = null;
        try
        {
          str = EmotionCodecUtils.b(localUGCFeedsInfo.jdField_a_of_type_JavaLangString);
          localObject = str;
        }
        catch (Exception localException)
        {
          label537:
          break label537;
        }
        localObject = new QQText((CharSequence)localObject, 3, 16);
        i = 8;
        break;
        label562:
        localObject = "";
      }
    }
  }
  
  public static CharSequence c(BaseArticleInfo paramBaseArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return b(-15504151, paramBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viewmodels.Utils
 * JD-Core Version:    0.7.0.1
 */