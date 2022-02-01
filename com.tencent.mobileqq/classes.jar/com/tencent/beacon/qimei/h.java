package com.tencent.beacon.qimei;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

final class h
  implements Runnable
{
  h(Context paramContext, String paramString) {}
  
  public void run()
  {
    Toast.makeText(this.a, this.b, 1).show();
    ClipboardManager localClipboardManager = (ClipboardManager)this.a.getSystemService("clipboard");
    if (localClipboardManager != null) {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("beacon", this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.h
 * JD-Core Version:    0.7.0.1
 */