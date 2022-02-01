import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.7.1;

public class bnok
  implements View.OnClickListener
{
  bnok(bnoc parambnoc) {}
  
  public void onClick(View paramView)
  {
    bnqm.a().ap();
    bnoc.b(this.a);
    new Handler().postDelayed(new AEGIFTextEditFragment.7.1(this), 200L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnok
 * JD-Core Version:    0.7.0.1
 */