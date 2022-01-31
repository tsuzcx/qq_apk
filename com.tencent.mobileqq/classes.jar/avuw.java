import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avuw
  extends avuy
{
  public avuw(GroupSearchEngine paramGroupSearchEngine, avuz paramavuz, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramavuz, paramString, paramInt);
  }
  
  public avom a(List<avon> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new avnx(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<avom> a(avvn paramavvn)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramavvn);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramavvn.a == null) {
        paramavvn.a = new Bundle();
      }
      paramavvn.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((avom)localList.get(1)).a().size());
        }
        paramavvn.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((avom)localList.get(1)).a().size());
      }
      return localList;
    }
    paramavvn.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected avom b(List<avon> paramList, String paramString)
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
      avon localavon = (avon)paramList.next();
      if (!avwf.a(localavon)) {
        localArrayList.add(localavon);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new avnx(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected avom c(List<avon> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      avon localavon = (avon)paramList.next();
      if (avwf.a(localavon)) {
        localArrayList.add(localavon);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new avnz(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuw
 * JD-Core Version:    0.7.0.1
 */