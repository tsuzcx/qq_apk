import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bntm
  implements View.OnClickListener
{
  bntm(bntl parambntl) {}
  
  public void onClick(View paramView)
  {
    if (!bntl.a(this.a).e) {
      bntl.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bntl.a(this.a).o)
      {
        bhzt.a().a(2131717161);
        bntl.a(this.a).o = false;
        bntl.a(this.a).setSelected(false);
        bntl.a(this.a).l = false;
        bntl.a(this.a).c(3008);
      }
      else
      {
        bhzt.a().a(2131717163);
        bntl.a(this.a).o = true;
        bntl.a(this.a).setSelected(true);
        bntl.a(this.a).l = true;
        bntl.a(this.a).c(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntm
 * JD-Core Version:    0.7.0.1
 */