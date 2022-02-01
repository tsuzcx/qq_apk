import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boum
  implements View.OnClickListener
{
  boum(bouf parambouf) {}
  
  public void onClick(View paramView)
  {
    bouf.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boum
 * JD-Core Version:    0.7.0.1
 */