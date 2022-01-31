import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bhby
{
  private bhbz jdField_a_of_type_Bhbz;
  private final ConcurrentLinkedQueue<AppBrandPage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bhby(bgho parambgho)
  {
    this.jdField_a_of_type_Bhbz = new bhbz(parambgho);
  }
  
  public bhbz a()
  {
    return this.jdField_a_of_type_Bhbz;
  }
  
  public AppBrandPage a(bgho parambgho, AppBrandPageContainer paramAppBrandPageContainer)
  {
    QMLog.d("AppBrandPagePool", "mBrandPageList size : " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localAppBrandPage == null)
    {
      QMLog.i("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(parambgho, paramAppBrandPageContainer);
    }
    QMLog.i("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    if (this.jdField_a_of_type_Bhbz != null) {
      this.jdField_a_of_type_Bhbz.a();
    }
  }
  
  public void a(bgho parambgho, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) || (parambgho == null)) {}
    do
    {
      return;
      QMLog.d("AppBrandPagePool", "preLoadAppBrandPage");
      parambgho = new AppBrandPage(parambgho, paramAppBrandPageContainer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambgho);
    } while (this.jdField_a_of_type_Bhbz == null);
    this.jdField_a_of_type_Bhbz.a(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhby
 * JD-Core Version:    0.7.0.1
 */