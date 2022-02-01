import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.now.NowQQLiveFragment;

public class ayve
  implements bjey
{
  public ayve(NowQQLiveFragment paramNowQQLiveFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (4 == paramInt)
    {
      paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", ayvd.a);
      this.a.getActivity().startActivity(paramView);
    }
    do
    {
      return;
      if (5 == paramInt)
      {
        paramView = new Intent();
        Bundle localBundle = new Bundle();
        paramView.setComponent(new ComponentName(this.a.getActivity(), ChatActivity.class));
        localBundle.putString("uin", ayvd.a);
        localBundle.putInt("uintype", 1008);
        localBundle.putString("uinname", anzj.a(2131694061));
        paramView.putExtras(localBundle);
        paramView.setFlags(67108864);
        paramView.putExtra("isforceRequestDetail", false);
        paramView.putExtra("jump_from", 2);
        this.a.getActivity().startActivity(paramView);
        ayxc.a();
        ayxc.b();
        return;
      }
    } while (1 != paramInt);
    NowQQLiveFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayve
 * JD-Core Version:    0.7.0.1
 */