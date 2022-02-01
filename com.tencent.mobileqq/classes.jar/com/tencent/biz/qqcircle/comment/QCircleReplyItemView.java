package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleReplyItemInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.comment.DateUtils;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleReplyItemView
  extends QCircleBaseWidgetView<QCircleReplyItemInfo>
  implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver
{
  private static final String a = HardCodeUtil.a(2131910888);
  private int b;
  private int c;
  private OnCommentElementClickListener d;
  private QCircleAsyncTextView e;
  private QCircleAsyncTextView f;
  private FeedCloudMeta.StFeed g;
  private FeedCloudMeta.StComment h;
  private FeedCloudMeta.StReply i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private QCircleCommentPraiseLayout m;
  private QCircleAvatarView n;
  private TextView o;
  
  public QCircleReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.n.setOnClickListener(this);
    setOnClickListener(this);
    this.f.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  private void a(FeedCloudMeta.StReply paramStReply)
  {
    if (this.g != null)
    {
      if (paramStReply == null) {
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((paramStReply.targetUser != null) && (!TextUtils.isEmpty(paramStReply.targetUser.id.get())))
      {
        localSpannableStringBuilder.append(a).append(paramStReply.targetUser.nick.get());
        this.f.a(localSpannableStringBuilder, a.length(), a.length() + paramStReply.targetUser.nick.get().length(), new QCircleReplyItemView.2(this, paramStReply));
        if (paramStReply.targetUser.id.get().equals(this.g.poster.id.get()))
        {
          e();
          this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.j);
        }
        localSpannableStringBuilder.append("：");
      }
      localSpannableStringBuilder.append(paramStReply.content.get());
      if (paramStReply.typeFlag.get() == 1)
      {
        f();
        this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.l);
        this.f.a(true);
      }
      else if (paramStReply.likeInfo.ownerStatus.get() == 1)
      {
        d();
        this.f.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.k);
        this.f.a(true);
      }
      else
      {
        this.f.a(false);
      }
      this.f.setOnClickAtTextListener(new QCircleReplyItemView.3(this));
      this.f.setText(localSpannableStringBuilder);
    }
  }
  
  private void a(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    QCircleLauncher.b(getContext(), localQCircleInitBean);
  }
  
  private void b()
  {
    Object localObject = this.i;
    if ((localObject != null) && (this.g != null))
    {
      if (this.e == null) {
        return;
      }
      localObject = new SpannableStringBuilder(((FeedCloudMeta.StReply)localObject).postUser.nick.get());
      if (!this.i.postUser.id.get().equals(this.g.poster.id.get()))
      {
        this.e.a(false);
        this.e.setText((CharSequence)localObject);
        return;
      }
      e();
      this.e.a((SpannableStringBuilder)localObject, ((SpannableStringBuilder)localObject).length(), this.j);
      this.e.a(true);
      this.e.setText((CharSequence)localObject);
    }
  }
  
  private void c()
  {
    QCircleCommentPraiseLayout localQCircleCommentPraiseLayout = this.m;
    if (localQCircleCommentPraiseLayout == null) {
      return;
    }
    localQCircleCommentPraiseLayout.setData(2, this.g, this.h, this.i, true);
    this.m.setOnClickHookListener(new QCircleReplyItemView.1(this));
  }
  
  private void d()
  {
    if (this.k == null)
    {
      this.k = QCircleSkinHelper.getInstance().getDrawable(2130845330);
      this.k.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(47.0F), ImmersiveUtils.a(15.5F));
    }
  }
  
  private void e()
  {
    if (this.j == null)
    {
      this.j = QCircleSkinHelper.getInstance().getDrawable(2130845329);
      this.j.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(30.0F), ImmersiveUtils.a(15.5F));
    }
  }
  
  private void f()
  {
    if (this.l == null)
    {
      this.l = QCircleSkinHelper.getInstance().getDrawable(2130845331);
      this.l.setBounds(ImmersiveUtils.a(2.0F), ImmersiveUtils.a(1.5F), ImmersiveUtils.a(30.0F), ImmersiveUtils.a(15.5F));
    }
  }
  
  public void a(QCircleReplyItemInfo paramQCircleReplyItemInfo, int paramInt)
  {
    if ((this.g != null) && (this.h != null) && (paramQCircleReplyItemInfo != null))
    {
      if (paramQCircleReplyItemInfo.b == null) {
        return;
      }
      this.c = paramInt;
      this.i = paramQCircleReplyItemInfo.b;
      this.n.setUser(this.i.postUser);
      b();
      this.o.setText(DateUtils.a(this.i.createTime.get() * 1000L));
      a(this.i);
      c();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626955;
  }
  
  protected String getLogTag()
  {
    return "QCircleReplyItemView";
  }
  
  public FeedCloudMeta.StReply getReply()
  {
    return this.i;
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
    if (i1 == 2131428988)
    {
      localOnCommentElementClickListener = this.d;
      if ((localOnCommentElementClickListener != null) && (this.h != null)) {
        localOnCommentElementClickListener.a(paramView, 1, this.c, this.i.postUser);
      }
    }
    else
    {
      Object localObject;
      if (i1 == 2131444654)
      {
        localOnCommentElementClickListener = this.d;
        if (localOnCommentElementClickListener != null)
        {
          localObject = this.i;
          if (localObject != null) {
            localOnCommentElementClickListener.a(paramView, 2, this.b, ((FeedCloudMeta.StReply)localObject).postUser);
          }
        }
      }
      else
      {
        FeedCloudMeta.StReply localStReply;
        if (i1 == 2131444652)
        {
          localOnCommentElementClickListener = this.d;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.h;
            localStReply = this.i;
            localOnCommentElementClickListener.a(paramView, 7, this.b, new Object[] { localObject, localStReply });
          }
        }
        else if ((paramView instanceof QCircleReplyItemView))
        {
          localOnCommentElementClickListener = this.d;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.h;
            localStReply = this.i;
            localOnCommentElementClickListener.a(paramView, 7, this.b, new Object[] { localObject, localStReply });
          }
        }
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
    this.e = ((QCircleAsyncTextView)paramView.findViewById(2131444654));
    this.f = ((QCircleAsyncTextView)paramView.findViewById(2131444652));
    this.m = ((QCircleCommentPraiseLayout)paramView.findViewById(2131440580));
    this.n = ((QCircleAvatarView)paramView.findViewById(2131428988));
    this.o = ((TextView)paramView.findViewById(2131448705));
    a();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131444652)
    {
      OnCommentElementClickListener localOnCommentElementClickListener = this.d;
      if (localOnCommentElementClickListener != null)
      {
        FeedCloudMeta.StComment localStComment = this.h;
        FeedCloudMeta.StReply localStReply = this.i;
        localOnCommentElementClickListener.b(paramView, 8, this.b, new Object[] { localStComment, localStReply });
      }
      return true;
    }
    return false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) && (this.g != null) && (this.h != null) && (this.i != null))
    {
      paramSimpleBaseEvent = (QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent;
      if (!TextUtils.equals(paramSimpleBaseEvent.mFeedId, this.g.id.get())) {
        return;
      }
      if ((paramSimpleBaseEvent.mType == 2) && (TextUtils.equals(paramSimpleBaseEvent.mCommentId, this.h.id.get())) && (TextUtils.equals(paramSimpleBaseEvent.mReplyId, this.i.id.get())))
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
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.d = paramOnCommentElementClickListener;
  }
  
  public void setPreData(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    this.g = paramStFeed;
    this.h = paramStComment;
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleReplyItemView
 * JD-Core Version:    0.7.0.1
 */