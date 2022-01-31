import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhac
  implements bghv<bgms>
{
  public static bgms a(bgho parambgho)
  {
    return (bgms)parambgho.a(new bhac());
  }
  
  public bgms a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer))
    {
      QMLog.w("Action", "Excepted AppBrandPageContainer, but is " + parambghl);
      return null;
    }
    return ((AppBrandPageContainer)parambghl).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhac
 * JD-Core Version:    0.7.0.1
 */