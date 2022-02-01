package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

final class ChatActivityUtils$16
  implements ClickableColorSpanTextView.SpanClickListener
{
  ChatActivityUtils$16(Context paramContext) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.a.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.16
 * JD-Core Version:    0.7.0.1
 */