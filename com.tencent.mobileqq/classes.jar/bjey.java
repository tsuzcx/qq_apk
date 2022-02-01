import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjey
  implements View.OnClickListener
{
  public bjey(OpenSdkIMBlockFragment paramOpenSdkIMBlockFragment) {}
  
  public void onClick(View paramView)
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a.getActivity(), 230);
    localQQCustomDialog.setTitle(2131698592);
    localQQCustomDialog.setMessage(2131698590);
    localQQCustomDialog.setPositiveButton(2131698591, new bjez(this));
    localQQCustomDialog.show();
    bjhg.a(OpenSdkIMBlockFragment.a(this.a), "0X800B65A");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjey
 * JD-Core Version:    0.7.0.1
 */