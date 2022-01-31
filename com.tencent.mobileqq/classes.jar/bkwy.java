import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bkwy
  implements bmeo<bkwp>
{
  bkwy(bkwr parambkwr) {}
  
  public void a(@Nullable bkwp parambkwp)
  {
    Object localObject = bkwl.a(parambkwp);
    parambkwp = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bkwp localbkwp = (bkwp)((Iterator)localObject).next();
      bkxb localbkxb = new bkxb(null);
      localbkxb.a = bkxd.a(localbkwp);
      parambkwp.add(localbkxb);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambkwp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwy
 * JD-Core Version:    0.7.0.1
 */