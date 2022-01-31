import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import java.util.concurrent.Executor;

class bgvm
  implements Executor
{
  bgvm(bgvl parambgvl) {}
  
  public void execute(Runnable paramRunnable)
  {
    TTHandleThread.a().b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvm
 * JD-Core Version:    0.7.0.1
 */