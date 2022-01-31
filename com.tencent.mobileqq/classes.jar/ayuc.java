import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class ayuc
  extends ayuf
{
  public ayuc(GroupSearchEngine paramGroupSearchEngine, ayug paramayug, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramayug, paramString, paramInt);
  }
  
  public aynt a(List<aynu> paramList, String paramString)
  {
    return null;
  }
  
  public List<aynt> a(ayuu paramayuu)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramayuu.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramayuu = this.jdField_a_of_type_Ayug.a(paramayuu);
    if (paramayuu != null) {
      localArrayList.addAll(paramayuu);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuc
 * JD-Core Version:    0.7.0.1
 */