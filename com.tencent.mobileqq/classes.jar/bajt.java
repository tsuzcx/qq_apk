import android.view.View;
import android.view.View.OnClickListener;

class bajt
  implements View.OnClickListener
{
  bajt(bajs parambajs) {}
  
  public void onClick(View paramView)
  {
    baky localbaky;
    if (bdeu.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbaky = (baky)paramView.getTag(-10);
      if (paramView.getId() != 2131364371) {
        break label40;
      }
      bajs.a(this.a, localbaky);
    }
    label40:
    while (bajs.a(this.a) == null) {
      return;
    }
    bajs.a(this.a).a(paramView.getId(), localbaky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajt
 * JD-Core Version:    0.7.0.1
 */