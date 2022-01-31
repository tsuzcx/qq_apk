import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bgll
  implements bglo
{
  public void a(boolean paramBoolean, Context paramContext, bglq parambglq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bglh.e(paramContext, parambglq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgll
 * JD-Core Version:    0.7.0.1
 */