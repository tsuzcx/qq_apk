import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment.4.1.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bngs
  implements wlq
{
  bngs(bngr parambngr) {}
  
  public void a(int paramInt, wlr paramwlr, List<TroopBarPOI> paramList)
  {
    paramwlr = new ArrayList();
    if ((paramInt == 0) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
        if (localTroopBarPOI != null) {
          paramwlr.add(new bngw(localTroopBarPOI.c, 0));
        }
      }
    }
    ThreadManager.getUIHandler().post(new AESelectLocationFragment.4.1.1(this, paramInt, paramwlr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngs
 * JD-Core Version:    0.7.0.1
 */