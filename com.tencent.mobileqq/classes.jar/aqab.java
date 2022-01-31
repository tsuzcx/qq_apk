import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class aqab
  implements View.OnClickListener
{
  public aqab(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null)
    {
      paramView = "";
      if (this.a.getActivity().app != null) {
        paramView = ((apwx)this.a.getActivity().app.getManager(264)).f();
      }
      aqcq.b(this.a.getActivity(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqab
 * JD-Core Version:    0.7.0.1
 */