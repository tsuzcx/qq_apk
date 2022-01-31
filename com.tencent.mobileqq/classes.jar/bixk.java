import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bixk
  extends biwh
{
  bixk(Context paramContext) {}
  
  public void b(@NonNull biwi parambiwi)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambiwi = parambiwi.a();
    boolean bool1 = bool2;
    if (parambiwi != null)
    {
      parambiwi = bixj.a("on_off", parambiwi);
      if (parambiwi == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bixi.a(this.a, bool1);
      return;
    }
    if (((Integer)parambiwi).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bixk
 * JD-Core Version:    0.7.0.1
 */