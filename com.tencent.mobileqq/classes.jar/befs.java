import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class befs
  implements View.OnClickListener
{
  befs(befl parambefl) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befs
 * JD-Core Version:    0.7.0.1
 */