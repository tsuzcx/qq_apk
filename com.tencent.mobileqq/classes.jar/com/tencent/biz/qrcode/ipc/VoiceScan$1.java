package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import bdcd;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import xwn;
import xwo;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(xwn paramxwn) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(xwn.a(this.this$0).getString(2131698769));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(xwn.a(this.this$0).getResources().getColor(2131165571), xwn.a(this.this$0).getResources().getColor(2131165576)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    xwn.a(this.this$0, bdcd.a(xwn.a(this.this$0), xwn.a(this.this$0).getString(2131698768), localSpannableString, 0, 2131690626, null, null, new xwo(this)));
    xwn.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */