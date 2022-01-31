import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bhgg
{
  private bglv jdField_a_of_type_Bglv;
  private ConcurrentHashMap<AppBrandPageContainer, bhfp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bhgg(bglv parambglv)
  {
    this.jdField_a_of_type_Bglv = parambglv;
  }
  
  public bhfp a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    bhfp localbhfp = (bhfp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramAppBrandPageContainer);
    if (localbhfp == null)
    {
      QMLog.i("PageWebviewPool", "get page form new BrandPageWebview.");
      return new bhfp(this.jdField_a_of_type_Bglv, paramAppBrandPageContainer);
    }
    QMLog.i("PageWebviewPool", "get page from cache.");
    return localbhfp;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        bhfp localbhfp = (bhfp)((Map.Entry)localIterator.next()).getValue();
        if (localbhfp != null) {
          localbhfp.c();
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
    bhfp localbhfp = new bhfp(this.jdField_a_of_type_Bglv, paramAppBrandPageContainer);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppBrandPageContainer, localbhfp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgg
 * JD-Core Version:    0.7.0.1
 */