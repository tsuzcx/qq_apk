import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bben
  extends bbfd
{
  public bben(GroupSearchEngine paramGroupSearchEngine, bbfe parambbfe, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, parambbfe, paramString, paramInt1);
  }
  
  public bays a(List<bayt> paramList, String paramString)
  {
    return new baye(paramList, paramString, this.jdField_a_of_type_Int);
  }
  
  public List<bays> a(bbfs parambbfs)
  {
    if (!GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(parambbfs);
    VADHelper.b("voice_search_approximate_cost");
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
    }
    for (;;)
    {
      return localList;
      parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bben
 * JD-Core Version:    0.7.0.1
 */