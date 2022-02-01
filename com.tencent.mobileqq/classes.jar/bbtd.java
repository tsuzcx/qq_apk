import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bbtd
  extends bbti
{
  public bbtd(GroupSearchEngine paramGroupSearchEngine, bbtj parambbtj, String paramString, int paramInt)
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
    if (parambbtx.jdField_a_of_type_AndroidOsBundle == null) {
      parambbtx.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    parambbtx = new bbmn(parambbtx.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new bbmf(parambbtx));
    localArrayList.add(parambbtx);
    bbuo.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtd
 * JD-Core Version:    0.7.0.1
 */