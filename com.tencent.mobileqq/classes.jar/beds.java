import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beds
  implements View.OnClickListener
{
  beds(bedr parambedr) {}
  
  public void onClick(View paramView)
  {
    beex localbeex;
    if (bhjx.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbeex = (beex)paramView.getTag(-10);
      if (paramView.getId() != 2131364627) {
        break label47;
      }
      bedr.a(this.a, localbeex);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (bedr.a(this.a) != null) {
        bedr.a(this.a).a(paramView.getId(), localbeex);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beds
 * JD-Core Version:    0.7.0.1
 */