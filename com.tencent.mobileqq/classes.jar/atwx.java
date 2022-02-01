import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atwx
  implements View.OnClickListener
{
  atwx(atwq paramatwq) {}
  
  public void onClick(View paramView)
  {
    auea.a(this.a.a, this.a.d());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwx
 * JD-Core Version:    0.7.0.1
 */