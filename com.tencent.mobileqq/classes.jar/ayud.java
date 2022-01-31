import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayud
  extends ayuf
{
  public ayud(GroupSearchEngine paramGroupSearchEngine, ayug paramayug, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramayug, paramString, paramInt);
  }
  
  public aynt a(List<aynu> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new ayne(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<aynt> a(ayuu paramayuu)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramayuu);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramayuu.a == null) {
        paramayuu.a = new Bundle();
      }
      paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((aynt)localList.get(1)).a().size());
        }
        paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((aynt)localList.get(1)).a().size());
      }
      return localList;
    }
    paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected aynt b(List<aynu> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aynu localaynu = (aynu)paramList.next();
      if (!ayvm.a(localaynu)) {
        localArrayList.add(localaynu);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ayne(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected aynt c(List<aynu> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aynu localaynu = (aynu)paramList.next();
      if (ayvm.a(localaynu)) {
        localArrayList.add(localaynu);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ayng(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayud
 * JD-Core Version:    0.7.0.1
 */