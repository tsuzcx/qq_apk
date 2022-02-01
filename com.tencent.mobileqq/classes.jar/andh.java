import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class andh
  implements anps
{
  andh(ande paramande) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    anpq.b(ande.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!ande.c(this.a)))
      {
        ande.a(this.a, true);
        ande.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andh
 * JD-Core Version:    0.7.0.1
 */