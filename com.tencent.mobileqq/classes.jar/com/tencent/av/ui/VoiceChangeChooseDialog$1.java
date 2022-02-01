package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;

class VoiceChangeChooseDialog$1
  implements Runnable
{
  public void run()
  {
    if ((VoiceChangeChooseDialog.a(this.this$0) == 1) && (!this.this$0.g))
    {
      this.this$0.f.setText(2131893737);
      VoiceChangeChooseDialog.a(this.this$0, 2);
      this.this$0.a.k().bW = true;
      this.this$0.k.postDelayed(this.this$0.l, 10000L);
      return;
    }
    if (VoiceChangeChooseDialog.a(this.this$0) == 2)
    {
      this.this$0.f.setText(2131893739);
      VoiceChangeChooseDialog.a(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.1
 * JD-Core Version:    0.7.0.1
 */