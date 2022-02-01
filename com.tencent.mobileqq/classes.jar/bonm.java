import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bonm
  implements Observer<bond>
{
  bonm(bonf parambonf) {}
  
  public void a(@Nullable bond parambond)
  {
    Object localObject = bomz.a(parambond);
    parambond = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bond localbond = (bond)((Iterator)localObject).next();
      bonp localbonp = new bonp(null);
      localbonp.a = bonr.a(localbond);
      parambond.add(localbonp);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambond));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonm
 * JD-Core Version:    0.7.0.1
 */