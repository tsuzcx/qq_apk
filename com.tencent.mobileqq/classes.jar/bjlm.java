import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.widget.AdapterView;

public class bjlm
  implements bljm
{
  public bjlm(BindGroupFragment paramBindGroupFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((bjle)paramView.getTag()).a;
    if (paramAdapterView.isThirdAppBind())
    {
      BindGroupFragment.b(this.a, anzj.a(2131700038));
      return;
    }
    if (paramAdapterView.isNewTroop())
    {
      BindGroupFragment.a(this.a, anzj.a(2131700024), paramAdapterView.troopuin);
      return;
    }
    BindGroupFragment.a(this.a, anzj.a(2131700027));
    ((aoip)BindGroupFragment.a(this.a).a(20)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(paramAdapterView.troopuin).longValue(), BindGroupFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjlm
 * JD-Core Version:    0.7.0.1
 */