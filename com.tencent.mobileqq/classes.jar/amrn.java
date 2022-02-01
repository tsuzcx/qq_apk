import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class amrn
  implements andx
{
  amrn(amrk paramamrk) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    andw.b(amrk.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!amrk.c(this.a)))
      {
        amrk.a(this.a, true);
        amrk.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrn
 * JD-Core Version:    0.7.0.1
 */