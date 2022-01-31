import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bfnn
  extends bfmh
{
  bfnn(Context paramContext) {}
  
  public void b(@NonNull bfmi parambfmi)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambfmi = parambfmi.a();
    boolean bool1 = bool2;
    if (parambfmi != null)
    {
      parambfmi = bfnm.a("on_off", parambfmi);
      if (parambfmi == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bfnl.a(this.a, bool1);
      return;
    }
    if (((Integer)parambfmi).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnn
 * JD-Core Version:    0.7.0.1
 */