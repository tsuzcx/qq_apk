package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleMessageReplyItemView
  extends QCircleBaseWidgetView<QCircleFeedCommentInfo>
  implements View.OnClickListener
{
  private final String a = HardCodeUtil.a(2131895886);
  private QCircleAsyncTextView b;
  private QCircleFeedCommentInfo c;
  private QCircleMessageReplyItemView.QCircleMessageReplyItemListener d;
  private int e;
  
  public QCircleMessageReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if (paramQCircleAsyncTextView != null)
    {
      paramQCircleAsyncTextView.a(false);
      paramQCircleAsyncTextView.setText("");
      paramQCircleAsyncTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    QCircleLauncher.b(getContext(), localQCircleInitBean);
  }
  
  public void a(QCircleFeedCommentInfo paramQCircleFeedCommentInfo, int paramInt)
  {
    if (paramQCircleFeedCommentInfo == null) {
      return;
    }
    this.c = paramQCircleFeedCommentInfo;
    this.e = paramInt;
    if (this.c.b == null) {
      return;
    }
    setReplyTxt(this.c.c);
  }
  
  public int getLayoutId()
  {
    return 2131626883;
  }
  
  protected String getLogTag()
  {
    return "QCircleMessageReplyItemView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436515)
    {
      Object localObject = this.c;
      if ((localObject != null) && (((QCircleFeedCommentInfo)localObject).a != null) && (this.c.b != null))
      {
        localObject = this.d;
        if (localObject != null) {
          ((QCircleMessageReplyItemView.QCircleMessageReplyItemListener)localObject).a(paramView, this.c);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.b = ((QCircleAsyncTextView)paramView.findViewById(2131436515));
    this.b.setOnClickListener(this);
  }
  
  public void setReplyItemListener(QCircleMessageReplyItemView.QCircleMessageReplyItemListener paramQCircleMessageReplyItemListener)
  {
    this.d = paramQCircleMessageReplyItemListener;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.b);
    if ((paramStReply != null) && (this.b != null) && (this.c != null))
    {
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.c.b.postUser;
      } else {
        localObject = paramStReply.targetUser;
      }
      String str = ((FeedCloudMeta.StUser)localObject).id.get();
      if (TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        localObject = this.c.b.postUser;
      } else {
        localObject = paramStReply.targetUser;
      }
      Object localObject = ((FeedCloudMeta.StUser)localObject).nick.get();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.a).append((CharSequence)localObject).append("：").append(paramStReply.content.get());
      this.b.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new QCircleMessageReplyItemView.1(this, paramStReply));
      this.b.a(localSpannableStringBuilder, paramStReply.postUser.nick.get().length() + this.a.length(), paramStReply.postUser.nick.get().length() + this.a.length() + ((String)localObject).length(), new QCircleMessageReplyItemView.2(this, str));
      this.b.setOnClickAtTextListener(new QCircleMessageReplyItemView.3(this));
      this.b.setText(localSpannableStringBuilder);
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView
 * JD-Core Version:    0.7.0.1
 */