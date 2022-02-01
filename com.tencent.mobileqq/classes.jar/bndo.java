import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bndo
  implements bndq
{
  public void a(boolean paramBoolean, Context paramContext, bndr parambndr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bndl.c(paramContext, parambndr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndo
 * JD-Core Version:    0.7.0.1
 */