import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class anri
  implements CompoundButton.OnCheckedChangeListener
{
  public anri(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ExtendFriendProfileEditFragment.a(this.a.getActivity().app, paramBoolean, new anrj(this, paramBoolean));
    if (paramBoolean) {}
    for (paramCompoundButton = "0X8009F0F";; paramCompoundButton = "0X8009F10")
    {
      awqx.b(this.a.getActivity().app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anri
 * JD-Core Version:    0.7.0.1
 */