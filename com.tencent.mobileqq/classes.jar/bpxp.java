import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpxp
  implements View.OnClickListener
{
  bpxp(bpxo parambpxo) {}
  
  public void onClick(View paramView)
  {
    if (!bpxo.a(this.a).f) {
      bpxo.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bpxo.a(this.a).p)
      {
        biti.a().a(2131716811);
        bpxo.a(this.a).p = false;
        bpxo.a(this.a).setSelected(false);
        bpxo.a(this.a).m = false;
        bpxo.a(this.a).c(3008);
      }
      else
      {
        biti.a().a(2131716813);
        bpxo.a(this.a).p = true;
        bpxo.a(this.a).setSelected(true);
        bpxo.a(this.a).m = true;
        bpxo.a(this.a).c(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxp
 * JD-Core Version:    0.7.0.1
 */