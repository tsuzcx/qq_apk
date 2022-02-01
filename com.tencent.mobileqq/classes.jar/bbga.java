import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbga
  implements View.OnClickListener
{
  bbga(bbfs parambbfs) {}
  
  public void onClick(View paramView)
  {
    if (bbfs.a(this.a) != null)
    {
      bbfs.a(this.a).findViewById(2131365328).setVisibility(8);
      bbfs.a(this.a).findViewById(2131365329).setVisibility(0);
      bbfs.a(this.a).a(bbfs.a(this.a).a(), false);
      bbfs.a(this.a).notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbga
 * JD-Core Version:    0.7.0.1
 */