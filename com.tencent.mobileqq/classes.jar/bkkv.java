import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bkkv
  implements bkkx
{
  public void a(boolean paramBoolean, Context paramContext, bkkz parambkkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bkkq.f(paramContext, parambkkz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkv
 * JD-Core Version:    0.7.0.1
 */