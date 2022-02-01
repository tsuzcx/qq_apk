import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bgmz
  implements xep
{
  bgmz(bgmp parambgmp) {}
  
  public void a(xab paramxab, biau parambiau)
  {
    if ((parambiau != null) && (parambiau.isShowing())) {
      parambiau.dismiss();
    }
    xen.a(this.a.a);
    if ((paramxab != null) && (paramxab.jdField_a_of_type_Int == 0))
    {
      xen.a(paramxab.jdField_a_of_type_JavaLangString, this.a.a);
      bgmp.a(this.a);
      return;
    }
    if (!bgnt.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131693949, 1).a();
      return;
    }
    this.a.c = "open";
    bgmp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgmz
 * JD-Core Version:    0.7.0.1
 */