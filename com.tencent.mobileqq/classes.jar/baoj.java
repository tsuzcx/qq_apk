import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class baoj
  extends Handler
{
  baoj(baoh parambaoh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Bundle)));
      this.a.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return;
    } while (this.a.a == null);
    QQToast.a(this.a.a.getApplication(), alud.a(2131707987), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoj
 * JD-Core Version:    0.7.0.1
 */