import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class awbj
  extends Handler
{
  private WeakReference<awaw> a;
  
  public awbj(awaw paramawaw)
  {
    this.a = new WeakReference(paramawaw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    awaw localawaw = (awaw)this.a.get();
    if (localawaw == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      awaw.a(localawaw, (awbl)paramMessage.obj);
      return;
    }
    awaw.a(localawaw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awbj
 * JD-Core Version:    0.7.0.1
 */