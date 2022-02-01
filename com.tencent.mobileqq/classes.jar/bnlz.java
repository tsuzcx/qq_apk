import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnlz
  implements Observer<bnlq>
{
  bnlz(bnls parambnls) {}
  
  public void a(@Nullable bnlq parambnlq)
  {
    Object localObject = bnlm.a(parambnlq);
    parambnlq = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bnlq localbnlq = (bnlq)((Iterator)localObject).next();
      bnmc localbnmc = new bnmc(null);
      localbnmc.a = bnme.a(localbnlq);
      parambnlq.add(localbnmc);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambnlq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlz
 * JD-Core Version:    0.7.0.1
 */