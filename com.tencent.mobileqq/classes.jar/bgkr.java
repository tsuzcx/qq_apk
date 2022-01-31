import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bgkr
  implements bgkx
{
  bgkr(bgkw parambgkw) {}
  
  public void a(boolean paramBoolean, Context paramContext, bgkz parambgkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bgkq.d(paramContext, parambgkz);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkr
 * JD-Core Version:    0.7.0.1
 */