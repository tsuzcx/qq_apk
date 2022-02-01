import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqll
  implements View.OnClickListener
{
  bqll(bqlj parambqlj) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setSelectAllOnFocus(false);
    this.a.a.setSelection(this.a.a.length());
    this.a.a.setOnClickListener(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqll
 * JD-Core Version:    0.7.0.1
 */