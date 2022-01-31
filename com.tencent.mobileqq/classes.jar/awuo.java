import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public class awuo
  extends awut
{
  public awuo(GroupSearchEngine paramGroupSearchEngine, awuu paramawuu, String paramString, int paramInt)
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
    if (paramawvi.jdField_a_of_type_AndroidOsBundle == null) {
      paramawvi.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    ArrayList localArrayList = new ArrayList();
    paramawvi = new awnx(paramawvi.jdField_a_of_type_JavaLangString, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
    localArrayList.add(new awnp(paramawvi));
    localArrayList.add(paramawvi);
    awvz.a(0);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuo
 * JD-Core Version:    0.7.0.1
 */