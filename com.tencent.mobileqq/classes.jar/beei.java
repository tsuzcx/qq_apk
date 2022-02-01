import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beei
  implements View.OnClickListener
{
  beei(beeh parambeeh) {}
  
  public void onClick(View paramView)
  {
    befn localbefn;
    if (bhbx.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbefn = (befn)paramView.getTag(-10);
      if (paramView.getId() != 2131364742) {
        break label47;
      }
      beeh.a(this.a, localbefn);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (beeh.a(this.a) != null) {
        beeh.a(this.a).a(paramView.getId(), localbefn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beei
 * JD-Core Version:    0.7.0.1
 */