import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.FastAnimationDrawable;
import java.lang.ref.WeakReference;

public class bbis
  extends Handler
{
  private final WeakReference<FastAnimationDrawable> a;
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    FastAnimationDrawable localFastAnimationDrawable;
    do
    {
      return;
      localFastAnimationDrawable = (FastAnimationDrawable)this.a.get();
    } while (localFastAnimationDrawable == null);
    FastAnimationDrawable.a(localFastAnimationDrawable, (bbir)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbis
 * JD-Core Version:    0.7.0.1
 */