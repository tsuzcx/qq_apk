import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;

class ayjs
  implements View.OnClickListener
{
  ayjs(ayjr paramayjr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aylj)paramView.getTag();
    if (((aylj)localObject).b == 1)
    {
      this.a.a.a.a(((aylj)localObject).a, null);
      if (((aylj)localObject).a == null) {}
      for (paramView = "";; paramView = ((aylj)localObject).a)
      {
        awqx.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
        return;
      }
    }
    this.a.a.a.a(((aylj)localObject).d, ((aylj)localObject).a);
    if (((aylj)localObject).d == null)
    {
      paramView = "";
      if (((aylj)localObject).a != null) {
        break label148;
      }
    }
    label148:
    for (localObject = "";; localObject = ((aylj)localObject).a)
    {
      awqx.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, (String)localObject, "", "");
      return;
      paramView = ((aylj)localObject).d;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjs
 * JD-Core Version:    0.7.0.1
 */