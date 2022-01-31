import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awup
  extends awur
{
  public awup(GroupSearchEngine paramGroupSearchEngine, awus paramawus, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawus, paramString, paramInt);
  }
  
  public awof a(List<awog> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new awnq(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<awof> a(awvg paramawvg)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramawvg);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramawvg.a == null) {
        paramawvg.a = new Bundle();
      }
      paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((awof)localList.get(1)).a().size());
        }
        paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((awof)localList.get(1)).a().size());
      }
      return localList;
    }
    paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected awof b(List<awog> paramList, String paramString)
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
      awog localawog = (awog)paramList.next();
      if (!awvy.a(localawog)) {
        localArrayList.add(localawog);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new awnq(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected awof c(List<awog> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      awog localawog = (awog)paramList.next();
      if (awvy.a(localawog)) {
        localArrayList.add(localawog);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new awns(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awup
 * JD-Core Version:    0.7.0.1
 */