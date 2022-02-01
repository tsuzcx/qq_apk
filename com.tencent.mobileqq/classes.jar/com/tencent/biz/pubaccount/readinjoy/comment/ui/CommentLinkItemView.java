package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import otl;
import pay;

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
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131562668, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)findViewById(2131369285));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379700));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842821));
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842823));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842825));
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
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.iconUrl))
    {
      QLog.d("CommentLinkItemView", 2, "createLinkItemView | mLinkData setDefaultIcon");
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.type);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.wording);
      }
      setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.iconUrl);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl)))
    {
      QLog.d("CommentLinkItemView", 2, "linkItemView click url " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl);
      pay.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.linkUrl);
      otl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData$CommentLinkData.type);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkItemView
 * JD-Core Version:    0.7.0.1
 */