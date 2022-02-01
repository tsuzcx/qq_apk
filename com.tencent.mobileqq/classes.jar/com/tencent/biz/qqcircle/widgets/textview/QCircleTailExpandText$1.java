package com.tencent.biz.qqcircle.widgets.textview;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

class QCircleTailExpandText$1
  extends ClickableSpan
{
  QCircleTailExpandText$1(QCircleTailExpandText paramQCircleTailExpandText) {}
  
  @RequiresApi(api=16)
  public void onClick(@NonNull View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("mIsOpen : ");
    paramView.append(QCircleTailExpandText.a(this.a));
    QLog.d("QCircleTailExpandText", 1, paramView.toString());
    paramView = this.a;
    QCircleTailExpandText.a(paramView, true ^ QCircleTailExpandText.a(paramView));
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(QCircleTailExpandText.b(this.a));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.1
 * JD-Core Version:    0.7.0.1
 */