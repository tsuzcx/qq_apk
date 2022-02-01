import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.6.1;
import mqq.os.MqqHandler;

public class bnkn
  implements Observer<Boolean>
{
  bnkn(bnkd parambnkd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkn
 * JD-Core Version:    0.7.0.1
 */