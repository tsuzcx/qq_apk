package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import babr;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import vvb;
import vvc;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(vvb paramvvb) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(vvb.a(this.this$0).getString(2131632728));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(vvb.a(this.this$0).getResources().getColor(2131099950), vvb.a(this.this$0).getResources().getColor(2131099955)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    vvb.a(this.this$0, babr.a(vvb.a(this.this$0), vvb.a(this.this$0).getString(2131632727), localSpannableString, 0, 2131625014, null, null, new vvc(this)));
    vvb.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */