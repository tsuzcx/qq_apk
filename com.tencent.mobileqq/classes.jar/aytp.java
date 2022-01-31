import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aytp
  extends ayuf
{
  public aytp(GroupSearchEngine paramGroupSearchEngine, ayug paramayug, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramayug, paramString, paramInt);
  }
  
  public aynt a(List<aynu> paramList, String paramString)
  {
    return new aynf(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<aynt> a(ayuu paramayuu)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramayuu);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytp
 * JD-Core Version:    0.7.0.1
 */