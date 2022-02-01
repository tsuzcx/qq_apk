package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bhlq;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import zyj;
import zyk;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(zyj paramzyj) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(zyj.a(this.this$0).getString(2131697751));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(zyj.a(this.this$0).getResources().getColor(2131165608), zyj.a(this.this$0).getResources().getColor(2131165613)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    zyj.a(this.this$0, bhlq.a(zyj.a(this.this$0), zyj.a(this.this$0).getString(2131697750), localSpannableString, 0, 2131690562, null, null, new zyk(this)));
    zyj.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */