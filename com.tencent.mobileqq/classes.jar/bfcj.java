import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bfcj
{
  private behq jdField_a_of_type_Behq;
  private ConcurrentHashMap<AppBrandPageContainer, bfbw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bfcj(behq parambehq)
  {
    this.jdField_a_of_type_Behq = parambehq;
  }
  
  public bfbw a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    bfbw localbfbw = (bfbw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramAppBrandPageContainer);
    if (localbfbw == null)
    {
      betc.b("PageWebviewPool", "get page form new BrandPageWebview.");
      return new bfbw(this.jdField_a_of_type_Behq, paramAppBrandPageContainer);
    }
    betc.b("PageWebviewPool", "get page from cache.");
    return localbfbw;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        bfbw localbfbw = (bfbw)((Map.Entry)localIterator.next()).getValue();
        if (localbfbw != null) {
          localbfbw.c();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      betc.d("PageWebviewPool", "destroyCachePage error:", localException);
    }
  }
  
  public void a(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAppBrandPageContainer)) {
      return;
    }
    betc.b("PageWebviewPool", "preLoad page");
    bfbw localbfbw = new bfbw(this.jdField_a_of_type_Behq, paramAppBrandPageContainer);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppBrandPageContainer, localbfbw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcj
 * JD-Core Version:    0.7.0.1
 */