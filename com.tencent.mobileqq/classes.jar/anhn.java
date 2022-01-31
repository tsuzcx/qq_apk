import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class anhn
  extends aniw
{
  private anhs jdField_a_of_type_Anhs;
  private anhw jdField_a_of_type_Anhw;
  private List<anht> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public anhn(Context paramContext, anhs paramanhs, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Anhs = paramanhs;
    this.jdField_a_of_type_ArrayOfInt = anmh.a();
  }
  
  public int a()
  {
    return anmf.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = anmf.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Anhw.a(3, 7);
    this.jdField_a_of_type_Anhw.a(paramInt);
    this.jdField_a_of_type_Anhw.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anhw.a();
  }
  
  public int b()
  {
    return a() + anmf.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */