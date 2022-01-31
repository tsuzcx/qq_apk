import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bhbz
{
  private bgho jdField_a_of_type_Bgho;
  private ConcurrentHashMap<AppBrandPageContainer, bhbi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bhbz(bgho parambgho)
  {
    this.jdField_a_of_type_Bgho = parambgho;
  }
  
  public bhbi a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    bhbi localbhbi = (bhbi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramAppBrandPageContainer);
    if (localbhbi == null)
    {
      QMLog.i("PageWebviewPool", "get page form new BrandPageWebview.");
      return new bhbi(this.jdField_a_of_type_Bgho, paramAppBrandPageContainer);
    }
    QMLog.i("PageWebviewPool", "get page from cache.");
    return localbhbi;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        bhbi localbhbi = (bhbi)((Map.Entry)localIterator.next()).getValue();
        if (localbhbi != null) {
          localbhbi.c();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PageWebviewPool", "destroyCachePage error:", localException);
    }
  }
  
  public void a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAppBrandPageContainer)) {
      return;
    }
    QMLog.i("PageWebviewPool", "preLoad page");
    bhbi localbhbi = new bhbi(this.jdField_a_of_type_Bgho, paramAppBrandPageContainer);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppBrandPageContainer, localbhbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbz
 * JD-Core Version:    0.7.0.1
 */