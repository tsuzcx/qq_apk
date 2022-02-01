import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbfb
  extends bbfd
{
  public bbfb(GroupSearchEngine paramGroupSearchEngine, bbfe parambbfe, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambbfe, paramString, paramInt);
  }
  
  public bays a(List<bayt> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new bayd(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bays> a(bbfs parambbfs)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(parambbfs);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambbfs.a == null) {
        parambbfs.a = new Bundle();
      }
      parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bays)localList.get(1)).a().size());
        }
        parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bays)localList.get(1)).a().size());
      }
      return localList;
    }
    parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected bays b(List<bayt> paramList, String paramString)
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
      bayt localbayt = (bayt)paramList.next();
      if (!bbgk.a(localbayt)) {
        localArrayList.add(localbayt);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bayd(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected bays c(List<bayt> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bayt localbayt = (bayt)paramList.next();
      if (bbgk.a(localbayt)) {
        localArrayList.add(localbayt);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bayf(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfb
 * JD-Core Version:    0.7.0.1
 */