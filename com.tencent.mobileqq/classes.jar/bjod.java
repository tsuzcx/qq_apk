import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bjod
  implements bjof
{
  public void a(boolean paramBoolean, Context paramContext, bjog parambjog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bjoa.c(paramContext, parambjog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */