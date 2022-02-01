import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amgu
  implements View.OnClickListener
{
  amgu(amgs paramamgs) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof amgx)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (amgx)localObject;
      if ((((amgx)localObject).a != null) && (this.a.a != null)) {
        this.a.a.a(((amgx)localObject).a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgu
 * JD-Core Version:    0.7.0.1
 */