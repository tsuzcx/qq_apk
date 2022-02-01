import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bndn
  implements bndq
{
  public void a(boolean paramBoolean, Context paramContext, bndr parambndr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bndl.d(paramContext, parambndr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndn
 * JD-Core Version:    0.7.0.1
 */