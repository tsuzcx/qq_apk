import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boww
  implements View.OnClickListener
{
  boww(bowv parambowv) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (bowv.a(this.a) != null)) {
      bowv.a(this.a).a(paramView, this.a.a, bowv.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boww
 * JD-Core Version:    0.7.0.1
 */