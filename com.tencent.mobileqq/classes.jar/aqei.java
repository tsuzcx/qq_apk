import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class aqei
  implements CompoundButton.OnCheckedChangeListener
{
  public aqei(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ExtendFriendProfileEditFragment.a(this.a.getActivity().app, paramBoolean, new aqej(this, paramBoolean));
    if (paramBoolean) {}
    for (paramCompoundButton = "0X8009F0F";; paramCompoundButton = "0X8009F10")
    {
      azqs.b(this.a.getActivity().app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqei
 * JD-Core Version:    0.7.0.1
 */