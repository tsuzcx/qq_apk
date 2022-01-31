import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bddl
  implements vgu
{
  bddl(bddb parambddb) {}
  
  public void a(vcg paramvcg, bepp parambepp)
  {
    if ((parambepp != null) && (parambepp.isShowing())) {
      parambepp.dismiss();
    }
    vgs.a(this.a.a);
    if ((paramvcg != null) && (paramvcg.jdField_a_of_type_Int == 0))
    {
      vgs.a(paramvcg.jdField_a_of_type_JavaLangString, this.a.a);
      bddb.a(this.a);
      return;
    }
    if (!bdee.g(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694767, 1).a();
      return;
    }
    this.a.c = "open";
    bddb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bddl
 * JD-Core Version:    0.7.0.1
 */