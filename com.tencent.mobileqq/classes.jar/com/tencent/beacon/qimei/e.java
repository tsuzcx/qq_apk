package com.tencent.beacon.qimei;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;

final class e
  implements Runnable
{
  e(Context paramContext, String paramString) {}
  
  public void run()
  {
    Toast.makeText(this.a, this.b, 1).show();
    ClipboardManager localClipboardManager = (ClipboardManager)this.a.getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText("beacon", this.b);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.e
 * JD-Core Version:    0.7.0.1
 */