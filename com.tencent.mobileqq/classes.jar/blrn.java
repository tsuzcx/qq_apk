import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blrn
  implements View.OnClickListener
{
  blrn(blrm paramblrm) {}
  
  public void onClick(View paramView)
  {
    blrm.a(this.a).a(655364, new Object[] { "热门玩法", "vt_pag_jiaopiangushi" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrn
 * JD-Core Version:    0.7.0.1
 */