import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.associations.AssociatedTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdve
  implements View.OnClickListener
{
  bdve(bdvd parambdvd) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (AssociatedTroopItem)paramView.getTag();
    bdvm.a(bdvd.a(this.a), (AssociatedTroopItem)localObject);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AssociatedTroopItem)localObject).uin)
    {
      bcef.b(null, "dc00898", "", (String)localObject, "0X800B4B2", "0X800B4B2", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdve
 * JD-Core Version:    0.7.0.1
 */