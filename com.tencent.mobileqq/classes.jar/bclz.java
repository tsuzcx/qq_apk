import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.GifAnimationDrawable;
import java.lang.ref.WeakReference;

public class bclz
  extends Handler
{
  private final WeakReference<GifAnimationDrawable> a;
  
  public bclz(GifAnimationDrawable paramGifAnimationDrawable)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramGifAnimationDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    GifAnimationDrawable localGifAnimationDrawable;
    do
    {
      return;
      localGifAnimationDrawable = (GifAnimationDrawable)this.a.get();
    } while (localGifAnimationDrawable == null);
    GifAnimationDrawable.a(localGifAnimationDrawable, (bcly)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bclz
 * JD-Core Version:    0.7.0.1
 */