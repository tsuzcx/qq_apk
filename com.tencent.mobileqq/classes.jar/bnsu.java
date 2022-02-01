import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnsu
  implements View.OnClickListener
{
  bnsu(bnss parambnss) {}
  
  public void onClick(View paramView)
  {
    bnyh.a().ae();
    bnss.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsu
 * JD-Core Version:    0.7.0.1
 */