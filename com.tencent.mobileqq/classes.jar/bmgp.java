import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bmgp
  implements bmgr
{
  public void a(boolean paramBoolean, Context paramContext, bmgt parambmgt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bmgk.f(paramContext, parambmgt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgp
 * JD-Core Version:    0.7.0.1
 */