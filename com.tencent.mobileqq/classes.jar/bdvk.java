import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bdvk
{
  private bdcz jdField_a_of_type_Bdcz;
  private ConcurrentHashMap<AppBrandPageContainer, bdux> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bdvk(bdcz parambdcz)
  {
    this.jdField_a_of_type_Bdcz = parambdcz;
  }
  
  public bdux a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    bdux localbdux = (bdux)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramAppBrandPageContainer);
    if (localbdux == null)
    {
      bdnw.b("PageWebviewPool", "get page form new BrandPageWebview.");
      return new bdux(this.jdField_a_of_type_Bdcz, paramAppBrandPageContainer);
    }
    bdnw.b("PageWebviewPool", "get page from cache.");
    return localbdux;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        bdux localbdux = (bdux)((Map.Entry)localIterator.next()).getValue();
        if (localbdux != null) {
          localbdux.c();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("PageWebviewPool", "destroyCachePage error:", localException);
    }
  }
  
  public void a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAppBrandPageContainer)) {
      return;
    }
    bdnw.b("PageWebviewPool", "preLoad page");
    bdux localbdux = new bdux(this.jdField_a_of_type_Bdcz, paramAppBrandPageContainer);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppBrandPageContainer, localbdux);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvk
 * JD-Core Version:    0.7.0.1
 */