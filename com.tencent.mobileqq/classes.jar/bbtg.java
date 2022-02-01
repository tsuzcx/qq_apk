import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbtg
  extends bbti
{
  public bbtg(GroupSearchEngine paramGroupSearchEngine, bbtj parambbtj, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambbtj, paramString, paramInt);
  }
  
  public bbmx a(List<bbmy> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new bbmi(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bbmx> a(bbtx parambbtx)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(parambbtx);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambbtx.a == null) {
        parambbtx.a = new Bundle();
      }
      parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bbmx)localList.get(1)).a().size());
        }
        parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bbmx)localList.get(1)).a().size());
      }
      return localList;
    }
    parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected bbmx b(List<bbmy> paramList, String paramString)
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
      bbmy localbbmy = (bbmy)paramList.next();
      if (!bbup.a(localbbmy)) {
        localArrayList.add(localbbmy);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bbmi(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected bbmx c(List<bbmy> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbmy localbbmy = (bbmy)paramList.next();
      if (bbup.a(localbbmy)) {
        localArrayList.add(localbbmy);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bbmk(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtg
 * JD-Core Version:    0.7.0.1
 */