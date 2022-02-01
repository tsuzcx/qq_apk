package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.text.UserSpan;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observable;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, Observer<CharSequence>
{
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  private Observable<CharSequence> jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    int i = 0;
    String str = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString;
    if (RIJFeedsType.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo))
    {
      a(paramArticleInfo, paramSpannableStringBuilder, paramRefreshUserInfoCallBack);
      i = 4;
    }
    do
    {
      return i;
      if ((CmpCtxt.c(paramArticleInfo)) && (!RIJItemViewType.q(paramArticleInfo))) {
        return 5;
      }
    } while (TextUtils.isEmpty(str));
    a(str, paramSpannableStringBuilder);
    return 6;
  }
  
  private static int a(ArticleInfo paramArticleInfo, IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = RIJItemViewType.a(paramArticleInfo);
    if (paramIReadInJoyModel.a().isPGCShortContent())
    {
      a(paramArticleInfo, paramSpannableStringBuilder);
      return 7;
    }
    if ((35 == i) || (34 == i))
    {
      b(paramArticleInfo, paramSpannableStringBuilder);
      return 1;
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {}
      for (paramIReadInJoyModel = paramArticleInfo.mSummary;; paramIReadInJoyModel = "")
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
          paramIReadInJoyModel = paramArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(paramIReadInJoyModel);
        return 2;
      }
    }
    a(paramArticleInfo, paramSpannableStringBuilder, paramIReadInJoyModel);
    return 3;
  }
  
  private static String a(@NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.a() == 33) {
      return HardCodeUtil.a(2131707093);
    }
    if ((CmpCtxt.e(paramIReadInJoyModel)) || (CmpCtxt.g(paramIReadInJoyModel)) || (CmpCtxt.h(paramIReadInJoyModel))) {
      return HardCodeUtil.a(2131707091);
    }
    if ((CmpCtxt.f(paramIReadInJoyModel)) || (CmpCtxt.i(paramIReadInJoyModel))) {
      return HardCodeUtil.a(2131707089);
    }
    if (CmpCtxt.a(paramIReadInJoyModel)) {
      return HardCodeUtil.a(2131707090);
    }
    return HardCodeUtil.a(2131707088);
  }
  
  public static void a(int paramInt, IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramIReadInJoyModel.a();
    if (!RIJItemViewType.a((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((RIJItemViewType.d((ArticleInfo)localObject)) || (RIJItemViewType.h((BaseArticleInfo)localObject)) || (RIJItemViewType.a(paramIReadInJoyModel.a())) || (RIJItemViewType.a((BaseArticleInfo)localObject)))
    {
      localObject = paramIReadInJoyModel.a().mSubscribeName;
      if ((paramIReadInJoyModel.a() == 33) && (paramIReadInJoyModel.a().mSocialFeedInfo != null) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null))
      {
        if (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b == 0L)
        {
          paramRefreshUserInfoCallBack = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        try
        {
          l2 = Long.valueOf(paramRefreshUserInfoCallBack).longValue();
          l1 = l2;
        }
        catch (NumberFormatException paramRefreshUserInfoCallBack)
        {
          for (;;)
          {
            paramRefreshUserInfoCallBack.printStackTrace();
          }
        }
        localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(": ");
      }
    }
    while ((!RIJItemViewType.f((ArticleInfo)localObject)) || (!RIJItemViewType.i((ArticleInfo)localObject))) {
      for (;;)
      {
        long l2;
        paramSpannableStringBuilder.append(new SpannableStringBuilder(new QQText(localSpannableStringBuilder, 3, 16)));
        return;
        paramRefreshUserInfoCallBack = String.valueOf(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
        if (RIJQQAppInterfaceUtil.a())
        {
          localObject = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), paramRefreshUserInfoCallBack, true);
        }
        else
        {
          localObject = paramIReadInJoyModel.a().a(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
          continue;
          if (paramIReadInJoyModel.a().mAccountLess == 0)
          {
            paramRefreshUserInfoCallBack = paramIReadInJoyModel.a().mSubscribeID;
            try
            {
              l2 = Long.valueOf(paramRefreshUserInfoCallBack).longValue();
              l1 = l2;
            }
            catch (NumberFormatException paramRefreshUserInfoCallBack)
            {
              for (;;)
              {
                paramRefreshUserInfoCallBack.printStackTrace();
              }
            }
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
            continue;
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
        }
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
    paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a(l1, paramRefreshUserInfoCallBack);
    if (paramRefreshUserInfoCallBack != null) {}
    for (paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack.nick;; paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a())
    {
      if (!TextUtils.isEmpty(paramRefreshUserInfoCallBack))
      {
        localSpannableStringBuilder.append(RIJStringUtils.a(paramRefreshUserInfoCallBack));
        localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      if (RIJFeedsType.q((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, ArticleInfo paramArticleInfo)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramArticleInfo.mTitle)) {
      str = paramArticleInfo.mTitle;
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(str);
      return;
      if (!TextUtils.isEmpty(paramArticleInfo.mSummary)) {
        str = paramArticleInfo.mSummary;
      }
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable = paramIReadInJoyModel.a().articleViewModel.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(this);
    setText((CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a());
    a(paramIReadInJoyModel.a());
  }
  
  public static void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    int j = 0;
    if (ArticleInfoHelper.a(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(paramIReadInJoyModel);
    int i;
    if (RIJItemViewType.a(localArticleInfo))
    {
      a(paramSpannableStringBuilder, localArticleInfo);
      i = j;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      if ((RIJItemViewType.d(localArticleInfo)) || (RIJItemViewType.h(localArticleInfo)) || (RIJItemViewType.a(paramIReadInJoyModel.a())))
      {
        i = a(localArticleInfo, paramIReadInJoyModel, paramSpannableStringBuilder, bool);
      }
      else
      {
        i = j;
        if (RIJItemViewType.f(localArticleInfo))
        {
          i = j;
          if (RIJItemViewType.i(localArticleInfo)) {
            i = a(localArticleInfo, paramSpannableStringBuilder, paramRefreshUserInfoCallBack);
          }
        }
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {
      setSpanText(HardCodeUtil.a(2131707092));
    }
    setMaxLines(a(paramArticleInfo));
    setMoreSpan(new NativeSummaryView.MoreSpan(this, paramArticleInfo, this.b));
    if ((RIJFeedsType.l(paramArticleInfo)) || (RIJFeedsType.m(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.b);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((RIJFeedsType.c(paramArticleInfo)) || (RIJFeedsType.d(paramArticleInfo)))
    {
      RIJJumpUtils.a(paramContext, paramArticleInfo, 1, false, 4, false);
      RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      RIJFrameworkReportManager.c(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString))) {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(paramArticleInfo);
      return;
      if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mTitle))) {
        paramArticleInfo = paramArticleInfo.mTitle;
      } else {
        paramArticleInfo = "";
      }
    }
  }
  
  private static void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    String str1 = paramIReadInJoyModel.a().mSummary;
    if ((CmpCtxt.f(paramIReadInJoyModel)) || (CmpCtxt.i(paramIReadInJoyModel))) {
      str1 = paramIReadInJoyModel.a().mTitle;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = a(paramIReadInJoyModel);
    }
    paramSpannableStringBuilder.append(str2);
    if ((paramIReadInJoyModel.a() == 33) && (!RIJItemViewType.l(paramArticleInfo)))
    {
      paramIReadInJoyModel = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
      paramSpannableStringBuilder = paramSpannableStringBuilder.append("“");
      if (!TextUtils.isEmpty(paramIReadInJoyModel.c)) {
        break label146;
      }
      paramArticleInfo = "";
      paramSpannableStringBuilder = paramSpannableStringBuilder.append(paramArticleInfo);
      if (!TextUtils.isEmpty(paramIReadInJoyModel.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
    }
    label146:
    label154:
    for (paramArticleInfo = "";; paramArticleInfo = paramIReadInJoyModel.jdField_a_of_type_JavaLangString)
    {
      paramSpannableStringBuilder.append(paramArticleInfo).append("”");
      return;
      paramArticleInfo = paramIReadInJoyModel.c;
      break;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a(paramArticleInfo, "2", paramRefreshUserInfoCallBack);
    if (!TextUtils.isEmpty(paramArticleInfo)) {
      paramSpannableStringBuilder.append(paramArticleInfo);
    }
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new QQText(EmotionCodecUtils.b(paramString), 3, 16));
  }
  
  private static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null) {}
    switch (paramIReadInJoyModel.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramObservable));
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.b(this);
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramIReadInJoyModel);
    setShouldCallClick(false);
    switch (paramIReadInJoyModel.a())
    {
    }
    for (;;)
    {
      a(paramIReadInJoyModel);
      return;
      setShouldCallClick(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */