import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqdk
  implements View.OnClickListener
{
  bqdk(bqdj parambqdj) {}
  
  public void onClick(View paramView)
  {
    bqdj localbqdj = this.a;
    if (!bqdj.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      bqdj.a(localbqdj, bool);
      bqdj.a(this.a, bqdj.a(this.a));
      wta.d(bqdj.a(this.a));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdk
 * JD-Core Version:    0.7.0.1
 */