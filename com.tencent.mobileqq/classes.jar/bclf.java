import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bclf
  extends bclv
{
  public bclf(GroupSearchEngine paramGroupSearchEngine, bclw parambclw, String paramString, int paramInt1, int paramInt2)
  {
    super(paramGroupSearchEngine, parambclw, paramString, paramInt1);
  }
  
  public bcfi a(List<bcfj> paramList, String paramString)
  {
    return new bceu(paramList, paramString, this.jdField_a_of_type_Int);
  }
  
  public List<bcfi> a(bcmk parambcmk)
  {
    if (!GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) {
      return null;
    }
    VADHelper.a("voice_search_approximate_cost");
    List localList = super.a(parambcmk);
    VADHelper.b("voice_search_approximate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambcmk.a == null) {
        parambcmk.a = new Bundle();
      }
      parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bcfi)localList.get(1)).a().size());
        }
        parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bcfi)localList.get(1)).a().size());
      }
    }
    for (;;)
    {
      return localList;
      parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclf
 * JD-Core Version:    0.7.0.1
 */