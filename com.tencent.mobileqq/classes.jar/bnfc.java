import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnfc
  implements Observer<bnet>
{
  bnfc(bnev parambnev) {}
  
  public void a(@Nullable bnet parambnet)
  {
    Object localObject = bnep.a(parambnet);
    parambnet = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bnet localbnet = (bnet)((Iterator)localObject).next();
      bnff localbnff = new bnff(null);
      localbnff.a = bnfh.a(localbnet);
      parambnet.add(localbnff);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambnet));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfc
 * JD-Core Version:    0.7.0.1
 */