import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bfci
{
  private bfcj jdField_a_of_type_Bfcj;
  private final ConcurrentLinkedQueue<AppBrandPage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bfci(behq parambehq)
  {
    this.jdField_a_of_type_Bfcj = new bfcj(parambehq);
  }
  
  public bfcj a()
  {
    return this.jdField_a_of_type_Bfcj;
  }
  
  public AppBrandPage a(behq parambehq, AppBrandPageContainer paramAppBrandPageContainer)
  {
    betc.a("AppBrandPagePool", "mBrandPageList size : " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localAppBrandPage == null)
    {
      betc.b("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(parambehq, paramAppBrandPageContainer);
    }
    betc.b("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    if (this.jdField_a_of_type_Bfcj != null) {
      this.jdField_a_of_type_Bfcj.a();
    }
  }
  
  public void a(behq parambehq, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) || (parambehq == null)) {}
    do
    {
      return;
      betc.a("AppBrandPagePool", "preLoadAppBrandPage");
      parambehq = new AppBrandPage(parambehq, paramAppBrandPageContainer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambehq);
    } while (this.jdField_a_of_type_Bfcj == null);
    this.jdField_a_of_type_Bfcj.a(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfci
 * JD-Core Version:    0.7.0.1
 */