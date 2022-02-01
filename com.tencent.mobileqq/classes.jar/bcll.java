import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bcll
  extends bcmb
{
  public bcll(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambcmc, paramString, paramInt);
  }
  
  public bcfq a(List<bcfr> paramList, String paramString)
  {
    return new bcfc(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bcfq> a(bcmq parambcmq)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(parambcmq);
    VADHelper.b("voice_search_approximate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambcmq.a == null) {
        parambcmq.a = new Bundle();
      }
      parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bcfq)localList.get(1)).a().size());
        }
        parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bcfq)localList.get(1)).a().size());
      }
    }
    for (;;)
    {
      return localList;
      parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcll
 * JD-Core Version:    0.7.0.1
 */