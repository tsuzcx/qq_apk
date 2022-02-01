package com.tencent.mobileqq.activity.aio.helper;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;

class FullScreenInputHelper$11
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  FullScreenInputHelper$11(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public void onPrimaryClipChanged()
  {
    Object localObject = this.a.a();
    ClipboardMonitor.getPrimaryClipDescription((ClipboardManager)localObject);
    localObject = ((ClipboardManager)localObject).getPrimaryClipDescription();
    if ((localObject != null) && (((ClipDescription)localObject).getLabel() != null) && ("FullScreenInputHelper".equalsIgnoreCase(((ClipDescription)localObject).getLabel().toString())))
    {
      FullScreenInputHelper.a(this.a, true);
      return;
    }
    FullScreenInputHelper.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.11
 * JD-Core Version:    0.7.0.1
 */