import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aybc
  implements View.OnClickListener
{
  aybc(aybb paramaybb) {}
  
  public void onClick(View paramView)
  {
    if (aybb.a(this.a) != null) {
      aybb.a(this.a).a(aybb.a(this.a));
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybc
 * JD-Core Version:    0.7.0.1
 */