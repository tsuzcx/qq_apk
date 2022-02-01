import android.os.FileObserver;
import com.tencent.qphone.base.util.QLog;

class bctx
  extends FileObserver
{
  public bctx(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void onEvent(int paramInt, String arg2)
  {
    QLog.e("UnifiedMonitor.Trace", 1, "dumpTraces onEvent " + ???);
    synchronized (bctw.a())
    {
      notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bctx
 * JD-Core Version:    0.7.0.1
 */