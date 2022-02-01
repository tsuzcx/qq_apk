import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bmgl
  implements bmgr
{
  bmgl(bmgq parambmgq) {}
  
  public void a(boolean paramBoolean, Context paramContext, bmgt parambmgt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bmgk.d(paramContext, parambmgt);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgl
 * JD-Core Version:    0.7.0.1
 */