import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bcly
  extends bcmb
{
  public bcly(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambcmc, paramString, paramInt);
  }
  
  public bcfq a(List<bcfr> paramList, String paramString)
  {
    return null;
  }
  
  public List<bcfq> a(bcmq parambcmq)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    parambcmq = this.jdField_a_of_type_Bcmc.a(parambcmq);
    if (parambcmq != null) {
      localArrayList.addAll(parambcmq);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcly
 * JD-Core Version:    0.7.0.1
 */