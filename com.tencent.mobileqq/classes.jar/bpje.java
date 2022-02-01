import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpje
  implements View.OnClickListener
{
  bpje(bpjd parambpjd) {}
  
  public void onClick(View paramView)
  {
    if (!bpjd.a(this.a).e) {
      bpjd.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bpjd.a(this.a).o)
      {
        bjkv.a().a(2131717524);
        bpjd.a(this.a).o = false;
        bpjd.a(this.a).setSelected(false);
        bpjd.a(this.a).l = false;
        bpjd.a(this.a).c(3008);
      }
      else
      {
        bjkv.a().a(2131717526);
        bpjd.a(this.a).o = true;
        bpjd.a(this.a).setSelected(true);
        bpjd.a(this.a).l = true;
        bpjd.a(this.a).c(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpje
 * JD-Core Version:    0.7.0.1
 */