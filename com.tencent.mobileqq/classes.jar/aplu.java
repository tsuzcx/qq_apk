import android.app.Activity;
import android.os.Handler;
import android.os.Message;

class aplu
  extends Handler
{
  aplu(apln paramapln) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      bbmy.a(this.a.a, ajjy.a(2131639030), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplu
 * JD-Core Version:    0.7.0.1
 */