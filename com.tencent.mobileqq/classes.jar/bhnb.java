import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bhnb
  implements xik
{
  bhnb(bhmr parambhmr) {}
  
  public void a(xdw paramxdw, bjbs parambjbs)
  {
    if ((parambjbs != null) && (parambjbs.isShowing())) {
      parambjbs.dismiss();
    }
    xii.a(this.a.a);
    if ((paramxdw != null) && (paramxdw.jdField_a_of_type_Int == 0))
    {
      xii.a(paramxdw.jdField_a_of_type_JavaLangString, this.a.a);
      bhmr.a(this.a);
      return;
    }
    if (!bhnv.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131693966, 1).a();
      return;
    }
    this.a.c = "open";
    bhmr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhnb
 * JD-Core Version:    0.7.0.1
 */