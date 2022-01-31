import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bfdr
  extends Handler
{
  bfdr(bfdq parambfdq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      bfdq localbfdq = this.a;
      if (paramMessage.obj == null) {}
      for (String str = null;; str = (String)paramMessage.obj)
      {
        localbfdq.a(str);
        break;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdr
 * JD-Core Version:    0.7.0.1
 */