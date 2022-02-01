import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.widget.QQToast;

public class avbp
  extends Handler
{
  public avbp(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, anzj.a(2131703702), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbp
 * JD-Core Version:    0.7.0.1
 */