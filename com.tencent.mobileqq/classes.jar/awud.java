import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awud
  extends awut
{
  public awud(GroupSearchEngine paramGroupSearchEngine, awuu paramawuu, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawuu, paramString, paramInt);
  }
  
  public awoh a(List<awoi> paramList, String paramString)
  {
    return new awnt(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<awoh> a(awvi paramawvi)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramawvi);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awud
 * JD-Core Version:    0.7.0.1
 */