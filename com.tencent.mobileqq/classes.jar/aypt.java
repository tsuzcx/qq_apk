import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class aypt
  extends aypw
{
  public aypt(GroupSearchEngine paramGroupSearchEngine, aypx paramaypx, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramaypx, paramString, paramInt);
  }
  
  public ayjk a(List<ayjl> paramList, String paramString)
  {
    return null;
  }
  
  public List<ayjk> a(ayql paramayql)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    paramayql.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramayql.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramayql = this.jdField_a_of_type_Aypx.a(paramayql);
    if (paramayql != null) {
      localArrayList.addAll(paramayql);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */