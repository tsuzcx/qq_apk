import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class aylx
  implements View.OnClickListener
{
  aylx(aylv paramaylv, ayjl paramayjl) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = this.jdField_a_of_type_Ayjl.b();
    if ((localObject instanceof BaseActivity))
    {
      ayrd.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      aylv.a(this.jdField_a_of_type_Aylv, (Activity)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylx
 * JD-Core Version:    0.7.0.1
 */