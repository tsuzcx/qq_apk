import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;

class azkk
  implements View.OnClickListener
{
  azkk(azkj paramazkj) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (azmb)paramView.getTag();
    if (((azmb)localObject).b == 1)
    {
      this.a.a.a.a(((azmb)localObject).a, null);
      if (((azmb)localObject).a == null) {}
      for (paramView = "";; paramView = ((azmb)localObject).a)
      {
        axqy.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
        return;
      }
    }
    this.a.a.a.a(((azmb)localObject).d, ((azmb)localObject).a);
    if (((azmb)localObject).d == null)
    {
      paramView = "";
      if (((azmb)localObject).a != null) {
        break label148;
      }
    }
    label148:
    for (localObject = "";; localObject = ((azmb)localObject).a)
    {
      axqy.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, (String)localObject, "", "");
      return;
      paramView = ((azmb)localObject).d;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkk
 * JD-Core Version:    0.7.0.1
 */