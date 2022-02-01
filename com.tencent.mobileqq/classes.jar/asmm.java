import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class asmm
  extends asol
{
  private asmr jdField_a_of_type_Asmr;
  private asmx jdField_a_of_type_Asmx;
  private List<asmu> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public asmm(Context paramContext, asmr paramasmr, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Asmr = paramasmr;
    this.jdField_a_of_type_ArrayOfInt = assp.a();
  }
  
  public int a()
  {
    return assj.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = assj.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Asmx.a(3, 7);
    this.jdField_a_of_type_Asmx.a(paramInt);
    this.jdField_a_of_type_Asmx.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Asmx.a();
  }
  
  public int b()
  {
    return a() + assj.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmm
 * JD-Core Version:    0.7.0.1
 */