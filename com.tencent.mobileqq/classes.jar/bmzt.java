import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

class bmzt
  extends bmzu
{
  private bmzt()
  {
    super(null);
  }
  
  protected void a(HashMap<bmzs, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      bmzw localbmzw = new bmzw(null);
      localbmzw.a((bmzs)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localbmzw.a((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localbmzw.a());
    }
    bcvj.a(8, localAppRuntime, new bmzx(null).a(localAppRuntime.getLongAccountUin()).a(bnwt.c()).a(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzt
 * JD-Core Version:    0.7.0.1
 */