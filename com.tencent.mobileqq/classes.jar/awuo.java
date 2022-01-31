import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class awuo
  extends awur
{
  public awuo(GroupSearchEngine paramGroupSearchEngine, awus paramawus, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramawus, paramString, paramInt);
  }
  
  public awof a(List<awog> paramList, String paramString)
  {
    return null;
  }
  
  public List<awof> a(awvg paramawvg)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramawvg.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramawvg = this.jdField_a_of_type_Awus.a(paramawvg);
    if (paramawvg != null) {
      localArrayList.addAll(paramawvg);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuo
 * JD-Core Version:    0.7.0.1
 */