package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

final class bx
  implements Runnable
{
  bx(bw parambw) {}
  
  public final void run()
  {
    String str = m.a().getSharedPreferences(bw.d(), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a.a(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      m.a().getSharedPreferences(bw.d(), 0).edit().putString("halley_cloud_param_content", "").commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.bx
 * JD-Core Version:    0.7.0.1
 */