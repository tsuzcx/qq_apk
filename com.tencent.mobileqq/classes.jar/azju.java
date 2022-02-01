import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import mqq.os.MqqHandler;

public class azju
  implements IThreadMgr
{
  public void postOnSubThread(Runnable paramRunnable)
  {
    ThreadManager.getSubThreadHandler().post(paramRunnable);
  }
  
  public void postOnSubThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void postOnUIThread(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void postOnUIThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void quitSubThread() {}
  
  public void removeCallbackOnSubHandler(Runnable paramRunnable)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(paramRunnable);
  }
  
  public void removeCallbackOnUIHandler(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azju
 * JD-Core Version:    0.7.0.1
 */