import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbyn
  implements View.OnClickListener
{
  bbyn(bbyl parambbyl) {}
  
  public void onClick(View paramView)
  {
    bbyl localbbyl = this.a;
    boolean bool;
    if (!bbyl.a(this.a))
    {
      bool = true;
      bbyl.a(localbbyl, bool);
      if (bbyl.a(this.a)) {
        break label70;
      }
      bbyl.b(this.a);
    }
    for (;;)
    {
      bbzo.a(this.a.a, bbyl.a(this.a));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label70:
      bbyl.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyn
 * JD-Core Version:    0.7.0.1
 */