package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSocialAvatarClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnSocialAvatarClickListener(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public static OnSocialAvatarClickListener.SocialAvatarData a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int n = 0;
    OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = new OnSocialAvatarClickListener.SocialAvatarData();
    if (paramArticleInfo == null) {
      return localSocialAvatarData;
    }
    boolean bool1 = RIJItemViewType.a(paramArticleInfo);
    int i;
    boolean bool2;
    int j;
    label59:
    int k;
    label68:
    boolean bool3;
    boolean bool4;
    int m;
    if ((paramInt == 77) || (paramInt == 78))
    {
      i = 1;
      bool2 = RIJItemViewType.g(paramArticleInfo);
      if ((paramInt != 72) && (paramInt != 74)) {
        break label242;
      }
      j = 1;
      if (paramInt != 76) {
        break label247;
      }
      k = 1;
      bool3 = RIJItemViewType.a(paramArticleInfo);
      bool4 = RIJItemViewType.f(paramArticleInfo);
      if ((paramInt != 73) && (paramInt != 75)) {
        break label253;
      }
      m = 1;
      label95:
      if (paramInt == 147) {
        n = 1;
      }
      if ((!bool1) && (i == 0)) {
        break label259;
      }
      if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
        a(localSocialAvatarData, paramArticleInfo.mSubscribeID);
      }
      label133:
      if (TextUtils.isEmpty(localSocialAvatarData.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          break label363;
        }
        a(localSocialAvatarData, paramArticleInfo.mSubscribeID);
      }
    }
    for (;;)
    {
      localSocialAvatarData.jdField_a_of_type_JavaLangString = ReadinjoyReportUtils.a(paramArticleInfo, localSocialAvatarData.jdField_a_of_type_JavaLangString, ReadinjoyReportUtils.e);
      QLog.d("OnSocialAvatarClickListener", 1, "uin = " + localSocialAvatarData.jdField_a_of_type_Long + " url = " + localSocialAvatarData.jdField_a_of_type_JavaLangString + " articleID = " + paramArticleInfo.mArticleID);
      return localSocialAvatarData;
      i = 0;
      break;
      label242:
      j = 0;
      break label59;
      label247:
      k = 0;
      break label68;
      label253:
      m = 0;
      break label95;
      label259:
      if ((bool2) || (j != 0))
      {
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
          break label133;
        }
        a(localSocialAvatarData, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        break label133;
      }
      if (((k == 0) && (!bool3) && (!bool4) && (m == 0) && (n == 0)) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null)) {
        break label133;
      }
      a(localSocialAvatarData, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      break label133;
      label363:
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)) {
        a(localSocialAvatarData, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      } else if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null)) {
        a(localSocialAvatarData, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramArticleInfo, paramInt);
    if (!TextUtils.isEmpty(localSocialAvatarData.jdField_a_of_type_JavaLangString))
    {
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      ReadInJoyUtils.a(paramContext, localSocialAvatarData.jdField_a_of_type_JavaLangString);
      a(paramArticleInfo, RIJFeedsType.b(paramArticleInfo), localSocialAvatarData.jdField_a_of_type_Long);
    }
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, long paramLong)
  {
    paramSocialAvatarData.jdField_a_of_type_Long = paramLong;
    paramSocialAvatarData.jdField_a_of_type_JavaLangString = (ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.jdField_a_of_type_Long).getBytes(), 2));
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, @NotNull String paramString)
  {
    try
    {
      paramSocialAvatarData.jdField_a_of_type_Long = Long.parseLong(paramString);
      paramSocialAvatarData.jdField_a_of_type_JavaLangString = (ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.jdField_a_of_type_Long).getBytes(), 2));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (RIJItemViewType.o(paramArticleInfo))
    {
      OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramArticleInfo, paramInt);
      a(paramArticleInfo, RIJFeedsType.b(paramArticleInfo), localSocialAvatarData.jdField_a_of_type_Long);
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, String paramString, long paramLong)
  {
    if (paramArticleInfo == null) {
      return;
    }
    Object localObject = "1";
    if (RIJItemViewType.g(paramArticleInfo))
    {
      localObject = "3";
      String str = RIJTransMergeKanDianReport.a((String)localObject, paramArticleInfo, paramLong);
      if (!ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {
        break label206;
      }
      localObject = "0X800935C";
      label43:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramLong), (String)localObject, (String)localObject, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject = RIJTransMergeKanDianReport.a();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
        paramString = RIJFeedsType.c(paramArticleInfo);
        if (!ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {
          break label214;
        }
        paramArticleInfo = "0X8009357";
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramArticleInfo, paramArticleInfo, 0, 0, paramString, "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        return;
      }
      if (!RIJItemViewType.a(paramArticleInfo)) {
        break;
      }
      localObject = "4";
      break;
      label206:
      localObject = "0X8007BA3";
      break label43;
      label214:
      paramArticleInfo = "0X800744D";
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID == 0L)) {
      RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER, 0, 0, 0), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialAvatarClickListener
 * JD-Core Version:    0.7.0.1
 */