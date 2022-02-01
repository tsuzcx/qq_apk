import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class amyr
  implements anmd
{
  amyr(amyo paramamyo) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    anmb.b(amyo.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!amyo.c(this.a)))
      {
        amyo.a(this.a, true);
        amyo.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyr
 * JD-Core Version:    0.7.0.1
 */