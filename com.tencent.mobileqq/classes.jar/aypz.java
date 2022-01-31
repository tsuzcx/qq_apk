import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.2;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.3;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aypz
  implements aypx<ayjp>
{
  public amej a;
  public QQAppInterface a;
  public String a;
  
  public aypz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amej = ((amej)paramQQAppInterface.getManager(105));
  }
  
  private List<ayjp> a(String paramString, FullMessageSearchResult paramFullMessageSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFullMessageSearchResult != null) && (paramFullMessageSearchResult.a != null))
    {
      int i = 0;
      while (i < paramFullMessageSearchResult.a.size())
      {
        localArrayList.add(new ayjp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (FullMessageSearchResult.SearchResultItem)paramFullMessageSearchResult.a.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List<ayjp> a(ayql paramayql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
    }
    this.jdField_a_of_type_JavaLangString = paramayql.jdField_a_of_type_JavaLangString;
    if ((paramayql.jdField_a_of_type_AndroidOsBundle != null) && (paramayql.jdField_a_of_type_AndroidOsBundle.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false))) {}
    for (paramayql = this.jdField_a_of_type_Amej.a(this.jdField_a_of_type_JavaLangString);; paramayql = this.jdField_a_of_type_Amej.b(this.jdField_a_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_JavaLangString, paramayql);
    }
  }
  
  public void a() {}
  
  public void a(ayql paramayql, aypy<ayjp> paramaypy)
  {
    ThreadManager.post(new MessageSearchEngine.1(this, paramaypy, paramayql), 8, null, true);
  }
  
  public void b()
  {
    ThreadManager.post(new MessageSearchEngine.2(this), 8, null, true);
  }
  
  public void c()
  {
    ThreadManager.post(new MessageSearchEngine.3(this, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
  
  public void d()
  {
    ThreadManager.post(new MessageSearchEngine.4(this, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypz
 * JD-Core Version:    0.7.0.1
 */