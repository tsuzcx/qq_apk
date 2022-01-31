import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avui
  extends avuy
{
  public avui(GroupSearchEngine paramGroupSearchEngine, avuz paramavuz, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramavuz, paramString, paramInt);
  }
  
  public avom a(List<avon> paramList, String paramString)
  {
    return new avny(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<avom> a(avvn paramavvn)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramavvn);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramavvn.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avui
 * JD-Core Version:    0.7.0.1
 */