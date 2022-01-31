import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class awqs
  implements View.OnClickListener
{
  awqs(awqq paramawqq, awog paramawog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = this.jdField_a_of_type_Awog.b();
    if ((localObject instanceof BaseActivity))
    {
      awvy.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      awqq.a(this.jdField_a_of_type_Awqq, (Activity)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqs
 * JD-Core Version:    0.7.0.1
 */