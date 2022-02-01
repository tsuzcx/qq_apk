import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfmx
  implements View.OnClickListener
{
  bfmx(bfmw parambfmw) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bfoo)paramView.getTag();
    String str;
    if (((bfoo)localObject).b == 1)
    {
      this.a.a.a.a(((bfoo)localObject).a, null);
      if (((bfoo)localObject).a == null) {}
      for (str = "";; str = ((bfoo)localObject).a)
      {
        bdll.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.a(((bfoo)localObject).d, ((bfoo)localObject).a);
    if (((bfoo)localObject).d == null)
    {
      str = "";
      label114:
      if (((bfoo)localObject).a != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((bfoo)localObject).a)
    {
      bdll.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((bfoo)localObject).d;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmx
 * JD-Core Version:    0.7.0.1
 */