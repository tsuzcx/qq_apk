import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bhgf
{
  private bhgg jdField_a_of_type_Bhgg;
  private final ConcurrentLinkedQueue<AppBrandPage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bhgf(bglv parambglv)
  {
    this.jdField_a_of_type_Bhgg = new bhgg(parambglv);
  }
  
  public bhgg a()
  {
    return this.jdField_a_of_type_Bhgg;
  }
  
  public AppBrandPage a(bglv parambglv, AppBrandPageContainer paramAppBrandPageContainer)
  {
    QMLog.d("AppBrandPagePool", "mBrandPageList size : " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    AppBrandPage localAppBrandPage = (AppBrandPage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localAppBrandPage == null)
    {
      QMLog.i("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(parambglv, paramAppBrandPageContainer);
    }
    QMLog.i("AppBrandPagePool", "getAppBrandPage from cache.");
    return localAppBrandPage;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    if (this.jdField_a_of_type_Bhgg != null) {
      this.jdField_a_of_type_Bhgg.a();
    }
  }
  
  public void a(bglv parambglv, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) || (parambglv == null)) {}
    do
    {
      return;
      QMLog.d("AppBrandPagePool", "preLoadAppBrandPage");
      parambglv = new AppBrandPage(parambglv, paramAppBrandPageContainer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambglv);
    } while (this.jdField_a_of_type_Bhgg == null);
    this.jdField_a_of_type_Bhgg.a(paramAppBrandPageContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgf
 * JD-Core Version:    0.7.0.1
 */