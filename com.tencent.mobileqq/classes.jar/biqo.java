import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class biqo
  implements biqu
{
  biqo(biqt parambiqt) {}
  
  public void a(boolean paramBoolean, Context paramContext, biqw parambiqw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      biqn.d(paramContext, parambiqw);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqo
 * JD-Core Version:    0.7.0.1
 */