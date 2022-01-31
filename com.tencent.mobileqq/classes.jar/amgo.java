import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment;

public class amgo
  extends ClickableSpan
{
  public amgo(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    PermisionPrivacyActivity.a(NewFriendVerifyBlockedListFragment.a(this.a));
    azqs.b(null, "dc00898", "", "", "0X800A3AA", "0X800A3AA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgo
 * JD-Core Version:    0.7.0.1
 */