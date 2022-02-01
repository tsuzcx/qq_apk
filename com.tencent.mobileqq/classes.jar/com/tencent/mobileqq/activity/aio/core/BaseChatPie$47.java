package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import bhbx;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class BaseChatPie$47
  implements bhbx
{
  BaseChatPie$47(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.this$0.mContext.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.47
 * JD-Core Version:    0.7.0.1
 */