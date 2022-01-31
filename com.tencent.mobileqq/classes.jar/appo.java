import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class appo
  extends aprh
{
  private appt jdField_a_of_type_Appt;
  private appz jdField_a_of_type_Appz;
  private List<appw> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public appo(Context paramContext, appt paramappt, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Appt = paramappt;
    this.jdField_a_of_type_ArrayOfInt = apuw.a();
  }
  
  public int a()
  {
    return apur.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = apur.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Appz.a(3, 7);
    this.jdField_a_of_type_Appz.a(paramInt);
    this.jdField_a_of_type_Appz.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Appz.a();
  }
  
  public int b()
  {
    return a() + apur.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appo
 * JD-Core Version:    0.7.0.1
 */