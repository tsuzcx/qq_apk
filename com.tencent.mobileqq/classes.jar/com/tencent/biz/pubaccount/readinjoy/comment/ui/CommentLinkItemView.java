package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan.Standard;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommentLinkItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseCommentData.CommentLinkData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData;
  private BaseCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public CommentLinkItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131562884, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)findViewById(2131369711));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380446));
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843007));
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843008));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843010));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843011));
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (TextUtils.isEmpty(paramCommentLinkData.iconUrl))
    {
      QLog.d("CommentLinkItemView", 2, "createLinkItemView | mLinkData setDefaultIcon");
      a(paramCommentLinkData.type);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(paramCommentLinkData.iconUrl);
  }
  
  private void b(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramCommentLinkData != null))
    {
      paramCommentLinkData = new SpannableString(paramCommentLinkData.wording);
      paramCommentLinkData.setSpan(new LeadingMarginSpan.Standard(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), 0), 0, paramCommentLinkData.length(), 18);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCommentLinkData);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((paramCommentLinkData == null) || (paramBaseCommentData == null) || (paramArticleInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData = paramCommentLinkData;
    QLog.d("CommentLinkItemView", 2, "createLinkItemView | mLinkData " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData);
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl)))
    {
      QLog.d("CommentLinkItemView", 2, "linkItemView click url " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.type != 4) {
        break label114;
      }
      RIJJumpUtils.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl, 2104, new CommentLinkItemView.1(this));
    }
    for (;;)
    {
      ReadInJoyCommentReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.type);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label114:
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkItemView
 * JD-Core Version:    0.7.0.1
 */