package com.tencent.av.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import java.lang.ref.WeakReference;

class QavDoubleVideoSharpnessMangaer$QavClickableSpan
  extends ClickableSpan
{
  private WeakReference<QavDoubleVideoSharpnessMangaer> a;
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (paramView == null) {
      return;
    }
    paramView = (QavDoubleVideoSharpnessMangaer)paramView.get();
    if (paramView != null) {
      paramView.f();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.QavClickableSpan
 * JD-Core Version:    0.7.0.1
 */