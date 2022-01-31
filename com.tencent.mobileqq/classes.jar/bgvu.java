import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bgvu
  extends bgur
{
  bgvu(Context paramContext) {}
  
  public void b(@NonNull bgus parambgus)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambgus = parambgus.a();
    boolean bool1 = bool2;
    if (parambgus != null)
    {
      parambgus = bgvt.a("on_off", parambgus);
      if (parambgus == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bgvs.a(this.a, bool1);
      return;
    }
    if (((Integer)parambgus).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvu
 * JD-Core Version:    0.7.0.1
 */