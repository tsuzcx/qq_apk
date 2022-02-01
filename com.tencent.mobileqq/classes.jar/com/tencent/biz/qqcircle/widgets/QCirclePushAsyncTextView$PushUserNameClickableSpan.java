package com.tencent.biz.qqcircle.widgets;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;

class QCirclePushAsyncTextView$PushUserNameClickableSpan
  extends ClickableSpan
{
  private WeakReference<QCirclePushAsyncTextView> a;
  private FeedCloudMeta.StUser b;
  private boolean c;
  
  private QCirclePushAsyncTextView$PushUserNameClickableSpan(QCirclePushAsyncTextView paramQCirclePushAsyncTextView, FeedCloudMeta.StUser paramStUser, boolean paramBoolean)
  {
    this.a = new WeakReference(paramQCirclePushAsyncTextView);
    this.b = paramStUser;
    this.c = paramBoolean;
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      paramView = (QCirclePushAsyncTextView)paramView.get();
      if ((paramView != null) && (QCirclePushAsyncTextView.a(paramView) != null)) {
        QCirclePushAsyncTextView.a(paramView).a(this.b);
      }
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(QCircleSkinHelper.getInstance().getColor(2131167084));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(this.c);
    paramTextPaint.setTextSize(ViewUtils.a(12.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView.PushUserNameClickableSpan
 * JD-Core Version:    0.7.0.1
 */