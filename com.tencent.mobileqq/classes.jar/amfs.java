import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amfs
  implements View.OnClickListener
{
  amfs(amfr paramamfr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    amfr.a(this.a, (ajuk)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfs
 * JD-Core Version:    0.7.0.1
 */