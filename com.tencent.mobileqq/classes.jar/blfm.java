import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class blfm
  implements blfo
{
  public void a(boolean paramBoolean, Context paramContext, blfq paramblfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      blfh.f(paramContext, paramblfq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfm
 * JD-Core Version:    0.7.0.1
 */