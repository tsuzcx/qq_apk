import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bgwl
  extends bgvi
{
  bgwl(Context paramContext) {}
  
  public void b(@NonNull bgvj parambgvj)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambgvj = parambgvj.a();
    boolean bool1 = bool2;
    if (parambgvj != null)
    {
      parambgvj = bgwk.a("on_off", parambgvj);
      if (parambgvj == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bgwj.a(this.a, bool1);
      return;
    }
    if (((Integer)parambgvj).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwl
 * JD-Core Version:    0.7.0.1
 */