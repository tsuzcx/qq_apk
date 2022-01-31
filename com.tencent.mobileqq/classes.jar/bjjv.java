import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bjjv
  implements bjjy
{
  public void a(boolean paramBoolean, Context paramContext, bjjz parambjjz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bjjt.d(paramContext, parambjjz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjv
 * JD-Core Version:    0.7.0.1
 */