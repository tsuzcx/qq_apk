import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amcg
  implements View.OnClickListener
{
  amcg(amce paramamce) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof amcj)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (amcj)localObject;
      if ((((amcj)localObject).a != null) && (this.a.a != null)) {
        this.a.a.a(((amcj)localObject).a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcg
 * JD-Core Version:    0.7.0.1
 */