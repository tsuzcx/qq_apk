import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boug
  implements View.OnClickListener
{
  boug(bouf parambouf) {}
  
  public void onClick(View paramView)
  {
    bouf.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boug
 * JD-Core Version:    0.7.0.1
 */