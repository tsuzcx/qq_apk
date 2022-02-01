import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class blwc
  implements blwf
{
  public void a(boolean paramBoolean, Context paramContext, blwh paramblwh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      blvy.e(paramContext, paramblwh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwc
 * JD-Core Version:    0.7.0.1
 */