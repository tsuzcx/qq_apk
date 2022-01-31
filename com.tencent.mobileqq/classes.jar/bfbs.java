import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bfbs
{
  private begz jdField_a_of_type_Begz;
  private ConcurrentHashMap<AppBrandPageContainer, bfbf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bfbs(begz parambegz)
  {
    this.jdField_a_of_type_Begz = parambegz;
  }
  
  public bfbf a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    bfbf localbfbf = (bfbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramAppBrandPageContainer);
    if (localbfbf == null)
    {
      besl.b("PageWebviewPool", "get page form new BrandPageWebview.");
      return new bfbf(this.jdField_a_of_type_Begz, paramAppBrandPageContainer);
    }
    besl.b("PageWebviewPool", "get page from cache.");
    return localbfbf;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        bfbf localbfbf = (bfbf)((Map.Entry)localIterator.next()).getValue();
        if (localbfbf != null) {
          localbfbf.c();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      besl.d("PageWebviewPool", "destroyCachePage error:", localException);
    }
  }
  
  public void a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAppBrandPageContainer)) {
      return;
    }
    besl.b("PageWebviewPool", "preLoad page");
    bfbf localbfbf = new bfbf(this.jdField_a_of_type_Begz, paramAppBrandPageContainer);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppBrandPageContainer, localbfbf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbs
 * JD-Core Version:    0.7.0.1
 */