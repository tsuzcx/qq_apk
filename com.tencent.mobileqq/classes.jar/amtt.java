import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtt
  implements View.OnClickListener
{
  amtt(amtp paramamtp) {}
  
  public void onClick(View paramView)
  {
    if ((amtp.a(this.a).d()) || (amtp.b(this.a)))
    {
      amtp.b(this.a, false);
      amtp.a(this.a).a();
      amtp.c(this.a).setVisibility(8);
      amtp.b(this.a).setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (amtp.a(this.a).c())
      {
        amtp.b(this.a, true);
        amtp.a(this.a).b();
        amtp.b(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtt
 * JD-Core Version:    0.7.0.1
 */