import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bfbr
{
  private bfbs jdField_a_of_type_Bfbs;
  private final ConcurrentLinkedQueue<AppBrandPage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bfbr(begz parambegz)
  {
    this.jdField_a_of_type_Bfbs = new bfbs(parambegz);
  }
  
  public bfbs a()
  {
    return this.jdField_a_of_type_Bfbs;
  }
  
  public AppBrandPage a(begz parambegz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    besl.a("AppBrandPagePool", "mBrandPageList size : " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localAppBrandPage == null)
    {
      besl.b("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(parambegz, paramAppBrandPageContainer);
    }
    besl.b("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    if (this.jdField_a_of_type_Bfbs != null) {
      this.jdField_a_of_type_Bfbs.a();
    }
  }
  
  public void a(begz parambegz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) || (parambegz == null)) {}
    do
    {
      return;
      besl.a("AppBrandPagePool", "preLoadAppBrandPage");
      parambegz = new AppBrandPage(parambegz, paramAppBrandPageContainer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambegz);
    } while (this.jdField_a_of_type_Bfbs == null);
    this.jdField_a_of_type_Bfbs.a(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbr
 * JD-Core Version:    0.7.0.1
 */