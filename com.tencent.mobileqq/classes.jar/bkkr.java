import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bkkr
  implements bkkx
{
  bkkr(bkkw parambkkw) {}
  
  public void a(boolean paramBoolean, Context paramContext, bkkz parambkkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bkkq.d(paramContext, parambkkz);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkr
 * JD-Core Version:    0.7.0.1
 */