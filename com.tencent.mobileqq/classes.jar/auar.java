import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;

public class auar
  implements View.OnClickListener
{
  public auar(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    azqs.b(this.a.a, "dc00898", "", "", "0X800A698", "0X800A698", 0, 0, "", "", "", "");
    paramView = new Intent();
    PublicFragmentActivity.a(this.a.getActivity(), paramView, MatchChatSettingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auar
 * JD-Core Version:    0.7.0.1
 */