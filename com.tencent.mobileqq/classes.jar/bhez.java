import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class bhez
  implements bghv<Void>
{
  bhez(bhex parambhex, int paramInt) {}
  
  public Void a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    do
    {
      do
      {
        return null;
        parambghl = ((AppBrandPageContainer)parambghl).a();
      } while ((parambghl == null) || (parambghl.a() == null));
      parambghl.a().a((byte)1);
    } while (this.jdField_a_of_type_Int != 100);
    parambghl.a().a((byte)2);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhez
 * JD-Core Version:    0.7.0.1
 */