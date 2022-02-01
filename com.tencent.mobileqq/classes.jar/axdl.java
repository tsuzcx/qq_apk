import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axdl
  implements View.OnClickListener
{
  public axdl(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131380251);
    axeo.a -= 1;
    if (axeo.a < 1) {
      axeo.a = 1;
    }
    localTextView.setText(anvx.a(2131706465) + axeo.a);
    MultiAIOFragment.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdl
 * JD-Core Version:    0.7.0.1
 */