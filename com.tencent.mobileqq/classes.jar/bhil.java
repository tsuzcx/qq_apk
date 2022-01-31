import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bhil
  implements bhin
{
  public void a(boolean paramBoolean, Context paramContext, bhio parambhio)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bhii.c(paramContext, parambhio);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhil
 * JD-Core Version:    0.7.0.1
 */