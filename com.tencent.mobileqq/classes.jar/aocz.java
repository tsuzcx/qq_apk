import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class aocz
  extends anzk
{
  private anyg jdField_a_of_type_Anyg;
  protected anyk a;
  private List<anyh> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public aocz(Context paramContext, anyg paramanyg, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Anyg = paramanyg;
    this.jdField_a_of_type_ArrayOfInt = aocw.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Anyg = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = aocw.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Anyk == null)
    {
      this.jdField_a_of_type_Anyk = new anzl(this, 2007);
      this.jdField_a_of_type_Anyk.a(true);
      this.jdField_a_of_type_Anyk.c(false);
      this.jdField_a_of_type_Anyk.b(false);
      anyh localanyh = new anyh();
      localanyh.h = "delete";
      this.jdField_a_of_type_Anyk.a(localanyh);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Anyg);
    paramView.setAdapter(this.jdField_a_of_type_Anyk);
    c();
    this.jdField_a_of_type_Anyk.a(paramInt);
    this.jdField_a_of_type_Anyk.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anyk.a();
  }
  
  public int b()
  {
    return aocu.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Anyk != null) {
      this.jdField_a_of_type_Anyk.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocz
 * JD-Core Version:    0.7.0.1
 */