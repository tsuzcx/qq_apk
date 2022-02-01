import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bckm
  implements View.OnClickListener
{
  bckm(bckg parambckg) {}
  
  public void onClick(View paramView)
  {
    bckg.a(this.a, bckg.a(this.a));
    bckg.b(this.a, System.currentTimeMillis());
    if (bckg.a(this.a) - bckg.b(this.a) < 300L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bckg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckm
 * JD-Core Version:    0.7.0.1
 */