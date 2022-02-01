import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class bnwb
  implements View.OnClickListener
{
  public bnwb(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onClick(View paramView)
  {
    bnqf.a(this.a.getActivity(), 1024, bnqb.B.a(), null);
    AETemplateInfoFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwb
 * JD-Core Version:    0.7.0.1
 */