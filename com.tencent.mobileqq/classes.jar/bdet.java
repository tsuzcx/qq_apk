import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bdet
  extends Handler
{
  bdet(bdes parambdes, Looper paramLooper)
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
      bdes localbdes = this.a;
      if (paramMessage.obj == null) {}
      for (String str = null;; str = (String)paramMessage.obj)
      {
        localbdes.a(str);
        break;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdet
 * JD-Core Version:    0.7.0.1
 */