import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.8.1;

public class blzb
  implements View.OnClickListener
{
  blzb(blys paramblys) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().aq();
    blys.b(this.a);
    new Handler().postDelayed(new AEGIFTextEditFragment.8.1(this), 200L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzb
 * JD-Core Version:    0.7.0.1
 */