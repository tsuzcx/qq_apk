import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bbtf
  extends bbti
{
  public bbtf(GroupSearchEngine paramGroupSearchEngine, bbtj parambbtj, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambbtj, paramString, paramInt);
  }
  
  public bbmx a(List<bbmy> paramList, String paramString)
  {
    return null;
  }
  
  public List<bbmx> a(bbtx parambbtx)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    parambbtx.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    parambbtx = this.jdField_a_of_type_Bbtj.a(parambbtx);
    if (parambbtx != null) {
      localArrayList.addAll(parambbtx);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtf
 * JD-Core Version:    0.7.0.1
 */