import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blzc
  implements View.OnClickListener
{
  blzc(blys paramblys) {}
  
  public void onClick(View paramView)
  {
    blys.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzc
 * JD-Core Version:    0.7.0.1
 */