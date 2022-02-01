import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anfn
  implements View.OnClickListener
{
  anfn(anfj paramanfj) {}
  
  public void onClick(View paramView)
  {
    if ((anfj.a(this.a).d()) || (anfj.b(this.a)))
    {
      anfj.b(this.a, false);
      anfj.a(this.a).a();
      anfj.c(this.a).setVisibility(8);
      anfj.b(this.a).setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (anfj.a(this.a).c())
      {
        anfj.b(this.a, true);
        anfj.a(this.a).b();
        anfj.b(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */