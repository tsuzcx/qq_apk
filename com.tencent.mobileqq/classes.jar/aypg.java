import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aypg
  extends aypw
{
  public aypg(GroupSearchEngine paramGroupSearchEngine, aypx paramaypx, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramaypx, paramString, paramInt);
  }
  
  public ayjk a(List<ayjl> paramList, String paramString)
  {
    return new ayiw(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<ayjk> a(ayql paramayql)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramayql);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramayql.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypg
 * JD-Core Version:    0.7.0.1
 */