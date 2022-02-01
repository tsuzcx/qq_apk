import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bntk
  implements View.OnClickListener
{
  bntk(bnta parambnta) {}
  
  public void onClick(View paramView)
  {
    bnta.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntk
 * JD-Core Version:    0.7.0.1
 */