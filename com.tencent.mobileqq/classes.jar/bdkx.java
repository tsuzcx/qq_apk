import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdkx
  implements View.OnClickListener
{
  bdkx(bdkw parambdkw) {}
  
  public void onClick(View paramView)
  {
    bdmc localbdmc;
    if (bgjw.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbdmc = (bdmc)paramView.getTag(-10);
      if (paramView.getId() != 2131364582) {
        break label47;
      }
      bdkw.a(this.a, localbdmc);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (bdkw.a(this.a) != null) {
        bdkw.a(this.a).a(paramView.getId(), localbdmc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkx
 * JD-Core Version:    0.7.0.1
 */