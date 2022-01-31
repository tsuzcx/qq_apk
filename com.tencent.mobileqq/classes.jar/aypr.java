import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class aypr
  extends aypw
{
  public aypr(GroupSearchEngine paramGroupSearchEngine, aypx paramaypx, String paramString, int paramInt)
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
    if (paramayql.jdField_a_of_type_AndroidOsBundle == null) {
      paramayql.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    paramayql = new ayja(paramayql.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new ayis(paramayql));
    localArrayList.add(paramayql);
    ayrc.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypr
 * JD-Core Version:    0.7.0.1
 */