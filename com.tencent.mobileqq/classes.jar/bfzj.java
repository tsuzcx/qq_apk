import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bfzj
  implements bfzl
{
  public void a(boolean paramBoolean, Context paramContext, bfzm parambfzm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bfzg.c(paramContext, parambfzm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfzj
 * JD-Core Version:    0.7.0.1
 */