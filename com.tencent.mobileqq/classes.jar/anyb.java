import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class anyb
  extends anzk
{
  private anyg jdField_a_of_type_Anyg;
  private anyk jdField_a_of_type_Anyk;
  private List<anyh> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public anyb(Context paramContext, anyg paramanyg, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Anyg = paramanyg;
    this.jdField_a_of_type_ArrayOfInt = aocw.a();
  }
  
  public int a()
  {
    return aocu.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = aocu.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Anyk.a(3, 7);
    this.jdField_a_of_type_Anyk.a(paramInt);
    this.jdField_a_of_type_Anyk.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Anyk.a();
  }
  
  public int b()
  {
    return a() + aocu.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyb
 * JD-Core Version:    0.7.0.1
 */