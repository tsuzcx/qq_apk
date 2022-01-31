import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import java.util.List;

public class aptx
  extends apvq
{
  private apuc jdField_a_of_type_Apuc;
  private apui jdField_a_of_type_Apui;
  private List<apuf> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public aptx(Context paramContext, apuc paramapuc, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_Apuc = paramapuc;
    this.jdField_a_of_type_ArrayOfInt = apzf.a();
  }
  
  public int a()
  {
    return apza.a(this.jdField_a_of_type_ArrayOfInt);
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
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= b());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = apza.a(this.jdField_a_of_type_ArrayOfInt);
      }
    } while (i != 2007);
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
    this.jdField_a_of_type_Apui.a(3, 7);
    this.jdField_a_of_type_Apui.a(paramInt);
    this.jdField_a_of_type_Apui.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Apui.a();
  }
  
  public int b()
  {
    return a() + apza.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptx
 * JD-Core Version:    0.7.0.1
 */