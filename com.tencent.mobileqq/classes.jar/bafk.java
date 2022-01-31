import android.view.View;
import android.view.View.OnClickListener;

class bafk
  implements View.OnClickListener
{
  bafk(bafj parambafj) {}
  
  public void onClick(View paramView)
  {
    bagp localbagp;
    if (bdal.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbagp = (bagp)paramView.getTag(-10);
      if (paramView.getId() != 2131364369) {
        break label40;
      }
      bafj.a(this.a, localbagp);
    }
    label40:
    while (bafj.a(this.a) == null) {
      return;
    }
    bafj.a(this.a).a(paramView.getId(), localbagp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafk
 * JD-Core Version:    0.7.0.1
 */