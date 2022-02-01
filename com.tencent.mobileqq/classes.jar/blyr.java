import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

class blyr
  extends blys
{
  private blyr()
  {
    super(null);
  }
  
  protected void a(HashMap<blyq, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      blyu localblyu = new blyu(null);
      localblyu.a((blyq)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localblyu.a((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localblyu.a());
    }
    bccr.a(8, localAppRuntime, new blyv(null).a(localAppRuntime.getLongAccountUin()).a(bmvl.c()).a(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyr
 * JD-Core Version:    0.7.0.1
 */