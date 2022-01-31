import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bgkv
  implements bgkx
{
  public void a(boolean paramBoolean, Context paramContext, bgkz parambgkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bgkq.f(paramContext, parambgkz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkv
 * JD-Core Version:    0.7.0.1
 */