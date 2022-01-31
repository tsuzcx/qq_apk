import android.view.View;
import android.view.View.OnClickListener;

class ayho
  implements View.OnClickListener
{
  ayho(ayhn paramayhn) {}
  
  public void onClick(View paramView)
  {
    ayit localayit;
    if (bbbr.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localayit = (ayit)paramView.getTag(-10);
      if (paramView.getId() != 2131364301) {
        break label40;
      }
      ayhn.a(this.a, localayit);
    }
    label40:
    while (ayhn.a(this.a) == null) {
      return;
    }
    ayhn.a(this.a).a(paramView.getId(), localayit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayho
 * JD-Core Version:    0.7.0.1
 */