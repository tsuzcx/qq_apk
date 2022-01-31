import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aypu
  extends aypw
{
  public aypu(GroupSearchEngine paramGroupSearchEngine, aypx paramaypx, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramaypx, paramString, paramInt);
  }
  
  public ayjk a(List<ayjl> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new ayiv(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<ayjk> a(ayql paramayql)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramayql);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramayql.a == null) {
        paramayql.a = new Bundle();
      }
      paramayql.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((ayjk)localList.get(1)).a().size());
        }
        paramayql.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((ayjk)localList.get(1)).a().size());
      }
      return localList;
    }
    paramayql.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected ayjk b(List<ayjl> paramList, String paramString)
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
      ayjl localayjl = (ayjl)paramList.next();
      if (!ayrd.a(localayjl)) {
        localArrayList.add(localayjl);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ayiv(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected ayjk c(List<ayjl> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ayjl localayjl = (ayjl)paramList.next();
      if (ayrd.a(localayjl)) {
        localArrayList.add(localayjl);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new ayix(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypu
 * JD-Core Version:    0.7.0.1
 */