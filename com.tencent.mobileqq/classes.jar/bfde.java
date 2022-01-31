import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bfde
  implements bfdg
{
  public void a(boolean paramBoolean, Context paramContext, bfdi parambfdi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bfcz.f(paramContext, parambfdi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfde
 * JD-Core Version:    0.7.0.1
 */