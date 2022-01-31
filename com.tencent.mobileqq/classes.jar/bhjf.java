import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bhjf
  extends Handler
{
  public bhjf(bhix parambhix, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      bhix.a(this.a, bhix.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bhix.a(this.a, true);
      bhix.a(this.a);
      bhix.a(this.a, false);
      return;
    case 3: 
      bhix.a(this.a, paramMessage.obj);
      return;
    }
    bhix.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjf
 * JD-Core Version:    0.7.0.1
 */