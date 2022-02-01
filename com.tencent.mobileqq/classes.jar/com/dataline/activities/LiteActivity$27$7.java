package com.dataline.activities;

import android.content.Context;
import android.text.ClipboardManager;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.widget.XListView;

class LiteActivity$27$7
  implements Runnable
{
  LiteActivity$27$7(LiteActivity.27 param27, String paramString, int paramInt) {}
  
  public void run()
  {
    this.c.a.m.notifyDataSetChanged();
    try
    {
      ((ClipboardManager)this.c.a.f.getContext().getSystemService("clipboard")).setText(this.a);
      label41:
      LiteActivity.a(this.c.a.g, this.c.a.f);
      LiteActivity.a(this.c.a.f);
      this.c.a.app.getMessageFacade().d(this.b).g();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.7
 * JD-Core Version:    0.7.0.1
 */