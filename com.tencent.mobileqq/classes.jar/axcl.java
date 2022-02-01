import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axcl
  implements View.OnClickListener
{
  axcl(axcj paramaxcj) {}
  
  public void onClick(View paramView)
  {
    axcn localaxcn = (axcn)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localaxcn.a, localaxcn.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcl
 * JD-Core Version:    0.7.0.1
 */