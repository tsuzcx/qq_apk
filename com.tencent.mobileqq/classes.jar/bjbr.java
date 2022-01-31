import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

final class bjbr
  extends bjao
{
  bjbr(Context paramContext) {}
  
  public void b(@NonNull bjap parambjap)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    parambjap = parambjap.a();
    boolean bool1 = bool2;
    if (parambjap != null)
    {
      parambjap = bjbq.a("on_off", parambjap);
      if (parambjap == null) {
        bool1 = bool2;
      }
    }
    else
    {
      bjbp.a(this.a, bool1);
      return;
    }
    if (((Integer)parambjap).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbr
 * JD-Core Version:    0.7.0.1
 */