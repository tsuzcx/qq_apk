import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avxj
  implements View.OnClickListener
{
  public avxj(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131379914);
    avym.a -= 1;
    if (avym.a < 1) {
      avym.a = 1;
    }
    localTextView.setText(amtj.a(2131706113) + avym.a);
    MultiAIOFragment.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxj
 * JD-Core Version:    0.7.0.1
 */