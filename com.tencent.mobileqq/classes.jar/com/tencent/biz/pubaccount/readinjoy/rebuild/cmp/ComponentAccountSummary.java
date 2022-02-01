package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class ComponentAccountSummary
  extends FrameLayout
  implements ComponentView
{
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  private String a(@NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    String str = paramIReadInJoyModel.a().mSummary;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.g())) {
      str = paramIReadInJoyModel.a().mTitle;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (paramIReadInJoyModel.a() == 33) {
      return HardCodeUtil.a(2131702381);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.d()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.e())) {
      return HardCodeUtil.a(2131702384);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.g())) {
      return HardCodeUtil.a(2131702361);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.h()) {
      return HardCodeUtil.a(2131702372);
    }
    return HardCodeUtil.a(2131702386);
  }
  
  private void a(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
      QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
    }
    for (;;)
    {
      String str = HardCodeUtil.a(2131702343);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new ComponentAccountSummary.ReadArticleSpan(paramArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt), localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  private void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if ((paramIReadInJoyModel.a() == 33) && (paramIReadInJoyModel.a().mSocialFeedInfo != null) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null)) {
      if (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b == 0L)
      {
        paramIReadInJoyModel = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramIReadInJoyModel, -3355444), 0, paramString.length(), 33);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(": ");
      return;
      paramString = String.valueOf(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
      if (RIJQQAppInterfaceUtil.a())
      {
        str = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), paramString, true);
        paramIReadInJoyModel = paramString;
        paramString = str;
        break;
      }
      String str = paramIReadInJoyModel.a().a(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
      paramIReadInJoyModel = paramString;
      paramString = str;
      break;
      if (paramIReadInJoyModel.a().mAccountLess == 0)
      {
        paramIReadInJoyModel = paramIReadInJoyModel.a().mSubscribeID;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramIReadInJoyModel, -3355444), 0, paramString.length(), 33);
      }
      else
      {
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramString.length(), 33);
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
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
  
  private void b(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((this.jdField_a_of_type_Boolean) || (this.b))
    {
      a(paramSpannableStringBuilder, paramIReadInJoyModel);
      return;
    }
    if (this.c)
    {
      b(paramSpannableStringBuilder, paramIReadInJoyModel);
      return;
    }
    paramSpannableStringBuilder.append(paramString);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560268, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365176));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof IReadInJoyModel)) {}
    do
    {
      return;
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
    } while (paramObject.a() == null);
    String str1 = paramObject.a().mSubscribeName;
    String str2 = a(paramObject);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(paramObject, localSpannableStringBuilder, str1);
    b(paramObject, localSpannableStringBuilder, str2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702400));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentAccountSummary.MoreSpan(this, paramObject.a(), -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */