import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class aocu
  extends anzf
{
  private anyb jdField_a_of_type_Anyb;
  protected anyf a;
  private List<anyc> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public aocu(Context paramContext, anyb paramanyb, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Anyb = paramanyb;
    this.jdField_a_of_type_ArrayOfInt = aocr.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Anyb = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = aocr.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Anyf == null)
    {
      this.jdField_a_of_type_Anyf = new anzg(this, 2007);
      this.jdField_a_of_type_Anyf.a(true);
      this.jdField_a_of_type_Anyf.c(false);
      this.jdField_a_of_type_Anyf.b(false);
      anyc localanyc = new anyc();
      localanyc.h = "delete";
      this.jdField_a_of_type_Anyf.a(localanyc);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Anyb);
    paramView.setAdapter(this.jdField_a_of_type_Anyf);
    c();
    this.jdField_a_of_type_Anyf.a(paramInt);
    this.jdField_a_of_type_Anyf.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anyf.a();
  }
  
  public int b()
  {
    return aocp.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Anyf != null) {
      this.jdField_a_of_type_Anyf.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocu
 * JD-Core Version:    0.7.0.1
 */