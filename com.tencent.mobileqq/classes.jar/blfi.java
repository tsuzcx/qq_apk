import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class blfi
  implements blfo
{
  blfi(blfn paramblfn) {}
  
  public void a(boolean paramBoolean, Context paramContext, blfq paramblfq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      blfh.d(paramContext, paramblfq);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfi
 * JD-Core Version:    0.7.0.1
 */