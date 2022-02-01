import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class blqa
  extends bloz
{
  blqa(Context paramContext) {}
  
  public void b(@NonNull blpa paramblpa)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    paramblpa = paramblpa.a();
    boolean bool1 = bool2;
    if (paramblpa != null)
    {
      paramblpa = blpz.a("on_off", paramblpa);
      if (paramblpa == null) {
        bool1 = bool2;
      }
    }
    else
    {
      blpy.a(this.a, bool1);
      return;
    }
    if (((Integer)paramblpa).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqa
 * JD-Core Version:    0.7.0.1
 */