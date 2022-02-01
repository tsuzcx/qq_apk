package com.tencent.biz.qqcircle.widgets;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class QCirclePushAsyncTextView$PushStartImageClickableSpan
  extends ClickableSpan
{
  private WeakReference<QCirclePushAsyncTextView> a;
  
  private QCirclePushAsyncTextView$PushStartImageClickableSpan(QCirclePushAsyncTextView paramQCirclePushAsyncTextView)
  {
    this.a = new WeakReference(paramQCirclePushAsyncTextView);
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      paramView = (QCirclePushAsyncTextView)paramView.get();
      if ((paramView != null) && (QCirclePushAsyncTextView.a(paramView) != null)) {
        QCirclePushAsyncTextView.a(paramView).b();
      }
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView.PushStartImageClickableSpan
 * JD-Core Version:    0.7.0.1
 */