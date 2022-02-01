import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbjw
  extends anxt
{
  public bbjw(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "unify handleBusiHotWordError code=" + paramInt + " errorMsg;" + paramString);
    }
  }
  
  public void a(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.jdField_a_of_type_Int = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel()) {
      QLog.i(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "unify handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjw
 * JD-Core Version:    0.7.0.1
 */