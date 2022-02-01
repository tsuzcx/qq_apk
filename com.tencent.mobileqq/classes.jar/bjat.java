import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjat
  implements View.OnClickListener
{
  public bjat(ProfileCardExtendFriendView.5 param5) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.authState == 1L) {
      QQToast.a(this.a.this$0.getContext(), 0, 2131697984, 1).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.a.authState == 0L) || (this.a.a.authState == 3L)) {
        atcb.a((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.a.this$0), this.a.a.idx, this.a.a.schoolName, this.a.a.schoolId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjat
 * JD-Core Version:    0.7.0.1
 */