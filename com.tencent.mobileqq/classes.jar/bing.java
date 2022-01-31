import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.7.1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bing
  implements bjob<bimx>
{
  bing(bimz parambimz) {}
  
  public void a(@Nullable bimx parambimx)
  {
    Object localObject = bimt.a(parambimx);
    parambimx = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bimx localbimx = (bimx)((Iterator)localObject).next();
      binj localbinj = new binj(null);
      localbinj.a = binl.a(localbimx);
      parambimx.add(localbinj);
    }
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.7.1(this, parambimx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bing
 * JD-Core Version:    0.7.0.1
 */