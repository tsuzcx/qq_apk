package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bbdj;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import whv;
import whw;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(whv paramwhv) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(whv.a(this.this$0).getString(2131698474));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(whv.a(this.this$0).getResources().getColor(2131165535), whv.a(this.this$0).getResources().getColor(2131165540)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    whv.a(this.this$0, bbdj.a(whv.a(this.this$0), whv.a(this.this$0).getString(2131698473), localSpannableString, 0, 2131690575, null, null, new whw(this)));
    whv.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */