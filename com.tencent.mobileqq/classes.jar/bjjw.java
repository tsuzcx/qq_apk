import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bjjw
  implements bjjy
{
  public void a(boolean paramBoolean, Context paramContext, bjjz parambjjz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bjjt.c(paramContext, parambjjz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjw
 * JD-Core Version:    0.7.0.1
 */