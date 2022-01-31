import android.view.View;
import android.view.View.OnClickListener;

class ayhm
  implements View.OnClickListener
{
  ayhm(ayhl paramayhl) {}
  
  public void onClick(View paramView)
  {
    ayir localayir;
    if (bbbd.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localayir = (ayir)paramView.getTag(-10);
      if (paramView.getId() != 2131364302) {
        break label40;
      }
      ayhl.a(this.a, localayir);
    }
    label40:
    while (ayhl.a(this.a) == null) {
      return;
    }
    ayhl.a(this.a).a(paramView.getId(), localayir);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhm
 * JD-Core Version:    0.7.0.1
 */