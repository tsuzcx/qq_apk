import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpbp
  implements View.OnClickListener
{
  bpbp(bpbo parambpbo) {}
  
  public void onClick(View paramView)
  {
    bpbo localbpbo = this.a;
    if (!bpbo.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      bpbo.a(localbpbo, bool);
      bpbo.a(this.a, bpbo.a(this.a));
      wpf.d(bpbo.a(this.a));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbp
 * JD-Core Version:    0.7.0.1
 */