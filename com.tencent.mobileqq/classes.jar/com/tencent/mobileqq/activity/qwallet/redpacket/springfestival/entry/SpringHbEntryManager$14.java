package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry;

import agtk;
import agtv;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SpringHbEntryManager$14
  implements Runnable
{
  public SpringHbEntryManager$14(agtk paramagtk) {}
  
  public void run()
  {
    try
    {
      if (agtk.a(this.this$0).hasMessages(1001))
      {
        QLog.i("springHb_SpringEntryManager", 2, "onConversationFragmentResume has SCHEDULE_PATRY_TASK msg.");
        agtk.h(this.this$0);
        return;
      }
      QLog.i("springHb_SpringEntryManager", 2, "onConversationFragmentResume not has SCHEDULE_PATRY_TASK msg.");
      if (agtk.a(this.this$0).isEmpty())
      {
        QLog.i("springHb_SpringEntryManager", 2, "onConversationFragmentResume task list is empty, return.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(localThrowable));
      return;
    }
    if (((agtv)agtk.a(this.this$0).get(0)).a - this.this$0.b() > 86400000L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        agtk.e(this.this$0);
      }
      QLog.i("springHb_SpringEntryManager", 2, "onConversationFragmentResume next task time beyond one day: " + bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.14
 * JD-Core Version:    0.7.0.1
 */