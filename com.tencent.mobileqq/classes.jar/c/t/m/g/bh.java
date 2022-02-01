package c.t.m.g;

import android.text.TextUtils;

final class bh
  implements Runnable
{
  bh(bg parambg) {}
  
  public final void run()
  {
    String str = ck.b("settings_in_client", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a.a(str);
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      ck.a("settings_in_client", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.bh
 * JD-Core Version:    0.7.0.1
 */