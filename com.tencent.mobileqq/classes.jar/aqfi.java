import android.app.Activity;
import android.os.Handler;
import android.os.Message;

class aqfi
  extends Handler
{
  aqfi(aqfb paramaqfb) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bcpw.a(this.a.a, ajyc.a(2131704815), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfi
 * JD-Core Version:    0.7.0.1
 */