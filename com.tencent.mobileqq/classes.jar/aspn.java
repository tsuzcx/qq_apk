import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aspn
  implements View.OnClickListener
{
  public aspn(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null)
    {
      String str = "";
      if (this.a.getActivity().app != null) {
        str = ((aslo)this.a.getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
      }
      assp.a(this.a.getActivity(), str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspn
 * JD-Core Version:    0.7.0.1
 */