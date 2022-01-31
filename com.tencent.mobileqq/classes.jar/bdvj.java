import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bdvj
{
  private bdvk jdField_a_of_type_Bdvk;
  private final ConcurrentLinkedQueue<AppBrandPage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bdvj(bdcz parambdcz)
  {
    this.jdField_a_of_type_Bdvk = new bdvk(parambdcz);
  }
  
  public bdvk a()
  {
    return this.jdField_a_of_type_Bdvk;
  }
  
  public AppBrandPage a(bdcz parambdcz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    bdnw.a("AppBrandPagePool", "mBrandPageList size : " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localAppBrandPage == null)
    {
      bdnw.b("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(parambdcz, paramAppBrandPageContainer);
    }
    bdnw.b("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    if (this.jdField_a_of_type_Bdvk != null) {
      this.jdField_a_of_type_Bdvk.a();
    }
  }
  
  public void a(bdcz parambdcz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) || (parambdcz == null)) {}
    do
    {
      return;
      bdnw.a("AppBrandPagePool", "preLoadAppBrandPage");
      parambdcz = new AppBrandPage(parambdcz, paramAppBrandPageContainer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambdcz);
    } while (this.jdField_a_of_type_Bdvk == null);
    this.jdField_a_of_type_Bdvk.a(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvj
 * JD-Core Version:    0.7.0.1
 */