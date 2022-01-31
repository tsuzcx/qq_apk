package com.tencent.biz.qqcircle.widgets;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import bdcd;
import bdfq;
import bhrf;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import tqt;
import tra;
import trr;
import trs;
import ttv;
import tuk;
import tyg;
import tyk;
import tym;
import uai;
import uaj;
import uak;
import ual;
import uam;
import uan;
import uau;
import uax;
import yej;
import yel;

public class QCircleFeedCommentWidget
  extends BaseWidgetView<trs>
  implements View.OnClickListener, View.OnLongClickListener, yel
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  bhrf jdField_a_of_type_Bhrf = new uax(this);
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private trs jdField_a_of_type_Trs;
  private Drawable b;
  
  public QCircleFeedCommentWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private ttv a()
  {
    if (((a() instanceof trr)) && (((trr)a()).a() != null)) {
      return ((trr)a()).a().a();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (tym.a().c(57))
    {
      tyk.a(paramInt, 2, a());
      return;
    }
    tyg.a(paramInt, 2, a());
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    a(62);
    tqt.a().a(paramView, paramStFeed, paramStComment, new uan(this, paramStFeed, paramStComment), this.jdField_a_of_type_Bhrf);
  }
  
  private void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    tqt.a().a(paramView, paramStFeed, paramStReply, new uau(this, paramStReply, paramStFeed, paramStComment), this.jdField_a_of_type_Bhrf);
  }
  
  private void a(QCircleCommentPraiseUpdateEvent paramQCircleCommentPraiseUpdateEvent)
  {
    if ((this.jdField_a_of_type_Trs == null) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!TextUtils.equals(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), paramQCircleCommentPraiseUpdateEvent.mFeedId))) {}
    do
    {
      do
      {
        return;
        if ((paramQCircleCommentPraiseUpdateEvent.mType != 1) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null)) {
          break;
        }
      } while (!TextUtils.equals(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId));
      if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
        this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      }
      this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
      this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
      setCommentTxt(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while ((paramQCircleCommentPraiseUpdateEvent.mType != 2) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!TextUtils.equals(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get(), paramQCircleCommentPraiseUpdateEvent.mCommentId)) || (!TextUtils.equals(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get(), paramQCircleCommentPraiseUpdateEvent.mReplyId)));
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
      this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.ownerStatus.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    }
    this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.status.set(paramQCircleCommentPraiseUpdateEvent.mPraisedStatus);
    this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.likeInfo.count.set(paramQCircleCommentPraiseUpdateEvent.mPraisedNum);
    setReplyTxt(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  private void a(QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if (paramQCircleAsyncTextView != null)
    {
      paramQCircleAsyncTextView.b();
      paramQCircleAsyncTextView.setText("");
      paramQCircleAsyncTextView.setVisibility(8);
    }
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (a()) {}
    while ((!(a() instanceof trr)) || (((trr)a()).a() == null)) {
      return;
    }
    trr localtrr = (trr)a();
    localtrr.a().a(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    localtrr.a().a(a());
    localtrr.a().a(localtrr.a());
    localtrr.a().a(paramStComment, paramStReply);
    if ((paramStComment == null) && (paramStReply == null))
    {
      tyg.a(6, 2, a());
      return;
    }
    tyg.a(9, 2, a());
    localtrr.a().a(9);
  }
  
  private void b()
  {
    int i;
    if ((a() != null) && (getContext() != null) && (a() != null))
    {
      if (a().sourceType != 6) {
        break label78;
      }
      i = 1;
      if (i == 0) {
        break label83;
      }
    }
    label78:
    label83:
    for (String str = alpo.a(2131698328);; str = alpo.a(2131698329))
    {
      bdcd.a(getContext(), 230, "", str, new ual(this), new uam(this)).show();
      return;
      i = 0;
      break;
    }
  }
  
  public int a()
  {
    return 2131560535;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131373127));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnLongClickListener(this);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent)) {
      a((QCircleCommentPraiseUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void a(trs paramtrs) {}
  
  public void a(trs paramtrs, int paramInt)
  {
    if (paramtrs == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Trs = paramtrs;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    if (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null)
    {
      setCommentTxt(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    }
    setReplyTxt(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public boolean a()
  {
    if ((a() instanceof trr))
    {
      trr localtrr = (trr)a();
      boolean bool = localtrr.a();
      if (bool)
      {
        if (localtrr.a() != 2) {
          break label41;
        }
        b();
      }
      for (;;)
      {
        return bool;
        label41:
        if (localtrr.a() == 4) {
          QQToast.a(getContext(), 0, 2131698348, 0).a();
        }
      }
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_Trs == null) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null));
    a(this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Trs != null) && (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null)) {
        if (this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) {
          a(paramView, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        } else {
          a(paramView, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
        }
      }
    }
  }
  
  public void setCommentTxt(FeedCloudMeta.StComment paramStComment)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    if ((paramStComment.postUser.get() != null) && (!TextUtils.isEmpty(paramStComment.postUser.nick.get())) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(0, paramStComment.postUser.nick.get().length() - 1, new uai(this, paramStComment));
      if (paramStComment.typeFlag.get() != 1) {
        break label214;
      }
      if (this.b == null)
      {
        this.b = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getContext().getResources().getDrawable(2130843540);
        this.b.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStComment.postUser.nick.get().trim() + "：" + paramStComment.content.get().trim());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      label214:
      if (paramStComment.likeInfo.ownerStatus.get() == 1)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getContext().getResources().getDrawable(2130843539);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(52.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    String str2;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(0, paramStReply.postUser.nick.get().length() - 1, new uaj(this, paramStReply));
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label320;
      }
      str1 = this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label334;
      }
      str2 = this.jdField_a_of_type_Trs.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();
      label117:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(paramStReply.postUser.nick.get().length() + 2, paramStReply.postUser.nick.get().length() + 2 + str2.length() - 1, new uak(this, str1));
      if (paramStReply.typeFlag.get() != 1) {
        break label348;
      }
      if (this.b == null)
      {
        this.b = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getContext().getResources().getDrawable(2130843540);
        this.b.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(33.0F), ImmersiveUtils.a(14.0F));
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.b);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      paramStReply = paramStReply.postUser.nick.get() + alpo.a(2131698366) + str2 + "：" + paramStReply.content.get();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStReply);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      label320:
      str1 = paramStReply.targetUser.id.get();
      break;
      label334:
      str2 = paramStReply.targetUser.nick.get();
      break label117;
      label348:
      if (paramStReply.likeInfo.ownerStatus.get() == 1)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getContext().getResources().getDrawable(2130843539);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(ImmersiveUtils.a(2.0F), 0, ImmersiveUtils.a(52.0F), ImmersiveUtils.a(14.0F));
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setEndSpanIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget
 * JD-Core Version:    0.7.0.1
 */