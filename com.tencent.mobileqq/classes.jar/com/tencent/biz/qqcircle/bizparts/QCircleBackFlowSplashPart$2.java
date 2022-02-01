package com.tencent.biz.qqcircle.bizparts;

import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;

class QCircleBackFlowSplashPart$2
  extends AbsoluteSizeSpan
{
  QCircleBackFlowSplashPart$2(QCircleBackFlowSplashPart paramQCircleBackFlowSplashPart, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    RFWTypefaceUtil.a(paramTextPaint, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBackFlowSplashPart.2
 * JD-Core Version:    0.7.0.1
 */