package com.tencent.featuretoggle.hltxkg.common.c.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.n;
import com.tencent.featuretoggle.hltxkg.common.c.j;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  public final void run()
  {
    String str = j.b("settings_in_client", "", true);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        b.a(this.a).a(str);
        b.b(this.a);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        j.a("settings_in_client", "", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.a.c
 * JD-Core Version:    0.7.0.1
 */