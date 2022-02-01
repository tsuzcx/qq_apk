import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.2.1;
import mqq.os.MqqHandler;

public class bnqy
  implements Observer<Boolean>
{
  bnqy(bnqx parambnqx) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new AEVideoStoryGIFTplViewModel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqy
 * JD-Core Version:    0.7.0.1
 */