import android.view.View;
import android.view.View.OnClickListener;

class axhi
  implements View.OnClickListener
{
  axhi(axhh paramaxhh) {}
  
  public void onClick(View paramView)
  {
    axin localaxin;
    if (azzz.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localaxin = (axin)paramView.getTag(-10);
      if (paramView.getId() != 2131298745) {
        break label40;
      }
      axhh.a(this.a, localaxin);
    }
    label40:
    while (axhh.a(this.a) == null) {
      return;
    }
    axhh.a(this.a).a(paramView.getId(), localaxin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhi
 * JD-Core Version:    0.7.0.1
 */