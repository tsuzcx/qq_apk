import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bkvj
  extends bkui
{
  bkvj(Context paramContext) {}
  
  public void b(@NonNull bkuj parambkuj)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambkuj = parambkuj.a();
    boolean bool1 = bool2;
    if (parambkuj != null)
    {
      parambkuj = bkvi.a("on_off", parambkuj);
      if (parambkuj == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bkvh.a(this.a, bool1);
      return;
    }
    if (((Integer)parambkuj).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvj
 * JD-Core Version:    0.7.0.1
 */