package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bfur;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import yxu;
import yxv;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(yxu paramyxu) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(yxu.a(this.this$0).getString(2131697897));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(yxu.a(this.this$0).getResources().getColor(2131165616), yxu.a(this.this$0).getResources().getColor(2131165621)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    yxu.a(this.this$0, bfur.a(yxu.a(this.this$0), yxu.a(this.this$0).getString(2131697896), localSpannableString, 0, 2131690602, null, null, new yxv(this)));
    yxu.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */