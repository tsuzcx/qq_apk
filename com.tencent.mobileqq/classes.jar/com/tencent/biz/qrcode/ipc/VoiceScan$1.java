package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bdgm;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import yaw;
import yax;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(yaw paramyaw) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(yaw.a(this.this$0).getString(2131698781));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(yaw.a(this.this$0).getResources().getColor(2131165571), yaw.a(this.this$0).getResources().getColor(2131165576)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    yaw.a(this.this$0, bdgm.a(yaw.a(this.this$0), yaw.a(this.this$0).getString(2131698780), localSpannableString, 0, 2131690626, null, null, new yax(this)));
    yaw.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */