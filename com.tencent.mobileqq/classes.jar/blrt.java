import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class blrt
  implements Observer<blrk>
{
  blrt(blrm paramblrm) {}
  
  public void a(@Nullable blrk paramblrk)
  {
    Object localObject = blrg.a(paramblrk);
    paramblrk = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      blrk localblrk = (blrk)((Iterator)localObject).next();
      blrw localblrw = new blrw(null);
      localblrw.a = blry.a(localblrk);
      paramblrk.add(localblrw);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, paramblrk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrt
 * JD-Core Version:    0.7.0.1
 */