import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awur
  extends awut
{
  public awur(GroupSearchEngine paramGroupSearchEngine, awuu paramawuu, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawuu, paramString, paramInt);
  }
  
  public awoh a(List<awoi> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new awns(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<awoh> a(awvi paramawvi)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramawvi);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramawvi.a == null) {
        paramawvi.a = new Bundle();
      }
      paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((awoh)localList.get(1)).a().size());
        }
        paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((awoh)localList.get(1)).a().size());
      }
      return localList;
    }
    paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected awoh b(List<awoi> paramList, String paramString)
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
      awoi localawoi = (awoi)paramList.next();
      if (!awwa.a(localawoi)) {
        localArrayList.add(localawoi);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new awns(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected awoh c(List<awoi> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      awoi localawoi = (awoi)paramList.next();
      if (awwa.a(localawoi)) {
        localArrayList.add(localawoi);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new awnu(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awur
 * JD-Core Version:    0.7.0.1
 */