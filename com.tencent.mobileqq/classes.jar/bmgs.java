import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bmgs
  extends bmfr
{
  bmgs(Context paramContext) {}
  
  public void b(@NonNull bmfs parambmfs)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambmfs = parambmfs.a();
    boolean bool1 = bool2;
    if (parambmfs != null)
    {
      parambmfs = bmgr.a("on_off", parambmfs);
      if (parambmfs == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bmgq.a(this.a, bool1);
      return;
    }
    if (((Integer)parambmfs).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgs
 * JD-Core Version:    0.7.0.1
 */