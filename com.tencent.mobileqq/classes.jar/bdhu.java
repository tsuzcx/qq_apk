import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bdhu
  implements vld
{
  bdhu(bdhk parambdhk) {}
  
  public void a(vgp paramvgp, bety parambety)
  {
    if ((parambety != null) && (parambety.isShowing())) {
      parambety.dismiss();
    }
    vlb.a(this.a.a);
    if ((paramvgp != null) && (paramvgp.jdField_a_of_type_Int == 0))
    {
      vlb.a(paramvgp.jdField_a_of_type_JavaLangString, this.a.a);
      bdhk.a(this.a);
      return;
    }
    if (!bdin.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694769, 1).a();
      return;
    }
    this.a.c = "open";
    bdhk.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhu
 * JD-Core Version:    0.7.0.1
 */