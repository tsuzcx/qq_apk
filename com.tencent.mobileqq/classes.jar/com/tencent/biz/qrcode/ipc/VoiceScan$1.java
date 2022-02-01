package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bglp;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import zuo;
import zup;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(zuo paramzuo) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(zuo.a(this.this$0).getString(2131697667));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(zuo.a(this.this$0).getResources().getColor(2131165608), zuo.a(this.this$0).getResources().getColor(2131165613)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    zuo.a(this.this$0, bglp.a(zuo.a(this.this$0), zuo.a(this.this$0).getString(2131697666), localSpannableString, 0, 2131690566, null, null, new zup(this)));
    zuo.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */