import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awld
  implements View.OnClickListener
{
  public awld(LocationPickFragment paramLocationPickFragment) {}
  
  public void onClick(View paramView)
  {
    if (LocationPickFragment.a(this.a).b()) {
      LocationPickFragment.a(this.a).b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LocationPickFragment.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awld
 * JD-Core Version:    0.7.0.1
 */