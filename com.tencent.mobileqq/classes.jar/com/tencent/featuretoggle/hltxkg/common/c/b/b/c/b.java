package com.tencent.featuretoggle.hltxkg.common.c.b.b.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.n;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    String str = com.tencent.featuretoggle.hltxkg.common.a.a().getSharedPreferences(a.a(this.a), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        a.a(this.a).a(str);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        a.a(this.a, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.c.b
 * JD-Core Version:    0.7.0.1
 */