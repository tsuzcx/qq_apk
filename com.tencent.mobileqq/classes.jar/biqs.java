import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class biqs
  implements biqu
{
  public void a(boolean paramBoolean, Context paramContext, biqw parambiqw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      biqn.f(paramContext, parambiqw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqs
 * JD-Core Version:    0.7.0.1
 */