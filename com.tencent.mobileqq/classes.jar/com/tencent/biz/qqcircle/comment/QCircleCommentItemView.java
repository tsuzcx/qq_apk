package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleCommentReplyAdapter;
import com.tencent.biz.qqcircle.beans.QCircleCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.comment.DateUtils;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;

public class QCircleCommentItemView
  extends QCircleBaseWidgetView<QCircleCommentItemInfo>
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private int a;
  private OnCommentElementClickListener b;
  private RelativeLayout c;
  private QCircleAvatarView d;
  private QCircleAsyncTextView e;
  private QCircleAsyncTextView f;
  private FeedCloudMeta.StFeed g;
  private QCircleCommentItemInfo h;
  private FeedCloudMeta.StComment i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private QCircleCommentPraiseLayout n;
  private TextView o;
  private LinearLayout p;
  private RecyclerView q;
  private QCircleCommentReplyAdapter r;
  
  public QCircleCommentItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.f.setOnLongClickListener(this);
    this.c.setOnLongClickListener(this);
    QCircleCommentItemView.1 local1 = new QCircleCommentItemView.1(this, getContext(), 1, false);
    this.q.setLayoutManager(local1);
    this.q.setItemAnimator(new EnhanceItemAnimator());
  }
  
  private void a(FeedCloudMeta.StComment paramStComment)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramStComment.content.get());
    if (paramStComment.typeFlag.get() == 1)
    {
      if (this.l == null)
      {
        this.l = QCircleSkinHelper.getInstance().getDrawable(2130845331);
        this.l.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(30.0F), ImmersiveUtils.a(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.l);
      this.f.a(true);
    }
    else if (QCircleCommentHelper.a(paramStComment.typeFlag2.get(), 4))
    {
      if (this.m == null)
      {
        this.m = getResources().getDrawable(2130845085);
        this.m.setBounds(ImmersiveUtils.a(2.5F), ImmersiveUtils.a(0.0F), ImmersiveUtils.a(42.5F), ImmersiveUtils.a(16.0F));
      }
      a(9, 1);
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.m);
      this.f.a(true);
    }
    else if (paramStComment.likeInfo.ownerStatus.get() == 1)
    {
      if (this.k == null)
      {
        this.k = QCircleSkinHelper.getInstance().getDrawable(2130845330);
        this.k.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(47.0F), ImmersiveUtils.a(15.5F));
      }
      this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.k);
      this.f.a(true);
    }
    else
    {
      this.f.a(false);
    }
    this.f.setOnClickAtTextListener(new QCircleCommentItemView.3(this));
    this.f.setText(localSpannableStringBuilder);
  }
  
  private void b()
  {
    Object localObject = this.i;
    if ((localObject != null) && (this.g != null))
    {
      QCircleAvatarView localQCircleAvatarView = this.d;
      if (localQCircleAvatarView == null) {
        return;
      }
      localQCircleAvatarView.setUser(((FeedCloudMeta.StComment)localObject).postUser);
      localObject = new SpannableStringBuilder(this.i.postUser.nick.get());
      if (!this.i.postUser.id.get().equals(this.g.poster.id.get()))
      {
        this.e.a(false);
        this.e.setText((CharSequence)localObject);
        return;
      }
      if (this.j == null)
      {
        this.j = QCircleSkinHelper.getInstance().getDrawable(2130845329);
        this.j.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(30.0F), ImmersiveUtils.a(15.5F));
      }
      this.e.a((SpannableStringBuilder)localObject, ((SpannableStringBuilder)localObject).length(), this.j);
      this.e.a(true);
      this.e.setText((CharSequence)localObject);
    }
  }
  
  private void c()
  {
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout = this.n;
    if (localQCircleCommentPraiseLayout == null) {
      return;
    }
    localQCircleCommentPraiseLayout.setData(1, this.g, this.i, null, true);
    this.n.setOnClickHookListener(new QCircleCommentItemView.2(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = getExtraTypeInfo() instanceof QCircleExtraTypeInfo;
    QCircleLpReportDc05501.DataBuilder localDataBuilder = null;
    QCircleExtraTypeInfo localQCircleExtraTypeInfo;
    if (bool)
    {
      localQCircleExtraTypeInfo = (QCircleExtraTypeInfo)getExtraTypeInfo();
      localObject2 = localQCircleExtraTypeInfo.mFeed;
    }
    else
    {
      localQCircleExtraTypeInfo = null;
      localObject2 = localQCircleExtraTypeInfo;
    }
    Object localObject1 = localDataBuilder;
    if (localObject2 != null)
    {
      localObject1 = localDataBuilder;
      if (((FeedCloudMeta.StFeed)localObject2).busiReport != null)
      {
        localObject1 = localDataBuilder;
        if (((FeedCloudMeta.StFeed)localObject2).busiReport.has())
        {
          localObject1 = localDataBuilder;
          if (((FeedCloudMeta.StFeed)localObject2).busiReport.get() != null) {
            localObject1 = ((FeedCloudMeta.StFeed)localObject2).busiReport.get().toByteArray();
          }
        }
      }
    }
    localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject2).setActionType(paramInt1).setSubActionType(paramInt2);
    if (localObject2 != null) {
      localObject2 = ((FeedCloudMeta.StFeed)localObject2).poster.id.get();
    } else {
      localObject2 = "";
    }
    Object localObject2 = localDataBuilder.setToUin((String)localObject2);
    if (localQCircleExtraTypeInfo != null) {
      paramInt1 = localQCircleExtraTypeInfo.mDataPosition;
    } else {
      paramInt1 = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject2).setIndex(paramInt1).setPageId(getPageId())).setReportInfo((byte[])localObject1));
  }
  
  public void a(QCircleCommentItemInfo paramQCircleCommentItemInfo, int paramInt)
  {
    if ((this.g != null) && (paramQCircleCommentItemInfo != null))
    {
      if (paramQCircleCommentItemInfo.a == null) {
        return;
      }
      this.a = paramInt;
      this.h = paramQCircleCommentItemInfo;
      this.i = paramQCircleCommentItemInfo.a;
      b();
      c();
      a(this.i);
      this.o.setText(DateUtils.a(this.i.createTime.get() * 1000L));
      if ((this.h.b != null) && (this.h.b.size() != 0))
      {
        this.p.setVisibility(0);
        if (this.r == null)
        {
          this.r = new QCircleCommentReplyAdapter();
          this.q.setAdapter(this.r);
        }
        this.r.a(this.g, this.i, this.h.b, this.a);
        this.r.a(this.b);
        this.r.notifyDataSetChanged();
        return;
      }
      this.p.setVisibility(8);
    }
  }
  
  public FeedCloudMeta.StComment getComment()
  {
    return this.i;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626774;
  }
  
  protected String getLogTag()
  {
    return "QCircleCommentItemView";
  }
  
  public QCircleCommentReplyAdapter getReplyAdapter()
  {
    return this.r;
  }
  
  public RecyclerView getRvReplyList()
  {
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    OnCommentElementClickListener localOnCommentElementClickListener;
    FeedCloudMeta.StComment localStComment;
    if (i1 == 2131428988)
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.i;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 1, this.a, localStComment.postUser);
        }
      }
    }
    else if (i1 == 2131440558)
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.i;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.a, localStComment.postUser);
        }
      }
    }
    else if ((i1 == 2131440538) || (i1 == 2131431066))
    {
      localOnCommentElementClickListener = this.b;
      if (localOnCommentElementClickListener != null) {
        localOnCommentElementClickListener.a(paramView, 4, this.a, this.i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = ((RelativeLayout)paramView.findViewById(2131431066));
    this.p = ((LinearLayout)paramView.findViewById(2131444639));
    this.d = ((QCircleAvatarView)paramView.findViewById(2131428988));
    this.e = ((QCircleAsyncTextView)paramView.findViewById(2131440558));
    this.f = ((QCircleAsyncTextView)paramView.findViewById(2131440538));
    this.n = ((QCircleCommentPraiseLayout)paramView.findViewById(2131440580));
    this.o = ((TextView)paramView.findViewById(2131431073));
    this.q = ((RecyclerView)paramView.findViewById(2131444647));
    a();
  }
  
  public boolean onLongClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131440538) && (i1 != 2131431066)) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.b;
    if (localOnCommentElementClickListener != null) {
      localOnCommentElementClickListener.b(paramView, 5, this.a, this.i);
    }
    return true;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) && (this.g != null) && (this.i != null))
    {
      paramSimpleBaseEvent = (QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (!TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.g.id.get())) {
        return;
      }
      if ((paramSimpleBaseEvent.mType == 1) && (TextUtils.equals(paramSimpleBaseEvent.mCommentId, this.i.id.get())))
      {
        if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.g.poster.get())) {
          this.i.likeInfo.ownerStatus.set(paramSimpleBaseEvent.mPraisedStatus);
        }
        this.i.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.i.likeInfo.count.set(paramSimpleBaseEvent.mPraisedNum);
        a(this.i);
      }
    }
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.g = paramStFeed;
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.b = paramOnCommentElementClickListener;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout = this.n;
    if (localQCircleCommentPraiseLayout != null) {
      localQCircleCommentPraiseLayout.setReportBean(paramQCircleReportBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentItemView
 * JD-Core Version:    0.7.0.1
 */