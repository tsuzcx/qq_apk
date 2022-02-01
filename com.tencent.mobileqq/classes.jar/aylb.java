import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class aylb
  extends Handler
{
  private WeakReference<ayko> a;
  
  public aylb(ayko paramayko)
  {
    this.a = new WeakReference(paramayko);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayko localayko = (ayko)this.a.get();
    if (localayko == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ayko.a(localayko, (ayld)paramMessage.obj);
      return;
    }
    ayko.a(localayko);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylb
 * JD-Core Version:    0.7.0.1
 */