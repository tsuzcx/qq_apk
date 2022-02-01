import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class benq
  implements View.OnClickListener
{
  benq(benp parambenp) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (beph)paramView.getTag();
    String str;
    if (((beph)localObject).b == 1)
    {
      this.a.a.a.a(((beph)localObject).a, null);
      if (((beph)localObject).a == null) {}
      for (str = "";; str = ((beph)localObject).a)
      {
        bcst.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.a(((beph)localObject).d, ((beph)localObject).a);
    if (((beph)localObject).d == null)
    {
      str = "";
      label114:
      if (((beph)localObject).a != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((beph)localObject).a)
    {
      bcst.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((beph)localObject).d;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benq
 * JD-Core Version:    0.7.0.1
 */