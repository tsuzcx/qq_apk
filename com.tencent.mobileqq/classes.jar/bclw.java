import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class bclw
  extends bcmb
{
  public bclw(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
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
    if (parambcmq.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmq.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    parambcmq = new bcfg(parambcmq.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new bcey(parambcmq));
    localArrayList.add(parambcmq);
    bcnh.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclw
 * JD-Core Version:    0.7.0.1
 */