import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bmgo
  implements bmgr
{
  public void a(boolean paramBoolean, Context paramContext, bmgt parambmgt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bmgk.e(paramContext, parambmgt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgo
 * JD-Core Version:    0.7.0.1
 */