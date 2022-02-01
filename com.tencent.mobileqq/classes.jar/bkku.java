import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bkku
  implements bkkx
{
  public void a(boolean paramBoolean, Context paramContext, bkkz parambkkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bkkq.e(paramContext, parambkkz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkku
 * JD-Core Version:    0.7.0.1
 */