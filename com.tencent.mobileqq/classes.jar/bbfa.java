import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bbfa
  extends bbfd
{
  public bbfa(GroupSearchEngine paramGroupSearchEngine, bbfe parambbfe, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambbfe, paramString, paramInt);
  }
  
  public bays a(List<bayt> paramList, String paramString)
  {
    return null;
  }
  
  public List<bays> a(bbfs parambbfs)
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = -1;
    parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    parambbfs.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    parambbfs = this.jdField_a_of_type_Bbfe.a(parambbfs);
    if (parambbfs != null) {
      localArrayList.addAll(parambbfs);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfa
 * JD-Core Version:    0.7.0.1
 */