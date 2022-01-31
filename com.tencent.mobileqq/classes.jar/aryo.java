import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;

class aryo
  extends Handler
{
  aryo(aryh paramaryh) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, alpo.a(2131705187), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryo
 * JD-Core Version:    0.7.0.1
 */