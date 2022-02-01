import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbfz
  implements View.OnClickListener
{
  bbfz(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    if (bbfs.a(this.a) != null) {
      bbfs.a(this.a, this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfz
 * JD-Core Version:    0.7.0.1
 */