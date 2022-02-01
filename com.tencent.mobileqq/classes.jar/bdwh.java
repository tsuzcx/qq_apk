import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdwh
  implements View.OnClickListener
{
  bdwh(bdwg parambdwg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bdxy)paramView.getTag();
    String str;
    if (((bdxy)localObject).b == 1)
    {
      this.a.a.a.a(((bdxy)localObject).a, null);
      if (((bdxy)localObject).a == null) {}
      for (str = "";; str = ((bdxy)localObject).a)
      {
        bcef.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.a(((bdxy)localObject).d, ((bdxy)localObject).a);
    if (((bdxy)localObject).d == null)
    {
      str = "";
      label114:
      if (((bdxy)localObject).a != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((bdxy)localObject).a)
    {
      bcef.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((bdxy)localObject).d;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwh
 * JD-Core Version:    0.7.0.1
 */