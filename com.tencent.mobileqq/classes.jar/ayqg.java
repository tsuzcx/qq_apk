import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class ayqg
  implements View.OnClickListener
{
  ayqg(ayqe paramayqe, aynu paramaynu) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = this.jdField_a_of_type_Aynu.b();
    if ((localObject instanceof BaseActivity))
    {
      ayvm.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      ayqe.a(this.jdField_a_of_type_Ayqe, (Activity)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqg
 * JD-Core Version:    0.7.0.1
 */