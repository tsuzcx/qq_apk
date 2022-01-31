package com.tencent.biz.qqcircle.widgets.message.item;

import alud;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import trx;
import ugw;
import ugx;
import ugy;

public class QCircleMessageReplyItemView
  extends BaseWidgetView<trx>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private final String jdField_a_of_type_JavaLangString = alud.a(2131698378);
  private trx jdField_a_of_type_Trx;
  private ugy jdField_a_of_type_Ugy;
  
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
    return 2131560566;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131368875));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
  }
  
  protected void a(trx paramtrx) {}
  
  public void a(trx paramtrx, int paramInt)
  {
    if (paramtrx == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Trx = paramtrx;
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null);
    setReplyTxt(this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_Trx == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (this.jdField_a_of_type_Ugy == null));
    this.jdField_a_of_type_Ugy.a(this.jdField_a_of_type_Trx);
  }
  
  public void setReplyItemListener(ugy paramugy)
  {
    this.jdField_a_of_type_Ugy = paramugy;
  }
  
  public void setReplyTxt(FeedCloudMeta.StReply paramStReply)
  {
    a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView);
    String str1;
    if ((paramStReply != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) && (this.jdField_a_of_type_Trx != null))
    {
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label286;
      }
      str1 = this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      if (!TextUtils.isEmpty(paramStReply.targetUser.id.get())) {
        break label301;
      }
    }
    label286:
    label301:
    for (String str2 = this.jdField_a_of_type_Trx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.nick.get();; str2 = paramStReply.targetUser.nick.get())
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStReply.postUser.nick.get()).append(this.jdField_a_of_type_JavaLangString).append(str2).append("：").append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStReply.postUser.nick.get().length(), new ugw(this, paramStReply));
      QCircleAsyncTextView localQCircleAsyncTextView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
      int i = paramStReply.postUser.nick.get().length();
      int j = this.jdField_a_of_type_JavaLangString.length();
      int k = paramStReply.postUser.nick.get().length();
      int m = this.jdField_a_of_type_JavaLangString.length();
      localQCircleAsyncTextView.a(localSpannableStringBuilder, i + j, str2.length() + (k + m), new ugx(this, str1));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.c();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      return;
      str1 = paramStReply.targetUser.id.get();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView
 * JD-Core Version:    0.7.0.1
 */