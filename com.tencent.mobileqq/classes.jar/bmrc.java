import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bmrc
  extends bmqb
{
  bmrc(Context paramContext) {}
  
  public void b(@NonNull bmqc parambmqc)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambmqc = parambmqc.a();
    boolean bool1 = bool2;
    if (parambmqc != null)
    {
      parambmqc = bmrb.a("on_off", parambmqc);
      if (parambmqc == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bmra.a(this.a, bool1);
      return;
    }
    if (((Integer)parambmqc).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrc
 * JD-Core Version:    0.7.0.1
 */