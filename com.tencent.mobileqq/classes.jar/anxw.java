import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class anxw
  extends anzf
{
  private anyb jdField_a_of_type_Anyb;
  private anyf jdField_a_of_type_Anyf;
  private List<anyc> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public anxw(Context paramContext, anyb paramanyb, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Anyb = paramanyb;
    this.jdField_a_of_type_ArrayOfInt = aocr.a();
  }
  
  public int a()
  {
    return aocp.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = aocp.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Anyf.a(3, 7);
    this.jdField_a_of_type_Anyf.a(paramInt);
    this.jdField_a_of_type_Anyf.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anyf.a();
  }
  
  public int b()
  {
    return a() + aocp.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxw
 * JD-Core Version:    0.7.0.1
 */