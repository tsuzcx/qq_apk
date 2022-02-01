import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bchw
  implements View.OnClickListener
{
  bchw(bchu parambchu, bcfj parambcfj) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    String str = this.jdField_a_of_type_Bcfj.b();
    if ((localObject instanceof BaseActivity))
    {
      bcnc.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      bchu.a(this.jdField_a_of_type_Bchu, (Activity)localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchw
 * JD-Core Version:    0.7.0.1
 */