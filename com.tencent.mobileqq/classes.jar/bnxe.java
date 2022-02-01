import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnxe
  implements View.OnClickListener
{
  bnxe(bnxa parambnxa) {}
  
  public void onClick(View paramView)
  {
    bnxa.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxe
 * JD-Core Version:    0.7.0.1
 */