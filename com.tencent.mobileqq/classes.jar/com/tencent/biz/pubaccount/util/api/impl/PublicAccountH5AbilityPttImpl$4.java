package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class PublicAccountH5AbilityPttImpl$4
  implements ClickableColorSpanTextView.SpanClickListener
{
  PublicAccountH5AbilityPttImpl$4(PublicAccountH5AbilityPttImpl paramPublicAccountH5AbilityPttImpl) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a.activity, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/sappfaq/210331qMJbAf210331RZBBba.html");
    this.a.activity.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl.4
 * JD-Core Version:    0.7.0.1
 */