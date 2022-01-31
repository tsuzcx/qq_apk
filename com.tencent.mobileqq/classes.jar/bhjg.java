import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class bhjg
  implements bgmc<Void>
{
  bhjg(bhje parambhje, int paramInt) {}
  
  public Void a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    do
    {
      do
      {
        return null;
        parambgls = ((AppBrandPageContainer)parambgls).a();
      } while ((parambgls == null) || (parambgls.a() == null));
      parambgls.a().a((byte)1);
    } while (this.jdField_a_of_type_Int != 100);
    parambgls.a().a((byte)2);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjg
 * JD-Core Version:    0.7.0.1
 */