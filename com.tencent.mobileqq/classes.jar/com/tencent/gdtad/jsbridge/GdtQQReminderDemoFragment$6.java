package com.tencent.gdtad.jsbridge;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.UUID;

class GdtQQReminderDemoFragment$6
  implements View.OnClickListener
{
  GdtQQReminderDemoFragment$6(GdtQQReminderDemoFragment paramGdtQQReminderDemoFragment) {}
  
  public void onClick(View paramView)
  {
    GdtQQReminderDemoFragment.a();
    String str1 = UUID.randomUUID().toString();
    String str2 = String.valueOf(GdtQQReminderDemoFragment.b());
    long l;
    if (!TextUtils.isEmpty(GdtQQReminderDemoFragment.a(this.a).getText().toString())) {
      l = Long.valueOf(GdtQQReminderDemoFragment.a(this.a).getText().toString()).longValue();
    } else {
      l = 0L;
    }
    GdtQQReminderDemoFragment.a(str1, str2, l);
    GdtQQReminderDemoFragment.a(String.format("%s %s:%s %s:%s delayedSeconds:%d", new Object[] { "addQQReminderMsg", "msg_id", str1, "mn_reserved", str2, Long.valueOf(l) }));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.6
 * JD-Core Version:    0.7.0.1
 */