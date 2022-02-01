import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class blfl
  implements blfo
{
  public void a(boolean paramBoolean, Context paramContext, blfq paramblfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      blfh.e(paramContext, paramblfq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfl
 * JD-Core Version:    0.7.0.1
 */