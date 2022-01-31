import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bksr
  implements bmac<bksi>
{
  bksr(bksk parambksk) {}
  
  public void a(@Nullable bksi parambksi)
  {
    Object localObject = bkse.a(parambksi);
    parambksi = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bksi localbksi = (bksi)((Iterator)localObject).next();
      bksu localbksu = new bksu(null);
      localbksu.a = bksw.a(localbksi);
      parambksi.add(localbksu);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambksi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksr
 * JD-Core Version:    0.7.0.1
 */