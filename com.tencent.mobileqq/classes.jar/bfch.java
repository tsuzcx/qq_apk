import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.associations.AssociatedTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfch
  implements View.OnClickListener
{
  bfch(bfcg parambfcg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (AssociatedTroopItem)paramView.getTag();
    bfcp.a(bfcg.a(this.a), (AssociatedTroopItem)localObject);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AssociatedTroopItem)localObject).uin)
    {
      bdla.b(null, "dc00898", "", (String)localObject, "0X800B4B2", "0X800B4B2", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfch
 * JD-Core Version:    0.7.0.1
 */