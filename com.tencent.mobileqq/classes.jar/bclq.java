import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bclq
  extends bclv
{
  public bclq(GroupSearchEngine paramGroupSearchEngine, bclw parambclw, String paramString, int paramInt)
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
    if (parambcmk.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmk.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    parambcmk = new bcey(parambcmk.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new bceq(parambcmk));
    localArrayList.add(parambcmk);
    bcnb.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclq
 * JD-Core Version:    0.7.0.1
 */