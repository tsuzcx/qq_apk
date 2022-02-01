import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbss
  extends bbti
{
  public bbss(GroupSearchEngine paramGroupSearchEngine, bbtj parambbtj, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambbtj, paramString, paramInt);
  }
  
  public bbmx a(List<bbmy> paramList, String paramString)
  {
    return new bbmj(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bbmx> a(bbtx parambbtx)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(parambbtx);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbss
 * JD-Core Version:    0.7.0.1
 */