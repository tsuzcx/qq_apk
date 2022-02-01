import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class arwy
  extends aryx
{
  private arxd jdField_a_of_type_Arxd;
  private arxj jdField_a_of_type_Arxj;
  private List<arxg> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public arwy(Context paramContext, arxd paramarxd, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Arxd = paramarxd;
    this.jdField_a_of_type_ArrayOfInt = asdb.a();
  }
  
  public int a()
  {
    return ascv.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Arxd = null;
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
        this.jdField_a_of_type_JavaUtilList = ascv.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
    if (this.jdField_a_of_type_Arxj == null)
    {
      this.jdField_a_of_type_Arxj = new aryy(this, 2007);
      this.jdField_a_of_type_Arxj.a(true);
      this.jdField_a_of_type_Arxj.c(false);
      this.jdField_a_of_type_Arxj.b(false);
      arxg localarxg = new arxg();
      localarxg.i = "delete";
      this.jdField_a_of_type_Arxj.a(localarxg);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Arxd);
    paramView.setAdapter(this.jdField_a_of_type_Arxj);
    this.jdField_a_of_type_Arxj.a(3, 7);
    this.jdField_a_of_type_Arxj.a(paramInt);
    this.jdField_a_of_type_Arxj.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arxj.a();
  }
  
  public int b()
  {
    return a() + ascv.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwy
 * JD-Core Version:    0.7.0.1
 */