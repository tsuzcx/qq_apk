import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bmcl
  implements bmco
{
  public void a(boolean paramBoolean, Context paramContext, bmcp parambmcp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bmcj.d(paramContext, parambmcp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcl
 * JD-Core Version:    0.7.0.1
 */