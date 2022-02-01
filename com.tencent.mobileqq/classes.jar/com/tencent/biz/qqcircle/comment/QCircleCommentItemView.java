package com.tencent.biz.qqcircle.comment;

import aaak;
import aaam;
import aajo;
import aakb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import uzg;
import uzn;
import vat;
import vkq;
import vkr;
import vks;
import zzl;

public class QCircleCommentItemView
  extends QCircleBaseWidgetView<vat>
  implements aaam, View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private aakb jdField_a_of_type_Aakb;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleCommentPraiseLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private uzn jdField_a_of_type_Uzn;
  private vat jdField_a_of_type_Vat;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private QCircleAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private Drawable c;
  
  public QCircleCommentItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
    vkq localvkq = new vkq(this, getContext(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localvkq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(new zzl());
  }
  
  private void a(FeedCloudMeta.StComment paramStComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.content.get());
    if (paramStComment.typeFlag.get() == 1)
    {
      if (this.c == null)
      {
        this.c = getResources().getDrawable(2130843927);
        this.c.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(28.0F), ImmersiveUtils.a(15.5F));
      }
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.c);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vks(this));
      return;
      if (paramStComment.likeInfo.ownerStatus.get() == 1)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843926);
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(46.0F), ImmersiveUtils.a(15.5F));
        }
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
      }
      else
      {
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(false);
      }
    }
  }
  
  public int a()
  {
    return 2131560695;
  }
  
  public RecyclerView a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  }
  
  public FeedCloudMeta.StComment a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  }
  
  public String a()
  {
    return "QCircleCommentItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364804));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376516));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131363109));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131372916));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131372901));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout = ((QCircleCommentPraiseLayout)paramView.findViewById(2131372927));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364811));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376523));
    a();
  }
  
  protected void a(vat paramvat) {}
  
  public void a(vat paramvat, int paramInt)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (paramvat == null) || (paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vat = paramvat;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramvat.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get() != null))
    {
      if ((getContext() instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
      }
      paramvat = new SpannableStringBuilder(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get());
      if (!this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get())) {
        break label397;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843925);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(28.0F), ImmersiveUtils.a(15.5F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(paramvat, paramvat.length(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramvat);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setData(1, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, null, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setOnClickHookListener(new vkr(this));
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(aajo.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get() * 1000L));
      if ((this.jdField_a_of_type_Vat.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Vat.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_Uzn == null) {
        this.jdField_a_of_type_Uzn = new uzn();
      }
      this.jdField_a_of_type_Uzn.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vat.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Uzn.a(this.jdField_a_of_type_Aakb);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uzn);
      return;
      label397:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(false);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    aaak.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Aakb != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
      {
        this.jdField_a_of_type_Aakb.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
        continue;
        if ((this.jdField_a_of_type_Aakb != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null))
        {
          this.jdField_a_of_type_Aakb.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser);
          continue;
          if (this.jdField_a_of_type_Aakb != null) {
            this.jdField_a_of_type_Aakb.a(paramView, 4, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
          }
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_Aakb != null) {
      this.jdField_a_of_type_Aakb.b(paramView, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
    }
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mFeedId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()))) {}
    while ((((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mType != 1) || (!TextUtils.equals(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mCommentId, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()))) {
      return;
    }
    if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedStatus);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent).mPraisedNum);
    a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void setOnCommentElementClickListener(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.setReportBean(paramQCircleReportBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView
 * JD-Core Version:    0.7.0.1
 */