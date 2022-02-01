import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class bjbx
  implements AdapterView.OnItemClickListener
{
  public bjbx(BindGroupFragment paramBindGroupFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((bjbp)paramView.getTag()).a;
    if (paramAdapterView.isThirdAppBind())
    {
      BindGroupFragment.b(this.a, anvx.a(2131700624));
      return;
    }
    if (paramAdapterView.isNewTroop())
    {
      BindGroupFragment.a(this.a, anvx.a(2131700610), paramAdapterView.troopuin);
      return;
    }
    BindGroupFragment.a(this.a, anvx.a(2131700613));
    ((aoep)BindGroupFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(paramAdapterView.troopuin).longValue(), BindGroupFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbx
 * JD-Core Version:    0.7.0.1
 */