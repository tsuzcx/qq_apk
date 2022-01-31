import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class avqz
  implements View.OnClickListener
{
  avqz(avqx paramavqx, avon paramavon) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = this.jdField_a_of_type_Avon.b();
    if ((localObject instanceof BaseActivity))
    {
      avwf.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      avqx.a(this.jdField_a_of_type_Avqx, (Activity)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqz
 * JD-Core Version:    0.7.0.1
 */