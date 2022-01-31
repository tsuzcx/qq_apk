import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class awuq
  extends awut
{
  public awuq(GroupSearchEngine paramGroupSearchEngine, awuu paramawuu, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawuu, paramString, paramInt);
  }
  
  public awoh a(List<awoi> paramList, String paramString)
  {
    return null;
  }
  
  public List<awoh> a(awvi paramawvi)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramawvi.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramawvi = this.jdField_a_of_type_Awuu.a(paramawvi);
    if (paramawvi != null) {
      localArrayList.addAll(paramawvi);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuq
 * JD-Core Version:    0.7.0.1
 */