import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class blvz
  implements blwf
{
  blvz(blwe paramblwe) {}
  
  public void a(boolean paramBoolean, Context paramContext, blwh paramblwh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      blvy.d(paramContext, paramblwh);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvz
 * JD-Core Version:    0.7.0.1
 */