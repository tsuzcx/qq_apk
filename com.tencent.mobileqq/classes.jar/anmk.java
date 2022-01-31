import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class anmk
  extends aniw
{
  private anhs jdField_a_of_type_Anhs;
  protected anhw a;
  private List<anht> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public anmk(Context paramContext, anhs paramanhs, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Anhs = paramanhs;
    this.jdField_a_of_type_ArrayOfInt = anmh.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Anhs = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = anmh.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Anhw == null)
    {
      this.jdField_a_of_type_Anhw = new anix(this, 2007);
      this.jdField_a_of_type_Anhw.a(true);
      this.jdField_a_of_type_Anhw.c(false);
      this.jdField_a_of_type_Anhw.b(false);
      anht localanht = new anht();
      localanht.h = "delete";
      this.jdField_a_of_type_Anhw.a(localanht);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Anhs);
    paramView.setAdapter(this.jdField_a_of_type_Anhw);
    c();
    this.jdField_a_of_type_Anhw.a(paramInt);
    this.jdField_a_of_type_Anhw.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anhw.a();
  }
  
  public int b()
  {
    return anmf.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Anhw != null) {
      this.jdField_a_of_type_Anhw.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anmk
 * JD-Core Version:    0.7.0.1
 */