package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anni;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import uzk;
import vmd;
import vme;
import vmf;
import vmg;

public class QCircleMessageReplyItemView
  extends QCircleBaseWidgetView<uzk>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = anni.a(2131697250);
  private uzk jdField_a_of_type_Uzk;
  private vmg jdField_a_of_type_Vmg;
  
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
  
  public int a()
  {
    return 2131560736;
  }
  
  public String a()
  {
    return "QCircleMessageReplyItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131369241));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
  }
  
  protected void a(uzk paramuzk) {}
  
  public void a(uzk paramuzk, int paramInt)
  {
    if (paramuzk == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Uzk = paramuzk;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    setReplyTxt(this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
      if ((this.jdField_a_of_type_Uzk != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (this.jdField_a_of_type_Vmg != null)) {
        this.jdField_a_of_type_Vmg.a(paramView, this.jdField_a_of_type_Uzk);
      }
    }
  }
  
  public void setReplyItemListener(vmg paramvmg)
  {
    this.jdField_a_of_type_Vmg = paramvmg;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Uzk != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label294;
      }
      str1 = this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label309;
      }
    }
    label294:
    label309:
    for (String str2 = this.jdField_a_of_type_Uzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new vmd(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new vme(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vmf(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView
 * JD-Core Version:    0.7.0.1
 */