import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbyv
  implements View.OnClickListener
{
  bbyv(bbyl parambbyl) {}
  
  public void onClick(View paramView)
  {
    if (bbyl.a(this.a) != null)
    {
      bbyl.a(this.a).findViewById(2131365372).setVisibility(8);
      bbyl.a(this.a).findViewById(2131365373).setVisibility(0);
      bbyl.a(this.a).a(bbyl.a(this.a).a(), false);
      bbyl.a(this.a).notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyv
 * JD-Core Version:    0.7.0.1
 */