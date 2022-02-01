import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bong
  implements View.OnClickListener
{
  bong(bonf parambonf) {}
  
  public void onClick(View paramView)
  {
    bonf.a(this.a).a(655364, new Object[] { "热门玩法", "vt_pag_jiaopiangushi" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bong
 * JD-Core Version:    0.7.0.1
 */