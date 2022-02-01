package com.tencent.biz.qqcircle.widgets;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.lang.ref.WeakReference;

class QCirclePushAsyncTextView$PushCountClickableSpan
  extends ClickableSpan
{
  private WeakReference<QCirclePushAsyncTextView> a;
  
  private QCirclePushAsyncTextView$PushCountClickableSpan(QCirclePushAsyncTextView paramQCirclePushAsyncTextView)
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
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && ((QCirclePushAsyncTextView)localWeakReference.get() != null)) {
      paramTextPaint.setColor(QCircleSkinHelper.getInstance().getColor(2131167084));
    }
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(ViewUtils.a(13.0F));
    RFWTypefaceUtil.a(paramTextPaint, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView.PushCountClickableSpan
 * JD-Core Version:    0.7.0.1
 */