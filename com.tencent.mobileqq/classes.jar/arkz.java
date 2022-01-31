import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class arkz
  implements asgr
{
  private WeakReference<IVideoOuterStatusListener> a;
  
  public arkz(WeakReference<IVideoOuterStatusListener> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    IVideoOuterStatusListener localIVideoOuterStatusListener = (IVideoOuterStatusListener)this.a.get();
    if (paramBoolean)
    {
      localIVideoOuterStatusListener.onVideoStop();
      return;
    }
    localIVideoOuterStatusListener.onVideoStart(-1);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_GAIN");
      arkv.a().a(false);
      a(false);
      return;
    }
    QLog.i("WatchFloatingWindowController", 1, "onFocusChange: MEDIAFOCUS_LOSS");
    arkv.a().a(true);
    a(true);
  }
  
  public void a(WeakReference<IVideoOuterStatusListener> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkz
 * JD-Core Version:    0.7.0.1
 */