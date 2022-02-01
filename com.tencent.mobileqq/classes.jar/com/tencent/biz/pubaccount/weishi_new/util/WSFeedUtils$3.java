package com.tencent.biz.pubaccount.weishi_new.util;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class WSFeedUtils$3
  extends ClickableSpan
{
  WSFeedUtils$3(String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = WSFeedUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("weishi://profile?person_id=");
    localStringBuilder.append(this.a);
    WeishiScehmeUtil.a(paramView, "biz_src_jc_gzh_weishi", localStringBuilder.toString());
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils.3
 * JD-Core Version:    0.7.0.1
 */