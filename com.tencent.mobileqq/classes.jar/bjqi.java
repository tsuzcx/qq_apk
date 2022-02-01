import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bjqi
  extends Handler
{
  bjqi(bjqh parambjqh, Looper paramLooper)
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
      bjqh localbjqh = this.a;
      if (paramMessage.obj == null) {}
      for (String str = null;; str = (String)paramMessage.obj)
      {
        localbjqh.a(str);
        break;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqi
 * JD-Core Version:    0.7.0.1
 */