import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bhnm
  extends Handler
{
  public bhnm(bhne parambhne, Looper paramLooper)
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
      bhne.a(this.a, bhne.a(this.a, paramMessage.obj));
      return;
    case 2: 
      bhne.a(this.a, true);
      bhne.a(this.a);
      bhne.a(this.a, false);
      return;
    case 3: 
      bhne.a(this.a, paramMessage.obj);
      return;
    }
    bhne.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnm
 * JD-Core Version:    0.7.0.1
 */