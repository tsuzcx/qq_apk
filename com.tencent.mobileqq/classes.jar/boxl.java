import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class boxl
  implements View.OnClickListener
{
  public boxl(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onClick(View paramView)
  {
    borr.a(this.a.getActivity(), 1024, born.B.a(), null);
    AETemplateInfoFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxl
 * JD-Core Version:    0.7.0.1
 */