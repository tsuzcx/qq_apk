import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class asss
  extends asol
{
  private asmr jdField_a_of_type_Asmr;
  protected asmx a;
  private List<asmu> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public asss(Context paramContext, asmr paramasmr, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Asmr = paramasmr;
    this.jdField_a_of_type_ArrayOfInt = assp.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Asmr = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = assp.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Asmx == null)
    {
      this.jdField_a_of_type_Asmx = new asom(this, 2007);
      this.jdField_a_of_type_Asmx.a(true);
      this.jdField_a_of_type_Asmx.c(false);
      this.jdField_a_of_type_Asmx.b(false);
      asmu localasmu = new asmu();
      localasmu.i = "delete";
      this.jdField_a_of_type_Asmx.a(localasmu);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Asmr);
    paramView.setAdapter(this.jdField_a_of_type_Asmx);
    c();
    this.jdField_a_of_type_Asmx.a(paramInt);
    this.jdField_a_of_type_Asmx.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Asmx.a();
  }
  
  public int b()
  {
    return assj.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Asmx != null) {
      this.jdField_a_of_type_Asmx.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asss
 * JD-Core Version:    0.7.0.1
 */