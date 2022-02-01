package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class AudioPanelAioHelper$2
  implements ClickableColorSpanTextView.SpanClickListener
{
  AudioPanelAioHelper$2(AudioPanelAioHelper paramAudioPanelAioHelper) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(AudioPanelAioHelper.a(this.a).e, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/sappfaq/210331qMJbAf210331RZBBba.html");
    AudioPanelAioHelper.a(this.a).e.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper.2
 * JD-Core Version:    0.7.0.1
 */