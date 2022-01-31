import android.app.Activity;
import android.os.Handler;
import android.os.Message;

class aqfk
  extends Handler
{
  aqfk(aqfd paramaqfd) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bcql.a(this.a.a, ajya.a(2131704826), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfk
 * JD-Core Version:    0.7.0.1
 */