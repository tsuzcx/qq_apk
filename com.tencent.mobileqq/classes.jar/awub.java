import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class awub
  extends awur
{
  public awub(GroupSearchEngine paramGroupSearchEngine, awus paramawus, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawus, paramString, paramInt);
  }
  
  public awof a(List<awog> paramList, String paramString)
  {
    return new awnr(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<awof> a(awvg paramawvg)
  {
    if (!GroupSearchEngine.a(this.a)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(paramawvg);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awub
 * JD-Core Version:    0.7.0.1
 */