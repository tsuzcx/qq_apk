import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class awqu
  implements View.OnClickListener
{
  awqu(awqs paramawqs, awoi paramawoi) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = this.jdField_a_of_type_Awoi.b();
    if ((localObject instanceof BaseActivity))
    {
      awwa.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      awqs.a(this.jdField_a_of_type_Awqs, (Activity)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqu
 * JD-Core Version:    0.7.0.1
 */