import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awrw
  implements View.OnClickListener
{
  public awrw(LocationPickFragment paramLocationPickFragment, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity.setResult(0);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    bdll.b(null, "CliOper", "", "", "0X800A963", "0X800A963", 0, 0, "0", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrw
 * JD-Core Version:    0.7.0.1
 */