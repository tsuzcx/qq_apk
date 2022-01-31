import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhej
  implements bgmc<bgqz>
{
  public static bgqz a(bglv parambglv)
  {
    return (bgqz)parambglv.a(new bhej());
  }
  
  public bgqz a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer))
    {
      QMLog.w("Action", "Excepted AppBrandPageContainer, but is " + parambgls);
      return null;
    }
    return ((AppBrandPageContainer)parambgls).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhej
 * JD-Core Version:    0.7.0.1
 */