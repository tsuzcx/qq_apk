import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bgli
  implements bglo
{
  bgli(bgln parambgln) {}
  
  public void a(boolean paramBoolean, Context paramContext, bglq parambglq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bglh.d(paramContext, parambglq);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgli
 * JD-Core Version:    0.7.0.1
 */