import android.content.SharedPreferences;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

public final class amoe
  implements Runnable
{
  public amoe(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    int i = 1;
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(this.a, true, true);
    if (localSharedPreferences == null) {
      return;
    }
    if (localSharedPreferences.getBoolean("free_time_refresh_push", true)) {}
    for (;;)
    {
      ReadInJoyHelper.a(i);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoe
 * JD-Core Version:    0.7.0.1
 */