import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfdk
  implements View.OnClickListener
{
  bfdk(bfdj parambfdj) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bffb)paramView.getTag();
    String str;
    if (((bffb)localObject).b == 1)
    {
      this.a.a.a.a(((bffb)localObject).a, null);
      if (((bffb)localObject).a == null) {}
      for (str = "";; str = ((bffb)localObject).a)
      {
        bdla.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.a(((bffb)localObject).d, ((bffb)localObject).a);
    if (((bffb)localObject).d == null)
    {
      str = "";
      label114:
      if (((bffb)localObject).a != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((bffb)localObject).a)
    {
      bdla.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((bffb)localObject).d;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdk
 * JD-Core Version:    0.7.0.1
 */