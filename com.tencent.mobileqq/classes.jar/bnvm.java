import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnvm
  implements View.OnClickListener
{
  bnvm(bnvl parambnvl) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (bnvl.a(this.a) != null)) {
      bnvl.a(this.a).a(paramView, this.a.a, bnvl.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvm
 * JD-Core Version:    0.7.0.1
 */