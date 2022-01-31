import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class aohz
  implements CompoundButton.OnCheckedChangeListener
{
  public aohz(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ExtendFriendProfileEditFragment.a(this.a.getActivity().app, paramBoolean, new aoia(this, paramBoolean));
    if (paramBoolean) {}
    for (paramCompoundButton = "0X8009F0F";; paramCompoundButton = "0X8009F10")
    {
      axqy.b(this.a.getActivity().app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohz
 * JD-Core Version:    0.7.0.1
 */