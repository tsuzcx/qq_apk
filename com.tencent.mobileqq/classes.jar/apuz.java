import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class apuz
  extends aprh
{
  private appt jdField_a_of_type_Appt;
  protected appz a;
  private List<appw> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public apuz(Context paramContext, appt paramappt, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Appt = paramappt;
    this.jdField_a_of_type_ArrayOfInt = apuw.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Appt = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = apuw.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Appz == null)
    {
      this.jdField_a_of_type_Appz = new apri(this, 2007);
      this.jdField_a_of_type_Appz.a(true);
      this.jdField_a_of_type_Appz.c(false);
      this.jdField_a_of_type_Appz.b(false);
      appw localappw = new appw();
      localappw.i = "delete";
      this.jdField_a_of_type_Appz.a(localappw);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Appt);
    paramView.setAdapter(this.jdField_a_of_type_Appz);
    c();
    this.jdField_a_of_type_Appz.a(paramInt);
    this.jdField_a_of_type_Appz.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Appz.a();
  }
  
  public int b()
  {
    return apur.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Appz != null) {
      this.jdField_a_of_type_Appz.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuz
 * JD-Core Version:    0.7.0.1
 */