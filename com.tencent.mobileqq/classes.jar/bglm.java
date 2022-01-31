import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bglm
  implements bglo
{
  public void a(boolean paramBoolean, Context paramContext, bglq parambglq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bglh.f(paramContext, parambglq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */