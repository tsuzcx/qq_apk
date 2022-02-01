import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnew
  implements View.OnClickListener
{
  bnew(bnev parambnev) {}
  
  public void onClick(View paramView)
  {
    bnev.a(this.a).a(655364, new Object[] { "热门玩法", "vt_pag_jiaopiangushi" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnew
 * JD-Core Version:    0.7.0.1
 */