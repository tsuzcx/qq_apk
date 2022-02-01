package com.dataline.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.widget.XListView;

class LiteActivity$27$8
  implements Runnable
{
  LiteActivity$27$8(LiteActivity.27 param27, String paramString, int paramInt) {}
  
  public void run()
  {
    this.c.a.m.notifyDataSetChanged();
    ClipboardManager localClipboardManager = (ClipboardManager)this.c.a.f.getContext().getSystemService("clipboard");
    ClipData localClipData = ClipData.newPlainText("msg", this.a);
    ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
    localClipboardManager.setPrimaryClip(localClipData);
    LiteActivity.a(this.c.a.g, this.c.a.f);
    LiteActivity.a(this.c.a.f);
    this.c.a.app.getMessageFacade().d(this.b).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.8
 * JD-Core Version:    0.7.0.1
 */