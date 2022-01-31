import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class apzi
  extends apvq
{
  private apuc jdField_a_of_type_Apuc;
  protected apui a;
  private List<apuf> jdField_a_of_type_JavaUtilList;
  protected int[] a;
  
  public apzi(Context paramContext, apuc paramapuc, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_Apuc = paramapuc;
    this.jdField_a_of_type_ArrayOfInt = apzf.a();
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Apuc = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= b())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = apzf.a(this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_Apui == null)
    {
      this.jdField_a_of_type_Apui = new apvr(this, 2007);
      this.jdField_a_of_type_Apui.a(true);
      this.jdField_a_of_type_Apui.c(false);
      this.jdField_a_of_type_Apui.b(false);
      apuf localapuf = new apuf();
      localapuf.i = "delete";
      this.jdField_a_of_type_Apui.a(localapuf);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_Apuc);
    paramView.setAdapter(this.jdField_a_of_type_Apui);
    c();
    this.jdField_a_of_type_Apui.a(paramInt);
    this.jdField_a_of_type_Apui.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Apui.a();
  }
  
  public int b()
  {
    return apza.a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Apui != null) {
      this.jdField_a_of_type_Apui.a(3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzi
 * JD-Core Version:    0.7.0.1
 */