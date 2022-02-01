package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusUtil;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ExposedSubCommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil.PTSCommentModel;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommentRichTextView
  extends RichNativeText
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter;
  private CommentViewItem jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem;
  private ExposedSubCommentViewItem jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataExposedSubCommentViewItem;
  private int c = -1;
  
  public CommentRichTextView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
  }
  
  private void a()
  {
    QLog.d("CommentRichTextView", 2, "showAnchorAniation");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.jdField_a_of_type_AndroidViewView;
    } while (localView == null);
    QLog.d("CommentRichTextView", 2, "showAnchorAniation start");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new CommentRichTextView.2(this, localView));
    localValueAnimator.start();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  private void b()
  {
    this.mNative.setBackgroundResource(2130849759);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
  }
  
  private void c()
  {
    Object localObject = null;
    CommentViewItem localCommentViewItem;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataExposedSubCommentViewItem != null)
    {
      localCommentViewItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataExposedSubCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataExposedSubCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataSubCommentData;
    }
    for (;;)
    {
      if ((localObject != null) && (((BaseCommentData)localObject).commentRptDataList != null))
      {
        RIJCommentTopicUtil.PTSCommentModel localPTSCommentModel = new RIJCommentTopicUtil.PTSCommentModel();
        localPTSCommentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localPTSCommentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = ((BaseCommentData)localObject);
        this.mNative.setTag(2131376605, localPTSCommentModel);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem != null)
      {
        localCommentViewItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem;
        localObject = localCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      }
      else
      {
        localCommentViewItem = null;
      }
    }
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramReadinjoyCommentListBaseAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter = paramReadinjoyCommentListBaseAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem = paramCommentViewItem;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.mNative == null)) {
      return;
    }
    this.mNative.setOnClickListener(this);
    this.mNative.setOnLongClickListener(this);
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter == null) || (this.mNative == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mNative.isHyperLinkClick()) {
        this.mNative.setHyperLinkClick(false);
      } else if (this.c == -1) {
        b();
      } else {
        ((ReadInJoyCommentListAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, CommentProteusUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, this.c), 2);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter == null)) {
      return false;
    }
    if (this.c == -1)
    {
      RIJTransMergeKanDianReport.a("0X800824B");
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a(), this.mNative, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, new CommentRichTextView.1(this));
    }
    return true;
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    }
    int i = 0;
    if ((paramObject instanceof CommentViewItem))
    {
      a((CommentViewItem)paramObject);
      i = 1;
    }
    for (;;)
    {
      c();
      if (i == 0) {
        break;
      }
      return true;
      if ((paramObject instanceof ExposedSubCommentViewItem))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataExposedSubCommentViewItem = ((ExposedSubCommentViewItem)paramObject);
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentRichTextView
 * JD-Core Version:    0.7.0.1
 */