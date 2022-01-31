import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;

class bbit
  implements View.OnClickListener
{
  bbit(bbis parambbis) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bbkk)paramView.getTag();
    if (((bbkk)localObject).b == 1)
    {
      this.a.a.a.a(((bbkk)localObject).a, null);
      if (((bbkk)localObject).a == null) {}
      for (paramView = "";; paramView = ((bbkk)localObject).a)
      {
        azmj.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
        return;
      }
    }
    this.a.a.a.a(((bbkk)localObject).d, ((bbkk)localObject).a);
    if (((bbkk)localObject).d == null)
    {
      paramView = "";
      if (((bbkk)localObject).a != null) {
        break label148;
      }
    }
    label148:
    for (localObject = "";; localObject = ((bbkk)localObject).a)
    {
      azmj.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, (String)localObject, "", "");
      return;
      paramView = ((bbkk)localObject).d;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbit
 * JD-Core Version:    0.7.0.1
 */