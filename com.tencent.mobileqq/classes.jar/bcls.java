import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bcls
  extends bclv
{
  public bcls(GroupSearchEngine paramGroupSearchEngine, bclw parambclw, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambclw, paramString, paramInt);
  }
  
  public bcfi a(List<bcfj> paramList, String paramString)
  {
    return null;
  }
  
  public List<bcfi> a(bcmk parambcmk)
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = -1;
    parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    parambcmk = this.jdField_a_of_type_Bclw.a(parambcmk);
    if (parambcmk != null) {
      localArrayList.addAll(parambcmk);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcls
 * JD-Core Version:    0.7.0.1
 */