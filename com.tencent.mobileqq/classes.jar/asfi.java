import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;

public class asfi
  implements View.OnClickListener
{
  public asfi(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    axqy.b(this.a.a, "dc00898", "", "", "0X800A698", "0X800A698", 0, 0, "", "", "", "");
    paramView = new Intent();
    PublicFragmentActivity.a(this.a.getActivity(), paramView, MatchChatSettingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfi
 * JD-Core Version:    0.7.0.1
 */