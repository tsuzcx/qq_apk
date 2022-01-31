import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class bbls
  extends Handler
{
  bbls(bblr parambblr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((this.a.a == null) || (TextUtils.isEmpty(this.a.a.a)) || (!this.a.a.a.equals(this.a.b)));
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbls
 * JD-Core Version:    0.7.0.1
 */