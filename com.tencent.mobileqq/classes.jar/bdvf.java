import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.associations.AssociatedTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdvf
  implements View.OnClickListener
{
  bdvf(bdvd parambdvd) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (AssociatedTroopItem)paramView.getTag();
    bdvm.b(bdvd.a(this.a), (AssociatedTroopItem)localObject);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AssociatedTroopItem)localObject).uin)
    {
      bcef.b(null, "dc00898", "", (String)localObject, "0X800B4B1", "0X800B4B1", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvf
 * JD-Core Version:    0.7.0.1
 */