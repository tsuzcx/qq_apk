import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bfdd
  implements bfdg
{
  public void a(boolean paramBoolean, Context paramContext, bfdi parambfdi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bfcz.e(paramContext, parambfdi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfdd
 * JD-Core Version:    0.7.0.1
 */