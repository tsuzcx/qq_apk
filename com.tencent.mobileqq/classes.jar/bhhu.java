import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bhhu
  implements bhhw
{
  public void a(boolean paramBoolean, Context paramContext, bhhx parambhhx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bhhr.c(paramContext, parambhhx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhhu
 * JD-Core Version:    0.7.0.1
 */