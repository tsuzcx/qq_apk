import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bgku
  implements bgkx
{
  public void a(boolean paramBoolean, Context paramContext, bgkz parambgkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bgkq.e(paramContext, parambgkz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgku
 * JD-Core Version:    0.7.0.1
 */