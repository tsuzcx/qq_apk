import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.widget.AdapterView;

public class bbvj
  implements behi
{
  public bbvj(BindGroupFragment paramBindGroupFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((bbvb)paramView.getTag()).a;
    if (paramAdapterView.isThirdAppBind())
    {
      BindGroupFragment.b(this.a, ajjy.a(2131635331));
      return;
    }
    if (paramAdapterView.isNewTroop())
    {
      BindGroupFragment.a(this.a, ajjy.a(2131635317), paramAdapterView.troopuin);
      return;
    }
    BindGroupFragment.a(this.a, ajjy.a(2131635320));
    ((ajtg)BindGroupFragment.a(this.a).a(20)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(paramAdapterView.troopuin).longValue(), BindGroupFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbvj
 * JD-Core Version:    0.7.0.1
 */