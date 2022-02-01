import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boyn
  implements View.OnClickListener
{
  boyn(boyk paramboyk) {}
  
  public void onClick(View paramView)
  {
    boyk.a(this.a).setText(null);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyn
 * JD-Core Version:    0.7.0.1
 */