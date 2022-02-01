import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcxj
  implements View.OnClickListener
{
  bcxj(bcxi parambcxi) {}
  
  public void onClick(View paramView)
  {
    bcyo localbcyo;
    if (bftf.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localbcyo = (bcyo)paramView.getTag(-10);
      if (paramView.getId() != 2131364658) {
        break label47;
      }
      bcxi.a(this.a, localbcyo);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (bcxi.a(this.a) != null) {
        bcxi.a(this.a).a(paramView.getId(), localbcyo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxj
 * JD-Core Version:    0.7.0.1
 */