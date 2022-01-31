package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bbcv;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import why;
import whz;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(why paramwhy) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(why.a(this.this$0).getString(2131698464));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(why.a(this.this$0).getResources().getColor(2131165535), why.a(this.this$0).getResources().getColor(2131165540)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    why.a(this.this$0, bbcv.a(why.a(this.this$0), why.a(this.this$0).getString(2131698463), localSpannableString, 0, 2131690575, null, null, new whz(this)));
    why.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */