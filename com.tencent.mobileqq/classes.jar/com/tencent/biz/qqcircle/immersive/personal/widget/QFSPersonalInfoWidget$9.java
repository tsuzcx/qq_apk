package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCirclePersonDetailClick;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QFSPersonalInfoWidget$9
  extends ClickableSpan
{
  static {}
  
  QFSPersonalInfoWidget$9(QFSPersonalInfoWidget paramQFSPersonalInfoWidget, StringBuilder paramStringBuilder) {}
  
  @QCirclePersonDetailClick
  public void onClick(@NonNull View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(QCircleSkinHelper.getInstance().getColor(2131167084));
    paramTextPaint.setFakeBoldText(true);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget.9
 * JD-Core Version:    0.7.0.1
 */