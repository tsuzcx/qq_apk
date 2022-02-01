import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axkd
  implements View.OnClickListener
{
  public axkd(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131380184);
    axlf.a += 1;
    localTextView.setText(anzj.a(2131705882) + axlf.a);
    MultiAIOFragment.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkd
 * JD-Core Version:    0.7.0.1
 */