import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class andb
  implements View.OnClickListener
{
  andb(anda paramanda) {}
  
  public void onClick(View paramView)
  {
    anda.a(this.a, true);
    this.a.a();
    anda.a(this.a, -1, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andb
 * JD-Core Version:    0.7.0.1
 */