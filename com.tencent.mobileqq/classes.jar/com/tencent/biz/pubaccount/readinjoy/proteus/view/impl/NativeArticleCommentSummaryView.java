package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class NativeArticleCommentSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView
{
  CmpCtxt a;
  private final boolean b = false;
  private final boolean c = false;
  
  public NativeArticleCommentSummaryView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((ReadInJoyUtils.b(paramArticleInfo)) || (ReadInJoyUtils.c(paramArticleInfo)))
    {
      ReadInJoyUtils.a(paramContext, paramArticleInfo, 1, false, 4, false);
      ReadInJoyBaseAdapter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      ReadInJoyUtils.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = paramIReadInJoyModel.a().mSubscribeName;
    if ((paramIReadInJoyModel.a() == 33) && (paramIReadInJoyModel.a().mSocialFeedInfo != null) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null)) {
      if (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b == 0L)
      {
        paramIReadInJoyModel = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a;
        paramSpannableStringBuilder.append((CharSequence)localObject);
        paramSpannableStringBuilder.setSpan(new NativeArticleCommentSummaryView.UserSpan(this, paramIReadInJoyModel, -3355444), 0, ((String)localObject).length(), 33);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(": ");
      return;
      localObject = String.valueOf(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
      if (ReadInJoyUtils.a())
      {
        str = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), (String)localObject, true);
        paramIReadInJoyModel = (IReadInJoyModel)localObject;
        localObject = str;
        break;
      }
      String str = paramIReadInJoyModel.a().b(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
      paramIReadInJoyModel = (IReadInJoyModel)localObject;
      localObject = str;
      break;
      if (paramIReadInJoyModel.a().mAccountLess == 0)
      {
        paramIReadInJoyModel = paramIReadInJoyModel.a().mSubscribeID;
        paramSpannableStringBuilder.append((CharSequence)localObject);
        paramSpannableStringBuilder.setSpan(new NativeArticleCommentSummaryView.UserSpan(this, paramIReadInJoyModel, -3355444), 0, ((String)localObject).length(), 33);
      }
      else
      {
        paramSpannableStringBuilder.append((CharSequence)localObject);
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, ((String)localObject).length(), 33);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void b(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject1 = paramIReadInJoyModel.a();
    int i = ReadInJoyBaseAdapter.c((ArticleInfo)localObject1);
    Object localObject2;
    if ((35 != i) && (34 != i))
    {
      localObject2 = paramIReadInJoyModel.a().mSummary;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (paramIReadInJoyModel.a() != 33) {
          break label311;
        }
        localObject1 = "发布了话题";
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append((CharSequence)localObject1);
      setSpanText("更多");
      setMaxLines(7);
      setMoreSpan(new NativeArticleCommentSummaryView.MoreSpan(this, paramIReadInJoyModel.a(), -3355444));
      return;
      localObject2 = new SpannableStringBuilder();
      if ((((ArticleInfo)localObject1).mSocialFeedInfo != null) && (((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null))
      {
        ((SpannableStringBuilder)localObject2).append(((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
        }
      }
      for (;;)
      {
        ((SpannableStringBuilder)localObject2).append(" ");
        ((SpannableStringBuilder)localObject2).append("阅读原文");
        ((SpannableStringBuilder)localObject2).setSpan(new NativeArticleCommentSummaryView.ReadArticleSpan((ArticleInfo)localObject1, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt), ((SpannableStringBuilder)localObject2).length() - "阅读原文".length(), ((SpannableStringBuilder)localObject2).length(), 33);
        ((SpannableStringBuilder)localObject2).append(" ");
        paramSpannableStringBuilder.append((CharSequence)localObject2);
        this.jdField_a_of_type_Boolean = true;
        break;
        if (((ArticleInfo)localObject1).mTitle != null) {
          ((SpannableStringBuilder)localObject2).append(((ArticleInfo)localObject1).mTitle);
        }
      }
      label311:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.d()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.e())) {
        localObject1 = "发布了文章";
      } else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.g())) {
        localObject1 = "发布了视频";
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.h()) {
        localObject1 = "发布了图集";
      } else {
        localObject1 = "发布了文章";
      }
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramIReadInJoyModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeArticleCommentSummaryView
 * JD-Core Version:    0.7.0.1
 */