package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class VoiceScan$1
  implements Runnable
{
  VoiceScan$1(VoiceScan paramVoiceScan) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(VoiceScan.a(this.this$0).getString(2131698456));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(VoiceScan.a(this.this$0).getResources().getColor(2131165624), VoiceScan.a(this.this$0).getResources().getColor(2131165629)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    VoiceScan.a(this.this$0, DialogUtil.a(VoiceScan.a(this.this$0), VoiceScan.a(this.this$0).getString(2131698455), localSpannableString, 0, 2131690781, null, null, new VoiceScan.1.1(this)));
    VoiceScan.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */