package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anzj;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import uyx;
import vba;
import voj;
import vok;
import vol;
import vom;

public class QCircleMessageReplyItemView
  extends QCircleBaseWidgetView<vba>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = anzj.a(2131697327);
  private vba jdField_a_of_type_Vba;
  private vom jdField_a_of_type_Vom;
  
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
    localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
    uyx.b(getContext(), localQCircleInitBean);
  }
  
  public int a()
  {
    return 2131560757;
  }
  
  public String a()
  {
    return "QCircleMessageReplyItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131369331));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
  }
  
  protected void a(vba paramvba) {}
  
  public void a(vba paramvba, int paramInt)
  {
    if (paramvba == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Vba = paramvba;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    setReplyTxt(this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
      if ((this.jdField_a_of_type_Vba != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (this.jdField_a_of_type_Vom != null)) {
        this.jdField_a_of_type_Vom.a(paramView, this.jdField_a_of_type_Vba);
      }
    }
  }
  
  public void setReplyItemListener(vom paramvom)
  {
    this.jdField_a_of_type_Vom = paramvom;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Vba != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label294;
      }
      str1 = this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label309;
      }
    }
    label294:
    label309:
    for (String str2 = this.jdField_a_of_type_Vba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new voj(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new vok(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(localSpannableStringBuilder, new vol(this));
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