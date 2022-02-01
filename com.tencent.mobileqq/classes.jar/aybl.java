import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aybl
  implements View.OnClickListener
{
  aybl(aybk paramaybk) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof aybm)) && (this.a.a != null))
    {
      aybm localaybm = (aybm)paramView.getTag();
      this.a.a.a(this.a, paramView, localaybm);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybl
 * JD-Core Version:    0.7.0.1
 */