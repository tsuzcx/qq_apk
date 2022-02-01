import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ayxn
  extends Handler
{
  private WeakReference<ayxa> a;
  
  public ayxn(ayxa paramayxa)
  {
    this.a = new WeakReference(paramayxa);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayxa localayxa = (ayxa)this.a.get();
    if (localayxa == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ayxa.a(localayxa, (ayxp)paramMessage.obj);
      return;
    }
    ayxa.a(localayxa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxn
 * JD-Core Version:    0.7.0.1
 */