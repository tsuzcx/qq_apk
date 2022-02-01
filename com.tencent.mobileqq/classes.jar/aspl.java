import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aspl
  implements CompoundButton.OnCheckedChangeListener
{
  public aspl(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ExtendFriendProfileEditFragment.a(this.a.getActivity().app, paramBoolean, new aspm(this, paramBoolean));
    if (paramBoolean) {}
    for (String str = "0X8009F0F";; str = "0X8009F10")
    {
      bdla.b(this.a.getActivity().app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspl
 * JD-Core Version:    0.7.0.1
 */