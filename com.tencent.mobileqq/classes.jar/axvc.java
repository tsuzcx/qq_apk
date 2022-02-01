import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axvc
  implements View.OnClickListener
{
  axvc(axva paramaxva) {}
  
  public void onClick(View paramView)
  {
    axve localaxve = (axve)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localaxve.a, localaxve.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvc
 * JD-Core Version:    0.7.0.1
 */