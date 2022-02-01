import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class bcmi
  implements bcmd
{
  public bcmi(NetSearchEngine paramNetSearchEngine, List paramList) {}
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    bcni.a();
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).a.countDown();
  }
  
  public void a(List paramList, bcmr parambcmr)
  {
    a(paramList, parambcmr.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmi
 * JD-Core Version:    0.7.0.1
 */