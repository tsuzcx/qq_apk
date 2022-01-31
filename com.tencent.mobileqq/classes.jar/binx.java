import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class binx
  implements bjos<bino>
{
  binx(binq parambinq) {}
  
  public void a(@Nullable bino parambino)
  {
    Object localObject = bink.a(parambino);
    parambino = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bino localbino = (bino)((Iterator)localObject).next();
      bioa localbioa = new bioa(null);
      localbioa.a = bioc.a(localbino);
      parambino.add(localbioa);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambino));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binx
 * JD-Core Version:    0.7.0.1
 */