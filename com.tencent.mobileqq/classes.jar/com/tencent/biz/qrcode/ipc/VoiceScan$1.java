package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bhdj;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import zmx;
import zmy;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(zmx paramzmx) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(zmx.a(this.this$0).getString(2131698180));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(zmx.a(this.this$0).getResources().getColor(2131165622), zmx.a(this.this$0).getResources().getColor(2131165627)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    zmx.a(this.this$0, bhdj.a(zmx.a(this.this$0), zmx.a(this.this$0).getString(2131698179), localSpannableString, 0, 2131690679, null, null, new zmy(this)));
    zmx.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */